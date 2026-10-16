package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.example.test.ui.device.activity.f0;
import md.k;
import md.r;
import md.t;

/* loaded from: classes.dex */
public abstract class MonthView extends BaseMonthView {
    public MonthView(Context context) {
        super(context);
    }

    public abstract void i(Canvas canvas, Calendar calendar, int i3, int i10);

    public abstract boolean j(Canvas canvas, int i3, int i10);

    public abstract void k(Canvas canvas, Calendar calendar, int i3, int i10, boolean z5, boolean z6);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Calendar index;
        MonthViewPager monthViewPager;
        if (this.f11303u && (index = getIndex()) != null) {
            if (this.f11285a.f16046c != 1 || index.isCurrentMonth()) {
                c();
                if (!b(index)) {
                    k kVar = this.f11285a.f16067n0;
                    return;
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
                k kVar2 = this.f11285a.f16067n0;
                if (kVar2 != null) {
                    kVar2.o(index);
                }
            }
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        if (this.f11284z == 0) {
            return;
        }
        int width = getWidth();
        r rVar = this.f11285a;
        this.f11300q = ((width - rVar.f16083w) - rVar.f16085x) / 7;
        h();
        int i3 = this.f11284z * 7;
        int i10 = 0;
        for (int i11 = 0; i11 < this.f11284z; i11++) {
            int i12 = 0;
            while (i12 < 7) {
                Calendar calendar = (Calendar) this.f11298o.get(i10);
                int i13 = this.f11285a.f16046c;
                if (i13 == 1) {
                    if (i10 > this.f11298o.size() - this.B) {
                        return;
                    }
                    if (!calendar.isCurrentMonth()) {
                        i10++;
                        canvas2 = canvas;
                        i12++;
                        canvas = canvas2;
                    }
                } else if (i13 == 2 && i10 >= i3) {
                    return;
                }
                int i14 = (this.f11300q * i12) + this.f11285a.f16083w;
                int i15 = i11 * this.f11299p;
                boolean z5 = i10 == this.f11304v;
                boolean hasScheme = calendar.hasScheme();
                if (hasScheme) {
                    if ((z5 ? j(canvas, i14, i15) : false) || !z5) {
                        this.f11291h.setColor(calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.f11285a.O);
                        i(canvas, calendar, i14, i15);
                    }
                } else if (z5) {
                    j(canvas, i14, i15);
                }
                canvas2 = canvas;
                k(canvas2, calendar, i14, i15, hasScheme, z5);
                i10++;
                i12++;
                canvas = canvas2;
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f11285a.getClass();
        return false;
    }
}
