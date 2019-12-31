package by.it.app.dto.request;

import by.it.app.model.Category;
import by.it.app.model.User;

import javax.validation.constraints.NotEmpty;

public class PreferredCategoriesRequest {

    private Long id;

    private Integer range;

    @NotEmpty
    private User user;

    @NotEmpty
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
