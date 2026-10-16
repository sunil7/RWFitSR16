package g;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import h.a0;

/* loaded from: classes.dex */
public final class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13701a;

    /* renamed from: b, reason: collision with root package name */
    public final a f13702b;

    public f(Context context, a aVar) {
        this.f13701a = context;
        this.f13702b = aVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f13702b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f13702b.b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new a0(this.f13701a, this.f13702b.c());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f13702b.e();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f13702b.f();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f13702b.f13689a;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f13702b.g();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f13702b.f13690b;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f13702b.h();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f13702b.i();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f13702b.j(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f13702b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f13702b.f13689a = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f13702b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z5) {
        this.f13702b.p(z5);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i3) {
        this.f13702b.l(i3);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i3) {
        this.f13702b.n(i3);
    }
}
