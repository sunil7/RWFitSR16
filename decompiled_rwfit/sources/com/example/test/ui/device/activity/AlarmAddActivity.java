package com.example.test.ui.device.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.model.AlarmModel;
import com.example.test.ui.mine.activity.InputActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.a2;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.material.timepicker.TimeModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class AlarmAddActivity extends XXBaseActivity<com.example.test.presenter.device.a, f6.d> implements p5.a, View.OnClickListener {
    public static final /* synthetic */ int N = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.AlarmAddActivity$alarmPosition$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = AlarmAddActivity.this.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra("alarm_position", 0) : -1);
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.AlarmAddActivity$alarmModel$2
        {
            super(0);
        }

        @Override // oh.a
        public final AlarmModel invoke() {
            Bundle extras;
            Intent intent = AlarmAddActivity.this.getIntent();
            Serializable serializable = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getSerializable(AeUtil.ROOT_DATA_PATH_OLD_NAME);
            kotlin.jvm.internal.e.d(serializable, "null cannot be cast to non-null type com.example.test.ui.device.model.AlarmModel");
            return (AlarmModel) serializable;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.AlarmAddActivity$isEdit$2
        {
            super(0);
        }

        @Override // oh.a
        public final Boolean invoke() {
            Intent intent = AlarmAddActivity.this.getIntent();
            return Boolean.valueOf(intent != null ? intent.getBooleanExtra("is_edit", false) : false);
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.AlarmAddActivity$opTime$2
        {
            super(0);
        }

        @Override // oh.a
        public final s3.d invoke() {
            AlarmAddActivity alarmAddActivity = AlarmAddActivity.this;
            alarmAddActivity.getClass();
            p3.a aVar = new p3.a(alarmAddActivity, new y(AlarmAddActivity.this, 1));
            AlarmAddActivity alarmAddActivity2 = AlarmAddActivity.this;
            alarmAddActivity2.getClass();
            Resources resources = alarmAddActivity2.getResources();
            aVar.f17450a.f17768v = resources != null ? resources.getColor(R.color.white) : -1;
            AlarmAddActivity alarmAddActivity3 = AlarmAddActivity.this;
            alarmAddActivity3.getClass();
            Resources resources2 = alarmAddActivity3.getResources();
            aVar.f17450a.f17767u = resources2 != null ? resources2.getColor(R$color.color_cfff) : -1;
            AlarmAddActivity alarmAddActivity4 = AlarmAddActivity.this;
            alarmAddActivity4.getClass();
            Resources resources3 = alarmAddActivity4.getResources();
            aVar.f17450a.f17769w = resources3 != null ? resources3.getColor(R$color.color_e8e8e8) : -7829368;
            aVar.f17450a.r = (ViewGroup) AlarmAddActivity.this.findViewById(R$id.decor);
            AlarmAddActivity alarmAddActivity5 = AlarmAddActivity.this;
            alarmAddActivity5.getClass();
            Resources resources4 = alarmAddActivity5.getResources();
            int color = resources4 != null ? resources4.getColor(R.color.transparent) : 0;
            q3.a aVar2 = aVar.f17450a;
            aVar2.f17766t = color;
            aVar2.f17770x = 1.8f;
            aVar.b(R$layout.view_time_select, new b9.a(3));
            return aVar.a();
        }
    });
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.AlarmAddActivity$timeFont$2
        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("AM");
            arrayList.add("PM");
            return arrayList;
        }
    });
    public final eh.b J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.AlarmAddActivity$hours$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<List<String>> invoke() {
            ArrayList arrayList = new ArrayList();
            AlarmAddActivity alarmAddActivity = AlarmAddActivity.this;
            int i3 = AlarmAddActivity.N;
            int size = ((List) alarmAddActivity.I.getValue()).size();
            for (int i10 = 0; i10 < size; i10++) {
                ArrayList arrayList2 = new ArrayList();
                for (int i11 = 1; i11 < 13; i11++) {
                    arrayList2.add(String.valueOf(i11));
                }
                arrayList.add(arrayList2);
            }
            return arrayList;
        }
    });
    public final eh.b K = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.AlarmAddActivity$hours24$2
        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 24; i3++) {
                arrayList.add(String.valueOf(i3));
            }
            return arrayList;
        }
    });
    public final eh.b L = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.AlarmAddActivity$mins24$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<List<String>> invoke() {
            ArrayList arrayList = new ArrayList();
            AlarmAddActivity alarmAddActivity = AlarmAddActivity.this;
            int i3 = AlarmAddActivity.N;
            int size = ((List) alarmAddActivity.K.getValue()).size();
            for (int i10 = 0; i10 < size; i10++) {
                ArrayList arrayList2 = new ArrayList();
                for (int i11 = 0; i11 < 60; i11++) {
                    arrayList2.add(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i11)}, 1)));
                }
                arrayList.add(arrayList2);
            }
            return arrayList;
        }
    });
    public final eh.b M = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.AlarmAddActivity$mins$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<List<List<String>>> invoke() {
            ArrayList arrayList = new ArrayList();
            AlarmAddActivity alarmAddActivity = AlarmAddActivity.this;
            int i3 = AlarmAddActivity.N;
            int size = ((List) alarmAddActivity.I.getValue()).size();
            AlarmAddActivity alarmAddActivity2 = AlarmAddActivity.this;
            for (int i10 = 0; i10 < size; i10++) {
                ArrayList arrayList2 = new ArrayList();
                int size2 = ((List) ((List) alarmAddActivity2.J.getValue()).get(0)).size();
                for (int i11 = 0; i11 < size2; i11++) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i12 = 0; i12 < 60; i12++) {
                        arrayList3.add(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i12)}, 1)));
                    }
                    arrayList2.add(arrayList3);
                }
                arrayList.add(arrayList2);
            }
            return arrayList;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.a(this, 0);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.d) this.f7247z.getValue()).f12771a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_alarm_add, (ViewGroup) null, false);
        int i3 = R$id.avRepeat;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.avTag;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.decor;
                if (((LinearLayout) he.a(i3, inflate)) != null) {
                    i3 = R$id.titleView;
                    TitleView titleView = (TitleView) he.a(i3, inflate);
                    if (titleView != null) {
                        return new f6.d((LinearLayout) inflate, actionItemView, actionItemView2, titleView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((f6.d) bVar.getValue()).f12774d.setOnTitleListener(new b(this));
        ((f6.d) bVar.getValue()).f12772b.setOnClickListener(this);
        ((f6.d) bVar.getValue()).f12773c.setOnClickListener(this);
        T0();
        ((f6.d) bVar.getValue()).f12772b.setHintStr(ca.f(this, R0().getRepeatModel()));
        ActionItemView actionItemView = ((f6.d) bVar.getValue()).f12773c;
        String alarmTag = ca.h(R0().getAlarmTag()) ? R0().getAlarmTag() : getString(R$string.str_alarm);
        kotlin.jvm.internal.e.c(alarmTag);
        actionItemView.setHintStr(alarmTag);
    }

    public final AlarmModel R0() {
        return (AlarmModel) this.F.getValue();
    }

    public final s3.d S0() {
        Object value = this.H.getValue();
        kotlin.jvm.internal.e.e(value, "getValue(...)");
        return (s3.d) value;
    }

    public final void T0() {
        if (DateFormat.is24HourFormat(this)) {
            S0().f((List) this.K.getValue(), (List) this.L.getValue(), null);
            s3.d S0 = S0();
            int startHour = R0().getStartHour();
            int startMin = R0().getStartMin();
            q3.a aVar = S0.e;
            aVar.f17752d = startHour;
            aVar.e = startMin;
            S0.e();
        } else {
            S0().f((List) this.I.getValue(), (List) this.J.getValue(), (List) this.M.getValue());
            int startHour2 = R0().getStartHour();
            int startMin2 = R0().getStartMin();
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, startHour2);
            calendar.set(12, startMin2);
            int i3 = calendar.get(9) == 0 ? 1 : 0;
            s3.d S02 = S0();
            int g10 = a2.g(this, R0().getStartHour(), R0().getStartMin());
            int startMin3 = R0().getStartMin();
            q3.a aVar2 = S02.e;
            aVar2.f17752d = i3 ^ 1;
            aVar2.e = g10;
            aVar2.f17753f = startMin3;
            S02.e();
        }
        S0().d();
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.avRepeat;
        boolean z5 = false;
        if (valueOf != null && valueOf.intValue() == i3) {
            int[] repeatModel = R0().getRepeatModel();
            if (repeatModel == null) {
                repeatModel = new int[7];
            }
            Intent intent = new Intent(this, (Class<?>) OptionActivity.class);
            intent.putExtra("option_type", 3);
            intent.putExtra("is_single", false);
            intent.putExtra("select_array", repeatModel);
            startActivity(intent);
            return;
        }
        int i10 = R$id.avTag;
        if (valueOf != null && valueOf.intValue() == i10) {
            String alarmTag = R0().getAlarmTag();
            if (alarmTag != null && alarmTag.length() != 0 && !"null".equalsIgnoreCase(alarmTag)) {
                z5 = true;
            }
            String alarmTag2 = z5 ? R0().getAlarmTag() : "";
            kotlin.jvm.internal.e.c(alarmTag2);
            Intent intent2 = new Intent(this, (Class<?>) InputActivity.class);
            intent2.putExtra(AeUtil.ROOT_DATA_PATH_OLD_NAME, alarmTag2);
            intent2.putExtra("data_type", 1);
            startActivity(intent2);
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onOptionEvent(EventBusBeans.OptionEvent optionEvent) {
        kotlin.jvm.internal.e.f(optionEvent, "optionEvent");
        R0().setRepeatModel(optionEvent.getSelectValue());
        ((f6.d) this.f7247z.getValue()).f12772b.setHintStr(ca.f(this, R0().getRepeatModel()));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        T0();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onTextEvent(EventBusBeans.TextEditEvent textEditEvent) {
        kotlin.jvm.internal.e.f(textEditEvent, "textEditEvent");
        R0().setAlarmTag(textEditEvent.text);
        ActionItemView actionItemView = ((f6.d) this.f7247z.getValue()).f12773c;
        String alarmTag = R0().getAlarmTag();
        String alarmTag2 = alarmTag != null && alarmTag.length() != 0 && !"null".equalsIgnoreCase(alarmTag) ? R0().getAlarmTag() : getString(R$string.str_alarm);
        kotlin.jvm.internal.e.c(alarmTag2);
        actionItemView.setHintStr(alarmTag2);
    }
}
