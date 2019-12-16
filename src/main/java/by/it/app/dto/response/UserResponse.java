package by.it.app.dto.response;

import by.it.app.model.PreferredCategories;
import by.it.app.model.PreferredWebsites;

import java.util.Set;

public class UserResponse {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Boolean admin;

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

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
