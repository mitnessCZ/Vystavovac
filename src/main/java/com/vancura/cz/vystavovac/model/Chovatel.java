package com.vancura.cz.vystavovac.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "chovatele")
public class Chovatel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 3, max = 50)
    private String jmenoChovatele;

    @OneToMany(mappedBy = "chovatel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Zvire> zvirata;
    @NotEmpty
    private String adresa;

    private String email;
    private String telefon;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vystava_id")
    private Vystava vystava;

    public Chovatel() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJmenoChovatele() {
        return jmenoChovatele;
    }

    public void setJmenoChovatele(String jmenoChovatele) {
        this.jmenoChovatele = jmenoChovatele;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
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

    public List<Zvire> getZvirata() {
        return zvirata;
    }

    public void setZvirata(List<Zvire> zvirata) {
        this.zvirata = zvirata;
    }

}
