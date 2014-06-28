package com.github.stefanbirkner.slides2go;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.contrib.java.lang.throwable.When.when;

public class Slides2GoTest {
    private final WebClient webClient = new WebClient();

    @Before
    public void runSlides2Go() {
        Slides2Go.main();
    }

    @Test
    public void showsStartPage() throws Exception {
        HtmlPage page = webClient.getPage("http://127.0.0.1:4567/");
        assertThat(page.asText(), is(equalTo("Slides2Go")));
    }

    @Test
    public void showsGist() throws Exception {
        webClient.getPage("http://127.0.0.1:4567/slides/gist/stefanbirkner/6916058");
    }

    @Test
    public void deliversCssFromWebjars() throws Exception {
        HtmlPage page = webClient.getPage("http://127.0.0.1:4567/webjars/modernizr/2.7.1/modernizr.js");
        assertThat(page.asText(), containsString("Modernizr"));
    }

    @Test
    public void returns404ForMissingWebjarsFiles() throws Exception {
        when(() -> webClient.getPage("http://127.0.0.1:4567/webjars/modernizr/2.7.1/does_not_exist"))
                .thenA(FailingHttpStatusCodeException.class)
                .isThrown();
    }
}