package com.github.stefanbirkner.slidesmadesimple.gist;


/**
 * A request for a gist source.
 */
public class GistRequest {
    public final String user;
    public final String id;

    public GistRequest(String user, String id) {
        this.user = user;
        this.id = id;
    }
}
