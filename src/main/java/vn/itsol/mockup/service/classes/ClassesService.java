package vn.itsol.mockup.service.classes;

import org.springframework.stereotype.Service;
import vn.itsol.mockup.dto.ClassesDto;
import vn.itsol.mockup.web.domain.ClassesVM;

import java.util.List;

/**
 *
 */

@Service
public interface ClassesService {

    List<ClassesDto> search(ClassesVM classesVM);
}
