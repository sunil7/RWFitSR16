package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.example.test.ui.device.activity.f0;
import md.r;
import md.t;

/* loaded from: classes.dex */
public abstract class MultiMonthView extends BaseMonthView {
    public MultiMonthView(Context context) {
        super(context);
    }

    public final boolean i(Calendar calendar) {
        c();
        return this.f11285a.f16076s0.containsKey(calendar.toString());
    }

    public abstract void j(Canvas canvas, Calendar calendar, int i3, int i10);

    public abstract void k(Canvas canvas, Calendar calendar, int i3, int i10, boolean z5, boolean z6);

    public abstract void l(Canvas canvas, Calendar calendar, int i3, int i10, boolean z5, boolean z6);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Calendar index;
        MonthViewPager monthViewPager;
        if (this.f11303u && (index = getIndex()) != null) {
            if (this.f11285a.f16046c != 1 || index.isCurrentMonth()) {
                c();
                if (!b(index)) {
                    this.f11285a.getClass();
                    return;
                }
                String calendar = index.toString();
                if (this.f11285a.f16076s0.containsKey(calendar)) {
                    this.f11285a.f16076s0.remove(calendar);
                } else {
                    int size = this.f11285a.f16076s0.size();
                    r rVar = this.f11285a;
                    if (size >= rVar.f16078t0) {
                        return;
                    } else {
                        rVar.f16076s0.put(calendar, index);
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004e, code lost:
    
        if (r9.isCurrentMonth() == false) goto L17;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDraw(android.graphics.Canvas r16) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.haibin.calendarview.MultiMonthView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return false;
    }
}
