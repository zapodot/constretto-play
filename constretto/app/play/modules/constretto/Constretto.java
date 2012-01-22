package play.modules.constretto;

import org.constretto.ConstrettoBuilder;
import org.constretto.ConstrettoConfiguration;
import play.modules.constretto.store.PlayConfigurationStore;

/**
 * User: sondre
 * Date: 1/11/12
 * Time: 9:34 PM
 */
public class Constretto {
                                                
    private ConstrettoConfiguration configuration;
    
    private Constretto(ConstrettoConfiguration constrettoConfiguration) {
        this.configuration = constrettoConfiguration;

    }
    
    private static Constretto create() {
        ConstrettoBuilder constrettoBuilder = new ConstrettoBuilder(new PlayIdConfigurationContextResolver());
        constrettoBuilder.addConfigurationStore(new PlayConfigurationStore());
        return new Constretto(constrettoBuilder.getConfiguration());
    }
    
    private <T> T configureObject(T objectToConfigure) {
        return configuration.on(objectToConfigure);
    }
    
    public static <T> T configure(T configurableObject) {
        return create().configureObject(configurableObject);
    }


}
