package com.vancura.cz.vystavovac.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "posuzovatele")
public class Posuzovatel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    @Size(min = 3, max = 50)
    private String jmeno;
    private String specializace;
    public Posuzovatel(long id) {
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vystava_id")
    private Vystava vystava;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getSpecializace() {
        return specializace;
    }

    public void setSpecializace(String specializace) {
        this.specializace = specializace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }


    @NotEmpty
    private String email;
    private String telefon;

    public Posuzovatel() {

    }
}
