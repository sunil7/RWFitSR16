package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import md.r;

/* loaded from: classes.dex */
public abstract class YearView extends View {

    /* renamed from: a, reason: collision with root package name */
    public r f11352a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f11353b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f11354c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f11355d;
    public final Paint e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f11356f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f11357g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f11358h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f11359i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f11360j;

    /* renamed from: k, reason: collision with root package name */
    public int f11361k;

    /* renamed from: l, reason: collision with root package name */
    public int f11362l;

    /* renamed from: m, reason: collision with root package name */
    public float f11363m;

    /* renamed from: n, reason: collision with root package name */
    public float f11364n;

    /* renamed from: o, reason: collision with root package name */
    public float f11365o;

    /* renamed from: p, reason: collision with root package name */
    public int f11366p;

    /* renamed from: q, reason: collision with root package name */
    public int f11367q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f11368s;

    public YearView(Context context) {
        this(context, null);
    }

    private int getMonthViewTop() {
        r rVar = this.f11352a;
        return rVar.f16077t + rVar.B + rVar.f16079u + rVar.C;
    }

    public final void a(int i3, int i10) {
        Rect rect = new Rect();
        Paint paint = this.f11353b;
        paint.getTextBounds("1", 0, 1, rect);
        int height = (rect.height() * 12) + getMonthViewTop();
        if (i10 < height) {
            i10 = height;
        }
        getLayoutParams().width = i3;
        getLayoutParams().height = i10;
        this.f11361k = (i10 - getMonthViewTop()) / 6;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.f11363m = ((fontMetrics.bottom - fontMetrics.top) / 2.0f) + ((this.f11361k / 2) - fontMetrics.descent);
        Paint.FontMetrics fontMetrics2 = this.f11358h.getFontMetrics();
        this.f11364n = ((fontMetrics2.bottom - fontMetrics2.top) / 2.0f) + ((this.f11352a.B / 2) - fontMetrics2.descent);
        Paint.FontMetrics fontMetrics3 = this.f11359i.getFontMetrics();
        this.f11365o = ((fontMetrics3.bottom - fontMetrics3.top) / 2.0f) + ((this.f11352a.C / 2) - fontMetrics3.descent);
        invalidate();
    }

    public abstract void b(Canvas canvas, int i3, int i10, int i11);

    public abstract void c(Canvas canvas, Calendar calendar, int i3, int i10, boolean z5, boolean z6);

