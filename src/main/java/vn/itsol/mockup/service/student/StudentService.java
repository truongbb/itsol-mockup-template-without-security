package vn.itsol.mockup.service.student;

import org.springframework.stereotype.Service;
import vn.itsol.mockup.dto.StudentDto;
import vn.itsol.mockup.web.domain.StudentVM;

import java.util.List;

/**
 * Student service for student business
 *
 * @author truongbb
 * @version 1.0
 * @since 2019-08-19
 */

@Service
public interface StudentService {

    List<StudentDto> search(StudentVM studentVm);

    boolean addNewStudent(StudentVM StudentVM);

    boolean deleteStudent(StudentVM StudentVM);

}
