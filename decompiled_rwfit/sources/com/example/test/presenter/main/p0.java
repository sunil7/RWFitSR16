package com.example.test.presenter.main;

import android.util.Log;
import com.example.test.R$string;
import com.example.test.ui.main.fragment.HeadsetFragment;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class p0 extends com.example.test.presenter.device.g {

    /* renamed from: d, reason: collision with root package name */
    public k6.b f7544d;
    public String e;

    /* renamed from: f, reason: collision with root package name */
    public String f7545f;

    @Override // com.example.test.presenter.device.g, com.example.baselibrary.preseneter.b
    public final void i() {
    }

    @Override // com.example.test.presenter.device.g
    public final void o() {
        HeadsetFragment headsetFragment = (HeadsetFragment) ((e7.a) this.f7255a);
        headsetFragment.b0();
        com.example.baselibrary.utils.d.a(R$string.str_download_fail);
        headsetFragment.q0().a().setEnable(true);
        headsetFragment.q0().a().setText(headsetFragment.getString(R$string.str_reinstall));
        headsetFragment.q0().dismiss();
    }

    @Override // com.example.test.presenter.device.g
    public final void p(float f2) {
        HeadsetFragment headsetFragment = (HeadsetFragment) ((e7.a) this.f7255a);
        String concat = String.format("%s: %.2f", Arrays.copyOf(new Object[]{headsetFragment.getString(R$string.str_downloading), Float.valueOf(f2)}, 2)).concat("%");
        headsetFragment.q0().a().setProgress(f2);
        headsetFragment.q0().a().setText(concat);
    }

    @Override // com.example.test.presenter.device.g
    public final void q(String str) {
        Log.e("qob", "onDownloadSuccess " + str);
        if (str == null || str.length() == 0) {
            o();
            return;
        }
        s(0.0f);
        com.example.test.service.e.h().f7682a = false;
        k6.b bVar = this.f7544d;
        if (bVar != null) {
            Log.e("qob", "otaFirmware");
            bVar.f17902g.f2679f = str;
            bVar.S(new o0((e7.a) this.f7255a));
        }
    }

    @Override // com.example.test.presenter.device.g
    public final void r(int i3) {
        ((HeadsetFragment) ((e7.a) this.f7255a)).a0(i3);
    }

    @Override // com.example.test.presenter.device.g
    public final void s(float f2) {
        ((HeadsetFragment) ((e7.a) this.f7255a)).E(f2);
    }

    @Override // com.example.test.presenter.device.g
    public final void t() {
        ((HeadsetFragment) ((e7.a) this.f7255a)).s();
    }
}
