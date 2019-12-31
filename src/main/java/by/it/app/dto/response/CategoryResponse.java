package by.it.app.dto.response;

import by.it.app.model.Website;

import java.util.Set;

public class CategoryResponse {

    private Long id;

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
