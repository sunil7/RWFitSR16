package com.haibin.calendarview;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import md.k;
import md.r;
import md.t;

/* loaded from: classes.dex */
public abstract class BaseWeekView extends BaseView {
    public BaseWeekView(Context context) {
        super(context);
    }

    public void g() {
    }

    public Calendar getIndex() {
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
                if (i10 < 0 || i10 >= this.f11298o.size()) {
                    return null;
                }
                return (Calendar) this.f11298o.get(i10);
            }
        }
        this.f11285a.getClass();
        return null;
    }

    public final void h(Calendar calendar, boolean z5) {
        ArrayList arrayList;
        if (this.f11297n == null || this.f11285a.f16069o0 == null || (arrayList = this.f11298o) == null || arrayList.size() == 0) {
            return;
        }
        int v6 = t.v(calendar.getYear(), calendar.getMonth(), calendar.getDay(), this.f11285a.f16044b);
        if (this.f11298o.contains(this.f11285a.f16056h0)) {
            r rVar = this.f11285a;
            Calendar calendar2 = rVar.f16056h0;
            int v9 = t.v(calendar2.getYear(), calendar2.getMonth(), calendar2.getDay(), rVar.f16044b);
            if (v6 > v9) {
                v6 = v9;
            }
        }
        Calendar calendar3 = (Calendar) this.f11298o.get(v6);
        r rVar2 = this.f11285a;
        if (rVar2.f16048d != 0) {
            if (this.f11298o.contains(rVar2.f16073q0)) {
                calendar3 = this.f11285a.f16073q0;
            } else {
                this.f11304v = -1;
            }
        }
        if (!b(calendar3)) {
            java.util.Calendar calendar4 = java.util.Calendar.getInstance();
            r rVar3 = this.f11285a;
            calendar4.set(rVar3.W, rVar3.Y - 1, rVar3.f16043a0);
            long timeInMillis = calendar4.getTimeInMillis();
            calendar4.set(calendar3.getYear(), calendar3.getMonth() - 1, calendar3.getDay());
            boolean z6 = calendar4.getTimeInMillis() < timeInMillis;
            v6 = 0;
            while (true) {
                if (v6 < this.f11298o.size()) {
                    boolean b3 = b((Calendar) this.f11298o.get(v6));
                    if (!z6 || !b3) {
                        if (!z6 && !b3) {
                            v6--;
                            break;
                        }
                        v6++;
                    } else {
                        break;
                    }
                } else {
                    v6 = z6 ? 6 : 0;
                }
            }
            calendar3 = (Calendar) this.f11298o.get(v6);
        }
        calendar3.setCurrentDay(calendar3.equals(this.f11285a.f16056h0));
        this.f11285a.f16069o0.x(calendar3, false);
        this.f11297n.h(t.u(calendar3, this.f11285a.f16044b));
        r rVar4 = this.f11285a;
        k kVar = rVar4.f16067n0;
        if (kVar != null && z5 && rVar4.f16048d == 0) {
            kVar.o(calendar3);
        }
        this.f11297n.f();
        r rVar5 = this.f11285a;
        if (rVar5.f16048d == 0) {
            this.f11304v = v6;
        }
        if (rVar5.f16074r0 != null && calendar.getYear() != this.f11285a.f16074r0.getYear()) {
            this.f11285a.getClass();
        }
        this.f11285a.f16074r0 = calendar3;
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.f11299p, 1073741824));
    }

    public final void setSelectedCalendar(Calendar calendar) {
        r rVar = this.f11285a;
        if (rVar.f16048d != 1 || calendar.equals(rVar.f16073q0)) {
            this.f11304v = this.f11298o.indexOf(calendar);
        }
    }

    public final void setup(Calendar calendar) {
        r rVar = this.f11285a;
        int i3 = rVar.f16044b;
        this.f11298o = t.x(calendar, rVar);
        a();
        invalidate();
    }
}
