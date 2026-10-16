package sc;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f18225a;

    /* renamed from: b, reason: collision with root package name */
    public int f18226b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f18227c;

    public c(byte[] bArr) {
        this.f18227c = bArr;
    }

    public int a() {
        return ((this.f18227c.length - this.f18225a) * 8) - this.f18226b;
    }

    public int b(int i3) {
        if (i3 < 1 || i3 > 32 || i3 > a()) {
            throw new IllegalArgumentException(String.valueOf(i3));
        }
        int i10 = this.f18226b;
        int i11 = 0;
        byte[] bArr = this.f18227c;
        if (i10 > 0) {
            int i12 = 8 - i10;
            int min = Math.min(i3, i12);
            int i13 = i12 - min;
            int i14 = this.f18225a;
            int i15 = (((255 >> (8 - min)) << i13) & bArr[i14]) >> i13;
            i3 -= min;
            int i16 = this.f18226b + min;
            this.f18226b = i16;
            if (i16 == 8) {
                this.f18226b = 0;
                this.f18225a = i14 + 1;
            }
            i11 = i15;
        }
        if (i3 > 0) {
            while (i3 >= 8) {
                int i17 = i11 << 8;
                int i18 = this.f18225a;
                int i19 = i17 | (bArr[i18] & 255);
                this.f18225a = i18 + 1;
                i3 -= 8;
                i11 = i19;
            }
            if (i3 > 0) {
                int i20 = 8 - i3;
                int i21 = ((((255 >> i20) << i20) & bArr[this.f18225a]) >> i20) | (i11 << i3);
                this.f18226b += i3;
                return i21;
            }
        }
        return i11;
    }

    public c(byte[] bArr, int i3, int i10) {
        this.f18227c = bArr;
        this.f18225a = i3;
        this.f18226b = i10;
    }
}
