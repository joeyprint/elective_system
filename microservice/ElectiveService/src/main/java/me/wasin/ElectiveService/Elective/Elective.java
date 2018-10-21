package me.wasin.ElectiveService.Elective;

import me.wasin.ElectiveService.Subject.Subject;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "electives")
public class Elective implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "total_register")
    private int totalRegister;

    @NotBlank
    @Column(name = "start_at")
    private Date startAt;

    @NotBlank
    @Column(name = "end_at")
    private Date endAt;


    public Elective() {
        super();
    }

    public Elective(Subject subject, @NotBlank int totalRegister) {
        this.subject = subject;
        this.totalRegister = totalRegister;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setTotalRegister(int totalRegister) {
        this.totalRegister = totalRegister;
    }

    public int getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getTotalRegister() {
        return totalRegister;
    }
}
