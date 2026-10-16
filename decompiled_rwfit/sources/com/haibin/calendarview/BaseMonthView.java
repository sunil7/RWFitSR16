package com.haibin.calendarview;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import md.r;
import md.t;

/* loaded from: classes.dex */
public abstract class BaseMonthView extends BaseView {
    public int A;
    public int B;

    /* renamed from: w, reason: collision with root package name */
    public MonthViewPager f11281w;

    /* renamed from: x, reason: collision with root package name */
    public int f11282x;

    /* renamed from: y, reason: collision with root package name */
    public int f11283y;

    /* renamed from: z, reason: collision with root package name */
    public int f11284z;

    public BaseMonthView(Context context) {
        super(context);
    }

    @Override // com.haibin.calendarview.BaseView
    public final void e() {
        super.e();
        int i3 = this.f11282x;
        int i10 = this.f11283y;
        int i11 = this.f11299p;
        r rVar = this.f11285a;
        this.A = t.m(i3, i10, i11, rVar.f16044b, rVar.f16046c);
    }

    public final void g() {
        int i3 = this.f11282x;
        int i10 = this.f11283y;
        this.B = t.k(i3, i10, t.j(i3, i10), this.f11285a.f16044b);
        int n4 = t.n(this.f11282x, this.f11283y, this.f11285a.f16044b);
        int j4 = t.j(this.f11282x, this.f11283y);
        int i11 = this.f11282x;
        int i12 = this.f11283y;
        r rVar = this.f11285a;
        ArrayList w8 = t.w(i11, i12, rVar.f16056h0, rVar.f16044b);
        this.f11298o = w8;
        if (w8.contains(this.f11285a.f16056h0)) {
            this.f11304v = this.f11298o.indexOf(this.f11285a.f16056h0);
        } else {
            this.f11304v = this.f11298o.indexOf(this.f11285a.f16073q0);
        }
        if (this.f11304v > 0) {
            this.f11285a.getClass();
        }
        if (this.f11285a.f16046c == 0) {
            this.f11284z = 6;
        } else {
            this.f11284z = ((n4 + j4) + this.B) / 7;
        }
        a();
        invalidate();
    }

    public Calendar getIndex() {
        if (this.f11300q != 0 && this.f11299p != 0) {
            float f2 = this.f11301s;
            if (f2 > this.f11285a.f16083w) {
                int width = getWidth();
                r rVar = this.f11285a;
                if (f2 < width - rVar.f16085x) {
                    int i3 = ((int) (this.f11301s - rVar.f16083w)) / this.f11300q;
                    if (i3 >= 7) {
                        i3 = 6;
                    }
                    int i10 = ((((int) this.f11302t) / this.f11299p) * 7) + i3;
                    if (i10 >= 0 && i10 < this.f11298o.size()) {
                        return (Calendar) this.f11298o.get(i10);
                    }
                }
            }
            this.f11285a.getClass();
        }
        return null;
    }

    public void h() {
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        if (this.f11284z != 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(this.A, 1073741824);
        }
        super.onMeasure(i3, i10);
    }

    public final void setSelectedCalendar(Calendar calendar) {
        this.f11304v = this.f11298o.indexOf(calendar);
    }
}
