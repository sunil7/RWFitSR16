package com.example.test.ui.dialog;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.R$id;

/* loaded from: classes.dex */
public final class o extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public t6.a f8001a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f8002b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f8003c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f8004d;
    public TextView e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f8005f;

    /* renamed from: g, reason: collision with root package name */
    public ConstraintLayout f8006g;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.btn_lefthand;
        if (valueOf != null && valueOf.intValue() == i3) {
            dismiss();
            t6.a aVar = this.f8001a;
            if (aVar != null) {
                aVar.v("0");
                return;
            }
            return;
        }
        int i10 = R$id.btn_righthand;
        if (valueOf != null && valueOf.intValue() == i10) {
            dismiss();
            t6.a aVar2 = this.f8001a;
            if (aVar2 != null) {
                aVar2.v("1");
                return;
            }
            return;
        }
        int i11 = R$id.tvCancel;
        if (valueOf != null && valueOf.intValue() == i11) {
            dismiss();
        }
    }

    public final void setOnDialogDataListener(t6.a onDialogDataListener) {
        kotlin.jvm.internal.e.f(onDialogDataListener, "onDialogDataListener");
        this.f8001a = onDialogDataListener;
    }
}
