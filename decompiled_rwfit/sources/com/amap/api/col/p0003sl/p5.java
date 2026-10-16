package com.amap.api.col.p0003sl;

import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class p5 extends BaseOverlay {
    public p5(IGlOverlayLayer iGlOverlayLayer, o5 o5Var, String str) {
        super(str);
        new WeakReference(iGlOverlayLayer);
    }
}
