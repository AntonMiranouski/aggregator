package by.it.app.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * The type User request.
 */
public class UserRequest {

    private Long id;

    @NotNull
    @Size(min = 3, max = 50, message = "Imia moža być ad 3 da 50 symbalaŭ")
    private String username;

    @NotNull
    @Size(min = 6, message = "Parol pavinny składacca nia mieńš jak z 6 symbalaŭ")
    private String password;

    @NotNull
    @Email(message = "Niasapraŭdny email adras")
    private String email;

    private Set<CategoryRequest> categories;

    private Set<WebsiteRequest> websites;

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
    public Set<CategoryRequest> getCategories() {
        return categories;
    }

    /**
     * Sets categories.
     *
     * @param categories the categories
     */
    public void setCategories(Set<CategoryRequest> categories) {
        this.categories = categories;
    }

    /**
     * Gets websites.
     *
     * @return the websites
     */
    public Set<WebsiteRequest> getWebsites() {
        return websites;
    }

    /**
     * Sets websites.
     *
     * @param websites the websites
     */
    public void setWebsites(Set<WebsiteRequest> websites) {
        this.websites = websites;
    }
}
