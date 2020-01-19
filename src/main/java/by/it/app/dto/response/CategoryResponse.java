package by.it.app.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

/**
 * The type Category response.
 */
public class CategoryResponse {

    private Long id;

    private String name;

    @JsonIgnore
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
