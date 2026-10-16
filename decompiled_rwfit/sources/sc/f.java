package sc;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.CharacterSetECI;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class f {
    public static final byte[] e = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18240a;

    /* renamed from: b, reason: collision with root package name */
    public Object f18241b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f18242c;

    /* renamed from: d, reason: collision with root package name */
    public Object f18243d;

    public f() {
        this.f18240a = 1;
        this.f18243d = StandardCharsets.ISO_8859_1;
        this.f18241b = new StringBuilder();
    }

    public static int d(int[] iArr) {
        int length = iArr.length;
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = iArr[i12];
            if (i13 > i3) {
                i11 = i12;
                i3 = i13;
            }
            if (i13 > i10) {
                i10 = i13;
            }
        }
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            int i17 = i16 - i11;
            int i18 = iArr[i16] * i17 * i17;
            if (i18 > i15) {
                i14 = i16;
                i15 = i18;
            }
        }
        if (i11 <= i14) {
            int i19 = i11;
            i11 = i14;
            i14 = i19;
        }
        if (i11 - i14 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i20 = i11 - 1;
        int i21 = -1;
        int i22 = i20;
        while (i20 > i14) {
            int i23 = i20 - i14;
            int i24 = (i10 - iArr[i20]) * (i11 - i20) * i23 * i23;
            if (i24 > i21) {
                i22 = i20;
                i21 = i24;
            }
            i20--;
        }
        return i22 << 3;
    }

    public void a(char c9) {
        ((StringBuilder) this.f18241b).append((char) (c9 & 255));
    }

    public void b(int i3) {
        c();
        CharacterSetECI characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(i3);
        if (characterSetECIByValue == null) {
            throw FormatException.getFormatInstance();
        }
        this.f18243d = characterSetECIByValue.getCharset();
    }

    public void c() {
        Charset charset = (Charset) this.f18243d;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        if (charset.equals(charset2)) {
            if (((StringBuilder) this.f18241b).length() > 0) {
                StringBuilder sb2 = (StringBuilder) this.f18242c;
                if (sb2 == null) {
                    this.f18242c = (StringBuilder) this.f18241b;
                    this.f18241b = new StringBuilder();
                    return;
                } else {
                    sb2.append((CharSequence) this.f18241b);
                    this.f18241b = new StringBuilder();
                    return;
                }
            }
            return;
        }
        if (((StringBuilder) this.f18241b).length() > 0) {
            byte[] bytes = ((StringBuilder) this.f18241b).toString().getBytes(charset2);
            this.f18241b = new StringBuilder();
            StringBuilder sb3 = (StringBuilder) this.f18242c;
            if (sb3 == null) {
                this.f18242c = new StringBuilder(new String(bytes, (Charset) this.f18243d));
            } else {
                sb3.append(new String(bytes, (Charset) this.f18243d));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [byte[], java.io.Serializable] */
    public b e() {
        int[] iArr;
        com.google.zxing.b bVar = (com.google.zxing.b) this.f18241b;
        int i3 = bVar.f11226a;
        int i10 = bVar.f11227b;
        b bVar2 = new b(i3, i10);
        if (((byte[]) this.f18242c).length < i3) {
            this.f18242c = new byte[i3];
        }
        int i11 = 0;
        while (true) {
            iArr = (int[]) this.f18243d;
            if (i11 >= 32) {
                break;
            }
            iArr[i11] = 0;
            i11++;
        }
        for (int i12 = 1; i12 < 5; i12++) {
            byte[] b3 = bVar.b((i10 * i12) / 5, (byte[]) this.f18242c);
            int i13 = (i3 * 4) / 5;
            for (int i14 = i3 / 5; i14 < i13; i14++) {
                int i15 = (b3[i14] & 255) >> 3;
                iArr[i15] = iArr[i15] + 1;
            }
        }
        int d5 = d(iArr);
        byte[] a3 = bVar.a();
        for (int i16 = 0; i16 < i10; i16++) {
            int i17 = i16 * i3;
            for (int i18 = 0; i18 < i3; i18++) {
                if ((a3[i17 + i18] & 255) < d5) {
                    bVar2.h(i18, i16);
                }
            }
        }
        return bVar2;
    }

    public String toString() {
        switch (this.f18240a) {
            case 1:
                c();
                StringBuilder sb2 = (StringBuilder) this.f18242c;
                return sb2 == null ? "" : sb2.toString();
            default:
                return super.toString();
        }
    }

    public f(int i3) {
        this.f18240a = 1;
        this.f18243d = StandardCharsets.ISO_8859_1;
        this.f18241b = new StringBuilder(i3);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [byte[], java.io.Serializable] */
    public f(com.google.zxing.b bVar) {
        this.f18240a = 0;
        this.f18240a = 0;
        this.f18241b = bVar;
        this.f18242c = e;
        this.f18243d = new int[32];
    }
}
