package q4;

import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17777a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f17778b;

    public c(d dVar) {
        this.f17778b = new WeakReference(dVar);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        switch (this.f17777a) {
            case 0:
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                d dVar = (d) this.f17778b.get();
                if (dVar != null) {
                    ArrayList arrayList = dVar.f17781b;
                    if (!arrayList.isEmpty()) {
                        ViewGroup viewGroup = dVar.f17780a;
                        int paddingRight = viewGroup.getPaddingRight() + viewGroup.getPaddingLeft();
                        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                        int i3 = 0;
                        int a3 = dVar.a(viewGroup.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
                        int paddingBottom = viewGroup.getPaddingBottom() + viewGroup.getPaddingTop();
                        ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
                        int a10 = dVar.a(viewGroup.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
                        if (a3 > 0 || a3 == Integer.MIN_VALUE) {
                            if (a10 > 0 || a10 == Integer.MIN_VALUE) {
                                ArrayList arrayList2 = new ArrayList(arrayList);
                                int size = arrayList2.size();
                                while (i3 < size) {
                                    Object obj = arrayList2.get(i3);
                                    i3++;
                                    ((com.bumptech.glide.request.a) ((f) obj)).n(a3, a10);
                                }
                                ViewTreeObserver viewTreeObserver = viewGroup.getViewTreeObserver();
                                if (viewTreeObserver.isAlive()) {
                                    viewTreeObserver.removeOnPreDrawListener(dVar.f17782c);
                                }
                                dVar.f17782c = null;
                                arrayList.clear();
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                h hVar = (h) this.f17778b.get();
                if (hVar != null) {
                    ArrayList arrayList3 = hVar.f17788b;
                    if (!arrayList3.isEmpty()) {
                        ImageView imageView = hVar.f17787a;
                        int paddingRight2 = imageView.getPaddingRight() + imageView.getPaddingLeft();
                        ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
                        int i10 = 0;
                        int a11 = hVar.a(imageView.getWidth(), layoutParams3 != null ? layoutParams3.width : 0, paddingRight2);
                        int paddingBottom2 = imageView.getPaddingBottom() + imageView.getPaddingTop();
                        ViewGroup.LayoutParams layoutParams4 = imageView.getLayoutParams();
                        int a12 = hVar.a(imageView.getHeight(), layoutParams4 != null ? layoutParams4.height : 0, paddingBottom2);
                        if (a11 > 0 || a11 == Integer.MIN_VALUE) {
                            if (a12 > 0 || a12 == Integer.MIN_VALUE) {
                                ArrayList arrayList4 = new ArrayList(arrayList3);
                                int size2 = arrayList4.size();
                                while (i10 < size2) {
                                    Object obj2 = arrayList4.get(i10);
                                    i10++;
                                    ((com.bumptech.glide.request.a) ((f) obj2)).n(a11, a12);
                                }
                                ViewTreeObserver viewTreeObserver2 = imageView.getViewTreeObserver();
                                if (viewTreeObserver2.isAlive()) {
                                    viewTreeObserver2.removeOnPreDrawListener(hVar.f17789c);
                                }
                                hVar.f17789c = null;
                                arrayList3.clear();
                                break;
                            }
                        }
                    }
                }
                break;
        }
        return true;
    }

    public c(h hVar) {
        this.f17778b = new WeakReference(hVar);
    }
}
