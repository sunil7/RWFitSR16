package com.example.test.ui.device.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.ce;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.king.mlkit.vision.barcode.QRCodeCameraScanActivity;
import java.util.List;
import java.util.WeakHashMap;
import l1.z0;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class ScanQrMlActivity extends QRCodeCameraScanActivity implements a7.e, View.OnClickListener {
    public static final /* synthetic */ int E = 0;
    public final eh.b B = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScanQrMlActivity$loadingDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.h invoke() {
            com.example.test.ui.dialog.h hVar = new com.example.test.ui.dialog.h(ScanQrMlActivity.this);
            hVar.c(8);
            return hVar;
        }
    });
    public final eh.b C = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScanQrMlActivity$gpsTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(ScanQrMlActivity.this);
            rVar.b(R$string.str_gps_open);
            rVar.setOnDialogListener(new a2.d(ScanQrMlActivity.this, 28));
            return rVar;
        }
    });
    public final eh.b D = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScanQrMlActivity$bleTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(ScanQrMlActivity.this);
            rVar.b(R$string.str_ble_open);
            rVar.setOnDialogListener(new androidx.appcompat.app.t(ScanQrMlActivity.this, 27));
            return rVar;
        }
    });

    @Override // a7.e
    public final void B() {
    }

    @Override // fe.e
    public final void C(fe.a result) {
        kotlin.jvm.internal.e.f(result, "result");
        this.A.f13585j = false;
        Object obj = result.f13574a;
        kotlin.jvm.internal.e.e(obj, "getResult(...)");
        List list = (List) obj;
        if (list.size() > 0) {
            Log.e("qob", "onScanResultCallback " + ((kc.a) list.get(0)).f15602a.o());
            String o3 = ((kc.a) list.get(0)).f15602a.o();
            if (o3 == null || o3.length() == 0) {
                com.example.baselibrary.utils.d.a(R$string.str_qr_code_error);
            } else {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScanQrCodeActivity", "扫描到内容 ".concat(o3));
                List u10 = kotlin.text.m.u(o3, new String[]{"?"});
                if (u10.size() >= 2) {
                    List u11 = kotlin.text.m.u((CharSequence) u10.get(1), new String[]{Const.STR_MART_ADD});
                    if (u11.size() >= 2) {
                        s5.a aVar = new s5.a();
                        if (kotlin.text.m.j((CharSequence) u11.get(0), "=", 0, false, 6) != -1) {
                            String substring = ((String) u11.get(0)).substring(kotlin.text.m.j((CharSequence) u11.get(0), "=", 0, false, 6) + 1, ((String) u11.get(0)).length());
                            kotlin.jvm.internal.e.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                            aVar.f18210a = substring;
                        }
                        if (kotlin.text.m.j((CharSequence) u11.get(1), "=", 0, false, 6) != -1) {
                            String substring2 = ((String) u11.get(1)).substring(kotlin.text.m.j((CharSequence) u11.get(1), "=", 0, false, 6) + 1, ((String) u11.get(1)).length());
                            kotlin.jvm.internal.e.e(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                            aVar.f18212c = kotlin.text.m.r(substring2, "-", ":");
                        }
                        if (!L0()) {
                            return;
                        }
                        yh.d.b().e(new EventBusBeans.DeviceConnectEvent());
                        com.example.test.service.e.h().c(aVar);
                    } else {
                        com.example.baselibrary.utils.d.a(R$string.str_qr_code_error);
                    }
                } else {
                    com.example.baselibrary.utils.d.a(R$string.str_qr_code_error);
                }
            }
            finish();
        }
    }

    @Override // com.king.mlkit.vision.barcode.BarcodeCameraScanActivity, com.king.camera.scan.BaseCameraScanActivity
    public final int H0() {
        return R$layout.activity_scan_qr_ml;
    }

    @Override // com.king.camera.scan.BaseCameraScanActivity
    public final void I0(fe.d dVar) {
        super.I0(dVar);
        je.d dVar2 = dVar.f13591p;
        if (dVar2 != null) {
            dVar2.f15423d = true;
        }
        if (dVar2 != null) {
            dVar2.e = true;
        }
        View view = this.f11392z;
        dVar.f13587l = view;
        je.b bVar = dVar.f13592q;
        if (bVar != null) {
            bVar.f15419d = view != null;
        }
    }

    @Override // com.king.mlkit.vision.barcode.BarcodeCameraScanActivity, com.king.camera.scan.BaseCameraScanActivity
    public final void J0() {
        super.J0();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R$id.rl_root);
        ce.a(getWindow());
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        b9.a aVar = new b9.a(7);
        WeakHashMap weakHashMap = z0.f15748a;
        l1.n0.u(relativeLayout, aVar);
        L0();
        ((ImageView) findViewById(R$id.back)).setOnClickListener(this);
    }

    public final boolean L0() {
        XXApplication xXApplication = XXApplication.f7400h;
        boolean d5 = com.example.test.utils.t.d(j1.a());
        boolean n4 = com.example.baselibrary.utils.b.n(j1.a());
        if (!n4) {
            ((com.example.test.ui.dialog.r) this.D.getValue()).show();
            return n4;
        }
        if (!d5) {
            ((com.example.test.ui.dialog.r) this.C.getValue()).show();
        }
        return d5;
    }

    public final com.example.test.ui.dialog.h M0() {
        return (com.example.test.ui.dialog.h) this.B.getValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        finish();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        int status = deviceStatusEvent.getStatus();
        if (status == 1) {
            Log.e("qob", "ScanQrCodeActivity DEVICE_CONNECTED");
            finish();
            return;
        }
        if (status != 2) {
            if (status == 3) {
                try {
                    M0().a(R$string.str_binding);
                    M0().c(0);
                    if (M0().isShowing()) {
                        return;
                    }
                    M0().show();
                    return;
                } catch (Throwable th2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScanQrCodeActivity", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("弹窗出错 ", th2.getLocalizedMessage()));
                    return;
                }
            }
            if (status == 4) {
                if (M0().isShowing()) {
                    M0().dismiss();
                }
            } else if (status != 5) {
                if (M0().isShowing()) {
                    M0().dismiss();
                }
            } else if (M0().isShowing()) {
                M0().dismiss();
            }
        }
    }
}
