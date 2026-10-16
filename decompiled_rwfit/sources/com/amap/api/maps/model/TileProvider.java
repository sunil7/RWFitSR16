package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public interface TileProvider {
    public static final Tile NO_TILE = Tile.obtain(-1, -1, null);

    @JBindingInclude
    Tile getTile(int i3, int i10, int i11);

    @JBindingInclude
    int getTileHeight();

    @JBindingInclude
    int getTileWidth();
}
