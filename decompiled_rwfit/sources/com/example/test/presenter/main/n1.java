package com.example.test.presenter.main;

import com.example.test.ui.testui.TRingDeviceFragment;

/* loaded from: classes.dex */
public final class n1 implements v5.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r1 f7539a;

    public n1(r1 r1Var) {
        this.f7539a = r1Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "MuslimCountSwitchCallback errorCode "));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        Integer num = (Integer) obj;
        if (num != null) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                kVar.Z(num.intValue() > 0 ? 1 : 0);
            }
            ((TRingDeviceFragment) ((g7.z) this.f7539a.f7255a)).I0(num.intValue());
        }
    }
}
