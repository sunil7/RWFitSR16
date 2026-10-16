package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.example.test.ui.device.activity.f0;
import md.k;
import md.r;
import md.t;

/* loaded from: classes.dex */
public abstract class WeekView extends BaseWeekView {
    public WeekView(Context context) {
        super(context);
    }

    public abstract void i(Canvas canvas, Calendar calendar, int i3);

    public abstract boolean j(Canvas canvas, int i3);

    public abstract void k(Canvas canvas, Calendar calendar, int i3, boolean z5, boolean z6);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Calendar index;
        if (this.f11303u && (index = getIndex()) != null) {
            c();
            if (!b(index)) {
                k kVar = this.f11285a.f16067n0;
                return;
            }
            this.f11304v = this.f11298o.indexOf(index);
            f0 f0Var = this.f11285a.f16069o0;
            if (f0Var != null) {
                f0Var.x(index, true);
            }
            if (this.f11297n != null) {
                this.f11297n.h(t.u(index, this.f11285a.f16044b));
            }
            k kVar2 = this.f11285a.f16067n0;
            if (kVar2 != null) {
                kVar2.o(index);
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f11298o.size() == 0) {
            return;
        }
        int width = getWidth();
        r rVar = this.f11285a;
        this.f11300q = ((width - rVar.f16083w) - rVar.f16085x) / 7;
        g();
        int i3 = 0;
        while (i3 < this.f11298o.size()) {
            int i10 = (this.f11300q * i3) + this.f11285a.f16083w;
            Calendar calendar = (Calendar) this.f11298o.get(i3);
            boolean z5 = i3 == this.f11304v;
            boolean hasScheme = calendar.hasScheme();
            if (hasScheme) {
                if ((z5 ? j(canvas, i10) : false) || !z5) {
                    this.f11291h.setColor(calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.f11285a.O);
                    i(canvas, calendar, i10);
                }
            } else if (z5) {
                j(canvas, i10);
            }
            Canvas canvas2 = canvas;
            k(canvas2, calendar, i10, hasScheme, z5);
            i3++;
            canvas = canvas2;
        }
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f11285a.getClass();
        return false;
    }
}
