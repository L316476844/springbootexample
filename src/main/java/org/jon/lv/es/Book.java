package org.jon.lv.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * @Package org.jon.lv.es.Book
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/22 13:55
 * version V1.0.0
 */

// indexName 只能为小写 否则启动报错
@Document(indexName = "jon", type = "books")
public class Book {
    @Id
    private String id;
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
    private String author;
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String title;
    private String releaseDate;
    @Field(type= FieldType.Nested)
    private List<Tag> tags;

    public Book() {
    }

    public Book(String id, String title, String author, String releaseDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    //getters and setters

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}