package edu.eci.dosw.parcial.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;
//Prueba 2

@Entity
@Table(name = "tutors")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0)
    @Column(nullable = false)
    private Integer rate;

    @Min(0)
    @Column(name = "materias", nullable = false)
    private String Materias;

    // true = Activo, false = Inactivo (regla: se crea Activo y nunca se elimina
    // fisicamente)
    @Column(nullable = false)
    private Boolean state = true;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Worker() {
    }

    public Worker(Integer rate, Integer salary) {
        this.rate = rate;
        this.salary = salary;
    }

    @PrePersist
    void onCreate() {
        this.creationDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getFinishedJobs() {
        return finishedJobs;
    }

    public void setFinishedJobs(Integer finishedJobs) {
        this.finishedJobs = finishedJobs;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}