package by.it.app.dto.response;

import java.util.Set;

/**
 * The type User response.
 */
public class UserResponse {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Set<CategoryResponse> categories;

    private Set<WebsiteResponse> websites;

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
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets categories.
     *
     * @return the categories
     */
    public Set<CategoryResponse> getCategories() {
        return categories;
    }

    /**
     * Sets categories.
     *
     * @param categories the categories
     */
    public void setCategories(Set<CategoryResponse> categories) {
        this.categories = categories;
    }

    /**
     * Gets websites.
     *
     * @return the websites
     */
    public Set<WebsiteResponse> getWebsites() {
        return websites;
    }

    /**
     * Sets websites.
     *
     * @param websites the websites
     */
    public void setWebsites(Set<WebsiteResponse> websites) {
        this.websites = websites;
    }
}
