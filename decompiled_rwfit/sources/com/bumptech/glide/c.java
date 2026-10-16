package com.bumptech.glide;

import androidx.camera.core.impl.g0;
import androidx.camera.core.impl.h0;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x.l;

/* loaded from: classes.dex */
public abstract class c {
    public static n0.i a(List list, androidx.camera.core.impl.utils.executor.b bVar, w.c cVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(x.i.d(((g0) it.next()).c()));
        }
        return ve.a(new h0(ve.a(new x.e(new l(new ArrayList(arrayList), false, a6.a()), cVar, 5000L)), bVar, list));
    }
}
