package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.service.*;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.*;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;
    private static StockRepository stockRepository;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = ctx.getBean(CountryService.class);
        stockRepository = ctx.getBean(StockRepository.class);
        employeeService = ctx.getBean(EmployeeService.class);
        departmentService = ctx.getBean(DepartmentService.class);
        skillService = ctx.getBean(SkillService.class);

        // Hands-on 2: Country table query methods
        testFindByNameContaining();
        testFindByNameContainingSorted();
        testFindByNameStartingWith();

        // Hands-on 2 (stock): Query Methods on Stock table
        testStockQueries();

        // Hands-on 4–6: ORM relationships
        testGetEmployeeWithDept();
        testAddEmployeeWithDept();
        testUpdateEmployeeDept();
        testGetDepartmentWithEmployees();
        testGetEmployeeWithSkills();
        testAddSkillToEmployee();
    }

    private static void testFindByNameContaining() {
        LOGGER.info("Start testFindByNameContaining");
        countryService.findByNameContaining("ou")
            .forEach(c -> LOGGER.debug("{}", c));
    }

    private static void testFindByNameContainingSorted() {
        LOGGER.info("Start testFindByNameContainingSorted");
        countryService.findByNameContainingSorted("ou")
            .forEach(c -> LOGGER.debug("{}", c));
    }

    private static void testFindByNameStartingWith() {
        LOGGER.info("Start testFindByNameStartingWith");
        countryService.findByNameStartingWith("Z")
            .forEach(c -> LOGGER.debug("{}", c));
    }

    private static void testStockQueries() {
        LOGGER.info("Start testStockQueries");

        LOGGER.info("FB Sep 2019");
        stockRepository.findByStCodeAndStDateBetweenOrderByStDateAsc("FB",
                Date.valueOf("2019-09-01"), Date.valueOf("2019-09-30"))
            .forEach(s -> LOGGER.debug("{}", s));

        LOGGER.info("GOOGL > 1250");
        stockRepository.findByStCodeAndStCloseGreaterThan("GOOGL", 1250.0)
            .forEach(s -> LOGGER.debug("{}", s));

        LOGGER.info("Top 3 by volume");
        stockRepository.findTop3ByOrderByStVolumeDesc()
            .forEach(s -> LOGGER.debug("{}", s));

        LOGGER.info("Lowest 3 NFLX");
        stockRepository.findTop3ByStCodeOrderByStCloseAsc("NFLX")
            .forEach(s -> LOGGER.debug("{}", s));
    }

    private static void testGetEmployeeWithDept() {
        LOGGER.info("Start testGetEmployeeWithDept");
        Employee emp = employeeService.get(1);
        LOGGER.debug("Emp: {} Dept: {}", emp, emp.getDepartment());
    }

    private static void testAddEmployeeWithDept() {
        LOGGER.info("Start testAddEmployeeWithDept");
        Employee e = new Employee("Alice", 75000, true, Date.valueOf("1990-05-15"));
        e.setDepartment(departmentService.get(1));
        employeeService.save(e);
        LOGGER.debug("Saved Employee: {}", e);
    }

    private static void testUpdateEmployeeDept() {
        LOGGER.info("Start testUpdateEmployeeDept");
        Employee e = employeeService.get(2);
        e.setDepartment(departmentService.get(2));
        employeeService.save(e);
        LOGGER.debug("Updated Employee: {}", e);
    }

    private static void testGetDepartmentWithEmployees() {
        LOGGER.info("Start testGetDepartmentWithEmployees");
        Department d = departmentService.get(1);
        LOGGER.debug("Dept: {} Employees: {}", d, d.getEmployeeList());
    }

    private static void testGetEmployeeWithSkills() {
        LOGGER.info("Start testGetEmployeeWithSkills");
        Employee e = employeeService.get(1);
        LOGGER.debug("Emp: {} Skills: {}", e, e.getSkillList());
    }

    private static void testAddSkillToEmployee() {
        LOGGER.info("Start testAddSkillToEmployee");
        Employee e = employeeService.get(1);
        Skill s = skillService.get(3);
        e.getSkillList().add(s);
        employeeService.save(e);
        LOGGER.debug("After Adding Skill {} to Employee {}: Skills: {}", s, e, e.getSkillList());
    }
}
