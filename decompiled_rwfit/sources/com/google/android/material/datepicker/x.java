package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.z1;
import com.google.android.material.R$id;
import java.util.WeakHashMap;
import l1.z0;

/* loaded from: classes.dex */
public final class x extends z1 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f10478a;

    /* renamed from: b, reason: collision with root package name */
    public final MaterialCalendarGridView f10479b;

    public x(LinearLayout linearLayout, boolean z5) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
        this.f10478a = textView;
        WeakHashMap weakHashMap = z0.f15748a;
        new l1.d0(androidx.core.R$id.tag_accessibility_heading, Boolean.class, 0, 28, 3).d(textView, Boolean.TRUE);
        this.f10479b = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
        if (z5) {
            return;
        }
        textView.setVisibility(8);
    }
}
