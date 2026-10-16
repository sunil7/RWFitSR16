package com.example.test.ui.testui;

import android.content.Intent;
import android.widget.Toast;
import com.example.test.R$string;
import com.example.test.ui.device.activity.OtaActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.m1;
import com.google.android.gms.internal.mlkit_vision_barcode.x1;
import f6.u3;

/* loaded from: classes.dex */
public final class r implements t6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingDeviceFragment f8307a;

    public r(TRingDeviceFragment tRingDeviceFragment) {
        this.f8307a = tRingDeviceFragment;
    }

    @Override // t6.b
    public final void onCancel() {
    }

    @Override // t6.b
    public final void s() {
        if (System.currentTimeMillis() - x1.f9659a >= 1200 || System.currentTimeMillis() < x1.f9659a) {
            x1.f9659a = System.currentTimeMillis();
            boolean i3 = com.example.test.service.e.h().i();
            TRingDeviceFragment tRingDeviceFragment = this.f8307a;
            if (!i3 || !tRingDeviceFragment.f8219l) {
                Toast.makeText(tRingDeviceFragment.f0(), R$string.str_device_disconnected, 0).show();
                u3 u3Var = (u3) tRingDeviceFragment.f7251b;
                if (u3Var != null) {
                    u3Var.f13380b.setLinkedStatus(0);
                    return;
                }
                return;
            }
            if (tRingDeviceFragment.z0().getPower() < 30) {
                Toast.makeText(tRingDeviceFragment.f0(), R$string.str_ota_battery_limit30, 0).show();
                return;
            }
            Object obj = com.example.test.service.p0.f7741g;
            String downloadUrl = m1.a().d().getDownloadUrl();
            if (downloadUrl != null && downloadUrl.length() != 0) {
                tRingDeviceFragment.startActivity(new Intent(tRingDeviceFragment.f0(), (Class<?>) OtaActivity.class));
            } else {
                tRingDeviceFragment.V();
                m1.a().h(false);
            }
        }
    }
}
