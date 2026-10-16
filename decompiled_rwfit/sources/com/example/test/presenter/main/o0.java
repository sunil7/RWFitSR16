package com.example.test.presenter.main;

import android.util.Log;
import com.example.test.ui.main.fragment.HeadsetFragment;

/* loaded from: classes.dex */
public final class o0 implements rd.d {

    /* renamed from: a, reason: collision with root package name */
    public final e7.a f7541a;

    public o0(e7.a view) {
        kotlin.jvm.internal.e.f(view, "view");
        this.f7541a = view;
    }

    @Override // rd.d
    public final void a(androidx.recyclerview.widget.x xVar) {
        Log.e("qob", "onError " + xVar);
        if (xVar != null) {
            ((HeadsetFragment) this.f7541a).a0(xVar.f2799c);
        }
    }

    @Override // rd.d
    public final void d() {
        Log.e("qob", "onStopOTA");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            kVar.V(false);
        }
        ((HeadsetFragment) this.f7541a).s();
    }

    @Override // rd.d
    public final void f(float f2, int i3) {
        if (i3 == 0) {
            ((HeadsetFragment) this.f7541a).u0(f2);
            return;
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null ? kotlin.jvm.internal.e.a(kVar.q(), Boolean.FALSE) : false) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            if (kVar2 != null) {
                kVar2.V(true);
            }
        }
        ((HeadsetFragment) this.f7541a).E(f2);
    }

    @Override // rd.d
    public final void h() {
        Log.e("qob", "onCancelOTA");
    }

    @Override // rd.d
    public final void s() {
        Log.e("qob", "onStartOTA");
        ((HeadsetFragment) this.f7541a).u0(0.0f);
    }

    @Override // rd.d
    public final void t(String str, boolean z5) {
        Log.e("qob", "onNeedReconnect " + z5);
    }
}
