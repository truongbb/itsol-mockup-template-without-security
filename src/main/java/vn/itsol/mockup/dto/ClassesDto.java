package vn.itsol.mockup.dto;

import lombok.*;

/**
 * Class data transfer object for CLASSES table
 *
 * @author truongbb
 * @version 1.0
 * @since 2019-08-22
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClassesDto extends BaseDto {

    private Long id;
    private String name;
}
