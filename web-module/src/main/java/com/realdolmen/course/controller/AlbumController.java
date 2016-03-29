package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Album;
import com.realdolmen.course.persistence.AlbumRepository;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by heleneshaikh on 26/03/16.
 */

@Named
@RequestScoped
public class AlbumController {
    @Inject
    AlbumRepository albumRepository;
    private List <Album> albumList;
    private String albumTitle;

    public List<Album> getAllAlbums(){
       return albumRepository.findAllAlbums();
    }

    public void removeAlbum(Album album) {
        albumRepository.deleteAlbum(album);
    }

    public void findById(Long id) {
        albumRepository.findById(id);
    }

    public void saveAlbum(Album album) {
        albumRepository.createAlbum(album);
    }

    public void filterAlbums(AjaxBehaviorEvent event) {
        albumList = albumRepository.findAlbumByTitle(albumTitle);
    }

    public AlbumRepository getAlbumRepository() {
        return albumRepository;
    }

    public void setAlbumRepository(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }
}
