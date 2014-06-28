package com.github.stefanbirkner.slides2go.webjars;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static spark.Spark.get;

public class WebjarsRouteTest {
    @Test
    public void servesWebjarsFile() throws Exception {
        get("/webjars/:library/:version/:file", new WebjarsRoute());
        WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage("http://127.0.0.1:4567/webjars/modernizr/2.7.1/modernizr.js");
        assertThat(page.asText(), containsString("Modernizr"));
    }
}