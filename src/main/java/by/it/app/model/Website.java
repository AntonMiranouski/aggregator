package by.it.app.model;

import javax.persistence.*;
import java.util.Set;

/**
 * The domain object Website.
 */
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
    private Set<Category> categories;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets categories.
     *
     * @return the categories
     */
    public Set<Category> getCategories() {
        return categories;
    }

    /**
     * Sets categories.
     *
     * @param categories the categories
     */
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
