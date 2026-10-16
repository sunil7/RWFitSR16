package k3;

import android.support.v4.media.session.e;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public long f15455a;

    /* renamed from: b, reason: collision with root package name */
    public String f15456b;

    /* renamed from: d, reason: collision with root package name */
    public int f15458d;
    public long e;

    /* renamed from: g, reason: collision with root package name */
    public short f15460g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f15461h;

    /* renamed from: c, reason: collision with root package name */
    public int f15457c = Const.I_DEF_CGI_SIG;

    /* renamed from: f, reason: collision with root package name */
    public long f15459f = 0;

    public a(boolean z5) {
        this.f15461h = z5;
    }

    public static String a(long j4) {
        if (j4 < 0 || j4 > 281474976710655L) {
            return null;
        }
        byte[] bArr = new byte[6];
        for (int i3 = 0; i3 < 6; i3++) {
            bArr[i3] = (byte) ((j4 >> ((5 - i3) * 8)) & 255);
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 6; i10++) {
            String hexString = Integer.toHexString(bArr[i10] & 255);
            if (hexString.length() < 2) {
                sb2.append("0");
            }
            sb2.append(hexString);
            if (i10 < 5) {
                sb2.append(":");
            }
        }
        return sb2.toString();
    }

    public static long b(String str) {
        if (str == null || str.length() == 0) {
            return 0L;
        }
        int i3 = 0;
        long j4 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long charAt = str.charAt(length);
            long j10 = 48;
            if (charAt < 48 || charAt > 57) {
                if (charAt >= 97 && charAt <= 102) {
                    j10 = 87;
                } else if (charAt < 65 || charAt > 70) {
                    if (charAt != 58 && charAt != 124) {
                        return 0L;
                    }
                } else {
                    j10 = 55;
                }
            }
            j4 += (charAt - j10) << i3;
            i3 += 4;
        }
        if (i3 != 48) {
            return 0L;
        }
        return j4;
    }

    public final Object clone() {
        boolean z5 = this.f15461h;
        a aVar = new a(z5);
        aVar.f15455a = this.f15455a;
        aVar.f15456b = this.f15456b;
        aVar.f15457c = this.f15457c;
        aVar.f15458d = this.f15458d;
        aVar.e = this.e;
        aVar.f15459f = this.f15459f;
        aVar.f15460g = this.f15460g;
        aVar.f15461h = z5;
        return aVar;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AmapWifi{mac=");
        sb2.append(this.f15455a);
        sb2.append(", ssid='");
        sb2.append(this.f15456b);
        sb2.append("', rssi=");
        sb2.append(this.f15457c);
        sb2.append(", frequency=");
        sb2.append(this.f15458d);
        sb2.append(", timestamp=");
        sb2.append(this.e);
        sb2.append(", lastUpdateUtcMills=");
        sb2.append(this.f15459f);
        sb2.append(", freshness=");
        sb2.append((int) this.f15460g);
        sb2.append(", connected=");
        return e.o(sb2, this.f15461h, '}');
    }
}
