package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Album;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by heleneshaikh on 26/03/16.
 */

@Remote
public interface RemoteAlbumRepository {

    void createAlbum(Album album);

    void updateAlbum(Album album);

    void deleteAlbum(Album album);

    void findById(Long id);

    List<Album> findAllAlbums();
}
