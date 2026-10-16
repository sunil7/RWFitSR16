package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.OutputStream;

/* loaded from: classes.dex */
public final class h0 extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9324a;

    /* renamed from: b, reason: collision with root package name */
    public long f9325b;

    @Override // java.io.OutputStream
    public final void write(int i3) {
        switch (this.f9324a) {
            case 0:
                this.f9325b++;
                break;
            default:
                this.f9325b++;
                break;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        switch (this.f9324a) {
            case 0:
                this.f9325b += bArr.length;
                break;
            default:
                this.f9325b += bArr.length;
                break;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i3, int i10) {
        int length;
        int i11;
        int length2;
        int i12;
        switch (this.f9324a) {
            case 0:
                if (i3 >= 0 && i3 <= (length = bArr.length) && i10 >= 0 && (i11 = i3 + i10) <= length && i11 >= 0) {
                    this.f9325b += i10;
                    return;
                }
                throw new IndexOutOfBoundsException();
            default:
                if (i3 >= 0 && i3 <= (length2 = bArr.length) && i10 >= 0 && (i12 = i3 + i10) <= length2 && i12 >= 0) {
                    this.f9325b += i10;
                    return;
                }
                throw new IndexOutOfBoundsException();
        }
    }
}
