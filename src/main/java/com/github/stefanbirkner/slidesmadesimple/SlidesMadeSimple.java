package com.github.stefanbirkner.slidesmadesimple;

import com.github.stefanbirkner.slidesmadesimple.gist.ShowGist;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.setPort;

public class SlidesMadeSimple {
    public static void main(String... args) {
        setPortIfRunningOnHeroku();
        get("/",
                (request, response) -> new ModelAndView("no model", "startpage.mustache"),
                new MustacheTemplateEngine());
        get("/slides/gist/:user/:id", new ShowGist());
    }

    private static void setPortIfRunningOnHeroku() {
        String portAsString = System.getenv("PORT");
        if (portAsString != null)
            setPort(Integer.parseInt(portAsString));
    }
}
