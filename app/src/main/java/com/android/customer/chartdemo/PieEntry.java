package com.android.customer.chartdemo;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

/**
 * Description: ChartDemo
 * Created by gy(1984629668@qq.com)
 * Created Time on 2020/10/22 22:06
 */
public class PieEntry {

    /** 板块颜色*/
    private int color;

    /** 板块数据*/
    private float data;

    /** 板块文字*/
    private String msg;

    /** 该板块是否凸起*/
    private boolean isRaised;


    public PieEntry(float data, @NonNull String msg) {
        this.data = data;
        this.msg = msg;
    }

    public PieEntry(float data, @NonNull String msg, @ColorInt int color) {
        this.color = color;
        this.data = data;
        this.msg = msg;
    }

    public PieEntry(float data, @NonNull String msg, boolean isRaised) {
        this.data = data;
        this.msg = msg;
        this.isRaised = isRaised;
    }

    public PieEntry(float data, @NonNull String msg, @ColorInt int color, boolean isRaised) {
        this.color = color;
        this.data = data;
        this.msg = msg;
        this.isRaised = isRaised;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getData() {
        return data;
    }

    public void setData(float data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isRaised() {
        return isRaised;
    }

    public void setRaised(boolean raised) {
        isRaised = raised;
    }
}

