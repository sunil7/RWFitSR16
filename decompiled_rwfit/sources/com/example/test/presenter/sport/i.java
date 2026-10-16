package com.example.test.presenter.sport;

import com.example.test.ui.sport.activity.SportNewDetailJLActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class i implements w5.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f7607a;

    public i(l lVar) {
        this.f7607a = lVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportDetailPresenter", l0.j(i3, "SportControlCallback errorCode "));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        byte intValue;
        Integer num = (Integer) obj;
        if (num == null || (intValue = (byte) num.intValue()) == 1) {
            return;
        }
        l lVar = this.f7607a;
        if (intValue == 3) {
            ((i7.d) lVar.f7255a).getClass();
        } else if (intValue == 2) {
            ((i7.d) lVar.f7255a).getClass();
        } else if (intValue == 4) {
            ((SportNewDetailJLActivity) ((i7.d) lVar.f7255a)).R0();
        }
    }
}
