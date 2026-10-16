package com.loper7.date_time_picker;

import a1.d;
import af.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.internal.mlkit_vision_barcode.ob;
import com.loper7.date_time_picker.number_picker.NumberPicker;
import java.util.Calendar;
import kotlin.collections.g;
import kotlin.jvm.internal.e;
import oh.l;
import th.f;

/* loaded from: classes2.dex */
public class DateTimePicker extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public NumberPicker f11471a;

    /* renamed from: b, reason: collision with root package name */
    public NumberPicker f11472b;

    /* renamed from: c, reason: collision with root package name */
    public NumberPicker f11473c;

    /* renamed from: d, reason: collision with root package name */
    public NumberPicker f11474d;
    public NumberPicker e;

    /* renamed from: f, reason: collision with root package name */
    public NumberPicker f11475f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f11476g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f11477h;

    /* renamed from: i, reason: collision with root package name */
    public int f11478i;

    /* renamed from: j, reason: collision with root package name */
    public int f11479j;

    /* renamed from: k, reason: collision with root package name */
    public int f11480k;

    /* renamed from: l, reason: collision with root package name */
    public final int f11481l;

    /* renamed from: m, reason: collision with root package name */
    public final int f11482m;

    /* renamed from: n, reason: collision with root package name */
    public String f11483n;

    /* renamed from: o, reason: collision with root package name */
    public String f11484o;

    /* renamed from: p, reason: collision with root package name */
    public String f11485p;

    /* renamed from: q, reason: collision with root package name */
    public String f11486q;
    public String r;

    /* renamed from: s, reason: collision with root package name */
    public String f11487s;

    /* renamed from: t, reason: collision with root package name */
    public int f11488t;

    /* renamed from: u, reason: collision with root package name */
    public int f11489u;

    /* renamed from: v, reason: collision with root package name */
    public b f11490v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f11491w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f11492x;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DateTimePicker(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet);
        e.f(context, "context");
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0226, code lost:
    
        if (kotlin.text.m.c(r7, "zh", true) != false) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 929
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loper7.date_time_picker.DateTimePicker.a():void");
    }

    public final void b(int i3, int i10) {
        if (i3 == 0 || i10 == 0) {
            return;
        }
        Context context = getContext();
        e.c(context);
        int a3 = ob.a(context, i10);
        Context context2 = getContext();
        e.c(context2);
        int a10 = ob.a(context2, i3);
        NumberPicker numberPicker = this.f11471a;
        if (numberPicker != null) {
            numberPicker.setTextSize(a10);
        }
        NumberPicker numberPicker2 = this.f11472b;
        if (numberPicker2 != null) {
            numberPicker2.setTextSize(a10);
        }
        NumberPicker numberPicker3 = this.f11473c;
        if (numberPicker3 != null) {
            numberPicker3.setTextSize(a10);
        }
        NumberPicker numberPicker4 = this.f11474d;
        if (numberPicker4 != null) {
            numberPicker4.setTextSize(a10);
        }
        NumberPicker numberPicker5 = this.e;
        if (numberPicker5 != null) {
            numberPicker5.setTextSize(a10);
        }
        NumberPicker numberPicker6 = this.f11475f;
        if (numberPicker6 != null) {
            numberPicker6.setTextSize(a10);
        }
        NumberPicker numberPicker7 = this.f11471a;
        if (numberPicker7 != null) {
            numberPicker7.setSelectedTextSize(a3);
        }
        NumberPicker numberPicker8 = this.f11472b;
        if (numberPicker8 != null) {
            numberPicker8.setSelectedTextSize(a3);
        }
        NumberPicker numberPicker9 = this.f11473c;
        if (numberPicker9 != null) {
            numberPicker9.setSelectedTextSize(a3);
        }
        NumberPicker numberPicker10 = this.f11474d;
        if (numberPicker10 != null) {
            numberPicker10.setSelectedTextSize(a3);
        }
        NumberPicker numberPicker11 = this.e;
        if (numberPicker11 != null) {
            numberPicker11.setSelectedTextSize(a3);
        }
        NumberPicker numberPicker12 = this.f11475f;
        if (numberPicker12 == null) {
            return;
        }
        numberPicker12.setSelectedTextSize(a3);
    }

    public final void c(boolean z5) {
        this.f11477h = z5;
        if (z5) {
            NumberPicker numberPicker = this.f11471a;
            if (numberPicker != null) {
                numberPicker.setLabel(this.f11483n);
            }
            NumberPicker numberPicker2 = this.f11472b;
            if (numberPicker2 != null) {
                numberPicker2.setLabel(this.f11484o);
            }
            NumberPicker numberPicker3 = this.f11473c;
            if (numberPicker3 != null) {
                numberPicker3.setLabel(this.f11485p);
            }
            NumberPicker numberPicker4 = this.f11474d;
            if (numberPicker4 != null) {
                numberPicker4.setLabel(this.f11486q);
            }
            NumberPicker numberPicker5 = this.e;
            if (numberPicker5 != null) {
                numberPicker5.setLabel(this.r);
            }
            NumberPicker numberPicker6 = this.f11475f;
            if (numberPicker6 == null) {
                return;
            }
            numberPicker6.setLabel(this.f11487s);
            return;
        }
        NumberPicker numberPicker7 = this.f11471a;
        if (numberPicker7 != null) {
            numberPicker7.setLabel("");
        }
        NumberPicker numberPicker8 = this.f11472b;
        if (numberPicker8 != null) {
            numberPicker8.setLabel("");
        }
        NumberPicker numberPicker9 = this.f11473c;
        if (numberPicker9 != null) {
            numberPicker9.setLabel("");
        }
        NumberPicker numberPicker10 = this.f11474d;
        if (numberPicker10 != null) {
            numberPicker10.setLabel("");
        }
        NumberPicker numberPicker11 = this.e;
        if (numberPicker11 != null) {
            numberPicker11.setLabel("");
        }
        NumberPicker numberPicker12 = this.f11475f;
        if (numberPicker12 == null) {
            return;
        }
        numberPicker12.setLabel("");
    }

    public long getMillisecond() {
        b bVar = this.f11490v;
        if (bVar == null) {
            return 0L;
        }
        Calendar calendar = bVar.f283g;
        if (calendar != null) {
            return calendar.getTimeInMillis();
        }
        e.m("calendar");
        throw null;
    }

    public void setDefaultMillisecond(long j4) {
        b bVar = this.f11490v;
        if (bVar == null) {
            return;
        }
        bVar.e(j4);
    }

    public final void setDisplayType(int[] iArr) {
        NumberPicker numberPicker;
        NumberPicker numberPicker2;
        NumberPicker numberPicker3;
        NumberPicker numberPicker4;
        NumberPicker numberPicker5;
        NumberPicker numberPicker6;
        if (iArr == null || iArr.length == 0) {
            return;
        }
        this.f11476g = iArr;
        if (!g.b(0, iArr) && (numberPicker6 = this.f11471a) != null) {
            numberPicker6.setVisibility(8);
        }
        if (!g.b(1, this.f11476g) && (numberPicker5 = this.f11472b) != null) {
            numberPicker5.setVisibility(8);
        }
        if (!g.b(2, this.f11476g) && (numberPicker4 = this.f11473c) != null) {
            numberPicker4.setVisibility(8);
        }
        if (!g.b(3, this.f11476g) && (numberPicker3 = this.f11474d) != null) {
            numberPicker3.setVisibility(8);
        }
        if (!g.b(4, this.f11476g) && (numberPicker2 = this.e) != null) {
            numberPicker2.setVisibility(8);
        }
        if (g.b(5, this.f11476g) || (numberPicker = this.f11475f) == null) {
            return;
        }
        numberPicker.setVisibility(8);
    }

    public final void setDividerColor(int i3) {
        if (i3 == 0) {
            return;
        }
        this.f11480k = i3;
        NumberPicker numberPicker = this.f11471a;
        if (numberPicker != null) {
            numberPicker.setDividerColor(i3);
        }
        NumberPicker numberPicker2 = this.f11472b;
        if (numberPicker2 != null) {
            numberPicker2.setDividerColor(i3);
        }
        NumberPicker numberPicker3 = this.f11473c;
        if (numberPicker3 != null) {
            numberPicker3.setDividerColor(i3);
        }
        NumberPicker numberPicker4 = this.f11474d;
        if (numberPicker4 != null) {
            numberPicker4.setDividerColor(i3);
        }
        NumberPicker numberPicker5 = this.e;
        if (numberPicker5 != null) {
            numberPicker5.setDividerColor(i3);
        }
        NumberPicker numberPicker6 = this.f11475f;
        if (numberPicker6 == null) {
            return;
        }
        numberPicker6.setDividerColor(i3);
    }

    public final void setGlobal(int i3) {
        this.f11488t = i3;
        a();
    }

    public final void setLayout(int i3) {
        if (i3 == 0) {
            return;
        }
        this.f11489u = i3;
        a();
    }

    public void setMaxMillisecond(long j4) {
        b bVar = this.f11490v;
        if (bVar == null || j4 == 0) {
            return;
        }
        Calendar calendar = bVar.f284h;
        if (calendar == null) {
            e.m("minCalendar");
            throw null;
        }
        if (calendar.getTimeInMillis() > 0) {
            Calendar calendar2 = bVar.f284h;
            if (calendar2 == null) {
                e.m("minCalendar");
                throw null;
            }
            if (j4 < calendar2.getTimeInMillis()) {
                return;
            }
        }
        Calendar calendar3 = bVar.f285i;
        if (calendar3 == null) {
            e.m("maxCalendar");
            throw null;
        }
        calendar3.setTimeInMillis(j4);
        NumberPicker numberPicker = bVar.f278a;
        if (numberPicker != null) {
            Calendar calendar4 = bVar.f285i;
            if (calendar4 == null) {
                e.m("maxCalendar");
                throw null;
            }
            numberPicker.setMaxValue(calendar4.get(1));
        }
        Calendar calendar5 = bVar.f283g;
        if (calendar5 != null) {
            bVar.e(calendar5.getTimeInMillis());
        } else {
            e.m("calendar");
            throw null;
        }
    }

    public void setMinMillisecond(long j4) {
        b bVar = this.f11490v;
        if (bVar == null || j4 == 0) {
            return;
        }
        f fVar = j4 <= Long.MIN_VALUE ? f.f18648d : new f(1, j4 - 1);
        Calendar calendar = bVar.f285i;
        if (calendar == null) {
            e.m("maxCalendar");
            throw null;
        }
        long timeInMillis = calendar.getTimeInMillis();
        if (fVar.f18641a > timeInMillis || timeInMillis > fVar.f18642b) {
            Calendar calendar2 = bVar.f284h;
            if (calendar2 == null) {
                e.m("minCalendar");
                throw null;
            }
            calendar2.setTimeInMillis(j4);
            NumberPicker numberPicker = bVar.f278a;
            if (numberPicker != null) {
                Calendar calendar3 = bVar.f284h;
                if (calendar3 == null) {
                    e.m("minCalendar");
                    throw null;
                }
                numberPicker.setMinValue(calendar3.get(1));
            }
            Calendar calendar4 = bVar.f283g;
            if (calendar4 != null) {
                bVar.e(calendar4.getTimeInMillis());
            } else {
                e.m("calendar");
                throw null;
            }
        }
    }

    public void setOnDateTimeChangedListener(l lVar) {
        b bVar = this.f11490v;
        if (bVar == null) {
            return;
        }
        bVar.f287k = lVar;
        bVar.d();
    }

    public final void setSelectedTextBold(boolean z5) {
        this.f11492x = z5;
        NumberPicker numberPicker = this.f11471a;
        if (numberPicker != null) {
            numberPicker.setSelectedTextBold(z5);
        }
        NumberPicker numberPicker2 = this.f11472b;
        if (numberPicker2 != null) {
            numberPicker2.setSelectedTextBold(z5);
        }
        NumberPicker numberPicker3 = this.f11473c;
        if (numberPicker3 != null) {
            numberPicker3.setSelectedTextBold(z5);
        }
        NumberPicker numberPicker4 = this.f11474d;
        if (numberPicker4 != null) {
            numberPicker4.setSelectedTextBold(z5);
        }
        NumberPicker numberPicker5 = this.e;
        if (numberPicker5 != null) {
            numberPicker5.setSelectedTextBold(z5);
        }
        NumberPicker numberPicker6 = this.f11475f;
        if (numberPicker6 == null) {
            return;
        }
        numberPicker6.setSelectedTextBold(z5);
    }

    public final void setTextBold(boolean z5) {
        this.f11491w = z5;
        NumberPicker numberPicker = this.f11471a;
        if (numberPicker != null) {
            numberPicker.setTextBold(z5);
        }
        NumberPicker numberPicker2 = this.f11472b;
        if (numberPicker2 != null) {
            numberPicker2.setTextBold(z5);
        }
        NumberPicker numberPicker3 = this.f11473c;
        if (numberPicker3 != null) {
            numberPicker3.setTextBold(z5);
        }
        NumberPicker numberPicker4 = this.f11474d;
        if (numberPicker4 != null) {
            numberPicker4.setTextBold(z5);
        }
        NumberPicker numberPicker5 = this.e;
        if (numberPicker5 != null) {
            numberPicker5.setTextBold(z5);
        }
        NumberPicker numberPicker6 = this.f11475f;
        if (numberPicker6 == null) {
            return;
        }
        numberPicker6.setTextBold(z5);
    }

    public final void setTextColor(int i3) {
        if (i3 == 0) {
            return;
        }
        this.f11479j = i3;
        NumberPicker numberPicker = this.f11471a;
        if (numberPicker != null) {
            numberPicker.setTextColor(i3);
        }
        NumberPicker numberPicker2 = this.f11472b;
        if (numberPicker2 != null) {
            numberPicker2.setTextColor(this.f11479j);
        }
        NumberPicker numberPicker3 = this.f11473c;
        if (numberPicker3 != null) {
            numberPicker3.setTextColor(this.f11479j);
        }
        NumberPicker numberPicker4 = this.f11474d;
        if (numberPicker4 != null) {
            numberPicker4.setTextColor(this.f11479j);
        }
        NumberPicker numberPicker5 = this.e;
        if (numberPicker5 != null) {
            numberPicker5.setTextColor(this.f11479j);
        }
        NumberPicker numberPicker6 = this.f11475f;
        if (numberPicker6 == null) {
            return;
        }
        numberPicker6.setTextColor(this.f11479j);
    }

    public final void setThemeColor(int i3) {
        if (i3 == 0) {
            return;
        }
        this.f11478i = i3;
        NumberPicker numberPicker = this.f11471a;
        if (numberPicker != null) {
            numberPicker.setSelectedTextColor(i3);
        }
        NumberPicker numberPicker2 = this.f11472b;
        if (numberPicker2 != null) {
            numberPicker2.setSelectedTextColor(this.f11478i);
        }
        NumberPicker numberPicker3 = this.f11473c;
        if (numberPicker3 != null) {
            numberPicker3.setSelectedTextColor(this.f11478i);
        }
        NumberPicker numberPicker4 = this.f11474d;
        if (numberPicker4 != null) {
            numberPicker4.setSelectedTextColor(this.f11478i);
        }
        NumberPicker numberPicker5 = this.e;
        if (numberPicker5 != null) {
            numberPicker5.setSelectedTextColor(this.f11478i);
        }
        NumberPicker numberPicker6 = this.f11475f;
        if (numberPicker6 == null) {
            return;
        }
        numberPicker6.setSelectedTextColor(this.f11478i);
    }

    public final void setWrapSelectorWheel(boolean z5) {
        b bVar = this.f11490v;
        if (bVar == null) {
            return;
        }
        bVar.f(null, z5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e.f(context, "context");
        this.f11476g = new int[]{0, 1, 2, 3, 4, 5};
        this.f11477h = true;
        this.f11483n = "年";
        this.f11484o = "月";
        this.f11485p = "日";
        this.f11486q = "时";
        this.r = "分";
        this.f11487s = "秒";
        this.f11489u = R$layout.dt_layout_date_picker;
        this.f11491w = true;
        this.f11492x = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DateTimePicker);
        this.f11477h = obtainStyledAttributes.getBoolean(R$styleable.DateTimePicker_dt_showLabel, true);
        this.f11478i = obtainStyledAttributes.getColor(R$styleable.DateTimePicker_dt_themeColor, d.a(context, R$color.colorAccent));
        this.f11479j = obtainStyledAttributes.getColor(R$styleable.DateTimePicker_dt_textColor, d.a(context, R$color.colorTextGray));
        this.f11480k = obtainStyledAttributes.getColor(R$styleable.DateTimePicker_dt_dividerColor, d.a(context, R$color.colorDivider));
        this.f11481l = (int) ((obtainStyledAttributes.getDimensionPixelSize(R$styleable.DateTimePicker_dt_selectTextSize, ob.a(context, 0.0f)) / context.getResources().getDisplayMetrics().density) + 0.5f);
        this.f11482m = (int) ((obtainStyledAttributes.getDimensionPixelSize(R$styleable.DateTimePicker_dt_normalTextSize, ob.a(context, 0.0f)) / context.getResources().getDisplayMetrics().density) + 0.5f);
        this.f11489u = obtainStyledAttributes.getResourceId(R$styleable.DateTimePicker_dt_layout, R$layout.dt_layout_date_picker);
        this.f11491w = obtainStyledAttributes.getBoolean(R$styleable.DateTimePicker_dt_textBold, this.f11491w);
        this.f11492x = obtainStyledAttributes.getBoolean(R$styleable.DateTimePicker_dt_selectedTextBold, this.f11492x);
        obtainStyledAttributes.recycle();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTimePicker(Context context) {
        super(context);
        e.f(context, "context");
        this.f11476g = new int[]{0, 1, 2, 3, 4, 5};
        this.f11477h = true;
        this.f11483n = "年";
        this.f11484o = "月";
        this.f11485p = "日";
        this.f11486q = "时";
        this.r = "分";
        this.f11487s = "秒";
        this.f11489u = R$layout.dt_layout_date_picker;
        this.f11491w = true;
        this.f11492x = true;
        a();
    }
}
