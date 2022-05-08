package com.example.ufmanagerf.model;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Uf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUf;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String numUf;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String nomUf;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    @Min(value = 1, message = "No pot ser menys de 1 hora")
    private String horesUf;

    @ManyToOne
    @Nullable
    private Mp mp;

    @OneToMany(mappedBy = "uf", cascade = CascadeType.ALL)
    @Nullable
    private List<Itemmat> itemmats;

    public Uf(String numUf, String nomUf, String horesUf) {
        this.numUf = numUf;
        this.nomUf = nomUf;
        this.horesUf = horesUf;
    }

    public Uf() {
    }

    public int getIdUf() {
        return idUf;
    }

    public void setIdUf(int idUf) {
        this.idUf = idUf;
    }

    public String getNumUf() {
        return numUf;
    }

    public void setNumUf(String numUf) {
        this.numUf = numUf;
    }

    public String getNomUf() {
        return nomUf;
    }

    public void setNomUf(String nomUf) {
        this.nomUf = nomUf;
    }

    public String getHoresUf() {
        return horesUf;
    }

    public void setHoresUf(String horesUf) {
        this.horesUf = horesUf;
    }

    public Mp getMp() {
        return mp;
    }

    public void setMp(Mp mp) {
        this.mp = mp;
    }

    public List<Itemmat> getItemmats() {
        return itemmats;
    }

    public void setItemmats(List<Itemmat> itemmats) {
        this.itemmats = itemmats;
    }

    public void setItemmat(Itemmat itemmat) {
        this.itemmats.add(itemmat);
    }

    public void removeItemmat(Itemmat itemmat) {
        this.itemmats.remove(itemmat);
    }
}
