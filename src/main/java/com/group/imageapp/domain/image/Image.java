package com.group.imageapp.domain.image;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.boot.autoconfigure.domain.EntityScan;

public class Image {

    private long id;
    private String imgname;
    private String url;

    protected Image(){}


    public Image(long id, String imgname, String url){
        if(url == null || url.isBlank()){
            throw new IllegalArgumentException(String.format("빈 값"));
        }
        this.id = id;
        this.url = url;
        this.imgname = imgname;
    }

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Object getImgname() {
        return imgname;
    }
}
