package com.cereal.shine.utils;

import java.util.List;

public class Value {

    private String header;

    private List<String> content;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Value{" +
                "header='" + header + '\'' +
                ", content=" + content +
                '}';
    }
}
