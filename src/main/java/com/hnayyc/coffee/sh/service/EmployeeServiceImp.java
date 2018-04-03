package com.hnayyc.coffee.sh.service;

import java.util.List;

import com.hnayyc.coffee.sh.dao.EmployeeDao;
import com.hnayyc.coffee.sh.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("employeeService")
@Transactional
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }

    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }

    public void deleteEmployeeBySsn(String ssn) {
        dao.deleteEmployeeBySsn(ssn);
    }

    public Employee findBySsn(String ssn) {
        return dao.findBySsn(ssn);
    }

    public void updateEmployee(Employee employee){
        dao.updateEmployee(employee);
    }
}
