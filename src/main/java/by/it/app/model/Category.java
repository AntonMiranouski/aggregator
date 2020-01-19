package by.it.app.model;

import javax.persistence.*;
import java.util.Set;

/**
 * The domain object Category.
 */
@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private Set<Website> websites;

    @PreRemove
    private void removeCategoriesFromWebsites() {
        for (Website w : websites) {
            w.getCategories().remove(this);
        }
    }

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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets websites.
     *
     * @return the websites
     */
    public Set<Website> getWebsites() {
        return websites;
    }

    /**
     * Sets websites.
     *
     * @param websites the websites
     */
    public void setWebsites(Set<Website> websites) {
        this.websites = websites;
    }
}
