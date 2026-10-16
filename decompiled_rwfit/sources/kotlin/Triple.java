package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public final class Triple<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public Triple(A a3, B b3, C c9) {
        this.first = a3;
        this.second = b3;
        this.third = c9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Triple copy$default(Triple triple, Object obj, Object obj2, Object obj3, int i3, Object obj4) {
        if ((i3 & 1) != 0) {
            obj = triple.first;
        }
        if ((i3 & 2) != 0) {
            obj2 = triple.second;
        }
        if ((i3 & 4) != 0) {
            obj3 = triple.third;
        }
        return triple.copy(obj, obj2, obj3);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final Triple<A, B, C> copy(A a3, B b3, C c9) {
        return new Triple<>(a3, b3, c9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return e.a(this.first, triple.first) && e.a(this.second, triple.second) && e.a(this.third, triple.third);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a3 = this.first;
        int hashCode = (a3 == null ? 0 : a3.hashCode()) * 31;
        B b3 = this.second;
        int hashCode2 = (hashCode + (b3 == null ? 0 : b3.hashCode())) * 31;
        C c9 = this.third;
        return hashCode2 + (c9 != null ? c9.hashCode() : 0);
    }

    public String toString() {
        return "(" + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
