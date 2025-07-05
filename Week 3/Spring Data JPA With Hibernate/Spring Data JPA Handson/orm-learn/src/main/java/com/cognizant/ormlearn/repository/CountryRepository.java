package com.cognizant.ormlearn.repository;
import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country,String> {
    List<Country> findByNameContaining(String kw);
    List<Country> findByNameContainingOrderByNameAsc(String kw);
    List<Country> findByNameStartingWith(String prefix);
}
