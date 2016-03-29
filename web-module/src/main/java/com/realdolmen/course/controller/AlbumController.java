package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Album;
import com.realdolmen.course.persistence.AlbumRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by heleneshaikh on 26/03/16.
 */

@Named
@RequestScoped
public class AlbumController {
    @Inject
    AlbumRepository albumRepository;

    private String albumTitle;

    private List <Album> albums;

    public void filterAlbums(AjaxBehaviorEvent event) {
        albums = albumRepository.findAlbumByTitle(albumTitle);
    }

    public void remove (Album album) {
        albumRepository.deleteAlbum(album);
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Album> getAllAlbums(){
       return albumRepository.findAllAlbums();
    }

    public void findById(Long id) {
        albumRepository.findById(id);
    }

    public void saveAlbum(Album album) {
        albumRepository.createAlbum(album);
    }


}
