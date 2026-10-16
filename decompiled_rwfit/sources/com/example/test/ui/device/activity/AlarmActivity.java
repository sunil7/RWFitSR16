package com.example.test.ui.device.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.example.blesdk.bean.function.AlarmRemainderBean;
import com.example.test.R$dimen;
import com.example.test.R$id;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.adapter.AlarmAdapter;
import com.example.test.ui.device.model.AlarmModel;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class AlarmActivity extends XXBaseActivity<com.example.test.presenter.device.c, f6.e> implements f7.a, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public int E;
    public final int F = 5;
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.AlarmActivity$data$2
        @Override // oh.a
        public final List<AlarmModel> invoke() {
            return new ArrayList();
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.AlarmActivity$alarmAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final AlarmAdapter invoke() {
            AlarmActivity alarmActivity = AlarmActivity.this;
            int i3 = AlarmActivity.I;
            return new AlarmAdapter(alarmActivity.S0());
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.c(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.e) this.f7247z.getValue()).f12808a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return f6.e.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.device.c) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        this.E = !DateFormat.is24HourFormat(this) ? 1 : 0;
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((f6.e) bVar.getValue()).f12811d.setOnTitleListener(new androidx.appcompat.app.t(this, 10));
        ((f6.e) bVar.getValue()).f12810c.setSwipeMenuCreator(new a(this));
        ((f6.e) bVar.getValue()).f12810c.setOnItemMenuClickListener(new a(this));
        ((f6.e) bVar.getValue()).f12810c.setLayoutManager(new LinearLayoutManager(1));
        SwipeRecyclerView swipeRecyclerView = ((f6.e) bVar.getValue()).f12810c;
        n.g0 g0Var = new n.g0(this);
        g0Var.e(getResources().getColor(R.color.transparent));
        g0Var.o(R$dimen.qb_px_10);
        swipeRecyclerView.g(g0Var.d());
        ((f6.e) bVar.getValue()).f12810c.setAdapter(R0());
        R0().setOnItemClickListener(new a(this));
        R0().setOnSwitchItemStatusListener(new a(this));
        ((f6.e) bVar.getValue()).f12809b.setOnClickListener(this);
    }

    public final AlarmAdapter R0() {
        return (AlarmAdapter) this.H.getValue();
    }

    public final List S0() {
        return (List) this.G.getValue();
    }

    @Override // f7.a
    public final void a() {
        com.example.baselibrary.utils.d.a(R$string.str_save_success);
        onBackPressed();
    }

    @Override // f7.a
    public final void b() {
        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
    }

    @Override // f7.a
    public final void d(List list) {
        S0().clear();
        S0().addAll(list);
        if (((ArrayList) list).size() < this.F) {
            S0().add(new AlarmModel(true));
        }
        R0().notifyDataSetChanged();
        ((f6.e) this.f7247z.getValue()).f12810c.setItemViewCacheSize(S0().size());
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onAlarmChangeEvent(EventBusBeans.AlarmChangeEvent alarmChangeEvent) {
        kotlin.jvm.internal.e.f(alarmChangeEvent, "alarmChangeEvent");
        List<AlarmRemainderBean> alarmRemainderBeans = alarmChangeEvent.getAlarmRemainderBeans();
        if (alarmRemainderBeans != null) {
            ArrayList arrayList = new ArrayList();
            for (AlarmRemainderBean alarmRemainderBean : alarmRemainderBeans) {
                AlarmModel alarmModel = new AlarmModel();
                alarmModel.setAlarmTag(alarmRemainderBean.getAlarmTag());
                alarmModel.setRepeatModel(alarmRemainderBean.getRepeatModel());
                alarmModel.setStartHour(alarmRemainderBean.getStartHour());
                alarmModel.setStartMin(alarmRemainderBean.getStartMin());
                alarmModel.setOpen(alarmRemainderBean.isOpen());
                arrayList.add(alarmModel);
            }
            d(arrayList);
        }
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
            return;
        }
        kotlin.jvm.internal.e.e(alarmEvent.getAlarmModel(), "getAlarmModel(...)");
        alarmEvent.getAlarmModel().setOpen(true);
        List S02 = S0();
        int size = S0().size() - 1;
        AlarmModel alarmModel2 = alarmEvent.getAlarmModel();
        kotlin.jvm.internal.e.e(alarmModel2, "getAlarmModel(...)");
        S02.add(size, alarmModel2);
        R0().notifyItemInserted(S0().size() - 1);
        if (S0().size() - 1 >= this.F) {
            int size2 = S0().size() - 1;
            S0().remove(size2);
            R0().notifyItemRemoved(size2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.addAlarmLl;
        if (valueOf != null && valueOf.intValue() == i3) {
            int size = S0().size();
            int i10 = this.F;
            if (size > 1 && ((AlarmModel) S0().get(S0().size() - 1)).isAdd()) {
                i10++;
            }
            if (S0().size() >= i10) {
                Toast.makeText(this, R$string.str_max_alarm_count, 0).show();
                return;
            }
            Calendar calendar = Calendar.getInstance();
            AlarmModel alarmModel = new AlarmModel(true);
            alarmModel.setRepeatModel(new int[7]);
            alarmModel.setStartHour(calendar.get(11));
            alarmModel.setStartMin(calendar.get(12));
            int size2 = S0().size() == 0 ? 0 : S0().size() - 1;
            Intent intent = new Intent(this, (Class<?>) AlarmAddActivity.class);
            intent.putExtra("is_edit", false);
            intent.putExtra("alarm_position", size2);
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
