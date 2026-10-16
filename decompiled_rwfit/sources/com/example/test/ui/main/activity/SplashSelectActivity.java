package com.example.test.ui.main.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.i;
import com.example.baselibrary.preseneter.b;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.presenter.main.e1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.mine.activity.AccountValidateActivity;
import com.example.test.ui.mine.activity.LoginActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.a2;
import g4.v;
import g7.w;
import kotlin.jvm.internal.e;
import z3.h;

/* loaded from: classes.dex */
public final class SplashSelectActivity extends XXBaseActivity<e1, a2> implements w, View.OnClickListener {
    public boolean E;

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final b G0() {
        return new e1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((a2) this.f7247z.getValue()).f12687a;
        e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_splash, (ViewGroup) null, false);
        int i3 = R$id.appLogo;
        ImageView imageView = (ImageView) he.a(i3, inflate);
        if (imageView != null) {
            i3 = R$id.btnLogin;
            Button button = (Button) he.a(i3, inflate);
            if (button != null) {
                i3 = R$id.btnRegister;
                Button button2 = (Button) he.a(i3, inflate);
                if (button2 != null) {
                    i3 = R$id.surfaceView;
                    SurfaceView surfaceView = (SurfaceView) he.a(i3, inflate);
                    if (surfaceView != null) {
                        i3 = R$id.tv_pass_login;
                        TextView textView = (TextView) he.a(i3, inflate);
                        if (textView != null) {
                            return new a2((ConstraintLayout) inflate, imageView, button, button2, surfaceView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((e1) I0()).k();
        this.E = false;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((i) ((i) ((i) ((i) com.bumptech.glide.b.c(this).m(Integer.valueOf(R$mipmap.ic_launcher)).o(true)).d(h.f20239b)).i(R$drawable.bg_dial_item)).a(p4.e.t(new v(20))).e(R$drawable.bg_dial_item)).x(((a2) bVar.getValue()).f12688b);
        ((a2) bVar.getValue()).f12691f.setOnClickListener(this);
        ((a2) bVar.getValue()).f12689c.setOnClickListener(this);
        ((a2) bVar.getValue()).f12690d.setOnClickListener(this);
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.tv_pass_login;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (this.E) {
                return;
            }
            Log.d("tong", "click pass btn");
            this.E = true;
            ((e1) I0()).l();
            return;
        }
        int i10 = R$id.btnLogin;
        if (valueOf != null && valueOf.intValue() == i10) {
            startActivity(new Intent(this, (Class<?>) LoginActivity.class));
            return;
        }
        int i11 = R$id.btnRegister;
        if (valueOf != null && valueOf.intValue() == i11) {
            Intent intent = new Intent(this, (Class<?>) AccountValidateActivity.class);
            intent.putExtra("select_type", 0);
            startActivity(intent);
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        eh.b bVar = this.f7247z;
        SurfaceView surfaceView = ((a2) bVar.getValue()).e;
        ((a2) bVar.getValue()).e.setVisibility(8);
    }
}
