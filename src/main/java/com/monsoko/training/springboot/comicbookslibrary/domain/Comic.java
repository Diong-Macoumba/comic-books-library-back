package com.monsoko.training.springboot.comicbookslibrary.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Comic implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComic;
    private String title;

    @NotNull @NotEmpty
    private String scriptWriter;
    private String illustrator;
    private String publisher;
    private Boolean favorite;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Comic_Album")
    private Set<Album> albums;

    public Comic() {
    }

    public Comic(String title, String scriptWriter, String illustrator, String publisher, Boolean favorite) {
        this.title = title;
        this.scriptWriter = scriptWriter;
        this.illustrator = illustrator;
        this.publisher = publisher;
        this.favorite = favorite;
    }

    public Long getIdComic() {
        return idComic;
    }

    public void setIdComic(Long idComic) {
        this.idComic = idComic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScriptWriter() {
        return scriptWriter;
    }

    public void setScriptWriter(String scriptWriter) {
        this.scriptWriter = scriptWriter;
    }

    public String getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(String illustrator) {
        this.illustrator = illustrator;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
