package com.example.test.ui.dialog;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.R$color;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$mipmap;

/* loaded from: classes.dex */
public final class m extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public t6.a f7984a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f7985b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f7986c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f7987d;
    public TextView e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f7988f;

    /* renamed from: g, reason: collision with root package name */
    public ConstraintLayout f7989g;

    public final void a(int i3) {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            ConstraintLayout constraintLayout = this.f7989g;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(R$drawable.shape_background_theme_black);
            }
            TextView textView = this.f7987d;
            if (textView != null) {
                textView.setTextColor(a1.d.a(getContext(), R$color.color_white));
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                textView2.setTextColor(a1.d.a(getContext(), R$color.color_white));
            }
            TextView textView3 = this.f7988f;
            if (textView3 != null) {
                textView3.setTextColor(a1.d.a(getContext(), R$color.color_white));
            }
        } else if (valueOf != null && valueOf.intValue() == 1) {
            ConstraintLayout constraintLayout2 = this.f7989g;
            if (constraintLayout2 != null) {
                constraintLayout2.setBackgroundResource(R$drawable.shape_background_theme_white);
            }
            TextView textView4 = this.f7987d;
            if (textView4 != null) {
                textView4.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView5 = this.e;
            if (textView5 != null) {
                textView5.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView6 = this.f7988f;
            if (textView6 != null) {
                textView6.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
        } else if (valueOf != null && valueOf.intValue() == 2) {
            ConstraintLayout constraintLayout3 = this.f7989g;
            if (constraintLayout3 != null) {
                constraintLayout3.setBackgroundResource(R$drawable.shape_background_theme_pink);
            }
            TextView textView7 = this.f7987d;
            if (textView7 != null) {
                textView7.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView8 = this.e;
            if (textView8 != null) {
                textView8.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView9 = this.f7988f;
            if (textView9 != null) {
                textView9.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        Integer valueOf2 = kVar2 != null ? Integer.valueOf(kVar2.D()) : null;
        if (i3 != 0) {
            if (i3 != 1) {
                return;
            }
            if (valueOf2 != null && valueOf2.intValue() == 0) {
                ImageView imageView = this.f7985b;
                if (imageView != null) {
                    imageView.setImageResource(R$drawable.svg_select_no_black);
                }
            } else {
                ImageView imageView2 = this.f7985b;
                if (imageView2 != null) {
                    imageView2.setImageResource(R$drawable.svg_select_no_white);
                }
            }
            ImageView imageView3 = this.f7986c;
            if (imageView3 != null) {
                imageView3.setImageResource(R$mipmap.select_yes);
                return;
            }
            return;
        }
        ImageView imageView4 = this.f7985b;
        if (imageView4 != null) {
            imageView4.setImageResource(R$mipmap.select_yes);
        }
        if (valueOf2 != null && valueOf2.intValue() == 0) {
            ImageView imageView5 = this.f7986c;
            if (imageView5 != null) {
                imageView5.setImageResource(R$drawable.svg_select_no_black);
                return;
            }
            return;
        }
        ImageView imageView6 = this.f7986c;
        if (imageView6 != null) {
            imageView6.setImageResource(R$drawable.svg_select_no_white);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.btn_lefthand;
        if (valueOf != null && valueOf.intValue() == i3) {
            dismiss();
            t6.a aVar = this.f7984a;
            if (aVar != null) {
                aVar.v("0");
                return;
            }
            return;
        }
        int i10 = R$id.btn_righthand;
        if (valueOf != null && valueOf.intValue() == i10) {
            dismiss();
            t6.a aVar2 = this.f7984a;
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
        this.f7984a = onDialogDataListener;
    }
}
