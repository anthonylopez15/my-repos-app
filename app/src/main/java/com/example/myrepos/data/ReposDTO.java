package com.example.myrepos.data;

import com.google.gson.annotations.SerializedName;

public class ReposDTO {
    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;

    public ReposDTO(int id, String name) {
        this.mId = id;
        this.mName = name;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
