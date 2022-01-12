package com.ye.controller;

import com.ye.dao.DepartmentDao;
import com.ye.dao.EmployeeDao;
import com.ye.pojo.Department;
import com.ye.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping(value = "/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAllEmployees();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    @GetMapping(value = "/emp")
    public String add(Model model){
        Collection<Department> departments = departmentDao.getAllDepartments();
        model.addAttribute("deps",departments);
        return "emp/add";
    }
    @PostMapping(value = "/emp")
    public String addEmp(Employee employee){
        //添加员工
        employeeDao.addMember(employee);
        return "redirect:/emps";
    }
    @GetMapping(value = "/emp/{id}")
    public String editEmp(@PathVariable("id") Integer id,Model model){
        //修改员工信息
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getAllDepartments();
        model.addAttribute("deps",departments);
        return "emp/edit";
    }
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.addMember(employee);
        return "redirect:/emps";
    }
    @GetMapping(value = "/del/{id}")
    public String delEmp(@PathVariable("id") Integer id){
        //删除员工
        employeeDao.fire(id);
        return "redirect:/emps";
    }
}
