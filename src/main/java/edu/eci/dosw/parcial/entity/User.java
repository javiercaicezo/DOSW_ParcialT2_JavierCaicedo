package edu.eci.dosw.parcial.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "users") // "user" va a ser la palabra reservada en PostgreSQL
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true, length = 150)
    private String correo;

    @Column(nullable = false)
    private Boolean state = true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private String role;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    public User() {
    }

    public User(String nombre, String foto, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}