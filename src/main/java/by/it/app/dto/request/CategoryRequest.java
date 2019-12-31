package by.it.app.dto.request;

import by.it.app.model.Website;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class CategoryRequest {

    private Long id;

    @NotNull
    @Size(min = 3, max = 50, message = "Imia katehoryi moža być ad 2 da 50 symbalaŭ")
    private String name;

    private Set<Website> websites;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Website> getWebsites() {
        return websites;
    }

    public void setWebsites(Set<Website> websites) {
        this.websites = websites;
    }
}
