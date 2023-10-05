package com.group.imageapp.dto.image;

import org.springframework.beans.factory.annotation.Value;

public class ImageRequest {

    public final int num;
    public boolean random = false;

    public ImageRequest(int num, boolean random){
        this.num = num;
        this.random = random;
    }

    public int getNum(){
        return num;
    }
    public boolean getRandomOrNot(){
        return random;
    }
}
