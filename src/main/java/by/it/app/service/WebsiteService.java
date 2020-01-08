package by.it.app.service;

import by.it.app.model.Website;

import java.util.List;

public interface WebsiteService {

    List<Website> findAll();

    Website findById(Long id);

    Website findBySecondLevelDomain(String sld);

    Website save(Website website);

    void deleteById(Long id);

    List<Website> findByCategoryId(Long categoryId);
}
