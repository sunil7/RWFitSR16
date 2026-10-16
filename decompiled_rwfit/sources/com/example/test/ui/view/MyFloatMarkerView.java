package com.example.test.ui.view;

import android.annotation.SuppressLint;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.example.test.R$id;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class MyFloatMarkerView extends MarkerView {

    /* renamed from: d, reason: collision with root package name */
    public final TextView f8490d;

    public MyFloatMarkerView(FragmentActivity fragmentActivity, int i3) {
        super(fragmentActivity, i3);
        this.f8490d = (TextView) findViewById(R$id.tvContent);
    }

    @Override // com.github.mikephil.charting.components.MarkerView, n7.d
    public final void a(Entry entry, q7.c cVar) {
        boolean z5 = entry instanceof CandleEntry;
        TextView textView = this.f8490d;
        if (z5) {
            textView.setText(String.valueOf(((int) (((CandleEntry) entry).l() * 10)) / 10.0f));
        } else {
            textView.setText(String.valueOf(((int) (entry.d() * 10)) / 10.0f));
        }
        super.a(entry, cVar);
    }

    @Override // com.github.mikephil.charting.components.MarkerView
    public v7.d getOffset() {
        return new v7.d(-(getWidth() / 2), -getHeight());
    }
}
