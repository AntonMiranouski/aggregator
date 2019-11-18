package by.it.app.model;

import javax.persistence.*;

@Entity
@Table(name = "PREFERRED_CATEGORIES", schema = "PUBLIC")
public class PreferredCategories {

    @Id
    @Column(name="ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RANGE")
    private Integer range;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PreferredCategories{" +
                "id=" + id +
                ", range=" + range +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
