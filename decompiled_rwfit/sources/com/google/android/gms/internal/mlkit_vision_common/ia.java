package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ia implements ha {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f9991a;

    public ia(Context context, ga gaVar) {
        ArrayList arrayList = new ArrayList();
        this.f9991a = arrayList;
        arrayList.add(new ka(context, gaVar));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.ha
    public final void a(ef.i iVar) {
        ArrayList arrayList = this.f9991a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((ha) obj).a(iVar);
        }
    }
}
