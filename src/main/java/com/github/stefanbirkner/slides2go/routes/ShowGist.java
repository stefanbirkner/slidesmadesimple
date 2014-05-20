package com.github.stefanbirkner.slides2go.routes;

import org.apache.commons.io.IOUtils;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.IOException;
import java.net.URL;

/**
 * Shows a file from a gist.
 */
public class ShowGist implements Route {
    @Override
    public Object handle(Request request, Response response) {
        String user = request.params(":user");
        String id = request.params(":id");
        return showGist(user, id);
    }

    private Object showGist(String user, String id) {
        try {
            URL gist = new URL("https://gist.github.com/" + user + "/" + id + "/raw");
            return IOUtils.toString(gist);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
