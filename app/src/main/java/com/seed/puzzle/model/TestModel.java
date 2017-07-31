package com.seed.puzzle.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Seed
 * @date: 2017-07-31 10:55
 */


public class TestModel implements Serializable{
    private String content;
    private List<String> urls = new ArrayList<>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
