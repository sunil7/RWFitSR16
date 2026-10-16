package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import md.t;

/* loaded from: classes.dex */
public final class DefaultWeekView extends WeekView {
    public final float A;

    /* renamed from: w, reason: collision with root package name */
    public final Paint f11330w;

    /* renamed from: x, reason: collision with root package name */
    public final Paint f11331x;

    /* renamed from: y, reason: collision with root package name */
    public final float f11332y;

    /* renamed from: z, reason: collision with root package name */
    public final int f11333z;

    public DefaultWeekView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f11330w = paint;
        Paint paint2 = new Paint();
        this.f11331x = paint2;
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
        this.f11332y = e;
        this.f11333z = t.e(getContext(), 4.0f);
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        this.A = ((fontMetrics.bottom - fontMetrics.top) / 2.0f) + (e - fontMetrics.descent) + t.e(getContext(), 1.0f);
    }

    @Override // com.haibin.calendarview.WeekView
    public final void i(Canvas canvas, Calendar calendar, int i3) {
        Paint paint = this.f11331x;
        paint.setColor(calendar.getSchemeColor());
        int i10 = this.f11300q + i3;
        int i11 = this.f11333z;
        float f2 = this.f11332y;
        float f10 = f2 / 2.0f;
        float f11 = i11;
        canvas.drawCircle((i10 - i11) - f10, f11 + f2, f2, paint);
        String scheme = calendar.getScheme();
        Paint paint2 = this.f11330w;
        canvas.drawText(calendar.getScheme(), (((i3 + this.f11300q) - i11) - f10) - (paint2.measureText(scheme) / 2.0f), f11 + this.A, paint2);
    }

    @Override // com.haibin.calendarview.WeekView
    public final boolean j(Canvas canvas, int i3) {
        Paint paint = this.f11292i;
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(i3 + r0, this.f11333z, (i3 + this.f11300q) - r0, this.f11299p - r0, paint);
        return true;
    }

    @Override // com.haibin.calendarview.WeekView
    public final void k(Canvas canvas, Calendar calendar, int i3, boolean z5, boolean z6) {
        int i10 = (this.f11300q / 2) + i3;
        int i11 = (-this.f11299p) / 6;
        if (z6) {
            float f2 = i10;
            canvas.drawText(String.valueOf(calendar.getDay()), f2, this.r + i11, this.f11294k);
            canvas.drawText(calendar.getLunar(), f2, this.r + (this.f11299p / 10), this.e);
            return;
        }
        Paint paint = this.f11296m;
        Paint paint2 = this.f11287c;
        Paint paint3 = this.f11295l;
        if (z5) {
            String valueOf = String.valueOf(calendar.getDay());
            float f10 = i10;
            float f11 = this.r + i11;
            if (calendar.isCurrentDay()) {
                paint2 = paint3;
            } else if (calendar.isCurrentMonth()) {
                paint2 = this.f11293j;
            }
            canvas.drawText(valueOf, f10, f11, paint2);
            String lunar = calendar.getLunar();
            float f12 = this.r + (this.f11299p / 10);
            if (!calendar.isCurrentDay()) {
                paint = this.f11290g;
            }
            canvas.drawText(lunar, f10, f12, paint);
            return;
        }
        String valueOf2 = String.valueOf(calendar.getDay());
        float f13 = i10;
        float f14 = this.r + i11;
        if (calendar.isCurrentDay()) {
            paint2 = paint3;
        } else if (calendar.isCurrentMonth()) {
            paint2 = this.f11286b;
        }
        canvas.drawText(valueOf2, f13, f14, paint2);
        String lunar2 = calendar.getLunar();
        float f15 = this.r + (this.f11299p / 10);
        if (!calendar.isCurrentDay()) {
            paint = calendar.isCurrentMonth() ? this.f11288d : this.f11289f;
        }
        canvas.drawText(lunar2, f13, f15, paint);
    }
}
