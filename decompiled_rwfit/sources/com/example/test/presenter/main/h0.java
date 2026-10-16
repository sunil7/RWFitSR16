package com.example.test.presenter.main;

import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.example.blesdk.bean.function.BrightScreenLedBean;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.blesdk.bean.function.FirmVersionBean;
import com.example.blesdk.bean.function.PowerBean;
import com.example.database.table.Devices;
import com.example.network.api.DeviceApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.DeviceModelInfoBean;
import com.example.network.bean.DialBean;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.main.fragment.DeviceFragment;
import java.util.List;

/* loaded from: classes.dex */
public final class h0 extends com.example.baselibrary.preseneter.b implements v5.c {

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7511b;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7512c;

    /* renamed from: d, reason: collision with root package name */
    public final eh.b f7513d;
    public final eh.b e;

    /* renamed from: f, reason: collision with root package name */
    public final eh.b f7514f;

    /* renamed from: g, reason: collision with root package name */
    public final eh.b f7515g;

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f7516h;

    /* renamed from: i, reason: collision with root package name */
    public final eh.b f7517i;

    /* renamed from: j, reason: collision with root package name */
    public int f7518j;

    /* renamed from: k, reason: collision with root package name */
    public final eh.b f7519k;

    /* renamed from: l, reason: collision with root package name */
    public final eh.b f7520l;

