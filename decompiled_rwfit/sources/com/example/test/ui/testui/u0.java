package com.example.test.ui.testui;

import android.content.Intent;
import android.os.Build;
import com.example.test.R$string;
import com.example.test.ui.sport.activity.SportCountDownActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.s1;

/* loaded from: classes.dex */
public final /* synthetic */ class u0 implements nd.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8316a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TRingSportTypeActivity f8317b;

    public /* synthetic */ u0(TRingSportTypeActivity tRingSportTypeActivity, int i3) {
        this.f8316a = i3;
        this.f8317b = tRingSportTypeActivity;
    }

    @Override // nd.b
    public final void h(boolean z5) {
        TRingSportTypeActivity this$0 = this.f8317b;
        switch (this.f8316a) {
            case 0:
                int i3 = TRingSportTypeActivity.G;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i10 = this$0.E;
                    Intent intent = new Intent(this$0, (Class<?>) SportCountDownActivity.class);
                    intent.putExtra("sport_type", i10);
                    this$0.startActivity(intent);
                    break;
                }
            case 1:
                int i11 = TRingSportTypeActivity.G;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i12 = this$0.E;
                    Intent intent2 = new Intent(this$0, (Class<?>) SportCountDownActivity.class);
                    intent2.putExtra("sport_type", i12);
                    this$0.startActivity(intent2);
                    break;
                }
            case 2:
                int i13 = TRingSportTypeActivity.G;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i14 = this$0.E;
                    Intent intent3 = new Intent(this$0, (Class<?>) SportCountDownActivity.class);
                    intent3.putExtra("sport_type", i14);
                    this$0.startActivity(intent3);
                    break;
                }
            case 3:
                int i15 = TRingSportTypeActivity.G;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i16 = this$0.E;
                    Intent intent4 = new Intent(this$0, (Class<?>) SportCountDownActivity.class);
                    intent4.putExtra("sport_type", i16);
                    this$0.startActivity(intent4);
                    break;
                }
            case 4:
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_location_permission);
                    break;
                } else if (Build.VERSION.SDK_INT < 30) {
                    v2.h hVar = new v2.h(this$0);
                    hVar.o("android.permission.ACTIVITY_RECOGNITION");
                    hVar.o("android.permission.BODY_SENSORS");
                    hVar.o("android.permission.WRITE_EXTERNAL_STORAGE");
                    hVar.p(new u0(this$0, 8));
                    break;
                } else {
                    v2.h hVar2 = new v2.h(this$0);
                    hVar2.o("android.permission.ACTIVITY_RECOGNITION");
                    hVar2.o("android.permission.BODY_SENSORS");
                    hVar2.p(new u0(this$0, 7));
                    break;
                }
            case 5:
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i17 = SportCountDownActivity.I;
                    s1.a(this$0, this$0.E);
                    break;
                }
            case 6:
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i18 = SportCountDownActivity.I;
                    s1.a(this$0, this$0.E);
                    break;
                }
            case 7:
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i19 = SportCountDownActivity.I;
                    s1.a(this$0, this$0.E);
                    break;
                }
            default:
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i20 = SportCountDownActivity.I;
                    s1.a(this$0, this$0.E);
                    break;
                }
        }
    }
}
