package o2;

/* loaded from: classes.dex */
public final class j extends l {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && j.class == obj.getClass();
    }

    public final int hashCode() {
        return j.class.getName().hashCode();
    }

    public final String toString() {
        return "Retry";
    }
}
