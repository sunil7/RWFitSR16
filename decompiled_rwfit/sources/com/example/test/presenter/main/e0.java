package com.example.test.presenter.main;

import com.example.blesdk.bean.function.PowerBean;
import com.example.test.ui.main.fragment.DeviceFragment;

/* loaded from: classes.dex */
public final class e0 implements v5.m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f7506a;

    public e0(h0 h0Var) {
        this.f7506a = h0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "powerCallback errorCode "));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        PowerBean powerBean = (PowerBean) obj;
        if (powerBean != null) {
            h0 h0Var = this.f7506a;
            powerBean.toString();
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                kVar.S(powerBean);
            }
            ((DeviceFragment) ((g7.k) h0Var.f7255a)).E0(powerBean);
        }
    }
}
