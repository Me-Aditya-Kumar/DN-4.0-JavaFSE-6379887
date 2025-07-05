package com.cognizant.ormlearn.service;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {
    @Autowired private EmployeeRepository repo;

    @Transactional public Employee get(int id) {
        return repo.findById(id).orElse(null);
    }

    @Transactional public void save(Employee e) {
        repo.save(e);
    }
}
