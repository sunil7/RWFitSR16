package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.example.test.ui.device.activity.f0;
import md.r;
import md.t;

/* loaded from: classes.dex */
public abstract class RangeMonthView extends BaseMonthView {
    public RangeMonthView(Context context) {
        super(context);
    }

    public final boolean i(Calendar calendar) {
        if (this.f11285a.f16080u0 == null) {
            return false;
        }
        c();
        r rVar = this.f11285a;
        return rVar.f16082v0 == null ? calendar.compareTo(rVar.f16080u0) == 0 : calendar.compareTo(rVar.f16080u0) >= 0 && calendar.compareTo(this.f11285a.f16082v0) <= 0;
    }

    public abstract void j(Canvas canvas, Calendar calendar, int i3, int i10);

    public abstract void k(Canvas canvas, Calendar calendar, int i3, int i10, boolean z5, boolean z6);

    public abstract void l(Canvas canvas, Calendar calendar, int i3, int i10, boolean z5, boolean z6);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Calendar index;
        MonthViewPager monthViewPager;
        int i3;
        if (this.f11303u && (index = getIndex()) != null) {
            if (this.f11285a.f16046c != 1 || index.isCurrentMonth()) {
                c();
                if (!b(index)) {
                    this.f11285a.getClass();
                    return;
                }
                r rVar = this.f11285a;
                Calendar calendar = rVar.f16080u0;
                if (calendar != null && rVar.f16082v0 == null) {
                    int d5 = t.d(index, calendar);
                    if (d5 >= 0 && (i3 = this.f11285a.f16084w0) != -1 && i3 > d5 + 1) {
                        return;
                    }
                    r rVar2 = this.f11285a;
                    int i10 = rVar2.f16086x0;
                    if (i10 != -1 && i10 < t.d(index, rVar2.f16080u0) + 1) {
                        this.f11285a.getClass();
                        return;
                    }
                }
                r rVar3 = this.f11285a;
                Calendar calendar2 = rVar3.f16080u0;
                if (calendar2 == null || rVar3.f16082v0 != null) {
                    rVar3.f16080u0 = index;
                    rVar3.f16082v0 = null;
                } else {
                    int compareTo = index.compareTo(calendar2);
                    r rVar4 = this.f11285a;
                    int i11 = rVar4.f16084w0;
                    if (i11 == -1 && compareTo <= 0) {
                        rVar4.f16080u0 = index;
                        rVar4.f16082v0 = null;
                    } else if (compareTo < 0) {
                        rVar4.f16080u0 = index;
                        rVar4.f16082v0 = null;
                    } else if (compareTo == 0 && i11 == 1) {
                        rVar4.f16082v0 = index;
                    } else {
                        rVar4.f16082v0 = index;
                    }
                }
                this.f11304v = this.f11298o.indexOf(index);
                if (!index.isCurrentMonth() && (monthViewPager = this.f11281w) != null) {
                    int currentItem = monthViewPager.getCurrentItem();
                    this.f11281w.setCurrentItem(this.f11304v < 7 ? currentItem - 1 : currentItem + 1);
                }
                f0 f0Var = this.f11285a.f16069o0;
                if (f0Var != null) {
                    f0Var.q(index, true);
                }
                if (this.f11297n != null) {
                    if (index.isCurrentMonth()) {
                        this.f11297n.g(this.f11298o.indexOf(index));
                    } else {
                        this.f11297n.h(t.u(index, this.f11285a.f16044b));
                    }
                }
                this.f11285a.getClass();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r2.isCurrentMonth() == false) goto L17;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDraw(android.graphics.Canvas r17) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.haibin.calendarview.RangeMonthView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return false;
    }
}
