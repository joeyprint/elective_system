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
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Register implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private User student_id;

    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "elective_id", nullable = false)
    private Elective elective_id;

    @NotBlank
    @Column(name = "start_at")
    private Date startAt;

    @NotBlank
    @Column(name = "end_at")
    private Date endAt;

    public Register() {
        super();
    }

    public Register(@NotBlank User student_id, @NotBlank Elective elective_id, @NotBlank Date startAt, @NotBlank Date endAt) {
        this.student_id = student_id;
        this.elective_id = elective_id;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent_id(User student_id) {
        this.student_id = student_id;
    }

    public void setElective_id(Elective elective_id) {
        this.elective_id = elective_id;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public int getId() {
        return id;
    }

    public User getStudent_id() {
        return student_id;
    }

    public Elective getElective_id() {
        return elective_id;
    }

    public Date getStartAt() {
        return startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

}
