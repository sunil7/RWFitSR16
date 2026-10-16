package androidx.emoji2.text;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f2047d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final int f2048a;

    /* renamed from: b, reason: collision with root package name */
    public final v2.h f2049b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f2050c = 0;

    public n(v2.h hVar, int i3) {
        this.f2049b = hVar;
        this.f2048a = i3;
    }

    public final int a(int i3) {
        s1.a b3 = b();
        int a3 = b3.a(16);
        if (a3 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) b3.f15697d;
        int i10 = a3 + b3.f15694a;
        return byteBuffer.getInt((i3 * 4) + byteBuffer.getInt(i10) + i10 + 4);
    }

    public final s1.a b() {
        ThreadLocal threadLocal = f2047d;
        s1.a aVar = (s1.a) threadLocal.get();
        if (aVar == null) {
            aVar = new s1.a();
            threadLocal.set(aVar);
        }
        s1.b bVar = (s1.b) this.f2049b.f19146a;
        int a3 = bVar.a(6);
        if (a3 != 0) {
            int i3 = a3 + bVar.f15694a;
            int i10 = (this.f2048a * 4) + ((ByteBuffer) bVar.f15697d).getInt(i3) + i3 + 4;
            int i11 = ((ByteBuffer) bVar.f15697d).getInt(i10) + i10;
            ByteBuffer byteBuffer = (ByteBuffer) bVar.f15697d;
            aVar.f15697d = byteBuffer;
            if (byteBuffer != null) {
                aVar.f15694a = i11;
                int i12 = i11 - byteBuffer.getInt(i11);
                aVar.f15695b = i12;
                aVar.f15696c = ((ByteBuffer) aVar.f15697d).getShort(i12);
                return aVar;
            }
            aVar.f15694a = 0;
            aVar.f15695b = 0;
            aVar.f15696c = 0;
        }
        return aVar;
    }

    public final String toString() {
        int i3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        s1.a b3 = b();
        int a3 = b3.a(4);
        sb2.append(Integer.toHexString(a3 != 0 ? ((ByteBuffer) b3.f15697d).getInt(a3 + b3.f15694a) : 0));
        sb2.append(", codepoints:");
        s1.a b10 = b();
        int a10 = b10.a(16);
        if (a10 != 0) {
            int i10 = a10 + b10.f15694a;
            i3 = ((ByteBuffer) b10.f15697d).getInt(((ByteBuffer) b10.f15697d).getInt(i10) + i10);
        } else {
            i3 = 0;
        }
        for (int i11 = 0; i11 < i3; i11++) {
            sb2.append(Integer.toHexString(a(i11)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
