package by.it.app.controller;

import by.it.app.dto.request.CategoryRequest;
import by.it.app.dto.response.CategoryResponse;
import by.it.app.model.Category;
import by.it.app.service.CategoryService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final Mapper mapper;

    public CategoryController(CategoryService categoryService, Mapper mapper) {
        this.categoryService = categoryService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll() {
        final List<Category> categoryList = categoryService.findAll();
        final List<CategoryResponse> categoryResponseList = categoryList.stream()
                .map(category -> mapper.map(category, CategoryResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(categoryResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id) {
        final Category category = categoryService.findById(id);
        final CategoryResponse categoryResponse = mapper.map(category, CategoryResponse.class);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    /**
     * Get by name with checking for the existence and accuracy of the request.
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<CategoryResponse> getByName(@PathVariable String name) {
        final Category category = categoryService.findByName(name);
        final CategoryResponse categoryResponse = mapper.map(category, CategoryResponse.class);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    /**
     * Get by website id with checking for the existence of a website.
     */
    @GetMapping("/by_website/{websiteId}")
    public ResponseEntity<List<CategoryResponse>> getByWebsiteId(@PathVariable Long websiteId) {
        final List<Category> categoryList = categoryService.findByWebsiteId(websiteId);
        final List<CategoryResponse> categoryResponseList = categoryList.stream()
                .map(category -> mapper.map(category, CategoryResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(categoryResponseList, HttpStatus.OK);
    }

    /**
     * Save with protection from overwriting and checking for the uniqueness of the name.
     */
    @PostMapping
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CategoryRequest categoryRequest) {
        final Category category = mapper.map(categoryRequest, Category.class);
        categoryService.save(category);
        final CategoryResponse categoryResponse = mapper.map(category, CategoryResponse.class);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    /**
     * Update with checking for the existence.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(
            @Valid @RequestBody CategoryRequest categoryRequest,
            @PathVariable Long id) {
        if (!Objects.equals(id, categoryRequest.getId())) {
            throw new RuntimeException("Nia znojdziena katehoryja z takim id");
        }
        final Category category = mapper.map(categoryRequest, Category.class);
        categoryService.update(category);
        final CategoryResponse categoryResponse = mapper.map(category, CategoryResponse.class);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
