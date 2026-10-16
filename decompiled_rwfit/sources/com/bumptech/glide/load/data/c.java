package com.bumptech.glide.load.data;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class c extends OutputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final FileOutputStream f6963a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f6964b;

    /* renamed from: c, reason: collision with root package name */
    public final a4.g f6965c;

    /* renamed from: d, reason: collision with root package name */
    public int f6966d;

    public c(FileOutputStream fileOutputStream, a4.g gVar) {
        this.f6963a = fileOutputStream;
        this.f6965c = gVar;
        this.f6964b = (byte[]) gVar.c(byte[].class, WXMediaMessage.THUMB_LENGTH_LIMIT);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        FileOutputStream fileOutputStream = this.f6963a;
        try {
            flush();
            fileOutputStream.close();
            byte[] bArr = this.f6964b;
            if (bArr != null) {
                this.f6965c.g(bArr);
                this.f6964b = null;
            }
        } catch (Throwable th2) {
            fileOutputStream.close();
            throw th2;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        int i3 = this.f6966d;
        FileOutputStream fileOutputStream = this.f6963a;
        if (i3 > 0) {
            fileOutputStream.write(this.f6964b, 0, i3);
            this.f6966d = 0;
        }
        fileOutputStream.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i3) {
        byte[] bArr = this.f6964b;
        int i10 = this.f6966d;
        int i11 = i10 + 1;
        this.f6966d = i11;
        bArr[i10] = (byte) i3;
        if (i11 != bArr.length || i11 <= 0) {
            return;
        }
        this.f6963a.write(bArr, 0, i11);
        this.f6966d = 0;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i3, int i10) {
        int i11 = 0;
        do {
            int i12 = i10 - i11;
            int i13 = i3 + i11;
            int i14 = this.f6966d;
            FileOutputStream fileOutputStream = this.f6963a;
            if (i14 == 0 && i12 >= this.f6964b.length) {
                fileOutputStream.write(bArr, i13, i12);
                return;
            }
            int min = Math.min(i12, this.f6964b.length - i14);
            System.arraycopy(bArr, i13, this.f6964b, this.f6966d, min);
            int i15 = this.f6966d + min;
            this.f6966d = i15;
            i11 += min;
            byte[] bArr2 = this.f6964b;
            if (i15 == bArr2.length && i15 > 0) {
                fileOutputStream.write(bArr2, 0, i15);
                this.f6966d = 0;
            }
        } while (i11 < i10);
    }
}
