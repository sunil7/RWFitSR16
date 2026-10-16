package com.example.test.presenter.main;

import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class x1 {
    public static boolean a(Integer num) {
        return num != null && num.intValue() == 1;
    }

    public static boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        return str2.equals(str);
    }
}
