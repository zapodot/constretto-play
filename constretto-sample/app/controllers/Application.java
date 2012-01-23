package controllers;

import org.constretto.annotation.Configuration;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

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