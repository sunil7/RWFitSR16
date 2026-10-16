package com.example.test.ui.mine.activity;

import android.os.Environment;
import com.example.test.R$string;
import com.example.test.ui.view.ActionItemView;
import com.google.android.gms.internal.mlkit_vision_barcode.z1;
import f6.v1;

/* loaded from: classes.dex */
public final class w implements t6.b, a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SettingActivity f8152a;

    public /* synthetic */ w(SettingActivity settingActivity) {
        this.f8152a = settingActivity;
    }

    @Override // a7.e
    public void B() {
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // t6.b
    public void s() {
        SettingActivity settingActivity = this.f8152a;
        z1.a(settingActivity.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            z1.a(settingActivity.getExternalCacheDir());
        }
        int i3 = SettingActivity.H;
        ActionItemView actionItemView = ((v1) settingActivity.f7247z.getValue()).f13400d;
        String c9 = z1.c(settingActivity);
        kotlin.jvm.internal.e.e(c9, "getTotalCacheSize(...)");
        actionItemView.setHintStr(c9);
        settingActivity.w0(R$string.str_clear_cache_success);
    }

    @Override // a7.e
    public void u0() {
        this.f8152a.onBackPressed();
    }
}
