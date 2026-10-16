package wh;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes2.dex */
public final class r implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public byte f19659a;

    /* renamed from: b, reason: collision with root package name */
    public final x f19660b;

    /* renamed from: c, reason: collision with root package name */
    public final Inflater f19661c;

    /* renamed from: d, reason: collision with root package name */
    public final s f19662d;
    public final CRC32 e;

    public r(c0 source) {
        kotlin.jvm.internal.e.f(source, "source");
        x xVar = new x(source);
        this.f19660b = xVar;
        Inflater inflater = new Inflater(true);
        this.f19661c = inflater;
        this.f19662d = new s(xVar, inflater);
        this.e = new CRC32();
    }

    public static void b(int i3, int i10, String str) {
        if (i10 != i3) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i10), Integer.valueOf(i3)}, 3)));
        }
    }

    public final void c(long j4, j jVar, long j10) {
        y yVar = jVar.f19653a;
        kotlin.jvm.internal.e.c(yVar);
        while (true) {
            int i3 = yVar.f19683c;
            int i10 = yVar.f19682b;
            if (j4 < i3 - i10) {
                break;
            }
            j4 -= i3 - i10;
            yVar = yVar.f19685f;
            kotlin.jvm.internal.e.c(yVar);
        }
        while (j10 > 0) {
            int min = (int) Math.min(yVar.f19683c - r5, j10);
            this.e.update(yVar.f19681a, (int) (yVar.f19682b + j4), min);
            j10 -= min;
            yVar = yVar.f19685f;
            kotlin.jvm.internal.e.c(yVar);
            j4 = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f19662d.close();
    }

    @Override // wh.c0
    public final long read(j sink, long j4) {
        long j10;
        long j11;
        r rVar = this;
        kotlin.jvm.internal.e.f(sink, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(l0.l(j4, "byteCount < 0: ").toString());
        }
        if (j4 == 0) {
            return 0L;
        }
        byte b3 = rVar.f19659a;
        CRC32 crc32 = rVar.e;
        x xVar = rVar.f19660b;
        if (b3 == 0) {
            xVar.P(10L);
            j jVar = xVar.f19678a;
            byte g10 = jVar.g(3L);
            boolean z5 = ((g10 >> 1) & 1) == 1;
            if (z5) {
                rVar.c(0L, jVar, 10L);
            }
            b(8075, xVar.readShort(), "ID1ID2");
            xVar.a(8L);
            if (((g10 >> 2) & 1) == 1) {
                xVar.P(2L);
                if (z5) {
                    c(0L, jVar, 2L);
                }
                short readShort = jVar.readShort();
                long j12 = (short) (((readShort & 255) << 8) | ((readShort & 65280) >>> 8));
                xVar.P(j12);
                if (z5) {
                    c(0L, jVar, j12);
                }
                xVar.a(j12);
            }
            if (((g10 >> 3) & 1) == 1) {
                long b10 = xVar.b((byte) 0, 0L, Format.OFFSET_SAMPLE_RELATIVE);
                if (b10 == -1) {
                    throw new EOFException();
                }
                if (z5) {
                    j10 = -1;
                    j11 = 2;
                    c(0L, jVar, b10 + 1);
                } else {
                    j10 = -1;
                    j11 = 2;
                }
                xVar.a(b10 + 1);
            } else {
                j10 = -1;
                j11 = 2;
            }
            if (((g10 >> 4) & 1) == 1) {
                long b11 = xVar.b((byte) 0, 0L, Format.OFFSET_SAMPLE_RELATIVE);
                if (b11 == j10) {
                    throw new EOFException();
                }
                if (z5) {
                    rVar = this;
                    rVar.c(0L, jVar, b11 + 1);
                } else {
                    rVar = this;
                }
                xVar.a(b11 + 1);
            } else {
                rVar = this;
            }
            if (z5) {
                xVar.P(j11);
                short readShort2 = jVar.readShort();
                b((short) (((readShort2 & 255) << 8) | ((readShort2 & 65280) >>> 8)), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            rVar.f19659a = (byte) 1;
        } else {
            j10 = -1;
        }
        if (rVar.f19659a == 1) {
            long j13 = sink.f19654b;
            long read = rVar.f19662d.read(sink, j4);
            if (read != j10) {
                rVar.c(j13, sink, read);
                return read;
            }
            rVar.f19659a = (byte) 2;
        }
        if (rVar.f19659a == 2) {
            b(xVar.c(), (int) crc32.getValue(), "CRC");
            b(xVar.c(), (int) rVar.f19661c.getBytesWritten(), "ISIZE");
            rVar.f19659a = (byte) 3;
            if (!xVar.D()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return j10;
    }

    @Override // wh.c0
    public final f0 timeout() {
        return this.f19660b.f19680c.timeout();
    }
}
