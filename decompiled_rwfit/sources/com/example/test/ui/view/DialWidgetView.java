package com.example.test.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.google.android.gms.internal.mlkit_vision_barcode.he;

/* loaded from: classes.dex */
public class DialWidgetView extends ConstraintLayout {

    /* renamed from: s, reason: collision with root package name */
    public final com.google.android.material.datepicker.c f8411s;

    /* renamed from: t, reason: collision with root package name */
    public int f8412t;

    /* renamed from: u, reason: collision with root package name */
    public int f8413u;

    public DialWidgetView(Context context) {
        this(context, null);
    }

    public final Bitmap p(int i3) {
        return BitmapFactory.decodeResource(getContext().getResources(), i3);
    }

    public void setContentColor(int i3) {
        ((TextView) this.f8411s.e).setTextColor(i3);
        ((TextView) this.f8411s.f10424g).setTextColor(i3);
        ((TextView) this.f8411s.f10423f).setTextColor(i3);
        int i10 = this.f8412t;
        if (i10 > 1) {
            if (i10 == 2) {
                ((ImageView) this.f8411s.f10422d).setImageBitmap(p(R$mipmap.ic_dial_sleep));
            } else if (i10 == 4) {
                ((ImageView) this.f8411s.f10422d).setImageBitmap(p(R$mipmap.ic_dial_hr));
            } else {
                ((ImageView) this.f8411s.f10422d).setImageBitmap(p(R$mipmap.ic_dial_step));
            }
        }
        int i11 = this.f8413u;
        if (i11 > 1) {
            if (i11 == 2) {
                ((ImageView) this.f8411s.f10421c).setImageBitmap(p(R$mipmap.ic_dial_sleep));
            } else if (i11 == 4) {
                ((ImageView) this.f8411s.f10421c).setImageBitmap(p(R$mipmap.ic_dial_hr));
            } else {
                ((ImageView) this.f8411s.f10421c).setImageBitmap(p(R$mipmap.ic_dial_step));
            }
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void setTimeDownType(int i3) {
        this.f8413u = i3;
        if (i3 == 0) {
            ((LinearLayout) this.f8411s.f10420b).setVisibility(4);
            return;
        }
        if (i3 == 1) {
            ((LinearLayout) this.f8411s.f10420b).setVisibility(0);
            ((ImageView) this.f8411s.f10421c).setVisibility(8);
            ((TextView) this.f8411s.f10423f).setText("THU 06");
            return;
        }
        if (i3 == 2) {
            ((LinearLayout) this.f8411s.f10420b).setVisibility(0);
            ((ImageView) this.f8411s.f10421c).setVisibility(0);
            ((ImageView) this.f8411s.f10421c).setImageBitmap(p(R$mipmap.ic_dial_sleep));
            ((TextView) this.f8411s.f10423f).setText("00h00m");
            return;
        }
        if (i3 == 4) {
            ((LinearLayout) this.f8411s.f10420b).setVisibility(0);
            ((ImageView) this.f8411s.f10421c).setVisibility(0);
            ((ImageView) this.f8411s.f10421c).setImageBitmap(p(R$mipmap.ic_dial_hr));
            ((TextView) this.f8411s.f10423f).setText("080");
            return;
        }
        ((LinearLayout) this.f8411s.f10420b).setVisibility(0);
        ((ImageView) this.f8411s.f10421c).setVisibility(0);
        ((ImageView) this.f8411s.f10421c).setImageBitmap(p(R$mipmap.ic_dial_step));
        ((TextView) this.f8411s.f10423f).setText("0");
    }

    @SuppressLint({"SetTextI18n"})
    public void setTimeUpType(int i3) {
        this.f8412t = i3;
        if (i3 == 0) {
            ((LinearLayout) this.f8411s.f10425h).setVisibility(4);
            return;
        }
        if (i3 == 1) {
            ((LinearLayout) this.f8411s.f10425h).setVisibility(0);
            ((ImageView) this.f8411s.f10422d).setVisibility(8);
            ((TextView) this.f8411s.f10424g).setText("THU 06");
            return;
        }
        if (i3 == 2) {
            ((LinearLayout) this.f8411s.f10425h).setVisibility(0);
            ((ImageView) this.f8411s.f10422d).setVisibility(0);
            ((ImageView) this.f8411s.f10422d).setImageBitmap(p(R$mipmap.ic_dial_sleep));
            ((TextView) this.f8411s.f10424g).setText("00h00m");
            return;
        }
        if (i3 == 4) {
            ((LinearLayout) this.f8411s.f10425h).setVisibility(0);
            ((ImageView) this.f8411s.f10422d).setVisibility(0);
            ((ImageView) this.f8411s.f10422d).setImageBitmap(p(R$mipmap.ic_dial_hr));
            ((TextView) this.f8411s.f10424g).setText("080");
            return;
        }
        ((LinearLayout) this.f8411s.f10425h).setVisibility(0);
        ((ImageView) this.f8411s.f10422d).setVisibility(0);
        ((ImageView) this.f8411s.f10422d).setImageBitmap(p(R$mipmap.ic_dial_step));
        ((TextView) this.f8411s.f10424g).setText("0");
    }

    public DialWidgetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DialWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        View inflate = View.inflate(context, R$layout.view_dial_widget, this);
        int i10 = R$id.down_layout;
        LinearLayout linearLayout = (LinearLayout) he.a(i10, inflate);
        if (linearLayout != null) {
            i10 = R$id.img_time_down;
            ImageView imageView = (ImageView) he.a(i10, inflate);
            if (imageView != null) {
                i10 = R$id.img_time_up;
                ImageView imageView2 = (ImageView) he.a(i10, inflate);
                if (imageView2 != null) {
                    i10 = R$id.time;
                    TextView textView = (TextView) he.a(i10, inflate);
                    if (textView != null) {
                        i10 = R$id.time_down_content;
                        TextView textView2 = (TextView) he.a(i10, inflate);
                        if (textView2 != null) {
                            i10 = R$id.time_up_content;
                            TextView textView3 = (TextView) he.a(i10, inflate);
                            if (textView3 != null) {
                                i10 = R$id.up_layout;
                                LinearLayout linearLayout2 = (LinearLayout) he.a(i10, inflate);
                                if (linearLayout2 != null) {
                                    this.f8411s = new com.google.android.material.datepicker.c((ConstraintLayout) inflate, linearLayout, imageView, imageView2, textView, textView2, textView3, linearLayout2);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }
}
