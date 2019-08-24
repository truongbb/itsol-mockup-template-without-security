package vn.itsol.mockup.repository.student;


import org.springframework.stereotype.Repository;
import vn.itsol.mockup.dto.StudentDto;
import vn.itsol.mockup.web.domain.StudentVM;

import java.util.List;

/**
 * Student repository custom for student repository
 *
 * @author truongbb
 * @version 1.0
 * @since 2019-08-19
 */

@Repository
public interface StudentRepository {

    List<StudentDto> search(StudentVM studentVM);

    boolean addNewStudent(StudentVM studentVM);

    boolean deleteStudent(Long id);


}
