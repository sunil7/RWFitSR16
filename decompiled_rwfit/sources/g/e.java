package g;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import com.example.test.utils.y;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class e extends a implements h.i {

    /* renamed from: c, reason: collision with root package name */
    public Context f13696c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContextView f13697d;
    public y e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f13698f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13699g;

    /* renamed from: h, reason: collision with root package name */
    public h.k f13700h;

    @Override // g.a
    public final void a() {
        if (this.f13699g) {
            return;
        }
        this.f13699g = true;
        this.e.B(this);
    }

    @Override // g.a
    public final View b() {
        WeakReference weakReference = this.f13698f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // g.a
    public final h.k c() {
        return this.f13700h;
    }

    @Override // h.i
    public final boolean d(h.k kVar, MenuItem menuItem) {
        return ((v2.h) this.e.f8773b).l(this, menuItem);
    }

    @Override // g.a
    public final MenuInflater e() {
        return new i(this.f13697d.getContext());
    }

    @Override // g.a
    public final CharSequence f() {
        return this.f13697d.getSubtitle();
    }

    @Override // g.a
    public final CharSequence g() {
        return this.f13697d.getTitle();
    }

    @Override // g.a
    public final void h() {
        this.e.D(this, this.f13700h);
    }

    @Override // g.a
    public final boolean i() {
        return this.f13697d.f631s;
    }

    @Override // g.a
    public final void j(View view) {
        this.f13697d.setCustomView(view);
        this.f13698f = view != null ? new WeakReference(view) : null;
    }

    @Override // h.i
    public final void k(h.k kVar) {
        h();
        androidx.appcompat.widget.l lVar = this.f13697d.f618d;
        if (lVar != null) {
            lVar.n();
        }
    }

    @Override // g.a
    public final void l(int i3) {
        m(this.f13696c.getString(i3));
    }

    @Override // g.a
    public final void m(CharSequence charSequence) {
        this.f13697d.setSubtitle(charSequence);
    }

    @Override // g.a
    public final void n(int i3) {
        o(this.f13696c.getString(i3));
    }

    @Override // g.a
    public final void o(CharSequence charSequence) {
        this.f13697d.setTitle(charSequence);
    }

    @Override // g.a
    public final void p(boolean z5) {
        this.f13690b = z5;
        this.f13697d.setTitleOptional(z5);
    }
}
