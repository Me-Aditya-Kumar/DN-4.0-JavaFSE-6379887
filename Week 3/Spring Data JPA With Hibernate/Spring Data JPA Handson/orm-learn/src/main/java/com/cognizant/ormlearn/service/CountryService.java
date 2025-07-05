package com.cognizant.ormlearn.service;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {
    @Autowired private CountryRepository repo;

    @Transactional public List<Country> findByNameContaining(String kw) {
        return repo.findByNameContaining(kw);
    }
    @Transactional public List<Country> findByNameContainingSorted(String kw) {
        return repo.findByNameContainingOrderByNameAsc(kw);
    }
    @Transactional public List<Country> findByNameStartingWith(String p) {
        return repo.findByNameStartingWith(p);
    }
}
