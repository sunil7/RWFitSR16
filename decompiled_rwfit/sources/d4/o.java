package d4;

import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayDeque f12278b;

    /* renamed from: a, reason: collision with root package name */
    public Object f12279a;

    static {
        char[] cArr = t4.l.f18523a;
        f12278b = new ArrayDeque(0);
    }

    public static o a(Object obj) {
        o oVar;
        ArrayDeque arrayDeque = f12278b;
        synchronized (arrayDeque) {
            oVar = (o) arrayDeque.poll();
        }
        if (oVar == null) {
            oVar = new o();
        }
        oVar.f12279a = obj;
        return oVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        oVar.getClass();
        return this.f12279a.equals(oVar.f12279a);
    }

    public final int hashCode() {
        return this.f12279a.hashCode();
    }
}
