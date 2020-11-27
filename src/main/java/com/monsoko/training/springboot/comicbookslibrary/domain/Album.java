package com.monsoko.training.springboot.comicbookslibrary.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Album implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlbum;
    @NotNull @NotEmpty
    private String title;
    private int number;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;
    private String coverName;

    public Album() {
    }

    public Album(String title, int number, Date publicationDate, String coverName) {
        this.title = title;
        this.number = number;
        this.publicationDate = publicationDate;
        this.coverName = coverName;
    }

    public Long getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Long idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }
}
