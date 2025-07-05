package com.cognizant.ormlearn.model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="skill")
public class Skill {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="sk_id")
    private int id;
    @Column(name="sk_name") private String name;
    @ManyToMany(mappedBy="skillList", fetch=FetchType.EAGER)
    private Set<Employee> employeeList;
    // getters, setters, toString()
}
