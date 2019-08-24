package vn.itsol.mockup.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Entity for STUDENT table
 *
 * @author truongbb
 * @version 1.0
 * @since 2019-08-19
 */

@Entity
@Table(name = "STUDENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "ADDRESS")
    @NotNull
    private String address;

    @Column(name = "CLASSES_ID")
    private Long classesId;
}
