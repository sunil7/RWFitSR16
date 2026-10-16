package com.example.test.ui.view.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.example.test.XXApplication;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.RangeMonthView;
import md.t;

/* loaded from: classes.dex */
public class CustomRangeMonthView extends RangeMonthView {
    public int C;
    public final Paint D;
    public final Paint E;

    public CustomRangeMonthView(Context context) {
        super(context);
        this.D = new Paint();
        this.E = new Paint();
    }

    @Override // com.haibin.calendarview.BaseMonthView
    public final void h() {
        this.C = (Math.min(this.f11300q, this.f11299p) / 5) * 2;
        this.f11291h.setStyle(Paint.Style.FILL);
    }

    @Override // com.haibin.calendarview.RangeMonthView
    public final void j(Canvas canvas, Calendar calendar, int i3, int i10) {
        int i11 = (this.f11300q / 2) + i3;
        int i12 = (this.f11299p / 2) + i10;
        Paint paint = this.D;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(calendar.getSchemeColor());
        canvas.drawCircle(i11, i12, this.C, paint);
    }

    @Override // com.haibin.calendarview.RangeMonthView
    public final void k(Canvas canvas, Calendar calendar, int i3, int i10, boolean z5, boolean z6) {
        int i11 = (this.f11300q / 2) + i3;
        int i12 = (this.f11299p / 2) + i10;
        Paint paint = this.D;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(calendar.getSchemeColor());
        canvas.drawCircle(i11, i12, this.C, paint);
    }

    @Override // com.haibin.calendarview.RangeMonthView
    public final void l(Canvas canvas, Calendar calendar, int i3, int i10, boolean z5, boolean z6) {
        float f2 = this.r + i10;
        int i11 = (this.f11300q / 2) + i3;
        boolean b3 = b(calendar);
        c();
        if (z6) {
            canvas.drawText(String.valueOf(calendar.getDay()), i11, f2, this.f11294k);
            return;
        }
        if (!z5) {
            canvas.drawText(String.valueOf(calendar.getDay()), i11, f2, calendar.isCurrentDay() ? this.f11295l : (calendar.isCurrentMonth() && b3) ? this.f11286b : this.f11287c);
            return;
        }
        Paint paint = this.E;
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setFakeBoldText(true);
        paint.setTextSize(t.e(XXApplication.f7400h, 14.0f));
        canvas.drawText(String.valueOf(calendar.getDay()), i11, f2, paint);
    }
}
