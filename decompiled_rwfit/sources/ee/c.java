package ee;

import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f12596a = new SimpleDateFormat("yyyyMMddHHmmss.SSS", Locale.getDefault());

    public static String a(String str, String str2) {
        Locale locale = Locale.ENGLISH;
        return l0.p("[", str, "] >>> ", str2);
    }

    public static void b(int i3, String str, String str2) {
        String n4 = l0.n("ota:", str);
        if (i3 == 1) {
            Log.v(n4, str2);
        } else if (i3 == 2) {
            Log.d(n4, str2);
        } else if (i3 == 3) {
            Log.i(n4, str2);
        } else if (i3 == 4) {
            Log.w(n4, str2);
        } else if (i3 != 5) {
            return;
        } else {
            Log.e(n4, str2);
        }
        f12596a.format(Calendar.getInstance().getTime());
    }

    public static void c(String str, String str2, String str3) {
        b(2, str, a(str2, str3));
    }

    public static void d(String str, String str2, String str3) {
        b(5, str, a(str2, str3));
    }

    public static void e(String str, String str2, String str3) {
        b(3, str, a(str2, str3));
    }

    public static void f(String str, String str2, String str3) {
        b(4, str, a(str2, str3));
    }
}
