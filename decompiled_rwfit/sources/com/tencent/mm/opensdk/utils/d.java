package com.tencent.mm.opensdk.utils;

/* loaded from: classes2.dex */
public final class d {
    public static boolean a(int i3) {
        return i3 == 36 || i3 == 46;
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }

    public static int c(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return Integer.parseInt(str);
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }
}
