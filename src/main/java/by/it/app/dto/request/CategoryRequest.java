package by.it.app.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * The type Category request.
 */
public class CategoryRequest {

    private Long id;

    @NotNull
    @Size(min = 3, max = 50, message = "Imia katehoryi moža być ad 3 da 50 symbalaŭ")
    private String name;

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
