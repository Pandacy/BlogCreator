package com.bc.springboot.model;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity(name="BlogLayout")
public class BlogLayout {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String font;

    private String color;

    private String fontSize;

    private String layoutStyle;

    @OneToOne
    @JoinColumn(name="blog_id")
    @RestResource(path = "blogLayout", rel="blog")
    private Blog blog;

    public BlogLayout(){

    }

    public BlogLayout(BlogLayout layout){
        this.id = layout.id;
        this.font = layout.font;
        this.color = layout.color;
        this.fontSize = layout.fontSize;
        this.layoutStyle = layout.layoutStyle;
        this.blog = layout.blog;
    }

    public BlogLayout(Integer id, String font, String color, String fontSize, String layoutStyle){
        this.id = id;
        this.font = font;
        this.color = color;
        this.fontSize = fontSize;
        this.layoutStyle = layoutStyle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.font = color;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getLayoutStyle() {
        return layoutStyle;
    }

    public void setLayoutStyle(String layoutStyle) {
        this.font = layoutStyle;
    }
}
