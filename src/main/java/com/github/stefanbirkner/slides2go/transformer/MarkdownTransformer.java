package com.github.stefanbirkner.slides2go.transformer;

import static com.github.rjeschke.txtmark.Processor.process;

/**
 * Transforms a markdown document into an HTML document.
 */
public class MarkdownTransformer {
    public String transform(String markdown) {
        String body = process(markdown);
        return "<!DOCTYPE html>\n<html><head></head><body>" + body + "</body></html>";
    }
}
