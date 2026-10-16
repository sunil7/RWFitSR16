package com.example.test.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;
import com.example.test.R$id;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class MyMarkerView extends MarkerView {

    /* renamed from: d, reason: collision with root package name */
    public final TextView f8491d;

    public MyMarkerView(Context context, int i3) {
        super(context, i3);
        this.f8491d = (TextView) findViewById(R$id.tvContent);
    }

    @Override // com.github.mikephil.charting.components.MarkerView, n7.d
    public final void a(Entry entry, q7.c cVar) {
        boolean z5 = entry instanceof CandleEntry;
        TextView textView = this.f8491d;
        if (z5) {
            textView.setText(v7.h.e(true, ((CandleEntry) entry).l()));
        } else {
            textView.setText(v7.h.e(false, entry.d()));
        }
        super.a(entry, cVar);
    }

    @Override // com.github.mikephil.charting.components.MarkerView
    public v7.d getOffset() {
        return new v7.d(-(getWidth() / 2), -getHeight());
    }
}
