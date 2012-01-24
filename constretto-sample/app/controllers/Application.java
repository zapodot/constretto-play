package controllers;

import org.constretto.annotation.Configuration;
import play.mvc.Controller;

public class Application extends Controller {

    @Configuration(expression = "example.text")
    static String text;

    @Configuration(expression = "example.number")
    static Integer number;

    public static void index() {
        StringBuilder exampleTextBuilder = new StringBuilder("Injected parameters ");
        exampleTextBuilder.append("Text: ").append(text).append('\n');
        exampleTextBuilder.append("Number: ").append(number);
        renderText(exampleTextBuilder.toString());
    }

}