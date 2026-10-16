package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.example.test.ui.device.activity.f0;
import md.r;
import md.t;

/* loaded from: classes.dex */
public abstract class MultiWeekView extends BaseWeekView {
    public MultiWeekView(Context context) {
        super(context);
    }

    public final boolean i(Calendar calendar) {
        c();
        return this.f11285a.f16076s0.containsKey(calendar.toString());
    }

    public abstract void j(Canvas canvas, int i3);

    public abstract void k(Canvas canvas, int i3, boolean z5, boolean z6);

    public abstract void l(Canvas canvas, Calendar calendar, int i3, boolean z5, boolean z6);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Calendar index;
        if (this.f11303u && (index = getIndex()) != null) {
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
            f0 f0Var = this.f11285a.f16069o0;
            if (f0Var != null) {
                f0Var.x(index, true);
            }
            if (this.f11297n != null) {
                this.f11297n.h(t.u(index, this.f11285a.f16044b));
            }
            this.f11285a.getClass();
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Calendar calendar;
        Calendar calendar2;
        if (this.f11298o.size() == 0) {
            return;
        }
        int width = getWidth();
        r rVar = this.f11285a;
        this.f11300q = ((width - rVar.f16083w) - rVar.f16085x) / 7;
        g();
        int i3 = 0;
        while (i3 < 7) {
            int i10 = (this.f11300q * i3) + this.f11285a.f16083w;
            Calendar calendar3 = (Calendar) this.f11298o.get(i3);
            boolean i11 = i(calendar3);
            if (i3 == 0) {
                calendar = t.q(calendar3);
                this.f11285a.e(calendar);
            } else {
                calendar = (Calendar) this.f11298o.get(i3 - 1);
            }
            boolean i12 = i(calendar);
            if (i3 == this.f11298o.size() - 1) {
                calendar2 = t.p(calendar3);
                this.f11285a.e(calendar2);
            } else {
                calendar2 = (Calendar) this.f11298o.get(i3 + 1);
            }
            boolean i13 = i(calendar2);
            boolean hasScheme = calendar3.hasScheme();
            if (hasScheme) {
                if (i11) {
                    k(canvas, i10, i12, i13);
                }
                if (!i11) {
                    this.f11291h.setColor(calendar3.getSchemeColor() != 0 ? calendar3.getSchemeColor() : this.f11285a.O);
                    j(canvas, i10);
                }
            } else if (i11) {
                k(canvas, i10, i12, i13);
            }
            Canvas canvas2 = canvas;
            l(canvas2, calendar3, i10, hasScheme, i11);
            i3++;
            canvas = canvas2;
        }
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return false;
    }
}
