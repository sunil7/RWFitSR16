package dd;

import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
public final class c extends e {

    /* renamed from: c, reason: collision with root package name */
    public final String f12328c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12329d;

    public c(sc.a aVar, String str, String str2) {
        super(aVar);
        this.f12328c = str2;
        this.f12329d = str;
    }

    @Override // a2.h
    public final String B() {
        if (((sc.a) this.f36a).f18220b != 84) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = new StringBuilder();
        D(sb2, 8);
        H(sb2, 48, 20);
        int c9 = com.google.zxing.oned.rss.expanded.decoders.b.c(68, 16, ((com.google.zxing.oned.rss.expanded.decoders.b) this.f37b).f11252a);
        if (c9 != 38400) {
            sb2.append('(');
            sb2.append(this.f12328c);
            sb2.append(')');
            int i3 = c9 % 32;
            int i10 = c9 / 32;
            int i11 = (i10 % 12) + 1;
            int i12 = i10 / 12;
            if (i12 / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(i12);
            if (i11 / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(i11);
            if (i3 / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(i3);
        }
        return sb2.toString();
    }

    @Override // dd.e
    public final void F(StringBuilder sb2, int i3) {
        sb2.append('(');
        sb2.append(this.f12329d);
        sb2.append(i3 / 100000);
        sb2.append(')');
    }

    @Override // dd.e
    public final int G(int i3) {
        return i3 % 100000;
    }
}
