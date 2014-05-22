package com.github.stefanbirkner.slides2go.gist;

import com.github.stefanbirkner.slides2go.transformer.MarkdownTransformer;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Shows a file from a gist.
 */
public class ShowGist implements Route {
    private static final GistSourceProvider GIST_SOURCE_PROVIDER = new GistSourceProvider();
    private static final MarkdownTransformer TRANSFORMER = new MarkdownTransformer();

    @Override
    public Object handle(Request request, Response response) {
        GistRequest gistRequest = new GistRequest(request.params(":user"), request.params(":id"));
        String markdown = GIST_SOURCE_PROVIDER.getSourceForRequest(gistRequest);
        return TRANSFORMER.transform(markdown);
    }
}
