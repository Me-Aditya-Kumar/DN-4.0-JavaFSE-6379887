package com.cognizant.ormlearn.repository;
import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Date;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Integer> {
    List<Stock> findByStCodeAndStDateBetweenOrderByStDateAsc(String code, Date from, Date to);
    List<Stock> findByStCodeAndStCloseGreaterThan(String code, Double price);
    List<Stock> findTop3ByOrderByStVolumeDesc();
    List<Stock> findTop3ByStCodeOrderByStCloseAsc(String code);
}
