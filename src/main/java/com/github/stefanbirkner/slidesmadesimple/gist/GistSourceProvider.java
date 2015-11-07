package com.github.stefanbirkner.slidesmadesimple.gist;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Provides a gist.
 */
public class GistSourceProvider {
    private static final String ENCODING = "UTF-8";

    public String getSourceForRequest(GistRequest request) {
        try {
            URL gist = new URL("https://gist.github.com/" + request.user + "/" + request.id + "/raw");
            return IOUtils.toString(gist, ENCODING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
