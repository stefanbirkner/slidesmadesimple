package com.github.stefanbirkner.slides2go.transformer;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MarkdownTransformerTest {
    private final MarkdownTransformer transformer = new MarkdownTransformer();

    @Test
    public void transformsMarkdownIntoHtml() {
        String html = transformer.transform("## headline\ndummy text");
        assertThat(html, is(equalTo("<!DOCTYPE html>\n<html><head></head><body><h2>headline</h2>\n<p>dummy text</p>\n</body></html>")));
    }
}