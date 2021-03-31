package com.springprojects.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.springprojects.config.ArticleRouterConfig;


@Component
public class ArticleRouter extends RouteBuilder {

    @Value("${messageQueue}")
    private String messageQueue;

    @Override
    public void configure() throws Exception {

        from("jms:queue:" + messageQueue)
                .marshal().json(JsonLibrary.Jackson)
                .to(ArticleRouterConfig.ENDPOINT);
    }
}
