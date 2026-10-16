package wh;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.d6;
import com.google.android.gms.internal.mlkit_vision_common.e6;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import okhttp3.internal.connection.RealConnection;
import okio.ByteString;
import okio.SegmentedByteString;

/* loaded from: classes2.dex */
public final class j implements l, k, Cloneable, ByteChannel, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public y f19653a;

    /* renamed from: b, reason: collision with root package name */
    public long f19654b;

    public final String A() {
        return y(this.f19654b, kotlin.text.a.f15656a);
    }

    @Override // wh.l
    public final String B() {
        return M(Format.OFFSET_SAMPLE_RELATIVE);
    }

    @Override // wh.l
    public final byte[] C() {
        return l(this.f19654b);
    }

    @Override // wh.l
    public final boolean D() {
        return this.f19654b == 0;
    }

    @Override // wh.k
    public final /* bridge */ /* synthetic */ k E(int i3) {
        Z(i3);
        return this;
    }

    public final int F() {
        int i3;
        int i10;
        int i11;
        if (this.f19654b == 0) {
            throw new EOFException();
        }
        byte g10 = g(0L);
        if ((g10 & 128) == 0) {
            i3 = g10 & Byte.MAX_VALUE;
            i11 = 0;
            i10 = 1;
        } else if ((g10 & 224) == 192) {
            i3 = g10 & 31;
            i10 = 2;
            i11 = 128;
        } else if ((g10 & 240) == 224) {
            i3 = g10 & 15;
            i10 = 3;
            i11 = 2048;
        } else {
            if ((g10 & 248) != 240) {
                a(1L);
                return 65533;
            }
            i3 = g10 & 7;
            i10 = 4;
            i11 = WXMediaMessage.THUMB_LENGTH_LIMIT;
        }
        long j4 = i10;
        if (this.f19654b < j4) {
            StringBuilder q5 = android.support.v4.media.session.e.q(i10, "size < ", ": ");
            q5.append(this.f19654b);
            q5.append(" (to read code point prefixed 0x");
            q5.append(d6.c(g10));
            q5.append(')');
            throw new EOFException(q5.toString());
        }
        for (int i12 = 1; i12 < i10; i12++) {
            long j10 = i12;
            byte g11 = g(j10);
            if ((g11 & 192) != 128) {
                a(j10);
                return 65533;
            }
            i3 = (i3 << 6) | (g11 & 63);
        }
        a(j4);
        if (i3 > 1114111) {
            return 65533;
        }
        if ((55296 <= i3 && 57343 >= i3) || i3 < i11) {
            return 65533;
        }
        return i3;
    }

    @Override // wh.k
    public final /* bridge */ /* synthetic */ k G(byte[] bArr) {
        X(bArr);
        return this;
    }

    @Override // wh.k
    public final /* bridge */ /* synthetic */ k H(ByteString byteString) {
        W(byteString);
        return this;
    }

    public final ByteString I(int i3) {
        if (i3 == 0) {
            return ByteString.EMPTY;
        }
        d6.b(this.f19654b, 0L, i3);
        y yVar = this.f19653a;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i3) {
            kotlin.jvm.internal.e.c(yVar);
            int i13 = yVar.f19683c;
            int i14 = yVar.f19682b;
            if (i13 == i14) {
                throw new AssertionError("s.limit == s.pos");
            }
            i11 += i13 - i14;
            i12++;
            yVar = yVar.f19685f;
        }
        byte[][] bArr = new byte[i12][];
        int[] iArr = new int[i12 * 2];
        y yVar2 = this.f19653a;
        int i15 = 0;
        while (i10 < i3) {
            kotlin.jvm.internal.e.c(yVar2);
            bArr[i15] = yVar2.f19681a;
            i10 += yVar2.f19683c - yVar2.f19682b;
            iArr[i15] = Math.min(i10, i3);
            iArr[i15 + i12] = yVar2.f19682b;
            yVar2.f19684d = true;
            i15++;
            yVar2 = yVar2.f19685f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // wh.k
    public final k J() {
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0099 A[EDGE_INSN: B:46:0x0099->B:40:0x0099 BREAK  A[LOOP:0: B:4:0x000f->B:45:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    @Override // wh.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long K() {
        /*
            r14 = this;
            long r0 = r14.f19654b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La4
            r0 = 0
            r4 = -7
            r1 = r0
            r5 = r4
            r3 = r2
            r2 = r1
        Lf:
            wh.y r7 = r14.f19653a
            kotlin.jvm.internal.e.c(r7)
            int r8 = r7.f19682b
            int r9 = r7.f19683c
        L18:
            if (r8 >= r9) goto L85
            byte[] r10 = r7.f19681a
            r10 = r10[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L60
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L60
            int r11 = r11 - r10
            r12 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r12 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r12 < 0) goto L40
            if (r12 != 0) goto L3a
            long r12 = (long) r11
            int r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r12 >= 0) goto L3a
            goto L40
        L3a:
            r12 = 10
            long r3 = r3 * r12
            long r10 = (long) r11
            long r3 = r3 + r10
            goto L6c
        L40:
            wh.j r0 = new wh.j
            r0.<init>()
            r0.a0(r3)
            r0.Z(r10)
            if (r1 != 0) goto L50
            r0.readByte()
        L50:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.A()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L60:
            r11 = 45
            byte r11 = (byte) r11
            r12 = 1
            if (r10 != r11) goto L71
            if (r0 != 0) goto L71
            r10 = 1
            long r5 = r5 - r10
            r1 = r12
        L6c:
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L71:
            if (r0 == 0) goto L75
            r2 = r12
            goto L85
        L75:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = com.google.android.gms.internal.mlkit_vision_common.d6.c(r10)
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L85:
            if (r8 != r9) goto L91
            wh.y r8 = r7.a()
            r14.f19653a = r8
            wh.z.a(r7)
            goto L93
        L91:
            r7.f19682b = r8
        L93:
            if (r2 != 0) goto L99
            wh.y r7 = r14.f19653a
            if (r7 != 0) goto Lf
        L99:
            long r5 = r14.f19654b
            long r7 = (long) r0
            long r5 = r5 - r7
            r14.f19654b = r5
            if (r1 == 0) goto La2
            return r3
        La2:
            long r0 = -r3
            return r0
        La4:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: wh.j.K():long");
    }

    @Override // wh.l
    public final int L(u options) {
        kotlin.jvm.internal.e.f(options, "options");
        int c9 = xh.a.c(this, options, false);
        if (c9 == -1) {
            return -1;
        }
        a(options.f19668a[c9].size());
        return c9;
    }

    @Override // wh.l
    public final String M(long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException(l0.l(j4, "limit < 0: ").toString());
        }
        long j10 = Format.OFFSET_SAMPLE_RELATIVE;
        if (j4 != Format.OFFSET_SAMPLE_RELATIVE) {
            j10 = j4 + 1;
        }
        long j11 = j10;
        byte b3 = (byte) 10;
        long h4 = h(b3, 0L, j11);
        if (h4 != -1) {
            return xh.a.b(this, h4);
        }
        if (j11 < this.f19654b && g(j11 - 1) == ((byte) 13) && g(j11) == b3) {
            return xh.a.b(this, j11);
        }
        j jVar = new j();
        f(0L, jVar, Math.min(32, this.f19654b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f19654b, j4) + " content=" + jVar.s(jVar.f19654b).hex() + (char) 8230);
    }

    @Override // wh.k
    public final /* bridge */ /* synthetic */ k N(int i3, int i10, byte[] bArr) {
        Y(bArr, i3, i10);
        return this;
    }

    public final y O(int i3) {
        if (i3 < 1 || i3 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        y yVar = this.f19653a;
        if (yVar == null) {
            y b3 = z.b();
            this.f19653a = b3;
            b3.f19686g = b3;
            b3.f19685f = b3;
            return b3;
        }
        y yVar2 = yVar.f19686g;
        kotlin.jvm.internal.e.c(yVar2);
        if (yVar2.f19683c + i3 <= 8192 && yVar2.e) {
            return yVar2;
        }
        y b10 = z.b();
        yVar2.b(b10);
        return b10;
    }

    @Override // wh.l
    public final void P(long j4) {
        if (this.f19654b < j4) {
            throw new EOFException();
        }
    }

    @Override // wh.k
    public final /* bridge */ /* synthetic */ k Q(String str) {
        h0(str);
        return this;
    }

    @Override // wh.k
    public final /* bridge */ /* synthetic */ k R(long j4) {
        a0(j4);
        return this;
    }

    @Override // wh.l
    public final boolean S(long j4, ByteString bytes) {
        kotlin.jvm.internal.e.f(bytes, "bytes");
        int size = bytes.size();
        if (j4 >= 0 && size >= 0 && this.f19654b - j4 >= size && bytes.size() >= size) {
            for (int i3 = 0; i3 < size; i3++) {
                if (g(i3 + j4) == bytes.getByte(i3)) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094 A[EDGE_INSN: B:39:0x0094->B:36:0x0094 BREAK  A[LOOP:0: B:4:0x000b->B:38:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008c  */
    @Override // wh.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long T() {
        /*
            r13 = this;
            long r0 = r13.f19654b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L9b
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            wh.y r6 = r13.f19653a
            kotlin.jvm.internal.e.c(r6)
            int r7 = r6.f19682b
            int r8 = r6.f19683c
        L14:
            if (r7 >= r8) goto L80
            byte[] r9 = r6.f19681a
            r9 = r9[r7]
            r10 = 48
            byte r10 = (byte) r10
            if (r9 < r10) goto L27
            r11 = 57
            byte r11 = (byte) r11
            if (r9 > r11) goto L27
            int r10 = r9 - r10
            goto L41
        L27:
            r10 = 97
            byte r10 = (byte) r10
            if (r9 < r10) goto L36
            r11 = 102(0x66, float:1.43E-43)
            byte r11 = (byte) r11
            if (r9 > r11) goto L36
        L31:
            int r10 = r9 - r10
            int r10 = r10 + 10
            goto L41
        L36:
            r10 = 65
            byte r10 = (byte) r10
            if (r9 < r10) goto L6c
            r11 = 70
            byte r11 = (byte) r11
            if (r9 > r11) goto L6c
            goto L31
        L41:
            r11 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r11 = r11 & r4
            int r11 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r11 != 0) goto L51
            r9 = 4
            long r4 = r4 << r9
            long r9 = (long) r10
            long r4 = r4 | r9
            int r7 = r7 + 1
            int r0 = r0 + 1
            goto L14
        L51:
            wh.j r0 = new wh.j
            r0.<init>()
            r0.b0(r4)
            r0.Z(r9)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.A()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L6c:
            if (r0 == 0) goto L70
            r1 = 1
            goto L80
        L70:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = com.google.android.gms.internal.mlkit_vision_common.d6.c(r9)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L80:
            if (r7 != r8) goto L8c
            wh.y r7 = r6.a()
            r13.f19653a = r7
            wh.z.a(r6)
            goto L8e
        L8c:
            r6.f19682b = r7
        L8e:
            if (r1 != 0) goto L94
            wh.y r6 = r13.f19653a
            if (r6 != 0) goto Lb
        L94:
            long r1 = r13.f19654b
            long r6 = (long) r0
            long r1 = r1 - r6
            r13.f19654b = r1
            return r4
        L9b:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: wh.j.T():long");
    }

    @Override // wh.l
    public final String U(Charset charset) {
        kotlin.jvm.internal.e.f(charset, "charset");
        return y(this.f19654b, charset);
    }

    @Override // wh.l
    public final InputStream V() {
        return new h(this, 0);
    }

    public final void W(ByteString byteString) {
        kotlin.jvm.internal.e.f(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
    }

    public final void X(byte[] source) {
        kotlin.jvm.internal.e.f(source, "source");
        Y(source, 0, source.length);
    }

    public final void Y(byte[] source, int i3, int i10) {
        kotlin.jvm.internal.e.f(source, "source");
        long j4 = i10;
        d6.b(source.length, i3, j4);
        int i11 = i10 + i3;
        while (i3 < i11) {
            y O = O(1);
            int min = Math.min(i11 - i3, 8192 - O.f19683c);
            int i12 = i3 + min;
            kotlin.collections.g.c(source, O.f19683c, i3, O.f19681a, i12);
            O.f19683c += min;
            i3 = i12;
        }
        this.f19654b += j4;
    }

    public final void Z(int i3) {
        y O = O(1);
        int i10 = O.f19683c;
        O.f19683c = i10 + 1;
        O.f19681a[i10] = (byte) i3;
        this.f19654b++;
    }

    @Override // wh.l
    public final void a(long j4) {
        while (j4 > 0) {
            y yVar = this.f19653a;
            if (yVar == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j4, yVar.f19683c - yVar.f19682b);
            long j10 = min;
            this.f19654b -= j10;
            j4 -= j10;
            int i3 = yVar.f19682b + min;
            yVar.f19682b = i3;
            if (i3 == yVar.f19683c) {
                this.f19653a = yVar.a();
                z.a(yVar);
            }
        }
    }

    public final void a0(long j4) {
        boolean z5;
        byte[] bArr;
        if (j4 == 0) {
            Z(48);
            return;
        }
        int i3 = 1;
        if (j4 < 0) {
            j4 = -j4;
            if (j4 < 0) {
                h0("-9223372036854775808");
                return;
            }
            z5 = true;
        } else {
            z5 = false;
        }
        if (j4 >= 100000000) {
            i3 = j4 < 1000000000000L ? j4 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j4 < 1000000000 ? 9 : 10 : j4 < 100000000000L ? 11 : 12 : j4 < 1000000000000000L ? j4 < 10000000000000L ? 13 : j4 < 100000000000000L ? 14 : 15 : j4 < 100000000000000000L ? j4 < 10000000000000000L ? 16 : 17 : j4 < 1000000000000000000L ? 18 : 19;
        } else if (j4 >= 10000) {
            i3 = j4 < 1000000 ? j4 < 100000 ? 5 : 6 : j4 < 10000000 ? 7 : 8;
        } else if (j4 >= 100) {
            i3 = j4 < 1000 ? 3 : 4;
        } else if (j4 >= 10) {
            i3 = 2;
        }
        if (z5) {
            i3++;
        }
        y O = O(i3);
        int i10 = O.f19683c + i3;
        while (true) {
            bArr = O.f19681a;
            if (j4 == 0) {
                break;
            }
            long j10 = 10;
            i10--;
            bArr[i10] = xh.a.f19827a[(int) (j4 % j10)];
            j4 /= j10;
        }
        if (z5) {
            bArr[i10 - 1] = (byte) 45;
        }
        O.f19683c += i3;
        this.f19654b += i3;
    }

    public final void b() {
        a(this.f19654b);
    }

    public final void b0(long j4) {
        if (j4 == 0) {
            Z(48);
            return;
        }
        long j10 = (j4 >>> 1) | j4;
        long j11 = j10 | (j10 >>> 2);
        long j12 = j11 | (j11 >>> 4);
        long j13 = j12 | (j12 >>> 8);
        long j14 = j13 | (j13 >>> 16);
        long j15 = j14 | (j14 >>> 32);
        long j16 = j15 - ((j15 >>> 1) & 6148914691236517205L);
        long j17 = ((j16 >>> 2) & 3689348814741910323L) + (j16 & 3689348814741910323L);
        long j18 = ((j17 >>> 4) + j17) & 1085102592571150095L;
        long j19 = j18 + (j18 >>> 8);
        long j20 = j19 + (j19 >>> 16);
        int i3 = (int) ((((j20 & 63) + ((j20 >>> 32) & 63)) + 3) / 4);
        y O = O(i3);
        int i10 = O.f19683c;
        for (int i11 = (i10 + i3) - 1; i11 >= i10; i11--) {
            O.f19681a[i11] = xh.a.f19827a[(int) (15 & j4)];
            j4 >>>= 4;
        }
        O.f19683c += i3;
        this.f19654b += i3;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final j clone() {
        j jVar = new j();
        if (this.f19654b == 0) {
            return jVar;
        }
        y yVar = this.f19653a;
        kotlin.jvm.internal.e.c(yVar);
        y c9 = yVar.c();
        jVar.f19653a = c9;
        c9.f19686g = c9;
        c9.f19685f = c9;
        for (y yVar2 = yVar.f19685f; yVar2 != yVar; yVar2 = yVar2.f19685f) {
            y yVar3 = c9.f19686g;
            kotlin.jvm.internal.e.c(yVar3);
            kotlin.jvm.internal.e.c(yVar2);
            yVar3.b(yVar2.c());
        }
        jVar.f19654b = this.f19654b;
        return jVar;
    }

    public final void c0(int i3) {
        y O = O(4);
        int i10 = O.f19683c;
        byte[] bArr = O.f19681a;
        bArr[i10] = (byte) ((i3 >>> 24) & 255);
        bArr[i10 + 1] = (byte) ((i3 >>> 16) & 255);
        bArr[i10 + 2] = (byte) ((i3 >>> 8) & 255);
        bArr[i10 + 3] = (byte) (i3 & 255);
        O.f19683c = i10 + 4;
        this.f19654b += 4;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, wh.a0
    public final void close() {
    }

    @Override // wh.l
    public final long d(j jVar) {
        long j4 = this.f19654b;
        if (j4 > 0) {
            jVar.write(this, j4);
        }
        return j4;
    }

    public final void d0(long j4) {
        y O = O(8);
        int i3 = O.f19683c;
        byte[] bArr = O.f19681a;
        bArr[i3] = (byte) ((j4 >>> 56) & 255);
        bArr[i3 + 1] = (byte) ((j4 >>> 48) & 255);
        bArr[i3 + 2] = (byte) ((j4 >>> 40) & 255);
        bArr[i3 + 3] = (byte) ((j4 >>> 32) & 255);
        bArr[i3 + 4] = (byte) ((j4 >>> 24) & 255);
        bArr[i3 + 5] = (byte) ((j4 >>> 16) & 255);
        bArr[i3 + 6] = (byte) ((j4 >>> 8) & 255);
        bArr[i3 + 7] = (byte) (j4 & 255);
        O.f19683c = i3 + 8;
        this.f19654b += 8;
    }

    public final long e() {
        long j4 = this.f19654b;
        if (j4 == 0) {
            return 0L;
        }
        y yVar = this.f19653a;
        kotlin.jvm.internal.e.c(yVar);
        y yVar2 = yVar.f19686g;
        kotlin.jvm.internal.e.c(yVar2);
        return (yVar2.f19683c >= 8192 || !yVar2.e) ? j4 : j4 - (r3 - yVar2.f19682b);
    }

    public final void e0(int i3) {
        y O = O(2);
        int i10 = O.f19683c;
        byte[] bArr = O.f19681a;
        bArr[i10] = (byte) ((i3 >>> 8) & 255);
        bArr[i10 + 1] = (byte) (i3 & 255);
        O.f19683c = i10 + 2;
        this.f19654b += 2;
    }

    public final boolean equals(Object obj) {
        boolean z5 = true;
        if (this == obj) {
            return true;
        }
        boolean z6 = false;
        if (!(obj instanceof j)) {
            return false;
        }
        long j4 = this.f19654b;
        j jVar = (j) obj;
        if (j4 != jVar.f19654b) {
            return false;
        }
        if (j4 == 0) {
            return true;
        }
        y yVar = this.f19653a;
        kotlin.jvm.internal.e.c(yVar);
        y yVar2 = jVar.f19653a;
        kotlin.jvm.internal.e.c(yVar2);
        int i3 = yVar.f19682b;
        int i10 = yVar2.f19682b;
        long j10 = 0;
        while (j10 < this.f19654b) {
            long min = Math.min(yVar.f19683c - i3, yVar2.f19683c - i10);
            long j11 = 0;
            while (j11 < min) {
                int i11 = i3 + 1;
                boolean z8 = z5;
                byte b3 = yVar.f19681a[i3];
                int i12 = i10 + 1;
                boolean z10 = z6;
                if (b3 != yVar2.f19681a[i10]) {
                    return z10;
                }
                j11++;
                i10 = i12;
                i3 = i11;
                z5 = z8;
                z6 = z10;
            }
            boolean z11 = z5;
            boolean z12 = z6;
            if (i3 == yVar.f19683c) {
                y yVar3 = yVar.f19685f;
                kotlin.jvm.internal.e.c(yVar3);
                i3 = yVar3.f19682b;
                yVar = yVar3;
            }
            if (i10 == yVar2.f19683c) {
                yVar2 = yVar2.f19685f;
                kotlin.jvm.internal.e.c(yVar2);
                i10 = yVar2.f19682b;
            }
            j10 += min;
            z5 = z11;
            z6 = z12;
        }
        return z5;
    }

    public final void f(long j4, j out, long j10) {
        kotlin.jvm.internal.e.f(out, "out");
        long j11 = j4;
        d6.b(this.f19654b, j11, j10);
        if (j10 == 0) {
            return;
        }
        out.f19654b += j10;
        y yVar = this.f19653a;
        while (true) {
            kotlin.jvm.internal.e.c(yVar);
            long j12 = yVar.f19683c - yVar.f19682b;
            if (j11 < j12) {
                break;
            }
            j11 -= j12;
            yVar = yVar.f19685f;
        }
        y yVar2 = yVar;
        long j13 = j10;
        while (j13 > 0) {
            kotlin.jvm.internal.e.c(yVar2);
            y c9 = yVar2.c();
            int i3 = c9.f19682b + ((int) j11);
            c9.f19682b = i3;
            c9.f19683c = Math.min(i3 + ((int) j13), c9.f19683c);
            y yVar3 = out.f19653a;
            if (yVar3 == null) {
                c9.f19686g = c9;
                c9.f19685f = c9;
                out.f19653a = c9;
            } else {
                y yVar4 = yVar3.f19686g;
                kotlin.jvm.internal.e.c(yVar4);
                yVar4.b(c9);
            }
            j13 -= c9.f19683c - c9.f19682b;
            yVar2 = yVar2.f19685f;
            j11 = 0;
        }
    }

    public final void f0(String str, int i3, int i10, Charset charset) {
        if (i3 < 0) {
            throw new IllegalArgumentException(l0.j(i3, "beginIndex < 0: ").toString());
        }
        if (i10 < i3) {
            throw new IllegalArgumentException(l0.i(i10, i3, "endIndex < beginIndex: ", " < ").toString());
        }
        if (i10 > str.length()) {
            StringBuilder q5 = android.support.v4.media.session.e.q(i10, "endIndex > string.length: ", " > ");
            q5.append(str.length());
            throw new IllegalArgumentException(q5.toString().toString());
        }
        if (charset.equals(kotlin.text.a.f15656a)) {
            g0(i3, i10, str);
            return;
        }
        String substring = str.substring(i3, i10);
        kotlin.jvm.internal.e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        byte[] bytes = substring.getBytes(charset);
        kotlin.jvm.internal.e.e(bytes, "(this as java.lang.String).getBytes(charset)");
        Y(bytes, 0, bytes.length);
    }

    @Override // wh.k, wh.a0, java.io.Flushable
    public final void flush() {
    }

    public final byte g(long j4) {
        d6.b(this.f19654b, j4, 1L);
        y yVar = this.f19653a;
        if (yVar == null) {
            kotlin.jvm.internal.e.c(null);
            throw null;
        }
        long j10 = this.f19654b;
        if (j10 - j4 < j4) {
            while (j10 > j4) {
                yVar = yVar.f19686g;
                kotlin.jvm.internal.e.c(yVar);
                j10 -= yVar.f19683c - yVar.f19682b;
            }
            return yVar.f19681a[(int) ((yVar.f19682b + j4) - j10)];
        }
        long j11 = 0;
        while (true) {
            int i3 = yVar.f19683c;
            int i10 = yVar.f19682b;
            long j12 = (i3 - i10) + j11;
            if (j12 > j4) {
                return yVar.f19681a[(int) ((i10 + j4) - j11)];
            }
            yVar = yVar.f19685f;
            kotlin.jvm.internal.e.c(yVar);
            j11 = j12;
        }
    }

    public final void g0(int i3, int i10, String string) {
        kotlin.jvm.internal.e.f(string, "string");
        if (i3 < 0) {
            throw new IllegalArgumentException(l0.j(i3, "beginIndex < 0: ").toString());
        }
        if (i10 < i3) {
            throw new IllegalArgumentException(l0.i(i10, i3, "endIndex < beginIndex: ", " < ").toString());
        }
        if (i10 > string.length()) {
            StringBuilder q5 = android.support.v4.media.session.e.q(i10, "endIndex > string.length: ", " > ");
            q5.append(string.length());
            throw new IllegalArgumentException(q5.toString().toString());
        }
        while (i3 < i10) {
            char charAt = string.charAt(i3);
            if (charAt < 128) {
                y O = O(1);
                int i11 = O.f19683c - i3;
                int min = Math.min(i10, 8192 - i11);
                int i12 = i3 + 1;
                byte[] bArr = O.f19681a;
                bArr[i3 + i11] = (byte) charAt;
                while (i12 < min) {
                    char charAt2 = string.charAt(i12);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i12 + i11] = (byte) charAt2;
                    i12++;
                }
                int i13 = O.f19683c;
                int i14 = (i11 + i12) - i13;
                O.f19683c = i13 + i14;
                this.f19654b += i14;
                i3 = i12;
            } else {
                if (charAt < 2048) {
                    y O2 = O(2);
                    int i15 = O2.f19683c;
                    byte[] bArr2 = O2.f19681a;
                    bArr2[i15] = (byte) ((charAt >> 6) | 192);
                    bArr2[i15 + 1] = (byte) ((charAt & '?') | 128);
                    O2.f19683c = i15 + 2;
                    this.f19654b += 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    y O3 = O(3);
                    int i16 = O3.f19683c;
                    byte[] bArr3 = O3.f19681a;
                    bArr3[i16] = (byte) ((charAt >> '\f') | 224);
                    bArr3[i16 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                    bArr3[i16 + 2] = (byte) ((charAt & '?') | 128);
                    O3.f19683c = i16 + 3;
                    this.f19654b += 3;
                } else {
                    int i17 = i3 + 1;
                    char charAt3 = i17 < i10 ? string.charAt(i17) : (char) 0;
                    if (charAt > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                        Z(63);
                        i3 = i17;
                    } else {
                        int i18 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + WXMediaMessage.THUMB_LENGTH_LIMIT;
                        y O4 = O(4);
                        int i19 = O4.f19683c;
                        byte[] bArr4 = O4.f19681a;
                        bArr4[i19] = (byte) ((i18 >> 18) | 240);
                        bArr4[i19 + 1] = (byte) (((i18 >> 12) & 63) | 128);
                        bArr4[i19 + 2] = (byte) (((i18 >> 6) & 63) | 128);
                        bArr4[i19 + 3] = (byte) ((i18 & 63) | 128);
                        O4.f19683c = i19 + 4;
                        this.f19654b += 4;
                        i3 += 2;
                    }
                }
                i3++;
            }
        }
    }

    public final long h(byte b3, long j4, long j10) {
        y yVar;
        long j11 = 0;
        if (!(0 <= j4 && j10 >= j4)) {
            throw new IllegalArgumentException(("size=" + this.f19654b + " fromIndex=" + j4 + " toIndex=" + j10).toString());
        }
        long j12 = this.f19654b;
        if (j10 > j12) {
            j10 = j12;
        }
        if (j4 == j10 || (yVar = this.f19653a) == null) {
            return -1L;
        }
        if (j12 - j4 < j4) {
            while (j12 > j4) {
                yVar = yVar.f19686g;
                kotlin.jvm.internal.e.c(yVar);
                j12 -= yVar.f19683c - yVar.f19682b;
            }
            while (j12 < j10) {
                int min = (int) Math.min(yVar.f19683c, (yVar.f19682b + j10) - j12);
                for (int i3 = (int) ((yVar.f19682b + j4) - j12); i3 < min; i3++) {
                    if (yVar.f19681a[i3] == b3) {
                        return (i3 - yVar.f19682b) + j12;
                    }
                }
                j12 += yVar.f19683c - yVar.f19682b;
                yVar = yVar.f19685f;
                kotlin.jvm.internal.e.c(yVar);
                j4 = j12;
            }
            return -1L;
        }
        while (true) {
            long j13 = (yVar.f19683c - yVar.f19682b) + j11;
            if (j13 > j4) {
                break;
            }
            yVar = yVar.f19685f;
            kotlin.jvm.internal.e.c(yVar);
            j11 = j13;
        }
        while (j11 < j10) {
            int min2 = (int) Math.min(yVar.f19683c, (yVar.f19682b + j10) - j11);
            for (int i10 = (int) ((yVar.f19682b + j4) - j11); i10 < min2; i10++) {
                if (yVar.f19681a[i10] == b3) {
                    return (i10 - yVar.f19682b) + j11;
                }
            }
            j11 += yVar.f19683c - yVar.f19682b;
            yVar = yVar.f19685f;
            kotlin.jvm.internal.e.c(yVar);
            j4 = j11;
        }
        return -1L;
    }

    public final void h0(String string) {
        kotlin.jvm.internal.e.f(string, "string");
        g0(0, string.length(), string);
    }

    public final int hashCode() {
        y yVar = this.f19653a;
        if (yVar == null) {
            return 0;
        }
        int i3 = 1;
        do {
            int i10 = yVar.f19683c;
            for (int i11 = yVar.f19682b; i11 < i10; i11++) {
                i3 = (i3 * 31) + yVar.f19681a[i11];
            }
            yVar = yVar.f19685f;
            kotlin.jvm.internal.e.c(yVar);
        } while (yVar != this.f19653a);
        return i3;
    }

    public final long i(ByteString targetBytes) {
        int i3;
        int i10;
        kotlin.jvm.internal.e.f(targetBytes, "targetBytes");
        y yVar = this.f19653a;
        if (yVar == null) {
            return -1L;
        }
        long j4 = this.f19654b;
        long j10 = 0;
        if (j4 < 0) {
            while (j4 > 0) {
                yVar = yVar.f19686g;
                kotlin.jvm.internal.e.c(yVar);
                j4 -= yVar.f19683c - yVar.f19682b;
            }
            if (targetBytes.size() == 2) {
                byte b3 = targetBytes.getByte(0);
                byte b10 = targetBytes.getByte(1);
                while (j4 < this.f19654b) {
                    i3 = (int) ((yVar.f19682b + j10) - j4);
                    int i11 = yVar.f19683c;
                    while (i3 < i11) {
                        byte b11 = yVar.f19681a[i3];
                        if (b11 != b3 && b11 != b10) {
                            i3++;
                        }
                        i10 = yVar.f19682b;
                    }
                    j10 = (yVar.f19683c - yVar.f19682b) + j4;
                    yVar = yVar.f19685f;
                    kotlin.jvm.internal.e.c(yVar);
                    j4 = j10;
                }
                return -1L;
            }
            byte[] internalArray$okio = targetBytes.internalArray$okio();
            while (j4 < this.f19654b) {
                i3 = (int) ((yVar.f19682b + j10) - j4);
                int i12 = yVar.f19683c;
                while (i3 < i12) {
                    byte b12 = yVar.f19681a[i3];
                    for (byte b13 : internalArray$okio) {
                        if (b12 == b13) {
                            i10 = yVar.f19682b;
                        }
                    }
                    i3++;
                }
                j10 = (yVar.f19683c - yVar.f19682b) + j4;
                yVar = yVar.f19685f;
                kotlin.jvm.internal.e.c(yVar);
                j4 = j10;
            }
            return -1L;
        }
        j4 = 0;
        while (true) {
            long j11 = (yVar.f19683c - yVar.f19682b) + j4;
            if (j11 > 0) {
                break;
            }
            yVar = yVar.f19685f;
            kotlin.jvm.internal.e.c(yVar);
            j4 = j11;
        }
        if (targetBytes.size() == 2) {
            byte b14 = targetBytes.getByte(0);
            byte b15 = targetBytes.getByte(1);
            while (j4 < this.f19654b) {
                i3 = (int) ((yVar.f19682b + j10) - j4);
                int i13 = yVar.f19683c;
                while (i3 < i13) {
                    byte b16 = yVar.f19681a[i3];
                    if (b16 != b14 && b16 != b15) {
                        i3++;
                    }
                    i10 = yVar.f19682b;
                }
                j10 = (yVar.f19683c - yVar.f19682b) + j4;
                yVar = yVar.f19685f;
                kotlin.jvm.internal.e.c(yVar);
                j4 = j10;
            }
            return -1L;
        }
        byte[] internalArray$okio2 = targetBytes.internalArray$okio();
        while (j4 < this.f19654b) {
            i3 = (int) ((yVar.f19682b + j10) - j4);
            int i14 = yVar.f19683c;
            while (i3 < i14) {
                byte b17 = yVar.f19681a[i3];
                for (byte b18 : internalArray$okio2) {
                    if (b17 == b18) {
                        i10 = yVar.f19682b;
                    }
                }
                i3++;
            }
            j10 = (yVar.f19683c - yVar.f19682b) + j4;
            yVar = yVar.f19685f;
            kotlin.jvm.internal.e.c(yVar);
            j4 = j10;
        }
        return -1L;
        return (i3 - i10) + j4;
    }

    public final void i0(int i3) {
        String str;
        int i10 = 0;
        if (i3 < 128) {
            Z(i3);
            return;
        }
        if (i3 < 2048) {
            y O = O(2);
            int i11 = O.f19683c;
            byte[] bArr = O.f19681a;
            bArr[i11] = (byte) ((i3 >> 6) | 192);
            bArr[1 + i11] = (byte) ((i3 & 63) | 128);
            O.f19683c = i11 + 2;
            this.f19654b += 2;
            return;
        }
        if (55296 <= i3 && 57343 >= i3) {
            Z(63);
            return;
        }
        if (i3 < 65536) {
            y O2 = O(3);
            int i12 = O2.f19683c;
            byte[] bArr2 = O2.f19681a;
            bArr2[i12] = (byte) ((i3 >> 12) | 224);
            bArr2[1 + i12] = (byte) (((i3 >> 6) & 63) | 128);
            bArr2[2 + i12] = (byte) ((i3 & 63) | 128);
            O2.f19683c = i12 + 3;
            this.f19654b += 3;
            return;
        }
        if (i3 <= 1114111) {
            y O3 = O(4);
            int i13 = O3.f19683c;
            byte[] bArr3 = O3.f19681a;
            bArr3[i13] = (byte) ((i3 >> 18) | 240);
            bArr3[1 + i13] = (byte) (((i3 >> 12) & 63) | 128);
            bArr3[2 + i13] = (byte) (((i3 >> 6) & 63) | 128);
            bArr3[3 + i13] = (byte) ((i3 & 63) | 128);
            O3.f19683c = i13 + 4;
            this.f19654b += 4;
            return;
        }
        StringBuilder sb2 = new StringBuilder("Unexpected code point: 0x");
        if (i3 != 0) {
            char[] cArr = xh.b.f19828a;
            char[] cArr2 = {cArr[(i3 >> 28) & 15], cArr[(i3 >> 24) & 15], cArr[(i3 >> 20) & 15], cArr[(i3 >> 16) & 15], cArr[(i3 >> 12) & 15], cArr[(i3 >> 8) & 15], cArr[(i3 >> 4) & 15], cArr[i3 & 15]};
            while (i10 < 8 && cArr2[i10] == '0') {
                i10++;
            }
            str = new String(cArr2, i10, 8 - i10);
        } else {
            str = "0";
        }
        sb2.append(str);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final int j(byte[] sink, int i3, int i10) {
        kotlin.jvm.internal.e.f(sink, "sink");
        d6.b(sink.length, i3, i10);
        y yVar = this.f19653a;
        if (yVar == null) {
            return -1;
        }
        int min = Math.min(i10, yVar.f19683c - yVar.f19682b);
        int i11 = yVar.f19682b;
        kotlin.collections.g.c(yVar.f19681a, i3, i11, sink, i11 + min);
        int i12 = yVar.f19682b + min;
        yVar.f19682b = i12;
        this.f19654b -= min;
        if (i12 == yVar.f19683c) {
            this.f19653a = yVar.a();
            z.a(yVar);
        }
        return min;
    }

    public final void k(g unsafeCursor) {
        kotlin.jvm.internal.e.f(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.f19644a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.f19644a = this;
        unsafeCursor.f19645b = true;
    }

    public final byte[] l(long j4) {
        if (!(j4 >= 0 && j4 <= ((long) SubsamplingScaleImageView.TILE_SIZE_AUTO))) {
            throw new IllegalArgumentException(l0.l(j4, "byteCount: ").toString());
        }
        if (this.f19654b < j4) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j4];
        readFully(bArr);
        return bArr;
    }

    @Override // wh.l, wh.k
    public final j m() {
        return this;
    }

    @Override // wh.k
    public final /* bridge */ /* synthetic */ k p(long j4) {
        b0(j4);
        return this;
    }

    @Override // wh.l
    public final x peek() {
        return e6.b(new v(this));
    }

    @Override // wh.l
    public final j q() {
        return this;
    }

    @Override // wh.l
    public final ByteString r() {
        return s(this.f19654b);
    }

    @Override // wh.c0
    public final long read(j sink, long j4) {
        kotlin.jvm.internal.e.f(sink, "sink");
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(l0.l(j4, "byteCount < 0: ").toString());
        }
        long j10 = this.f19654b;
        if (j10 == 0) {
            return -1L;
        }
        if (j4 > j10) {
            j4 = j10;
        }
        sink.write(this, j4);
        return j4;
    }

    @Override // wh.l
    public final byte readByte() {
        if (this.f19654b == 0) {
            throw new EOFException();
        }
        y yVar = this.f19653a;
        kotlin.jvm.internal.e.c(yVar);
        int i3 = yVar.f19682b;
        int i10 = yVar.f19683c;
        int i11 = i3 + 1;
        byte b3 = yVar.f19681a[i3];
        this.f19654b--;
        if (i11 != i10) {
            yVar.f19682b = i11;
            return b3;
        }
        this.f19653a = yVar.a();
        z.a(yVar);
        return b3;
    }

    @Override // wh.l
    public final void readFully(byte[] sink) {
        kotlin.jvm.internal.e.f(sink, "sink");
        int i3 = 0;
        while (i3 < sink.length) {
            int j4 = j(sink, i3, sink.length - i3);
            if (j4 == -1) {
                throw new EOFException();
            }
            i3 += j4;
        }
    }

    @Override // wh.l
    public final int readInt() {
        if (this.f19654b < 4) {
            throw new EOFException();
        }
        y yVar = this.f19653a;
        kotlin.jvm.internal.e.c(yVar);
        int i3 = yVar.f19682b;
        int i10 = yVar.f19683c;
        if (i10 - i3 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = yVar.f19681a;
        int i11 = i3 + 3;
        int i12 = ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 2] & 255) << 8);
        int i13 = i3 + 4;
        int i14 = i12 | (bArr[i11] & 255);
        this.f19654b -= 4;
        if (i13 != i10) {
            yVar.f19682b = i13;
            return i14;
        }
        this.f19653a = yVar.a();
        z.a(yVar);
        return i14;
    }

    @Override // wh.l
    public final long readLong() {
        if (this.f19654b < 8) {
            throw new EOFException();
        }
        y yVar = this.f19653a;
        kotlin.jvm.internal.e.c(yVar);
        int i3 = yVar.f19682b;
        int i10 = yVar.f19683c;
        if (i10 - i3 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = yVar.f19681a;
        int i11 = i3 + 7;
        long j4 = ((bArr[i3 + 3] & 255) << 32) | ((bArr[i3] & 255) << 56) | ((bArr[i3 + 1] & 255) << 48) | ((bArr[i3 + 2] & 255) << 40) | ((bArr[i3 + 4] & 255) << 24) | ((bArr[i3 + 5] & 255) << 16) | ((bArr[i3 + 6] & 255) << 8);
        int i12 = i3 + 8;
        long j10 = j4 | (bArr[i11] & 255);
        this.f19654b -= 8;
        if (i12 != i10) {
            yVar.f19682b = i12;
            return j10;
        }
        this.f19653a = yVar.a();
        z.a(yVar);
        return j10;
    }

    @Override // wh.l
    public final short readShort() {
        if (this.f19654b < 2) {
            throw new EOFException();
        }
        y yVar = this.f19653a;
        kotlin.jvm.internal.e.c(yVar);
        int i3 = yVar.f19682b;
        int i10 = yVar.f19683c;
        if (i10 - i3 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        int i11 = i3 + 1;
        byte[] bArr = yVar.f19681a;
        int i12 = (bArr[i3] & 255) << 8;
        int i13 = i3 + 2;
        int i14 = (bArr[i11] & 255) | i12;
        this.f19654b -= 2;
        if (i13 == i10) {
            this.f19653a = yVar.a();
            z.a(yVar);
        } else {
            yVar.f19682b = i13;
        }
        return (short) i14;
    }

    @Override // wh.l
    public final boolean request(long j4) {
        return this.f19654b >= j4;
    }

    @Override // wh.l
    public final ByteString s(long j4) {
        if (!(j4 >= 0 && j4 <= ((long) SubsamplingScaleImageView.TILE_SIZE_AUTO))) {
            throw new IllegalArgumentException(l0.l(j4, "byteCount: ").toString());
        }
        if (this.f19654b < j4) {
            throw new EOFException();
        }
        if (j4 < 4096) {
            return new ByteString(l(j4));
        }
        ByteString I = I((int) j4);
        a(j4);
        return I;
    }

    @Override // wh.l
    public final void t(j sink, long j4) {
        kotlin.jvm.internal.e.f(sink, "sink");
        long j10 = this.f19654b;
        if (j10 >= j4) {
            sink.write(this, j4);
        } else {
            sink.write(this, j10);
            throw new EOFException();
        }
    }

    @Override // wh.c0
    public final f0 timeout() {
        return f0.NONE;
    }

    public final String toString() {
        long j4 = this.f19654b;
        if (j4 <= SubsamplingScaleImageView.TILE_SIZE_AUTO) {
            return I((int) j4).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f19654b).toString());
    }

    @Override // wh.k
    public final long v(c0 source) {
        kotlin.jvm.internal.e.f(source, "source");
        long j4 = 0;
        while (true) {
            long read = source.read(this, 8192);
            if (read == -1) {
                return j4;
            }
            j4 += read;
        }
    }

    @Override // wh.k
    public final k w() {
        return this;
    }

    @Override // wh.a0
    public final void write(j source, long j4) {
        y b3;
        kotlin.jvm.internal.e.f(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        d6.b(source.f19654b, 0L, j4);
        while (j4 > 0) {
            y yVar = source.f19653a;
            kotlin.jvm.internal.e.c(yVar);
            int i3 = yVar.f19683c;
            y yVar2 = source.f19653a;
            kotlin.jvm.internal.e.c(yVar2);
            long j10 = i3 - yVar2.f19682b;
            int i10 = 0;
            if (j4 < j10) {
                y yVar3 = this.f19653a;
                y yVar4 = yVar3 != null ? yVar3.f19686g : null;
                if (yVar4 != null && yVar4.e) {
                    if ((yVar4.f19683c + j4) - (yVar4.f19684d ? 0 : yVar4.f19682b) <= 8192) {
                        y yVar5 = source.f19653a;
                        kotlin.jvm.internal.e.c(yVar5);
                        yVar5.d(yVar4, (int) j4);
                        source.f19654b -= j4;
                        this.f19654b += j4;
                        return;
                    }
                }
                y yVar6 = source.f19653a;
                kotlin.jvm.internal.e.c(yVar6);
                int i11 = (int) j4;
                if (i11 <= 0 || i11 > yVar6.f19683c - yVar6.f19682b) {
                    throw new IllegalArgumentException("byteCount out of range");
                }
                if (i11 >= 1024) {
                    b3 = yVar6.c();
                } else {
                    b3 = z.b();
                    int i12 = yVar6.f19682b;
                    kotlin.collections.g.c(yVar6.f19681a, 0, i12, b3.f19681a, i12 + i11);
                }
                b3.f19683c = b3.f19682b + i11;
                yVar6.f19682b += i11;
                y yVar7 = yVar6.f19686g;
                kotlin.jvm.internal.e.c(yVar7);
                yVar7.b(b3);
                source.f19653a = b3;
            }
            y yVar8 = source.f19653a;
            kotlin.jvm.internal.e.c(yVar8);
            long j11 = yVar8.f19683c - yVar8.f19682b;
            source.f19653a = yVar8.a();
            y yVar9 = this.f19653a;
            if (yVar9 == null) {
                this.f19653a = yVar8;
                yVar8.f19686g = yVar8;
                yVar8.f19685f = yVar8;
            } else {
                y yVar10 = yVar9.f19686g;
                kotlin.jvm.internal.e.c(yVar10);
                yVar10.b(yVar8);
                y yVar11 = yVar8.f19686g;
                if (yVar11 == yVar8) {
                    throw new IllegalStateException("cannot compact");
                }
                kotlin.jvm.internal.e.c(yVar11);
                if (yVar11.e) {
                    int i13 = yVar8.f19683c - yVar8.f19682b;
                    y yVar12 = yVar8.f19686g;
                    kotlin.jvm.internal.e.c(yVar12);
                    int i14 = 8192 - yVar12.f19683c;
                    y yVar13 = yVar8.f19686g;
                    kotlin.jvm.internal.e.c(yVar13);
                    if (!yVar13.f19684d) {
                        y yVar14 = yVar8.f19686g;
                        kotlin.jvm.internal.e.c(yVar14);
                        i10 = yVar14.f19682b;
                    }
                    if (i13 <= i14 + i10) {
                        y yVar15 = yVar8.f19686g;
                        kotlin.jvm.internal.e.c(yVar15);
                        yVar8.d(yVar15, i13);
                        yVar8.a();
                        z.a(yVar8);
                    }
                }
            }
            source.f19654b -= j11;
            this.f19654b += j11;
            j4 -= j11;
        }
    }

    @Override // wh.k
    public final /* bridge */ /* synthetic */ k x(int i3) {
        e0(i3);
        return this;
    }

    public final String y(long j4, Charset charset) {
        kotlin.jvm.internal.e.f(charset, "charset");
        if (!(j4 >= 0 && j4 <= ((long) SubsamplingScaleImageView.TILE_SIZE_AUTO))) {
            throw new IllegalArgumentException(l0.l(j4, "byteCount: ").toString());
        }
        if (this.f19654b < j4) {
            throw new EOFException();
        }
        if (j4 == 0) {
            return "";
        }
        y yVar = this.f19653a;
        kotlin.jvm.internal.e.c(yVar);
        int i3 = yVar.f19682b;
        if (i3 + j4 > yVar.f19683c) {
            return new String(l(j4), charset);
        }
        int i10 = (int) j4;
        String str = new String(yVar.f19681a, i3, i10, charset);
        int i11 = yVar.f19682b + i10;
        yVar.f19682b = i11;
        this.f19654b -= j4;
        if (i11 == yVar.f19683c) {
            this.f19653a = yVar.a();
            z.a(yVar);
        }
        return str;
    }

    @Override // wh.k
    public final /* bridge */ /* synthetic */ k z(int i3) {
        c0(i3);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.e.f(sink, "sink");
        y yVar = this.f19653a;
        if (yVar == null) {
            return -1;
        }
        int min = Math.min(sink.remaining(), yVar.f19683c - yVar.f19682b);
        sink.put(yVar.f19681a, yVar.f19682b, min);
        int i3 = yVar.f19682b + min;
        yVar.f19682b = i3;
        this.f19654b -= min;
        if (i3 == yVar.f19683c) {
            this.f19653a = yVar.a();
            z.a(yVar);
        }
        return min;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.e.f(source, "source");
        int remaining = source.remaining();
        int i3 = remaining;
        while (i3 > 0) {
            y O = O(1);
            int min = Math.min(i3, 8192 - O.f19683c);
            source.get(O.f19681a, O.f19683c, min);
            i3 -= min;
            O.f19683c += min;
        }
        this.f19654b += remaining;
        return remaining;
    }
}
