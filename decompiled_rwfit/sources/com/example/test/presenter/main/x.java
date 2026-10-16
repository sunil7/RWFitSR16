package com.example.test.presenter.main;

import com.example.database.db.SettingImpl;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.test.ui.main.fragment.DeviceFragment;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class x implements w5.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f7580a;

    public x(h0 h0Var) {
        this.f7580a = h0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "DeviceControlCallback errorCode "));
    }

    @Override // u5.g
    public final void c() {
        u5.c cVar;
        Devices c9;
        String macAddress;
        User d5;
        h0 h0Var = this.f7580a;
        if (h0Var.f7518j == 2) {
            h0Var.f7518j = 0;
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
            ((DeviceFragment) ((g7.k) h0Var.f7255a)).F0();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "======== deviceControlCallback");
            com.example.test.service.e.h().q();
            x5.b I0 = x5.b.I0();
            if (I0.J0(this)) {
                LinkedList linkedList = I0.f19795a;
                Iterator it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        cVar = null;
                        break;
                    }
                    cVar = (u5.c) it.next();
                    if (cVar != null && cVar.g() == this) {
                        break;
                    }
                }
                if (cVar == null) {
                    return;
                }
                linkedList.remove(cVar);
            }
        }
    }

    @Override // u5.g
    public final /* bridge */ /* synthetic */ void e(Object obj) {
    }
}
