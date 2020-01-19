package by.it.app.controller;

import by.it.app.dto.request.WebsiteRequest;
import by.it.app.dto.response.WebsiteResponse;
import by.it.app.model.Website;
import by.it.app.service.WebsiteService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/websites")
public class WebsiteController {

    private final WebsiteService websiteService;
    private final Mapper mapper;

    public WebsiteController(WebsiteService websiteService, Mapper mapper) {
        this.websiteService = websiteService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<WebsiteResponse>> getAll() {
        final List<Website> websiteList = websiteService.findAll();
        final List<WebsiteResponse> websiteResponseList = websiteList.stream()
                .map(website -> mapper.map(website, WebsiteResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(websiteResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebsiteResponse> getById(@PathVariable Long id) {
        final Website website = websiteService.findById(id);
        final WebsiteResponse websiteResponse = mapper.map(website, WebsiteResponse.class);
        return new ResponseEntity<>(websiteResponse, HttpStatus.OK);
    }

    /**
     * Gets by second level domain with a check on the existence and accuracy of the request.
     */
    @GetMapping("/sld/{sld}")
    public ResponseEntity<WebsiteResponse> getBySecondLevelDomain(@PathVariable String sld) {
        final Website website = websiteService.findBySecondLevelDomain(sld);
        final WebsiteResponse websiteResponse = mapper.map(website, WebsiteResponse.class);
        return new ResponseEntity<>(websiteResponse, HttpStatus.OK);
    }

    /**
     * Get by category id with checking for the existence of a category.
     */
    @GetMapping("/by_category/{categoryId}")
    public ResponseEntity<List<WebsiteResponse>> getByCategoryId(@PathVariable Long categoryId) {
        final List<Website> websiteList = websiteService.findByCategoryId(categoryId);
        final List<WebsiteResponse> websiteResponseList = websiteList.stream()
                .map(website -> mapper.map(website, WebsiteResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(websiteResponseList, HttpStatus.OK);
    }

    /**
     * Save with protection from overwriting and checking for the uniqueness of the url.
     */
    @PostMapping
    public ResponseEntity<WebsiteResponse> save(@Valid @RequestBody WebsiteRequest websiteRequest) {
        final Website website = mapper.map(websiteRequest, Website.class);
        websiteService.save(website);
        final WebsiteResponse websiteResponse = mapper.map(website, WebsiteResponse.class);
        return new ResponseEntity<>(websiteResponse, HttpStatus.OK);
    }

    /**
     * Update with checking for the existence.
     */
    @PutMapping("/{id}")
    public ResponseEntity<WebsiteResponse> update(
            @Valid @RequestBody WebsiteRequest websiteRequest,
            @PathVariable Long id) {
        if (!Objects.equals(id, websiteRequest.getId())) {
            throw new RuntimeException("Nia znojdzieny sajt z takim id");
        }
        final Website website = mapper.map(websiteRequest, Website.class);
        websiteService.update(website);
        final WebsiteResponse websiteResponse = mapper.map(website, WebsiteResponse.class);
        return new ResponseEntity<>(websiteResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        websiteService.deleteById(id);
    }
}
