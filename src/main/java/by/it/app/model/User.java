package by.it.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<PreferredCategories> preferredCategories;

    @OneToMany(mappedBy = "user")
    private Set<PreferredWebsites> preferredWebsites;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<PreferredCategories> getPreferredCategories() {
        return preferredCategories;
    }

    public void setPreferredCategories(Set<PreferredCategories> preferredCategories) {
        this.preferredCategories = preferredCategories;
    }

    public Set<PreferredWebsites> getPreferredWebsites() {
        return preferredWebsites;
    }

    public void setPreferredWebsites(Set<PreferredWebsites> preferredWebsites) {
        this.preferredWebsites = preferredWebsites;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
