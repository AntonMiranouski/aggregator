package by.it.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES", schema = "PUBLIC")
public class Category {

    @Id
    @Column(name="ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Website> websites;

    @OneToMany(mappedBy = "category")
    private Set<PreferredCategories> preferredCategories;

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

    public Set<Website> getWebsites() {
        return websites;
    }

    public void setWebsites(Set<Website> websites) {
        this.websites = websites;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
