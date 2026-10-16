package com.example.test.ui.view.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MultiMonthView;

/* loaded from: classes.dex */
public class CustomMultiMonthView extends MultiMonthView {
    public int C;

    public CustomMultiMonthView(Context context) {
        super(context);
    }

    @Override // com.haibin.calendarview.BaseMonthView
    public final void h() {
        this.C = (Math.min(this.f11300q, this.f11299p) / 5) * 2;
        Paint paint = this.f11291h;
        paint.setColor(Color.parseColor("#FF3C3F"));
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // com.haibin.calendarview.MultiMonthView
    public final void j(Canvas canvas, Calendar calendar, int i3, int i10) {
        Log.d("tong", "onDrawScheme --->");
        canvas.drawCircle((this.f11300q / 2) + i3, (this.f11299p / 2) + i10, this.C, this.f11291h);
    }

    @Override // com.haibin.calendarview.MultiMonthView
    public final void k(Canvas canvas, Calendar calendar, int i3, int i10, boolean z5, boolean z6) {
        Log.d("tong", "onDrawSelected---> Year = " + calendar.getYear() + " /" + calendar.getMonth() + "/" + calendar.getDay());
        int i11 = (this.f11300q / 2) + i3;
        int i12 = (this.f11299p / 2) + i10;
        Paint paint = this.f11292i;
        if (!z5) {
            Log.d("tong", "isSelectedPre---false");
            if (z6) {
                int i13 = this.C;
                canvas.drawRect(i11, i12 - i13, i3 + this.f11300q, i13 + i12, paint);
            }
            canvas.drawCircle(i11, i12, this.C, paint);
            return;
        }
        Log.d("tong", "isSelectedPre---true");
        if (z6) {
            Log.d("tong", "isSelectedNext---true");
            int i14 = this.C;
            canvas.drawRect(i3, i12 - i14, i3 + this.f11300q, i12 + i14, paint);
        } else {
            Log.d("tong", "isSelectedNext---false");
            int i15 = this.C;
            float f2 = i11;
            canvas.drawRect(i3, i12 - i15, f2, i15 + i12, paint);
            canvas.drawCircle(f2, i12, this.C, paint);
        }
    }

    @Override // com.haibin.calendarview.MultiMonthView
    public final void l(Canvas canvas, Calendar calendar, int i3, int i10, boolean z5, boolean z6) {
        float f2 = this.r + i10;
        int i11 = (this.f11300q / 2) + i3;
        boolean b3 = b(calendar);
        c();
        if (z6) {
            canvas.drawText(String.valueOf(calendar.getDay()), i11, f2, this.f11294k);
            return;
        }
        Paint paint = this.f11287c;
        Paint paint2 = this.f11295l;
        if (z5) {
            String valueOf = String.valueOf(calendar.getDay());
            float f10 = i11;
            if (calendar.isCurrentDay()) {
                paint = paint2;
            } else if (calendar.isCurrentMonth() && b3) {
                paint = this.f11293j;
            }
            canvas.drawText(valueOf, f10, f2, paint);
            return;
        }
        String valueOf2 = String.valueOf(calendar.getDay());
        float f11 = i11;
        if (calendar.isCurrentDay()) {
            paint = paint2;
        } else if (calendar.isCurrentMonth() && b3) {
            paint = this.f11286b;
        }
        canvas.drawText(valueOf2, f11, f2, paint);
    }
}
