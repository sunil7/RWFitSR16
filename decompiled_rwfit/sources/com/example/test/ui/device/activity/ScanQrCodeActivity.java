package com.example.test.ui.device.activity;

import android.content.Context;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.bingoogolapple.qrcode.core.BarcodeType;
import com.bingoogolapple.qrcode.core.ScanBoxView;
import com.bingoogolapple.qrcode.zxing.ZXingView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import f6.o1;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class ScanQrCodeActivity extends XXBaseActivity<com.example.test.presenter.device.n, o1> implements p5.a, t3.d {
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScanQrCodeActivity$gpsTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(ScanQrCodeActivity.this);
            rVar.b(R$string.str_gps_open);
            rVar.setOnDialogListener(new a2.d(ScanQrCodeActivity.this, 27));
            return rVar;
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScanQrCodeActivity$bleTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(ScanQrCodeActivity.this);
            rVar.b(R$string.str_ble_open);
            rVar.setOnDialogListener(new androidx.appcompat.app.t(ScanQrCodeActivity.this, 26));
            return rVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.n(this, 3);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        RelativeLayout relativeLayout = ((o1) this.f7247z.getValue()).f13164a;
        kotlin.jvm.internal.e.e(relativeLayout, "getRoot(...)");
        return relativeLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_scan_qr_code, (ViewGroup) null, false);
        int i3 = R$id.titleView;
        TitleView titleView = (TitleView) he.a(i3, inflate);
        if (titleView != null) {
            i3 = R$id.zxingView;
            ZXingView zXingView = (ZXingView) he.a(i3, inflate);
            if (zXingView != null) {
                return new o1((RelativeLayout) inflate, titleView, zXingView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        R0();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ZXingView zXingView = ((o1) bVar.getValue()).f13166c;
        BarcodeType barcodeType = BarcodeType.ONLY_QR_CODE;
        zXingView.f6868j = barcodeType;
        if (barcodeType == BarcodeType.CUSTOM) {
            throw new RuntimeException("barcodeType 为 BarcodeType.CUSTOM 时 hintMap 不能为空");
        }
        zXingView.f();
        ((o1) bVar.getValue()).f13166c.setDelegate(this);
        ((o1) bVar.getValue()).f13165b.setOnTitleListener(new y2.f(this, 27));
    }

    public final boolean R0() {
        XXApplication xXApplication = XXApplication.f7400h;
        boolean d5 = com.example.test.utils.t.d(j1.a());
        boolean n4 = com.example.baselibrary.utils.b.n(j1.a());
        if (!n4) {
            ((com.example.test.ui.dialog.r) this.F.getValue()).show();
            return n4;
        }
        if (!d5) {
            ((com.example.test.ui.dialog.r) this.E.getValue()).show();
        }
        return d5;
    }

    public final void S0(String str) {
        Object systemService = getSystemService("vibrator");
        kotlin.jvm.internal.e.d(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService).vibrate(200L);
        if (str == null || str.length() == 0) {
            w0(R$string.str_qr_code_error);
        } else {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScanQrCodeActivity", "扫描到内容 ".concat(str));
            List u10 = kotlin.text.m.u(str, new String[]{"?"});
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
                    if (!R0()) {
                        return;
                    }
                    yh.d.b().e(new EventBusBeans.DeviceConnectEvent());
                    com.example.test.service.e.h().c(aVar);
                } else {
                    w0(R$string.str_qr_code_error);
                }
            } else {
                w0(R$string.str_qr_code_error);
            }
        }
        finish();
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        ZXingView zXingView = ((o1) this.f7247z.getValue()).f13166c;
        zXingView.i();
        zXingView.f6863d = null;
        super.onDestroy();
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
            if (status != 3) {
                if (status == 4) {
                    b0();
                    return;
                } else if (status != 5) {
                    b0();
                    return;
                } else {
                    b0();
                    return;
                }
            }
            try {
                P0().a(R$string.str_binding);
                P0().c(0);
                if (P0().isShowing()) {
                    return;
                }
                P0().show();
            } catch (Throwable th2) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScanQrCodeActivity", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("弹窗出错 ", th2.getLocalizedMessage()));
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        eh.b bVar = this.f7247z;
        ((o1) bVar.getValue()).f13166c.g();
        ZXingView zXingView = ((o1) bVar.getValue()).f13166c;
        zXingView.e = true;
        zXingView.g();
        if (zXingView.e && zXingView.f6861b.c()) {
            try {
                zXingView.f6860a.setOneShotPreviewCallback(zXingView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ScanBoxView scanBoxView = zXingView.f6862c;
        if (scanBoxView != null) {
            scanBoxView.setVisibility(0);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        ((o1) this.f7247z.getValue()).f13166c.i();
        super.onStop();
    }
}
