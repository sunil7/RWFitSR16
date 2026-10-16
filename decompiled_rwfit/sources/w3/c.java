package w3;

import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f19497b;

    /* renamed from: c, reason: collision with root package name */
    public b f19498c;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f19496a = new byte[256];

    /* renamed from: d, reason: collision with root package name */
    public int f19499d = 0;

    public final boolean a() {
        return this.f19498c.f19487b != 0;
    }

    public final b b() {
        byte[] bArr;
        if (this.f19497b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (a()) {
            return this.f19498c;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < 6; i3++) {
            sb2.append((char) c());
        }
        if (sb2.toString().startsWith("GIF")) {
            this.f19498c.f19490f = this.f19497b.getShort();
            this.f19498c.f19491g = this.f19497b.getShort();
            int c9 = c();
            b bVar = this.f19498c;
            bVar.f19492h = (c9 & 128) != 0;
            bVar.f19493i = (int) Math.pow(2.0d, (c9 & 7) + 1);
            this.f19498c.f19494j = c();
            b bVar2 = this.f19498c;
            c();
            bVar2.getClass();
            if (this.f19498c.f19492h && !a()) {
                b bVar3 = this.f19498c;
                bVar3.f19486a = e(bVar3.f19493i);
                b bVar4 = this.f19498c;
                bVar4.f19495k = bVar4.f19486a[bVar4.f19494j];
            }
        } else {
            this.f19498c.f19487b = 1;
        }
        if (!a()) {
            boolean z5 = false;
            while (!z5 && !a() && this.f19498c.f19488c <= Integer.MAX_VALUE) {
                int c10 = c();
                if (c10 == 33) {
                    int c11 = c();
                    if (c11 == 1) {
                        f();
                    } else if (c11 == 249) {
                        this.f19498c.f19489d = new a();
                        c();
                        int c12 = c();
                        a aVar = this.f19498c.f19489d;
                        int i10 = (c12 & 28) >> 2;
                        aVar.f19481g = i10;
                        if (i10 == 0) {
                            aVar.f19481g = 1;
                        }
                        aVar.f19480f = (c12 & 1) != 0;
                        short s7 = this.f19497b.getShort();
                        if (s7 < 2) {
                            s7 = 10;
                        }
                        a aVar2 = this.f19498c.f19489d;
                        aVar2.f19483i = s7 * 10;
                        aVar2.f19482h = c();
                        c();
                    } else if (c11 == 254) {
                        f();
                    } else if (c11 != 255) {
                        f();
                    } else {
                        d();
                        StringBuilder sb3 = new StringBuilder();
                        int i11 = 0;
                        while (true) {
                            bArr = this.f19496a;
                            if (i11 >= 11) {
                                break;
                            }
                            sb3.append((char) bArr[i11]);
                            i11++;
                        }
                        if (sb3.toString().equals("NETSCAPE2.0")) {
                            do {
                                d();
                                if (bArr[0] == 1) {
                                    byte b3 = bArr[1];
                                    byte b10 = bArr[2];
                                    this.f19498c.getClass();
                                }
                                if (this.f19499d > 0) {
                                }
                            } while (!a());
                        } else {
                            f();
                        }
                    }
                } else if (c10 == 44) {
                    b bVar5 = this.f19498c;
                    if (bVar5.f19489d == null) {
                        bVar5.f19489d = new a();
                    }
                    bVar5.f19489d.f19476a = this.f19497b.getShort();
                    this.f19498c.f19489d.f19477b = this.f19497b.getShort();
                    this.f19498c.f19489d.f19478c = this.f19497b.getShort();
                    this.f19498c.f19489d.f19479d = this.f19497b.getShort();
                    int c13 = c();
                    boolean z6 = (c13 & 128) != 0;
                    int pow = (int) Math.pow(2.0d, (c13 & 7) + 1);
                    a aVar3 = this.f19498c.f19489d;
                    aVar3.e = (c13 & 64) != 0;
                    if (z6) {
                        aVar3.f19485k = e(pow);
                    } else {
                        aVar3.f19485k = null;
                    }
                    this.f19498c.f19489d.f19484j = this.f19497b.position();
                    c();
                    f();
                    if (!a()) {
                        b bVar6 = this.f19498c;
                        bVar6.f19488c++;
                        bVar6.e.add(bVar6.f19489d);
                    }
                } else if (c10 != 59) {
                    this.f19498c.f19487b = 1;
                } else {
                    z5 = true;
                }
            }
            b bVar7 = this.f19498c;
            if (bVar7.f19488c < 0) {
                bVar7.f19487b = 1;
            }
        }
        return this.f19498c;
    }

    public final int c() {
        try {
            return this.f19497b.get() & 255;
        } catch (Exception unused) {
            this.f19498c.f19487b = 1;
            return 0;
        }
    }

    public final void d() {
        int c9 = c();
        this.f19499d = c9;
        if (c9 <= 0) {
            return;
        }
        int i3 = 0;
        int i10 = 0;
        while (true) {
            try {
                i10 = this.f19499d;
                if (i3 >= i10) {
                    return;
                }
                i10 -= i3;
                this.f19497b.get(this.f19496a, i3, i10);
                i3 += i10;
            } catch (Exception e) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    StringBuilder s7 = l0.s(i3, "Error Reading Block n: ", i10, " count: ", " blockSize: ");
                    s7.append(this.f19499d);
                    Log.d("GifHeaderParser", s7.toString(), e);
                }
                this.f19498c.f19487b = 1;
                return;
            }
        }
    }

    public final int[] e(int i3) {
        byte[] bArr = new byte[i3 * 3];
        int[] iArr = null;
        try {
            this.f19497b.get(bArr);
            iArr = new int[256];
            int i10 = 0;
            int i11 = 0;
            while (i10 < i3) {
                int i12 = bArr[i11] & 255;
                int i13 = i11 + 2;
                int i14 = bArr[i11 + 1] & 255;
                i11 += 3;
                int i15 = i10 + 1;
                iArr[i10] = (i14 << 8) | (i12 << 16) | (-16777216) | (bArr[i13] & 255);
                i10 = i15;
            }
            return iArr;
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.f19498c.f19487b = 1;
            return iArr;
        }
    }

    public final void f() {
        int c9;
        do {
            c9 = c();
            this.f19497b.position(Math.min(this.f19497b.position() + c9, this.f19497b.limit()));
        } while (c9 > 0);
    }
}
