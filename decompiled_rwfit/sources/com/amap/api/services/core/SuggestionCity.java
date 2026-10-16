package com.amap.api.services.core;

/* loaded from: classes.dex */
public class SuggestionCity {

    /* renamed from: a, reason: collision with root package name */
    private String f5978a;

    /* renamed from: b, reason: collision with root package name */
    private String f5979b;

    /* renamed from: c, reason: collision with root package name */
    private String f5980c;

    /* renamed from: d, reason: collision with root package name */
    private int f5981d;

    public SuggestionCity() {
    }

    public String getAdCode() {
        return this.f5980c;
    }

    public String getCityCode() {
        return this.f5979b;
    }

    public String getCityName() {
        return this.f5978a;
    }

    public int getSuggestionNum() {
        return this.f5981d;
    }

    public void setAdCode(String str) {
        this.f5980c = str;
    }

    public void setCityCode(String str) {
        this.f5979b = str;
    }

    public void setCityName(String str) {
        this.f5978a = str;
    }

    public void setSuggestionNum(int i3) {
        this.f5981d = i3;
    }

    public SuggestionCity(String str, String str2, String str3, int i3) {
        this.f5978a = str;
        this.f5979b = str2;
        this.f5980c = str3;
        this.f5981d = i3;
    }
}
