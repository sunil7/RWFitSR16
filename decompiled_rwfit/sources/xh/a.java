package xh;

import kotlin.jvm.internal.e;
import wh.j;
import wh.y;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f19827a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(kotlin.text.a.f15656a);
        e.e(bytes, "(this as java.lang.String).getBytes(charset)");
        f19827a = bytes;
    }

    public static final boolean a(y yVar, int i3, byte[] bArr, int i10) {
        int i11 = yVar.f19683c;
        byte[] bArr2 = yVar.f19681a;
        for (int i12 = 1; i12 < i10; i12++) {
            if (i3 == i11) {
                yVar = yVar.f19685f;
                e.c(yVar);
                i3 = yVar.f19682b;
                i11 = yVar.f19683c;
                bArr2 = yVar.f19681a;
            }
            if (bArr2[i3] != bArr[i12]) {
                return false;
            }
            i3++;
        }
        return true;
    }

    public static final String b(j readUtf8Line, long j4) {
        e.f(readUtf8Line, "$this$readUtf8Line");
        if (j4 > 0) {
            long j10 = j4 - 1;
            if (readUtf8Line.g(j10) == ((byte) 13)) {
                String y4 = readUtf8Line.y(j10, kotlin.text.a.f15656a);
                readUtf8Line.a(2L);
                return y4;
            }
        }
        String y10 = readUtf8Line.y(j4, kotlin.text.a.f15656a);
        readUtf8Line.a(1L);
        return y10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
    
        if (r19 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
    
        return -2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int c(wh.j r17, wh.u r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 185
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xh.a.c(wh.j, wh.u, boolean):int");
    }
}
