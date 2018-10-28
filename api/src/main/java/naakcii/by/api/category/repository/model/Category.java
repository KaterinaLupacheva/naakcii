package naakcii.by.api.category.repository.model;

import naakcii.by.api.subcategory.repository.model.Subcategory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "select cat from Category cat"),
        @NamedQuery(name = "Category.findAllWithDetails",
                query = "select distinct cat from Category cat left join fetch cat.subcategories sub"),
        @NamedQuery(name = "Category.findAllByIsActiveTrue",
                query = "select cat from Category cat where cat.isActive = true"),
        @NamedQuery(name = "Category.findAllByIsActiveTrueWithDetails",
                query = "select distinct cat from Category cat left join fetch cat.subcategories sub where cat.isActive = true"),
        @NamedQuery(name = "Category.softDelete",
                query = "update Category cat set cat.isActive = false where cat.id = :categoryId")
})
//@Where(clause = "F_CATEGORY_IS_ACTIVE = 1")
//@Cacheable
//@org.hibernate.annotations.Cache(
//        usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE,
//        region = "naakcii.by.repository.modelDTO.cache.Category"
//)
//@org.hibernate.annotations.NaturalIdCache
public class Category implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -782539646608262755L;

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
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

//    @org.hibernate.annotations.Cache(
//            usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE
//    )

    private List<Subcategory> subcategories = new ArrayList<Subcategory>();

    public Category() {

    }

    public Category(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
