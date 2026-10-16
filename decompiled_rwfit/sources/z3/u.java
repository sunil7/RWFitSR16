package z3;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class u implements x3.c {

    /* renamed from: j, reason: collision with root package name */
    public static final n.m f20301j = new n.m(50);

    /* renamed from: b, reason: collision with root package name */
    public final a4.g f20302b;

    /* renamed from: c, reason: collision with root package name */
    public final x3.c f20303c;

    /* renamed from: d, reason: collision with root package name */
    public final x3.c f20304d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f20305f;

    /* renamed from: g, reason: collision with root package name */
    public final Class f20306g;

    /* renamed from: h, reason: collision with root package name */
    public final x3.f f20307h;

    /* renamed from: i, reason: collision with root package name */
    public final x3.i f20308i;

    public u(a4.g gVar, x3.c cVar, x3.c cVar2, int i3, int i10, x3.i iVar, Class cls, x3.f fVar) {
        this.f20302b = gVar;
        this.f20303c = cVar;
        this.f20304d = cVar2;
        this.e = i3;
        this.f20305f = i10;
        this.f20308i = iVar;
        this.f20306g = cls;
        this.f20307h = fVar;
    }

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        Object e;
        a4.g gVar = this.f20302b;
        synchronized (gVar) {
            a4.f fVar = gVar.f89b;
            a4.i iVar = (a4.i) ((ArrayDeque) fVar.f78a).poll();
            if (iVar == null) {
                iVar = fVar.j();
            }
            a4.e eVar = (a4.e) iVar;
            eVar.f85b = 8;
            eVar.f86c = byte[].class;
            e = gVar.e(eVar, byte[].class);
        }
        byte[] bArr = (byte[]) e;
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f20305f).array();
        this.f20304d.b(messageDigest);
        this.f20303c.b(messageDigest);
        messageDigest.update(bArr);
        x3.i iVar2 = this.f20308i;
        if (iVar2 != null) {
            iVar2.b(messageDigest);
        }
        this.f20307h.b(messageDigest);
        n.m mVar = f20301j;
        Class cls = this.f20306g;
        byte[] bArr2 = (byte[]) mVar.a(cls);
        if (bArr2 == null) {
            bArr2 = cls.getName().getBytes(x3.c.f19771a);
            mVar.f(cls, bArr2);
        }
        messageDigest.update(bArr2);
        this.f20302b.g(bArr);
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f20305f == uVar.f20305f && this.e == uVar.e && t4.l.a(this.f20308i, uVar.f20308i) && this.f20306g.equals(uVar.f20306g) && this.f20303c.equals(uVar.f20303c) && this.f20304d.equals(uVar.f20304d) && this.f20307h.equals(uVar.f20307h)) {
                return true;
            }
        }
        return false;
    }

    @Override // x3.c
    public final int hashCode() {
        int hashCode = ((((this.f20304d.hashCode() + (this.f20303c.hashCode() * 31)) * 31) + this.e) * 31) + this.f20305f;
        x3.i iVar = this.f20308i;
        if (iVar != null) {
            hashCode = (hashCode * 31) + iVar.hashCode();
        }
        return this.f20307h.f19776b.hashCode() + ((this.f20306g.hashCode() + (hashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f20303c + ", signature=" + this.f20304d + ", width=" + this.e + ", height=" + this.f20305f + ", decodedResourceClass=" + this.f20306g + ", transformation='" + this.f20308i + "', options=" + this.f20307h + '}';
    }
}
