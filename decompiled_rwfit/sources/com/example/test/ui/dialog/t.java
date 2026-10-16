package com.example.test.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.R$color;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$style;

/* loaded from: classes.dex */
public final class t extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public t6.b f8031a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f8032b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f8033c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f8034d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f8035f;

    public t(Context context) {
        super(context, R$style.bottom_dialog);
        setContentView(R$layout.dialog_confirm);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = 0;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setGravity(80);
            window.setBackgroundDrawableResource(R$color.transparent);
        }
        this.f8032b = (ImageView) findViewById(R$id.ivCancel);
        this.f8033c = (ImageView) findViewById(R$id.ivOk);
        View findViewById = findViewById(R$id.tvTitle);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8034d = (TextView) findViewById;
        View findViewById2 = findViewById(R$id.tvTips);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.e = (TextView) findViewById2;
        this.f8035f = (ConstraintLayout) findViewById(R$id.cl_confirm_bg);
        ImageView imageView = this.f8032b;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = this.f8033c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.ivOk;
        if (valueOf != null && valueOf.intValue() == i3) {
            t6.b bVar = this.f8031a;
            if (bVar != null) {
                bVar.s();
            }
            dismiss();
            return;
        }
        int i10 = R$id.ivCancel;
        if (valueOf != null && valueOf.intValue() == i10) {
            dismiss();
        }
    }

    public final void setOnDialogListener(t6.b onDialogListener) {
        kotlin.jvm.internal.e.f(onDialogListener, "onDialogListener");
        this.f8031a = onDialogListener;
    }

    @Override // android.app.Dialog
    public final void show() {
        super.show();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            ConstraintLayout constraintLayout = this.f8035f;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(R$drawable.shape_background_theme_black);
            }
            TextView textView = this.f8034d;
            if (textView == null) {
                kotlin.jvm.internal.e.m("tvTitle");
                throw null;
            }
            textView.setTextColor(a1.d.a(getContext(), R$color.color_white));
            TextView textView2 = this.e;
            if (textView2 == null) {
                kotlin.jvm.internal.e.m("tvTips");
                throw null;
            }
            textView2.setTextColor(a1.d.a(getContext(), R$color.color_white));
            ImageView imageView = this.f8033c;
            if (imageView != null) {
                imageView.setImageDrawable(a1.c.b(getContext(), R$drawable.svg_confirmdialog_ok_black));
            }
            ImageView imageView2 = this.f8032b;
            if (imageView2 != null) {
                imageView2.setImageDrawable(a1.c.b(getContext(), R$drawable.svg_confirmdialog_cancel_black));
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            ConstraintLayout constraintLayout2 = this.f8035f;
            if (constraintLayout2 != null) {
                constraintLayout2.setBackgroundResource(R$drawable.shape_background_theme_white);
            }
            TextView textView3 = this.f8034d;
            if (textView3 == null) {
                kotlin.jvm.internal.e.m("tvTitle");
                throw null;
            }
            textView3.setTextColor(a1.d.a(getContext(), R$color.color_black));
            TextView textView4 = this.e;
            if (textView4 == null) {
                kotlin.jvm.internal.e.m("tvTips");
                throw null;
            }
            textView4.setTextColor(a1.d.a(getContext(), R$color.color_black));
            ImageView imageView3 = this.f8033c;
            if (imageView3 != null) {
                imageView3.setImageDrawable(a1.c.b(getContext(), R$drawable.svg_confirmdialog_ok_white));
            }
            ImageView imageView4 = this.f8032b;
            if (imageView4 != null) {
                imageView4.setImageDrawable(a1.c.b(getContext(), R$drawable.svg_confirmdialog_cancel_white));
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == 2) {
            ConstraintLayout constraintLayout3 = this.f8035f;
            if (constraintLayout3 != null) {
                constraintLayout3.setBackgroundResource(R$drawable.shape_background_theme_pink);
            }
            TextView textView5 = this.f8034d;
            if (textView5 == null) {
                kotlin.jvm.internal.e.m("tvTitle");
                throw null;
            }
            textView5.setTextColor(a1.d.a(getContext(), R$color.color_black));
            TextView textView6 = this.e;
            if (textView6 == null) {
                kotlin.jvm.internal.e.m("tvTips");
                throw null;
            }
            textView6.setTextColor(a1.d.a(getContext(), R$color.color_black));
            ImageView imageView5 = this.f8033c;
            if (imageView5 != null) {
                imageView5.setImageDrawable(a1.c.b(getContext(), R$drawable.svg_confirmdialog_ok_white));
            }
            ImageView imageView6 = this.f8032b;
            if (imageView6 != null) {
                imageView6.setImageDrawable(a1.c.b(getContext(), R$drawable.svg_confirmdialog_cancel_white));
            }
        }
    }
}
