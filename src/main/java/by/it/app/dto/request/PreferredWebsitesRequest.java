package by.it.app.dto.request;

import by.it.app.model.User;
import by.it.app.model.Website;

import javax.validation.constraints.NotEmpty;

public class PreferredWebsitesRequest {

    private Long id;

    private Integer range;

    @NotEmpty
    private User user;

    @NotEmpty
    private Website website;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }
}
