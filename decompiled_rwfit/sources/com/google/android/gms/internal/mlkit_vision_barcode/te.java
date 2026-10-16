package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class te {
    public static void a(androidx.camera.core.impl.k kVar, ArrayList arrayList) {
        if (kVar instanceof androidx.camera.core.impl.l) {
            ((androidx.camera.core.impl.l) kVar).getClass();
            throw null;
        }
        if (kVar instanceof n.x) {
            arrayList.add(((n.x) kVar).f16316a);
        } else {
            arrayList.add(new com.example.test.ui.view.b(kVar));
        }
    }
}
