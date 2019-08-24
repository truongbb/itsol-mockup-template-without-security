package vn.itsol.mockup.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.itsol.mockup.entity.StudentEntity;

import java.util.List;

/**
 * Student Repository Spring JPA
 *
 * @author truongbb
 * @version 1.0
 * @since 2019-08-19
 */

@Repository
public interface StudentRepositoryJPA extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findAll();

    List<StudentEntity> findByName(String name);
}
