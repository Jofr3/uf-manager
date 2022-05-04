package com.example.ufmanagerf.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Mp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMp;

    @Min(value = 0, message = "No pot ser mes petit que 0")
    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String numMp;

    @NotEmpty(message = "Aquest camp no pot estar buit")
    private String nomMp;

    @Nullable
    @OneToMany(mappedBy = "mp", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Uf> ufs;

    @ManyToOne
    @Nullable
    private Pla pla;

    /*
    idMp        int
    numMp       string
    nomMp       string
    ufs         List<Uf>
    pla         Pla
    */

    public Mp(String numMp, String nomMp, List<Uf> ufs) {
        this.numMp = numMp;
        this.nomMp = nomMp;
        this.ufs = ufs;
    }

    public Mp() {
    }

    public int getIdMp() {
        return idMp;
    }

    public void setIdMp(int idMp) {
        this.idMp = idMp;
    }

    public String getNumMp() {
        return numMp;
    }

    public void setNumMp(String numMp) {
        this.numMp = numMp;
    }

    public String getNomMp() {
        return nomMp;
    }

    public void setNomMp(String nomMp) {
        this.nomMp = nomMp;
    }

    @Nullable
    public List<Uf> getUfs() {
        return ufs;
    }

    public void setUfs(@Nullable List<Uf> ufs) {
        this.ufs = ufs;
    }

    public void setUf(Uf uf) {
        this.ufs.add(uf);
    }

    public void removeUf(Uf uf) {
        this.ufs.remove(uf);
    }

    public void removeUfs() {
        this.ufs = null;
    }

    @Nullable
    public Pla getPla() {
        return pla;
    }

    public void setPla(@Nullable Pla pla) {
        this.pla = pla;
    }

    @Override
    public String toString() {
        return "Mp{" +
                "idMp=" + idMp +
                ", numMp='" + numMp + '\'' +
                ", nomMp='" + nomMp + '\'' +
                '}';
    }
}
