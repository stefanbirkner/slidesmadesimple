package com.github.stefanbirkner.slides2go.webjars;

import org.apache.commons.io.IOUtils;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class WebjarsRoute implements Route {

    @Override
    public Object handle(Request request, Response response) {
        InputStream file = getResourceForRequest(request);
        if (file == null)
            writeNotFoundToResponse(response);
        else
            writeFileToResponse(file, response);
        return null;
    }

    private InputStream getResourceForRequest(Request request) {
        return getClass().getResourceAsStream("/META-INF/resources" + request.pathInfo());
    }

    private void writeNotFoundToResponse(Response response) {
        response.status(404);
    }

    private void writeFileToResponse(InputStream file, Response response) {
        try {
            PrintWriter writer = response.raw().getWriter();
            IOUtils.copy(file, writer);
            writer.close();
            response.status(200);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
