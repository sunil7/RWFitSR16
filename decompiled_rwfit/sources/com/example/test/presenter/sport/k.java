package com.example.test.presenter.sport;

import com.example.blesdk.bean.sync.NewSportBean;
import com.example.test.ui.sport.activity.SportNewDetailJLActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class k implements v5.r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f7609a;

    public k(l lVar) {
        this.f7609a = lVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "sportCallback", l0.k(i3, "运动同步失败[", "]"));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        byte intValue;
        NewSportBean data = (NewSportBean) obj;
        kotlin.jvm.internal.e.f(data, "data");
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "sportGetControlCallback", "运动结果同步");
        Integer status = data.getStatus();
        if (status == null || (intValue = (byte) status.intValue()) == 1) {
            return;
        }
        l lVar = this.f7609a;
        if (intValue == 3) {
            ((i7.d) lVar.f7255a).getClass();
        } else if (intValue == 2) {
            ((i7.d) lVar.f7255a).getClass();
        } else if (intValue == 4) {
            ((SportNewDetailJLActivity) ((i7.d) lVar.f7255a)).R0();
        }
    }
}
