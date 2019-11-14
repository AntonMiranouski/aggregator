package by.it.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "WEBSITES", schema = "PUBLIC")
public class Website {

    @Id
    @Column(name="ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "URL", nullable = false, unique = true)
    private String url;

    @Column(name = "STATE")
    private boolean state;

    @ManyToMany
    @JoinTable(name = "WEBSITE_CATEGORIES",
        joinColumns = {@JoinColumn(name = "WEBSITE_ID")},
        inverseJoinColumns = {@JoinColumn(name = "CATEGORIES_ID")})
    private Set<Category> categories;

    @OneToMany(mappedBy = "website")
    private Set<PreferredWebsites> preferredWebsites;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", state=" + state +
                '}';
    }
}