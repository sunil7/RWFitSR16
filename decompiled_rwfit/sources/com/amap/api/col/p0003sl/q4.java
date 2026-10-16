package com.amap.api.col.p0003sl;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.material.timepicker.TimeModel;
import java.util.Locale;
import java.util.Random;

/* loaded from: classes.dex */
public class q4 {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f4890a;

        public a(String str, int i3) {
            this.f4890a = a(str, i3, str.length());
        }

        public int a(int i3) {
            return (int) (((i3 * 1103515245) + 12345) & 2147483647L);
        }

        public String a(String str, int i3, int i10) {
            StringBuffer stringBuffer = new StringBuffer(str);
            int length = str.length();
            for (int i11 = 0; i11 < i10; i11++) {
                int a3 = a(i3);
                int i12 = a3 % length;
                i3 = a(a3);
                int i13 = i3 % length;
                char charAt = stringBuffer.charAt(i12);
                stringBuffer.setCharAt(i12, stringBuffer.charAt(i13));
                stringBuffer.setCharAt(i13, charAt);
            }
            return stringBuffer.toString();
        }

        public String a(int i3, String str) {
            StringBuilder sb2 = new StringBuilder();
            int length = this.f4890a.length();
            int length2 = str.length();
            for (int i10 = 0; i10 < length2; i10++) {
                char charAt = str.charAt(i10);
                this.f4890a.getClass();
                int indexOf = this.f4890a.indexOf(charAt);
                if (indexOf < 0) {
                    break;
                }
                this.f4890a.getClass();
                sb2.append(this.f4890a.charAt(((indexOf + i3) + i10) % length));
            }
            if (sb2.length() == length2) {
                return sb2.toString();
            }
            return null;
        }
    }

    public static String a() {
        Random random = new Random();
        int nextInt = random.nextInt(10);
        Locale locale = Locale.US;
        String format = String.format(locale, "%05d", Integer.valueOf(nextInt));
        int nextInt2 = random.nextInt(10);
        int nextInt3 = random.nextInt(100);
        StringBuilder t8 = l0.t(new a("0123456789", nextInt3).a(nextInt2, format));
        t8.append(String.format(locale, "%01d", Integer.valueOf(nextInt2)));
        t8.append(String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(nextInt3)));
        return t8.toString();
    }
}
