package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class TileOverlaySource {

    @JBindingExclude
    public static int TILESOURCE_TYPE_FBO_TEXTURE = 4;

    @JBindingExclude
    public static int TILESOURCE_TYPE_IMAGE = 1;

    @JBindingExclude
    public static int TILESOURCE_TYPE_IMAGE_DEM = 3;

    @JBindingExclude
    public static int TILESOURCE_TYPE_VECTOR = 2;
    private String attribute;

    /* renamed from: id, reason: collision with root package name */
    private final int f5746id;
    private final int type;
    private final String url;
    private int minZoom = 3;
    private int maxZoom = 20;
    private boolean cacheEnabled = true;

    public TileOverlaySource(int i3, int i10, String str) {
        this.url = str;
        this.type = i10;
        this.f5746id = i3;
    }

    public int getId() {
        return this.f5746id;
    }

    public int getMaxZoom() {
        return this.maxZoom;
    }

    public int getMinZoom() {
        return this.minZoom;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isCacheEnabled() {
        return this.cacheEnabled;
    }

    public void setCacheEnabled(boolean z5) {
        this.cacheEnabled = z5;
    }

    public void setMaxZoom(int i3) {
        this.maxZoom = i3;
    }

    public void setMinZoom(int i3) {
        this.minZoom = i3;
    }
}
