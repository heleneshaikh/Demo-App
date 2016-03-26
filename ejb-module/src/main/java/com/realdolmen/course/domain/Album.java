package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by heleneshaikh on 25/03/16.
 */

@Entity
@NamedQueries( {
        @NamedQuery(name="album.findAll", query = "SELECT a FROM Album a")
})
public class Album implements Serializable {
    public static String FIND_ALL = "album.findAll";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    private String composer;
    @Column(name="songs")
    private int numberOfSongs;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne
    private User user;

    public enum Genre {
        ROCK, CLASSICAL, POP;
    }

    public Album() {
    }

    public Album(String title, String composer, int numberOfSongs, Genre genre) {
        this.title = title;
        this.composer = composer;
        this.numberOfSongs = numberOfSongs;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
