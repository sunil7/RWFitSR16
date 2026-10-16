package v3;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class e implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final FileInputStream f19170a;

    /* renamed from: b, reason: collision with root package name */
    public final Charset f19171b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f19172c;

    /* renamed from: d, reason: collision with root package name */
    public int f19173d;
    public int e;

    public e(FileInputStream fileInputStream, Charset charset) {
        if (charset == null) {
            throw null;
        }
        if (!charset.equals(f.f19174a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f19170a = fileInputStream;
        this.f19171b = charset;
        this.f19172c = new byte[8192];
    }

    public final String b() {
        int i3;
        synchronized (this.f19170a) {
            try {
                byte[] bArr = this.f19172c;
                if (bArr == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f19173d >= this.e) {
                    int read = this.f19170a.read(bArr, 0, bArr.length);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.f19173d = 0;
                    this.e = read;
                }
                for (int i10 = this.f19173d; i10 != this.e; i10++) {
                    byte[] bArr2 = this.f19172c;
                    if (bArr2[i10] == 10) {
                        int i11 = this.f19173d;
                        if (i10 != i11) {
                            i3 = i10 - 1;
                            if (bArr2[i3] == 13) {
                                String str = new String(bArr2, i11, i3 - i11, this.f19171b.name());
                                this.f19173d = i10 + 1;
                                return str;
                            }
                        }
                        i3 = i10;
                        String str2 = new String(bArr2, i11, i3 - i11, this.f19171b.name());
                        this.f19173d = i10 + 1;
                        return str2;
                    }
                }
                d dVar = new d(this, (this.e - this.f19173d) + 80);
                while (true) {
                    byte[] bArr3 = this.f19172c;
                    int i12 = this.f19173d;
                    dVar.write(bArr3, i12, this.e - i12);
                    this.e = -1;
                    byte[] bArr4 = this.f19172c;
                    int read2 = this.f19170a.read(bArr4, 0, bArr4.length);
                    if (read2 == -1) {
                        throw new EOFException();
                    }
                    this.f19173d = 0;
                    this.e = read2;
                    for (int i13 = 0; i13 != this.e; i13++) {
                        byte[] bArr5 = this.f19172c;
                        if (bArr5[i13] == 10) {
                            int i14 = this.f19173d;
                            if (i13 != i14) {
                                dVar.write(bArr5, i14, i13 - i14);
                            }
                            this.f19173d = i13 + 1;
                            return dVar.toString();
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f19170a) {
            try {
                if (this.f19172c != null) {
                    this.f19172c = null;
                    this.f19170a.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
