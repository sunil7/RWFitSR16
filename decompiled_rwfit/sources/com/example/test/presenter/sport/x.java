package com.example.test.presenter.sport;

import com.example.test.R$string;
import com.example.test.ui.sport.activity.SportSettingActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class x implements w5.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f7636a;

    public x(y yVar) {
        this.f7636a = yVar;
    }

    @Override // w5.c
    public final void a(int i3) {
        y yVar = this.f7636a;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, yVar.f7637b, l0.j(i3, "运动目标设置失败："));
        ((SportSettingActivity) ((i7.i) yVar.f7255a)).onBackPressed();
    }

    @Override // w5.c
    public final void c() {
        y yVar = this.f7636a;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, yVar.f7637b, "运动目标设置成功");
        SportSettingActivity sportSettingActivity = (SportSettingActivity) ((i7.i) yVar.f7255a);
        sportSettingActivity.w0(R$string.str_save_success);
        sportSettingActivity.onBackPressed();
    }
}
