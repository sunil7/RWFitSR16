package com.example.test.ui.dialog;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.R$id;

/* loaded from: classes.dex */
public final class n extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public t6.a f7990a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f7991b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f7992c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f7993d;
    public ImageView e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f7994f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f7995g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f7996h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f7997i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f7998j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f7999k;

    /* renamed from: l, reason: collision with root package name */
    public ConstraintLayout f8000l;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.btn_stronglight;
        if (valueOf != null && valueOf.intValue() == i3) {
            dismiss();
            t6.a aVar = this.f7990a;
            if (aVar != null) {
                aVar.v("1");
                return;
            }
            return;
        }
        int i10 = R$id.btn_softlight;
        if (valueOf != null && valueOf.intValue() == i10) {
            dismiss();
            t6.a aVar2 = this.f7990a;
            if (aVar2 != null) {
                aVar2.v("2");
                return;
            }
            return;
        }
        int i11 = R$id.btn_minlight;
        if (valueOf != null && valueOf.intValue() == i11) {
            dismiss();
            t6.a aVar3 = this.f7990a;
            if (aVar3 != null) {
                aVar3.v("3");
                return;
            }
            return;
        }
        int i12 = R$id.btn_close;
        if (valueOf != null && valueOf.intValue() == i12) {
            dismiss();
            t6.a aVar4 = this.f7990a;
            if (aVar4 != null) {
                aVar4.v("0");
                return;
            }
            return;
        }
        int i13 = R$id.tvCancel;
        if (valueOf != null && valueOf.intValue() == i13) {
            dismiss();
        }
    }

    public final void setOnDialogDataListener(t6.a onDialogDataListener) {
        kotlin.jvm.internal.e.f(onDialogDataListener, "onDialogDataListener");
        this.f7990a = onDialogDataListener;
    }
}
