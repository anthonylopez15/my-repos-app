package com.example.myrepos.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ReposDTO implements Serializable {
    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("language")
    private String mlanguage;

    @SerializedName("updated_at")
    private String mupdated;

    @SerializedName("stargazers_count")
    private String fav;

    @SerializedName("forks")
    private String mforks;

    @SerializedName("html_url")
    private String url;

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
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

    public String getMlanguage() {
        return mlanguage;
    }

    public void setMlanguage(String mlanguage) {
        this.mlanguage = mlanguage;
    }

    public String getMupdated() {
        return mupdated;
    }

    public void setMupdated(String mupdated) {
        this.mupdated = mupdated;
    }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    public String getMforks() {
        return mforks;
    }

    public void setMforks(String mforks) {
        this.mforks = mforks;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
