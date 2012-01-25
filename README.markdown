Constretto Play Module
===================

 * Integrates the [Constretto framework](http://constretto.org) with Play
 * Adds support for using Play's ID mechanism to specify environment. 
 * Makes all the properties in "application.conf" available for injection
 * Injection of configuration for controller classes using Constretto's @Configuration annotation
 * The module has been developed and tested with Play 1.2.4

Examples:
--------------------

    public class Application extends Controller {
    
    @Configuration(expression = "example.text")
    static String text;

    @Configuration(expression = "example.number", defaultValue = "0", required = false)
    static Integer number;

    ...
    }

If the configuration expression in the first property is not in found in application.conf, Constretto will throw a ConstrettoException (which is a RuntimeException) . 

If you provide a value for the 'defaultValue' property like in the second property that will be used if Constretto can not find a value for the expression in the configuration file.

When you change values for the properties in application.conf and hit reload the Constretto Play modul will automatically re-inject values in to the annotated fields in all your controllers.


Change history
--------------------
 * v.01 (built 2012-01-25): basic integration with Play controllers done

If you have experience any issues or have change requests for this module, please use the [GitHub issue tracker](https://github.com/zapodot/constretto-play/issues).
