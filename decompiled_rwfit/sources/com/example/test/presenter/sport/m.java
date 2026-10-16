package com.example.test.presenter.sport;

import com.example.test.R$string;
import com.example.test.ui.sport.activity.SportNewRecordDetailActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class m implements w5.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f7619a;

    public m(o oVar) {
        this.f7619a = oVar;
    }

    @Override // w5.c
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportRecordDetailPresenter", l0.j(i3, "运动汇总数据传输失败 "));
        SportNewRecordDetailActivity sportNewRecordDetailActivity = (SportNewRecordDetailActivity) ((i7.e) this.f7619a.f7255a);
        sportNewRecordDetailActivity.R0().dismiss();
        sportNewRecordDetailActivity.w0(R$string.str_syncing_fail);
        sportNewRecordDetailActivity.J = false;
    }

    @Override // w5.c
    public final void c() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportRecordDetailPresenter", "运动汇总数据传输成功");
        SportNewRecordDetailActivity sportNewRecordDetailActivity = (SportNewRecordDetailActivity) ((i7.e) this.f7619a.f7255a);
        h6.b bVar = sportNewRecordDetailActivity.G;
        ArrayList arrayList = bVar != null ? bVar.f14275k : null;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportRecord", r5.a.d("地图数据是否为空 ", arrayList == null || arrayList.isEmpty()));
        h6.b bVar2 = sportNewRecordDetailActivity.G;
        ArrayList arrayList2 = bVar2 != null ? bVar2.f14275k : null;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            sportNewRecordDetailActivity.b0();
            sportNewRecordDetailActivity.J = false;
        } else {
            sportNewRecordDetailActivity.V();
            ((com.example.baselibrary.utils.e) sportNewRecordDetailActivity.E.getValue()).sendEmptyMessageDelayed(1, 1000L);
        }
    }
}
