package com.example.test.ui.dialog;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import com.example.test.R$id;
import com.example.test.R$mipmap;

/* loaded from: classes.dex */
public final class f extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7956a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7957b;

    /* renamed from: c, reason: collision with root package name */
    public t6.e f7958c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f7959d;
    public ImageView e;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.iv_find_close;
        if (valueOf != null && valueOf.intValue() == i3) {
            dismiss();
            return;
        }
        int i10 = R$id.ib_hs_find_left;
        if (valueOf != null && valueOf.intValue() == i10) {
            if (this.f7956a) {
                this.f7956a = false;
                ImageView imageView = this.f7959d;
                if (imageView == null) {
                    kotlin.jvm.internal.e.m("mIb_hs_find_left");
                    throw null;
                }
                imageView.setImageResource(R$mipmap.headset_find_pause);
                t6.e eVar = this.f7958c;
                if (eVar != null) {
                    eVar.a(1, 0);
                    return;
                }
                return;
            }
            this.f7956a = true;
            ImageView imageView2 = this.f7959d;
            if (imageView2 == null) {
                kotlin.jvm.internal.e.m("mIb_hs_find_left");
                throw null;
            }
            imageView2.setImageResource(R$mipmap.headset_find_play);
            t6.e eVar2 = this.f7958c;
            if (eVar2 != null) {
                eVar2.a(1, 1);
                return;
            }
            return;
        }
        int i11 = R$id.ib_hs_find_right;
        if (valueOf != null && valueOf.intValue() == i11) {
            if (this.f7957b) {
                this.f7957b = false;
                ImageView imageView3 = this.e;
                if (imageView3 == null) {
                    kotlin.jvm.internal.e.m("mIb_hs_find_right");
                    throw null;
                }
                imageView3.setImageResource(R$mipmap.headset_find_pause);
                t6.e eVar3 = this.f7958c;
                if (eVar3 != null) {
                    eVar3.a(0, 0);
                    return;
                }
                return;
            }
            this.f7957b = true;
            ImageView imageView4 = this.e;
            if (imageView4 == null) {
                kotlin.jvm.internal.e.m("mIb_hs_find_right");
                throw null;
            }
            imageView4.setImageResource(R$mipmap.headset_find_play);
            t6.e eVar4 = this.f7958c;
            if (eVar4 != null) {
                eVar4.a(0, 1);
            }
        }
    }

    public final void setOnDialogListener(t6.e onDialogListener) {
        kotlin.jvm.internal.e.f(onDialogListener, "onDialogListener");
        this.f7958c = onDialogListener;
    }
}
