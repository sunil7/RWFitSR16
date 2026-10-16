package com.example.test.presenter.main;

import android.util.Log;
import com.example.blesdk.bean.function.FirmVersionBean;
import com.example.database.table.Devices;
import com.example.test.ui.testui.TRingDeviceFragment;

/* loaded from: classes.dex */
public final class m1 implements v5.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r1 f7535a;

    public m1(r1 r1Var) {
        this.f7535a = r1Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "firmwareCallback errorCode "));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        Devices c9;
        Devices c10;
        FirmVersionBean firmVersionBean = (FirmVersionBean) obj;
        Log.e("qob", "FirmwareCallback onResult screenType " + (firmVersionBean != null ? Integer.valueOf(firmVersionBean.getScreenType()) : null));
        if (firmVersionBean != null) {
            r1 r1Var = this.f7535a;
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null && (c9 = kVar.c()) != null) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", "固件版本信息：" + firmVersionBean.getDeviceNo() + " isNeedActive " + com.example.test.service.e.h().f7688h);
                c9.setDeviceVer(firmVersionBean.getDeviceNo());
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                if (kVar2 != null) {
                    kVar2.a(c9);
                }
                if (com.example.test.service.e.h().f7688h) {
                    r1Var.getClass();
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
                    if (kVar3 != null && (c10 = kVar3.c()) != null) {
                        String deviceModel = y5.d.f20005b ? c10.getDeviceModel() : firmVersionBean.getDeviceClazz();
                        c6.b bVar = c6.b.f3390c;
                        String macAddress = c10.getMacAddress();
                        kotlin.jvm.internal.e.e(macAddress, "getMacAddress(...)");
                        kotlin.jvm.internal.e.c(deviceModel);
                        bVar.d(macAddress, deviceModel).subscribe(new com.example.test.presenter.device.y(r1Var, ((TRingDeviceFragment) ((g7.z) r1Var.f7255a)).f0(), com.example.test.utils.w0.d(), 7));
                    }
                }
            }
            ((g7.z) r1Var.f7255a).onAttachFirmware(firmVersionBean);
        }
    }
}
