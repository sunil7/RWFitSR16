package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public TypedValue f735a;

    /* renamed from: b, reason: collision with root package name */
    public TypedValue f736b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f737c;

    /* renamed from: d, reason: collision with root package name */
    public TypedValue f738d;
    public TypedValue e;

    /* renamed from: f, reason: collision with root package name */
    public TypedValue f739f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f740g;

    /* renamed from: h, reason: collision with root package name */
    public i1 f741h;

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f739f == null) {
            this.f739f = new TypedValue();
        }
        return this.f739f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f737c == null) {
            this.f737c = new TypedValue();
        }
        return this.f737c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f738d == null) {
            this.f738d = new TypedValue();
        }
        return this.f738d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f735a == null) {
            this.f735a = new TypedValue();
        }
        return this.f735a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f736b == null) {
            this.f736b = new TypedValue();
        }
        return this.f736b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        i1 i1Var = this.f741h;
        if (i1Var != null) {
            i1Var.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        l lVar;
        super.onDetachedFromWindow();
        i1 i1Var = this.f741h;
        if (i1Var != null) {
            androidx.appcompat.app.c0 c0Var = (androidx.appcompat.app.c0) ((y2.f) i1Var).f19953b;
            j1 j1Var = c0Var.r;
            if (j1Var != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) j1Var;
                actionBarOverlayLayout.k();
                ActionMenuView actionMenuView = ((x3) actionBarOverlayLayout.e).f1109a.f836a;
                if (actionMenuView != null && (lVar = actionMenuView.f660t) != null) {
                    lVar.d();
                    f fVar = lVar.f971u;
                    if (fVar != null && fVar.b()) {
                        fVar.f14212i.dismiss();
                    }
                }
            }
            if (c0Var.f443w != null) {
                c0Var.f433l.getDecorView().removeCallbacks(c0Var.f444x);
                if (c0Var.f443w.isShowing()) {
                    try {
                        c0Var.f443w.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                c0Var.f443w = null;
            }
            l1.g1 g1Var = c0Var.f445y;
            if (g1Var != null) {
                g1Var.b();
            }
            h.k kVar = c0Var.z(0).f410h;
            if (kVar != null) {
                kVar.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b3  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(i1 i1Var) {
        this.f741h = i1Var;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f740g = new Rect();
    }
}
