package androidx.appcompat.app;

import android.R;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle$Event;
import com.google.android.gms.internal.mlkit_vision_barcode.zd;

/* loaded from: classes.dex */
public abstract class e0 extends Dialog implements m, androidx.lifecycle.s, androidx.activity.p {

    /* renamed from: a, reason: collision with root package name */
    public androidx.lifecycle.u f465a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.activity.o f466b;

    /* renamed from: c, reason: collision with root package name */
    public c0 f467c;

    /* renamed from: d, reason: collision with root package name */
    public final d0 f468d;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.appcompat.app.d0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e0(android.content.Context r5, int r6) {
        /*
            r4 = this;
            r0 = 1
            if (r6 != 0) goto L14
            android.util.TypedValue r1 = new android.util.TypedValue
            r1.<init>()
            android.content.res.Resources$Theme r2 = r5.getTheme()
            int r3 = androidx.appcompat.R$attr.dialogTheme
            r2.resolveAttribute(r3, r1, r0)
            int r1 = r1.resourceId
            goto L15
        L14:
            r1 = r6
        L15:
            java.lang.String r2 = "context"
            kotlin.jvm.internal.e.f(r5, r2)
            r4.<init>(r5, r1)
            androidx.activity.o r1 = new androidx.activity.o
            androidx.activity.b r2 = new androidx.activity.b
            r3 = 1
            r2.<init>(r4, r3)
            r1.<init>(r2)
            r4.f466b = r1
            androidx.appcompat.app.d0 r1 = new androidx.appcompat.app.d0
            r1.<init>()
            r4.f468d = r1
            androidx.appcompat.app.p r1 = r4.b()
            if (r6 != 0) goto L47
            android.util.TypedValue r6 = new android.util.TypedValue
            r6.<init>()
            android.content.res.Resources$Theme r5 = r5.getTheme()
            int r2 = androidx.appcompat.R$attr.dialogTheme
            r5.resolveAttribute(r2, r6, r0)
            int r6 = r6.resourceId
        L47:
            r5 = r1
            androidx.appcompat.app.c0 r5 = (androidx.appcompat.app.c0) r5
            r5.T = r6
            r1.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.e0.<init>(android.content.Context, int):void");
    }

    public static void a(e0 e0Var) {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c0 c0Var = (c0) b();
        c0Var.w();
        ((ViewGroup) c0Var.A.findViewById(R.id.content)).addView(view, layoutParams);
        c0Var.f434m.a(c0Var.f433l.getCallback());
    }

    public final p b() {
        if (this.f467c == null) {
            j0 j0Var = p.f530a;
            this.f467c = new c0(getContext(), getWindow(), this, this);
        }
        return this.f467c;
    }

    public final void c(Bundle bundle) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            androidx.activity.o oVar = this.f466b;
            oVar.e = onBackInvokedDispatcher;
            oVar.c();
        }
        androidx.lifecycle.u uVar = this.f465a;
        if (uVar == null) {
            uVar = new androidx.lifecycle.u(this);
            this.f465a = uVar;
        }
        uVar.e(Lifecycle$Event.ON_CREATE);
    }

    public final void d() {
        androidx.lifecycle.u uVar = this.f465a;
        if (uVar == null) {
            uVar = new androidx.lifecycle.u(this);
            this.f465a = uVar;
        }
        uVar.e(Lifecycle$Event.ON_DESTROY);
        this.f465a = null;
        super.onStop();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        b().f();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return zd.b(this.f468d, getWindow().getDecorView(), this, keyEvent);
    }

    public final boolean e(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final View findViewById(int i3) {
        c0 c0Var = (c0) b();
        c0Var.w();
        return c0Var.f433l.findViewById(i3);
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.n getLifecycle() {
        androidx.lifecycle.u uVar = this.f465a;
        if (uVar != null) {
            return uVar;
        }
        androidx.lifecycle.u uVar2 = new androidx.lifecycle.u(this);
        this.f465a = uVar2;
        return uVar2;
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        b().b();
    }

    @Override // androidx.activity.p
    public final androidx.activity.o l() {
        return this.f466b;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f466b.b();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        b().a();
        c(bundle);
        b().e();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        androidx.lifecycle.u uVar = this.f465a;
        if (uVar == null) {
            uVar = new androidx.lifecycle.u(this);
            this.f465a = uVar;
        }
        uVar.e(Lifecycle$Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        d();
        c0 c0Var = (c0) b();
        c0Var.A();
        p0 p0Var = c0Var.f436o;
        if (p0Var != null) {
            p0Var.f557t = false;
            g.j jVar = p0Var.f556s;
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        b().i(i3);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        b().m(charSequence);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        b().j(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b().l(view, layoutParams);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i3) {
        super.setTitle(i3);
        b().m(getContext().getString(i3));
    }
}
