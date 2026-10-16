package com.example.test.ui.testui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.autonavi.base.amap.mapcore.AeUtil;
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
import f6.h1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TringAlarmAddActivity extends XXBaseActivity<com.example.test.presenter.device.a, h1> implements p5.a, View.OnClickListener {
    public static final /* synthetic */ int N = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TringAlarmAddActivity$alarmPosition$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = TringAlarmAddActivity.this.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra("alarm_position", 0) : -1);
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TringAlarmAddActivity$alarmModel$2
        {
            super(0);
        }

        @Override // oh.a
        public final AlarmModel invoke() {
            Bundle extras;
            Intent intent = TringAlarmAddActivity.this.getIntent();
            Serializable serializable = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getSerializable(AeUtil.ROOT_DATA_PATH_OLD_NAME);
            kotlin.jvm.internal.e.d(serializable, "null cannot be cast to non-null type com.example.test.ui.device.model.AlarmModel");
            return (AlarmModel) serializable;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TringAlarmAddActivity$isEdit$2
        {
            super(0);
        }

        @Override // oh.a
        public final Boolean invoke() {
            Intent intent = TringAlarmAddActivity.this.getIntent();
            return Boolean.valueOf(intent != null ? intent.getBooleanExtra("is_edit", false) : false);
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TringAlarmAddActivity$opTime$2
        {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0073  */
        @Override // oh.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final s3.d invoke() {
            /*
                Method dump skipped, instructions count: 223
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.testui.TringAlarmAddActivity$opTime$2.invoke():s3.d");
        }
    });
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TringAlarmAddActivity$timeFont$2
        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("AM");
            arrayList.add("PM");
            return arrayList;
        }
    });
    public final eh.b J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TringAlarmAddActivity$hours$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<List<String>> invoke() {
            ArrayList arrayList = new ArrayList();
            TringAlarmAddActivity tringAlarmAddActivity = TringAlarmAddActivity.this;
            int i3 = TringAlarmAddActivity.N;
            int size = ((List) tringAlarmAddActivity.I.getValue()).size();
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
    public final eh.b K = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TringAlarmAddActivity$hours24$2
        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 24; i3++) {
                arrayList.add(String.valueOf(i3));
            }
            return arrayList;
        }
    });
    public final eh.b L = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TringAlarmAddActivity$mins24$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<List<String>> invoke() {
            ArrayList arrayList = new ArrayList();
            TringAlarmAddActivity tringAlarmAddActivity = TringAlarmAddActivity.this;
            int i3 = TringAlarmAddActivity.N;
            int size = ((List) tringAlarmAddActivity.K.getValue()).size();
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
    public final eh.b M = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TringAlarmAddActivity$mins$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<List<List<String>>> invoke() {
            ArrayList arrayList = new ArrayList();
            TringAlarmAddActivity tringAlarmAddActivity = TringAlarmAddActivity.this;
            int i3 = TringAlarmAddActivity.N;
            int size = ((List) tringAlarmAddActivity.I.getValue()).size();
            TringAlarmAddActivity tringAlarmAddActivity2 = TringAlarmAddActivity.this;
            for (int i10 = 0; i10 < size; i10++) {
                ArrayList arrayList2 = new ArrayList();
                int size2 = ((List) ((List) tringAlarmAddActivity2.J.getValue()).get(0)).size();
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
        LinearLayout linearLayout = ((h1) this.f7247z.getValue()).f12948a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_ring_alarm_add, (ViewGroup) null, false);
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
                        return new h1((LinearLayout) inflate, actionItemView, actionItemView2, titleView);
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
        ((h1) bVar.getValue()).f12951d.setOnTitleListener(new c1(this));
        ((h1) bVar.getValue()).f12949b.setOnClickListener(this);
        ((h1) bVar.getValue()).f12950c.setOnClickListener(this);
        T0();
        ((h1) bVar.getValue()).f12949b.setHintStr(ca.f(this, R0().getRepeatModel()));
        ActionItemView actionItemView = ((h1) bVar.getValue()).f12950c;
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
            Intent intent = new Intent(this, (Class<?>) TRingOptionActivity.class);
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
        ((h1) this.f7247z.getValue()).f12949b.setHintStr(ca.f(this, R0().getRepeatModel()));
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
        ActionItemView actionItemView = ((h1) this.f7247z.getValue()).f12950c;
        String alarmTag = R0().getAlarmTag();
        String alarmTag2 = alarmTag != null && alarmTag.length() != 0 && !"null".equalsIgnoreCase(alarmTag) ? R0().getAlarmTag() : getString(R$string.str_alarm);
        kotlin.jvm.internal.e.c(alarmTag2);
        actionItemView.setHintStr(alarmTag2);
    }
}
