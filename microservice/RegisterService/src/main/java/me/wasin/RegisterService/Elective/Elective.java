package me.wasin.RegisterService.Elective;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import me.wasin.RegisterService.Subject.Subject;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "electives")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Elective implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "total_register")
    private int totalRegister;

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
