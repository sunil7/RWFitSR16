package q4;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bumptech.glide.R$id;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class e implements g {

    /* renamed from: c, reason: collision with root package name */
    public static final int f17783c = R$id.glide_custom_view_target_tag;

    /* renamed from: a, reason: collision with root package name */
    public final d f17784a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup f17785b;

    public e(ViewGroup viewGroup) {
        this.f17785b = viewGroup;
        this.f17784a = new d(viewGroup);
    }

    @Override // q4.g
    public final void a(com.bumptech.glide.request.a aVar) {
        d dVar = this.f17784a;
        ViewGroup viewGroup = dVar.f17780a;
        int paddingRight = viewGroup.getPaddingRight() + viewGroup.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int a3 = dVar.a(viewGroup.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        ViewGroup viewGroup2 = dVar.f17780a;
        int paddingBottom = viewGroup2.getPaddingBottom() + viewGroup2.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
        int a10 = dVar.a(viewGroup2.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
        if ((a3 > 0 || a3 == Integer.MIN_VALUE) && (a10 > 0 || a10 == Integer.MIN_VALUE)) {
            aVar.n(a3, a10);
            return;
        }
        ArrayList arrayList = dVar.f17781b;
        if (!arrayList.contains(aVar)) {
            arrayList.add(aVar);
        }
        if (dVar.f17782c == null) {
            ViewTreeObserver viewTreeObserver = viewGroup2.getViewTreeObserver();
            c cVar = new c(dVar);
            dVar.f17782c = cVar;
            viewTreeObserver.addOnPreDrawListener(cVar);
        }
    }

    @Override // q4.g
    public final void c(com.bumptech.glide.request.a aVar) {
        this.f17784a.f17781b.remove(aVar);
    }

    @Override // q4.g
    public final void d(p4.c cVar) {
        this.f17785b.setTag(f17783c, cVar);
    }

    @Override // q4.g
    public final void e(Drawable drawable) {
    }

    @Override // q4.g
    public final p4.c f() {
        Object tag = this.f17785b.getTag(f17783c);
        if (tag == null) {
            return null;
        }
        if (tag instanceof p4.c) {
            return (p4.c) tag;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // q4.g
    public final void g(Drawable drawable) {
        d dVar = this.f17784a;
        ViewTreeObserver viewTreeObserver = dVar.f17780a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(dVar.f17782c);
        }
        dVar.f17782c = null;
        dVar.f17781b.clear();
        j(drawable);
    }

    @Override // m4.g
    public final void i() {
    }

    public abstract void j(Drawable drawable);

    @Override // m4.g
    public final void onDestroy() {
    }

    @Override // m4.g
    public final void onStop() {
    }

    public final String toString() {
        return "Target for: " + this.f17785b;
    }
}
