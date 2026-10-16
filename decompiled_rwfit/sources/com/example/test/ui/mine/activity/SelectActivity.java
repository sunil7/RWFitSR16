package com.example.test.ui.mine.activity;

import android.R;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.services.core.AMapException;
import com.contrarywind.view.WheelView;
import com.example.baselibrary.R$anim;
import com.example.baselibrary.R$string;
import com.example.database.table.User;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.od;
import com.google.android.material.R$attr;
import f6.u1;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import n.m0;

@SuppressLint({"ResourceType"})
/* loaded from: classes.dex */
public final class SelectActivity extends XXBaseActivity<com.example.test.presenter.device.n, u1> implements p5.a, View.OnClickListener {
    public static final /* synthetic */ int P = 0;
    public int E;
    public int F;
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.SelectActivity$opTime$2
        {
            super(0);
        }

        @Override // oh.a
        public final s3.d invoke() {
            SelectActivity selectActivity = SelectActivity.this;
            int i3 = SelectActivity.P;
            Integer num = (Integer) selectActivity.K.getValue();
            selectActivity.E = num != null ? num.intValue() : 0;
            SelectActivity selectActivity2 = SelectActivity.this;
            Integer num2 = (Integer) selectActivity2.L.getValue();
            selectActivity2.F = num2 != null ? num2.intValue() : 0;
            TypedValue typedValue = new TypedValue();
            SelectActivity selectActivity3 = SelectActivity.this;
            selectActivity3.getClass();
            selectActivity3.getTheme().resolveAttribute(R$attr.colorOnPrimary, typedValue, true);
            int i10 = typedValue.data;
            SelectActivity selectActivity4 = SelectActivity.this;
            selectActivity4.getClass();
            p3.a aVar = new p3.a(selectActivity4, new v(SelectActivity.this));
            q3.a aVar2 = aVar.f17450a;
            aVar2.f17768v = i10;
            SelectActivity selectActivity5 = SelectActivity.this;
            selectActivity5.getClass();
            Resources resources = selectActivity5.getResources();
            aVar2.f17767u = resources != null ? resources.getColor(R$color.color_cccccc) : -7829368;
            aVar2.f17769w = i10;
            aVar2.r = (ViewGroup) SelectActivity.this.findViewById(R$id.decor);
            SelectActivity selectActivity6 = SelectActivity.this;
            selectActivity6.getClass();
            Resources resources2 = selectActivity6.getResources();
            aVar2.f17766t = resources2 != null ? resources2.getColor(R.color.transparent) : 0;
            aVar2.f17770x = 1.8f;
            aVar.b(R$layout.view_time_select, new b9.a(3));
            return aVar.a();
        }
    });
    public Date H = new Date();
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.SelectActivity$opDate$2
        {
            super(0);
        }

        @Override // oh.a
        public final s3.e invoke() {
            String str;
            String str2;
            Calendar calendar = Calendar.getInstance();
            SelectActivity selectActivity = SelectActivity.this;
            int i3 = SelectActivity.P;
            Integer U0 = selectActivity.U0();
            if (U0 != null && U0.intValue() == 7) {
                calendar.set(1, 2025);
                calendar.set(2, 0);
                calendar.set(5, 1);
            } else {
                calendar.set(1, 1900);
                calendar.set(2, 0);
                calendar.set(5, 1);
            }
            TypedValue typedValue = new TypedValue();
            SelectActivity selectActivity2 = SelectActivity.this;
            selectActivity2.getClass();
            selectActivity2.getTheme().resolveAttribute(R$attr.colorOnPrimary, typedValue, true);
            int i10 = typedValue.data;
            Calendar calendar2 = Calendar.getInstance();
            SelectActivity selectActivity3 = SelectActivity.this;
            selectActivity3.getClass();
            v vVar = new v(SelectActivity.this);
            q3.a aVar = new q3.a(2);
            aVar.f17765s = selectActivity3;
            aVar.f17749a = vVar;
            aVar.f17768v = i10;
            SelectActivity selectActivity4 = SelectActivity.this;
            selectActivity4.getClass();
            Resources resources = selectActivity4.getResources();
            aVar.f17767u = resources != null ? resources.getColor(R$color.color_cccccc) : -7829368;
            aVar.f17769w = i10;
            aVar.r = (ViewGroup) SelectActivity.this.findViewById(R$id.decor);
            SelectActivity selectActivity5 = SelectActivity.this;
            selectActivity5.getClass();
            Resources resources2 = selectActivity5.getResources();
            aVar.f17766t = resources2 != null ? resources2.getColor(R.color.transparent) : 0;
            aVar.f17770x = 1.8f;
            String str3 = "";
            aVar.f17758k = "";
            aVar.f17759l = "";
            aVar.f17760m = "";
            aVar.f17761n = "";
            aVar.f17762o = "";
            aVar.f17763p = "";
            aVar.f17754g = new boolean[]{true, true, true, false, false, false};
            aVar.f17756i = calendar;
            aVar.f17757j = calendar2;
            int i11 = R$layout.view_day_select;
            b9.a aVar2 = new b9.a(3);
            aVar.f17764q = i11;
            aVar.f17751c = aVar2;
            s3.e eVar = new s3.e(aVar.f17765s);
            eVar.e = aVar;
            Context context = aVar.f17765s;
            Dialog dialog = eVar.f18173j;
            if (dialog != null) {
                dialog.setCancelable(true);
            }
            eVar.b();
            int i12 = R$anim.pickerview_slide_in_bottom;
            Context context2 = eVar.f18165a;
            eVar.f18171h = AnimationUtils.loadAnimation(context2, i12);
            eVar.f18170g = AnimationUtils.loadAnimation(context2, R$anim.pickerview_slide_out_bottom);
            b9.a aVar3 = eVar.e.f17751c;
            if (aVar3 == null) {
                LayoutInflater.from(context).inflate(com.example.baselibrary.R$layout.pickerview_time, eVar.f18166b);
                TextView textView = (TextView) eVar.f18166b.findViewById(com.example.baselibrary.R$id.tvTitle);
                RelativeLayout relativeLayout = (RelativeLayout) eVar.f18166b.findViewById(com.example.baselibrary.R$id.rv_topbar);
                Button button = (Button) eVar.f18166b.findViewById(com.example.baselibrary.R$id.btnSubmit);
                Button button2 = (Button) eVar.f18166b.findViewById(com.example.baselibrary.R$id.btnCancel);
                button.setTag("submit");
                button2.setTag("cancel");
                button.setOnClickListener(eVar);
                button2.setOnClickListener(eVar);
                eVar.e.getClass();
                if (TextUtils.isEmpty(null)) {
                    str = context.getResources().getString(R$string.pickerview_submit);
                } else {
                    eVar.e.getClass();
                    str = null;
                }
                button.setText(str);
                eVar.e.getClass();
                if (TextUtils.isEmpty(null)) {
                    str2 = context.getResources().getString(R$string.pickerview_cancel);
                } else {
                    eVar.e.getClass();
                    str2 = null;
                }
                button2.setText(str2);
                eVar.e.getClass();
                if (!TextUtils.isEmpty(null)) {
                    eVar.e.getClass();
                    str3 = null;
                }
                textView.setText(str3);
                eVar.e.getClass();
                button.setTextColor(-16417281);
                eVar.e.getClass();
                button2.setTextColor(-16417281);
                eVar.e.getClass();
                textView.setTextColor(-16777216);
                eVar.e.getClass();
                relativeLayout.setBackgroundColor(-657931);
                eVar.e.getClass();
                float f2 = 17;
                button.setTextSize(f2);
                eVar.e.getClass();
                button2.setTextSize(f2);
                eVar.e.getClass();
                textView.setTextSize(18);
            } else {
                LayoutInflater.from(context).inflate(eVar.e.f17764q, eVar.f18166b);
                aVar3.a();
            }
            LinearLayout linearLayout = (LinearLayout) eVar.f18166b.findViewById(com.example.baselibrary.R$id.timepicker);
            linearLayout.setBackgroundColor(eVar.e.f17766t);
            q3.a aVar4 = eVar.e;
            boolean[] zArr = aVar4.f17754g;
            s3.h hVar = new s3.h();
            hVar.f18197i = 1900;
            hVar.f18198j = AMapException.CODE_AMAP_NEARBY_INVALID_USERID;
            hVar.f18199k = 1;
            hVar.f18200l = 12;
            hVar.f18201m = 1;
            hVar.f18202n = 31;
            hVar.f18190a = linearLayout;
            hVar.f18196h = zArr;
            eVar.f18177m = hVar;
            if (aVar4.f17749a != null) {
                hVar.f18204p = new m0(eVar, 15);
            }
            Calendar calendar3 = aVar4.f17756i;
            if (calendar3 == null || aVar4.f17757j == null) {
                if (calendar3 == null) {
                    Calendar calendar4 = aVar4.f17757j;
                    if (calendar4 == null) {
                        eVar.e();
                    } else {
                        if (calendar4.get(1) > 2100) {
                            throw new IllegalArgumentException("The endDate should not be later than 2100");
                        }
                        eVar.e();
                    }
                } else {
                    if (calendar3.get(1) < 1900) {
                        throw new IllegalArgumentException("The startDate can not as early as 1900");
                    }
                    eVar.e();
                }
            } else {
                if (calendar3.getTimeInMillis() > eVar.e.f17757j.getTimeInMillis()) {
                    throw new IllegalArgumentException("startDate can't be later than endDate");
                }
                eVar.e();
            }
            eVar.f();
            s3.h hVar2 = eVar.f18177m;
            q3.a aVar5 = eVar.e;
            String str4 = aVar5.f17758k;
            String str5 = aVar5.f17759l;
            String str6 = aVar5.f17760m;
            String str7 = aVar5.f17761n;
            String str8 = aVar5.f17762o;
            String str9 = aVar5.f17763p;
            hVar2.getClass();
            LinearLayout linearLayout2 = hVar2.f18190a;
            if (str4 != null) {
                hVar2.f18191b.setLabel(str4);
            } else {
                hVar2.f18191b.setLabel(linearLayout2.getContext().getString(R$string.pickerview_year));
            }
            if (str5 != null) {
                hVar2.f18192c.setLabel(str5);
            } else {
                hVar2.f18192c.setLabel(linearLayout2.getContext().getString(R$string.pickerview_month));
            }
            if (str6 != null) {
                hVar2.f18193d.setLabel(str6);
            } else {
                hVar2.f18193d.setLabel(linearLayout2.getContext().getString(R$string.pickerview_day));
            }
            if (str7 != null) {
                hVar2.e.setLabel(str7);
            } else {
                hVar2.e.setLabel(linearLayout2.getContext().getString(R$string.pickerview_hours));
            }
            if (str8 != null) {
                hVar2.f18194f.setLabel(str8);
            } else {
                hVar2.f18194f.setLabel(linearLayout2.getContext().getString(R$string.pickerview_minutes));
            }
            if (str9 != null) {
                hVar2.f18195g.setLabel(str9);
            } else {
                hVar2.f18195g.setLabel(linearLayout2.getContext().getString(R$string.pickerview_seconds));
            }
            s3.h hVar3 = eVar.f18177m;
            eVar.e.getClass();
            eVar.e.getClass();
            eVar.e.getClass();
            eVar.e.getClass();
            eVar.e.getClass();
            eVar.e.getClass();
            hVar3.f18191b.setTextXOffset(0);
            hVar3.f18192c.setTextXOffset(0);
            hVar3.f18193d.setTextXOffset(0);
            hVar3.e.setTextXOffset(0);
            hVar3.f18194f.setTextXOffset(0);
            hVar3.f18195g.setTextXOffset(0);
            s3.h hVar4 = eVar.f18177m;
            int i13 = eVar.e.A;
            hVar4.f18193d.setItemsVisibleCount(i13);
            hVar4.f18192c.setItemsVisibleCount(i13);
            hVar4.f18191b.setItemsVisibleCount(i13);
            hVar4.e.setItemsVisibleCount(i13);
            hVar4.f18194f.setItemsVisibleCount(i13);
            hVar4.f18195g.setItemsVisibleCount(i13);
            s3.h hVar5 = eVar.f18177m;
            eVar.e.getClass();
            hVar5.f18193d.setAlphaGradient(false);
            hVar5.f18192c.setAlphaGradient(false);
            hVar5.f18191b.setAlphaGradient(false);
            hVar5.e.setAlphaGradient(false);
            hVar5.f18194f.setAlphaGradient(false);
            hVar5.f18195g.setAlphaGradient(false);
            eVar.e.getClass();
            ViewGroup viewGroup = eVar.f18167c;
            if (viewGroup != null) {
                viewGroup.findViewById(com.example.baselibrary.R$id.outmost_container).setOnTouchListener(eVar.f18175l);
            }
            s3.h hVar6 = eVar.f18177m;
            eVar.e.getClass();
            hVar6.f18191b.setCyclic(false);
            hVar6.f18192c.setCyclic(false);
            hVar6.f18193d.setCyclic(false);
            hVar6.e.setCyclic(false);
            hVar6.f18194f.setCyclic(false);
            hVar6.f18195g.setCyclic(false);
            s3.h hVar7 = eVar.f18177m;
            int i14 = eVar.e.f17769w;
            hVar7.f18193d.setDividerColor(i14);
            hVar7.f18192c.setDividerColor(i14);
            hVar7.f18191b.setDividerColor(i14);
            hVar7.e.setDividerColor(i14);
            hVar7.f18194f.setDividerColor(i14);
            hVar7.f18195g.setDividerColor(i14);
            s3.h hVar8 = eVar.f18177m;
            WheelView.DividerType dividerType = eVar.e.f17772z;
            hVar8.f18193d.setDividerType(dividerType);
            hVar8.f18192c.setDividerType(dividerType);
            hVar8.f18191b.setDividerType(dividerType);
            hVar8.e.setDividerType(dividerType);
            hVar8.f18194f.setDividerType(dividerType);
            hVar8.f18195g.setDividerType(dividerType);
            s3.h hVar9 = eVar.f18177m;
            float f10 = eVar.e.f17770x;
            hVar9.f18193d.setLineSpacingMultiplier(f10);
            hVar9.f18192c.setLineSpacingMultiplier(f10);
            hVar9.f18191b.setLineSpacingMultiplier(f10);
            hVar9.e.setLineSpacingMultiplier(f10);
            hVar9.f18194f.setLineSpacingMultiplier(f10);
            hVar9.f18195g.setLineSpacingMultiplier(f10);
            s3.h hVar10 = eVar.f18177m;
            int i15 = eVar.e.f17767u;
            hVar10.f18193d.setTextColorOut(i15);
            hVar10.f18192c.setTextColorOut(i15);
            hVar10.f18191b.setTextColorOut(i15);
            hVar10.e.setTextColorOut(i15);
            hVar10.f18194f.setTextColorOut(i15);
            hVar10.f18195g.setTextColorOut(i15);
            s3.h hVar11 = eVar.f18177m;
            int i16 = eVar.e.f17768v;
            hVar11.f18193d.setTextColorCenter(i16);
            hVar11.f18192c.setTextColorCenter(i16);
            hVar11.f18191b.setTextColorCenter(i16);
            hVar11.e.setTextColorCenter(i16);
            hVar11.f18194f.setTextColorCenter(i16);
            hVar11.f18195g.setTextColorCenter(i16);
            s3.h hVar12 = eVar.f18177m;
            eVar.e.getClass();
            hVar12.f18193d.f7062g = false;
            hVar12.f18192c.f7062g = false;
            hVar12.f18191b.f7062g = false;
            hVar12.e.f7062g = false;
            hVar12.f18194f.f7062g = false;
            hVar12.f18195g.f7062g = false;
            return eVar;
        }
    });
    public final eh.b J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.SelectActivity$selectType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = SelectActivity.this.getIntent();
            if (intent != null) {
                return Integer.valueOf(intent.getIntExtra("select_type", 0));
            }
            return null;
        }
    });
    public final eh.b K = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.SelectActivity$optionPosition$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = SelectActivity.this.getIntent();
            if (intent != null) {
                return Integer.valueOf(intent.getIntExtra("option_position", 0));
            }
            return null;
        }
    });
    public final eh.b L = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.SelectActivity$optionPosition2$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = SelectActivity.this.getIntent();
            if (intent != null) {
                return Integer.valueOf(intent.getIntExtra("option_position2", 0));
            }
            return null;
        }
    });
    public final eh.b M = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.SelectActivity$optionDate$2
        {
            super(0);
        }

        @Override // oh.a
        public final Long invoke() {
            Intent intent = SelectActivity.this.getIntent();
            if (intent != null) {
                return Long.valueOf(intent.getLongExtra("option_date", System.currentTimeMillis()));
            }
            return null;
        }
    });
    public final eh.b N = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.SelectActivity$selectData$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            User d5 = kVar != null ? kVar.d() : null;
            SelectActivity selectActivity = SelectActivity.this;
            int i3 = SelectActivity.P;
            Integer U0 = selectActivity.U0();
            if (U0 != null && U0.intValue() == 0) {
                SelectActivity.R0(SelectActivity.this).f13373c.setTitle(com.example.test.R$string.str_sex);
                String string = SelectActivity.this.getString(com.example.test.R$string.str_man);
                kotlin.jvm.internal.e.e(string, "getString(...)");
                ArrayList r = kotlin.collections.h.r(arrayList, string);
                String string2 = SelectActivity.this.getString(com.example.test.R$string.str_woman);
                kotlin.jvm.internal.e.e(string2, "getString(...)");
                return kotlin.collections.h.r(r, string2);
            }
            if (U0 != null && U0.intValue() == 2) {
                SelectActivity.R0(SelectActivity.this).f13373c.setTitle(com.example.test.R$string.str_height);
                if (d5 != null) {
                    if (d5.getMeterUnit() == 0) {
                        for (int i10 = 60; i10 < 281; i10++) {
                            arrayList = kotlin.collections.h.r(arrayList, String.valueOf(i10));
                        }
                        return arrayList;
                    }
                    int a3 = com.google.android.gms.internal.mlkit_vision_common.r.a(23.622059f);
                    int a10 = com.google.android.gms.internal.mlkit_vision_common.r.a(110.236275f);
                    if (a3 <= a10) {
                        while (true) {
                            arrayList = kotlin.collections.h.r(arrayList, String.valueOf(a3));
                            if (a3 == a10) {
                                return arrayList;
                            }
                            a3++;
                        }
                    }
                }
            } else if (U0 != null && U0.intValue() == 3) {
                SelectActivity.R0(SelectActivity.this).f13373c.setTitle(com.example.test.R$string.str_weight);
                if (d5 != null) {
                    if (d5.getMeterUnit() == 0) {
                        for (int i11 = 20; i11 < 201; i11++) {
                            arrayList = kotlin.collections.h.r(arrayList, String.valueOf(i11));
                        }
                        return arrayList;
                    }
                    int a11 = com.google.android.gms.internal.mlkit_vision_common.r.a(44.1f);
                    int a12 = com.google.android.gms.internal.mlkit_vision_common.r.a(441.0f);
                    if (a11 <= a12) {
                        while (true) {
                            arrayList = kotlin.collections.h.r(arrayList, String.valueOf(a11));
                            if (a11 == a12) {
                                return arrayList;
                            }
                            a11++;
                        }
                    }
                }
            } else if (U0 != null && U0.intValue() == 4) {
                SelectActivity.R0(SelectActivity.this).f13373c.setTitle(com.example.test.R$string.str_target);
                int a13 = od.a(1000, 38000, 1000);
                if (1000 <= a13) {
                    int i12 = 1000;
                    while (true) {
                        arrayList = kotlin.collections.h.r(arrayList, String.valueOf(i12));
                        if (i12 == a13) {
                            return arrayList;
                        }
                        i12 += 1000;
                    }
                }
            } else {
                if (U0 != null && U0.intValue() == 5) {
                    SelectActivity.R0(SelectActivity.this).f13373c.setTitle(com.example.test.R$string.str_unit);
                    String string3 = SelectActivity.this.getString(com.example.test.R$string.str_unit_metric);
                    kotlin.jvm.internal.e.e(string3, "getString(...)");
                    ArrayList r8 = kotlin.collections.h.r(arrayList, string3);
                    String string4 = SelectActivity.this.getString(com.example.test.R$string.str_unit_imperial);
                    kotlin.jvm.internal.e.e(string4, "getString(...)");
                    return kotlin.collections.h.r(r8, string4);
                }
                if (U0 != null && U0.intValue() == 6) {
                    SelectActivity.R0(SelectActivity.this).f13373c.setTitle(com.example.test.R$string.str_temp);
                    String string5 = SelectActivity.this.getString(com.example.test.R$string.str_temp_centigrade);
                    kotlin.jvm.internal.e.e(string5, "getString(...)");
                    ArrayList r9 = kotlin.collections.h.r(arrayList, string5);
                    String string6 = SelectActivity.this.getString(com.example.test.R$string.str_temp_fahrenheit);
                    kotlin.jvm.internal.e.e(string6, "getString(...)");
                    return kotlin.collections.h.r(r9, string6);
                }
            }
            return arrayList;
        }
    });
    public final eh.b O = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.SelectActivity$selectData2$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<List<String>> invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (int i10 = 0; i10 < 10; i10++) {
                arrayList.add("." + i10);
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(".0");
            ArrayList arrayList3 = new ArrayList();
            SelectActivity selectActivity = SelectActivity.this;
            int i11 = SelectActivity.P;
            int size = ((List) selectActivity.N.getValue()).size();
            SelectActivity selectActivity2 = SelectActivity.this;
            while (i3 < size) {
                arrayList3.add(i3 == ((List) selectActivity2.N.getValue()).size() + (-1) ? arrayList2 : arrayList);
                i3++;
            }
            return arrayList3;
        }
    });

    public static final u1 R0(SelectActivity selectActivity) {
        return (u1) selectActivity.f7247z.getValue();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.n(this, 4);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((u1) this.f7247z.getValue()).f13371a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_select, (ViewGroup) null, false);
        int i3 = R$id.decor;
        if (((LinearLayout) he.a(i3, inflate)) != null) {
            i3 = R$id.sureBtn;
            Button button = (Button) he.a(i3, inflate);
            if (button != null) {
                i3 = R$id.titleView;
                TitleView titleView = (TitleView) he.a(i3, inflate);
                if (titleView != null) {
                    return new u1((ConstraintLayout) inflate, button, titleView);
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
        eh.b bVar = this.f7247z;
        ((u1) bVar.getValue()).f13373c.setOnTitleListener(new o(this, 8));
        Integer U0 = U0();
        eh.b bVar2 = this.M;
        if (U0 != null && U0.intValue() == 1) {
            ((u1) bVar.getValue()).f13373c.setTitle(com.example.test.R$string.str_birthday);
            Log.e("qob", " selectType SELECT_BIRTHDAY " + U0() + " " + ((Long) bVar2.getValue()));
            Long l3 = (Long) bVar2.getValue();
            if (l3 != null) {
                long longValue = l3.longValue();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(longValue);
                s3.e S0 = S0();
                S0.e.f17755h = calendar;
                S0.f();
            }
            S0().d();
        } else if (U0 != null && U0.intValue() == 7) {
            ((u1) bVar.getValue()).f13373c.setTitle(com.example.test.R$string.str_menstrual_last_time);
            Long l5 = (Long) bVar2.getValue();
            if (l5 != null) {
                long longValue2 = l5.longValue();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(longValue2);
                s3.e S02 = S0();
                S02.e.f17755h = calendar2;
                S02.f();
            }
            S0().d();
        } else {
            Integer U02 = U0();
            eh.b bVar3 = this.N;
            eh.b bVar4 = this.K;
            if (U02 != null && U02.intValue() == 3) {
                if (((Integer) bVar4.getValue()) != null) {
                    eh.b bVar5 = this.L;
                    if (((Integer) bVar5.getValue()) != null) {
                        s3.d T0 = T0();
                        Integer num = (Integer) bVar4.getValue();
                        kotlin.jvm.internal.e.c(num);
                        int intValue = num.intValue();
                        Integer num2 = (Integer) bVar5.getValue();
                        kotlin.jvm.internal.e.c(num2);
                        int intValue2 = num2.intValue();
                        q3.a aVar = T0.e;
                        aVar.f17752d = intValue;
                        aVar.e = intValue2;
                        T0.e();
                    }
                }
                T0().f((List) bVar3.getValue(), (List) this.O.getValue(), null);
            } else {
                T0().f((List) bVar3.getValue(), null, null);
                Integer num3 = (Integer) bVar4.getValue();
                if (num3 != null) {
                    int intValue3 = num3.intValue();
                    s3.d T02 = T0();
                    T02.e.f17752d = intValue3;
                    T02.e();
                }
            }
            T0().d();
        }
        ((u1) bVar.getValue()).f13372b.setOnClickListener(this);
    }

    public final s3.e S0() {
        Object value = this.I.getValue();
        kotlin.jvm.internal.e.e(value, "getValue(...)");
        return (s3.e) value;
    }

    public final s3.d T0() {
        Object value = this.G.getValue();
        kotlin.jvm.internal.e.e(value, "getValue(...)");
        return (s3.d) value;
    }

    public final Integer U0() {
        return (Integer) this.J.getValue();
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.sureBtn;
        if (valueOf != null && valueOf.intValue() == i3) {
            Integer U0 = U0();
            if (U0 != null && U0.intValue() == 0) {
                yh.d.b().e(new EventBusBeans.IntegerValueEvent(this.E, 0));
                finish();
                return;
            }
            if (U0 != null && U0.intValue() == 2) {
                yh.d.b().e(new EventBusBeans.IntegerValueEvent(this.E, 2));
                finish();
                return;
            }
            if (U0 != null && U0.intValue() == 3) {
                yh.d.b().e(new EventBusBeans.IntegerValueEvent(this.E, this.F, 3));
                finish();
                return;
            }
            if (U0 != null && U0.intValue() == 4) {
                yh.d.b().e(new EventBusBeans.IntegerValueEvent(this.E, 4));
                finish();
                return;
            }
            if (U0 != null && U0.intValue() == 5) {
                yh.d.b().e(new EventBusBeans.IntegerValueEvent(this.E, 5));
                finish();
                return;
            }
            if (U0 != null && U0.intValue() == 6) {
                yh.d.b().e(new EventBusBeans.IntegerValueEvent(this.E, 6));
                finish();
            } else if (U0 != null && U0.intValue() == 1) {
                yh.d.b().e(new EventBusBeans.DateValueEvent(this.H));
                finish();
            } else if (U0 != null && U0.intValue() == 7) {
                yh.d.b().e(new EventBusBeans.DateValueEvent(this.H));
                finish();
            }
        }
    }
}
