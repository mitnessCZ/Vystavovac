package com.vancura.cz.vystavovac.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Zvirata")
public class Zvire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 2, max = 10)
    private String plemeno;
    @NotEmpty
    @Size(min = 5, max = 8)
    private String regKod;
    private boolean pohlavi;

    @NotNull(message = "ke zvířeti musí být přiřazen chovatel!")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chovatel_id", nullable = false)
    private Chovatel chovatel;

    private String typZvirete;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vystava_id")
    private Vystava vystava;

    public Zvire() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlemeno() {
        return plemeno;
    }

    public void setPlemeno(String plemeno) {
        this.plemeno = plemeno;
    }

    public String getRegKod() {
        return regKod;
    }

    public void setRegKod(String regKod) {
        this.regKod = regKod;
    }

    public boolean isPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(boolean pohlavi) {
        this.pohlavi = pohlavi;
    }

    public Chovatel getChovatel() {
        return chovatel;
    }

    public void setChovatel(Chovatel chovatel) {
        this.chovatel = chovatel;
    }

    public String getTypZvirete() {
        return typZvirete;
    }

    public void setTypZvirete(String typZvirete) {
        this.typZvirete = typZvirete;
    }
}
