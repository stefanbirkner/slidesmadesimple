package com.github.stefanbirkner.slidesmadesimple;

import com.github.stefanbirkner.slidesmadesimple.gist.ShowGist;

import static spark.Spark.get;
import static spark.Spark.setPort;

public class SlidesMadeSimple {
    public static void main(String... args) {
        setPortIfRunningOnHeroku();
        get("/", (request, response) -> "Slides made Simple");
        get("/slides/gist/:user/:id", new ShowGist());
    }

    private static void setPortIfRunningOnHeroku() {
        String portAsString = System.getenv("PORT");
        if (portAsString != null)
            setPort(Integer.parseInt(portAsString));
    }
}
