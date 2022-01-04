package com.ye.dao;

import com.ye.pojo.Department;
import com.ye.pojo.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees =null;
    private static Integer initId = 1006;

    @Autowired
    private static DepartmentDao departmentDao = new DepartmentDao();

    static{
        employees =  new HashMap<Integer,Employee>();
        employees.put(1001,new Employee(1001,"aa","a953427984@qq.com",1,departmentDao.getDepartmentById(101)));
        employees.put(1002,new Employee(1002,"bb","b953427984@qq.com",0,departmentDao.getDepartmentById(102)));
        employees.put(1003,new Employee(1003,"cc","c953427984@qq.com",1,departmentDao.getDepartmentById(103)));
        employees.put(1004,new Employee(1004,"dd","d953427984@qq.com",0,departmentDao.getDepartmentById(104)));
        employees.put(1005,new Employee(1005,"ee","e953427984@qq.com",1,departmentDao.getDepartmentById(105)));

    }
    public Collection<Employee> getAllEmployees(){
        return employees.values();
    }

    public void addMember(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);

    }
    public void fire(Integer id){
        employees.remove(id);
    }
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    @Test
    public void test(){
        System.out.println(getAllEmployees());
        System.out.println(getEmployeeById(1001));

        addMember(new Employee(null,"ff","f953427984@qq.com",1,departmentDao.getDepartmentById(105)));
        fire(1001);

        System.out.println(getAllEmployees());
    }
}
