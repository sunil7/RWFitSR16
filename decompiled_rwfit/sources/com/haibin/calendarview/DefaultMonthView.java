package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import md.t;

/* loaded from: classes.dex */
public final class DefaultMonthView extends MonthView {
    public final Paint C;
    public final Paint D;
    public final float E;
    public final int F;
    public final float G;

    public DefaultMonthView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.C = paint;
        Paint paint2 = new Paint();
        this.D = paint2;
        paint.setTextSize(t.e(context, 8.0f));
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setFakeBoldText(true);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setColor(-1223853);
        paint2.setFakeBoldText(true);
        float e = t.e(getContext(), 7.0f);
        this.E = e;
        this.F = t.e(getContext(), 4.0f);
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        this.G = ((fontMetrics.bottom - fontMetrics.top) / 2.0f) + (e - fontMetrics.descent) + t.e(getContext(), 1.0f);
    }

    @Override // com.haibin.calendarview.MonthView
    public final void i(Canvas canvas, Calendar calendar, int i3, int i10) {
        Paint paint = this.D;
        paint.setColor(calendar.getSchemeColor());
        int i11 = this.f11300q + i3;
        int i12 = this.F;
        float f2 = this.E;
        float f10 = f2 / 2.0f;
        float f11 = i10 + i12;
        canvas.drawCircle((i11 - i12) - f10, f11 + f2, f2, paint);
        String scheme = calendar.getScheme();
        Paint paint2 = this.C;
        canvas.drawText(calendar.getScheme(), (((i3 + this.f11300q) - i12) - f10) - (paint2.measureText(scheme) / 2.0f), f11 + this.G, paint2);
    }

    @Override // com.haibin.calendarview.MonthView
    public final boolean j(Canvas canvas, int i3, int i10) {
        Paint paint = this.f11292i;
        paint.setStyle(Paint.Style.FILL);
        int i11 = this.F;
        canvas.drawRect(i3 + i11, i10 + i11, (i3 + this.f11300q) - i11, (i10 + this.f11299p) - i11, paint);
        return true;
    }

    @Override // com.haibin.calendarview.MonthView
    public final void k(Canvas canvas, Calendar calendar, int i3, int i10, boolean z5, boolean z6) {
        int i11 = (this.f11300q / 2) + i3;
        int i12 = i10 - (this.f11299p / 6);
        if (z6) {
            float f2 = i11;
            canvas.drawText(String.valueOf(calendar.getDay()), f2, this.r + i12, this.f11294k);
            canvas.drawText(calendar.getLunar(), f2, this.r + i10 + (this.f11299p / 10), this.e);
            return;
        }
        Paint paint = this.f11296m;
        Paint paint2 = this.f11287c;
        Paint paint3 = this.f11295l;
        if (z5) {
            String valueOf = String.valueOf(calendar.getDay());
            float f10 = i11;
            float f11 = this.r + i12;
            if (calendar.isCurrentDay()) {
                paint2 = paint3;
            } else if (calendar.isCurrentMonth()) {
                paint2 = this.f11293j;
            }
            canvas.drawText(valueOf, f10, f11, paint2);
            String lunar = calendar.getLunar();
            float f12 = this.r + i10 + (this.f11299p / 10);
            if (!calendar.isCurrentDay()) {
                paint = this.f11290g;
            }
            canvas.drawText(lunar, f10, f12, paint);
            return;
        }
        String valueOf2 = String.valueOf(calendar.getDay());
        float f13 = i11;
        float f14 = this.r + i12;
        if (calendar.isCurrentDay()) {
            paint2 = paint3;
        } else if (calendar.isCurrentMonth()) {
            paint2 = this.f11286b;
        }
        canvas.drawText(valueOf2, f13, f14, paint2);
        String lunar2 = calendar.getLunar();
        float f15 = this.r + i10 + (this.f11299p / 10);
        if (!calendar.isCurrentDay()) {
            paint = calendar.isCurrentMonth() ? this.f11288d : this.f11289f;
        }
        canvas.drawText(lunar2, f13, f15, paint);
    }
}
