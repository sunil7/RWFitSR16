package com.haibin.calendarview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.j1;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import java.util.ArrayList;
import java.util.Map;
import md.r;
import md.t;
import md.x;
import md.y;

/* loaded from: classes.dex */
public abstract class b extends z0 {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f11374a;

    /* renamed from: b, reason: collision with root package name */
    public md.a f11375b;

    /* renamed from: c, reason: collision with root package name */
    public a f11376c;

    /* renamed from: d, reason: collision with root package name */
    public Context f11377d;

    @Override // androidx.recyclerview.widget.z0
    public final int getItemCount() {
        return this.f11374a.size();
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onBindViewHolder(z1 z1Var, int i3) {
        y yVar = (y) this;
        Month month = (Month) this.f11374a.get(i3);
        YearView yearView = ((x) z1Var).f16121a;
        int year = month.getYear();
        int month2 = month.getMonth();
        yearView.f11366p = year;
        yearView.f11367q = month2;
        yearView.r = t.k(year, month2, t.j(year, month2), yearView.f11352a.f16044b);
        t.n(yearView.f11366p, yearView.f11367q, yearView.f11352a.f16044b);
        int i10 = yearView.f11366p;
        int i11 = yearView.f11367q;
        r rVar = yearView.f11352a;
        yearView.f11360j = t.w(i10, i11, rVar.f16056h0, rVar.f16044b);
        yearView.f11368s = 6;
        Map map = yearView.f11352a.f16065m0;
        if (map != null && map.size() != 0) {
            ArrayList arrayList = yearView.f11360j;
            int size = arrayList.size();
            int i12 = 0;
            while (i12 < size) {
                Object obj = arrayList.get(i12);
                i12++;
                Calendar calendar = (Calendar) obj;
                if (yearView.f11352a.f16065m0.containsKey(calendar.toString())) {
                    Calendar calendar2 = (Calendar) yearView.f11352a.f16065m0.get(calendar.toString());
                    if (calendar2 != null) {
                        calendar.setScheme(TextUtils.isEmpty(calendar2.getScheme()) ? yearView.f11352a.V : calendar2.getScheme());
                        calendar.setSchemeColor(calendar2.getSchemeColor());
                        calendar.setSchemes(calendar2.getSchemes());
                    }
                } else {
                    calendar.setScheme("");
                    calendar.setSchemeColor(0);
                    calendar.setSchemes(null);
                }
            }
        }
        yearView.a(yVar.f16122f, yVar.f16123g);
    }

    @Override // androidx.recyclerview.widget.z0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i3) {
        YearView defaultYearView;
        y yVar = (y) this;
        boolean isEmpty = TextUtils.isEmpty(yVar.e.S);
        Context context = yVar.f11377d;
        if (isEmpty) {
            defaultYearView = new DefaultYearView(context);
        } else {
            try {
                defaultYearView = (YearView) yVar.e.T.getConstructor(Context.class).newInstance(context);
            } catch (Exception e) {
                e.printStackTrace();
                defaultYearView = new DefaultYearView(context);
            }
        }
        defaultYearView.setLayoutParams(new j1(-1, -1));
        r rVar = yVar.e;
        x xVar = new x(defaultYearView);
        xVar.f16121a = defaultYearView;
        defaultYearView.setup(rVar);
        xVar.itemView.setTag(xVar);
        xVar.itemView.setOnClickListener(this.f11376c);
        return xVar;
    }

    public void setOnItemClickListener(md.a aVar) {
        this.f11375b = aVar;
    }
}
