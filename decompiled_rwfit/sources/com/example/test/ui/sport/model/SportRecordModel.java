package com.example.test.ui.sport.model;

import h6.b;

/* loaded from: classes.dex */
public class SportRecordModel {
    private String date;
    private b detailBean;

    /* renamed from: id, reason: collision with root package name */
    private long f8192id;
    private boolean isExpand = true;
    private int type;

    public SportRecordModel(int i3) {
        this.type = i3;
    }

    public String getDate() {
        return this.date;
    }

    public b getDetailBean() {
        return this.detailBean;
    }

    public long getId() {
        return this.f8192id;
    }

    public int getType() {
        return this.type;
    }

    public boolean isExpand() {
        return this.isExpand;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDetailBean(b bVar) {
        this.detailBean = bVar;
    }

    public void setExpand(boolean z5) {
        this.isExpand = z5;
    }

    public void setId(long j4) {
        this.f8192id = j4;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public SportRecordModel(int i3, String str) {
        this.type = i3;
        this.date = str;
    }
}
