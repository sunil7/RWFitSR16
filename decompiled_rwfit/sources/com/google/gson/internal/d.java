package com.google.gson.internal;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f11179a;

    static {
        int i3;
        String property = System.getProperty("java.version");
        try {
            String[] split = property.split("[._]");
            i3 = Integer.parseInt(split[0]);
            if (i3 == 1 && split.length > 1) {
                i3 = Integer.parseInt(split[1]);
            }
        } catch (NumberFormatException unused) {
            i3 = -1;
        }
        if (i3 == -1) {
            try {
                StringBuilder sb2 = new StringBuilder();
                for (int i10 = 0; i10 < property.length(); i10++) {
                    char charAt = property.charAt(i10);
                    if (!Character.isDigit(charAt)) {
                        break;
                    }
                    sb2.append(charAt);
                }
                i3 = Integer.parseInt(sb2.toString());
            } catch (NumberFormatException unused2) {
                i3 = -1;
            }
        }
        if (i3 == -1) {
            i3 = 6;
        }
        f11179a = i3;
    }
}
