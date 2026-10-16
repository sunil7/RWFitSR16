package com.example.test.ui.view.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.example.baselibrary.utils.b;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MonthView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SimpleMonthView extends MonthView {
    public int C;
    public int D;
    public final Paint E;
    public final Paint F;
    public int G;

    public SimpleMonthView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.E = paint;
        Paint paint2 = new Paint();
        this.F = paint2;
        paint2.setAntiAlias(true);
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        paint2.setColor(858430889);
        paint.setAntiAlias(true);
        paint.setStyle(style);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(-65536);
    }

    @Override // com.haibin.calendarview.BaseMonthView
    public final void h() {
        this.C = (Math.min(this.f11300q, this.f11299p) / 5) * 2;
        this.D = b.f(getContext(), 2.0f);
        this.G = b.f(getContext(), 10.0f);
        this.f11291h.setStyle(Paint.Style.STROKE);
    }

    @Override // com.haibin.calendarview.MonthView
    public final void i(Canvas canvas, Calendar calendar, int i3, int i10) {
        ArrayList arrayList = this.f11298o;
        boolean z5 = arrayList != null && arrayList.indexOf(calendar) == this.f11304v;
        Paint paint = this.E;
        if (z5) {
            paint.setColor(-16711936);
        } else {
            paint.setColor(-65536);
        }
        canvas.drawCircle((this.f11300q / 2) + i3, (i10 + this.f11299p) - this.G, this.D, paint);
    }

    @Override // com.haibin.calendarview.MonthView
    public final boolean j(Canvas canvas, int i3, int i10) {
        canvas.drawCircle((this.f11300q / 2) + i3, (this.f11299p / 2) + i10, this.C, this.f11292i);
        return false;
    }

    @Override // com.haibin.calendarview.MonthView
    public final void k(Canvas canvas, Calendar calendar, int i3, int i10, boolean z5, boolean z6) {
        Rect rect = new Rect();
        Paint paint = this.f11295l;
        paint.getTextBounds(String.valueOf(calendar.getDay()), 0, String.valueOf(calendar.getDay()).length(), rect);
        float height = (this.r + i10) - (rect.height() / 4);
        int i11 = (this.f11300q / 2) + i3;
        int i12 = (this.f11299p / 2) + i10;
        if (calendar.isCurrentDay() && !z6) {
            canvas.drawCircle(i11, i12, this.C, this.F);
        }
        if (z6) {
            canvas.drawText(String.valueOf(calendar.getDay()), i11, height, this.f11294k);
        } else {
            Paint paint2 = this.f11287c;
            if (z5) {
                String valueOf = String.valueOf(calendar.getDay());
                float f2 = i11;
                if (!calendar.isCurrentDay()) {
                    paint = calendar.isCurrentMonth() ? this.f11293j : paint2;
                }
                canvas.drawText(valueOf, f2, height, paint);
            } else {
                Calendar calendar2 = new Calendar();
                calendar2.setYear(this.f11285a.W);
                calendar2.setMonth(this.f11285a.Y);
                calendar2.setDay(this.f11285a.f16043a0);
                Calendar calendar3 = new Calendar();
                calendar3.setYear(this.f11285a.X);
                calendar3.setMonth(this.f11285a.Z);
                calendar3.setDay(this.f11285a.f16045b0);
                String valueOf2 = String.valueOf(calendar.getDay());
                float f10 = i11;
                if (!calendar.isCurrentDay()) {
                    paint = (!calendar.isCurrentMonth() || calendar.getTimeInMillis() > calendar3.getTimeInMillis() || calendar.getTimeInMillis() < calendar2.getTimeInMillis()) ? paint2 : this.f11286b;
                }
                canvas.drawText(valueOf2, f10, height, paint);
            }
        }
        if (z5) {
            Paint paint3 = this.E;
            if (z6) {
                paint3.setColor(-1);
            } else {
                paint3.setColor(-13984343);
            }
            canvas.drawCircle((this.f11300q / 2) + i3, (i10 + this.f11299p) - this.G, this.D, paint3);
        }
    }
}
