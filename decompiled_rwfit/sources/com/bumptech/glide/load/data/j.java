package com.bumptech.glide.load.data;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class j extends FilterInputStream {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f6971c = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: d, reason: collision with root package name */
    public static final int f6972d = 31;

    /* renamed from: a, reason: collision with root package name */
    public final byte f6973a;

    /* renamed from: b, reason: collision with root package name */
    public int f6974b;

    public j(InputStream inputStream, int i3) {
        super(inputStream);
        if (i3 < -1 || i3 > 8) {
            throw new IllegalArgumentException(l0.j(i3, "Cannot add invalid orientation: "));
        }
        this.f6973a = (byte) i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int i3;
        int i10 = this.f6974b;
        int read = (i10 < 2 || i10 > (i3 = f6972d)) ? super.read() : i10 == i3 ? this.f6973a : f6971c[i10 - 2] & 255;
        if (read != -1) {
            this.f6974b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j4) {
        long skip = super.skip(j4);
        if (skip > 0) {
            this.f6974b = (int) (this.f6974b + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i3, int i10) {
        int i11;
        int i12 = this.f6974b;
        int i13 = f6972d;
        if (i12 > i13) {
            i11 = super.read(bArr, i3, i10);
        } else if (i12 == i13) {
            bArr[i3] = this.f6973a;
            i11 = 1;
        } else if (i12 < 2) {
            i11 = super.read(bArr, i3, 2 - i12);
        } else {
            int min = Math.min(i13 - i12, i10);
            System.arraycopy(f6971c, this.f6974b - 2, bArr, i3, min);
            i11 = min;
        }
        if (i11 > 0) {
            this.f6974b += i11;
        }
        return i11;
    }
}
