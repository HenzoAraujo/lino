package br.com.lino.lino.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity 
public class Note {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNote;

    @Column(nullable = false)
    private String nameNote;

    @Column(nullable = false)
    private String descNote;

    private Date dateNote;

    @ManyToOne
    private Theme theme;


    public Long getIdNote() {
        return idNote;
    }

    public void setIdNote(Long idNote) {
        this.idNote = idNote;
    }

    public String getNameNote() {
        return nameNote;
    }

    public void setNameNote(String nameNote) {
        this.nameNote = nameNote;
    }

    public String getDescNote() {
        return descNote;
    }

    public void setDescNote(String descNote) {
        this.descNote = descNote;
    }

    public Date getDateNote() {
        return dateNote;
    }

    public void setDateNote(Date dateNote) {
        this.dateNote = dateNote;
    }

     public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Note(){

    }

    public Note(String descNote){
        this.descNote = descNote;
        this.dateNote = new Date(System.currentTimeMillis());
    }

}
