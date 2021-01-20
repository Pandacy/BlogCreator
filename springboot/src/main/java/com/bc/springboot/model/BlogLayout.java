package com.bc.springboot.model;

import javax.persistence.*;

@Entity(name="BlogLayout")
public class BlogLayout {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String font;

    private String color;

    private String fontSize;

    public BlogLayout(){

    }

    public BlogLayout(BlogLayout layout){
        this.id = layout.id;
        this.font = layout.font;
        this.color = layout.color;
        this.fontSize = layout.fontSize;
    }

    public BlogLayout(Integer id, String font, String color, String fontSize){
        this.id = id;
        this.font = font;
        this.color = color;
        this.fontSize = fontSize;
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
}
