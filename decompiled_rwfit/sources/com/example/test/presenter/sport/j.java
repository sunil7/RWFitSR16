package com.example.test.presenter.sport;

import com.example.blesdk.bean.sync.SportDataPushBean;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class j implements v5.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f7608a;

    public j(l lVar) {
        this.f7608a = lVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "sportCallback", l0.k(i3, "运动同步失败[", "]"));
        ((XXBaseActivity) ((i7.d) this.f7608a.f7255a)).b0();
    }

    @Override // u5.g
    public final void c() {
        ((XXBaseActivity) ((i7.d) this.f7608a.f7255a)).b0();
    }

    @Override // u5.g
    public final void e(Object obj) {
        SportDataPushBean data = (SportDataPushBean) obj;
        kotlin.jvm.internal.e.f(data, "data");
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "sportCallback", "运动同步成功 " + data);
        yh.d.b().e(new EventBusBeans.SportDataPushEvent(data));
        ((XXBaseActivity) ((i7.d) this.f7608a.f7255a)).b0();
    }
}
