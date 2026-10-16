package ld;

import a2.g;
import com.google.zxing.qrcode.decoder.Mode;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Mode f15865a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15866b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15867c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15868d;
    public final /* synthetic */ com.google.zxing.qrcode.encoder.c e;

    public e(com.google.zxing.qrcode.encoder.c cVar, Mode mode, int i3, int i10, int i11) {
        this.e = cVar;
        this.f15865a = mode;
        this.f15866b = i3;
        this.f15867c = i10;
        this.f15868d = i11;
    }

    public final int a() {
        Mode mode = Mode.BYTE;
        Mode mode2 = this.f15865a;
        int i3 = this.f15868d;
        if (mode2 != mode) {
            return i3;
        }
        g gVar = this.e.f11280c;
        sc.e eVar = (sc.e) gVar.f34c;
        int i10 = this.f15866b;
        return ((String) gVar.f33b).substring(i10, i3 + i10).getBytes(eVar.f18238a[this.f15867c].charset()).length;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        Mode mode = this.f15865a;
        sb2.append(mode);
        sb2.append('(');
        Mode mode2 = Mode.ECI;
        com.google.zxing.qrcode.encoder.c cVar = this.e;
        if (mode == mode2) {
            sb2.append(((sc.e) cVar.f11280c.f34c).f18238a[this.f15867c].charset().displayName());
        } else {
            String str = (String) cVar.f11280c.f33b;
            int i3 = this.f15866b;
            String substring = str.substring(i3, this.f15868d + i3);
            StringBuilder sb3 = new StringBuilder();
            for (int i10 = 0; i10 < substring.length(); i10++) {
                if (substring.charAt(i10) < ' ' || substring.charAt(i10) > '~') {
                    sb3.append('.');
                } else {
                    sb3.append(substring.charAt(i10));
                }
            }
            sb2.append(sb3.toString());
        }
        sb2.append(')');
        return sb2.toString();
    }
}
