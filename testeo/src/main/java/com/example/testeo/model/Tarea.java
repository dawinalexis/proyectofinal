package com.example.testeo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String fechatarea;
    private String tipotarea;
    private String importanciatarea;

    // Tus getters y setters van aquí

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechatarea() {
        return fechatarea;
    }

    public void setFechatarea(String fechatarea) {
        this.fechatarea = fechatarea;
    }

    public String getTipotarea() {
        return tipotarea;
    }

    public void setTipotarea(String tipotarea) {
        this.tipotarea = tipotarea;
    }

    public String getImportanciatarea() {
        return importanciatarea;
    }

    public void setImportanciatarea(String importanciatarea) {
        this.importanciatarea = importanciatarea;
    }
}
