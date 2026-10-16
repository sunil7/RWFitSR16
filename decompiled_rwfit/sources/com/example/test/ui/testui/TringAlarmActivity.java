package com.example.test.ui.testui;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.example.test.R$dimen;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.adapter.AlarmRingAdapter;
import com.example.test.ui.device.model.AlarmModel;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import f6.i1;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TringAlarmActivity extends XXBaseActivity<com.example.test.presenter.device.b, i1> implements f7.a, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public int E;
    public final int F = 5;
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TringAlarmActivity$data$2
        @Override // oh.a
        public final List<AlarmModel> invoke() {
            return new ArrayList();
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TringAlarmActivity$alarmAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final AlarmRingAdapter invoke() {
            TringAlarmActivity tringAlarmActivity = TringAlarmActivity.this;
            int i3 = TringAlarmActivity.I;
            return new AlarmRingAdapter(tringAlarmActivity.S0());
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.b(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((i1) this.f7247z.getValue()).f12985a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_ring_alarm, (ViewGroup) null, false);
        int i3 = R$id.addAlarmLl;
        LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
        if (linearLayout != null) {
            i3 = R$id.alarmList;
            SwipeRecyclerView swipeRecyclerView = (SwipeRecyclerView) he.a(i3, inflate);
            if (swipeRecyclerView != null) {
                i3 = R$id.titleView;
                TitleView titleView = (TitleView) he.a(i3, inflate);
                if (titleView != null) {
                    return new i1((LinearLayout) inflate, linearLayout, swipeRecyclerView, titleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.device.b) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        this.E = !DateFormat.is24HourFormat(this) ? 1 : 0;
        b2.a(this);
        eh.b bVar = this.f7247z;
        ImageView imageView = ((i1) bVar.getValue()).f12988d.f8652a;
        if (imageView == null) {
            kotlin.jvm.internal.e.m("icRightIv");
            throw null;
        }
        imageView.setVisibility(8);
        ((i1) bVar.getValue()).f12988d.setOnTitleListener(new a1(this, 9));
        ((i1) bVar.getValue()).f12987c.setSwipeMenuCreator(new b1(this));
        ((i1) bVar.getValue()).f12987c.setOnItemMenuClickListener(new b1(this));
        ((i1) bVar.getValue()).f12987c.setLayoutManager(new LinearLayoutManager(1));
        SwipeRecyclerView swipeRecyclerView = ((i1) bVar.getValue()).f12987c;
        n.g0 g0Var = new n.g0(this);
        g0Var.e(getResources().getColor(R.color.transparent));
        g0Var.o(R$dimen.qb_px_10);
        swipeRecyclerView.g(g0Var.d());
        ((i1) bVar.getValue()).f12987c.setAdapter(R0());
        R0().setOnItemClickListener(new b1(this));
        R0().setOnSwitchItemStatusListener(new b1(this));
        ((i1) bVar.getValue()).f12986b.setOnClickListener(this);
    }

    public final AlarmRingAdapter R0() {
        return (AlarmRingAdapter) this.H.getValue();
    }

    public final List S0() {
        return (List) this.G.getValue();
    }

    @Override // f7.a
    public final void a() {
    }

    @Override // f7.a
    public final void b() {
        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
    }

    @Override // f7.a
    public final void d(List list) {
        S0().clear();
        S0().addAll(list);
        R0().notifyDataSetChanged();
        ((i1) this.f7247z.getValue()).f12987c.setItemViewCacheSize(S0().size());
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onAlarmEvent(EventBusBeans.AlarmEvent alarmEvent) {
        kotlin.jvm.internal.e.f(alarmEvent, "alarmEvent");
        if (alarmEvent.isEdit()) {
            List S0 = S0();
            int position = alarmEvent.getPosition();
            AlarmModel alarmModel = alarmEvent.getAlarmModel();
            kotlin.jvm.internal.e.e(alarmModel, "getAlarmModel(...)");
            S0.set(position, alarmModel);
            R0().notifyItemChanged(alarmEvent.getPosition());
            ((com.example.test.presenter.device.b) I0()).o(S0());
            return;
        }
        alarmEvent.getAlarmModel().setOpen(true);
        List S02 = S0();
        AlarmModel alarmModel2 = alarmEvent.getAlarmModel();
        kotlin.jvm.internal.e.e(alarmModel2, "getAlarmModel(...)");
        S02.add(alarmModel2);
        R0().notifyItemChanged(alarmEvent.getPosition());
        ((com.example.test.presenter.device.b) I0()).o(S0());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i10 = R$id.addAlarmLl;
        if (valueOf != null && valueOf.intValue() == i10) {
            if (S0().size() >= this.F) {
                Toast.makeText(this, R$string.str_max_alarm_count, 0).show();
                return;
            }
            Calendar calendar = Calendar.getInstance();
            AlarmModel alarmModel = new AlarmModel(true);
            alarmModel.setRepeatModel(new int[7]);
            alarmModel.setStartHour(calendar.get(11));
            alarmModel.setStartMin(calendar.get(12));
            if (S0().size() > 0) {
                i3 = 0;
                for (AlarmModel alarmModel2 : S0()) {
                    if (alarmModel2.getAlarmId() > i3) {
                        i3 = alarmModel2.getAlarmId();
                    }
                }
            } else {
                i3 = 0;
            }
            alarmModel.setAlarmId(i3 + 1);
            int size = S0().size() == 0 ? 0 : S0().size() - 1;
            Intent intent = new Intent(this, (Class<?>) TringAlarmAddActivity.class);
            intent.putExtra("is_edit", false);
            intent.putExtra("alarm_position", size);
            Bundle bundle = new Bundle();
            bundle.putSerializable(AeUtil.ROOT_DATA_PATH_OLD_NAME, alarmModel);
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
            R0().notifyDataSetChanged();
        }
    }
}
