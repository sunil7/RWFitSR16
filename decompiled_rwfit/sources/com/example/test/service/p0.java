package com.example.test.service;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.example.database.table.Devices;
import com.example.network.bean.FirmwareInfoBean;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.model.EventBusBeans;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: g, reason: collision with root package name */
    public static final Object f7741g = kotlin.a.a(LazyThreadSafetyMode.NONE, new oh.a() { // from class: com.example.test.service.OTAService$Companion$service$2
        @Override // oh.a
        public final p0 invoke() {
            return new p0();
        }
    });

    /* renamed from: a, reason: collision with root package name */
    public boolean f7742a;

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f7743b = kotlin.a.b(new oh.a() { // from class: com.example.test.service.OTAService$firmInfo$2
        @Override // oh.a
        public final FirmwareInfoBean invoke() {
            return new FirmwareInfoBean();
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7744c = kotlin.a.b(new oh.a() { // from class: com.example.test.service.OTAService$callbacks$2
        @Override // oh.a
        public final List<Object> invoke() {
            return new ArrayList();
        }
    });

    /* renamed from: d, reason: collision with root package name */
    public com.example.test.ui.dialog.r f7745d;
    public final eh.b e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7746f;

    public p0() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.service.OTAService$otaStatusCallBack$2
            {
                super(0);
            }

            @Override // oh.a
            public final o0 invoke() {
                return new o0(p0.this);
            }
        });
        this.e = kotlin.a.b(new oh.a() { // from class: com.example.test.service.OTAService$firmwareCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final i0 invoke() {
                return new i0(p0.this);
            }
        });
    }

    public static final com.example.test.ui.dialog.r a(p0 p0Var) {
        synchronized (p0Var) {
            XXApplication xXApplication = XXApplication.f7400h;
            Activity c9 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c();
            if (c9 == null) {
                return null;
            }
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(c9);
            rVar.b(R$string.str_is_latest_version);
            rVar.setOnDialogListener(new com.google.android.gms.internal.mlkit_common.o(5));
            rVar.a();
            return rVar;
        }
    }

    public static final void b(p0 p0Var) {
        yh.d.b().e(new EventBusBeans.FirmwareEvent(11, p0Var.d()));
    }

    public static final void c(p0 p0Var) {
        com.example.test.ui.dialog.r rVar;
        if (p0Var.f7745d == null) {
            XXApplication xXApplication = XXApplication.f7400h;
            Activity c9 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c();
            if (c9 != null) {
                rVar = new com.example.test.ui.dialog.r(c9);
                rVar.b(R$string.str_new_version_found);
                rVar.setOnDialogListener(new androidx.appcompat.app.t(p0Var, 9));
            } else {
                rVar = null;
            }
            p0Var.f7745d = rVar;
        }
        try {
            com.example.test.ui.dialog.r rVar2 = p0Var.f7745d;
            if (rVar2 != null) {
                rVar2.show();
            }
        } catch (Throwable th2) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("show hid dialog ", th2.getMessage()));
            p0Var.f7745d = null;
        }
    }

    public final FirmwareInfoBean d() {
        return (FirmwareInfoBean) this.f7743b.getValue();
    }

    public final void e() {
        Devices c9;
        i();
        XXApplication xXApplication = XXApplication.f7400h;
        Context applicationContext = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getApplicationContext();
        if (applicationContext != null) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar == null || (c9 = kVar.c()) == null) {
                return;
            }
            com.example.test.utils.a a3 = com.google.android.gms.internal.mlkit_vision_barcode.u1.a(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getApplicationContext());
            c6.b bVar = c6.b.f3390c;
            String fromVersion = d().getFromVersion();
            kotlin.jvm.internal.e.e(fromVersion, "getFromVersion(...)");
            String macAddress = c9.getMacAddress();
            kotlin.jvm.internal.e.e(macAddress, "getMacAddress(...)");
            String str = a3.f8718a;
            kotlin.jvm.internal.e.e(str, "getVersionName(...)");
            bVar.e(fromVersion, macAddress, str).subscribe(new j0(applicationContext, this, com.example.test.utils.w0.d()));
        }
    }

    public final void f() {
        Devices c9;
        Log.e("qob", "getJLOTAFailedFirmwareInfo");
        i();
        XXApplication xXApplication = XXApplication.f7400h;
        Context applicationContext = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getApplicationContext();
        if (applicationContext != null) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar == null || (c9 = kVar.c()) == null) {
                return;
            }
            com.example.test.utils.a a3 = com.google.android.gms.internal.mlkit_vision_barcode.u1.a(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getApplicationContext());
            c6.b bVar = c6.b.f3390c;
            String macAddress = c9.getMacAddress();
            kotlin.jvm.internal.e.e(macAddress, "getMacAddress(...)");
            String str = a3.f8718a;
            kotlin.jvm.internal.e.e(str, "getVersionName(...)");
            bVar.e("", macAddress, str).subscribe(new m0(applicationContext, this, com.example.test.utils.w0.d()));
        }
    }

    public final void g(String str) {
        Log.e("qob", "getJLOTAFailedFirmwareInfoWithMac");
        i();
        XXApplication xXApplication = XXApplication.f7400h;
        com.example.test.utils.a a3 = com.google.android.gms.internal.mlkit_vision_barcode.u1.a(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getApplicationContext());
        c6.b bVar = c6.b.f3390c;
        String str2 = a3.f8718a;
        kotlin.jvm.internal.e.e(str2, "getVersionName(...)");
        bVar.e("", str, str2).subscribe(new n0(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getApplicationContext(), this, com.example.test.utils.w0.d()));
    }

    public final void h(boolean z5) {
        this.f7746f = z5;
        if (!e.h().i()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", "获取固件版本信息失败 设备未连接");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", "获取固件版本信息");
        com.google.android.gms.internal.mlkit_vision_common.p.U((i0) this.e.getValue());
        if (y5.d.f20005b) {
            com.google.android.gms.internal.mlkit_vision_common.p.h();
        } else if (r5.b.k().f18054c) {
            x5.d.c().j((byte) 0, new byte[0]);
        } else {
            x5.b.I0().F0((byte) 0);
        }
    }

    public final void i() {
        d().setToVersion("");
        d().setDownloadUrl("");
        d().setSize(0);
        d().setDeviceModel("");
        d().setSummary("");
    }
}
