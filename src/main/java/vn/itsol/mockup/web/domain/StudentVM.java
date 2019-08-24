package vn.itsol.mockup.web.domain;

import lombok.*;

/**
 * View-model for student object
 *
 * @author truongbb
 * @version 1.0
 * @since 2019-08-19
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentVM {

    private Long id;
    private String name;
    private String address;
    private Long classId;
}
