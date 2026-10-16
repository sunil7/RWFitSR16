package z3;

import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class m implements x3.c {

    /* renamed from: b, reason: collision with root package name */
    public final Object f20269b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20270c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20271d;
    public final Class e;

    /* renamed from: f, reason: collision with root package name */
    public final Class f20272f;

    /* renamed from: g, reason: collision with root package name */
    public final x3.c f20273g;

    /* renamed from: h, reason: collision with root package name */
    public final t4.c f20274h;

    /* renamed from: i, reason: collision with root package name */
    public final x3.f f20275i;

    /* renamed from: j, reason: collision with root package name */
    public int f20276j;

    public m(Object obj, x3.c cVar, int i3, int i10, t4.c cVar2, Class cls, Class cls2, x3.f fVar) {
        t4.f.c(obj, "Argument must not be null");
        this.f20269b = obj;
        this.f20273g = cVar;
        this.f20270c = i3;
        this.f20271d = i10;
        t4.f.c(cVar2, "Argument must not be null");
        this.f20274h = cVar2;
        t4.f.c(cls, "Resource class must not be null");
        this.e = cls;
        t4.f.c(cls2, "Transcode class must not be null");
        this.f20272f = cls2;
        t4.f.c(fVar, "Argument must not be null");
        this.f20275i = fVar;
    }

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f20269b.equals(mVar.f20269b) && this.f20273g.equals(mVar.f20273g) && this.f20271d == mVar.f20271d && this.f20270c == mVar.f20270c && this.f20274h.equals(mVar.f20274h) && this.e.equals(mVar.e) && this.f20272f.equals(mVar.f20272f) && this.f20275i.equals(mVar.f20275i);
    }

    @Override // x3.c
    public final int hashCode() {
        if (this.f20276j == 0) {
            int hashCode = this.f20269b.hashCode();
            this.f20276j = hashCode;
            int hashCode2 = ((((this.f20273g.hashCode() + (hashCode * 31)) * 31) + this.f20270c) * 31) + this.f20271d;
            this.f20276j = hashCode2;
            int hashCode3 = this.f20274h.hashCode() + (hashCode2 * 31);
            this.f20276j = hashCode3;
            int hashCode4 = this.e.hashCode() + (hashCode3 * 31);
            this.f20276j = hashCode4;
            int hashCode5 = this.f20272f.hashCode() + (hashCode4 * 31);
            this.f20276j = hashCode5;
            this.f20276j = this.f20275i.f19776b.hashCode() + (hashCode5 * 31);
        }
        return this.f20276j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.f20269b + ", width=" + this.f20270c + ", height=" + this.f20271d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f20272f + ", signature=" + this.f20273g + ", hashCode=" + this.f20276j + ", transformations=" + this.f20274h + ", options=" + this.f20275i + '}';
    }
}
