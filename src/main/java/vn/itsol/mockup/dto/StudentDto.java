package vn.itsol.mockup.dto;

import lombok.*;

/**
 * Student Data transfer object for student
 *
 * @author truongbb
 * @version 1.0
 * @since 2019-08-19
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto extends BaseDto{

    private Long id;
    private String name;
    private String address;
    private Long classesId;

}
