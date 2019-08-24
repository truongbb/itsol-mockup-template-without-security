package vn.itsol.mockup.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.itsol.mockup.dto.StudentDto;
import vn.itsol.mockup.service.student.StudentService;
import vn.itsol.mockup.web.domain.StudentVM;

import java.util.List;

/**
 * Student Resource for StudentAPI
 *
 * @author truongbb
 * @version 1.0
 * @since 2019-08-19
 */

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentResource {

    private Logger logger = LoggerFactory.getLogger(StudentResource.class);

    @Autowired
    private StudentService studentService;

    @PostMapping("/search")
    public ResponseEntity<List<StudentDto>> search(@RequestBody StudentVM studentVM) {
        List<StudentDto> students = studentService.search(studentVM);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDto> addNewStudent(@RequestBody StudentVM studentVM) {
        boolean result = studentService.addNewStudent(studentVM);
        StudentDto dto = new StudentDto();
        dto.setResultStatus(result ? "OK" : "NOK");
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<StudentDto> deleteStudent(@RequestBody StudentVM studentVM) {
        boolean result = studentService.deleteStudent(studentVM);
        StudentDto dto = new StudentDto();
        dto.setResultStatus(result ? "OK" : "NOK");
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
