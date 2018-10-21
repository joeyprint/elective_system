package me.wasin.RegisterService.Register;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import me.wasin.RegisterService.Elective.Elective;
import me.wasin.RegisterService.User.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "registers")
public class Register implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private User studentId;

    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "elective_id", nullable = false)
    private Elective electiveId;

    public Register() {
        super();
    }

    public Register(@NotBlank User studentId, @NotBlank Elective electiveId) {
        this.studentId = studentId;
        this.electiveId = electiveId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentId(User studentId) {
        this.studentId = studentId;
    }

    public void setElectiveId(Elective electiveId) {
        this.electiveId = electiveId;
    }

    public int getId() {
        return id;
    }

    public User getStudentId() {
        return studentId;
    }

    public Elective getElectiveId() {
        return electiveId;
    }

}
