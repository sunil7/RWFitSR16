package com.yanzhenjie.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.baselibrary.R$id;
import com.example.baselibrary.R$layout;
import og.r;

/* loaded from: classes2.dex */
public class DefaultLoadMoreView extends LinearLayout implements r, View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final ProgressBar f12174a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f12175b;

    public DefaultLoadMoreView(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
    }

    public DefaultLoadMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setGravity(17);
        setVisibility(8);
        setMinimumHeight((int) ((getResources().getDisplayMetrics().density * 60.0f) + 0.5d));
        View.inflate(getContext(), R$layout.x_recycler_view_load_more, this);
        this.f12174a = (ProgressBar) findViewById(R$id.progress_bar);
        this.f12175b = (TextView) findViewById(R$id.tv_load_more_message);
        setOnClickListener(this);
    }
}
