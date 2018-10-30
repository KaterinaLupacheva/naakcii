package naakcii.by.api.category.service.model;

import lombok.*;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDTO {

    private Long Id;
    private String picture;
    private String name;
    private Integer priority;
}
