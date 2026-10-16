package androidx.emoji2.text;

import android.graphics.Rect;
import android.view.View;
import android.widget.OverScroller;
import androidx.recyclerview.widget.i1;
import androidx.recyclerview.widget.t0;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public int f2029a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2030b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2031c;

    public g(int i3, View view) {
        this.f2029a = i3;
        this.f2030b = view;
        this.f2031c = new og.g();
    }

    public static g d(i1 i1Var, int i3) {
        if (i3 == 0) {
            return new t0(i1Var, 0);
        }
        if (i3 == 1) {
            return new t0(i1Var, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract void a(OverScroller overScroller, int i3, int i10);

    public abstract void b(OverScroller overScroller, int i3, int i10);

    public abstract og.g c(int i3, int i10);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h(View view);

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int o();

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract boolean r(float f2, int i3);

    public abstract void s(int i3);

    public g(i1 i1Var) {
        this.f2029a = Integer.MIN_VALUE;
        this.f2031c = new Rect();
        this.f2030b = i1Var;
    }

    public g(j jVar) {
        this.f2029a = 0;
        this.f2031c = new d();
        this.f2030b = jVar;
    }
}
