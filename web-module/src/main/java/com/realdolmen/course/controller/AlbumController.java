package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Album;
import com.realdolmen.course.persistence.AlbumRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by heleneshaikh on 26/03/16.
 */

@Named
public class AlbumController {
    @Inject
    AlbumRepository albumRepository;

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



}
