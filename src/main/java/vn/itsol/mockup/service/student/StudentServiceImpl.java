package vn.itsol.mockup.service.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.itsol.mockup.dto.StudentDto;
import vn.itsol.mockup.repository.student.StudentRepository;
import vn.itsol.mockup.repository.student.StudentRepositoryJPA;
import vn.itsol.mockup.web.domain.StudentVM;

import java.util.List;

/**
 * Student service class implement Student Service interface
 *
 * @author truongbb
 * @version 1.0
 * @since 2019-08-19
 */
@Service
public class StudentServiceImpl implements StudentService {

    private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentRepositoryJPA studentRepositoryJPA;

    @Override
    public List<StudentDto> search(StudentVM studentVm) {
        logger.info("CALL STUDENT SERVICE");
        return studentRepository.search(studentVm);
    }

    @Override
    public boolean addNewStudent(StudentVM studentVM) {
        return studentRepository.addNewStudent(studentVM);
    }

    @Override
    public boolean deleteStudent(StudentVM studentVM) {
        return studentRepository.deleteStudent(studentVM.getId());
    }
}
