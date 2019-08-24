package vn.itsol.mockup.repository.classes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import vn.itsol.mockup.dto.ClassesDto;
import vn.itsol.mockup.dto.StudentDto;
import vn.itsol.mockup.repository.BaseRepository;
import vn.itsol.mockup.utils.DataUtil;
import vn.itsol.mockup.utils.SQLBuilder;
import vn.itsol.mockup.web.domain.ClassesVM;
import vn.itsol.mockup.web.domain.StudentVM;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */

@Repository
public class ClassesRepositoryImpl extends BaseRepository implements ClassesRepository {

    private Logger logger = LoggerFactory.getLogger(ClassesRepositoryImpl.class);

    @Override
    public List<ClassesDto> search(ClassesVM classesVM) {
        List<ClassesDto> dtos = null;
        try {
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODULE_CLASSES, "get_list_classes"));


            Map<String, Object> parameters = new HashMap<>();

            if (DataUtil.isNotNullAndEmptyString(classesVM.getName())) {
                builder.append(" and c.name like :p_name ");
                parameters.put("p_name", DataUtil.removeWildcardCharacters(classesVM.getName()));
            }

            dtos = getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(ClassesDto.class));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return dtos;
    }
}
