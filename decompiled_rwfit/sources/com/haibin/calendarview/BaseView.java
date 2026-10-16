package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;
import md.r;
import md.t;

/* loaded from: classes.dex */
public abstract class BaseView extends View implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public r f11285a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f11286b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f11287c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f11288d;
    public final Paint e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f11289f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f11290g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f11291h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f11292i;

    /* renamed from: j, reason: collision with root package name */
    public final Paint f11293j;

    /* renamed from: k, reason: collision with root package name */
    public final Paint f11294k;

    /* renamed from: l, reason: collision with root package name */
    public final Paint f11295l;

    /* renamed from: m, reason: collision with root package name */
    public final Paint f11296m;

    /* renamed from: n, reason: collision with root package name */
    public CalendarLayout f11297n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f11298o;

    /* renamed from: p, reason: collision with root package name */
    public int f11299p;

    /* renamed from: q, reason: collision with root package name */
    public int f11300q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public float f11301s;

    /* renamed from: t, reason: collision with root package name */
    public float f11302t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f11303u;

    /* renamed from: v, reason: collision with root package name */
    public int f11304v;

    public BaseView(Context context) {
        this(context, null);
    }

    public final void a() {
        Map map = this.f11285a.f16065m0;
        if (map == null || map.size() == 0) {
            return;
        }
        ArrayList arrayList = this.f11298o;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Calendar calendar = (Calendar) obj;
            if (this.f11285a.f16065m0.containsKey(calendar.toString())) {
                Calendar calendar2 = (Calendar) this.f11285a.f16065m0.get(calendar.toString());
                if (calendar2 != null) {
                    calendar.setScheme(TextUtils.isEmpty(calendar2.getScheme()) ? this.f11285a.V : calendar2.getScheme());
                    calendar.setSchemeColor(calendar2.getSchemeColor());
                    calendar.setSchemes(calendar2.getSchemes());
                }
            } else {
                calendar.setScheme("");
                calendar.setSchemeColor(0);
                calendar.setSchemes(null);
            }
        }
    }

    public final boolean b(Calendar calendar) {
        r rVar = this.f11285a;
        return rVar != null && t.y(calendar, rVar);
    }

    public final void c() {
        this.f11285a.getClass();
    }

    public final void d() {
        Map map = this.f11285a.f16065m0;
        if (map != null && map.size() != 0) {
            a();
            invalidate();
            return;
        }
        ArrayList arrayList = this.f11298o;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Calendar calendar = (Calendar) obj;
            calendar.setScheme("");
            calendar.setSchemeColor(0);
            calendar.setSchemes(null);
        }
        invalidate();
    }

    public void e() {
        this.f11299p = this.f11285a.f16050e0;
        Paint.FontMetrics fontMetrics = this.f11286b.getFontMetrics();
        this.r = ((fontMetrics.bottom - fontMetrics.top) / 2.0f) + ((this.f11299p / 2) - fontMetrics.descent);
    }

    public final void f() {
        r rVar = this.f11285a;
        if (rVar == null) {
            return;
        }
        Paint paint = this.f11295l;
        paint.setColor(rVar.e);
        Paint paint2 = this.f11296m;
        paint2.setColor(this.f11285a.f16051f);
        Paint paint3 = this.f11286b;
        paint3.setColor(this.f11285a.f16060k);
        Paint paint4 = this.f11287c;
        paint4.setColor(this.f11285a.f16058j);
        Paint paint5 = this.f11288d;
        paint5.setColor(this.f11285a.f16066n);
        Paint paint6 = this.e;
        paint6.setColor(this.f11285a.f16064m);
        Paint paint7 = this.f11294k;
        paint7.setColor(this.f11285a.f16062l);
        Paint paint8 = this.f11289f;
        paint8.setColor(this.f11285a.f16068o);
        Paint paint9 = this.f11290g;
        paint9.setColor(this.f11285a.f16057i);
        this.f11291h.setColor(this.f11285a.O);
        Paint paint10 = this.f11293j;
        paint10.setColor(this.f11285a.f16055h);
        paint3.setTextSize(this.f11285a.f16047c0);
        paint4.setTextSize(this.f11285a.f16047c0);
        paint.setTextSize(this.f11285a.f16047c0);
        paint10.setTextSize(this.f11285a.f16047c0);
        paint7.setTextSize(this.f11285a.f16047c0);
        paint5.setTextSize(this.f11285a.f16049d0);
        paint6.setTextSize(this.f11285a.f16049d0);
        paint2.setTextSize(this.f11285a.f16049d0);
        paint8.setTextSize(this.f11285a.f16049d0);
        paint9.setTextSize(this.f11285a.f16049d0);
        Paint paint11 = this.f11292i;
        paint11.setStyle(Paint.Style.FILL);
        paint11.setColor(this.f11285a.P);
    }

    public int getCalendarPaddingLeft() {
        r rVar = this.f11285a;
        if (rVar != null) {
            return rVar.f16083w;
        }
        return 0;
    }

    public int getCalendarPaddingRight() {
        r rVar = this.f11285a;
        if (rVar != null) {
            return rVar.f16085x;
        }
        return 0;
    }

    public int getWeekStartWith() {
        r rVar = this.f11285a;
        if (rVar != null) {
            return rVar.f16044b;
        }
        return 1;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11301s = motionEvent.getX();
            this.f11302t = motionEvent.getY();
            this.f11303u = true;
        } else if (action == 1) {
            this.f11301s = motionEvent.getX();
            this.f11302t = motionEvent.getY();
        } else if (action == 2 && this.f11303u) {
            this.f11303u = Math.abs(motionEvent.getY() - this.f11302t) <= 50.0f;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setup(r rVar) {
        this.f11285a = rVar;
        rVar.getClass();
        f();
        e();
    }

    public BaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f11286b = paint;
        Paint paint2 = new Paint();
        this.f11287c = paint2;
        Paint paint3 = new Paint();
        this.f11288d = paint3;
        Paint paint4 = new Paint();
        this.e = paint4;
        Paint paint5 = new Paint();
        this.f11289f = paint5;
        Paint paint6 = new Paint();
        this.f11290g = paint6;
        Paint paint7 = new Paint();
        this.f11291h = paint7;
        Paint paint8 = new Paint();
        this.f11292i = paint8;
        Paint paint9 = new Paint();
        this.f11293j = paint9;
        Paint paint10 = new Paint();
        this.f11294k = paint10;
        Paint paint11 = new Paint();
        this.f11295l = paint11;
        Paint paint12 = new Paint();
        this.f11296m = paint12;
        this.f11303u = true;
        this.f11304v = -1;
        paint.setAntiAlias(true);
        Paint.Align align = Paint.Align.CENTER;
        paint.setTextAlign(align);
        paint.setColor(-15658735);
        paint.setFakeBoldText(true);
        paint.setTextSize(t.e(context, 14.0f));
        paint2.setAntiAlias(true);
        paint2.setTextAlign(align);
        paint2.setColor(-1973791);
        paint2.setFakeBoldText(true);
        paint2.setTextSize(t.e(context, 14.0f));
        paint3.setAntiAlias(true);
        paint3.setTextAlign(align);
        paint4.setAntiAlias(true);
        paint4.setTextAlign(align);
        paint5.setAntiAlias(true);
        paint5.setTextAlign(align);
        paint6.setAntiAlias(true);
        paint6.setTextAlign(align);
        paint9.setAntiAlias(true);
        Paint.Style style = Paint.Style.FILL;
        paint9.setStyle(style);
        paint9.setTextAlign(align);
        paint9.setColor(-1223853);
        paint9.setFakeBoldText(true);
        paint9.setTextSize(t.e(context, 14.0f));
        paint10.setAntiAlias(true);
        paint10.setStyle(style);
        paint10.setTextAlign(align);
        paint10.setColor(-1223853);
        paint10.setFakeBoldText(true);
        paint10.setTextSize(t.e(context, 14.0f));
        paint7.setAntiAlias(true);
        paint7.setStyle(style);
        paint7.setStrokeWidth(2.0f);
        paint7.setColor(-1052689);
        paint11.setAntiAlias(true);
        paint11.setTextAlign(align);
        paint11.setColor(-65536);
        paint11.setFakeBoldText(true);
        paint11.setTextSize(t.e(context, 14.0f));
        paint12.setAntiAlias(true);
        paint12.setTextAlign(align);
        paint12.setColor(-65536);
        paint12.setFakeBoldText(true);
        paint12.setTextSize(t.e(context, 14.0f));
        paint8.setAntiAlias(true);
        paint8.setStyle(style);
        paint8.setStrokeWidth(2.0f);
        setOnClickListener(this);
        setOnLongClickListener(this);
    }
}
