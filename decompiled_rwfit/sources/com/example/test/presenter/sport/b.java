package com.example.test.presenter.sport;

import com.example.test.service.r0;
import com.example.test.ui.sport.activity.SportDetailJLActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.n1;
import f6.b2;

/* loaded from: classes.dex */
public final class b implements w5.h {

    /* renamed from: a, reason: collision with root package name */
    public SportDetailJLActivity f7602a;

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
        eh.b bVar = this.f7602a.f7247z;
        if (intValue == 3) {
            ((b2) bVar.getValue()).f12727m.setVisibility(0);
            ((b2) bVar.getValue()).f12721g.setVisibility(0);
            ((b2) bVar.getValue()).f12723i.setVisibility(8);
            Object obj2 = r0.M;
            n1.a().f7774v = true;
            return;
        }
        if (intValue != 2) {
            if (intValue == 4) {
                Object obj3 = r0.M;
                n1.a().f();
                return;
            }
            return;
        }
        ((b2) bVar.getValue()).f12727m.setVisibility(8);
        ((b2) bVar.getValue()).f12721g.setVisibility(4);
        ((b2) bVar.getValue()).f12723i.setVisibility(0);
        Object obj4 = r0.M;
        r0 a3 = n1.a();
        a3.f7774v = false;
        a3.J = 0;
        a3.L = false;
    }
}
