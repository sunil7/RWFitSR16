package com.example.test.presenter.main;

import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.blesdk.bean.function.FirmVersionBean;
import com.example.database.table.Devices;
import com.example.test.ui.main.fragment.DeviceFragment;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class c0 implements v5.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f7501a;

    public c0(h0 h0Var) {
        this.f7501a = h0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "firmwareCallback errorCode "));
    }

    @Override // u5.g
    public final void c() {
        Log.e("qob", "FirmwareCallback");
    }

    @Override // u5.g
    public final void e(Object obj) {
        Devices c9;
        Devices c10;
        FirmVersionBean firmVersionBean = (FirmVersionBean) obj;
        Log.e("qob", "FirmwareCallback onResult screenType " + (firmVersionBean != null ? Integer.valueOf(firmVersionBean.getScreenType()) : null));
        if (firmVersionBean != null) {
            h0 h0Var = this.f7501a;
            if (y5.d.f20005b) {
                DialInfoBean dialInfoBean = new DialInfoBean();
                dialInfoBean.setDialType(firmVersionBean.getScreenType());
                dialInfoBean.setWidth(firmVersionBean.getScreenWidth());
                dialInfoBean.setHeight(firmVersionBean.getScreenHeight());
                ((DeviceFragment) ((g7.k) h0Var.f7255a)).n0(dialInfoBean);
                com.example.baselibrary.utils.b.x(dialInfoBean, new oh.l() { // from class: com.example.test.presenter.main.DevicePresenter$firmwareCallback$2$1$onResult$1$1$1
                    @Override // oh.l
                    public final DialInfoBean invoke(DialInfoBean dialInfo) {
                        kotlin.jvm.internal.e.f(dialInfo, "dialInfo");
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        if (kVar != null) {
                            kVar.T(dialInfo);
                        }
                        return dialInfo;
                    }
                }, new oh.l() { // from class: com.example.test.presenter.main.DevicePresenter$firmwareCallback$2$1$onResult$1$1$2
                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((DialInfoBean) obj2);
                        return eh.g.f12633a;
                    }

                    public final void invoke(DialInfoBean it) {
                        kotlin.jvm.internal.e.f(it, "it");
                        yh.d.b().e(new EventBusBeans.DeviceDialInfoEvent(it));
                    }
                });
            }
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
                    h0Var.getClass();
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
                        bVar.d(macAddress, deviceModel).subscribe(new v(h0Var, (FragmentActivity) ((DeviceFragment) ((g7.k) h0Var.f7255a)).f0(), com.example.test.utils.w0.d(), 0));
                    }
                }
            }
            ((g7.k) h0Var.f7255a).onAttachFirmware(firmVersionBean);
        }
    }
}
