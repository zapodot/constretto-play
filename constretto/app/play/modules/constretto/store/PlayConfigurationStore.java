package play.modules.constretto.store;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.constretto.ConfigurationStore;
import org.constretto.model.TaggedPropertySet;
import play.Play;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/**
 * User: sondre
 * Date: 1/11/12
 * Time: 9:34 PM
 */
public class PlayConfigurationStore implements ConfigurationStore {

    @Override
    public Collection<TaggedPropertySet> parseConfiguration() {
        TaggedPropertySet taggedPropertySet = new TaggedPropertySet(Play.id, convertPropertiesToStringMap(Play.configuration), getClass());
        return Lists.newArrayList(taggedPropertySet);
    }
    
    private Map<String, String> convertPropertiesToStringMap(Properties properties) {
        Map<String, String> propertiesMap = Maps.newHashMapWithExpectedSize(properties.size());
        for(String propertyName: properties.stringPropertyNames()) {
            propertiesMap.put(propertyName, properties.getProperty(propertyName));
        } 
        return propertiesMap;
    }
}
