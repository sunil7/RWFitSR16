package com.example.baselibrary.preseneter;

import androidx.camera.lifecycle.d;
import eh.g;
import kotlin.jvm.internal.e;
import oh.l;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final p5.a f7255a;

    public b(p5.a baseView) {
        e.f(baseView, "baseView");
        this.f7255a = baseView;
    }

    public static void j(Object obj, l runBlock, final l backBlock) {
        e.f(runBlock, "runBlock");
        e.f(backBlock, "backBlock");
        rg.l create = rg.l.create(new a(runBlock, obj, 0));
        e.e(create, "create(...)");
        com.example.baselibrary.utils.b.t(create).subscribe(new d(new l() { // from class: com.example.baselibrary.preseneter.BasePresenter$startAsyncTask$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                m52invoke(obj2);
                return g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m52invoke(Object obj2) {
                l.this.invoke(obj2);
            }
        }, 4), new d(new l() { // from class: com.example.baselibrary.preseneter.BasePresenter$startAsyncTask$3
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((Throwable) obj2);
                return g.f12633a;
            }

            public final void invoke(Throwable th2) {
                new StringBuilder("startAsyncTask error : ").append(com.example.baselibrary.utils.b.z(th2));
            }
        }, 5));
    }

    public abstract void i();
}
