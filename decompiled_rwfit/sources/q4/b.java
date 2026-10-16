package q4;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.bumptech.glide.R$id;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b extends a {
    public static final int e = R$id.glide_custom_view_target_tag;

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f17773a;

    /* renamed from: b, reason: collision with root package name */
    public final h f17774b;

    /* renamed from: c, reason: collision with root package name */
    public Animatable f17775c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f17776d;

    public b(ImageView imageView, int i3) {
        this.f17776d = i3;
        t4.f.c(imageView, "Argument must not be null");
        this.f17773a = imageView;
        this.f17774b = new h(imageView);
    }

    @Override // q4.g
    public final void a(com.bumptech.glide.request.a aVar) {
        h hVar = this.f17774b;
        ImageView imageView = hVar.f17787a;
        int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int a3 = hVar.a(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        ImageView imageView2 = hVar.f17787a;
        int paddingBottom = imageView2.getPaddingBottom() + imageView2.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int a10 = hVar.a(imageView2.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
        if ((a3 > 0 || a3 == Integer.MIN_VALUE) && (a10 > 0 || a10 == Integer.MIN_VALUE)) {
            aVar.n(a3, a10);
            return;
        }
        ArrayList arrayList = hVar.f17788b;
        if (!arrayList.contains(aVar)) {
            arrayList.add(aVar);
        }
        if (hVar.f17789c == null) {
            ViewTreeObserver viewTreeObserver = imageView2.getViewTreeObserver();
            c cVar = new c(hVar);
            hVar.f17789c = cVar;
            viewTreeObserver.addOnPreDrawListener(cVar);
        }
    }

    @Override // q4.g
    public final void b(Drawable drawable) {
        j(null);
        this.f17775c = null;
        this.f17773a.setImageDrawable(drawable);
    }

    @Override // q4.g
    public final void c(com.bumptech.glide.request.a aVar) {
        this.f17774b.f17788b.remove(aVar);
    }

    @Override // q4.g
    public final void d(p4.c cVar) {
        this.f17773a.setTag(e, cVar);
    }

    @Override // q4.g
    public final void e(Drawable drawable) {
        j(null);
        this.f17775c = null;
        this.f17773a.setImageDrawable(drawable);
    }

    @Override // q4.g
    public final p4.c f() {
        Object tag = this.f17773a.getTag(e);
        if (tag == null) {
            return null;
        }
        if (tag instanceof p4.c) {
            return (p4.c) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // q4.g
    public final void g(Drawable drawable) {
        h hVar = this.f17774b;
        ViewTreeObserver viewTreeObserver = hVar.f17787a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(hVar.f17789c);
        }
        hVar.f17789c = null;
        hVar.f17788b.clear();
        Animatable animatable = this.f17775c;
        if (animatable != null) {
            animatable.stop();
        }
        j(null);
        this.f17775c = null;
        this.f17773a.setImageDrawable(drawable);
    }

    @Override // q4.g
    public final void h(Object obj) {
        j(obj);
        if (!(obj instanceof Animatable)) {
            this.f17775c = null;
            return;
        }
        Animatable animatable = (Animatable) obj;
        this.f17775c = animatable;
        animatable.start();
    }

    @Override // m4.g
    public final void i() {
        Animatable animatable = this.f17775c;
        if (animatable != null) {
            animatable.start();
        }
    }

    public final void j(Object obj) {
        switch (this.f17776d) {
            case 0:
                this.f17773a.setImageBitmap((Bitmap) obj);
                break;
            default:
                this.f17773a.setImageDrawable((Drawable) obj);
                break;
        }
    }

    @Override // m4.g
    public final void onStop() {
        Animatable animatable = this.f17775c;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public final String toString() {
        return "Target for: " + this.f17773a;
    }
}
