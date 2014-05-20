package com.github.stefanbirkner.slides2go;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Slides2GoTest {

    @Test
    public void showsStartPage() throws Exception {
        new Slides2Go().main();
        WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage("http://127.0.0.1:4567/");
        assertThat(page.asText(), is(equalTo("Slides2Go")));
    }

    @Test
    public void showsGist() throws Exception {
        new Slides2Go().main();
        WebClient webClient = new WebClient();
        webClient.getPage("http://127.0.0.1:4567/slides/gist/stefanbirkner/6916058");
    }
}