package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.User;
import org.junit.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by heleneshaikh on 27/03/16.
 */
public class UserRepositoryTest extends DataSetPersistenceTest {

    private static EntityManagerFactory emf;
    private static UserRepository userRepository;
    private static EntityTransaction tx;

    @BeforeClass
    public static void initEntityManager() throws Exception {
        emf = Persistence.createEntityManagerFactory("MyTestPersistenceUnit");
        userRepository = new UserRepository();
    }

    @AfterClass
    public static void closeEntityManager() throws Exception {
        emf.close();
    }

    @Before
    public void initTransaction() throws Exception {
        userRepository.em = emf.createEntityManager();
        tx = userRepository.em.getTransaction();
        tx.begin();
    }

    @After
    public void closeTransaction() throws Exception {
        tx.rollback();
        userRepository.em.close();
    }

    @Test
    public void savesUsers() throws Exception {
        User user = new User("Helene", "Shaikh", 27);
        userRepository.createUser(user);
        assertNotNull(user.getId());
    }

    @Test
    public void findsAllUsers() throws Exception {
        List<User> users = userRepository.findAllUsers();
        assertEquals(2, users.size());
    }
}
