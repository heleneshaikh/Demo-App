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
    @Mock //shorthand for mock creation
    private AlbumRepository albumRepository;

    @InjectMocks //creates an instance of the class + injects the mocks that are created with the @Mock annotations into this instance
    private AlbumController albumController = new AlbumController();

    @Test
    public void getAllAlbumsToRepo() throws Exception {
        albumController.getAllAlbums();
        verify(albumRepository).findAllAlbums(); //verify() method to ensure that a method was called.
        verifyNoMoreInteractions(albumRepository); //Verifies that no interactions happened on given mocks.
    }

}
