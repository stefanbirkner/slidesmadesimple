package com.github.stefanbirkner.slides2go;

import com.github.stefanbirkner.slides2go.routes.ShowGist;

import static spark.Spark.get;
import static spark.Spark.setPort;

public class Slides2Go {
    public static void main(String... args) {
        setPortIfRunningOnHeroku();
        get("/", (request, response) -> "Slides2Go");
        get("/slides/gist/:user/:id", new ShowGist());
    }

    private static void setPortIfRunningOnHeroku() {
        String portAsString = System.getenv("PORT");
        if (portAsString != null)
            setPort(Integer.parseInt(portAsString));
    }
}
