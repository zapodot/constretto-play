package play.modules.constretto;

import com.google.common.collect.Lists;
import org.constretto.model.ConfigurationNode;
import org.constretto.resolver.ConfigurationContextResolver;
import play.Play;

import java.util.List;

/**
 * User: sondre
 * Date: 1/11/12
 * Time: 9:03 PM
 */
public class PlayIdConfigurationContextResolver implements ConfigurationContextResolver {
    @Override
    public List<String> getTags() {
        String tag = Play.id;
        if(tag == null) {
            tag = "";
        }
        return Lists.newArrayList(tag);
    }
}
