package play.modules.constretto;

import play.Logger;
import play.Play;
import play.PlayPlugin;
import play.mvc.Controller;

/**
 * Constretto Play Plugin used for injecting configuration in to Controllers
 */
public class ConstrettoPlugin extends PlayPlugin {

    private static final String INJECTION_ERROR_MESSAGE = "Can not inject configuration in to Controller class %1$s because it can't be instantiated";

    @Override
    public void onConfigurationRead() {
        Constretto.resetConfiguration();
        if (Logger.isDebugEnabled()) {
            Logger.debug("Configuration read. ");
        }
    }

    @Override
    public void onApplicationStart() {
        Constretto.reconfigure();
        reconfigureControllers();

    }

    @Override
    public void onApplicationStop() {
        Constretto.resetConfiguration();
    }

    private void reconfigureControllers() {
        for (Class<Object> clazz : Play.classloader.getAssignableClasses(Controller.class)) {
            try {
                if (Logger.isDebugEnabled()) {
                    Logger.debug("Will inject configuration in Controller class", clazz.getName());
                }
                Object controllerInstance = clazz.newInstance();
                Constretto.configure(controllerInstance);
            } catch (InstantiationException e) {
                Logger.warn(e, INJECTION_ERROR_MESSAGE, clazz.getName());
            } catch (IllegalAccessException e) {
                Logger.warn(e, INJECTION_ERROR_MESSAGE, clazz.getName());
            }
        }
    }
}
