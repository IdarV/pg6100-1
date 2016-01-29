package ninja.idar.models;

import helpers.GenericBeanTestIntegrationTestHelper;
import ninja.idar.models.Post;
import ninja.idar.models.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Idar Vassdal on 25.01.2016.
 */
public class PostIT extends GenericBeanTestIntegrationTestHelper<Post> {
    private Post post;

    @Before
    public void setUp() throws Exception {
        post = new Post();
    }

    @AfterClass
    public static void afterTests(){
        closePersister();
    }

    @Test
    public void testPostTableIsPopulated() throws Exception {
        assertTrue(isTablePopulated("Post"));
    }

    @Test
    public void testPostNamedQueries() throws Exception {
        // NOT IMPLEMENTED
    }

    @Test
    public void testPostPersist() throws Exception {
        post = new Post("postTitle", "This is my post and I would like you to read it please");
        assertFalse(post.getId() > 0);
        persistEntity(post);
        assertTrue(post.getId() > 0);
    }
}