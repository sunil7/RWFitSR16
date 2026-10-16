package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Pair(A a3, B b3) {
        this.first = a3;
        this.second = b3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair copy$default(Pair pair, Object obj, Object obj2, int i3, Object obj3) {
        if ((i3 & 1) != 0) {
            obj = pair.first;
        }
        if ((i3 & 2) != 0) {
            obj2 = pair.second;
        }
        return pair.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final Pair<A, B> copy(A a3, B b3) {
        return new Pair<>(a3, b3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return e.a(this.first, pair.first) && e.a(this.second, pair.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a3 = this.first;
        int hashCode = (a3 == null ? 0 : a3.hashCode()) * 31;
        B b3 = this.second;
        return hashCode + (b3 != null ? b3.hashCode() : 0);
    }

    public String toString() {
        return "(" + this.first + ", " + this.second + ')';
    }
}
