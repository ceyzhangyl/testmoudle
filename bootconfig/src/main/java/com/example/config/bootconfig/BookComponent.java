package com.example.config.bootconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties(prefix = "demo.book")
@Validated
public class BookComponent {

    /**
     * 书名
     */
    @NotEmpty
    private String name;
    /**
     * 作者
     */
    @NotNull
    private String Writer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }
}
