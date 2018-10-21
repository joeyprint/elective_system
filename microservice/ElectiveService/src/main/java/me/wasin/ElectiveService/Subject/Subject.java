package me.wasin.ElectiveService.Subject;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "subject_id")
    private String subjectId;

    @NotBlank
    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "lecturer_id")
    private int lecturerId;

    public Subject() {
        super();
    }

    public Subject(@NotBlank String subjectId, @NotBlank String subjectName, @NotBlank int lecturerId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.lecturerId = lecturerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public int getId() {
        return id;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getLecturerId() {
        return lecturerId;
    }
}
