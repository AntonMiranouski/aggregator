package by.it.app.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

/**
 * The type Website response.
 */
public class WebsiteResponse {

    private Long id;

    private String url;

    @JsonIgnore
    private Set<CategoryResponse> categories;

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
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
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
}
