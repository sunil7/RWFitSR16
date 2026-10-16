package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.k0;
import androidx.fragment.app.t0;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import com.google.android.gms.internal.mlkit_vision_barcode.ic;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f373a;

    /* renamed from: c, reason: collision with root package name */
    public final k f375c;

    /* renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f376d;
    public OnBackInvokedDispatcher e;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f374b = new ArrayDeque();

    /* renamed from: f, reason: collision with root package name */
    public boolean f377f = false;

    public o(Runnable runnable) {
        this.f373a = runnable;
        if (ic.b()) {
            this.f375c = new k(this, 0);
            this.f376d = m.a(new b(this, 2));
        }
    }

    public final void a(s sVar, k0 k0Var) {
        androidx.lifecycle.n lifecycle = sVar.getLifecycle();
        if (((u) lifecycle).f2390b == Lifecycle$State.DESTROYED) {
            return;
        }
        k0Var.f2210b.add(new OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(this, lifecycle, k0Var));
        if (ic.b()) {
            c();
            k0Var.f2211c = this.f375c;
        }
    }

    public final void b() {
        Iterator descendingIterator = this.f374b.descendingIterator();
        while (descendingIterator.hasNext()) {
            k0 k0Var = (k0) descendingIterator.next();
            if (k0Var.f2209a) {
                t0 t0Var = k0Var.f2212d;
                t0Var.s(true);
                if (t0Var.f2276h.f2209a) {
                    t0Var.G();
                    return;
                } else {
                    t0Var.f2275g.b();
                    return;
                }
            }
        }
        Runnable runnable = this.f373a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void c() {
        boolean z5;
        Iterator descendingIterator = this.f374b.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z5 = false;
                break;
            } else if (((k0) descendingIterator.next()).f2209a) {
                z5 = true;
                break;
            }
        }
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.e;
        if (onBackInvokedDispatcher != null) {
            if (z5 && !this.f377f) {
                m.b(onBackInvokedDispatcher, 0, this.f376d);
                this.f377f = true;
            } else {
                if (z5 || !this.f377f) {
                    return;
                }
                m.c(onBackInvokedDispatcher, this.f376d);
                this.f377f = false;
            }
        }
    }
}
