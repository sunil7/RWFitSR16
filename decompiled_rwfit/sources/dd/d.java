package dd;

/* loaded from: classes.dex */
public abstract class d extends a2.h {
    public final void D(StringBuilder sb2, int i3) {
        sb2.append("(01)");
        int length = sb2.length();
        sb2.append('9');
        E(sb2, i3, length);
    }

    public final void E(StringBuilder sb2, int i3, int i10) {
        for (int i11 = 0; i11 < 4; i11++) {
            int c9 = com.google.zxing.oned.rss.expanded.decoders.b.c((i11 * 10) + i3, 10, ((com.google.zxing.oned.rss.expanded.decoders.b) this.f37b).f11252a);
            if (c9 / 100 == 0) {
                sb2.append('0');
            }
            if (c9 / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(c9);
        }
        int i12 = 0;
        for (int i13 = 0; i13 < 13; i13++) {
            int charAt = sb2.charAt(i13 + i10) - '0';
            if ((i13 & 1) == 0) {
                charAt *= 3;
            }
            i12 += charAt;
        }
        int i14 = 10 - (i12 % 10);
        sb2.append(i14 != 10 ? i14 : 0);
    }
}
