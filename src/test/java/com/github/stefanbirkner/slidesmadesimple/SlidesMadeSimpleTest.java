package com.github.stefanbirkner.slidesmadesimple;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SlidesMadeSimpleTest {

    @Test
    public void showsStartPage() throws Exception {
        new SlidesMadeSimple().main();
        WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage("http://127.0.0.1:4567/");
        assertThat(page.asText(), containsString("Slides made Simple"));
    }

    @Test
    public void showsGist() throws Exception {
        new SlidesMadeSimple().main();
        WebClient webClient = new WebClient();
        webClient.getPage("http://127.0.0.1:4567/slides/gist/stefanbirkner/6916058");
    }

    @Test
    @Ignore
    public void createsZipForGist() throws Exception {
        new Slides2Go().main();
        WebClient webClient = new WebClient();
        webClient.getPage("http://127.0.0.1:4567/slides/gist/stefanbirkner/6916058.zip");
    }
}