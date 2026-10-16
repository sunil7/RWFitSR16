package com.example.test.ui.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.test.R$drawable;
import com.example.test.R$string;
import com.example.test.ui.device.activity.DialListActivity;
import com.example.test.ui.device.activity.i0;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

/* loaded from: classes.dex */
public final class n implements eg.c {

    /* renamed from: a, reason: collision with root package name */
    public DialListActivity f8701a;

    /* renamed from: b, reason: collision with root package name */
    public ProgressBar f8702b;

    /* renamed from: c, reason: collision with root package name */
    public View f8703c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f8704d;
    public TextView e;

    @Override // eg.a
    public final void a(i0 i0Var, int i3, int i10) {
    }

    @Override // eg.a
    public final void b(SmartRefreshLayout smartRefreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i3 = m.f8700a[refreshState2.ordinal()];
        ProgressBar progressBar = this.f8702b;
        DialListActivity dialListActivity = this.f8701a;
        TextView textView = this.e;
        ImageView imageView = this.f8704d;
        if (i3 == 1 || i3 == 2) {
            textView.setText(dialListActivity.getString(R$string.pull_to_refresh));
            imageView.setVisibility(0);
            progressBar.setVisibility(8);
            imageView.setImageResource(R$drawable.ic_refresh_down);
            return;
        }
        if (i3 == 3) {
            textView.setText(dialListActivity.getString(R$string.syncing));
            progressBar.setVisibility(0);
            imageView.setVisibility(8);
        } else {
            if (i3 != 4) {
                return;
            }
            textView.setText(dialListActivity.getString(R$string.pull_to_refresh));
            imageView.setImageResource(R$drawable.ic_refresh_up);
        }
    }

    @Override // eg.a
    public final void c(SmartRefreshLayout smartRefreshLayout, int i3, int i10) {
    }

    @Override // eg.a
    public final void d(int i3, float f2, int i10) {
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
        return fg.b.f13680c;
    }

    @Override // eg.a
    public final View getView() {
        return this.f8703c;
    }

    @Override // eg.a
    public final void h(eg.d dVar, int i3, int i10) {
        this.f8702b.setVisibility(0);
    }

    @Override // eg.a
    public final int i(eg.d dVar, boolean z5) {
        this.f8702b.setVisibility(8);
        this.e.setText("");
        return 500;
    }

    @Override // eg.a
    public final void setPrimaryColors(int... iArr) {
    }
}
