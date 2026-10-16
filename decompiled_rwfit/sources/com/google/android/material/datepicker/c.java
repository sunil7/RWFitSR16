package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.internal.mlkit_vision_barcode.s0;
import com.google.android.gms.internal.mlkit_vision_barcode.t0;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public final class c implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f10419a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10420b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f10421c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f10422d;
    public final Object e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f10423f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f10424g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f10425h;

    public c(ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout2) {
        this.f10419a = constraintLayout;
        this.f10420b = linearLayout;
        this.f10421c = imageView;
        this.f10422d = imageView2;
        this.e = textView;
        this.f10423f = textView2;
        this.f10424g = textView3;
        this.f10425h = linearLayout2;
    }

    @Override // m2.a
    public View b() {
        return (ConstraintLayout) this.f10419a;
    }

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(s0.b(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R$styleable.MaterialCalendar);
        this.f10419a = androidx.appcompat.widget.w.e(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayStyle, 0));
        this.f10424g = androidx.appcompat.widget.w.e(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f10420b = androidx.appcompat.widget.w.e(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f10421c = androidx.appcompat.widget.w.e(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList a3 = t0.a(context, obtainStyledAttributes, R$styleable.MaterialCalendar_rangeFillColor);
        this.f10422d = androidx.appcompat.widget.w.e(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearStyle, 0));
        this.e = androidx.appcompat.widget.w.e(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f10423f = androidx.appcompat.widget.w.e(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f10425h = paint;
        paint.setColor(a3.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
