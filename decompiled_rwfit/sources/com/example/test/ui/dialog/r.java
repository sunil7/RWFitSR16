package com.example.test.ui.dialog;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$style;

/* loaded from: classes.dex */
public final class r extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f8021a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f8022b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f8023c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f8024d;
    public final View e;

    /* renamed from: f, reason: collision with root package name */
    public t6.b f8025f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context) {
        super(context, R$style.normalDialog);
        kotlin.jvm.internal.e.f(context, "context");
        Window window = getWindow();
        kotlin.jvm.internal.e.c(window);
        window.setBackgroundDrawableResource(R.color.transparent);
        setContentView(R$layout.dialog_tips);
        View findViewById = findViewById(R$id.tvCancel);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8021a = (TextView) findViewById;
        View findViewById2 = findViewById(R$id.tvSure);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8022b = (TextView) findViewById2;
        View findViewById3 = findViewById(R$id.tvSureSingle);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8023c = (TextView) findViewById3;
        View findViewById4 = findViewById(R$id.tvTips);
        kotlin.jvm.internal.e.e(findViewById4, "findViewById(...)");
        this.f8024d = (TextView) findViewById4;
        View findViewById5 = findViewById(R$id.line_v);
        kotlin.jvm.internal.e.e(findViewById5, "findViewById(...)");
        this.e = findViewById5;
        TextView textView = this.f8021a;
        if (textView == null) {
            kotlin.jvm.internal.e.m("tvCancelTv");
            throw null;
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.f8022b;
        if (textView2 == null) {
            kotlin.jvm.internal.e.m("tvSureTv");
            throw null;
        }
        textView2.setOnClickListener(this);
        TextView textView3 = this.f8023c;
        if (textView3 != null) {
            textView3.setOnClickListener(this);
        } else {
            kotlin.jvm.internal.e.m("tvSureSingleTv");
            throw null;
        }
    }

    public final void a() {
        TextView textView = this.f8021a;
        if (textView == null) {
            kotlin.jvm.internal.e.m("tvCancelTv");
            throw null;
        }
        textView.setVisibility(8);
        TextView textView2 = this.f8022b;
        if (textView2 == null) {
            kotlin.jvm.internal.e.m("tvSureTv");
            throw null;
        }
        textView2.setVisibility(8);
        View view = this.e;
        if (view == null) {
            kotlin.jvm.internal.e.m("lineVView");
            throw null;
        }
        view.setVisibility(4);
        TextView textView3 = this.f8023c;
        if (textView3 != null) {
            textView3.setVisibility(0);
        } else {
            kotlin.jvm.internal.e.m("tvSureSingleTv");
            throw null;
        }
    }

    public final void b(int i3) {
        TextView textView = this.f8024d;
        if (textView != null) {
            textView.setText(i3);
        } else {
            kotlin.jvm.internal.e.m("tvTipsTv");
            throw null;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        t6.b bVar;
        dismiss();
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.tvCancel;
        if (valueOf != null && valueOf.intValue() == i3) {
            t6.b bVar2 = this.f8025f;
            if (bVar2 != null) {
                bVar2.onCancel();
                return;
            }
            return;
        }
        int i10 = R$id.tvSure;
        if (valueOf != null && valueOf.intValue() == i10) {
            t6.b bVar3 = this.f8025f;
            if (bVar3 != null) {
                bVar3.s();
                return;
            }
            return;
        }
        int i11 = R$id.tvSureSingle;
        if (valueOf == null || valueOf.intValue() != i11 || (bVar = this.f8025f) == null) {
            return;
        }
        bVar.s();
    }

    public final void setOnDialogListener(t6.b onDialogListener) {
        kotlin.jvm.internal.e.f(onDialogListener, "onDialogListener");
        this.f8025f = onDialogListener;
    }
}
