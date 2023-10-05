package com.group.imageapp.dto.image.response;

import com.group.imageapp.domain.image.Image;

public class ImageResponse {
    private long id;
    private String imgname;
    private String url;

    public ImageResponse(long id, String imgname, String url){
        this.id = id;
        this.imgname = imgname;
        this.url = url;
    }

    public long getId(){
        return id;
    }

    public String getUrl(){
        return url;
    }

    public String getImgname(){return imgname;}
}
