package com.realdolmen.course.integration;

import com.realdolmen.course.persistence.RemoteAlbumRepository;
import org.junit.Test;

/**
 * Created by heleneshaikh on 26/03/16.
 */
public class RemoteAlbumRepositoryTest extends RemoteIntegrationTest {

    @Test
    public void findAllAlbumsRemotely() throws Exception {
        RemoteAlbumRepository remoteAlbumRepository = lookup("ear-module-1.2/ejb-module-1.2/AlbumRepository!com.realdolmen.course.persistence.RemoteAlbumRepository");
        assertEquals(2, remoteAlbumRepository.findAllAlbums().size());
    }

}
