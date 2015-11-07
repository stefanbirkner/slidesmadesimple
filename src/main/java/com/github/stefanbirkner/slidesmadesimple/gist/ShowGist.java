package com.github.stefanbirkner.slidesmadesimple.gist;

import com.github.stefanbirkner.jmarkdown2deckjs.Configuration;
import com.github.stefanbirkner.jmarkdown2deckjs.JMarkdown2DeckJs;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Shows a file from a gist.
 */
public class ShowGist implements Route {
    private static final GistSourceProvider GIST_SOURCE_PROVIDER = new GistSourceProvider();
    private static final JMarkdown2DeckJs TRANSFORMER = new JMarkdown2DeckJs(new Configuration("http://imakewebthings.com/deck.js/"));

    @Override
    public Object handle(Request request, Response response) {
        GistRequest gistRequest = new GistRequest(request.params(":user"), request.params(":id"));
        String markdown = GIST_SOURCE_PROVIDER.getSourceForRequest(gistRequest);
        return TRANSFORMER.convert(markdown);
    }
}
