package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class hb {
    public static String a(String str) {
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            if (charAt >= 'A' && charAt <= 'Z') {
                char[] charArray = str.toCharArray();
                while (i3 < length) {
                    char c9 = charArray[i3];
                    if (c9 >= 'A' && c9 <= 'Z') {
                        charArray[i3] = (char) (c9 ^ ' ');
                    }
                    i3++;
                }
                return String.valueOf(charArray);
            }
            i3++;
        }
        return str;
    }
}
