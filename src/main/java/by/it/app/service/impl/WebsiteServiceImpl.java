package by.it.app.service.impl;

import by.it.app.exception.NotFoundException;
import by.it.app.model.Website;
import by.it.app.repository.WebsiteRepo;
import by.it.app.service.WebsiteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WebsiteServiceImpl implements WebsiteService {

    private final WebsiteRepo websiteRepo;

    public WebsiteServiceImpl(WebsiteRepo websiteRepo) {
        this.websiteRepo = websiteRepo;
    }

    @Override
    public List<Website> findAll() {
        return websiteRepo.findAll();
    }

    @Override
    public Website findById(Long id) {
        return websiteRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Website save(Website website) {
        return websiteRepo.save(website);
    }

    @Override
    public void deleteById(Long id) {
        websiteRepo.deleteById(id);
    }
}
