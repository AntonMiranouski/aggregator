package by.it.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Website> websites;

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
}
