package com.example.test.ui.view.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.example.baselibrary.utils.b;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.WeekView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SimpleWeekView extends WeekView {
    public int A;

    /* renamed from: w, reason: collision with root package name */
    public int f8679w;

    /* renamed from: x, reason: collision with root package name */
    public int f8680x;

    /* renamed from: y, reason: collision with root package name */
    public final Paint f8681y;

    /* renamed from: z, reason: collision with root package name */
    public final Paint f8682z;

    public SimpleWeekView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f8681y = paint;
        Paint paint2 = new Paint();
        this.f8682z = paint2;
        paint2.setAntiAlias(true);
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        paint2.setColor(855695596);
        paint.setAntiAlias(true);
        paint.setStyle(style);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(-65536);
        this.f11294k.setColor(0);
    }

    @Override // com.haibin.calendarview.BaseWeekView
    public final void g() {
        this.f8679w = (Math.min(this.f11300q, this.f11299p) / 5) * 2;
        this.f11291h.setStyle(Paint.Style.STROKE);
        this.f8680x = b.f(getContext(), 2.0f);
        this.A = b.f(getContext(), 12.0f);
    }

    @Override // com.haibin.calendarview.WeekView
    public final void i(Canvas canvas, Calendar calendar, int i3) {
        ArrayList arrayList = this.f11298o;
        boolean z5 = arrayList != null && arrayList.indexOf(calendar) == this.f11304v;
        Paint paint = this.f8681y;
        if (z5) {
            paint.setColor(-1);
        } else {
            paint.setColor(-13984343);
        }
        canvas.drawCircle((this.f11300q / 2) + i3, (this.r + this.f11299p) - this.A, this.f8680x, paint);
    }

    @Override // com.haibin.calendarview.WeekView
    public final boolean j(Canvas canvas, int i3) {
        canvas.drawCircle((this.f11300q / 2) + i3, this.f11299p / 2, this.f8679w, this.f11292i);
        return false;
    }

    @Override // com.haibin.calendarview.WeekView
    public final void k(Canvas canvas, Calendar calendar, int i3, boolean z5, boolean z6) {
        Rect rect = new Rect();
        Paint paint = this.f11295l;
        paint.getTextBounds(String.valueOf(calendar.getDay()), 0, String.valueOf(calendar.getDay()).length(), rect);
        float height = this.r - (rect.height() / 4);
        int i10 = (this.f11300q / 2) + i3;
        int i11 = this.f11299p / 2;
        if (calendar.isCurrentDay() && !z6) {
            canvas.drawCircle(i10, i11, this.f8679w, this.f8682z);
        }
        if (z6) {
            canvas.drawText(String.valueOf(calendar.getDay()), i10, height, this.f11294k);
        } else if (z5) {
            String valueOf = String.valueOf(calendar.getDay());
            float f2 = i10;
            if (!calendar.isCurrentDay()) {
                calendar.isCurrentMonth();
                paint = this.f11293j;
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
            float f10 = i10;
            if (!calendar.isCurrentDay()) {
                paint = (!calendar.isCurrentMonth() || calendar.getTimeInMillis() > calendar3.getTimeInMillis() || calendar.getTimeInMillis() < calendar2.getTimeInMillis()) ? this.f11287c : this.f11286b;
            }
            canvas.drawText(valueOf2, f10, height, paint);
        }
        if (z5) {
            Paint paint2 = this.f8681y;
            if (z6) {
                paint2.setColor(-1);
            } else {
                paint2.setColor(-13984343);
            }
            canvas.drawCircle((this.f11300q / 2) + i3, this.f11299p - this.A, this.f8680x, paint2);
        }
    }
}
