package com.example.test.ui.view;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.test.R$string;
import com.example.test.ui.device.activity.i0;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

/* loaded from: classes.dex */
public final class h implements eg.b {

    /* renamed from: a, reason: collision with root package name */
    public View f8692a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f8693b;

    /* renamed from: c, reason: collision with root package name */
    public ProgressBar f8694c;

    @Override // eg.a
    public final void a(i0 i0Var, int i3, int i10) {
    }

    @Override // eg.a
    public final void b(SmartRefreshLayout smartRefreshLayout, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // eg.a
    public final void c(SmartRefreshLayout smartRefreshLayout, int i3, int i10) {
    }

    @Override // eg.a
    public final void d(int i3, float f2, int i10) {
    }

    @Override // eg.b
    public final boolean e(boolean z5) {
        ProgressBar progressBar = this.f8694c;
        TextView textView = this.f8693b;
        if (z5) {
            textView.setText(R$string.str_no_more_data);
            progressBar.setVisibility(8);
            return z5;
        }
        textView.setText(R$string.str_load_more);
        progressBar.setVisibility(0);
        return z5;
    }

    @Override // eg.a
    public final void f(boolean z5, float f2, int i3, int i10, int i11) {
    }

    @Override // eg.a
    public final boolean g() {
        return false;
    }

    @Override // eg.a
    public final fg.b getSpinnerStyle() {
        return fg.b.f13681d;
    }

    @Override // eg.a
    public final View getView() {
        return this.f8692a;
    }

    @Override // eg.a
    public final void h(eg.d dVar, int i3, int i10) {
    }

    @Override // eg.a
    public final int i(eg.d dVar, boolean z5) {
        return 0;
    }

    @Override // eg.a
    public final void setPrimaryColors(int... iArr) {
    }
}
