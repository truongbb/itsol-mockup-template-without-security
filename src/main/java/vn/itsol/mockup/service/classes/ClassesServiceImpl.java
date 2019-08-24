package vn.itsol.mockup.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.itsol.mockup.dto.ClassesDto;
import vn.itsol.mockup.repository.classes.ClassesRepository;
import vn.itsol.mockup.web.domain.ClassesVM;

import java.util.List;

/**
 *
 *
 */

@Service
public class ClassesServiceImpl implements ClassesService{

    @Autowired
    private ClassesRepository classesRepository;

    @Override
    public List<ClassesDto> search(ClassesVM classesVM) {
        return classesRepository.search(classesVM);
    }
}
