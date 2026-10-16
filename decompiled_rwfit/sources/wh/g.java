package wh;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.Closeable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class g implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public j f19644a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19645b;

    /* renamed from: c, reason: collision with root package name */
    public y f19646c;
    public byte[] e;

    /* renamed from: d, reason: collision with root package name */
    public long f19647d = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f19648f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f19649g = -1;

    public final void b(long j4) {
        j jVar = this.f19644a;
        if (jVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!this.f19645b) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        long j10 = jVar.f19654b;
        if (j4 <= j10) {
            if (j4 < 0) {
                throw new IllegalArgumentException(l0.l(j4, "newSize < 0: ").toString());
            }
            long j11 = j10 - j4;
            while (true) {
                if (j11 <= 0) {
                    break;
                }
                y yVar = jVar.f19653a;
                kotlin.jvm.internal.e.c(yVar);
                y yVar2 = yVar.f19686g;
                kotlin.jvm.internal.e.c(yVar2);
                int i3 = yVar2.f19683c;
                long j12 = i3 - yVar2.f19682b;
                if (j12 > j11) {
                    yVar2.f19683c = i3 - ((int) j11);
                    break;
                } else {
                    jVar.f19653a = yVar2.a();
                    z.a(yVar2);
                    j11 -= j12;
                }
            }
            this.f19646c = null;
            this.f19647d = j4;
            this.e = null;
            this.f19648f = -1;
            this.f19649g = -1;
        } else if (j4 > j10) {
            long j13 = j4 - j10;
            int i10 = 1;
            boolean z5 = true;
            for (long j14 = 0; j13 > j14; j14 = 0) {
                y O = jVar.O(i10);
                int min = (int) Math.min(j13, 8192 - O.f19683c);
                int i11 = O.f19683c + min;
                O.f19683c = i11;
                j13 -= min;
                if (z5) {
                    this.f19646c = O;
                    this.f19647d = j10;
                    this.e = O.f19681a;
                    this.f19648f = i11 - min;
                    this.f19649g = i11;
                    z5 = false;
                }
                i10 = 1;
            }
        }
        jVar.f19654b = j4;
    }

    public final int c(long j4) {
        j jVar = this.f19644a;
        if (jVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (j4 >= -1) {
            long j10 = jVar.f19654b;
            if (j4 <= j10) {
                if (j4 == -1 || j4 == j10) {
                    this.f19646c = null;
                    this.f19647d = j4;
                    this.e = null;
                    this.f19648f = -1;
                    this.f19649g = -1;
                    return -1;
                }
                y yVar = jVar.f19653a;
                y yVar2 = this.f19646c;
                long j11 = 0;
                if (yVar2 != null) {
                    long j12 = this.f19647d - (this.f19648f - yVar2.f19682b);
                    if (j12 > j4) {
                        yVar2 = yVar;
                        yVar = yVar2;
                        j10 = j12;
                    } else {
                        j11 = j12;
                    }
                } else {
                    yVar2 = yVar;
                }
                if (j10 - j4 > j4 - j11) {
                    while (true) {
                        kotlin.jvm.internal.e.c(yVar2);
                        long j13 = (yVar2.f19683c - yVar2.f19682b) + j11;
                        if (j4 < j13) {
                            break;
                        }
                        yVar2 = yVar2.f19685f;
                        j11 = j13;
                    }
                } else {
                    while (j10 > j4) {
                        kotlin.jvm.internal.e.c(yVar);
                        yVar = yVar.f19686g;
                        kotlin.jvm.internal.e.c(yVar);
                        j10 -= yVar.f19683c - yVar.f19682b;
                    }
                    yVar2 = yVar;
                    j11 = j10;
                }
                if (this.f19645b) {
                    kotlin.jvm.internal.e.c(yVar2);
                    if (yVar2.f19684d) {
                        byte[] bArr = yVar2.f19681a;
                        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                        kotlin.jvm.internal.e.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                        y yVar3 = new y(copyOf, yVar2.f19682b, yVar2.f19683c, false, true);
                        if (jVar.f19653a == yVar2) {
                            jVar.f19653a = yVar3;
                        }
                        yVar2.b(yVar3);
                        y yVar4 = yVar3.f19686g;
                        kotlin.jvm.internal.e.c(yVar4);
                        yVar4.a();
                        yVar2 = yVar3;
                    }
                }
                this.f19646c = yVar2;
                this.f19647d = j4;
                kotlin.jvm.internal.e.c(yVar2);
                this.e = yVar2.f19681a;
                int i3 = yVar2.f19682b + ((int) (j4 - j11));
                this.f19648f = i3;
                int i10 = yVar2.f19683c;
                this.f19649g = i10;
                return i10 - i3;
            }
        }
        throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j4), Long.valueOf(jVar.f19654b)}, 2)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!(this.f19644a != null)) {
            throw new IllegalStateException("not attached to a buffer");
        }
        this.f19644a = null;
        this.f19646c = null;
        this.f19647d = -1L;
        this.e = null;
        this.f19648f = -1;
        this.f19649g = -1;
    }
}
