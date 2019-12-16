package by.it.app.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "WEBSITES")
public class Website {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "URL", nullable = false, unique = true)
    private String url;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "WEBSITE_CATEGORIES",
            joinColumns = {@JoinColumn(name = "WEBSITE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CATEGORIES_ID")})
    private Set<Category> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
