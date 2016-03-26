package com.realdolmen.course.controller;

import com.realdolmen.course.persistence.AlbumRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by heleneshaikh on 26/03/16.
 */

@RunWith(MockitoJUnitRunner.class)

public class AlbumControllerTest extends Mockito {
    @Mock
    private AlbumRepository albumRepository;

    @InjectMocks
    private AlbumController albumController = new AlbumController();

    @Test
    public void getAllAlbumsToRepo() throws Exception {
        albumController.getAllAlbums();
        verify(albumRepository).findAllAlbums();
        verifyNoMoreInteractions(albumRepository);
    }

}
