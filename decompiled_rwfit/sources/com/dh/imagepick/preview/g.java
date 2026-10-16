package com.dh.imagepick.preview;

import a2.i;
import androidx.lifecycle.b0;
import androidx.lifecycle.m0;
import com.example.test.ui.device.activity.e0;
import com.google.android.gms.internal.mlkit_common.o;
import java.util.concurrent.atomic.AtomicBoolean;
import o2.m;

/* loaded from: classes.dex */
public final class g extends m0 {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.lifecycle.e f7142a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f7143b;

    public g() {
        e0 e0Var = new e0(new com.dh.imagepick.preview.adapter.a(), 19);
        m mVar = new m((byte) 0, 3, 1);
        w.a aVar = i.a.f14328d;
        i iVar = new i();
        iVar.f46j = e0Var;
        iVar.f47k = mVar;
        iVar.f39b = aVar;
        iVar.f41d = new AtomicBoolean(true);
        iVar.e = new AtomicBoolean(false);
        iVar.f42f = new androidx.activity.e(iVar, 4);
        iVar.f38a = aVar;
        iVar.f40c = new androidx.lifecycle.e(iVar);
        iVar.f45i = new o(1);
        androidx.lifecycle.e eVar = (androidx.lifecycle.e) iVar.f40c;
        kotlin.jvm.internal.e.b(eVar, "LivePagedListBuilder(thi…tor)\n            .build()");
        this.f7142a = eVar;
        this.f7143b = new b0();
    }
}
