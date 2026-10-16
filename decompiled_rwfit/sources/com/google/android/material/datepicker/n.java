package com.google.android.material.datepicker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import java.util.ArrayList;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class n extends g1 {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f10445a = e0.f(null);

    /* renamed from: b, reason: collision with root package name */
    public final Calendar f10446b = e0.f(null);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f10447c;

    public n(MaterialCalendar materialCalendar) {
        this.f10447c = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.g1
    public final void f(Canvas canvas, RecyclerView recyclerView) {
        n nVar = this;
        if ((recyclerView.getAdapter() instanceof h0) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            h0 h0Var = (h0) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            MaterialCalendar materialCalendar = nVar.f10447c;
            ArrayList y4 = materialCalendar.f10394c.y();
            int size = y4.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = y4.get(i3);
                i3++;
                k1.c cVar = (k1.c) obj;
                Object obj2 = cVar.f15450a;
                if (obj2 != null) {
                    Object obj3 = cVar.f15451b;
                    if (obj3 != null) {
                        long longValue = ((Long) obj2).longValue();
                        Calendar calendar = nVar.f10445a;
                        calendar.setTimeInMillis(longValue);
                        long longValue2 = ((Long) obj3).longValue();
                        Calendar calendar2 = nVar.f10446b;
                        calendar2.setTimeInMillis(longValue2);
                        int i10 = calendar.get(1) - h0Var.f10432a.f10395d.n().f10406b;
                        int i11 = calendar2.get(1) - h0Var.f10432a.f10395d.n().f10406b;
                        View q5 = gridLayoutManager.q(i10);
                        View q8 = gridLayoutManager.q(i11);
                        int i12 = gridLayoutManager.F;
                        int i13 = i10 / i12;
                        int i14 = i11 / i12;
                        for (int i15 = i13; i15 <= i14; i15++) {
                            View q10 = gridLayoutManager.q(gridLayoutManager.F * i15);
                            if (q10 != null) {
                                int top = q10.getTop() + ((Rect) ((androidx.appcompat.widget.w) materialCalendar.f10397g.f10422d).f1072b).top;
                                int bottom = q10.getBottom() - ((Rect) ((androidx.appcompat.widget.w) materialCalendar.f10397g.f10422d).f1072b).bottom;
                                canvas.drawRect(i15 == i13 ? (q5.getWidth() / 2) + q5.getLeft() : 0, top, i15 == i14 ? (q8.getWidth() / 2) + q8.getLeft() : recyclerView.getWidth(), bottom, (Paint) materialCalendar.f10397g.f10425h);
                            }
                        }
                    }
                }
                nVar = this;
            }
        }
    }
}
