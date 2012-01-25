package controllers;

import org.constretto.annotation.Configuration;
import org.constretto.annotation.Configure;
import play.mvc.Controller;

public class Application extends Controller {

    private static class ExampleConfiguration {

        private ExampleConfiguration(String text, Integer number) {
            this.text = text;
            this.number = number;
        }

        private String text;

        @Configuration(expression = "example.number")
        private Integer number;
    }

    @Configuration(expression = "example.text")
    static String text;

    @Configuration(expression = "example.number")
    static Integer number;

    @Configuration(expression = "example.unknownProperty", defaultValue = "default text", required = false)
    static String missingValue;

    static ExampleConfiguration configuration;

    public static void index() {
        StringBuilder exampleTextBuilder = new StringBuilder("Injected parameters ");
        exampleTextBuilder.append("Text: ").append(text).append('\n');
        exampleTextBuilder.append("Number: ").append(number).append('\n');
        exampleTextBuilder.append("missingValue: ").append(missingValue).append('\n');
        if (configuration != null) {
            exampleTextBuilder.append("configuration property has been set");
        }
        renderText(exampleTextBuilder.toString());
    }

    @Configure
    public void configurationMethod(
            @Configuration(expression = "example.text") String text,
            @Configuration(expression = "example.number") Integer number
    ) {
        configuration = new ExampleConfiguration(text, number);
    }

}