package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.example.baselibrary.R$array;
import md.t;

/* loaded from: classes.dex */
public class DefaultYearView extends YearView {

    /* renamed from: t, reason: collision with root package name */
    public final int f11334t;

    public DefaultYearView(Context context) {
        super(context);
        this.f11334t = t.e(context, 3.0f);
    }

    @Override // com.haibin.calendarview.YearView
    public final void b(Canvas canvas, int i3, int i10, int i11) {
        canvas.drawText(getContext().getResources().getStringArray(R$array.month_string_array)[i3 - 1], ((this.f11362l / 2) + i10) - this.f11334t, i11 + this.f11364n, this.f11358h);
    }

    @Override // com.haibin.calendarview.YearView
    public final void c(Canvas canvas, Calendar calendar, int i3, int i10, boolean z5, boolean z6) {
        float f2 = this.f11363m + i10;
        int i11 = (this.f11362l / 2) + i3;
        Paint paint = this.e;
        if (z6) {
            String valueOf = String.valueOf(calendar.getDay());
            float f10 = i11;
            if (!z5) {
                paint = this.f11356f;
            }
            canvas.drawText(valueOf, f10, f2, paint);
            return;
        }
        Paint paint2 = this.f11354c;
        Paint paint3 = this.f11357g;
        if (z5) {
            String valueOf2 = String.valueOf(calendar.getDay());
            float f11 = i11;
            if (calendar.isCurrentDay()) {
                paint = paint3;
            } else if (!calendar.isCurrentMonth()) {
                paint = paint2;
            }
            canvas.drawText(valueOf2, f11, f2, paint);
            return;
        }
        String valueOf3 = String.valueOf(calendar.getDay());
        float f12 = i11;
        if (calendar.isCurrentDay()) {
            paint2 = paint3;
        } else if (calendar.isCurrentMonth()) {
            paint2 = this.f11353b;
        }
        canvas.drawText(valueOf3, f12, f2, paint2);
    }

    @Override // com.haibin.calendarview.YearView
    public final void d(Canvas canvas, int i3, int i10, int i11, int i12) {
        canvas.drawText(getContext().getResources().getStringArray(R$array.year_view_week_string_array)[i3], (i12 / 2) + i10, i11 + this.f11365o, this.f11359i);
    }
}
