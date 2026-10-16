package sc;

import com.google.zxing.common.CharacterSetECI;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f18237c = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final CharsetEncoder[] f18238a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18239b;

    static {
        String[] strArr = {"IBM437", "ISO-8859-2", "ISO-8859-3", "ISO-8859-4", "ISO-8859-5", "ISO-8859-6", "ISO-8859-7", "ISO-8859-8", "ISO-8859-9", "ISO-8859-10", "ISO-8859-11", "ISO-8859-13", "ISO-8859-14", "ISO-8859-15", "ISO-8859-16", "windows-1250", "windows-1251", "windows-1252", "windows-1256", "Shift_JIS"};
        for (int i3 = 0; i3 < 20; i3++) {
            String str = strArr[i3];
            if (CharacterSetECI.getCharacterSetECIByName(str) != null) {
                try {
                    f18237c.add(Charset.forName(str).newEncoder());
                } catch (UnsupportedCharsetException unused) {
                }
            }
        }
    }

    public e(String str, Charset charset) {
        int i3;
        boolean z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(StandardCharsets.ISO_8859_1.newEncoder());
        int i10 = 0;
        boolean z6 = charset != null && charset.name().startsWith("UTF");
        int i11 = 0;
        while (true) {
            i3 = -1;
            if (i11 >= str.length()) {
                break;
            }
            int size = arrayList.size();
            int i12 = 0;
            while (i12 < size) {
                Object obj = arrayList.get(i12);
                i12++;
                CharsetEncoder charsetEncoder = (CharsetEncoder) obj;
                char charAt = str.charAt(i11);
                if (charAt == 65535 || charsetEncoder.canEncode(charAt)) {
                    z5 = true;
                    break;
                }
            }
            z5 = false;
            if (!z5) {
                ArrayList arrayList2 = f18237c;
                int size2 = arrayList2.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size2) {
                        break;
                    }
                    Object obj2 = arrayList2.get(i13);
                    i13++;
                    CharsetEncoder charsetEncoder2 = (CharsetEncoder) obj2;
                    if (charsetEncoder2.canEncode(str.charAt(i11))) {
                        arrayList.add(charsetEncoder2);
                        z5 = true;
                        break;
                    }
                }
            }
            if (!z5) {
                z6 = true;
            }
            i11++;
        }
        if (arrayList.size() != 1 || z6) {
            this.f18238a = new CharsetEncoder[arrayList.size() + 2];
            int size3 = arrayList.size();
            int i14 = 0;
            int i15 = 0;
            while (i15 < size3) {
                Object obj3 = arrayList.get(i15);
                i15++;
                this.f18238a[i14] = (CharsetEncoder) obj3;
                i14++;
            }
            this.f18238a[i14] = StandardCharsets.UTF_8.newEncoder();
            this.f18238a[i14 + 1] = StandardCharsets.UTF_16BE.newEncoder();
        } else {
            this.f18238a = new CharsetEncoder[]{(CharsetEncoder) arrayList.get(0)};
        }
        if (charset != null) {
            while (true) {
                CharsetEncoder[] charsetEncoderArr = this.f18238a;
                if (i10 < charsetEncoderArr.length) {
                    if (charsetEncoderArr[i10] != null && charset.name().equals(this.f18238a[i10].charset().name())) {
                        i3 = i10;
                        break;
                    }
                    i10++;
                } else {
                    break;
                }
            }
        }
        this.f18239b = i3;
    }
}
