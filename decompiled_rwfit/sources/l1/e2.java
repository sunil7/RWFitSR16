package l1;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class e2 {

    /* renamed from: a, reason: collision with root package name */
    public final c2 f15688a;

    public e2(Window window, View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f15688a = new b2(window, this);
        } else {
            this.f15688a = new z1(window, view);
        }
    }

    public final void a(boolean z5) {
        this.f15688a.a(z5);
    }

    public void addOnControllableInsetsChangedListener(d2 d2Var) {
        this.f15688a.addOnControllableInsetsChangedListener(d2Var);
    }

    public final void b(boolean z5) {
        this.f15688a.b(z5);
    }

    public void removeOnControllableInsetsChangedListener(d2 d2Var) {
        this.f15688a.removeOnControllableInsetsChangedListener(d2Var);
    }
}
