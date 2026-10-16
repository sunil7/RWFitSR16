package com.amap.api.col.p0003sl;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class gb implements Closeable, AutoCloseable {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f4213f = Charset.forName("US-ASCII");

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f4214a;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f4215b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f4216c;

    /* renamed from: d, reason: collision with root package name */
    private int f4217d;
    private int e;

    public class a extends ByteArrayOutputStream {
        public a(int i3) {
            super(i3);
        }

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int i3 = ((ByteArrayOutputStream) this).count;
            if (i3 > 0) {
                int i10 = i3 - 1;
                if (((ByteArrayOutputStream) this).buf[i10] == 13) {
                    i3 = i10;
                }
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i3, gb.this.f4215b.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public gb(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private void b() throws IOException {
        InputStream inputStream = this.f4214a;
        byte[] bArr = this.f4216c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f4217d = 0;
        this.e = read;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.f4214a) {
            try {
                if (this.f4216c != null) {
                    this.f4216c = null;
                    this.f4214a.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private gb(InputStream inputStream, Charset charset, byte b3) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(f4213f)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f4214a = inputStream;
        this.f4215b = charset;
        this.f4216c = new byte[8192];
    }

    public final String a() throws IOException {
        int i3;
        byte[] bArr;
        int i10;
        synchronized (this.f4214a) {
            try {
                if (this.f4216c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f4217d >= this.e) {
                    b();
                }
                for (int i11 = this.f4217d; i11 != this.e; i11++) {
                    byte[] bArr2 = this.f4216c;
                    if (bArr2[i11] == 10) {
                        int i12 = this.f4217d;
                        if (i11 != i12) {
                            i10 = i11 - 1;
                            if (bArr2[i10] == 13) {
                                String str = new String(bArr2, i12, i10 - i12, this.f4215b.name());
                                this.f4217d = i11 + 1;
                                return str;
                            }
                        }
                        i10 = i11;
                        String str2 = new String(bArr2, i12, i10 - i12, this.f4215b.name());
                        this.f4217d = i11 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.e - this.f4217d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f4216c;
                    int i13 = this.f4217d;
                    aVar.write(bArr3, i13, this.e - i13);
                    this.e = -1;
                    b();
                    i3 = this.f4217d;
                    while (i3 != this.e) {
                        bArr = this.f4216c;
                        if (bArr[i3] == 10) {
                            break loop1;
                        }
                        i3++;
                    }
                }
                int i14 = this.f4217d;
                if (i3 != i14) {
                    aVar.write(bArr, i14, i3 - i14);
                }
                this.f4217d = i3 + 1;
                return aVar.toString();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
