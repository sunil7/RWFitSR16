package l1;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public final class b2 extends c2 {

    /* renamed from: a, reason: collision with root package name */
    public final WindowInsetsController f15678a;

    /* renamed from: b, reason: collision with root package name */
    public final m0.k f15679b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f15680c;

    public b2(Window window, e2 e2Var) {
        WindowInsetsController insetsController;
        insetsController = window.getInsetsController();
        this.f15679b = new m0.k();
        this.f15678a = insetsController;
        this.f15680c = window;
    }

    @Override // l1.c2
    public final void a(boolean z5) {
        Window window = this.f15680c;
        if (z5) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.f15678a.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.f15678a.setSystemBarsAppearance(0, 16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, l1.a2] */
    @Override // l1.c2
    public void addOnControllableInsetsChangedListener(d2 d2Var) {
        m0.k kVar = this.f15679b;
        if (kVar.containsKey(d2Var)) {
            return;
        }
        ?? r12 = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: l1.a2
            @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
            public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i3) {
                if (b2.this.f15678a == windowInsetsController) {
                    throw null;
                }
            }
        };
        kVar.put(d2Var, r12);
        this.f15678a.addOnControllableInsetsChangedListener(r12);
    }

    @Override // l1.c2
    public final void b(boolean z5) {
        Window window = this.f15680c;
        if (z5) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            this.f15678a.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.f15678a.setSystemBarsAppearance(0, 8);
    }

    @Override // l1.c2
    public void removeOnControllableInsetsChangedListener(d2 d2Var) {
        WindowInsetsController.OnControllableInsetsChangedListener i3 = com.google.android.gms.common.api.d.i(this.f15679b.remove(d2Var));
        if (i3 != null) {
            this.f15678a.removeOnControllableInsetsChangedListener(i3);
        }
    }
}
