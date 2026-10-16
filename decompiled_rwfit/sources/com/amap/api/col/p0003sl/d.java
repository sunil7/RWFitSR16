package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.f9;

/* loaded from: classes.dex */
final class d extends rc {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f3878a;

    public d(Context context) {
        this.f3878a = context;
    }

    @Override // com.amap.api.col.p0003sl.rc
    public void runTask() {
        f9.d dVar = f9.e;
        try {
            ea.a();
        } catch (Throwable unused) {
        }
        f9.f(this.f3878a);
        f9.t(this.f3878a);
    }
}
