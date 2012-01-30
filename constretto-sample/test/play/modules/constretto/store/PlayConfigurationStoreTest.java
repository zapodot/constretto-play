package play.modules.constretto.store;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import org.constretto.model.TaggedPropertySet;
import org.junit.Test;
import play.test.UnitTest;

import javax.annotation.Nullable;
import java.util.Collection;

import static org.junit.Assert.assertNotNull;

/**
 * Test for the PlayConfigurationStore
 */
public class PlayConfigurationStoreTest extends UnitTest {
    @Test
    public void testParseConfiguration() throws Exception {
        PlayConfigurationStore playConfigurationStore = new PlayConfigurationStore();
        Collection<TaggedPropertySet> taggedPropertySets = playConfigurationStore.parseConfiguration();
        TaggedPropertySet taggedPropertySet = Iterators.find(
                taggedPropertySets.iterator(),
                new Predicate<TaggedPropertySet>() {
                    @Override
                    public boolean apply(@Nullable final TaggedPropertySet taggedPropertySet) {
                        return taggedPropertySet.getProperties().containsKey("example.number");
                    }
                }
        );
        assertNotNull(taggedPropertySet);
        assertEquals("22", taggedPropertySet.getProperties().get("example.number"));
    }
}
