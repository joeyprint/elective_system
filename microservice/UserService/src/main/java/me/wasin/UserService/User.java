package me.wasin.UserService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "student_id")
    private String studentId;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String department;

    @NotBlank
    private String faculty;

    private int year;

    public User() {
        super();
    }

    public User(@NotBlank String studentId, @NotBlank String name, @NotBlank String surname, @NotBlank String department, @NotBlank String faculty) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.faculty = faculty;
    }

    public User(@NotBlank String studentId, @NotBlank String name, @NotBlank String surname, @NotBlank String department, @NotBlank String faculty, int year) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.faculty = faculty;
        this.year = year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }
}