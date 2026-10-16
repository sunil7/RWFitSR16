package com.dh.imagepick.work;

import com.autonavi.base.ae.gmap.glyph.FontStyle;
import com.dh.imagepick.crop.CropImageView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7198a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f7199b = new ArrayList();

    public c(z4.c cVar) {
        this.f7198a = cVar;
    }

    public static f5.a a(c cVar) {
        cVar.getClass();
        f5.a aVar = new f5.a(cVar);
        aVar.f12665c = FontStyle.WEIGHT_SEMI_BOLD;
        aVar.f12666d = FontStyle.WEIGHT_SEMI_BOLD;
        aVar.e = CropImageView.Style.CIRCLE;
        aVar.f12664b = null;
        return aVar;
    }
}
