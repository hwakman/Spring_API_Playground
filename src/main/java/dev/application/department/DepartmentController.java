package dev.application.department;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dep")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("")
    public List<Department> getDepartmentAll () {
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);

        return departments;
    }

    @PostMapping("/add")
    public String addDepartment (
        @RequestParam(value = "dep_name") String dep_name,
        @RequestParam(value = "dep_tel") String dep_tel
    ){
        try {
            Department dep = new Department();
            dep.setDepartment_name(dep_name);
            dep.setDepartment_telephone(dep_tel);
            departmentRepository.save(dep);

            return "Value added";
        } catch (Exception e) {

            return "Error : " + e;
        }
    }

    @PostMapping("/del")
    public String deleteDepartment (
        @RequestParam(value = "id") Long id
    ) {
        try {
            departmentRepository.deleteById(id);
            return "Department id '"+id+"' was deleted.";
        } catch (Exception e) {
            return "Error : " + e;
        }
    }
}