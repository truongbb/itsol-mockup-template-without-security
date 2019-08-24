package vn.itsol.mockup.repository.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.itsol.mockup.dto.StudentDto;
import vn.itsol.mockup.entity.StudentEntity;
import vn.itsol.mockup.repository.BaseRepository;
import vn.itsol.mockup.utils.DataUtil;
import vn.itsol.mockup.utils.SQLBuilder;
import vn.itsol.mockup.web.domain.StudentVM;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation for Student Repository custom
 *
 * @author truongbb
 * @version 1.0
 * @since 2019-08-19
 */

@Repository
public class StudentRepositoryImpl extends BaseRepository implements StudentRepository {

    private Logger logger = LoggerFactory.getLogger(StudentRepositoryImpl.class);

    @Override
    public List<StudentDto> search(StudentVM studentVM) {
        List<StudentDto> resultList = null;
        try {
            StringBuilder sqlBuilder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODULE_STUDENT, "get_list_student"));
            Map<String, Object> parameters = new HashMap<>();
            if (DataUtil.isNotNullAndEmptyString(studentVM.getName())) {
                sqlBuilder.append(" and s.name like :p_name ");
                parameters.put("p_name", DataUtil.removeWildcardCharacters(studentVM.getName()));
            }

            if (DataUtil.isNotNullAndEmptyString(studentVM.getAddress())) {
                sqlBuilder.append(" and s.address like :p_address ");
                parameters.put("p_address", DataUtil.removeWildcardCharacters(studentVM.getAddress()));
            }

            resultList = getNamedParameterJdbcTemplate().query(sqlBuilder.toString(), parameters, new BeanPropertyRowMapper<>(StudentDto.class));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return resultList;
    }

    @Override
    @Transactional
    public boolean addNewStudent(StudentVM studentVM) {
        try {
            EntityManager entityManager = getEntityManager();
            StudentEntity studentEntity = new StudentEntity();

            studentEntity.setName(studentVM.getName());
            studentEntity.setAddress(studentVM.getAddress());
            studentEntity.setClassesId(studentVM.getClassId());

            entityManager.persist(studentEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteStudent(Long id) {
        try {
            EntityManager entityManager = getEntityManager();
            StudentEntity studentEntity = entityManager.find(StudentEntity.class, id);
            entityManager.remove(studentEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }
}
