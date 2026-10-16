package b8;

import android.content.Context;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3167a;

    /* renamed from: b, reason: collision with root package name */
    public final i8.a f3168b;

    /* renamed from: c, reason: collision with root package name */
    public final i8.a f3169c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3170d;

    public b(Context context, i8.a aVar, i8.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f3167a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f3168b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f3169c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f3170d = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f3167a.equals(((b) cVar).f3167a)) {
                b bVar = (b) cVar;
                if (this.f3168b.equals(bVar.f3168b) && this.f3169c.equals(bVar.f3169c) && this.f3170d.equals(bVar.f3170d)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f3167a.hashCode() ^ 1000003) * 1000003) ^ this.f3168b.hashCode()) * 1000003) ^ this.f3169c.hashCode()) * 1000003) ^ this.f3170d.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("CreationContext{applicationContext=");
        sb2.append(this.f3167a);
        sb2.append(", wallClock=");
        sb2.append(this.f3168b);
        sb2.append(", monotonicClock=");
        sb2.append(this.f3169c);
        sb2.append(", backendName=");
        return r5.a.f(sb2, this.f3170d, "}");
    }
}
