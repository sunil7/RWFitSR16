package androidx.camera.core.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1401a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f1402b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f1403c;

    public g1(boolean z5, HashSet hashSet, HashSet hashSet2) {
        this.f1401a = z5;
        this.f1402b = hashSet == null ? Collections.EMPTY_SET : new HashSet(hashSet);
        this.f1403c = hashSet2 == null ? Collections.EMPTY_SET : new HashSet(hashSet2);
    }

    public final boolean a(Class cls, boolean z5) {
        if (this.f1402b.contains(cls)) {
            return true;
        }
        return !this.f1403c.contains(cls) && this.f1401a && z5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g1)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        g1 g1Var = (g1) obj;
        return this.f1401a == g1Var.f1401a && Objects.equals(this.f1402b, g1Var.f1402b) && Objects.equals(this.f1403c, g1Var.f1403c);
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f1401a), this.f1402b, this.f1403c);
    }

    public final String toString() {
        return "QuirkSettings{enabledWhenDeviceHasQuirk=" + this.f1401a + ", forceEnabledQuirks=" + this.f1402b + ", forceDisabledQuirks=" + this.f1403c + '}';
    }
}
