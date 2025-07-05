package com.cognizant.ormlearn.service;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DepartmentService {
    @Autowired private DepartmentRepository repo;

    @Transactional public Department get(int id) {
        return repo.findById(id).orElse(null);
    }
}
