package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class h1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2579a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i1 f2580b;

    public /* synthetic */ h1(i1 i1Var, int i3) {
        this.f2579a = i3;
        this.f2580b = i1Var;
    }

    public final int a(View view) {
        switch (this.f2579a) {
            case 0:
                j1 j1Var = (j1) view.getLayoutParams();
                this.f2580b.getClass();
                return i1.C(view) + ((ViewGroup.MarginLayoutParams) j1Var).rightMargin;
            default:
                j1 j1Var2 = (j1) view.getLayoutParams();
                this.f2580b.getClass();
                return i1.y(view) + ((ViewGroup.MarginLayoutParams) j1Var2).bottomMargin;
        }
    }

    public final int b(View view) {
        switch (this.f2579a) {
            case 0:
                j1 j1Var = (j1) view.getLayoutParams();
                this.f2580b.getClass();
                return i1.A(view) - ((ViewGroup.MarginLayoutParams) j1Var).leftMargin;
            default:
                j1 j1Var2 = (j1) view.getLayoutParams();
                this.f2580b.getClass();
                return i1.D(view) - ((ViewGroup.MarginLayoutParams) j1Var2).topMargin;
        }
    }

    public final int c() {
        switch (this.f2579a) {
            case 0:
                i1 i1Var = this.f2580b;
                return i1Var.f2597n - i1Var.I();
            default:
                i1 i1Var2 = this.f2580b;
                return i1Var2.f2598o - i1Var2.G();
        }
    }

    public final int d() {
        switch (this.f2579a) {
            case 0:
                return this.f2580b.H();
            default:
                return this.f2580b.J();
        }
    }
}
