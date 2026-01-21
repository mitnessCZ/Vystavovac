package com.vancura.cz.vystavovac.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vystava")
public class Vystava {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "zadejte o jakou výstavu se jedná")
   private String nazev;
    @NotNull(message = "kdy se koná")
    private LocalDateTime datumcas;
    @NotEmpty(message = "je nutne zadat misto")
    private String misto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public LocalDateTime getDatumcas() {
        return datumcas;
    }

    public void setDatumcas(LocalDateTime datumcas) {
        this.datumcas = datumcas;
    }

    public String getMisto() {
        return misto;
    }

    public void setMisto(String misto) {
        this.misto = misto;
    }

    public String getStav() {
        return stav;
    }

    public void setStav(String stav) {
        this.stav = stav;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public void setPoznamky(String poznamky) {
        this.poznamky = poznamky;
    }

    public List<Zvire> getZvirata() {
        return zvirata;
    }

    public void setZvirata(List<Zvire> zvirata) {
        this.zvirata = zvirata;
    }

    public List<Chovatel> getChovatele() {
        return chovatele;
    }

    public void setChovatele(List<Chovatel> chovatele) {
        this.chovatele = chovatele;
    }

    public List<Posuzovatel> getPosuzovatele() {
        return posuzovatele;
    }

    public void setPosuzovatele(List<Posuzovatel> posuzovatele) {
        this.posuzovatele = posuzovatele;
    }

    private String stav;
    private String poznamky;

    @OneToMany(mappedBy = "vystava", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Zvire> zvirata = new ArrayList<>();

    @OneToMany(mappedBy = "vystava", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Chovatel> chovatele = new ArrayList<>();
    @OneToMany(mappedBy = "vystava", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Posuzovatel> posuzovatele = new ArrayList<>();

    public int getPocetZvirat() {
        if (zvirata != null){
            return zvirata.size();
        }else {
            return 0;
        }
    }
    public int getPocetChovatelu() {
        if (chovatele != null) {
            return chovatele.size();
        }
        else {
            return 0;
        }
    }
    public int getPocetPosuzovatelu() {
        if (posuzovatele != null) {
            return posuzovatele.size();
        } else {
            return 0;
        }
    }
    public Vystava() {
        this.zvirata = new ArrayList<>();
        this.chovatele = new ArrayList<>();
        this.posuzovatele = new ArrayList<>();

    }
}
