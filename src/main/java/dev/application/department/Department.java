package dev.application.department;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "dep_name")
    private String department_name;

    @Column(name = "dep_tel")
    private String department_telephone;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the department_name
     */
    public String getDepartment_name() {
        return department_name;
    }

    /**
     * @return the department_telephone
     */
    public String getDepartment_telephone() {
        return department_telephone;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param department_name the department_name to set
     */
    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    /**
     * @param department_telephone the department_telephone to set
     */
    public void setDepartment_telephone(String department_telephone) {
        this.department_telephone = department_telephone;
    }
}