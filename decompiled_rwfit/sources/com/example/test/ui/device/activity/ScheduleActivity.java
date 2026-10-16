package com.example.test.ui.device.activity;

import android.R;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.device.e1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.adapter.ScheduleAdapter;
import com.example.test.ui.device.model.ScheduleModel;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import f6.q1;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class ScheduleActivity extends XXBaseActivity<e1, q1> implements f7.w, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public int E;
    public final int F = 5;
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScheduleActivity$data$2
        @Override // oh.a
        public final List<ScheduleModel> invoke() {
            return new ArrayList();
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScheduleActivity$scheduleAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final ScheduleAdapter invoke() {
            ScheduleActivity scheduleActivity = ScheduleActivity.this;
            int i3 = ScheduleActivity.I;
            List data = scheduleActivity.R0();
            kotlin.jvm.internal.e.f(data, "data");
            return new ScheduleAdapter(R$layout.item_schedule, data);
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new e1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((q1) this.f7247z.getValue()).f13255a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_schedule, (ViewGroup) null, false);
        int i3 = R$id.addScheduleLl;
        LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
        if (linearLayout != null) {
            i3 = R$id.scheduleList;
            SwipeRecyclerView swipeRecyclerView = (SwipeRecyclerView) he.a(i3, inflate);
            if (swipeRecyclerView != null) {
                i3 = R$id.titleView;
                TitleView titleView = (TitleView) he.a(i3, inflate);
                if (titleView != null) {
                    return new q1((LinearLayout) inflate, linearLayout, swipeRecyclerView, titleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        e1 e1Var = (e1) I0();
        e1Var.getClass();
        com.google.android.gms.internal.mlkit_vision_common.p.U(e1Var);
        e1Var.f7425d = true;
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -82);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getScheduleDCmdJL");
        b3.g((byte) -82, new byte[]{4, 3, 48, (byte) 255}, new boolean[0]);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((q1) bVar.getValue()).f13258d.setOnTitleListener(new y2.f(this, 28));
        ((q1) bVar.getValue()).f13257c.setSwipeMenuCreator(new c0(this));
        ((q1) bVar.getValue()).f13257c.setOnItemMenuClickListener(new c0(this));
        ((q1) bVar.getValue()).f13257c.setLayoutManager(new LinearLayoutManager(1));
        he.b bVar2 = new he.b();
        bVar2.f14314a = (int) ((1.0f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
        bVar2.f14314a = (int) (10.0f * Resources.getSystem().getDisplayMetrics().density);
        bVar2.f14315b = getResources().getColor(R.color.transparent);
        bVar2.f14317d = new b9.a(9);
        bVar2.e = new b9.a(10);
        SwipeRecyclerView swipeRecyclerView = ((q1) bVar.getValue()).f13257c;
        oe.b bVar3 = new oe.b();
        bVar3.f16922a = bVar2;
        swipeRecyclerView.g(bVar3);
        ((q1) bVar.getValue()).f13257c.setAdapter(S0());
        S0().setOnItemClickListener(new c0(this));
        ((q1) bVar.getValue()).f13256b.setOnClickListener(this);
    }

    public final List R0() {
        return (List) this.G.getValue();
    }

    public final ScheduleAdapter S0() {
        return (ScheduleAdapter) this.H.getValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.addScheduleLl;
        if (valueOf != null && valueOf.intValue() == i3) {
            int size = R0().size();
            int i10 = this.F;
            if (size > 1 && ((ScheduleModel) R0().get(R0().size() - 1)).isAdd()) {
                i10++;
            }
            if (R0().size() >= i10) {
                Toast.makeText(this, R$string.str_schedule_item_max, 0).show();
                return;
            }
            ScheduleModel scheduleModel = new ScheduleModel(true);
            int[] iArr = new int[5];
            if (R0().size() > 0) {
                for (ScheduleModel scheduleModel2 : R0()) {
                    if (scheduleModel2.getScheduleId() != -1) {
                        iArr[scheduleModel2.getScheduleId()] = 1;
                    }
                }
            }
            int i11 = 0;
            while (true) {
                if (i11 >= 5) {
                    i11 = 0;
                    break;
                } else if (iArr[i11] == 0) {
                    break;
                } else {
                    i11++;
                }
            }
            scheduleModel.setScheduleId(i11);
            int size2 = R0().size() == 0 ? 0 : R0().size() - 1;
            Intent intent = new Intent(this, (Class<?>) ScheduleAddActivity.class);
            intent.putExtra("is_edit", false);
            intent.putExtra("schedule_position", size2);
            Bundle bundle = new Bundle();
            bundle.putSerializable(AeUtil.ROOT_DATA_PATH_OLD_NAME, scheduleModel);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        int i3 = !DateFormat.is24HourFormat(this) ? 1 : 0;
        if (this.E != i3) {
            this.E = i3;
            S0().notifyDataSetChanged();
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onScheduleEvent(EventBusBeans.ScheduleEvent scheduleEvent) {
        kotlin.jvm.internal.e.f(scheduleEvent, "scheduleEvent");
        if (scheduleEvent.isEdit()) {
            List R0 = R0();
            int position = scheduleEvent.getPosition();
            ScheduleModel scheduleModel = scheduleEvent.getScheduleModel();
            kotlin.jvm.internal.e.e(scheduleModel, "getScheduleModel(...)");
            R0.set(position, scheduleModel);
            S0().notifyItemChanged(scheduleEvent.getPosition());
            e1 e1Var = (e1) I0();
            ScheduleModel scheduleModel2 = scheduleEvent.getScheduleModel();
            kotlin.jvm.internal.e.e(scheduleModel2, "getScheduleModel(...)");
            e1Var.l(scheduleModel2, R0(), false);
            return;
        }
        List R02 = R0();
        int size = R0().size();
        ScheduleModel scheduleModel3 = scheduleEvent.getScheduleModel();
        kotlin.jvm.internal.e.e(scheduleModel3, "getScheduleModel(...)");
        R02.add(size, scheduleModel3);
        S0().notifyItemInserted(R0().size());
        if (R0().size() >= this.F) {
            int size2 = R0().size() - 1;
            R0().remove(size2);
            S0().notifyItemRemoved(size2);
        }
        e1 e1Var2 = (e1) I0();
        ScheduleModel scheduleModel4 = scheduleEvent.getScheduleModel();
        kotlin.jvm.internal.e.e(scheduleModel4, "getScheduleModel(...)");
        e1Var2.l(scheduleModel4, R0(), true);
    }
}
