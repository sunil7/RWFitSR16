package j2;

import android.view.ViewGroup;
import android.view.WindowId;

/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public final WindowId f15305a;

    public u0(ViewGroup viewGroup) {
        this.f15305a = viewGroup.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof u0) && ((u0) obj).f15305a.equals(this.f15305a);
    }

    public final int hashCode() {
        return this.f15305a.hashCode();
    }
}
