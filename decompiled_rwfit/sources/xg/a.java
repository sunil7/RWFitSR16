package xg;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final int f19824a;

    public a(int i3) {
        this.f19824a = i3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return new ArrayList(this.f19824a);
    }
}
