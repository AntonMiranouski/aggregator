package by.it.app.dto.request;

import by.it.app.model.Category;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class WebsiteRequest {

    private Long id;

    @NotNull
    @URL
    private String url;

    private Set<Category> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
