package com.example.test.presenter.device;

import com.example.database.db.SettingImpl;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.test.ui.device.activity.MoreActivity;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;

/* loaded from: classes.dex */
public final class s0 implements w5.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t0 f7479a;

    public s0(t0 t0Var) {
        this.f7479a = t0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "DeviceControlCallback errorCode "));
    }

    @Override // u5.g
    public final void c() {
        Devices c9;
        String macAddress;
        User d5;
        t0 t0Var = this.f7479a;
        if (t0Var.f7484c != 2) {
            ((f7.r) t0Var.f7255a).getClass();
            return;
        }
        t0Var.f7484c = 0;
        com.example.test.utils.k a3 = y1.a();
        if (a3 != null) {
            a3.Q("");
        }
        com.example.test.utils.k a10 = y1.a();
        if (a10 != null && (c9 = a10.c()) != null && (macAddress = c9.getMacAddress()) != null) {
            com.example.test.utils.k a11 = y1.a();
            if (a11 != null) {
                a11.e0(macAddress, false);
            }
            com.example.test.utils.k a12 = y1.a();
            if (a12 != null) {
                a12.a0(macAddress, false);
            }
            com.example.test.utils.k a13 = y1.a();
            if (a13 != null) {
                a13.O(macAddress, false);
            }
            com.example.test.utils.k a14 = y1.a();
            if (a14 != null && (d5 = a14.d()) != null) {
                SettingImpl settingImpl = SettingImpl.INSTANCE;
                String userId = d5.getUserId();
                kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                settingImpl.clearData(userId, macAddress);
            }
        }
        ((MoreActivity) ((f7.r) t0Var.f7255a)).getClass();
        yh.d.b().e(new EventBusBeans.DeviceFunEvent(2));
        com.example.test.service.e.h().q();
    }

    @Override // u5.g
    public final /* bridge */ /* synthetic */ void e(Object obj) {
    }
}
