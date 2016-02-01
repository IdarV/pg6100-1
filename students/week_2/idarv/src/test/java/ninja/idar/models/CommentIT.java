package ninja.idar.models;

import helpers.GenericBeanTestIntegrationTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Idar Vassdal on 29.01.2016.
 */
public class CommentIT extends GenericBeanTestIntegrationTestHelper<Comment> {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager persister;
    private Comment comment;

    @Before
    public void setUp() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        persister = entityManagerFactory.createEntityManager();
        comment = new Comment();
    }

    @After
    public void tearDown() throws Exception {
        persister.close();
        entityManagerFactory.close();
    }

    @Test
    public void testLoadsInitScript() throws Exception {
        assertTrue("init.sql should populate comments in the database", isTablePopulated("Comment"));
    }
}