package com.example.test.ui.sport.fragment;

import android.os.Build;
import com.example.baselibrary.utils.d;
import com.example.test.R$string;
import com.example.test.ui.sport.activity.SportCountDownActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.s1;
import kotlin.jvm.internal.e;
import nd.b;
import v2.h;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8190a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SportTypeFragment f8191b;

    public /* synthetic */ a(SportTypeFragment sportTypeFragment, int i3) {
        this.f8190a = i3;
        this.f8191b = sportTypeFragment;
    }

    @Override // nd.b
    public final void h(boolean z5) {
        SportTypeFragment this$0 = this.f8191b;
        switch (this.f8190a) {
            case 0:
                if (!z5) {
                    d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i3 = SportCountDownActivity.I;
                    s1.a(this$0.f0(), this$0.q0() == 0 ? this$0.f8189d : this$0.q0());
                    break;
                }
            case 1:
                if (!z5) {
                    d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i10 = SportCountDownActivity.I;
                    s1.a(this$0.f0(), this$0.q0() == 0 ? this$0.f8189d : this$0.q0());
                    break;
                }
            case 2:
                if (!z5) {
                    d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i11 = SportCountDownActivity.I;
                    s1.a(this$0.f0(), this$0.q0() == 0 ? this$0.f8189d : this$0.q0());
                    break;
                }
            case 3:
                if (!z5) {
                    d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i12 = SportCountDownActivity.I;
                    s1.a(this$0.f0(), this$0.q0() == 0 ? this$0.f8189d : this$0.q0());
                    break;
                }
            case 4:
                e.f(this$0, "this$0");
                if (!z5) {
                    d.a(R$string.str_location_permission);
                    break;
                } else if (Build.VERSION.SDK_INT < 30) {
                    h hVar = new h(this$0.f0());
                    hVar.o("android.permission.ACTIVITY_RECOGNITION");
                    hVar.o("android.permission.BODY_SENSORS");
                    hVar.o("android.permission.WRITE_EXTERNAL_STORAGE");
                    hVar.p(new a(this$0, 8));
                    break;
                } else {
                    h hVar2 = new h(this$0.f0());
                    hVar2.o("android.permission.ACTIVITY_RECOGNITION");
                    hVar2.o("android.permission.BODY_SENSORS");
                    hVar2.p(new a(this$0, 7));
                    break;
                }
            case 5:
                e.f(this$0, "this$0");
                if (!z5) {
                    d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i13 = SportCountDownActivity.I;
                    s1.a(this$0.f0(), this$0.q0() == 0 ? this$0.f8189d : this$0.q0());
                    break;
                }
            case 6:
                e.f(this$0, "this$0");
                if (!z5) {
                    d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i14 = SportCountDownActivity.I;
                    s1.a(this$0.f0(), this$0.q0() == 0 ? this$0.f8189d : this$0.q0());
                    break;
                }
            case 7:
                e.f(this$0, "this$0");
                if (!z5) {
                    d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i15 = SportCountDownActivity.I;
                    s1.a(this$0.f0(), this$0.q0() == 0 ? this$0.f8189d : this$0.q0());
                    break;
                }
            default:
                e.f(this$0, "this$0");
                if (!z5) {
                    d.a(R$string.str_sport_permission);
                    break;
                } else {
                    int i16 = SportCountDownActivity.I;
                    s1.a(this$0.f0(), this$0.q0() == 0 ? this$0.f8189d : this$0.q0());
                    break;
                }
        }
    }
}
