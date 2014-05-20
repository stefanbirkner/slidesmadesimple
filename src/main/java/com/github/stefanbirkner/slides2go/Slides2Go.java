package com.github.stefanbirkner.slides2go;

import static spark.Spark.get;

public class Slides2Go {
    public static void main(String... args) {
        get("/", (request, response) -> "Slides2Go");
    }
}
