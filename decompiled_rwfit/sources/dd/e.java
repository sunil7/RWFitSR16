package dd;

/* loaded from: classes.dex */
public abstract class e extends d {
    public abstract void F(StringBuilder sb2, int i3);

    public abstract int G(int i3);

    public final void H(StringBuilder sb2, int i3, int i10) {
        int c9 = com.google.zxing.oned.rss.expanded.decoders.b.c(i3, i10, ((com.google.zxing.oned.rss.expanded.decoders.b) this.f37b).f11252a);
        F(sb2, c9);
        int G = G(c9);
        int i11 = 100000;
        for (int i12 = 0; i12 < 5; i12++) {
            if (G / i11 == 0) {
                sb2.append('0');
            }
            i11 /= 10;
        }
        sb2.append(G);
    }
}
