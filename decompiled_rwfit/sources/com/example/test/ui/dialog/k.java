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
public final class k extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public t6.a f7969a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f7970b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f7971c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f7972d;
    public ImageView e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f7973f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f7974g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f7975h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f7976i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f7977j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f7978k;

    /* renamed from: l, reason: collision with root package name */
    public ConstraintLayout f7979l;

    public final void a(int i3) {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            ConstraintLayout constraintLayout = this.f7979l;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(R$drawable.shape_background_theme_black);
            }
            TextView textView = this.f7973f;
            if (textView != null) {
                textView.setTextColor(a1.d.a(getContext(), R$color.color_white));
            }
            TextView textView2 = this.f7974g;
            if (textView2 != null) {
                textView2.setTextColor(a1.d.a(getContext(), R$color.color_white));
            }
            TextView textView3 = this.f7975h;
            if (textView3 != null) {
                textView3.setTextColor(a1.d.a(getContext(), R$color.color_white));
            }
            TextView textView4 = this.f7976i;
            if (textView4 != null) {
                textView4.setTextColor(a1.d.a(getContext(), R$color.color_white));
            }
            TextView textView5 = this.f7977j;
            if (textView5 != null) {
                textView5.setTextColor(a1.d.a(getContext(), R$color.color_white));
            }
            TextView textView6 = this.f7978k;
            if (textView6 != null) {
                textView6.setTextColor(a1.d.a(getContext(), R$color.color_white));
            }
        } else if (valueOf != null && valueOf.intValue() == 1) {
            ConstraintLayout constraintLayout2 = this.f7979l;
            if (constraintLayout2 != null) {
                constraintLayout2.setBackgroundResource(R$drawable.shape_background_theme_white);
            }
            TextView textView7 = this.f7973f;
            if (textView7 != null) {
                textView7.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView8 = this.f7974g;
            if (textView8 != null) {
                textView8.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView9 = this.f7975h;
            if (textView9 != null) {
                textView9.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView10 = this.f7976i;
            if (textView10 != null) {
                textView10.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView11 = this.f7977j;
            if (textView11 != null) {
                textView11.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView12 = this.f7978k;
            if (textView12 != null) {
                textView12.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
        } else if (valueOf != null && valueOf.intValue() == 2) {
            ConstraintLayout constraintLayout3 = this.f7979l;
            if (constraintLayout3 != null) {
                constraintLayout3.setBackgroundResource(R$drawable.shape_background_theme_pink);
            }
            TextView textView13 = this.f7973f;
            if (textView13 != null) {
                textView13.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView14 = this.f7974g;
            if (textView14 != null) {
                textView14.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView15 = this.f7975h;
            if (textView15 != null) {
                textView15.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView16 = this.f7976i;
            if (textView16 != null) {
                textView16.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView17 = this.f7977j;
            if (textView17 != null) {
                textView17.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
            TextView textView18 = this.f7978k;
            if (textView18 != null) {
                textView18.setTextColor(a1.d.a(getContext(), R$color.color_black));
            }
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        Integer valueOf2 = kVar2 != null ? Integer.valueOf(kVar2.D()) : null;
        if (i3 == 0) {
            ImageView imageView = this.f7970b;
            if (imageView != null) {
                imageView.setImageResource(R$mipmap.select_yes);
            }
            if (valueOf2 != null && valueOf2.intValue() == 0) {
                ImageView imageView2 = this.f7971c;
                if (imageView2 != null) {
                    imageView2.setImageResource(R$drawable.svg_select_no_black);
                }
                ImageView imageView3 = this.f7972d;
                if (imageView3 != null) {
                    imageView3.setImageResource(R$drawable.svg_select_no_black);
                }
                ImageView imageView4 = this.e;
                if (imageView4 != null) {
                    imageView4.setImageResource(R$drawable.svg_select_no_black);
                    return;
                }
                return;
            }
            ImageView imageView5 = this.f7971c;
            if (imageView5 != null) {
                imageView5.setImageResource(R$drawable.svg_select_no_white);
            }
            ImageView imageView6 = this.f7972d;
            if (imageView6 != null) {
                imageView6.setImageResource(R$drawable.svg_select_no_white);
            }
            ImageView imageView7 = this.e;
            if (imageView7 != null) {
                imageView7.setImageResource(R$drawable.svg_select_no_white);
                return;
            }
            return;
        }
        if (i3 == 1) {
            ImageView imageView8 = this.f7971c;
            if (imageView8 != null) {
                imageView8.setImageResource(R$mipmap.select_yes);
            }
            if (valueOf2 != null && valueOf2.intValue() == 0) {
                ImageView imageView9 = this.f7970b;
                if (imageView9 != null) {
                    imageView9.setImageResource(R$drawable.svg_select_no_black);
                }
                ImageView imageView10 = this.f7972d;
                if (imageView10 != null) {
                    imageView10.setImageResource(R$drawable.svg_select_no_black);
                }
                ImageView imageView11 = this.e;
                if (imageView11 != null) {
                    imageView11.setImageResource(R$drawable.svg_select_no_black);
                    return;
                }
                return;
            }
            ImageView imageView12 = this.f7970b;
            if (imageView12 != null) {
                imageView12.setImageResource(R$drawable.svg_select_no_white);
            }
            ImageView imageView13 = this.f7972d;
            if (imageView13 != null) {
                imageView13.setImageResource(R$drawable.svg_select_no_white);
            }
            ImageView imageView14 = this.e;
            if (imageView14 != null) {
                imageView14.setImageResource(R$drawable.svg_select_no_white);
                return;
            }
            return;
        }
        if (i3 == 2) {
            ImageView imageView15 = this.f7972d;
            if (imageView15 != null) {
                imageView15.setImageResource(R$mipmap.select_yes);
            }
            if (valueOf2 != null && valueOf2.intValue() == 0) {
                ImageView imageView16 = this.f7970b;
                if (imageView16 != null) {
                    imageView16.setImageResource(R$drawable.svg_select_no_black);
                }
                ImageView imageView17 = this.f7971c;
                if (imageView17 != null) {
                    imageView17.setImageResource(R$drawable.svg_select_no_black);
                }
                ImageView imageView18 = this.e;
                if (imageView18 != null) {
                    imageView18.setImageResource(R$drawable.svg_select_no_black);
                    return;
                }
                return;
            }
            ImageView imageView19 = this.f7970b;
            if (imageView19 != null) {
                imageView19.setImageResource(R$drawable.svg_select_no_white);
            }
            ImageView imageView20 = this.f7971c;
            if (imageView20 != null) {
                imageView20.setImageResource(R$drawable.svg_select_no_white);
            }
            ImageView imageView21 = this.e;
            if (imageView21 != null) {
                imageView21.setImageResource(R$drawable.svg_select_no_white);
                return;
            }
            return;
        }
        if (i3 != 3) {
            return;
        }
        ImageView imageView22 = this.e;
        if (imageView22 != null) {
            imageView22.setImageResource(R$mipmap.select_yes);
        }
        if (valueOf2 != null && valueOf2.intValue() == 0) {
            ImageView imageView23 = this.f7970b;
            if (imageView23 != null) {
                imageView23.setImageResource(R$drawable.svg_select_no_black);
            }
            ImageView imageView24 = this.f7971c;
            if (imageView24 != null) {
                imageView24.setImageResource(R$drawable.svg_select_no_black);
            }
            ImageView imageView25 = this.f7972d;
            if (imageView25 != null) {
                imageView25.setImageResource(R$drawable.svg_select_no_black);
                return;
            }
            return;
        }
        ImageView imageView26 = this.f7970b;
        if (imageView26 != null) {
            imageView26.setImageResource(R$drawable.svg_select_no_white);
        }
        ImageView imageView27 = this.f7971c;
        if (imageView27 != null) {
            imageView27.setImageResource(R$drawable.svg_select_no_white);
        }
        ImageView imageView28 = this.f7972d;
        if (imageView28 != null) {
            imageView28.setImageResource(R$drawable.svg_select_no_white);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.btn_stronglight;
        if (valueOf != null && valueOf.intValue() == i3) {
            dismiss();
            t6.a aVar = this.f7969a;
            if (aVar != null) {
                aVar.v("0");
                return;
            }
            return;
        }
        int i10 = R$id.btn_softlight;
        if (valueOf != null && valueOf.intValue() == i10) {
            dismiss();
            t6.a aVar2 = this.f7969a;
            if (aVar2 != null) {
                aVar2.v("1");
                return;
            }
            return;
        }
        int i11 = R$id.btn_minlight;
        if (valueOf != null && valueOf.intValue() == i11) {
            dismiss();
            t6.a aVar3 = this.f7969a;
            if (aVar3 != null) {
                aVar3.v("2");
                return;
            }
            return;
        }
        int i12 = R$id.btn_close;
        if (valueOf != null && valueOf.intValue() == i12) {
            dismiss();
            t6.a aVar4 = this.f7969a;
            if (aVar4 != null) {
                aVar4.v("3");
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
        this.f7969a = onDialogDataListener;
    }
}
