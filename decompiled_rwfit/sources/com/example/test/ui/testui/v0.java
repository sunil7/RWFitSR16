package com.example.test.ui.testui;

import android.os.Build;
import com.example.test.R$id;

/* loaded from: classes.dex */
public final class v0 implements a7.f, t6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingSportTypeActivity f8321a;

    @Override // a7.f
    public void j(int i3) {
        if (i3 == R$id.barStatusIv) {
            this.f8321a.finish();
        }
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // t6.b
    public void s() {
        TRingSportTypeActivity tRingSportTypeActivity = this.f8321a;
        if (tRingSportTypeActivity.E != 4) {
            v2.h hVar = new v2.h(tRingSportTypeActivity);
            hVar.o("android.permission.ACCESS_COARSE_LOCATION");
            hVar.o("android.permission.ACCESS_FINE_LOCATION");
            hVar.o("android.permission.ACCESS_BACKGROUND_LOCATION");
            hVar.p(new u0(tRingSportTypeActivity, 4));
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            v2.h hVar2 = new v2.h(tRingSportTypeActivity);
            hVar2.o("android.permission.ACTIVITY_RECOGNITION");
            hVar2.o("android.permission.BODY_SENSORS");
            hVar2.p(new u0(tRingSportTypeActivity, 5));
            return;
        }
        v2.h hVar3 = new v2.h(tRingSportTypeActivity);
        hVar3.o("android.permission.ACTIVITY_RECOGNITION");
        hVar3.o("android.permission.BODY_SENSORS");
        hVar3.o("android.permission.WRITE_EXTERNAL_STORAGE");
        hVar3.p(new u0(tRingSportTypeActivity, 6));
    }
}
