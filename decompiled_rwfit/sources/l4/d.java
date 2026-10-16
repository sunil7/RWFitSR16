package l4;

import g4.y;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import k4.h;
import x3.f;
import z3.s;

/* loaded from: classes.dex */
public final class d implements a {

    /* renamed from: b, reason: collision with root package name */
    public static final d f15767b = new d(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15768a;

    public /* synthetic */ d(int i3) {
        this.f15768a = i3;
    }

    @Override // l4.a
    public final s d(s sVar, f fVar) {
        byte[] bArr;
        switch (this.f15768a) {
            case 0:
                return sVar;
            default:
                ByteBuffer asReadOnlyBuffer = ((h) ((k4.c) sVar.get()).f15470a.f15469b).f15486a.f19503d.asReadOnlyBuffer();
                AtomicReference atomicReference = t4.b.f18505a;
                sc.c cVar = (asReadOnlyBuffer.isReadOnly() || !asReadOnlyBuffer.hasArray()) ? null : new sc.c(asReadOnlyBuffer.array(), asReadOnlyBuffer.arrayOffset(), asReadOnlyBuffer.limit());
                if (cVar != null && cVar.f18225a == 0) {
                    if (cVar.f18226b == cVar.f18227c.length) {
                        bArr = asReadOnlyBuffer.array();
                        return new y(bArr);
                    }
                }
                ByteBuffer asReadOnlyBuffer2 = asReadOnlyBuffer.asReadOnlyBuffer();
                byte[] bArr2 = new byte[asReadOnlyBuffer2.limit()];
                asReadOnlyBuffer2.position(0);
                asReadOnlyBuffer2.get(bArr2);
                bArr = bArr2;
                return new y(bArr);
        }
    }
}
