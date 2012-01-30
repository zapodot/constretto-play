package play.modules.constretto.store;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.constretto.ConfigurationStore;
import org.constretto.model.TaggedPropertySet;
import play.Play;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/**
 * Constretto configuration store thet reads configuration from the currently loaded Play configuration.
 */
public class PlayConfigurationStore implements ConfigurationStore {

    @Override
    public Collection<TaggedPropertySet> parseConfiguration() {
        TaggedPropertySet taggedPropertySet = new TaggedPropertySet(Play.id, convertPropertiesToStringMap(Play.configuration), getClass());
        return Lists.newArrayList(taggedPropertySet);
    }

    private Map<String, String> convertPropertiesToStringMap(Properties properties) {
        Map<String, String> propertiesMap = Maps.newHashMapWithExpectedSize(properties.size());
        for (String propertyName : properties.stringPropertyNames()) {
            propertiesMap.put(propertyName, properties.getProperty(propertyName));
        }
        return propertiesMap;
    }
}
