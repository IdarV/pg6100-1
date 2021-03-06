package ninja.idar.models;

import helpers.GenericBeanValidationTestHelper;
import helpers.StringHelper;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Idar Vassdal on 18.01.2016.
 */
public class PostValidationTestTests extends GenericBeanValidationTestHelper<Post> {
    private static StringHelper stringHelper;
    private Post post;

    @BeforeClass
    public static void beforeTests(){
        stringHelper = new StringHelper();
    }

    @Before
    public void setUp() throws Exception {
        initLegalPost();
    }

    @AfterClass
    public static void afterTests(){
        closeValidationFactory();
    }

    @Test
    public void testEmptyPost() throws Exception {
        post = new Post();
        assertFalse("Empty post is not valid", isValid(post));
    }

    @Test
    public void testLegalPost() throws Exception {
        assertTrue("Legal post should have no validations", isValid(post));
    }

    @Test
    public void testContentsValidation() throws Exception {
        String longContents = stringHelper.buildStringOfLength(1001);
        String shortContents = stringHelper.buildStringOfLength(19);

        post.setContents(shortContents);
        assertFalse("19 characters should be too short content", isValidProperty(post, "contents"));

        post.setContents(longContents);
        assertFalse("1001 characters should be too long content", isValidProperty(post, "contents"));
    }

    @Test
    public void testTitleValidation() throws Exception {
        String longTitle = stringHelper.buildStringOfLength(31);
        String shortTitle = stringHelper.buildStringOfLength(4);

        post.setTitle(longTitle);
        assertFalse("title max cap should not be exceeded", isValidProperty(post, "title"));

        post.setTitle(shortTitle);
        assertFalse("title min cap should be exceeded", isValidProperty(post, "title"));

    }

    private void initLegalPost(){
        post = new Post("postTitle", "This is my post and I would like you to read it please");
    }
}