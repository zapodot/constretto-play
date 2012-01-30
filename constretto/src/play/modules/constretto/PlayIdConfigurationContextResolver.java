package play.modules.constretto;

import com.google.common.collect.Lists;
import org.constretto.resolver.ConfigurationContextResolver;
import play.Play;

import java.util.List;

/**
 * Constretto ConfigurationContextResolver implementation that use Play's "id" as tag.
 */
public class PlayIdConfigurationContextResolver implements ConfigurationContextResolver {
    @Override
    public List<String> getTags() {
        String tag = Play.id;
        if (tag == null) {
            tag = "";
        }
        return Lists.newArrayList(tag);
    }
}
