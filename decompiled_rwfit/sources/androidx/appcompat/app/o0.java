package androidx.appcompat.app;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class o0 extends g.a implements h.i {

    /* renamed from: c, reason: collision with root package name */
    public final Context f526c;

    /* renamed from: d, reason: collision with root package name */
    public final h.k f527d;
    public com.example.test.utils.y e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f528f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ p0 f529g;

    public o0(p0 p0Var, Context context, com.example.test.utils.y yVar) {
        this.f529g = p0Var;
        this.f526c = context;
        this.e = yVar;
        h.k kVar = new h.k(context);
        kVar.f14154l = 1;
        this.f527d = kVar;
        kVar.e = this;
    }

    @Override // g.a
    public final void a() {
        p0 p0Var = this.f529g;
        if (p0Var.f547i != this) {
            return;
        }
        if (p0Var.f554p) {
            p0Var.f548j = this;
            p0Var.f549k = this.e;
        } else {
            this.e.B(this);
        }
        this.e = null;
        p0Var.a(false);
        ActionBarContextView actionBarContextView = p0Var.f544f;
        if (actionBarContextView.f624k == null) {
            actionBarContextView.e();
        }
        p0Var.f542c.setHideOnContentScrollEnabled(p0Var.f558u);
        p0Var.f547i = null;
    }

    @Override // g.a
    public final View b() {
        WeakReference weakReference = this.f528f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // g.a
    public final h.k c() {
        return this.f527d;
    }

    @Override // h.i
    public final boolean d(h.k kVar, MenuItem menuItem) {
        com.example.test.utils.y yVar = this.e;
        if (yVar != null) {
            return ((v2.h) yVar.f8773b).l(this, menuItem);
        }
        return false;
    }

    @Override // g.a
    public final MenuInflater e() {
        return new g.i(this.f526c);
    }

    @Override // g.a
    public final CharSequence f() {
        return this.f529g.f544f.getSubtitle();
    }

    @Override // g.a
    public final CharSequence g() {
        return this.f529g.f544f.getTitle();
    }

    @Override // g.a
    public final void h() {
        if (this.f529g.f547i != this) {
            return;
        }
        h.k kVar = this.f527d;
        kVar.y();
        try {
            this.e.D(this, kVar);
        } finally {
            kVar.x();
        }
    }

    @Override // g.a
    public final boolean i() {
        return this.f529g.f544f.f631s;
    }

    @Override // g.a
    public final void j(View view) {
        this.f529g.f544f.setCustomView(view);
        this.f528f = new WeakReference(view);
    }

    @Override // h.i
    public final void k(h.k kVar) {
        if (this.e == null) {
            return;
        }
        h();
        androidx.appcompat.widget.l lVar = this.f529g.f544f.f618d;
        if (lVar != null) {
            lVar.n();
        }
    }

    @Override // g.a
    public final void l(int i3) {
        m(this.f529g.f540a.getResources().getString(i3));
    }

    @Override // g.a
    public final void m(CharSequence charSequence) {
        this.f529g.f544f.setSubtitle(charSequence);
    }

    @Override // g.a
    public final void n(int i3) {
        o(this.f529g.f540a.getResources().getString(i3));
    }

    @Override // g.a
    public final void o(CharSequence charSequence) {
        this.f529g.f544f.setTitle(charSequence);
    }

    @Override // g.a
    public final void p(boolean z5) {
        this.f13690b = z5;
        this.f529g.f544f.setTitleOptional(z5);
    }
}
