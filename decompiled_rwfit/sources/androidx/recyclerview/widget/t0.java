package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class t0 extends androidx.emoji2.text.g {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f2743d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t0(i1 i1Var, int i3) {
        super(i1Var);
        this.f2743d = i3;
    }

    @Override // androidx.emoji2.text.g
    public final int e(View view) {
        switch (this.f2743d) {
            case 0:
                j1 j1Var = (j1) view.getLayoutParams();
                ((i1) this.f2030b).getClass();
                return i1.C(view) + ((ViewGroup.MarginLayoutParams) j1Var).rightMargin;
            default:
                j1 j1Var2 = (j1) view.getLayoutParams();
                ((i1) this.f2030b).getClass();
                return i1.y(view) + ((ViewGroup.MarginLayoutParams) j1Var2).bottomMargin;
        }
    }

    @Override // androidx.emoji2.text.g
    public final int f(View view) {
        switch (this.f2743d) {
            case 0:
                j1 j1Var = (j1) view.getLayoutParams();
                ((i1) this.f2030b).getClass();
                Rect rect = ((j1) view.getLayoutParams()).f2634b;
                return view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) j1Var).leftMargin + ((ViewGroup.MarginLayoutParams) j1Var).rightMargin;
            default:
                j1 j1Var2 = (j1) view.getLayoutParams();
                ((i1) this.f2030b).getClass();
                return i1.B(view) + ((ViewGroup.MarginLayoutParams) j1Var2).topMargin + ((ViewGroup.MarginLayoutParams) j1Var2).bottomMargin;
        }
    }

    @Override // androidx.emoji2.text.g
    public final int g(View view) {
        switch (this.f2743d) {
            case 0:
                j1 j1Var = (j1) view.getLayoutParams();
                ((i1) this.f2030b).getClass();
                return i1.B(view) + ((ViewGroup.MarginLayoutParams) j1Var).topMargin + ((ViewGroup.MarginLayoutParams) j1Var).bottomMargin;
            default:
                j1 j1Var2 = (j1) view.getLayoutParams();
                ((i1) this.f2030b).getClass();
                Rect rect = ((j1) view.getLayoutParams()).f2634b;
                return view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) j1Var2).leftMargin + ((ViewGroup.MarginLayoutParams) j1Var2).rightMargin;
        }
    }

    @Override // androidx.emoji2.text.g
    public final int h(View view) {
        switch (this.f2743d) {
            case 0:
                j1 j1Var = (j1) view.getLayoutParams();
                ((i1) this.f2030b).getClass();
                return i1.A(view) - ((ViewGroup.MarginLayoutParams) j1Var).leftMargin;
            default:
                j1 j1Var2 = (j1) view.getLayoutParams();
                ((i1) this.f2030b).getClass();
                return i1.D(view) - ((ViewGroup.MarginLayoutParams) j1Var2).topMargin;
        }
    }

    @Override // androidx.emoji2.text.g
    public final int i() {
        switch (this.f2743d) {
            case 0:
                return ((i1) this.f2030b).f2597n;
            default:
                return ((i1) this.f2030b).f2598o;
        }
    }

    @Override // androidx.emoji2.text.g
    public final int j() {
        switch (this.f2743d) {
            case 0:
                i1 i1Var = (i1) this.f2030b;
                return i1Var.f2597n - i1Var.I();
            default:
                i1 i1Var2 = (i1) this.f2030b;
                return i1Var2.f2598o - i1Var2.G();
        }
    }

    @Override // androidx.emoji2.text.g
    public final int k() {
        switch (this.f2743d) {
            case 0:
                return ((i1) this.f2030b).I();
            default:
                return ((i1) this.f2030b).G();
        }
    }

    @Override // androidx.emoji2.text.g
    public final int l() {
        switch (this.f2743d) {
            case 0:
                return ((i1) this.f2030b).f2595l;
            default:
                return ((i1) this.f2030b).f2596m;
        }
    }

    @Override // androidx.emoji2.text.g
    public final int m() {
        switch (this.f2743d) {
            case 0:
                return ((i1) this.f2030b).f2596m;
            default:
                return ((i1) this.f2030b).f2595l;
        }
    }

    @Override // androidx.emoji2.text.g
    public final int n() {
        switch (this.f2743d) {
            case 0:
                return ((i1) this.f2030b).H();
            default:
                return ((i1) this.f2030b).J();
        }
    }

    @Override // androidx.emoji2.text.g
    public final int o() {
        switch (this.f2743d) {
            case 0:
                i1 i1Var = (i1) this.f2030b;
                return (i1Var.f2597n - i1Var.H()) - i1Var.I();
            default:
                i1 i1Var2 = (i1) this.f2030b;
                return (i1Var2.f2598o - i1Var2.J()) - i1Var2.G();
        }
    }

    @Override // androidx.emoji2.text.g
    public final int p(View view) {
        switch (this.f2743d) {
            case 0:
                i1 i1Var = (i1) this.f2030b;
                Rect rect = (Rect) this.f2031c;
                i1Var.N(view, rect);
                return rect.right;
            default:
                i1 i1Var2 = (i1) this.f2030b;
                Rect rect2 = (Rect) this.f2031c;
                i1Var2.N(view, rect2);
                return rect2.bottom;
        }
    }

    @Override // androidx.emoji2.text.g
    public final int q(View view) {
        switch (this.f2743d) {
            case 0:
                i1 i1Var = (i1) this.f2030b;
                Rect rect = (Rect) this.f2031c;
                i1Var.N(view, rect);
                return rect.left;
            default:
                i1 i1Var2 = (i1) this.f2030b;
                Rect rect2 = (Rect) this.f2031c;
                i1Var2.N(view, rect2);
                return rect2.top;
        }
    }

    @Override // androidx.emoji2.text.g
    public final void s(int i3) {
        switch (this.f2743d) {
            case 0:
                ((i1) this.f2030b).R(i3);
                break;
            default:
                ((i1) this.f2030b).S(i3);
                break;
        }
    }
}
