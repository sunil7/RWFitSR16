package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public abstract class SizeOverLife {

    @JBindingExclude
    protected final int TYPE_DEFAULT = -1;

    @JBindingExclude
    protected final int TYPE_CURVESIZEOVERLIFE = 0;
    protected int type = -1;

    @JBindingExclude
    public final int DEFAULT_SIZE = 0;

    public abstract float getSizeX(float f2);

    public abstract float getSizeY(float f2);

    public abstract float getSizeZ(float f2);
}
