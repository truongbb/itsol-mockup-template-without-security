package vn.itsol.mockup.repository.classes;

import org.springframework.stereotype.Repository;
import vn.itsol.mockup.dto.ClassesDto;
import vn.itsol.mockup.web.domain.ClassesVM;

import java.util.List;

/**
 * ...
 */


@Repository
public interface ClassesRepository {

    List<ClassesDto> search(ClassesVM classesVM);
}
