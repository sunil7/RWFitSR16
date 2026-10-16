package ch;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class b implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3500a;

    public /* synthetic */ b(int i3) {
        this.f3500a = i3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f3500a) {
            case 0:
                return a.f3499a;
            case 1:
                return c.f3501a;
            case 2:
                return d.f3502a;
            case 3:
                return e.f3503a;
            default:
                return null;
        }
    }
}