    public h0(DeviceFragment deviceFragment) {
        super(deviceFragment);
        this.f7511b = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.DevicePresenter$dateFormatCallback$2
            @Override // oh.a
            public final w invoke() {
                return new w();
            }
        });
        this.f7512c = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.DevicePresenter$firmwareCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final c0 invoke() {
                return new c0(h0.this);
            }
        });
        this.f7513d = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.DevicePresenter$powerCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final e0 invoke() {
                return new e0(h0.this);
            }
        });
        kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.DevicePresenter$dialInfoCallbackJL$2
            {
                super(0);
            }

            @Override // oh.a
            public final a0 invoke() {
                return new a0(h0.this);
            }
        });
        this.e = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.DevicePresenter$dialInfoCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final z invoke() {
                return new z(h0.this);
            }
        });
        this.f7514f = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.DevicePresenter$switchStatusCallback$2
            @Override // oh.a
            public final f0 invoke() {
                return new f0();
            }
        });
        this.f7515g = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.DevicePresenter$findDeviceControlCallback$2
            @Override // oh.a
            public final b0 invoke() {
                return new b0();
            }
        });
        this.f7516h = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.DevicePresenter$deviceControlCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final x invoke() {
                return new x(h0.this);
            }
        });
        this.f7517i = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.DevicePresenter$deviceUnbindControlCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final y invoke() {
                return new y(h0.this);
            }
        });
        this.f7519k = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.DevicePresenter$wearHandCallback$2
            @Override // oh.a
            public final g0 invoke() {
                return new g0();
            }
        });
        this.f7520l = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.main.DevicePresenter$VideoHidCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final u invoke() {
                return new u(h0.this);
            }
        });
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScreenLedLightPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "亮屏等级错误，错误代码"));
        ((XXBaseFragment) ((g7.k) this.f7255a)).b0();
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        BrightScreenLedBean brightScreenLedBean = (BrightScreenLedBean) obj;
        if (brightScreenLedBean != null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScreenLedLightPresenter", String.valueOf(brightScreenLedBean));
            ((DeviceFragment) ((g7.k) this.f7255a)).getClass();
        }
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        com.google.android.gms.internal.mlkit_vision_common.p.d((c0) this.f7512c.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((e0) this.f7513d.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((z) this.e.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((f0) this.f7514f.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((b0) this.f7515g.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((x) this.f7516h.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((y) this.f7517i.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((w) this.f7511b.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d(this);
        com.google.android.gms.internal.mlkit_vision_common.p.d((g0) this.f7519k.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((u) this.f7520l.getValue());
    }

    public final void k() {
        Devices c9;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (c9 = kVar.c()) == null) {
            return;
        }
        c6.b bVar = c6.b.f3390c;
        String macAddress = c9.getMacAddress();
        kotlin.jvm.internal.e.e(macAddress, "getMacAddress(...)");
        bVar.getClass();
        rg.l<HttpModel<List<DialBean>>> dialList = ((DeviceApi) bVar.f113a).getDialList(macAddress);
        kotlin.jvm.internal.e.e(dialList, "getDialList(...)");
        com.example.baselibrary.utils.b.w(dialList).subscribe(new v(this, (FragmentActivity) ((DeviceFragment) ((g7.k) this.f7255a)).f0(), com.example.test.utils.w0.d(), 1));
    }

    public final void l() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.DevicePresenter$getLocalPower$1
            @Override // oh.l
            public final PowerBean invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    return kVar.k();
                }
                return null;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.DevicePresenter$getLocalPower$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PowerBean) obj);
                return eh.g.f12633a;
            }

            public final void invoke(PowerBean powerBean) {
                if (powerBean != null) {
                    ((DeviceFragment) ((g7.k) h0.this.f7255a)).E0(powerBean);
                }
            }
        });
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.DevicePresenter$getLocalDialInfo$1
            @Override // oh.l
            public final DialInfoBean invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    return kVar.n();
                }
                return null;
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.DevicePresenter$getLocalDialInfo$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DialInfoBean) obj);
                return eh.g.f12633a;
            }

            public final void invoke(DialInfoBean dialInfoBean) {
                if (dialInfoBean != null) {
                    ((DeviceFragment) ((g7.k) h0.this.f7255a)).n0(dialInfoBean);
                }
            }
        });
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.main.DevicePresenter$getLocalVersion$1
            @Override // oh.l
            public final String invoke(String it) {
                Devices c9;
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar == null || (c9 = kVar.c()) == null) {
                    return null;
                }
                return c9.getDeviceVer();
            }
        }, new oh.l() { // from class: com.example.test.presenter.main.DevicePresenter$getLocalVersion$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return eh.g.f12633a;
            }

            public final void invoke(String str) {
                if (str != null) {
                    h0 h0Var = h0.this;
                    FirmVersionBean firmVersionBean = new FirmVersionBean();
                    firmVersionBean.setDeviceNo(str);
                    ((g7.k) h0Var.f7255a).onAttachFirmware(firmVersionBean);
                }
            }
        });
    }

    public final void m(String str) {
        Log.e("qob", "getModelInfo ".concat(str));
        rg.l<HttpModel<DeviceModelInfoBean>> modelInfo = ((DeviceApi) c6.b.f3390c.f113a).getModelInfo(str);
        kotlin.jvm.internal.e.e(modelInfo, "getModelInfo(...)");
        com.example.baselibrary.utils.b.w(modelInfo).subscribe(new d0(str, this, (FragmentActivity) ((DeviceFragment) ((g7.k) this.f7255a)).f0(), com.example.test.utils.w0.d(), 0));
    }

    public final void n() {
        ((XXBaseFragment) ((g7.k) this.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.U((y) this.f7517i.getValue());
        if (!y5.d.f20005b) {
            if (r5.b.k().f18054c) {
                x5.d.c().j((byte) 68, new byte[0]);
                return;
            } else {
                x5.b.I0().F0((byte) 68);
                return;
            }
        }
        com.google.android.gms.internal.mlkit_vision_common.p.X();
        Thread.sleep(2000L);
        ((XXBaseFragment) ((g7.k) this.f7255a)).b0();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            kVar.f0();
        }
        ((DeviceFragment) ((g7.k) this.f7255a)).F0();
        com.example.test.service.e.h().q();
    }

    public final void o() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "======== unbindLocal");
        com.example.test.service.e.h().q();
        ((DeviceFragment) ((g7.k) this.f7255a)).F0();
    }
}
