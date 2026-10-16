package com.example.test.ui.device.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.camera.core.impl.i1;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.test.R$drawable;
import com.example.test.R$mipmap;
import com.example.test.ui.device.model.AlarmModel;
import java.util.Calendar;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements og.n, og.k, OnItemClickListener, s6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlarmActivity f7844a;

    @Override // og.n
    public void a(i1 i1Var, i1 i1Var2) {
        int i3 = AlarmActivity.I;
        AlarmActivity this$0 = this.f7844a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        og.o oVar = new og.o();
        oVar.f16946a = this$0.getResources().getDrawable(R$drawable.bg_right_red);
        oVar.f16949d = -1;
        oVar.f16948c = com.example.baselibrary.utils.b.f(this$0, 70.0f);
        oVar.f16947b = this$0.getResources().getDrawable(R$mipmap.ic_delect);
        i1Var2.b(oVar);
    }

    @Override // s6.b
    public void c(int i3, boolean z5) {
        int i10 = AlarmActivity.I;
        AlarmActivity this$0 = this.f7844a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        if (i3 < 0 || i3 >= this$0.S0().size()) {
            return;
        }
        ((AlarmModel) this$0.S0().get(i3)).setOpen(z5);
    }

    @Override // og.k
    public void d(og.m mVar, int i3) {
        int i10 = AlarmActivity.I;
        AlarmActivity this$0 = this.f7844a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        mVar.a();
        int size = this$0.S0().size();
        this$0.S0().remove(i3);
        this$0.R0().notifyItemRemoved(i3);
        if (size == this$0.F && !((AlarmModel) this$0.S0().get(this$0.S0().size() - 1)).isAdd()) {
            this$0.S0().add(new AlarmModel(true));
            this$0.R0().notifyItemInserted(size);
        }
        ((f6.e) this$0.f7247z.getValue()).f12810c.setItemViewCacheSize(this$0.S0().size());
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        int i10 = AlarmActivity.I;
        AlarmActivity this$0 = this.f7844a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        AlarmModel alarmModel = (AlarmModel) this$0.S0().get(i3);
        if (i3 == this$0.S0().size() - 1) {
            Calendar calendar = Calendar.getInstance();
            alarmModel.setRepeatModel(new int[7]);
            alarmModel.setStartHour(calendar.get(11));
            alarmModel.setStartMin(calendar.get(12));
        }
        kotlin.jvm.internal.e.f(alarmModel, "alarmModel");
        Intent intent = new Intent(this$0, (Class<?>) AlarmAddActivity.class);
        intent.putExtra("is_edit", true);
        intent.putExtra("alarm_position", i3);
        Bundle bundle = new Bundle();
        bundle.putSerializable(AeUtil.ROOT_DATA_PATH_OLD_NAME, alarmModel);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }
}
