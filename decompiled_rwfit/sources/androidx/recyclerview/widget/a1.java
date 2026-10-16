package androidx.recyclerview.widget;

import android.database.Observable;

/* loaded from: classes.dex */
public final class a1 extends Observable {
    public final boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((b1) ((Observable) this).mObservers.get(size)).a();
        }
    }

    public final void c(int i3, int i10) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((b1) ((Observable) this).mObservers.get(size)).d(i3, i10);
        }
    }

    public final void d(int i3, int i10, Object obj) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((b1) ((Observable) this).mObservers.get(size)).b(i3, i10, obj);
        }
    }

    public final void e(int i3, int i10) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((b1) ((Observable) this).mObservers.get(size)).c(i3, i10);
        }
    }

    public final void f(int i3, int i10) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((b1) ((Observable) this).mObservers.get(size)).e(i3, i10);
        }
    }

    public final void g() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((b1) ((Observable) this).mObservers.get(size)).f();
        }
    }
}
