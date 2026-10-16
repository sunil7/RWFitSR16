package s4;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import t4.l;

/* loaded from: classes.dex */
public final class a implements x3.c {

    /* renamed from: b, reason: collision with root package name */
    public final int f18205b;

    /* renamed from: c, reason: collision with root package name */
    public final x3.c f18206c;

    public a(int i3, x3.c cVar) {
        this.f18205b = i3;
        this.f18206c = cVar;
    }

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        this.f18206c.b(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f18205b).array());
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f18205b == aVar.f18205b && this.f18206c.equals(aVar.f18206c)) {
                return true;
            }
        }
        return false;
    }

    @Override // x3.c
    public final int hashCode() {
        return l.g(this.f18205b, this.f18206c);
    }
}
