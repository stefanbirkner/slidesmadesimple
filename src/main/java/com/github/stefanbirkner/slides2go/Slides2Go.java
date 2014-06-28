package com.github.stefanbirkner.slides2go;

import com.github.stefanbirkner.slides2go.gist.ShowGist;
import com.github.stefanbirkner.slides2go.webjars.WebjarsRoute;

import static spark.Spark.get;
import static spark.Spark.setPort;
import static spark.SparkBase.staticFileLocation;

public class Slides2Go {
    public static void main(String... args) {
        setPortIfRunningOnHeroku();
        get("/", (request, response) -> "Slides2Go");
        get("/slides/gist/:user/:id", new ShowGist());
        get("/webjars/:library/:version/:file", new WebjarsRoute());
        get("/webjars/*/*/*/*", new WebjarsRoute());
    }

    private static void setPortIfRunningOnHeroku() {
        String portAsString = System.getenv("PORT");
        if (portAsString != null)
            setPort(Integer.parseInt(portAsString));
    }
}
