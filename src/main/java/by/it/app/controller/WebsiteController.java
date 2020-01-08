package by.it.app.controller;

import by.it.app.dto.request.WebsiteRequest;
import by.it.app.dto.response.WebsiteResponse;
import by.it.app.exception.NonUniqueException;
import by.it.app.exception.NotFoundException;
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

    @GetMapping("/sld/{sld}")
    public ResponseEntity<WebsiteResponse> getBySecondLevelDomain(@PathVariable String sld) {
        final Website website;
        try {
            website = websiteService.findBySecondLevelDomain(sld);
        } catch (RuntimeException e) {
            throw new NonUniqueException();
        }
        if (website == null) {
            throw new NotFoundException();
        }
        final WebsiteResponse websiteResponse = mapper.map(website, WebsiteResponse.class);
        return new ResponseEntity<>(websiteResponse, HttpStatus.OK);
    }

    @GetMapping("/by_category/{categoryId}")
    public ResponseEntity<List<WebsiteResponse>> getByCategoryId(@PathVariable Long categoryId) {
        final List<Website> websiteList = websiteService.findByCategoryId(categoryId);
        if (websiteList.isEmpty()) {
            throw new NotFoundException();
        }
        final List<WebsiteResponse> websiteResponseList = websiteList.stream()
                .map(website -> mapper.map(website, WebsiteResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(websiteResponseList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WebsiteResponse> save(@Valid @RequestBody WebsiteRequest websiteRequest) {
        websiteRequest.setId(null);
        Website website;
        try {
            website = getWebsite(websiteRequest);
        } catch (RuntimeException e) {
            throw new NonUniqueException();
        }
        final WebsiteResponse websiteResponse = mapper.map(website, WebsiteResponse.class);
        return new ResponseEntity<>(websiteResponse, HttpStatus.OK);
    }

    private Website getWebsite(WebsiteRequest websiteRequest) {
        final Website website = mapper.map(websiteRequest, Website.class);
        websiteService.save(website);
        return website;
    }

    @PutMapping("/{id}")
    public ResponseEntity<WebsiteResponse> update(
            @Valid @RequestBody WebsiteRequest websiteRequest,
            @PathVariable Long id) {
        if (!Objects.equals(id, websiteRequest.getId())) {
            throw new NotFoundException();
        }
        Website website = getWebsite(websiteRequest);
        final WebsiteResponse websiteResponse = mapper.map(website, WebsiteResponse.class);
        return new ResponseEntity<>(websiteResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        websiteService.deleteById(id);
    }
}
