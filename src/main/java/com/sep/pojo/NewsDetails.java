package com.sep.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDetails {
    private int id;
    private String title;
    private String content;
    private String author;
    private Date time;
    private String type;

    public NewsDetails(String title, String content, String author, Date time, String type) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.time = time;
        this.type = type;
    }
}
