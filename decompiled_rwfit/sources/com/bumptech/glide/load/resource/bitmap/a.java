package com.bumptech.glide.load.resource.bitmap;

import a4.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class a extends FilterInputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public volatile byte[] f7021a;

    /* renamed from: b, reason: collision with root package name */
    public int f7022b;

    /* renamed from: c, reason: collision with root package name */
    public int f7023c;

    /* renamed from: d, reason: collision with root package name */
    public int f7024d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public final g f7025f;

    public a(InputStream inputStream, g gVar) {
        super(inputStream);
        this.f7024d = -1;
        this.f7025f = gVar;
        this.f7021a = (byte[]) gVar.c(byte[].class, WXMediaMessage.THUMB_LENGTH_LIMIT);
    }

    public static void e() {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f7021a == null || inputStream == null) {
            e();
            throw null;
        }
        return (this.f7022b - this.e) + inputStream.available();
    }

    public final int b(InputStream inputStream, byte[] bArr) {
        int i3 = this.f7024d;
        if (i3 != -1) {
            int i10 = this.e - i3;
            int i11 = this.f7023c;
            if (i10 < i11) {
                if (i3 == 0 && i11 > bArr.length && this.f7022b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i11) {
                        i11 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f7025f.c(byte[].class, i11);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f7021a = bArr2;
                    this.f7025f.g(bArr);
                    bArr = bArr2;
                } else if (i3 > 0) {
                    System.arraycopy(bArr, i3, bArr, 0, bArr.length - i3);
                }
                int i12 = this.e - this.f7024d;
                this.e = i12;
                this.f7024d = 0;
                this.f7022b = 0;
                int read = inputStream.read(bArr, i12, bArr.length - i12);
                int i13 = this.e;
                if (read > 0) {
                    i13 += read;
                }
                this.f7022b = i13;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f7024d = -1;
            this.e = 0;
            this.f7022b = read2;
        }
        return read2;
    }

    public final synchronized void c() {
        if (this.f7021a != null) {
            this.f7025f.g(this.f7021a);
            this.f7021a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f7021a != null) {
            this.f7025f.g(this.f7021a);
            this.f7021a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i3) {
        this.f7023c = Math.max(this.f7023c, i3);
        this.f7024d = this.e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = this.f7021a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            e();
            throw null;
        }
        if (this.e >= this.f7022b && b(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f7021a && (bArr = this.f7021a) == null) {
            e();
            throw null;
        }
        int i3 = this.f7022b;
        int i10 = this.e;
        if (i3 - i10 <= 0) {
            return -1;
        }
        this.e = i10 + 1;
        return bArr[i10] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (this.f7021a == null) {
            throw new IOException("Stream is closed");
        }
        int i3 = this.f7024d;
        if (-1 == i3) {
            final String str = "Mark has been invalidated, pos: " + this.e + " markLimit: " + this.f7023c;
            throw new IOException(str) { // from class: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream$InvalidMarkException
                private static final long serialVersionUID = -4338378848813561757L;
            };
        }
        this.e = i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j4) {
        if (j4 < 1) {
            return 0L;
        }
        byte[] bArr = this.f7021a;
        if (bArr == null) {
            e();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            e();
            throw null;
        }
        int i3 = this.f7022b;
        int i10 = this.e;
        if (i3 - i10 >= j4) {
            this.e = (int) (i10 + j4);
            return j4;
        }
        long j10 = i3 - i10;
        this.e = i3;
        if (this.f7024d == -1 || j4 > this.f7023c) {
            long skip = inputStream.skip(j4 - j10);
            if (skip > 0) {
                this.f7024d = -1;
            }
            return j10 + skip;
        }
        if (b(inputStream, bArr) == -1) {
            return j10;
        }
        int i11 = this.f7022b;
        int i12 = this.e;
        if (i11 - i12 >= j4 - j10) {
            this.e = (int) ((i12 + j4) - j10);
            return j4;
        }
        long j11 = (j10 + i11) - i12;
        this.e = i11;
        return j11;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i3, int i10) {
        int i11;
        int i12;
        byte[] bArr2 = this.f7021a;
        if (bArr2 == null) {
            e();
            throw null;
        }
        if (i10 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i13 = this.e;
            int i14 = this.f7022b;
            if (i13 < i14) {
                int i15 = i14 - i13;
                if (i15 >= i10) {
                    i15 = i10;
                }
                System.arraycopy(bArr2, i13, bArr, i3, i15);
                this.e += i15;
                if (i15 == i10 || inputStream.available() == 0) {
                    return i15;
                }
                i3 += i15;
                i11 = i10 - i15;
            } else {
                i11 = i10;
            }
            while (true) {
                if (this.f7024d == -1 && i11 >= bArr2.length) {
                    i12 = inputStream.read(bArr, i3, i11);
                    if (i12 == -1) {
                        return i11 != i10 ? i10 - i11 : -1;
                    }
                } else {
                    if (b(inputStream, bArr2) == -1) {
                        return i11 != i10 ? i10 - i11 : -1;
                    }
                    if (bArr2 != this.f7021a && (bArr2 = this.f7021a) == null) {
                        e();
                        throw null;
                    }
                    int i16 = this.f7022b;
                    int i17 = this.e;
                    i12 = i16 - i17;
                    if (i12 >= i11) {
                        i12 = i11;
                    }
                    System.arraycopy(bArr2, i17, bArr, i3, i12);
                    this.e += i12;
                }
                i11 -= i12;
                if (i11 == 0) {
                    return i10;
                }
                if (inputStream.available() == 0) {
                    return i10 - i11;
                }
                i3 += i12;
            }
        } else {
            e();
            throw null;
        }
    }
}
