package play.modules.constretto;

import org.junit.Test;
import play.test.UnitTest;

import java.util.List;

/**
 *
 */
public class PlayIdConfigurationContextResolverTest extends UnitTest {

    @Test
    public void testGetTags() throws Exception {
        PlayIdConfigurationContextResolver playIdConfigurationContextResolver = new PlayIdConfigurationContextResolver();
        List<String> tags = playIdConfigurationContextResolver.getTags();
        assertEquals(1, tags.size());
        assertEquals("test", tags.get(0));
    }
}
