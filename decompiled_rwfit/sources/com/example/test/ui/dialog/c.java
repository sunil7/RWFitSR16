package com.example.test.ui.dialog;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.c0;
import androidx.appcompat.app.e0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.loper7.date_time_picker.DateTimePicker;
import com.loper7.date_time_picker.R$color;
import com.loper7.date_time_picker.R$drawable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.WeakHashMap;
import l1.n0;
import l1.z0;

/* loaded from: classes.dex */
public final class c extends e0 implements View.OnClickListener {
    public static final /* synthetic */ int C = 0;
    public static final /* synthetic */ int D = 0;
    public View A;
    public long B;
    public BottomSheetBehavior e;

    /* renamed from: f, reason: collision with root package name */
    public FrameLayout f7929f;

    /* renamed from: g, reason: collision with root package name */
    public CoordinatorLayout f7930g;

    /* renamed from: h, reason: collision with root package name */
    public FrameLayout f7931h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7932i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7933j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7934k;

    /* renamed from: l, reason: collision with root package name */
    public oa.d f7935l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7936m;

    /* renamed from: n, reason: collision with root package name */
    public oa.c f7937n;

    /* renamed from: o, reason: collision with root package name */
    public a f7938o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f7939p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f7940q;
    public TextView r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f7941s;

    /* renamed from: t, reason: collision with root package name */
    public TextView f7942t;

    /* renamed from: u, reason: collision with root package name */
    public DateTimePicker f7943u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f7944v;

    /* renamed from: w, reason: collision with root package name */
    public LinearLayout f7945w;

    /* renamed from: x, reason: collision with root package name */
    public LinearLayout f7946x;

    /* renamed from: y, reason: collision with root package name */
    public BottomSheetBehavior f7947y;

