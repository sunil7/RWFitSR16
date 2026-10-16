package com.amap.api.maps.model.amap3dmodeltile;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class AMap3DTileBuildingMaterialOptions {
    public float metallicFactor;
    public float roughnessFactor;
    public String type;

    public AMap3DTileBuildingMaterialOptions(String str, float f2, float f10) {
        this.type = str;
        this.metallicFactor = f2;
        this.roughnessFactor = f10;
    }
}
