package ud;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f19059a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19060b;

    public c(int i3, int i10) {
        this.f19059a = i3;
        this.f19060b = i10;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FileOffset{offset=");
        sb2.append(this.f19059a);
        sb2.append(", len=");
        return e.m(sb2, this.f19060b, '}');
    }
}
