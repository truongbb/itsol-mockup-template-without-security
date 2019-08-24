package vn.itsol.mockup.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.itsol.mockup.dto.ClassesDto;
import vn.itsol.mockup.service.classes.ClassesService;
import vn.itsol.mockup.web.domain.ClassesVM;

import java.util.List;

@RestController
@RequestMapping("/classes")
@CrossOrigin("*")
public class ClassesResource {

    @Autowired
    private ClassesService classesService;

    @PostMapping("/search")
    public ResponseEntity<List<ClassesDto>> search(@RequestBody ClassesVM classesVM){
        List<ClassesDto> result = classesService.search(classesVM);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
