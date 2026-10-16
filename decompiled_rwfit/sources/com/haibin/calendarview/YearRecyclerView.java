package com.haibin.calendarview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.ui.device.activity.e0;
import java.util.ArrayList;
import md.r;
import md.w;
import md.y;

/* loaded from: classes.dex */
public final class YearRecyclerView extends RecyclerView {

    /* renamed from: l1, reason: collision with root package name */
    public r f11349l1;

    /* renamed from: m1, reason: collision with root package name */
    public final y f11350m1;

    /* renamed from: n1, reason: collision with root package name */
    public w f11351n1;

    public YearRecyclerView(Context context) {
        this(context, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i3) / 3;
        y yVar = this.f11350m1;
        yVar.f16122f = size2;
        yVar.f16123g = size / 4;
    }

    public final void setOnMonthSelectedListener(w wVar) {
        this.f11351n1 = wVar;
    }

    public final void setup(r rVar) {
        this.f11349l1 = rVar;
        this.f11350m1.e = rVar;
    }

    public YearRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        y yVar = new y();
        yVar.f11377d = context;
        yVar.f11374a = new ArrayList();
        LayoutInflater.from(context);
        yVar.f11376c = new a(yVar);
        this.f11350m1 = yVar;
        setLayoutManager(new GridLayoutManager(3));
        setAdapter(yVar);
        yVar.setOnItemClickListener(new e0(this, 28));
    }
}
