package d4;

import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class n extends n.m {
    @Override // n.m
    public final void e(Object obj, Object obj2) {
        o oVar = (o) obj;
        oVar.getClass();
        ArrayDeque arrayDeque = o.f12278b;
        synchronized (arrayDeque) {
            arrayDeque.offer(oVar);
        }
    }
}
