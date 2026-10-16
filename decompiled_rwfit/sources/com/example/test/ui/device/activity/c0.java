package com.example.test.ui.device.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.camera.core.impl.i1;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.blesdk.bean.function.ScheduleBean;
import com.example.test.R$drawable;
import com.example.test.R$mipmap;
import com.example.test.presenter.device.e1;
import com.example.test.ui.device.model.ScheduleModel;
import f6.q1;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final /* synthetic */ class c0 implements og.n, og.k, OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScheduleActivity f7850a;

    public /* synthetic */ c0(ScheduleActivity scheduleActivity) {
        this.f7850a = scheduleActivity;
    }

    @Override // og.n
    public void a(i1 i1Var, i1 i1Var2) {
        int i3 = ScheduleActivity.I;
        ScheduleActivity this$0 = this.f7850a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        og.o oVar = new og.o();
        oVar.f16946a = this$0.getResources().getDrawable(R$drawable.bg_right_red);
        oVar.f16949d = -1;
        oVar.f16948c = com.example.baselibrary.utils.b.f(this$0, 70.0f);
        oVar.f16947b = this$0.getResources().getDrawable(R$mipmap.ic_delect);
        i1Var2.b(oVar);
    }

    @Override // og.k
    public void d(og.m mVar, int i3) {
        int i10 = ScheduleActivity.I;
        ScheduleActivity this$0 = this.f7850a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        mVar.a();
        int scheduleId = ((ScheduleModel) this$0.R0().get(i3)).getScheduleId();
        this$0.R0().remove(i3);
        this$0.S0().notifyItemRemoved(i3);
        e1 e1Var = (e1) this$0.I0();
        if (scheduleId == -1) {
            e1Var.getClass();
        } else {
            ArrayList arrayList = e1Var.f7423b;
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                ScheduleBean scheduleBean = (ScheduleBean) obj;
                if (scheduleBean.getScheduleId() == scheduleId) {
                    arrayList.remove(scheduleBean);
                }
            }
            if (r5.b.k().f18054c) {
                x5.c b3 = x5.c.b();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getScheduleDCmdJL");
                b3.g((byte) -82, new byte[]{4, 3, 48, (byte) scheduleId}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -82);
            }
        }
        ((q1) this$0.f7247z.getValue()).f13257c.setItemViewCacheSize(this$0.R0().size());
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        int i10 = ScheduleActivity.I;
        ScheduleActivity this$0 = this.f7850a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        ScheduleModel model = (ScheduleModel) this$0.R0().get(i3);
        kotlin.jvm.internal.e.f(model, "model");
        Intent intent = new Intent(this$0, (Class<?>) ScheduleAddActivity.class);
        intent.putExtra("is_edit", true);
        intent.putExtra("schedule_position", i3);
        Bundle bundle = new Bundle();
        bundle.putSerializable(AeUtil.ROOT_DATA_PATH_OLD_NAME, model);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }
}
