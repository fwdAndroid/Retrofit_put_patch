package com.example.retrofitput_patch;

import com.google.gson.annotations.SerializedName;

public class PutModal {
    String title;

    @SerializedName("data")
    public String bodyPost;



    json json;

    public String getTitle() {
        return title;
    }

    public String getBodyPost() {
        return bodyPost;
    }

    public com.example.retrofitput_patch.json getJson() {
        return json;
    }

    public PutModal(String title, String bodyPost) {
        this.title = title;
        this.bodyPost = bodyPost;
    }

}
