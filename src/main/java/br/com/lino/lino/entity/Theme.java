package br.com.lino.lino.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTheme;

    @Column(nullable = false)
    private String nameTheme;

    public Long getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(Long idTheme) {
        this.idTheme = idTheme;
    }

    public String getNameTheme() {
        return nameTheme;
    }

    public void setNameTheme(String nameTheme) {
        this.nameTheme = nameTheme;
    }

    public Theme() {
    }

    public Theme(String nameTheme) {
        this.nameTheme = nameTheme;
    }

}
