package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Album;
import org.junit.*;
import org.junit.rules.ExpectedException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by heleneshaikh on 26/03/16.
 */
public class AlbumRepositoryTest extends DataSetPersistenceTest {

    private static EntityManagerFactory emf;
    private static AlbumRepository albumRepository;
    private static EntityTransaction tx;

    @BeforeClass
    public static void initEntityManager() throws Exception {
        emf = Persistence.createEntityManagerFactory("MyTestPersistenceUnit");
        albumRepository = new AlbumRepository();
    }

    @AfterClass
    public static void closeEntityManager() throws Exception {
        emf.close();
    }

    @Before
    public void initTransaction() {
        albumRepository.em = emf.createEntityManager();
        tx = albumRepository.em.getTransaction();
        tx.begin();
    }

    @After
    public void closeTransaction() {
        tx.rollback();
        albumRepository.em.close();
    }

    @Test
    public void albumCanBePersistedTest() throws Exception {
        Album album = new Album("Nevermind", "Nirvana", 12, Album.Genre.ROCK);
        albumRepository.createAlbum(album);
        assertNotNull(album.getId());
    }

    @Test
    public void findAllAlbumsTest() throws Exception {
        List<Album> albums = albumRepository.findAllAlbums();
        assertNotNull(albums);
        assertEquals(2, albums.size());
    }



}
