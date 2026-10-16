package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class z extends u {
    public static final Logger e = Logger.getLogger(z.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f9850f = x1.e;

    /* renamed from: a, reason: collision with root package name */
    public x0 f9851a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f9852b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9853c;

    /* renamed from: d, reason: collision with root package name */
    public int f9854d;

    public z(byte[] bArr, int i3) {
        int length = bArr.length;
        if (((length - i3) | i3) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i3)));
        }
        this.f9852b = bArr;
        this.f9854d = 0;
        this.f9853c = i3;
    }

    public static int a(int i3) {
        return (352 - (Integer.numberOfLeadingZeros(i3) * 9)) >>> 6;
    }

    public static int b(long j4) {
        return (640 - (Long.numberOfLeadingZeros(j4) * 9)) >>> 6;
    }

    public static int r(String str) {
        int length;
        try {
            length = y1.c(str);
        } catch (zzhd unused) {
            length = str.getBytes(s0.f9827a).length;
        }
        return a(length) + length;
    }

    public final void c(byte b3) {
        try {
            byte[] bArr = this.f9852b;
            int i3 = this.f9854d;
            this.f9854d = i3 + 1;
            bArr[i3] = b3;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f9854d), Integer.valueOf(this.f9853c), 1), e10);
        }
    }

    public final void d(int i3, int i10, byte[] bArr) {
        try {
            System.arraycopy(bArr, i3, this.f9852b, this.f9854d, i10);
            this.f9854d += i10;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f9854d), Integer.valueOf(this.f9853c), Integer.valueOf(i10)), e10);
        }
    }

    public final void e(int i3, zzdf zzdfVar) {
        o((i3 << 3) | 2);
        o(zzdfVar.zzd());
        zzdfVar.zzm(this);
    }

    public final void f(int i3, int i10) {
        o((i3 << 3) | 5);
        g(i10);
    }

    public final void g(int i3) {
        try {
            byte[] bArr = this.f9852b;
            int i10 = this.f9854d;
            int i11 = i10 + 1;
            this.f9854d = i11;
            bArr[i10] = (byte) (i3 & 255);
            int i12 = i10 + 2;
            this.f9854d = i12;
            bArr[i11] = (byte) ((i3 >> 8) & 255);
            int i13 = i10 + 3;
            this.f9854d = i13;
            bArr[i12] = (byte) ((i3 >> 16) & 255);
            this.f9854d = i10 + 4;
            bArr[i13] = (byte) ((i3 >> 24) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f9854d), Integer.valueOf(this.f9853c), 1), e10);
        }
    }

    public final void h(int i3, long j4) {
        o((i3 << 3) | 1);
        i(j4);
    }

    public final void i(long j4) {
        try {
            byte[] bArr = this.f9852b;
            int i3 = this.f9854d;
            int i10 = i3 + 1;
            this.f9854d = i10;
            bArr[i3] = (byte) (((int) j4) & 255);
            int i11 = i3 + 2;
            this.f9854d = i11;
            bArr[i10] = (byte) (((int) (j4 >> 8)) & 255);
            int i12 = i3 + 3;
            this.f9854d = i12;
            bArr[i11] = (byte) (((int) (j4 >> 16)) & 255);
            int i13 = i3 + 4;
            this.f9854d = i13;
            bArr[i12] = (byte) (((int) (j4 >> 24)) & 255);
            int i14 = i3 + 5;
            this.f9854d = i14;
            bArr[i13] = (byte) (((int) (j4 >> 32)) & 255);
            int i15 = i3 + 6;
            this.f9854d = i15;
            bArr[i14] = (byte) (((int) (j4 >> 40)) & 255);
            int i16 = i3 + 7;
            this.f9854d = i16;
            bArr[i15] = (byte) (((int) (j4 >> 48)) & 255);
            this.f9854d = i3 + 8;
            bArr[i16] = (byte) (((int) (j4 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f9854d), Integer.valueOf(this.f9853c), 1), e10);
        }
    }

    public final void j(int i3, int i10) {
        o(i3 << 3);
        k(i10);
    }

    public final void k(int i3) {
        if (i3 >= 0) {
            o(i3);
        } else {
            q(i3);
        }
    }

    public final void l(int i3, String str) {
        o((i3 << 3) | 2);
        int i10 = this.f9854d;
        try {
            int a3 = a(str.length() * 3);
            int a10 = a(str.length());
            byte[] bArr = this.f9852b;
            int i11 = this.f9853c;
            if (a10 != a3) {
                o(y1.c(str));
                int i12 = this.f9854d;
                this.f9854d = y1.b(str, bArr, i12, i11 - i12);
            } else {
                int i13 = i10 + a10;
                this.f9854d = i13;
                int b3 = y1.b(str, bArr, i13, i11 - i13);
                this.f9854d = i10;
                o((b3 - i10) - a10);
                this.f9854d = b3;
            }
        } catch (zzhd e10) {
            this.f9854d = i10;
            e.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e10);
            byte[] bytes = str.getBytes(s0.f9827a);
            try {
                int length = bytes.length;
                o(length);
                d(0, length, bytes);
            } catch (IndexOutOfBoundsException e11) {
                throw new zzdl(e11);
            }
        } catch (IndexOutOfBoundsException e12) {
            throw new zzdl(e12);
        }
    }

    public final void m(int i3, int i10) {
        o((i3 << 3) | i10);
    }

    public final void n(int i3, int i10) {
        o(i3 << 3);
        o(i10);
    }

    public final void o(int i3) {
        while (true) {
            int i10 = i3 & (-128);
            byte[] bArr = this.f9852b;
            if (i10 == 0) {
                int i11 = this.f9854d;
                this.f9854d = i11 + 1;
                bArr[i11] = (byte) i3;
                return;
            } else {
                try {
                    int i12 = this.f9854d;
                    this.f9854d = i12 + 1;
                    bArr[i12] = (byte) ((i3 | 128) & 255);
                    i3 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f9854d), Integer.valueOf(this.f9853c), 1), e10);
                }
            }
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f9854d), Integer.valueOf(this.f9853c), 1), e10);
        }
    }

    public final void p(int i3, long j4) {
        o(i3 << 3);
        q(j4);
    }

    public final void q(long j4) {
        byte[] bArr = this.f9852b;
        boolean z5 = f9850f;
        int i3 = this.f9853c;
        if (!z5 || i3 - this.f9854d < 10) {
            while ((j4 & (-128)) != 0) {
                try {
                    int i10 = this.f9854d;
                    this.f9854d = i10 + 1;
                    bArr[i10] = (byte) ((((int) j4) | 128) & 255);
                    j4 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f9854d), Integer.valueOf(i3), 1), e10);
                }
            }
            int i11 = this.f9854d;
            this.f9854d = i11 + 1;
            bArr[i11] = (byte) j4;
            return;
        }
        while (true) {
            int i12 = (int) j4;
            if ((j4 & (-128)) == 0) {
                int i13 = this.f9854d;
                this.f9854d = i13 + 1;
                x1.f9843c.d(bArr, x1.f9845f + i13, (byte) i12);
                return;
            }
            int i14 = this.f9854d;
            this.f9854d = i14 + 1;
            x1.f9843c.d(bArr, x1.f9845f + i14, (byte) ((i12 | 128) & 255));
            j4 >>>= 7;
        }
    }
}
