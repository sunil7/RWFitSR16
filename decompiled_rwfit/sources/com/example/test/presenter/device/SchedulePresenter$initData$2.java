package com.example.test.presenter.device;

import com.example.blesdk.bean.function.ScheduleBean;
import com.example.database.table.DataSetting;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.ScheduleActivity;
import com.example.test.ui.device.model.ScheduleModel;
import f6.q1;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
final class SchedulePresenter$initData$2 extends Lambda implements oh.l {
    final /* synthetic */ e1 this$0;

    public static final class a extends bc.a<List<? extends ScheduleBean>> {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SchedulePresenter$initData$2(e1 e1Var) {
        super(1);
        this.this$0 = e1Var;
    }

    @Override // oh.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DataSetting) obj);
        return eh.g.f12633a;
    }

    public final void invoke(DataSetting dataSetting) {
        if (dataSetting != null) {
            e1 e1Var = this.this$0;
            List<ScheduleBean> h4 = com.example.baselibrary.utils.b.h(dataSetting.getDataValue(), new a().f3204b);
            kotlin.jvm.internal.e.e(h4, "fromJsonArray(...)");
            e1Var.f7423b.clear();
            e1Var.f7423b.addAll(h4);
            ArrayList arrayList = new ArrayList();
            for (ScheduleBean scheduleBean : h4) {
                ScheduleModel scheduleModel = new ScheduleModel();
                scheduleModel.setTime(scheduleBean.getTime());
                scheduleModel.setAdvance(scheduleBean.getAdvance());
                scheduleModel.setAdvanceIndex(scheduleBean.getAdvanceIndex());
                scheduleModel.setScheduleId(scheduleBean.getScheduleId());
                scheduleModel.setScheduleTitle(scheduleBean.getTitle());
                scheduleModel.setScheduleMsg(scheduleBean.getMessage());
                arrayList.add(scheduleModel);
            }
            ScheduleActivity scheduleActivity = (ScheduleActivity) ((f7.w) e1Var.f7255a);
            scheduleActivity.getClass();
            scheduleActivity.R0().clear();
            scheduleActivity.R0().addAll(arrayList);
            if (!arrayList.isEmpty()) {
                e1 e1Var2 = (e1) scheduleActivity.I0();
                e1Var2.getClass();
                ((XXBaseActivity) ((f7.w) e1Var2.f7255a)).V();
                e1Var2.f7424c = arrayList.size();
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ScheduleModel scheduleModel2 = (ScheduleModel) obj;
                    ScheduleBean scheduleBean2 = new ScheduleBean();
                    scheduleBean2.setTime(scheduleModel2.getTime());
                    scheduleBean2.setAdvance(scheduleModel2.getAdvance());
                    scheduleBean2.setAdvanceIndex(scheduleModel2.getAdvanceIndex());
                    scheduleBean2.setScheduleId(scheduleModel2.getScheduleId());
                    scheduleBean2.setTitle(scheduleModel2.getScheduleTitle());
                    scheduleBean2.setMessage(scheduleModel2.getScheduleMsg());
                    com.google.android.gms.internal.mlkit_vision_common.p.a(scheduleBean2);
                }
            }
            scheduleActivity.S0().notifyDataSetChanged();
            ((q1) scheduleActivity.f7247z.getValue()).f13257c.setItemViewCacheSize(scheduleActivity.R0().size());
        }
    }
}
