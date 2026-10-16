package com.example.test.ui.testui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.material.timepicker.TimeModel;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class TRingDateSelectView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public int f8205a;

    /* renamed from: b, reason: collision with root package name */
    public Calendar f8206b;

    /* renamed from: c, reason: collision with root package name */
    public final Calendar f8207c;

    /* renamed from: d, reason: collision with root package name */
    public a7.b f8208d;
    public final ImageView e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f8209f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f8210g;

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f8211h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TRingDateSelectView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    private final com.example.test.ui.dialog.e getDateDialog() {
        return (com.example.test.ui.dialog.e) this.f8211h.getValue();
    }

    public final void a(boolean z5) {
        ImageView imageView = this.e;
        if (imageView == null) {
            kotlin.jvm.internal.e.m("lastIv");
            throw null;
        }
        imageView.setEnabled(z5);
        ImageView imageView2 = this.e;
        if (imageView2 != null) {
            imageView2.setAlpha(z5 ? 1.0f : 0.1f);
        } else {
            kotlin.jvm.internal.e.m("lastIv");
            throw null;
        }
    }

    public final void b(boolean z5) {
        ImageView imageView = this.f8209f;
        if (imageView == null) {
            kotlin.jvm.internal.e.m("nextIv");
            throw null;
        }
        imageView.setEnabled(z5);
        ImageView imageView2 = this.f8209f;
        if (imageView2 != null) {
            imageView2.setAlpha(z5 ? 1.0f : 0.1f);
        } else {
            kotlin.jvm.internal.e.m("nextIv");
            throw null;
        }
    }

    public final void c() {
        String str;
        a7.b bVar;
        Calendar calendar = this.f8206b;
        if (calendar != null) {
            int i3 = this.f8205a;
            if (i3 == 0) {
                long timeInMillis = calendar.getTimeInMillis();
                try {
                    str = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                } catch (Exception e) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                    str = null;
                }
                if (str == null || (bVar = this.f8208d) == null) {
                    return;
                }
                bVar.b(str);
                return;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return;
                    }
                    String valueOf = String.valueOf(calendar.get(1));
                    a7.b bVar2 = this.f8208d;
                    if (bVar2 != null) {
                        bVar2.a(valueOf);
                        return;
                    }
                    return;
                }
                String str2 = calendar.get(1) + "/" + String.format(Locale.ENGLISH, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(calendar.get(2) + 1)}, 1));
                a7.b bVar3 = this.f8208d;
                if (bVar3 != null) {
                    bVar3.c(str2);
                    return;
                }
                return;
            }
            Date time = calendar.getTime();
            kotlin.jvm.internal.e.e(time, "getTime(...)");
            Locale locale = Locale.ENGLISH;
            Date v6 = android.support.v4.media.session.e.v(Calendar.getInstance(locale), time, 7, 7, "getTime(...)");
            Date time2 = calendar.getTime();
            kotlin.jvm.internal.e.e(time2, "getTime(...)");
            Calendar calendar2 = Calendar.getInstance(locale);
            calendar2.setTime(time2);
            calendar2.set(7, calendar2.getActualMaximum(7));
            Date time3 = calendar2.getTime();
            kotlin.jvm.internal.e.e(time3, "getTime(...)");
            String j4 = ca.j(v6.getTime());
            if (j4 == null) {
                j4 = "";
            }
            String j10 = ca.j(time3.getTime());
            String str3 = j10 != null ? j10 : "";
            a7.b bVar4 = this.f8208d;
            if (bVar4 != null) {
                bVar4.d(j4, str3);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d4, code lost:
    
        if (r1 > (r3 != null ? r3.get(1) : -1)) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.testui.TRingDateSelectView.d():void");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.last;
        if (valueOf != null && valueOf.intValue() == i3) {
            Calendar calendar = this.f8206b;
            if (calendar != null) {
                int i10 = this.f8205a;
                if (i10 == 0) {
                    calendar.add(5, -1);
                    d();
                    return;
                }
                if (i10 == 1) {
                    calendar.add(3, -1);
                    d();
                    return;
                } else if (i10 == 2) {
                    calendar.add(2, -1);
                    d();
                    return;
                } else {
                    if (i10 != 3) {
                        return;
                    }
                    calendar.add(1, -1);
                    d();
                    return;
                }
            }
            return;
        }
        int i11 = R$id.next;
        if (valueOf == null || valueOf.intValue() != i11) {
            if (this.f8205a != 3) {
                getDateDialog().show();
                return;
            }
            return;
        }
        Calendar calendar2 = this.f8206b;
        if (calendar2 != null) {
            int i12 = this.f8205a;
            if (i12 == 0) {
                calendar2.add(5, 1);
                d();
                return;
            }
            if (i12 == 1) {
                calendar2.add(3, 1);
                d();
            } else if (i12 == 2) {
                calendar2.add(2, 1);
                d();
            } else {
                if (i12 != 3) {
                    return;
                }
                calendar2.add(1, 1);
                d();
            }
        }
    }

    public final void setDate(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        TextView textView = this.f8210g;
        if (textView != null) {
            textView.setText(date);
        } else {
            kotlin.jvm.internal.e.m("tvDateTv");
            throw null;
        }
    }

    public final void setDateColor(int i3) {
        TextView textView = this.f8210g;
        if (textView != null) {
            textView.setTextColor(i3);
        } else {
            kotlin.jvm.internal.e.m("tvDateTv");
            throw null;
        }
    }

    public final void setDateModel(int i3) {
        this.f8205a = i3;
        d();
    }

    public final void setOnDateSelectedListener(a7.b onDateSelectedListener) {
        kotlin.jvm.internal.e.f(onDateSelectedListener, "onDateSelectedListener");
        this.f8208d = onDateSelectedListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TRingDateSelectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ TRingDateSelectView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TRingDateSelectView(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.ring_view_date_select, this);
        View findViewById = findViewById(R$id.last);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.e = (ImageView) findViewById;
        View findViewById2 = findViewById(R$id.next);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8209f = (ImageView) findViewById2;
        View findViewById3 = findViewById(R$id.dateTv);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8210g = (TextView) findViewById3;
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setOnClickListener(this);
            ImageView imageView2 = this.f8209f;
            if (imageView2 != null) {
                imageView2.setOnClickListener(this);
                setOnClickListener(this);
                this.f8206b = Calendar.getInstance();
                Calendar calendar = Calendar.getInstance();
                this.f8207c = calendar;
                if (calendar != null) {
                    calendar.set(1, 1900);
                    calendar.set(2, 0);
                    calendar.set(6, 1);
                }
                d();
                this.f8211h = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDateSelectView$dateDialog$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // oh.a
                    public final com.example.test.ui.dialog.e invoke() {
                        com.example.test.ui.dialog.e eVar = new com.example.test.ui.dialog.e(context);
                        eVar.setOnDialogDataListener(new a1(this, 2));
                        return eVar;
                    }
                });
                return;
            }
            kotlin.jvm.internal.e.m("nextIv");
            throw null;
        }
        kotlin.jvm.internal.e.m("lastIv");
        throw null;
    }
}
