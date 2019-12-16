package by.it.app.dto.request;

import by.it.app.model.PreferredCategories;
import by.it.app.model.PreferredWebsites;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class UserRequest {

    private Long id;

    @NotNull
    @Size(min = 2, max = 50, message = "Imia moža być ad 2 da 50 symbalaŭ")
    private String username;

    @NotNull
    @Size(min = 6, message = "Parol pavinny składacca nia mieńš jak z 6 symbalaŭ")
    private String password;

    @Email(message = "Niasapraŭdny email adras")
    private String email;

    private Set<PreferredCategories> preferredCategories;

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
