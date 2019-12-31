package by.it.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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
    @JoinTable(name = "WEBSITES_CATEGORIES",
            joinColumns = {@JoinColumn(name = "WEBSITE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID")})
    @JsonIgnore
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

    @Override
    public String toString() {
        return "Website{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
