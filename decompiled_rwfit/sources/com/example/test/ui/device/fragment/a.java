package com.example.test.ui.device.fragment;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.example.baselibrary.preseneter.b;
import com.example.test.R$dimen;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.presenter.device.a0;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.device.activity.CustomDialActivity;
import com.example.test.ui.device.activity.CustomJLDialActivity;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.i3;
import f7.i;
import g4.v;
import java.io.File;
import kotlin.jvm.internal.e;
import org.greenrobot.eventbus.ThreadMode;
import y5.d;
import yh.k;
import z3.h;

/* loaded from: classes.dex */
public final class a extends XXBaseFragment<a0, i3> implements i, View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    public int f7908d;

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final b I() {
        return new a0(this);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        i3 i3Var = (i3) this.f7251b;
        if (i3Var != null) {
            return i3Var.f12995a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_dial_mine, viewGroup, false);
        int i3 = R$id.custom_dial;
        LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
        if (linearLayout != null) {
            i3 = R$id.custom_dial_face;
            ImageView imageView = (ImageView) he.a(i3, inflate);
            if (imageView != null) {
                i3 = R$id.dialNewTv;
                if (((TextView) he.a(i3, inflate)) != null) {
                    i3 = R$id.dialUnTv;
                    if (((TextView) he.a(i3, inflate)) != null) {
                        return new i3((NestedScrollView) inflate, linearLayout, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
    }

    @Override // p5.a
    public final Context f0() {
        FragmentActivity activity = getActivity();
        e.d(activity, "null cannot be cast to non-null type android.content.Context");
        return activity;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
        ((a0) X()).k();
    }

    public final void k0(String str) {
        i3 i3Var = (i3) this.f7251b;
        if (i3Var != null) {
            ImageView imageView = i3Var.f12997c;
            if (str == null || str.length() == 0) {
                if (this.f7908d == 1) {
                    int dimension = (int) getResources().getDimension(R$dimen.qb_px_120);
                    int dimension2 = (int) getResources().getDimension(R$dimen.qb_px_120);
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.width = dimension;
                    layoutParams.height = dimension2;
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageDrawable(getResources().getDrawable(R$drawable.bg_dial_cover_circle));
                    return;
                }
                int dimension3 = (int) getResources().getDimension(R$dimen.qb_px_102);
                int dimension4 = (int) getResources().getDimension(R$dimen.qb_px_119);
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                layoutParams2.width = dimension3;
                layoutParams2.height = dimension4;
                imageView.setLayoutParams(layoutParams2);
                imageView.setImageDrawable(getResources().getDrawable(R$drawable.bg_rectangle_black));
                return;
            }
            if (new File(str).exists()) {
                int i3 = this.f7908d;
                h hVar = h.f20239b;
                if (i3 == 1) {
                    ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(f0()).n(str).o(true)).d(hVar)).i(R$drawable.bg_img)).a(p4.e.t(new g4.i())).e(R$drawable.bg_img)).x(imageView);
                    return;
                }
                ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(f0()).n(str).o(true)).d(hVar)).i(R$drawable.bg_dial_item)).a(p4.e.t(new v(com.example.baselibrary.utils.b.f(f0(), 16.0f)))).e(R$drawable.bg_dial_item)).x(imageView);
                return;
            }
            if (this.f7908d == 1) {
                int dimension5 = (int) getResources().getDimension(R$dimen.qb_px_120);
                int dimension6 = (int) getResources().getDimension(R$dimen.qb_px_120);
                ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
                layoutParams3.width = dimension5;
                layoutParams3.height = dimension6;
                imageView.setLayoutParams(layoutParams3);
                imageView.setImageDrawable(getResources().getDrawable(R$drawable.bg_dial_cover_circle));
                return;
            }
            int dimension7 = (int) getResources().getDimension(R$dimen.qb_px_102);
            int dimension8 = (int) getResources().getDimension(R$dimen.qb_px_119);
            ViewGroup.LayoutParams layoutParams4 = imageView.getLayoutParams();
            layoutParams4.width = dimension7;
            layoutParams4.height = dimension8;
            imageView.setLayoutParams(layoutParams4);
            imageView.setImageDrawable(getResources().getDrawable(R$drawable.bg_rectangle_black));
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        b2.a(this);
        i3 i3Var = (i3) this.f7251b;
        if (i3Var != null) {
            i3Var.f12996b.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.custom_dial;
        if (valueOf != null && valueOf.intValue() == i3) {
            Log.e("qob", "CustomJLDialActivity isJLPlatform " + d.f20005b);
            if (d.f20005b) {
                startActivity(new Intent(f0(), (Class<?>) CustomJLDialActivity.class));
            } else {
                startActivity(new Intent(f0(), (Class<?>) CustomDialActivity.class));
            }
        }
    }

    @k(threadMode = ThreadMode.MAIN)
    public final void onCustomDialChangeEvent(EventBusBeans.CustomDialChangeEvent customDialChangeEvent) {
        e.f(customDialChangeEvent, "customDialChangeEvent");
        String customDialPath = customDialChangeEvent.getCustomDialPath();
        if (customDialPath != null) {
            k0(customDialPath);
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }
}
