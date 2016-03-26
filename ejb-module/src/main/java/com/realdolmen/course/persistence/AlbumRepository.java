package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Album;
import com.sun.jndi.cosnaming.IiopUrl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by heleneshaikh on 26/03/16.
 */

@Stateless
@LocalBean
public class AlbumRepository implements RemoteAlbumRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public void createAlbum(Album album) {
        em.persist(album);
    }

    @Override
    public void updateAlbum(Album album) {
        em.merge(album);

    }

    @Override
    public void deleteAlbum(Album album) {
        album = em.find(Album.class, album.getId());
        em.remove(album);

    }

    @Override
    public void findById(Long id) {
        em.find(Album.class, id);
    }

    @Override
    public List<Album> findAllAlbums() {
        return em.createNamedQuery(Album.FIND_ALL, Album.class).getResultList();
    }

}
