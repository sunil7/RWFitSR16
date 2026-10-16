package com.example.test.ui.view.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MultiWeekView;

/* loaded from: classes.dex */
public class CustomMultiWeekView extends MultiWeekView {

    /* renamed from: w, reason: collision with root package name */
    public int f8676w;

    public CustomMultiWeekView(Context context) {
        super(context);
    }

    @Override // com.haibin.calendarview.BaseWeekView
    public final void g() {
        this.f8676w = (Math.min(this.f11300q, this.f11299p) / 5) * 2;
        this.f11291h.setStyle(Paint.Style.STROKE);
    }

    @Override // com.haibin.calendarview.MultiWeekView
    public final void j(Canvas canvas, int i3) {
        canvas.drawCircle((this.f11300q / 2) + i3, this.f11299p / 2, this.f8676w, this.f11291h);
    }

    @Override // com.haibin.calendarview.MultiWeekView
    public final void k(Canvas canvas, int i3, boolean z5, boolean z6) {
        int i10 = (this.f11300q / 2) + i3;
        int i11 = this.f11299p / 2;
        Paint paint = this.f11292i;
        if (!z5) {
            if (z6) {
                int i12 = this.f8676w;
                canvas.drawRect(i10, i11 - i12, i3 + r0, i12 + i11, paint);
            }
            canvas.drawCircle(i10, i11, this.f8676w, paint);
            return;
        }
        if (z6) {
            int i13 = this.f8676w;
            canvas.drawRect(i3, i11 - i13, i3 + r0, i11 + i13, paint);
        } else {
            int i14 = this.f8676w;
            float f2 = i10;
            canvas.drawRect(i3, i11 - i14, f2, i14 + i11, paint);
            canvas.drawCircle(f2, i11, this.f8676w, paint);
        }
    }

    @Override // com.haibin.calendarview.MultiWeekView
    public final void l(Canvas canvas, Calendar calendar, int i3, boolean z5, boolean z6) {
        float f2 = this.r;
        int i10 = (this.f11300q / 2) + i3;
        boolean b3 = b(calendar);
        c();
        if (z6) {
            canvas.drawText(String.valueOf(calendar.getDay()), i10, f2, this.f11294k);
            return;
        }
        Paint paint = this.f11287c;
        Paint paint2 = this.f11295l;
        if (z5) {
            String valueOf = String.valueOf(calendar.getDay());
            float f10 = i10;
            if (calendar.isCurrentDay()) {
                paint = paint2;
            } else if (calendar.isCurrentMonth() && b3) {
                paint = this.f11293j;
            }
            canvas.drawText(valueOf, f10, f2, paint);
            return;
        }
        String valueOf2 = String.valueOf(calendar.getDay());
        float f11 = i10;
        if (calendar.isCurrentDay()) {
            paint = paint2;
        } else if (calendar.isCurrentMonth() && b3) {
            paint = this.f11286b;
        }
        canvas.drawText(valueOf2, f11, f2, paint);
    }
}
