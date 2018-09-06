package com.hb.androidcontrols.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ControlsModelView implements Serializable {

    @SerializedName("Title")
    @Expose
    public String title;
    @SerializedName("ScreenName")
    @Expose
    public String screenName;
    @SerializedName("data")
    @Expose
    public List<ControlsModelView> data = null;

}