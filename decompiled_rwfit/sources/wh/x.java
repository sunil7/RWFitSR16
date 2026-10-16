package wh;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.xd;
import com.google.android.gms.internal.mlkit_vision_common.e6;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class x implements l {

    /* renamed from: a, reason: collision with root package name */
    public final j f19678a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19679b;

    /* renamed from: c, reason: collision with root package name */
    public final c0 f19680c;

    public x(c0 source) {
        kotlin.jvm.internal.e.f(source, "source");
        this.f19680c = source;
        this.f19678a = new j();
    }

    @Override // wh.l
    public final String B() {
        return M(Format.OFFSET_SAMPLE_RELATIVE);
    }

    @Override // wh.l
    public final byte[] C() {
        c0 c0Var = this.f19680c;
        j jVar = this.f19678a;
        jVar.v(c0Var);
        return jVar.l(jVar.f19654b);
    }

    @Override // wh.l
    public final boolean D() {
        if (this.f19679b) {
            throw new IllegalStateException("closed");
        }
        j jVar = this.f19678a;
        if (jVar.D()) {
            return this.f19680c.read(jVar, (long) 8192) == -1;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        com.google.android.gms.internal.mlkit_vision_barcode.xd.a(16);
        com.google.android.gms.internal.mlkit_vision_barcode.xd.a(16);
        r1 = java.lang.Integer.toString(r8, 16);
        kotlin.jvm.internal.e.e(r1, "java.lang.Integer.toStri…(this, checkRadix(radix))");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        throw new java.lang.NumberFormatException("Expected leading [0-9] or '-' character but was 0x".concat(r1));
     */
    @Override // wh.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long K() {
        /*
            r11 = this;
            r0 = 1
            r11.P(r0)
            r2 = 0
            r4 = r2
        L8:
            long r6 = r4 + r0
            boolean r8 = r11.request(r6)
            wh.j r9 = r11.f19678a
            if (r8 == 0) goto L4c
            byte r8 = r9.g(r4)
            r10 = 48
            byte r10 = (byte) r10
            if (r8 < r10) goto L20
            r10 = 57
            byte r10 = (byte) r10
            if (r8 <= r10) goto L2a
        L20:
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 != 0) goto L2c
            r5 = 45
            byte r5 = (byte) r5
            if (r8 == r5) goto L2a
            goto L2c
        L2a:
            r4 = r6
            goto L8
        L2c:
            if (r4 == 0) goto L2f
            goto L4c
        L2f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = 16
            com.google.android.gms.internal.mlkit_vision_barcode.xd.a(r1)
            com.google.android.gms.internal.mlkit_vision_barcode.xd.a(r1)
            java.lang.String r1 = java.lang.Integer.toString(r8, r1)
            java.lang.String r2 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.e.e(r1, r2)
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L4c:
            long r0 = r9.K()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: wh.x.K():long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0032, code lost:
    
        return -1;
     */
    @Override // wh.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int L(wh.u r7) {
        /*
            r6 = this;
            java.lang.String r0 = "options"
            kotlin.jvm.internal.e.f(r7, r0)
            boolean r0 = r6.f19679b
            if (r0 != 0) goto L33
        L9:
            wh.j r0 = r6.f19678a
            r1 = 1
            int r1 = xh.a.c(r0, r7, r1)
            r2 = -2
            r3 = -1
            if (r1 == r2) goto L23
            if (r1 == r3) goto L32
            okio.ByteString[] r7 = r7.f19668a
            r7 = r7[r1]
            int r7 = r7.size()
            long r2 = (long) r7
            r0.a(r2)
            return r1
        L23:
            r1 = 8192(0x2000, float:1.148E-41)
            long r1 = (long) r1
            wh.c0 r4 = r6.f19680c
            long r0 = r4.read(r0, r1)
            r4 = -1
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L9
        L32:
            return r3
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "closed"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: wh.x.L(wh.u):int");
    }

    @Override // wh.l
    public final String M(long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException(l0.l(j4, "limit < 0: ").toString());
        }
        long j10 = j4 == Format.OFFSET_SAMPLE_RELATIVE ? Long.MAX_VALUE : j4 + 1;
        byte b3 = (byte) 10;
        long b10 = b(b3, 0L, j10);
        j jVar = this.f19678a;
        if (b10 != -1) {
            return xh.a.b(jVar, b10);
        }
        if (j10 < Format.OFFSET_SAMPLE_RELATIVE && request(j10) && jVar.g(j10 - 1) == ((byte) 13) && request(j10 + 1) && jVar.g(j10) == b3) {
            return xh.a.b(jVar, j10);
        }
        j jVar2 = new j();
        jVar.f(0L, jVar2, Math.min(32, jVar.f19654b));
        throw new EOFException("\\n not found: limit=" + Math.min(jVar.f19654b, j4) + " content=" + jVar2.s(jVar2.f19654b).hex() + "…");
    }

    @Override // wh.l
    public final void P(long j4) {
        if (!request(j4)) {
            throw new EOFException();
        }
    }

    @Override // wh.l
    public final boolean S(long j4, ByteString bytes) {
        int i3;
        kotlin.jvm.internal.e.f(bytes, "bytes");
        int size = bytes.size();
        if (this.f19679b) {
            throw new IllegalStateException("closed");
        }
        if (size >= 0 && bytes.size() >= size) {
            for (0; i3 < size; i3 + 1) {
                long j10 = i3;
                i3 = (request(1 + j10) && this.f19678a.g(j10) == bytes.getByte(i3)) ? i3 + 1 : 0;
            }
            return true;
        }
        return false;
    }

    @Override // wh.l
    public final long T() {
        j jVar;
        byte g10;
        P(1L);
        int i3 = 0;
        while (true) {
            int i10 = i3 + 1;
            boolean request = request(i10);
            jVar = this.f19678a;
            if (!request) {
                break;
            }
            g10 = jVar.g(i3);
            if ((g10 < ((byte) 48) || g10 > ((byte) 57)) && ((g10 < ((byte) 97) || g10 > ((byte) 102)) && (g10 < ((byte) 65) || g10 > ((byte) 70)))) {
                break;
            }
            i3 = i10;
        }
        if (i3 == 0) {
            xd.a(16);
            xd.a(16);
            String num = Integer.toString(g10, 16);
            kotlin.jvm.internal.e.e(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(num));
        }
        return jVar.T();
    }

    @Override // wh.l
    public final String U(Charset charset) {
        kotlin.jvm.internal.e.f(charset, "charset");
        c0 c0Var = this.f19680c;
        j jVar = this.f19678a;
        jVar.v(c0Var);
        return jVar.U(charset);
    }

    @Override // wh.l
    public final InputStream V() {
        return new h(this, 1);
    }

    @Override // wh.l
    public final void a(long j4) {
        if (this.f19679b) {
            throw new IllegalStateException("closed");
        }
        while (j4 > 0) {
            j jVar = this.f19678a;
            if (jVar.f19654b == 0) {
                if (this.f19680c.read(jVar, 8192) == -1) {
                    throw new EOFException();
                }
            }
            long min = Math.min(j4, jVar.f19654b);
            jVar.a(min);
            j4 -= min;
        }
    }

    public final long b(byte b3, long j4, long j10) {
        if (this.f19679b) {
            throw new IllegalStateException("closed");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException(l0.l(j10, "fromIndex=0 toIndex=").toString());
        }
        long j11 = 0;
        while (j11 < j10) {
            j jVar = this.f19678a;
            byte b10 = b3;
            long j12 = j10;
            long h4 = jVar.h(b10, j11, j12);
            if (h4 == -1) {
                long j13 = jVar.f19654b;
                if (j13 >= j12) {
                    break;
                }
                if (this.f19680c.read(jVar, 8192) == -1) {
                    break;
                }
                j11 = Math.max(j11, j13);
                b3 = b10;
                j10 = j12;
            } else {
                return h4;
            }
        }
        return -1L;
    }

    public final int c() {
        P(4L);
        int readInt = this.f19678a.readInt();
        return ((readInt & 255) << 24) | (((-16777216) & readInt) >>> 24) | ((16711680 & readInt) >>> 8) | ((65280 & readInt) << 8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.f19679b) {
            return;
        }
        this.f19679b = true;
        this.f19680c.close();
        this.f19678a.b();
    }

    @Override // wh.l
    public final long d(j jVar) {
        j jVar2;
        long j4 = 0;
        while (true) {
            jVar2 = this.f19678a;
            if (this.f19680c.read(jVar2, 8192) == -1) {
                break;
            }
            long e = jVar2.e();
            if (e > 0) {
                j4 += e;
                jVar.write(jVar2, e);
            }
        }
        long j10 = jVar2.f19654b;
        if (j10 <= 0) {
            return j4;
        }
        long j11 = j4 + j10;
        jVar.write(jVar2, j10);
        return j11;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f19679b;
    }

    @Override // wh.l, wh.k
    public final j m() {
        return this.f19678a;
    }

    @Override // wh.l
    public final x peek() {
        return e6.b(new v(this));
    }

    @Override // wh.l
    public final j q() {
        return this.f19678a;
    }

    @Override // wh.l
    public final ByteString r() {
        c0 c0Var = this.f19680c;
        j jVar = this.f19678a;
        jVar.v(c0Var);
        return jVar.s(jVar.f19654b);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.e.f(sink, "sink");
        j jVar = this.f19678a;
        if (jVar.f19654b == 0) {
            if (this.f19680c.read(jVar, 8192) == -1) {
                return -1;
            }
        }
        return jVar.read(sink);
    }

    @Override // wh.l
    public final byte readByte() {
        P(1L);
        return this.f19678a.readByte();
    }

    @Override // wh.l
    public final void readFully(byte[] sink) {
        j jVar = this.f19678a;
        kotlin.jvm.internal.e.f(sink, "sink");
        try {
            P(sink.length);
            jVar.readFully(sink);
        } catch (EOFException e) {
            int i3 = 0;
            while (true) {
                long j4 = jVar.f19654b;
                if (j4 <= 0) {
                    throw e;
                }
                int j10 = jVar.j(sink, i3, (int) j4);
                if (j10 == -1) {
                    throw new AssertionError();
                }
                i3 += j10;
            }
        }
    }

    @Override // wh.l
    public final int readInt() {
        P(4L);
        return this.f19678a.readInt();
    }

    @Override // wh.l
    public final long readLong() {
        P(8L);
        return this.f19678a.readLong();
    }

    @Override // wh.l
    public final short readShort() {
        P(2L);
        return this.f19678a.readShort();
    }

    @Override // wh.l
    public final boolean request(long j4) {
        j jVar;
        if (j4 < 0) {
            throw new IllegalArgumentException(l0.l(j4, "byteCount < 0: ").toString());
        }
        if (this.f19679b) {
            throw new IllegalStateException("closed");
        }
        do {
            jVar = this.f19678a;
            if (jVar.f19654b >= j4) {
                return true;
            }
        } while (this.f19680c.read(jVar, 8192) != -1);
        return false;
    }

    @Override // wh.l
    public final ByteString s(long j4) {
        P(j4);
        return this.f19678a.s(j4);
    }

    @Override // wh.l
    public final void t(j sink, long j4) {
        j jVar = this.f19678a;
        kotlin.jvm.internal.e.f(sink, "sink");
        try {
            P(j4);
            jVar.t(sink, j4);
        } catch (EOFException e) {
            sink.v(jVar);
            throw e;
        }
    }

    @Override // wh.c0
    public final f0 timeout() {
        return this.f19680c.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f19680c + ')';
    }

    @Override // wh.c0
    public final long read(j sink, long j4) {
        kotlin.jvm.internal.e.f(sink, "sink");
        if (j4 >= 0) {
            if (!this.f19679b) {
                j jVar = this.f19678a;
                if (jVar.f19654b == 0) {
                    if (this.f19680c.read(jVar, 8192) == -1) {
                        return -1L;
                    }
                }
                return jVar.read(sink, Math.min(j4, jVar.f19654b));
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(l0.l(j4, "byteCount < 0: ").toString());
    }
}
