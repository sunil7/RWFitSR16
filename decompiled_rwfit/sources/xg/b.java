package xg;

import androidx.appcompat.widget.b0;
import ch.g;
import com.google.zxing.ChecksumException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.concurrent.TimeUnit;
import n.l;
import n.m0;
import rg.x;
import vg.o;
import z3.i;

/* loaded from: classes2.dex */
public final class b implements o, u4.a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f19825a;

    public /* synthetic */ b(Object obj) {
        this.f19825a = obj;
    }

    public int a(byte[] bArr, int i3, int i10, int i11, int i12) {
        int i13 = i10 + i11;
        int i14 = i12 == 0 ? 1 : 2;
        int[] iArr = new int[i13 / i14];
        for (int i15 = 0; i15 < i13; i15++) {
            if (i12 == 0 || i15 % 2 == i12 - 1) {
                iArr[i15 / i14] = bArr[i15 + i3] & 255;
            }
        }
        try {
            int y4 = ((m0) this.f19825a).y(i11 / i14, iArr);
            for (int i16 = 0; i16 < i10; i16++) {
                if (i12 == 0 || i16 % 2 == i12 - 1) {
                    bArr[i16 + i3] = (byte) iArr[i16 / i14];
                }
            }
            return y4;
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    @Override // vg.o
    public Object apply(Object obj) {
        TimeUnit timeUnit = (TimeUnit) this.f19825a;
        return new g(obj, x.b(timeUnit), timeUnit);
    }

    @Override // u4.a
    public Object e() {
        b0 b0Var = (b0) this.f19825a;
        return new com.bumptech.glide.load.engine.b((i) b0Var.f873b, (l) b0Var.f874c);
    }

    public b() {
        this.f19825a = new m0(uc.a.f19039o, 23);
    }

    public b(TimeUnit timeUnit, x xVar) {
        this.f19825a = timeUnit;
    }
}
