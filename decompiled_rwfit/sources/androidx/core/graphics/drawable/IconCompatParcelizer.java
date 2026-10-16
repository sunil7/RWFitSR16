package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import l2.b;
import l2.c;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(b bVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1915a = bVar.f(iconCompat.f1915a, 1);
        byte[] bArr = iconCompat.f1917c;
        if (bVar.e(2)) {
            Parcel parcel = ((c) bVar).e;
            int readInt = parcel.readInt();
            if (readInt < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[readInt];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f1917c = bArr;
        iconCompat.f1918d = bVar.g(iconCompat.f1918d, 3);
        iconCompat.e = bVar.f(iconCompat.e, 4);
        iconCompat.f1919f = bVar.f(iconCompat.f1919f, 5);
        iconCompat.f1920g = (ColorStateList) bVar.g(iconCompat.f1920g, 6);
        String str = iconCompat.f1922i;
        if (bVar.e(7)) {
            str = ((c) bVar).e.readString();
        }
        iconCompat.f1922i = str;
        String str2 = iconCompat.f1923j;
        if (bVar.e(8)) {
            str2 = ((c) bVar).e.readString();
        }
        iconCompat.f1923j = str2;
        iconCompat.f1921h = PorterDuff.Mode.valueOf(iconCompat.f1922i);
        switch (iconCompat.f1915a) {
            case -1:
                Parcelable parcelable = iconCompat.f1918d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f1916b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f1918d;
                if (parcelable2 != null) {
                    iconCompat.f1916b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f1917c;
                iconCompat.f1916b = bArr3;
                iconCompat.f1915a = 3;
                iconCompat.e = 0;
                iconCompat.f1919f = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.f1917c, Charset.forName("UTF-16"));
                iconCompat.f1916b = str3;
                if (iconCompat.f1915a == 2 && iconCompat.f1923j == null) {
                    iconCompat.f1923j = str3.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f1916b = iconCompat.f1917c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, b bVar) {
        bVar.getClass();
        iconCompat.f1922i = iconCompat.f1921h.name();
        switch (iconCompat.f1915a) {
            case -1:
                iconCompat.f1918d = (Parcelable) iconCompat.f1916b;
                break;
            case 1:
            case 5:
                iconCompat.f1918d = (Parcelable) iconCompat.f1916b;
                break;
            case 2:
                iconCompat.f1917c = ((String) iconCompat.f1916b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f1917c = (byte[]) iconCompat.f1916b;
                break;
            case 4:
            case 6:
                iconCompat.f1917c = iconCompat.f1916b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i3 = iconCompat.f1915a;
        if (-1 != i3) {
            bVar.j(i3, 1);
        }
        byte[] bArr = iconCompat.f1917c;
        if (bArr != null) {
            bVar.i(2);
            int length = bArr.length;
            Parcel parcel = ((c) bVar).e;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f1918d;
        if (parcelable != null) {
            bVar.k(parcelable, 3);
        }
        int i10 = iconCompat.e;
        if (i10 != 0) {
            bVar.j(i10, 4);
        }
        int i11 = iconCompat.f1919f;
        if (i11 != 0) {
            bVar.j(i11, 5);
        }
        ColorStateList colorStateList = iconCompat.f1920g;
        if (colorStateList != null) {
            bVar.k(colorStateList, 6);
        }
        String str = iconCompat.f1922i;
        if (str != null) {
            bVar.i(7);
            ((c) bVar).e.writeString(str);
        }
        String str2 = iconCompat.f1923j;
        if (str2 != null) {
            bVar.i(8);
            ((c) bVar).e.writeString(str2);
        }
    }
}