    /* renamed from: z, reason: collision with root package name */
    public View f7948z;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        if (this.e == null) {
            g();
        }
        super.cancel();
    }

    public final int f() {
        return (int) ((12.0f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void g() {
        if (this.f7929f == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R$layout.design_bottom_sheet_dialog, null);
            this.f7929f = frameLayout;
            this.f7930g = (CoordinatorLayout) frameLayout.findViewById(R$id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f7929f.findViewById(R$id.design_bottom_sheet);
            this.f7931h = frameLayout2;
            BottomSheetBehavior x10 = BottomSheetBehavior.x(frameLayout2);
            this.e = x10;
            oa.c cVar = this.f7937n;
            ArrayList arrayList = x10.P;
            if (!arrayList.contains(cVar)) {
                arrayList.add(cVar);
            }
            this.e.z(this.f7932i);
        }
    }

    public final void h(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    public final void i() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.e;
        if (bottomSheetBehavior == null || bottomSheetBehavior.F != 5) {
            return;
        }
        bottomSheetBehavior.B(4);
    }

    public final FrameLayout j(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        g();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f7929f.findViewById(R$id.coordinator);
        if (i3 != 0 && view == null) {
            view = getLayoutInflater().inflate(i3, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f7936m) {
            FrameLayout frameLayout = this.f7931h;
            mc.g gVar = new mc.g(this, 7);
            WeakHashMap weakHashMap = z0.f15748a;
            n0.u(frameLayout, gVar);
        }
        this.f7931h.removeAllViews();
        if (layoutParams == null) {
            this.f7931h.addView(view);
        } else {
            this.f7931h.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R$id.touch_outside).setOnClickListener(new androidx.appcompat.app.c(this, 10));
        z0.n(this.f7931h, new com.google.android.material.button.f(this, 5));
        this.f7931h.setOnTouchListener(new fb.c(1));
        return this.f7929f;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z5 = this.f7936m && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f7929f;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z5);
            }
            CoordinatorLayout coordinatorLayout = this.f7930g;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z5);
            }
            if (z5) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View v6) {
        oh.a aVar;
        oh.l lVar;
        oh.l lVar2;
        kotlin.jvm.internal.e.f(v6, "v");
        dismiss();
        int id2 = v6.getId();
        int i3 = com.example.test.R$id.btn_today;
        a aVar2 = this.f7938o;
        if (id2 == i3) {
            if (aVar2 != null && (lVar2 = aVar2.f7922m) != null) {
                lVar2.invoke(Long.valueOf(Calendar.getInstance().getTimeInMillis()));
            }
        } else if (id2 == com.example.test.R$id.dialog_submit) {
            if (aVar2 != null && (lVar = aVar2.f7922m) != null) {
                lVar.invoke(Long.valueOf(this.B));
            }
        } else if (id2 == com.example.test.R$id.dialog_cancel && aVar2 != null && (aVar = aVar2.f7923n) != null) {
            aVar.invoke();
        }
        dismiss();
    }

    @Override // androidx.appcompat.app.e0, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        setContentView(com.example.test.R$layout.dialog_custom_date_picker);
        h(bundle);
        androidx.appcompat.app.p b3 = b();
        int i3 = com.loper7.date_time_picker.R$id.design_bottom_sheet;
        c0 c0Var = (c0) b3;
        c0Var.w();
        FrameLayout frameLayout = (FrameLayout) c0Var.f433l.findViewById(i3);
        kotlin.jvm.internal.e.c(frameLayout);
        frameLayout.setBackgroundColor(0);
        this.f7939p = (TextView) findViewById(com.example.test.R$id.dialog_cancel);
        this.f7940q = (TextView) findViewById(com.example.test.R$id.dialog_submit);
        this.f7943u = (DateTimePicker) findViewById(com.example.test.R$id.dateTimePicker);
        this.r = (TextView) findViewById(com.example.test.R$id.tv_title);
        this.f7942t = (TextView) findViewById(com.example.test.R$id.btn_today);
        this.f7941s = (TextView) findViewById(com.example.test.R$id.tv_choose_date);
        this.f7944v = (TextView) findViewById(com.example.test.R$id.tv_go_back);
        this.f7945w = (LinearLayout) findViewById(com.example.test.R$id.linear_now);
        this.f7946x = (LinearLayout) findViewById(com.example.test.R$id.linear_bg);
        this.f7948z = findViewById(com.example.test.R$id.divider_top);
        this.A = findViewById(com.example.test.R$id.divider_bottom);
        BottomSheetBehavior x10 = BottomSheetBehavior.x(frameLayout);
        this.f7947y = x10;
        a aVar = this.f7938o;
        if (x10 != null) {
            x10.z(aVar != null ? aVar.f7921l : true);
        }
        kotlin.jvm.internal.e.c(aVar);
        if (aVar.f7918i != 0) {
            LinearLayout linearLayout = this.f7946x;
            kotlin.jvm.internal.e.c(linearLayout);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(linearLayout.getLayoutParams());
            int i10 = aVar.f7918i;
            if (i10 == 0) {
                layoutParams.setMargins(f(), f(), f(), f());
                LinearLayout linearLayout2 = this.f7946x;
                kotlin.jvm.internal.e.c(linearLayout2);
                linearLayout2.setLayoutParams(layoutParams);
                LinearLayout linearLayout3 = this.f7946x;
                kotlin.jvm.internal.e.c(linearLayout3);
                linearLayout3.setBackgroundResource(R$drawable.shape_bg_round_white_5);
            } else if (i10 == 1) {
                layoutParams.setMargins(0, 0, 0, 0);
                LinearLayout linearLayout4 = this.f7946x;
                kotlin.jvm.internal.e.c(linearLayout4);
                linearLayout4.setLayoutParams(layoutParams);
                LinearLayout linearLayout5 = this.f7946x;
                kotlin.jvm.internal.e.c(linearLayout5);
                linearLayout5.setBackgroundColor(a1.d.a(getContext(), R$color.colorTextWhite));
            } else if (i10 != 2) {
                layoutParams.setMargins(0, 0, 0, 0);
                LinearLayout linearLayout6 = this.f7946x;
                kotlin.jvm.internal.e.c(linearLayout6);
                linearLayout6.setLayoutParams(layoutParams);
                LinearLayout linearLayout7 = this.f7946x;
                kotlin.jvm.internal.e.c(linearLayout7);
                linearLayout7.setBackgroundResource(aVar.f7918i);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
                LinearLayout linearLayout8 = this.f7946x;
                kotlin.jvm.internal.e.c(linearLayout8);
                linearLayout8.setLayoutParams(layoutParams);
                LinearLayout linearLayout9 = this.f7946x;
                kotlin.jvm.internal.e.c(linearLayout9);
                linearLayout9.setBackgroundResource(com.example.test.R$drawable.bg_bottom_dialog);
            }
        }
        TextView textView = this.r;
        kotlin.jvm.internal.e.c(textView);
        textView.setVisibility(8);
        TextView textView2 = this.f7939p;
        if (textView2 != null) {
            textView2.setText(aVar.e);
        }
        TextView textView3 = this.f7940q;
        if (textView3 != null) {
            textView3.setText(aVar.f7915f);
        }
        DateTimePicker dateTimePicker = this.f7943u;
        kotlin.jvm.internal.e.c(dateTimePicker);
        dateTimePicker.setLayout(aVar.f7919j);
        DateTimePicker dateTimePicker2 = this.f7943u;
        kotlin.jvm.internal.e.c(dateTimePicker2);
        dateTimePicker2.c(aVar.f7914d);
        DateTimePicker dateTimePicker3 = this.f7943u;
        kotlin.jvm.internal.e.c(dateTimePicker3);
        String year = aVar.f7924o;
        kotlin.jvm.internal.e.f(year, "year");
        String month = aVar.f7925p;
        kotlin.jvm.internal.e.f(month, "month");
        String day = aVar.f7926q;
        kotlin.jvm.internal.e.f(day, "day");
        String hour = aVar.r;
        kotlin.jvm.internal.e.f(hour, "hour");
        String min = aVar.f7927s;
        kotlin.jvm.internal.e.f(min, "min");
        String second = aVar.f7928t;
        kotlin.jvm.internal.e.f(second, "second");
        dateTimePicker3.f11483n = year;
        dateTimePicker3.f11484o = month;
        dateTimePicker3.f11485p = day;
        dateTimePicker3.f11486q = hour;
        dateTimePicker3.r = min;
        dateTimePicker3.f11487s = second;
        dateTimePicker3.c(dateTimePicker3.f11477h);
        if (aVar.f7917h == null) {
            aVar.f7917h = new int[]{0, 1, 2, 3, 4, 5};
        }
        DateTimePicker dateTimePicker4 = this.f7943u;
        kotlin.jvm.internal.e.c(dateTimePicker4);
        dateTimePicker4.setDisplayType(aVar.f7917h);
        int[] iArr = aVar.f7917h;
        if (iArr != null) {
            kotlin.jvm.internal.e.c(iArr);
            char c9 = 0;
            for (int i11 : iArr) {
                if (i11 == 0 && c9 <= 0) {
                    TextView textView4 = this.f7944v;
                    kotlin.jvm.internal.e.c(textView4);
                    textView4.setText("回到今年");
                    TextView textView5 = this.f7942t;
                    kotlin.jvm.internal.e.c(textView5);
                    textView5.setText("今");
                    c9 = 0;
                }
                if (i11 == 1 && c9 <= 1) {
                    TextView textView6 = this.f7944v;
                    kotlin.jvm.internal.e.c(textView6);
                    textView6.setText("回到本月");
                    TextView textView7 = this.f7942t;
                    kotlin.jvm.internal.e.c(textView7);
                    textView7.setText("本");
                    c9 = 1;
                }
                if (i11 == 2 && c9 <= 2) {
                    TextView textView8 = this.f7944v;
                    kotlin.jvm.internal.e.c(textView8);
                    textView8.setText("回到今日");
                    TextView textView9 = this.f7942t;
                    kotlin.jvm.internal.e.c(textView9);
                    textView9.setText("今");
                    c9 = 2;
                }
                if ((i11 == 3 || i11 == 4) && c9 <= 3) {
                    TextView textView10 = this.f7944v;
                    kotlin.jvm.internal.e.c(textView10);
                    textView10.setText("回到此刻");
                    TextView textView11 = this.f7942t;
                    kotlin.jvm.internal.e.c(textView11);
                    textView11.setText("此");
                    c9 = 3;
                }
            }
        }
        LinearLayout linearLayout10 = this.f7945w;
        kotlin.jvm.internal.e.c(linearLayout10);
        linearLayout10.setVisibility(aVar.f7912b ? 0 : 8);
        TextView textView12 = this.f7941s;
        kotlin.jvm.internal.e.c(textView12);
        textView12.setVisibility(aVar.f7913c ? 0 : 8);
        DateTimePicker dateTimePicker5 = this.f7943u;
        kotlin.jvm.internal.e.c(dateTimePicker5);
        dateTimePicker5.setGlobal(1);
        DateTimePicker dateTimePicker6 = this.f7943u;
        kotlin.jvm.internal.e.c(dateTimePicker6);
        dateTimePicker6.setMinMillisecond(0L);
        DateTimePicker dateTimePicker7 = this.f7943u;
        kotlin.jvm.internal.e.c(dateTimePicker7);
        dateTimePicker7.setMaxMillisecond(0L);
        DateTimePicker dateTimePicker8 = this.f7943u;
        kotlin.jvm.internal.e.c(dateTimePicker8);
        dateTimePicker8.setDefaultMillisecond(aVar.f7916g);
        DateTimePicker dateTimePicker9 = this.f7943u;
        kotlin.jvm.internal.e.c(dateTimePicker9);
        ArrayList arrayList = aVar.f7920k;
        af.b bVar = dateTimePicker9.f11490v;
        if (bVar != null) {
            bVar.f(arrayList, true);
        }
        DateTimePicker dateTimePicker10 = this.f7943u;
        kotlin.jvm.internal.e.c(dateTimePicker10);
        dateTimePicker10.b(14, 17);
        TextView textView13 = this.f7939p;
        kotlin.jvm.internal.e.c(textView13);
        textView13.setOnClickListener(this);
        TextView textView14 = this.f7940q;
        kotlin.jvm.internal.e.c(textView14);
        textView14.setOnClickListener(this);
        TextView textView15 = this.f7942t;
        kotlin.jvm.internal.e.c(textView15);
        textView15.setOnClickListener(this);
        DateTimePicker dateTimePicker11 = this.f7943u;
        kotlin.jvm.internal.e.c(dateTimePicker11);
        dateTimePicker11.setOnDateTimeChangedListener(new oh.l() { // from class: com.example.test.ui.dialog.CustomDatePickerDialog$onCreate$1
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return eh.g.f12633a;
            }

            public final void invoke(long j4) {
                c.this.B = j4;
            }
        });
    }

    @Override // androidx.appcompat.app.e0, android.app.Dialog
    public final void onStart() {
        i();
        BottomSheetBehavior bottomSheetBehavior = this.f7947y;
        if (bottomSheetBehavior == null) {
            return;
        }
        bottomSheetBehavior.B(3);
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean z5) {
        super.setCancelable(z5);
        if (this.f7932i != z5) {
            this.f7932i = z5;
            BottomSheetBehavior bottomSheetBehavior = this.e;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.z(z5);
            }
        }
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean z5) {
        super.setCanceledOnTouchOutside(z5);
        if (z5 && !this.f7932i) {
            this.f7932i = true;
        }
        this.f7933j = z5;
        this.f7934k = true;
    }

    @Override // androidx.appcompat.app.e0, android.app.Dialog
    public final void setContentView(int i3) {
        super.setContentView(j(null, i3, null));
    }

    @Override // androidx.appcompat.app.e0, android.app.Dialog
    public final void setContentView(View view) {
        super.setContentView(j(view, 0, null));
    }

    @Override // androidx.appcompat.app.e0, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(j(view, 0, layoutParams));
    }
}
