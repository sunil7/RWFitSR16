package l1;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public abstract class y1 extends c2 {

    /* renamed from: a, reason: collision with root package name */
    public final Window f15743a;

    /* renamed from: b, reason: collision with root package name */
    public final View f15744b;

    public y1(Window window, View view) {
        this.f15743a = window;
        this.f15744b = view;
    }

    @Override // l1.c2
    public void addOnControllableInsetsChangedListener(d2 d2Var) {
    }

    @Override // l1.c2
    public void removeOnControllableInsetsChangedListener(d2 d2Var) {
    }
}
