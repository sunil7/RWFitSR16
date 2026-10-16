package com.example.test.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;

/* loaded from: classes.dex */
public final class SportNewDataView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f8589a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f8590b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f8591c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f8592d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final GpsView f8593f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SportNewDataView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final void setSingle(int i3) {
        GpsView gpsView = this.f8593f;
        if (gpsView != null) {
            gpsView.setLevel(i3);
        } else {
            kotlin.jvm.internal.e.m("gpsSingleView");
            throw null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SportNewDataView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ SportNewDataView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SportNewDataView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_sport_new_data, this);
        View findViewById = findViewById(R$id.distanceUnitTv);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8589a = (TextView) findViewById;
        View findViewById2 = findViewById(R$id.distanceTv);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8590b = (TextView) findViewById2;
        View findViewById3 = findViewById(R$id.currentPaceTv);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8591c = (TextView) findViewById3;
        View findViewById4 = findViewById(R$id.caloriesTv);
        kotlin.jvm.internal.e.e(findViewById4, "findViewById(...)");
        this.f8592d = (TextView) findViewById4;
        View findViewById5 = findViewById(R$id.totalTimeTv);
        kotlin.jvm.internal.e.e(findViewById5, "findViewById(...)");
        this.e = (TextView) findViewById5;
        View findViewById6 = findViewById(R$id.gpsSingleView);
        kotlin.jvm.internal.e.e(findViewById6, "findViewById(...)");
        this.f8593f = (GpsView) findViewById6;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d5 = kVar != null ? kVar.d() : null;
        if (d5 != null) {
            if (d5.getMeterUnit() == 0) {
                TextView textView = this.f8589a;
                if (textView != null) {
                    textView.setText(getContext().getString(R$string.str_km));
                    return;
                } else {
                    kotlin.jvm.internal.e.m("distanceUnitTv");
                    throw null;
                }
            }
            TextView textView2 = this.f8589a;
            if (textView2 != null) {
                textView2.setText(getContext().getString(R$string.str_mile));
            } else {
                kotlin.jvm.internal.e.m("distanceUnitTv");
                throw null;
            }
        }
    }
}
