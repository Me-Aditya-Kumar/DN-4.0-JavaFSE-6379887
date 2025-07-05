package com.cognizant.ormlearn.model;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="stock")
public class Stock {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="st_id")
    private Integer id;
    @Column(name="st_code") private String stCode;
    @Column(name="st_date") private Date stDate;
    @Column(name="st_open") private Double stOpen;
    @Column(name="st_close") private Double stClose;
    @Column(name="st_volume") private Long stVolume;
    // getters, setters, toString()
}
