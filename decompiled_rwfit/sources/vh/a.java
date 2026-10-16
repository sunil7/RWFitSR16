package vh;

import java.util.Iterator;

/* loaded from: classes2.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c f19261a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19262b;

    public a(c cVar, int i3) {
        this.f19261a = cVar;
        this.f19262b = i3;
        if (i3 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i3 + '.').toString());
    }

    @Override // vh.c
    public final Iterator iterator() {
        return new kotlin.collections.b(this);
    }
}
