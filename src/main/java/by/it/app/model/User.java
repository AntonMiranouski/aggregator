package by.it.app.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    @Size(min = 2, max = 50, message = "Imia moža być ad 2 da 50 symbalaŭ")
    private String username;

    @Size(min = 6, message = "Parol pavinny składacca nia mieńš jak z 6 symbalaŭ")
    private String password;

    @Column(name = "EMAIL", unique = true)
    @Email(message = "Niasapraŭdny email adras")
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<PreferredCategories> preferredCategories;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
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
}
