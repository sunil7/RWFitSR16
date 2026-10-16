package q1;

import android.support.v4.media.session.e;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.gms.internal.mlkit_vision_barcode.sf;
import java.util.ArrayList;
import pe.o;

/* loaded from: classes.dex */
public final class d extends sf {

    /* renamed from: a, reason: collision with root package name */
    public final int f17733a;

    /* renamed from: b, reason: collision with root package name */
    public p1.d f17734b;

    /* renamed from: c, reason: collision with root package name */
    public final o f17735c = new o(this, 1);

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DrawerLayout f17736d;

    public d(DrawerLayout drawerLayout, int i3) {
        this.f17736d = drawerLayout;
        this.f17733a = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final int a(int i3, View view) {
        DrawerLayout drawerLayout = this.f17736d;
        if (drawerLayout.a(3, view)) {
            return Math.max(-view.getWidth(), Math.min(i3, 0));
        }
        int width = drawerLayout.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i3, width));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final int b(int i3, View view) {
        return view.getTop();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final int c(View view) {
        if (DrawerLayout.n(view)) {
            return view.getWidth();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final void e(int i3, int i10) {
        int i11 = i3 & 1;
        DrawerLayout drawerLayout = this.f17736d;
        View e = i11 == 1 ? drawerLayout.e(3) : drawerLayout.e(5);
        if (e == null || drawerLayout.h(e) != 0) {
            return;
        }
        this.f17734b.b(i10, e);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final void f() {
        this.f17736d.postDelayed(this.f17735c, 160L);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final void g(int i3, View view) {
        ((c) view.getLayoutParams()).f17731c = false;
        int i10 = this.f17733a == 3 ? 5 : 3;
        DrawerLayout drawerLayout = this.f17736d;
        View e = drawerLayout.e(i10);
        if (e != null) {
            drawerLayout.b(e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final void h(int i3) {
        int i10;
        int size;
        int size2;
        View rootView;
        int size3;
        View view = this.f17734b.f17386t;
        DrawerLayout drawerLayout = this.f17736d;
        int i11 = drawerLayout.f1998g.f17369a;
        int i12 = drawerLayout.f1999h.f17369a;
        if (i11 == 1 || i12 == 1) {
            i10 = 1;
        } else {
            i10 = 2;
            if (i11 != 2 && i12 != 2) {
                i10 = 0;
            }
        }
        if (view != null && i3 == 0) {
            float f2 = ((c) view.getLayoutParams()).f17730b;
            if (f2 == 0.0f) {
                c cVar = (c) view.getLayoutParams();
                if ((cVar.f17732d & 1) == 1) {
                    cVar.f17732d = 0;
                    ArrayList arrayList = drawerLayout.f2009s;
                    if (arrayList != null && (size3 = arrayList.size() - 1) >= 0) {
                        throw e.c(size3, drawerLayout.f2009s);
                    }
                    drawerLayout.t(view, false);
                    drawerLayout.s(view);
                    if (drawerLayout.hasWindowFocus() && (rootView = drawerLayout.getRootView()) != null) {
                        rootView.sendAccessibilityEvent(32);
                    }
                }
            } else if (f2 == 1.0f) {
                c cVar2 = (c) view.getLayoutParams();
                if ((cVar2.f17732d & 1) == 0) {
                    cVar2.f17732d = 1;
                    ArrayList arrayList2 = drawerLayout.f2009s;
                    if (arrayList2 != null && (size2 = arrayList2.size() - 1) >= 0) {
                        throw e.c(size2, drawerLayout.f2009s);
                    }
                    drawerLayout.t(view, true);
                    drawerLayout.s(view);
                    if (drawerLayout.hasWindowFocus()) {
                        drawerLayout.sendAccessibilityEvent(32);
                    }
                }
            }
        }
        if (i10 != drawerLayout.f2002k) {
            drawerLayout.f2002k = i10;
            ArrayList arrayList3 = drawerLayout.f2009s;
            if (arrayList3 != null && (size = arrayList3.size() - 1) >= 0) {
                throw e.c(size, drawerLayout.f2009s);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final void i(View view, int i3, int i10) {
        int width = view.getWidth();
        DrawerLayout drawerLayout = this.f17736d;
        float width2 = (drawerLayout.a(3, view) ? i3 + width : drawerLayout.getWidth() - i3) / width;
        drawerLayout.r(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        drawerLayout.invalidate();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final void j(View view, float f2, float f10) {
        int i3;
        DrawerLayout drawerLayout = this.f17736d;
        int[] iArr = DrawerLayout.C;
        float f11 = ((c) view.getLayoutParams()).f17730b;
        int width = view.getWidth();
        if (drawerLayout.a(3, view)) {
            i3 = (f2 > 0.0f || (f2 == 0.0f && f11 > 0.5f)) ? 0 : -width;
        } else {
            int width2 = drawerLayout.getWidth();
            if (f2 < 0.0f || (f2 == 0.0f && f11 > 0.5f)) {
                width2 -= width;
            }
            i3 = width2;
        }
        this.f17734b.q(i3, view.getTop());
        drawerLayout.invalidate();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.sf
    public final boolean k(int i3, View view) {
        DrawerLayout drawerLayout = this.f17736d;
        return DrawerLayout.n(view) && drawerLayout.a(this.f17733a, view) && drawerLayout.h(view) == 0;
    }
}
