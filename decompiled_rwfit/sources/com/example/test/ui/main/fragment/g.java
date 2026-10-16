package com.example.test.ui.main.fragment;

import android.content.Intent;
import android.widget.Toast;
import com.example.test.R$string;
import com.example.test.service.p0;
import com.example.test.ui.device.activity.OtaActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.m1;
import com.google.android.gms.internal.mlkit_vision_barcode.x1;

/* loaded from: classes.dex */
public final class g implements t6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeviceFragment f8107a;

    public g(DeviceFragment deviceFragment) {
        this.f8107a = deviceFragment;
    }

    @Override // t6.b
    public final void onCancel() {
    }

    @Override // t6.b
    public final void s() {
        if (System.currentTimeMillis() - x1.f9659a >= 1200 || System.currentTimeMillis() < x1.f9659a) {
            x1.f9659a = System.currentTimeMillis();
            boolean i3 = com.example.test.service.e.h().i();
            DeviceFragment deviceFragment = this.f8107a;
            if (!i3 || !deviceFragment.f8042d) {
                Toast.makeText(deviceFragment.f0(), R$string.str_device_disconnected, 0).show();
                return;
            }
            if (deviceFragment.u0().getPower() < 30) {
                Toast.makeText(deviceFragment.f0(), R$string.str_ota_battery_limit30, 0).show();
                return;
            }
            Object obj = p0.f7741g;
            String downloadUrl = m1.a().d().getDownloadUrl();
            if (downloadUrl != null && downloadUrl.length() != 0) {
                deviceFragment.startActivity(new Intent(deviceFragment.f0(), (Class<?>) OtaActivity.class));
            } else {
                deviceFragment.V();
                m1.a().h(false);
            }
        }
    }
}
