package com.example.blesdk.bean.function;

/* loaded from: classes.dex */
public class MusicPushBean {
    private int attr;
    private String content;
    private int entity;

    public int getAttr() {
        return this.attr;
    }

    public String getContent() {
        return this.content;
    }

    public int getEntity() {
        return this.entity;
    }

    public void setAttr(int i3) {
        this.attr = i3;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEntity(int i3) {
        this.entity = i3;
    }

    public String toString() {
        return "entity " + this.entity + " attr " + this.attr + " content " + this.content;
    }
}
