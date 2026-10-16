package com.example.test.ui.dialog;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.ui.view.ProgressButtonView;

/* loaded from: classes.dex */
public final class g extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public t6.e f7960a;

    /* renamed from: b, reason: collision with root package name */
    public ProgressButtonView f7961b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f7962c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f7963d;

    public final ProgressButtonView a() {
        ProgressButtonView progressButtonView = this.f7961b;
        if (progressButtonView != null) {
            return progressButtonView;
        }
        kotlin.jvm.internal.e.m("progressButtonView");
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.iv_find_close;
        if (valueOf != null && valueOf.intValue() == i3) {
            dismiss();
            return;
        }
        int i10 = R$id.progressBtn;
        if (valueOf != null && valueOf.intValue() == i10) {
            ((ImageView) findViewById(R$id.iv_find_close)).setVisibility(8);
            t6.e eVar = this.f7960a;
            if (eVar != null) {
                eVar.a(100, 0);
            }
        }
    }

    public final void setOnDialogListener(t6.e onDialogListener) {
        kotlin.jvm.internal.e.f(onDialogListener, "onDialogListener");
        this.f7960a = onDialogListener;
    }
}
