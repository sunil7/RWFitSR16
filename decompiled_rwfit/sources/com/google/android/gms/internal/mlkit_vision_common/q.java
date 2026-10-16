package com.google.android.gms.internal.mlkit_vision_common;

import android.graphics.Rect;

/* loaded from: classes.dex */
public abstract class q {
    public static Rect a(wf.b bVar, wf.a aVar) {
        int round;
        int i3 = bVar.f19627a;
        float c9 = aVar.c();
        int i10 = bVar.f19627a;
        int i11 = bVar.f19628b;
        float abs = Math.abs(c9 - wf.a.a(i10, i11).c());
        int i12 = 0;
        if (abs <= 5.0E-4f) {
            return new Rect(0, 0, i3, i11);
        }
        if (wf.a.a(i3, i11).c() > aVar.c()) {
            int round2 = Math.round(aVar.c() * i11);
            int round3 = Math.round((i3 - round2) / 2.0f);
            i3 = round2;
            round = 0;
            i12 = round3;
        } else {
            int round4 = Math.round(i3 / aVar.c());
            round = Math.round((i11 - round4) / 2.0f);
            i11 = round4;
        }
        return new Rect(i12, round, i3 + i12, i11 + round);
    }
}
