package by.it.app.service.impl;

import by.it.app.model.Website;
import by.it.app.repository.WebsiteRepo;
import by.it.app.service.WebsiteService;
import by.it.app.util.Validation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Website service.
 */
@Service
@Transactional
public class WebsiteServiceImpl implements WebsiteService {

    private final WebsiteRepo websiteRepo;

    private static final String ERROR_MESSAGE = "Nia znojdzieny sajt z takim ";

    /**
     * Instantiates a new Website service.
     *
     * @param websiteRepo the website repository
     */
    public WebsiteServiceImpl(WebsiteRepo websiteRepo) {
        this.websiteRepo = websiteRepo;
    }

    @Override
    public List<Website> findAll() {
        return websiteRepo.findAll();
    }

    @Override
    public Website findById(Long id) {
        return websiteRepo.findById(id).orElseThrow(() -> new RuntimeException(ERROR_MESSAGE + "id"));
    }

    @Override
    public Website findBySecondLevelDomain(String sld) {
        Website website = websiteRepo.findByUrlStartingWith(sld);
        Validation.validate(website == null, ERROR_MESSAGE + "damenam");
        return website;
    }

    @Override
    public List<Website> findByCategoryId(Long categoryId) {
        List<Website> websites = websiteRepo.findByCategoryId(categoryId);
        Validation.validate(websites.isEmpty(), ERROR_MESSAGE + "id katehoryi");
        return websites;
    }

    @Override
    public Website save(Website website) {
        website.setId(null);
        Validation.validate(websiteRepo.existsByUrl(website.getUrl()), "Sajt z takim url užo isnuje");
        return websiteRepo.saveAndFlush(website);
    }

    @Override
    public Website update(Website website) {
        return websiteRepo.saveAndFlush(website);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        websiteRepo.deleteById(id);
    }

}