    public abstract void d(Canvas canvas, int i3, int i10, int i11, int i12);

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width = getWidth();
        r rVar = this.f11352a;
        int i3 = rVar.r;
        this.f11362l = ((width - i3) - rVar.f16075s) / 7;
        int i10 = this.f11367q;
        getWidth();
        int i11 = this.f11352a.f16075s;
        b(canvas, i10, i3, rVar.f16077t);
        r rVar2 = this.f11352a;
        if (rVar2.C > 0) {
            int i12 = rVar2.f16044b;
            if (i12 > 0) {
                i12--;
            }
            int width2 = getWidth();
            r rVar3 = this.f11352a;
            int i13 = ((width2 - rVar3.r) - rVar3.f16075s) / 7;
            int i14 = i12;
            for (int i15 = 0; i15 < 7; i15++) {
                r rVar4 = this.f11352a;
                d(canvas, i14, rVar4.r + (i15 * i13), rVar4.B + rVar4.f16077t + rVar4.f16079u, i13);
                i14++;
                if (i14 >= 7) {
                    i14 = 0;
                }
            }
        }
        int i16 = 0;
        int i17 = 0;
        while (i17 < this.f11368s) {
            int i18 = i16;
            for (int i19 = 0; i19 < 7; i19++) {
                Calendar calendar = (Calendar) this.f11360j.get(i18);
                if (i18 > this.f11360j.size() - this.r) {
                    return;
                }
                if (calendar.isCurrentMonth()) {
                    int i20 = this.f11352a.r + (this.f11362l * i19);
                    int monthViewTop = getMonthViewTop() + (this.f11361k * i17);
                    boolean equals = calendar.equals(this.f11352a.f16073q0);
                    boolean hasScheme = calendar.hasScheme();
                    if (hasScheme && !equals) {
                        this.f11355d.setColor(calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.f11352a.O);
                    }
                    c(canvas, calendar, i20, monthViewTop, hasScheme, equals);
                }
                i18++;
            }
            i17++;
            i16 = i18;
        }
    }

    public final void setup(r rVar) {
        this.f11352a = rVar;
        if (rVar == null) {
            return;
        }
        Paint paint = this.f11353b;
        paint.setTextSize(rVar.f16088z);
        Paint paint2 = this.e;
        paint2.setTextSize(this.f11352a.f16088z);
        Paint paint3 = this.f11354c;
        paint3.setTextSize(this.f11352a.f16088z);
        Paint paint4 = this.f11357g;
        paint4.setTextSize(this.f11352a.f16088z);
        Paint paint5 = this.f11356f;
        paint5.setTextSize(this.f11352a.f16088z);
        paint2.setColor(this.f11352a.F);
        paint.setColor(this.f11352a.E);
        paint3.setColor(this.f11352a.E);
        paint4.setColor(this.f11352a.H);
        paint5.setColor(this.f11352a.G);
        Paint paint6 = this.f11358h;
        paint6.setTextSize(this.f11352a.f16087y);
        paint6.setColor(this.f11352a.D);
        Paint paint7 = this.f11359i;
        paint7.setColor(this.f11352a.I);
        paint7.setTextSize(this.f11352a.A);
    }

    public YearView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f11353b = paint;
        Paint paint2 = new Paint();
        this.f11354c = paint2;
        Paint paint3 = new Paint();
        Paint paint4 = new Paint();
        Paint paint5 = new Paint();
        Paint paint6 = new Paint();
        Paint paint7 = new Paint();
        this.f11355d = paint7;
        Paint paint8 = new Paint();
        Paint paint9 = new Paint();
        this.e = paint9;
        Paint paint10 = new Paint();
        this.f11356f = paint10;
        Paint paint11 = new Paint();
        this.f11357g = paint11;
        Paint paint12 = new Paint();
        Paint paint13 = new Paint();
        this.f11358h = paint13;
        Paint paint14 = new Paint();
        this.f11359i = paint14;
        paint.setAntiAlias(true);
        Paint.Align align = Paint.Align.CENTER;
        paint.setTextAlign(align);
        paint.setColor(-15658735);
        paint.setFakeBoldText(true);
        paint2.setAntiAlias(true);
        paint2.setTextAlign(align);
        paint2.setColor(-1973791);
        paint2.setFakeBoldText(true);
        paint3.setAntiAlias(true);
        paint3.setTextAlign(align);
        paint4.setAntiAlias(true);
        paint4.setTextAlign(align);
        paint5.setAntiAlias(true);
        paint5.setTextAlign(align);
        paint13.setAntiAlias(true);
        paint13.setFakeBoldText(true);
        paint14.setAntiAlias(true);
        paint14.setFakeBoldText(true);
        paint14.setTextAlign(align);
        paint6.setAntiAlias(true);
        paint6.setTextAlign(align);
        paint9.setAntiAlias(true);
        Paint.Style style = Paint.Style.FILL;
        paint9.setStyle(style);
        paint9.setTextAlign(align);
        paint9.setColor(-1223853);
        paint9.setFakeBoldText(true);
        paint10.setAntiAlias(true);
        paint10.setStyle(style);
        paint10.setTextAlign(align);
        paint10.setColor(-1223853);
        paint10.setFakeBoldText(true);
        paint7.setAntiAlias(true);
        paint7.setStyle(style);
        paint7.setStrokeWidth(2.0f);
        paint7.setColor(-1052689);
        paint11.setAntiAlias(true);
        paint11.setTextAlign(align);
        paint11.setColor(-65536);
        paint11.setFakeBoldText(true);
        paint12.setAntiAlias(true);
        paint12.setTextAlign(align);
        paint12.setColor(-65536);
        paint12.setFakeBoldText(true);
        paint8.setAntiAlias(true);
        paint8.setStyle(style);
        paint8.setStrokeWidth(2.0f);
    }
}
