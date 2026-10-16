package com.example.test.ui.device.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class AlarmJLActivity extends XXBaseActivity<com.example.test.presenter.device.b, f6.e> implements f7.a, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public int E;
    public final int F = 5;
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.AlarmJLActivity$data$2
        @Override // oh.a
        public final List<AlarmModel> invoke() {
            return new ArrayList();
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.AlarmJLActivity$alarmAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final AlarmAdapter invoke() {
            AlarmJLActivity alarmJLActivity = AlarmJLActivity.this;
            int i3 = AlarmJLActivity.I;
            return new AlarmAdapter(alarmJLActivity.S0());
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.b(this);
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
        ((com.example.test.presenter.device.b) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        this.E = !DateFormat.is24HourFormat(this) ? 1 : 0;
        b2.a(this);
        eh.b bVar = this.f7247z;
        ImageView imageView = ((f6.e) bVar.getValue()).f12811d.f8652a;
        if (imageView == null) {
            kotlin.jvm.internal.e.m("icRightIv");
            throw null;
        }
        imageView.setVisibility(8);
        ((f6.e) bVar.getValue()).f12811d.setOnTitleListener(new a2.d(this, 9));
        ((f6.e) bVar.getValue()).f12810c.setSwipeMenuCreator(new c(this));
        ((f6.e) bVar.getValue()).f12810c.setOnItemMenuClickListener(new c(this));
        ((f6.e) bVar.getValue()).f12810c.setLayoutManager(new LinearLayoutManager(1));
        SwipeRecyclerView swipeRecyclerView = ((f6.e) bVar.getValue()).f12810c;
        n.g0 g0Var = new n.g0(this);
        g0Var.e(getResources().getColor(R.color.transparent));
        g0Var.o(R$dimen.qb_px_10);
        swipeRecyclerView.g(g0Var.d());
        ((f6.e) bVar.getValue()).f12810c.setAdapter(R0());
        R0().setOnItemClickListener(new c(this));
        R0().setOnSwitchItemStatusListener(new c(this));
        ((f6.e) bVar.getValue()).f12809b.setOnClickListener(this);
    }

    public final AlarmAdapter R0() {
        return (AlarmAdapter) this.H.getValue();
    }

    public final List S0() {
        return (List) this.G.getValue();
    }

    public final int T0() {
        int[] iArr = new int[5];
        if (S0().size() > 0) {
            for (AlarmModel alarmModel : S0()) {
                if (alarmModel.getAlarmId() != -1) {
                    iArr[alarmModel.getAlarmId()] = 1;
                }
            }
        }
        for (int i3 = 0; i3 < 5; i3++) {
            if (iArr[i3] == 0) {
                return i3;
            }
        }
        return 0;
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
        boolean isEmpty = list.isEmpty();
        eh.b bVar = this.f7247z;
        if (!isEmpty) {
            ArrayList arrayList = (ArrayList) list;
            if (((AlarmModel) arrayList.get(0)).isDelete() || ((AlarmModel) arrayList.get(0)).isEdit()) {
                int alarmId = ((AlarmModel) arrayList.get(0)).getAlarmId();
                int size = S0().size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i3 = -1;
                        break;
                    } else if (alarmId == ((AlarmModel) S0().get(i3)).getAlarmId()) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 != -1) {
                    if (((AlarmModel) arrayList.get(0)).isDelete()) {
                        S0().remove(i3);
                        R0().notifyItemRemoved(i3);
                    } else {
                        S0().set(i3, arrayList.get(0));
                        R0().notifyItemChanged(i3);
                    }
                    ((f6.e) bVar.getValue()).f12810c.setItemViewCacheSize(S0().size());
                    ((com.example.test.presenter.device.b) I0()).m(S0());
                    return;
                }
                if (((AlarmModel) arrayList.get(0)).isEdit()) {
                    S0().add(arrayList.get(0));
                    R0().notifyItemInserted(S0().size() - 1);
                    ((f6.e) bVar.getValue()).f12810c.setItemViewCacheSize(S0().size());
                    ((com.example.test.presenter.device.b) I0()).m(S0());
                    return;
                }
            }
        }
        S0().clear();
        S0().addAll(list);
        if (((ArrayList) list).size() < this.F) {
            S0().add(new AlarmModel(true));
        }
        R0().notifyDataSetChanged();
        ((f6.e) bVar.getValue()).f12810c.setItemViewCacheSize(S0().size());
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
                alarmModel.setAlarmId(alarmRemainderBean.getAlarmId());
                alarmModel.setDelete(alarmRemainderBean.isDelete());
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
            com.example.test.presenter.device.b bVar = (com.example.test.presenter.device.b) I0();
            AlarmModel alarmModel2 = alarmEvent.getAlarmModel();
            kotlin.jvm.internal.e.e(alarmModel2, "getAlarmModel(...)");
            bVar.n(alarmModel2, S0());
            return;
        }
        alarmEvent.getAlarmModel().setOpen(true);
        List S02 = S0();
        int size = S0().size() - 1;
        AlarmModel alarmModel3 = alarmEvent.getAlarmModel();
        kotlin.jvm.internal.e.e(alarmModel3, "getAlarmModel(...)");
        S02.add(size, alarmModel3);
        R0().notifyItemInserted(S0().size() - 1);
        if (S0().size() - 1 >= this.F) {
            int size2 = S0().size() - 1;
            S0().remove(size2);
            R0().notifyItemRemoved(size2);
        }
        com.example.test.presenter.device.b bVar2 = (com.example.test.presenter.device.b) I0();
        AlarmModel alarmModel4 = alarmEvent.getAlarmModel();
        kotlin.jvm.internal.e.e(alarmModel4, "getAlarmModel(...)");
        List<AlarmModel> list = S0();
        bVar2.getClass();
        kotlin.jvm.internal.e.f(list, "list");
        ArrayList arrayList = bVar2.f7410b;
        arrayList.clear();
        for (AlarmModel alarmModel5 : list) {
            if (!alarmModel5.isAdd()) {
                AlarmRemainderBean alarmRemainderBean = new AlarmRemainderBean();
                alarmRemainderBean.setAlarmTag(alarmModel5.getAlarmTag());
                alarmRemainderBean.setRepeatModel(alarmModel5.getRepeatModel());
                alarmRemainderBean.setStartHour(alarmModel5.getStartHour());
                alarmRemainderBean.setStartMin(alarmModel5.getStartMin());
                alarmRemainderBean.setOpen(alarmModel5.isOpen());
                alarmRemainderBean.setAlarmId(alarmModel5.getAlarmId());
                arrayList.add(alarmRemainderBean);
            }
        }
        AlarmRemainderBean alarmRemainderBean2 = new AlarmRemainderBean();
        alarmRemainderBean2.setAlarmTag(alarmModel4.getAlarmTag());
        alarmRemainderBean2.setRepeatModel(alarmModel4.getRepeatModel());
        alarmRemainderBean2.setStartHour(alarmModel4.getStartHour());
        alarmRemainderBean2.setStartMin(alarmModel4.getStartMin());
        alarmRemainderBean2.setOpen(alarmModel4.isOpen());
        alarmRemainderBean2.setAlarmId(alarmModel4.getAlarmId());
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -34);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getAlarmACmdJL " + com.example.baselibrary.utils.b.z(alarmRemainderBean2));
        Calendar calendar = Calendar.getInstance();
        String format = new SimpleDateFormat("yy", Locale.getDefault()).format(Long.valueOf(calendar.getTimeInMillis()));
        kotlin.jvm.internal.e.e(format, "format(...)");
        int parseInt = Integer.parseInt(format);
        int i3 = calendar.get(2) + 1;
        int i10 = calendar.get(5);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(alarmRemainderBean2.isOpen() ? 1 : 0);
        sb2.append(Byte.valueOf((byte) alarmRemainderBean2.getRepeatModel()[0]));
        sb2.append(Byte.valueOf((byte) alarmRemainderBean2.getRepeatModel()[6]));
        sb2.append(Byte.valueOf((byte) alarmRemainderBean2.getRepeatModel()[5]));
        sb2.append(Byte.valueOf((byte) alarmRemainderBean2.getRepeatModel()[4]));
        sb2.append(Byte.valueOf((byte) alarmRemainderBean2.getRepeatModel()[3]));
        sb2.append(Byte.valueOf((byte) alarmRemainderBean2.getRepeatModel()[2]));
        sb2.append(Byte.valueOf((byte) alarmRemainderBean2.getRepeatModel()[1]));
        byte[] bArr = new byte[31];
        bArr[0] = 2;
        bArr[1] = 16;
        bArr[2] = 32;
        int alarmId = alarmRemainderBean2.getAlarmId();
        char[] cArr = y5.b.f20001a;
        bArr[3] = (byte) (alarmId & 255);
        bArr[4] = y5.b.b(sb2.toString());
        bArr[5] = (byte) parseInt;
        bArr[6] = (byte) i3;
        bArr[7] = (byte) i10;
        bArr[8] = (byte) (alarmRemainderBean2.getStartHour() & 255);
        bArr[9] = (byte) (alarmRemainderBean2.getStartMin() & 255);
        byte[] n4 = y5.b.n(alarmRemainderBean2.getAlarmTag());
        System.arraycopy(n4, 0, bArr, 10, n4.length <= 21 ? n4.length : 21);
        b3.g((byte) -34, bArr, new boolean[0]);
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
            alarmModel.setAlarmId(T0());
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
