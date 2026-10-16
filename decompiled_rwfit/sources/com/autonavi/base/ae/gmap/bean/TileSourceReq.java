package com.autonavi.base.ae.gmap.bean;

import android.support.v4.media.session.e;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class TileSourceReq {
    public int sourceType;

    /* renamed from: x, reason: collision with root package name */
    public int f6843x;

    /* renamed from: y, reason: collision with root package name */
    public int f6844y;
    public int zoom;

    @JBindingExclude
    public String toString() {
        StringBuilder sb2 = new StringBuilder("TileSourceReq{x=");
        sb2.append(this.f6843x);
        sb2.append(", y=");
        sb2.append(this.f6844y);
        sb2.append(", zoom=");
        sb2.append(this.zoom);
        sb2.append(", sourceId=");
        return e.m(sb2, this.sourceType, '}');
    }
}
