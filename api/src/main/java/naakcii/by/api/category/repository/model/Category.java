package naakcii.by.api.category.repository.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import naakcii.by.api.subcategory.repository.model.Subcategory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
@Setter
@Getter
@NoArgsConstructor
@ToString(exclude = {"icon", "subcategories"})

@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long id;

    @Column(name = "CATEGORY_NAME", length = 200)
    @NotNull
    @Size(min = 3, max = 45)
    @org.hibernate.annotations.NaturalId(mutable = true)
    private String name;

    @Column(name = "CATEGORY_PRIORITY")
    @NotNull
    private int priority;

    @Column(name = "CATEGORY_IS_ACTIVE")
    @NotNull
    private boolean isActive;

    @Column(name = "CATEGORY_ICON")
    @Size(max = 255)
    private String icon;

    @OneToMany(
            mappedBy = "category",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Subcategory> subcategories = new ArrayList<>();
}
