package r5;

import android.util.Log;
import org.greenrobot.greendao.database.Database;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static int a(int i3, String str) {
        return String.valueOf(str).length() + i3;
    }

    public static String b(int i3, String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(i3);
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        return sb2.toString();
    }

    public static String c(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String d(String str, boolean z5) {
        return str + z5;
    }

    public static String e(StringBuilder sb2, int i3, String str) {
        sb2.append(i3);
        sb2.append(str);
        return sb2.toString();
    }

    public static String f(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    public static StringBuilder g(int i3, String str, String str2, String str3, String str4) {
        StringBuilder sb2 = new StringBuilder(i3);
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
        return sb2;
    }

    public static void h(int i3, String str, String str2) {
        Log.e(str2, str + i3);
    }

    public static /* synthetic */ void i(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void j(StringBuilder sb2, String str, String str2, Database database) {
        sb2.append(str);
        sb2.append(str2);
        database.execSQL(sb2.toString());
    }
}
