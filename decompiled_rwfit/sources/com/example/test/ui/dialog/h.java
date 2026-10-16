package com.example.test.ui.dialog;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$style;

/* loaded from: classes.dex */
public final class h extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f7964a;

    /* renamed from: b, reason: collision with root package name */
    public Activity f7965b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context, R$style.normalDialog);
        kotlin.jvm.internal.e.f(context, "context");
        Window window = getWindow();
        kotlin.jvm.internal.e.c(window);
        window.setBackgroundDrawableResource(R.color.transparent);
        setContentView(R$layout.dialog_sync);
        View findViewById = findViewById(R$id.loadingTv);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f7964a = (TextView) findViewById;
    }

    public final void a(int i3) {
        TextView textView = this.f7964a;
        if (textView != null) {
            textView.setText(i3);
        } else {
            kotlin.jvm.internal.e.m("mLoadingTv");
            throw null;
        }
    }

    public final void b(String loadingText) {
        kotlin.jvm.internal.e.f(loadingText, "loadingText");
        TextView textView = this.f7964a;
        if (textView != null) {
            textView.setText(loadingText);
        } else {
            kotlin.jvm.internal.e.m("mLoadingTv");
            throw null;
        }
    }

    public final void c(int i3) {
        TextView textView = this.f7964a;
        if (textView != null) {
            textView.setVisibility(i3);
        } else {
            kotlin.jvm.internal.e.m("mLoadingTv");
            throw null;
        }
    }
}
