package com.king.camera.scan;

import a1.g;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.view.PreviewView;
import com.example.test.ui.testui.p;
import com.king.logx.LogX;
import de.o;
import f0.a;
import fe.d;
import fe.e;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import je.b;

/* loaded from: classes.dex */
public abstract class BaseCameraScanActivity<T> extends AppCompatActivity implements e {
    public d A;

    /* renamed from: y, reason: collision with root package name */
    public PreviewView f11391y;

    /* renamed from: z, reason: collision with root package name */
    public View f11392z;

    public abstract o G0();

    public int H0() {
        return R$layout.camera_scan;
    }

    public void I0(d dVar) {
        dVar.f13584i = G0();
        View view = this.f11392z;
        dVar.f13587l = view;
        b bVar = dVar.f13592q;
        if (bVar != null) {
            bVar.f15419d = view != null;
        }
        dVar.f13589n = this;
    }

    public void J0() {
        this.f11391y = (PreviewView) findViewById(R$id.previewView);
        int i3 = R$id.ivFlashlight;
        if (i3 != -1 && i3 != 0) {
            View findViewById = findViewById(i3);
            this.f11392z = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(new p(this, 1));
            }
        }
        d dVar = new d(this, this.f11391y);
        this.A = dVar;
        I0(dVar);
        K0();
    }

    public final void K0() {
        if (this.A != null) {
            if (g.a(this, "android.permission.CAMERA") != 0) {
                String[] strArr = {"android.permission.CAMERA"};
                LogX.d("requestPermissions: %s", Arrays.toString(strArr));
                y0.d.d(this, strArr, 134);
                return;
            }
            d dVar = this.A;
            he.b bVar = dVar.f13583h;
            ComponentActivity componentActivity = dVar.f13577a;
            if (bVar == null) {
                he.b bVar2 = new he.b();
                DisplayMetrics displayMetrics = componentActivity.getResources().getDisplayMetrics();
                int i3 = displayMetrics.widthPixels;
                int i10 = displayMetrics.heightPixels;
                LogX.d("displayMetrics: %dx%d", Integer.valueOf(i3), Integer.valueOf(i10));
                a aVar = a.f12636c;
                a aVar2 = a.f12635b;
                if (i3 < i10) {
                    float f2 = i10 / i3;
                    bVar2.f14314a = Math.min(i3, 1080);
                    if (Math.abs(f2 - 1.3333334f) < Math.abs(f2 - 1.7777778f)) {
                        bVar2.f14316c = aVar2;
                    } else {
                        bVar2.f14316c = aVar;
                    }
                    int i11 = bVar2.f14314a;
                    bVar2.f14317d = new Size(i11, Math.round(i11 * f2));
                    if (i3 > 1080) {
                        bVar2.f14315b = 1080;
                    } else {
                        bVar2.f14315b = Math.min(i3, 720);
                    }
                    int i12 = bVar2.f14315b;
                    bVar2.e = new Size(i12, Math.round(i12 * f2));
                } else {
                    bVar2.f14314a = Math.min(i10, 1080);
                    float f10 = i3 / i10;
                    if (Math.abs(f10 - 1.3333334f) < Math.abs(f10 - 1.7777778f)) {
                        bVar2.f14316c = aVar2;
                    } else {
                        bVar2.f14316c = aVar;
                    }
                    bVar2.f14317d = new Size(Math.round(bVar2.f14314a * f10), bVar2.f14314a);
                    if (i10 > 1080) {
                        bVar2.f14315b = 1080;
                    } else {
                        bVar2.f14315b = Math.min(i10, 720);
                    }
                    bVar2.e = new Size(Math.round(bVar2.f14315b * f10), bVar2.f14315b);
                }
                dVar.f13583h = bVar2;
            }
            x.b f11 = androidx.camera.lifecycle.e.f(componentActivity);
            dVar.f13581f = f11;
            f11.a(new androidx.activity.b(dVar, 25), g.c(componentActivity));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(H0());
        J0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        SensorManager sensorManager;
        d dVar = this.A;
        if (dVar != null) {
            dVar.f13585j = false;
            dVar.f13587l = null;
            b bVar = dVar.f13592q;
            if (bVar != null && (sensorManager = bVar.f15416a) != null && bVar.f15417b != null) {
                sensorManager.unregisterListener(bVar);
            }
            je.d dVar2 = dVar.f13591p;
            if (dVar2 != null) {
                dVar2.close();
            }
            ExecutorService executorService = dVar.f13580d;
            if (executorService != null) {
                executorService.shutdown();
            }
            x.b bVar2 = dVar.f13581f;
            if (bVar2 != null) {
                try {
                    ((androidx.camera.lifecycle.e) bVar2.get()).g();
                } catch (Exception e) {
                    LogX.e(e);
                }
            }
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        if (i3 == 134) {
            int length = strArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                if ("android.permission.CAMERA".equals(strArr[i10]) && iArr[i10] == 0) {
                    K0();
                    return;
                }
            }
            finish();
        }
    }
}
