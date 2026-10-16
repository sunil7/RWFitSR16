package com.jieli.bmp_convert;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class ConvertParam {
    public static final int FORMAT_ARGB_8565 = 1;
    public static final int FORMAT_ARGB_8888 = 2;
    public static final int FORMAT_AUTO = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f11384a = 1;

    public int getFormat() {
        return this.f11384a;
    }

    public ConvertParam setFormat(int i3) {
        this.f11384a = i3;
        return this;
    }

    public String toString() {
        return e.m(new StringBuilder("ConvertParam{format="), this.f11384a, '}');
    }
}
