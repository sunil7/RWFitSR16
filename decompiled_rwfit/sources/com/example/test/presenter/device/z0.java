package com.example.test.presenter.device;

import android.util.Log;
import com.example.blesdk.bean.function.PowerBean;
import com.example.blesdk.service.PXIOtaService$PXI_CMD_FW;
import com.example.test.R$string;
import com.example.test.ui.device.activity.OtaActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.le;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.internal.http2.Settings;

/* loaded from: classes.dex */
public final class z0 extends g {

    /* renamed from: d, reason: collision with root package name */
    public k6.b f7499d;

    @Override // com.example.test.presenter.device.g, com.example.baselibrary.preseneter.b
    public final void i() {
        u();
        k6.b bVar = this.f7499d;
        if (bVar != null) {
            bVar.P();
        }
    }

    @Override // com.example.test.presenter.device.g
    public final void o() {
        OtaActivity otaActivity = (OtaActivity) ((f7.u) this.f7255a);
        otaActivity.E = false;
        otaActivity.b0();
        otaActivity.w0(R$string.str_download_fail);
        eh.b bVar = otaActivity.f7247z;
        ((f6.a1) bVar.getValue()).f12681b.setEnable(true);
        ((f6.a1) bVar.getValue()).f12681b.setText(otaActivity.getString(R$string.str_reinstall));
    }

    @Override // com.example.test.presenter.device.g
    public final void p(float f2) {
        OtaActivity otaActivity = (OtaActivity) ((f7.u) this.f7255a);
        String concat = String.format("%s: %.2f", Arrays.copyOf(new Object[]{otaActivity.getString(R$string.str_downloading), Float.valueOf(f2)}, 2)).concat("%");
        eh.b bVar = otaActivity.f7247z;
        ((f6.a1) bVar.getValue()).f12681b.setProgress(f2);
        ((f6.a1) bVar.getValue()).f12681b.setText(concat);
    }

    @Override // com.example.test.presenter.device.g
    public final void q(String str) {
        Log.e("qob", "onDownloadSuccess " + str);
        if (str == null || str.length() == 0) {
            o();
            return;
        }
        s(0.0f);
        if (y5.d.f20005b && !y5.d.f20006c) {
            k6.b bVar = this.f7499d;
            if (bVar != null) {
                Log.e("qob", "otaFirmware");
                bVar.f17902g.f2679f = str;
                bVar.S(new x0((f7.u) this.f7255a, this));
                return;
            }
            return;
        }
        if (!y5.d.f20006c) {
            e fileTransferCallback = l();
            kotlin.jvm.internal.e.f(fileTransferCallback, "fileTransferCallback");
            r5.c h4 = r5.c.h();
            CopyOnWriteArrayList copyOnWriteArrayList = h4.f18079f;
            copyOnWriteArrayList.size();
            if (!h4.k(fileTransferCallback)) {
                copyOnWriteArrayList.add(new WeakReference(fileTransferCallback));
            }
            if (!r5.b.k().f18054c) {
                r5.c.h().n(true, new byte[]{14, 2, -124});
                return;
            } else {
                if (str.length() == 0) {
                    return;
                }
                r5.c.h().u(5, str, "");
                return;
            }
        }
        if (y5.d.f20007d) {
            boolean z5 = com.example.blesdk.service.b0.f7293a;
            com.example.blesdk.service.b0.d(str, l());
            return;
        }
        int i3 = com.example.blesdk.service.b.f7281a;
        e callBack = l();
        kotlin.jvm.internal.e.f(callBack, "callBack");
        com.example.blesdk.service.b.f7292m = callBack;
        try {
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                e eVar = com.example.blesdk.service.b.f7292m;
                if (eVar == null) {
                    kotlin.jvm.internal.e.m("fileCallBack");
                    throw null;
                }
                eVar.a(11);
                System.out.println((Object) "The file does not exist or is not a valid file.");
                return;
            }
            byte[] a3 = le.a(file);
            com.example.blesdk.service.b.f7289j = a3;
            com.example.blesdk.service.b.f7288i = a3.length;
            int i10 = 0;
            for (byte b3 : a3) {
                i10 = (i10 + (b3 & 255)) & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            }
            com.example.blesdk.service.b.f7287h = i10;
            com.example.blesdk.service.b.e = 0;
            com.example.blesdk.service.b.f7285f = 0;
            com.example.blesdk.service.b.f7286g = 0;
            com.example.blesdk.service.b.f7283c = 0;
            com.example.blesdk.service.b.f7291l = new ArrayList();
            if (r5.b.k().f18054c) {
                byte code = (byte) PXIOtaService$PXI_CMD_FW.CMD_FW_OTA_INIT_NEW.getCode();
                int i11 = com.example.blesdk.service.b.f7288i;
                System.out.println((Object) "Init OTA NEW");
                com.example.blesdk.service.b.e(new byte[]{code, (byte) (i11 & 255), (byte) ((i11 >> 8) & 255), (byte) ((i11 >> 16) & 255), (byte) ((i11 >> 24) & 255)});
                return;
            }
            e eVar2 = com.example.blesdk.service.b.f7292m;
            if (eVar2 == null) {
                kotlin.jvm.internal.e.m("fileCallBack");
                throw null;
            }
            eVar2.a(12);
        } catch (IOException e) {
            e eVar3 = com.example.blesdk.service.b.f7292m;
            if (eVar3 == null) {
                kotlin.jvm.internal.e.m("fileCallBack");
                throw null;
            }
            eVar3.a(11);
            System.out.println((Object) ("An error occurred while reading the file: " + e.getMessage()));
        }
    }

    @Override // com.example.test.presenter.device.g
    public final void r(int i3) {
        OtaActivity otaActivity = (OtaActivity) ((f7.u) this.f7255a);
        otaActivity.E = false;
        otaActivity.runOnUiThread(new com.example.test.ui.device.activity.w(otaActivity, 1));
    }

    @Override // com.example.test.presenter.device.g
    public final void s(float f2) {
        ((OtaActivity) ((f7.u) this.f7255a)).E(f2);
    }

    @Override // com.example.test.presenter.device.g
    public final void t() {
        OtaActivity otaActivity = (OtaActivity) ((f7.u) this.f7255a);
        otaActivity.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OtaActivity", "-----固件安装成功----");
        otaActivity.runOnUiThread(new com.example.test.ui.device.activity.w(otaActivity, 0));
    }

    public final void w() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.OtaPresenter$getLocalPower$1
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
        }, new oh.l() { // from class: com.example.test.presenter.device.OtaPresenter$getLocalPower$2
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
                    OtaActivity otaActivity = (OtaActivity) ((f7.u) z0.this.f7255a);
                    otaActivity.getClass();
                    otaActivity.G = powerBean;
                }
            }
        });
    }
}
