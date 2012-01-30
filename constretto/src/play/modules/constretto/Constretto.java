package play.modules.constretto;

import org.constretto.ConstrettoBuilder;
import org.constretto.ConstrettoConfiguration;
import org.constretto.internal.store.SystemPropertiesStore;
import play.modules.constretto.store.PlayConfigurationStore;

/**
 * Main integration class for Constretto. To configure your own POJOS, use the #configure method of this class.
 */
public class Constretto {

    public static Constretto instance;

    private ConstrettoConfiguration configuration;

    private Constretto(ConstrettoConfiguration constrettoConfiguration) {
        this.configuration = constrettoConfiguration;

    }

    public static Constretto reconfigure() {
        ConstrettoBuilder constrettoBuilder = new ConstrettoBuilder(new PlayIdConfigurationContextResolver());
        constrettoBuilder.addConfigurationStore(new SystemPropertiesStore());
        constrettoBuilder.addConfigurationStore(new PlayConfigurationStore());
        return new Constretto(constrettoBuilder.getConfiguration());

    }

    public static void resetConfiguration() {
        instance = null;
    }

    private <T> T configureObject(T objectToConfigure) {
        return configuration.on(objectToConfigure);
    }

    private static Constretto getInstance() {
        if (instance == null) {
            instance = reconfigure();
        }
        return instance;
    }

    public static <T> T configure(T configurableObject) {
        return getInstance().configureObject(configurableObject);
    }


}
