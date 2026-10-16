package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.example.test.ui.device.activity.f0;
import md.r;
import md.t;

/* loaded from: classes.dex */
public abstract class RangeWeekView extends BaseWeekView {
    public RangeWeekView(Context context) {
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

    public abstract void j(Canvas canvas, int i3);

    public abstract void k(Canvas canvas, int i3, boolean z5, boolean z6);

    public abstract void l(Canvas canvas, Calendar calendar, int i3, boolean z5, boolean z6);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Calendar index;
        int i3;
        if (this.f11303u && (index = getIndex()) != null) {
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
            boolean z5 = this.f11285a.f16080u0 != null && i(calendar);
            if (i3 == this.f11298o.size() - 1) {
                calendar2 = t.p(calendar3);
                this.f11285a.e(calendar2);
            } else {
                calendar2 = (Calendar) this.f11298o.get(i3 + 1);
            }
            boolean z6 = this.f11285a.f16080u0 != null && i(calendar2);
            boolean hasScheme = calendar3.hasScheme();
            if (hasScheme) {
                if (i11) {
                    k(canvas, i10, z5, z6);
                }
                if (!i11) {
                    this.f11291h.setColor(calendar3.getSchemeColor() != 0 ? calendar3.getSchemeColor() : this.f11285a.O);
                    j(canvas, i10);
                }
            } else if (i11) {
                k(canvas, i10, z5, z6);
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
