package com.cognizant.ormlearn.model;
import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employee")
public class Employee {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="em_id")
    private int id;
    @Column(name="em_name") private String name;
    @Column(name="em_salary") private double salary;
    @Column(name="em_permanent") private boolean permanent;
    @Column(name="em_date_of_birth") private Date dateOfBirth;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="em_dp_id")
    private Department department;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="employee_skill",
             joinColumns=@JoinColumn(name="es_em_id"),
             inverseJoinColumns=@JoinColumn(name="es_sk_id"))
    private Set<Skill> skillList = new HashSet<>();

    // getters, setters, toString()
}
