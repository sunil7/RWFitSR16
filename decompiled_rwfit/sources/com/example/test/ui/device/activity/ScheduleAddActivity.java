package com.example.test.ui.device.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.s2;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.model.RemindModel;
import com.example.test.ui.device.model.ScheduleModel;
import com.example.test.ui.mine.activity.InputActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.material.R$attr;
import com.loper7.date_time_picker.R$style;
import f6.p1;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class ScheduleAddActivity extends XXBaseActivity<com.example.test.presenter.device.a, p1> implements p5.a, View.OnClickListener {
    public static final /* synthetic */ int L = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScheduleAddActivity$timeFormat$2
        {
            super(0);
        }

        @Override // oh.a
        public final Boolean invoke() {
            ScheduleAddActivity context = ScheduleAddActivity.this;
            kotlin.jvm.internal.e.f(context, "context");
            return Boolean.valueOf(DateFormat.is24HourFormat(context));
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScheduleAddActivity$scheduleRemindData$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<RemindModel> invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RemindModel(0, ScheduleAddActivity.this.getString(R$string.str_schedule_remind_now), 0));
            arrayList.add(new RemindModel(1, ScheduleAddActivity.this.getString(R$string.str_schedule_remind_before_5_minutes), 5));
            arrayList.add(new RemindModel(2, ScheduleAddActivity.this.getString(R$string.str_schedule_remind_before_15_minutes), 15));
            arrayList.add(new RemindModel(3, ScheduleAddActivity.this.getString(R$string.str_schedule_remind_before_30_minutes), 35));
            arrayList.add(new RemindModel(4, ScheduleAddActivity.this.getString(R$string.str_schedule_remind_before_1_hour), 60));
            arrayList.add(new RemindModel(5, ScheduleAddActivity.this.getString(R$string.str_schedule_remind_before_2_hour), 120));
            arrayList.add(new RemindModel(6, ScheduleAddActivity.this.getString(R$string.str_schedule_remind_before_1_day), 1440));
            arrayList.add(new RemindModel(7, ScheduleAddActivity.this.getString(R$string.str_schedule_remind_before_2_day), 2880));
            arrayList.add(new RemindModel(8, ScheduleAddActivity.this.getString(R$string.str_schedule_remind_before_1_week), 10080));
            return arrayList;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScheduleAddActivity$schedulePosition$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = ScheduleAddActivity.this.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra("schedule_position", 0) : -1);
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScheduleAddActivity$scheduleModel$2
        {
            super(0);
        }

        @Override // oh.a
        public final ScheduleModel invoke() {
            Bundle extras;
            Intent intent = ScheduleAddActivity.this.getIntent();
            Serializable serializable = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getSerializable(AeUtil.ROOT_DATA_PATH_OLD_NAME);
            kotlin.jvm.internal.e.d(serializable, "null cannot be cast to non-null type com.example.test.ui.device.model.ScheduleModel");
            return (ScheduleModel) serializable;
        }
    });
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScheduleAddActivity$isEdit$2
        {
            super(0);
        }

        @Override // oh.a
        public final Boolean invoke() {
            Intent intent = ScheduleAddActivity.this.getIntent();
            return Boolean.valueOf(intent != null ? intent.getBooleanExtra("is_edit", false) : false);
        }
    });
    public final eh.b J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScheduleAddActivity$opTime$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.a invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            arrayList.add(0);
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(4);
            int i10 = com.example.test.ui.dialog.c.D;
            com.example.test.ui.dialog.a a3 = com.example.test.ui.dialog.b.a(ScheduleAddActivity.this);
            a3.f7912b = false;
            a3.f7913c = false;
            a3.f7914d = false;
            a3.f7919j = R$layout.layout_date_picker;
            int[] iArr = new int[arrayList.size()];
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                iArr[i3] = ((Number) obj).intValue();
                i3++;
            }
            a3.f7917h = iArr;
            a3.f7918i = 2;
            String string = ScheduleAddActivity.this.getString(R$string.str_sure);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            final ScheduleAddActivity scheduleAddActivity = ScheduleAddActivity.this;
            a3.f7922m = new oh.l() { // from class: com.example.test.ui.device.activity.ScheduleAddActivity$opTime$2.1
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke(((Number) obj2).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ScheduleAddActivity scheduleAddActivity2 = ScheduleAddActivity.this;
                    int i12 = ScheduleAddActivity.L;
                    scheduleAddActivity2.S0().setTime(j4);
                    ScheduleAddActivity.this.R0();
                }
            };
            a3.f7915f = string;
            String string2 = ScheduleAddActivity.this.getString(R$string.str_cancel);
            kotlin.jvm.internal.e.e(string2, "getString(...)");
            a3.f7923n = new oh.a() { // from class: com.example.test.ui.device.activity.ScheduleAddActivity$opTime$2.2
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m55invoke() {
                }

                @Override // oh.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m55invoke();
                    return eh.g.f12633a;
                }
            };
            a3.e = string2;
            return a3;
        }
    });
    public final eh.b K = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ScheduleAddActivity$remindDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.d invoke() {
            ArrayList arrayList = new ArrayList();
            ScheduleAddActivity scheduleAddActivity = ScheduleAddActivity.this;
            int i3 = ScheduleAddActivity.L;
            int size = ((List) scheduleAddActivity.F.getValue()).size();
            ScheduleAddActivity scheduleAddActivity2 = ScheduleAddActivity.this;
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.add(((RemindModel) ((List) scheduleAddActivity2.F.getValue()).get(i10)).getShowStr());
            }
            ScheduleAddActivity scheduleAddActivity3 = ScheduleAddActivity.this;
            com.example.test.ui.dialog.d dVar = new com.example.test.ui.dialog.d(scheduleAddActivity3, arrayList, scheduleAddActivity3.S0().getAdvanceIndex());
            dVar.setOnOptionSelectListener(new y(ScheduleAddActivity.this, 11));
            return dVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.a(this, 0);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((p1) this.f7247z.getValue()).f13221a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_schedule_add, (ViewGroup) null, false);
        int i3 = R$id.scheduleMsgEdit;
        EditText editText = (EditText) he.a(i3, inflate);
        if (editText != null) {
            i3 = R$id.scheduleMsgLimitTv;
            TextView textView = (TextView) he.a(i3, inflate);
            if (textView != null) {
                i3 = R$id.scheduleRemindAv;
                ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
                if (actionItemView != null) {
                    i3 = R$id.scheduleTimeAv;
                    ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView2 != null) {
                        i3 = R$id.scheduleTitleAv;
                        ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                        if (actionItemView3 != null) {
                            i3 = R$id.titleView;
                            TitleView titleView = (TitleView) he.a(i3, inflate);
                            if (titleView != null) {
                                return new p1((LinearLayout) inflate, editText, textView, actionItemView, actionItemView2, actionItemView3, titleView);
                            }
                        }
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
        ((p1) bVar.getValue()).f13226g.setOnTitleListener(new d0(this));
        if (((Boolean) this.I.getValue()).booleanValue()) {
            ((p1) bVar.getValue()).f13226g.setTitle(R$string.str_schedule_edit_title);
        } else {
            ((p1) bVar.getValue()).f13226g.setTitle(R$string.str_schedule_add_title);
        }
        ((p1) bVar.getValue()).f13225f.setOnClickListener(this);
        ((p1) bVar.getValue()).e.setOnClickListener(this);
        ((p1) bVar.getValue()).f13224d.setOnClickListener(this);
        ((p1) bVar.getValue()).f13222b.addTextChangedListener(new s2(this, 2));
        ((p1) bVar.getValue()).f13222b.setText(S0().getScheduleMsg());
        R0();
    }

    public final void R0() {
        String str;
        eh.b bVar = this.f7247z;
        ActionItemView actionItemView = ((p1) bVar.getValue()).f13225f;
        String scheduleTitle = ca.h(S0().getScheduleTitle()) ? S0().getScheduleTitle() : getString(R$string.str_schedule_title);
        kotlin.jvm.internal.e.c(scheduleTitle);
        actionItemView.setHintStr(scheduleTitle);
        long time = S0().getTime();
        eh.b bVar2 = this.E;
        String str2 = null;
        if (time == 0) {
            if (((Boolean) bVar2.getValue()).booleanValue()) {
                try {
                    str2 = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.ENGLISH).format(Long.valueOf(Calendar.getInstance().getTimeInMillis()));
                } catch (Exception e) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("date translate error ", e.getMessage()));
                }
                if (str2 != null) {
                    ((p1) bVar.getValue()).e.setHintStr(str2);
                }
            } else {
                Calendar calendar = Calendar.getInstance();
                str = calendar.get(9) == 0 ? "AM" : "PM";
                String i3 = ca.i(calendar.getTimeInMillis(), "yyyy/MM/dd hh:mm");
                if (i3 != null) {
                    ((p1) bVar.getValue()).e.setHintStr(String.format("%s %s", Arrays.copyOf(new Object[]{i3, str}, 2)));
                }
            }
        } else if (((Boolean) bVar2.getValue()).booleanValue()) {
            try {
                str2 = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.ENGLISH).format(Long.valueOf(S0().getTime()));
            } catch (Exception e10) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("date translate error ", e10.getMessage()));
            }
            if (str2 != null) {
                ((p1) bVar.getValue()).e.setHintStr(str2);
            }
        } else {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(S0().getTime());
            str = calendar2.get(9) == 0 ? "AM" : "PM";
            String i10 = ca.i(calendar2.getTimeInMillis(), "yyyy/MM/dd hh:mm");
            if (i10 != null) {
                ((p1) bVar.getValue()).e.setHintStr(String.format("%s %s", Arrays.copyOf(new Object[]{i10, str}, 2)));
            }
        }
        ActionItemView actionItemView2 = ((p1) bVar.getValue()).f13224d;
        String showStr = ((RemindModel) ((List) this.F.getValue()).get(S0().getAdvanceIndex())).getShowStr();
        kotlin.jvm.internal.e.e(showStr, "getShowStr(...)");
        actionItemView2.setHintStr(showStr);
    }

    public final ScheduleModel S0() {
        return (ScheduleModel) this.H.getValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.scheduleTimeAv;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i10 = R$id.scheduleRemindAv;
            if (valueOf != null && valueOf.intValue() == i10) {
                ((com.example.test.ui.dialog.d) this.K.getValue()).show();
                return;
            }
            int i11 = R$id.scheduleTitleAv;
            if (valueOf != null && valueOf.intValue() == i11) {
                String scheduleTitle = S0().getScheduleTitle();
                String scheduleTitle2 = (scheduleTitle == null || scheduleTitle.length() == 0 || "null".equalsIgnoreCase(scheduleTitle)) ? "" : S0().getScheduleTitle();
                kotlin.jvm.internal.e.c(scheduleTitle2);
                Intent intent = new Intent(this, (Class<?>) InputActivity.class);
                intent.putExtra(AeUtil.ROOT_DATA_PATH_OLD_NAME, scheduleTitle2);
                intent.putExtra("data_type", 2);
                startActivity(intent);
                return;
            }
            return;
        }
        long time = S0().getTime();
        eh.b bVar = this.J;
        if (time == 0) {
            ((com.example.test.ui.dialog.a) bVar.getValue()).f7916g = Calendar.getInstance().getTimeInMillis();
        } else {
            ((com.example.test.ui.dialog.a) bVar.getValue()).f7916g = S0().getTime();
        }
        com.example.test.ui.dialog.a aVar = (com.example.test.ui.dialog.a) bVar.getValue();
        aVar.getClass();
        Context context = aVar.f7911a;
        kotlin.jvm.internal.e.f(context, "context");
        int i12 = R$style.DateTimePicker_BottomSheetDialog;
        if (i12 == 0) {
            TypedValue typedValue = new TypedValue();
            i12 = context.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : com.google.android.material.R$style.Theme_Design_Light_BottomSheetDialog;
        }
        com.example.test.ui.dialog.c cVar = new com.example.test.ui.dialog.c(context, i12);
        cVar.f7932i = true;
        cVar.f7933j = true;
        cVar.f7937n = new oa.c(cVar);
        cVar.b().h(1);
        cVar.f7936m = cVar.getContext().getTheme().obtainStyledAttributes(new int[]{R$attr.enableEdgeToEdge}).getBoolean(0, false);
        com.example.test.ui.dialog.b.a(context);
        cVar.f7938o = aVar;
        cVar.show();
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onTextEvent(EventBusBeans.TextEditEvent textEditEvent) {
        kotlin.jvm.internal.e.f(textEditEvent, "textEditEvent");
        S0().setScheduleTitle(textEditEvent.text);
        R0();
    }
}
