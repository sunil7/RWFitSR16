package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class vf implements uf {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f9565a;

    public vf(Context context, tf tfVar) {
        ArrayList arrayList = new ArrayList();
        this.f9565a = arrayList;
        arrayList.add(new cg(context, tfVar));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.uf
    public final void a(androidx.appcompat.widget.b0 b0Var) {
        ArrayList arrayList = this.f9565a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((uf) obj).a(b0Var);
        }
    }
}
