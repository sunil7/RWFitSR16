package androidx.appcompat.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class r3 implements h.x {

    /* renamed from: a, reason: collision with root package name */
    public h.k f1036a;

    /* renamed from: b, reason: collision with root package name */
    public h.m f1037b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Toolbar f1038c;

    public r3(Toolbar toolbar) {
        this.f1038c = toolbar;
    }

    @Override // h.x
    public final void b(h.k kVar, boolean z5) {
    }

    @Override // h.x
    public final void e(Parcelable parcelable) {
    }

    @Override // h.x
    public final void g(boolean z5) {
        if (this.f1037b != null) {
            h.k kVar = this.f1036a;
            if (kVar != null) {
                int size = kVar.f14148f.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (this.f1036a.getItem(i3) == this.f1037b) {
                        return;
                    }
                }
            }
            l(this.f1037b);
        }
    }

    @Override // h.x
    public final int getId() {
        return 0;
    }

    @Override // h.x
    public final void h(Context context, h.k kVar) {
        h.m mVar;
        h.k kVar2 = this.f1036a;
        if (kVar2 != null && (mVar = this.f1037b) != null) {
            kVar2.d(mVar);
        }
        this.f1036a = kVar;
    }

    @Override // h.x
    public final boolean i() {
        return false;
    }

    @Override // h.x
    public final Parcelable j() {
        return null;
    }

    @Override // h.x
    public final boolean k(h.m mVar) {
        Toolbar toolbar = this.f1038c;
        toolbar.c();
        ViewParent parent = toolbar.f842h.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f842h);
            }
            toolbar.addView(toolbar.f842h);
        }
        View actionView = mVar.getActionView();
        toolbar.f843i = actionView;
        this.f1037b = mVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f843i);
            }
            s3 h4 = Toolbar.h();
            h4.f1048a = (toolbar.f848n & 112) | 8388611;
            h4.f1049b = 2;
            toolbar.f843i.setLayoutParams(h4);
            toolbar.addView(toolbar.f843i);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((s3) childAt.getLayoutParams()).f1049b != 2 && childAt != toolbar.f836a) {
                toolbar.removeViewAt(childCount);
                toolbar.E.add(childAt);
            }
        }
        toolbar.requestLayout();
        mVar.C = true;
        mVar.f14181n.p(false);
        KeyEvent.Callback callback = toolbar.f843i;
        if (callback instanceof g.b) {
            ((g.b) callback).c();
        }
        toolbar.t();
        return true;
    }

    @Override // h.x
    public final boolean l(h.m mVar) {
        Toolbar toolbar = this.f1038c;
        KeyEvent.Callback callback = toolbar.f843i;
        if (callback instanceof g.b) {
            ((g.b) callback).e();
        }
        toolbar.removeView(toolbar.f843i);
        toolbar.removeView(toolbar.f842h);
        toolbar.f843i = null;
        ArrayList arrayList = toolbar.E;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f1037b = null;
        toolbar.requestLayout();
        mVar.C = false;
        mVar.f14181n.p(false);
        toolbar.t();
        return true;
    }

    @Override // h.x
    public final boolean m(h.d0 d0Var) {
        return false;
    }
}
