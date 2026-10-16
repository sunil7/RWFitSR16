package t4;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f18523a = "0123456789abcdef".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f18524b = new char[64];

    /* renamed from: c, reason: collision with root package name */
    public static volatile Handler f18525c;

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int b(int i3, int i10, Bitmap.Config config) {
        int i11 = i3 * i10;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i12 = k.f18522a[config.ordinal()];
        int i13 = 1;
        if (i12 != 1) {
            i13 = 2;
            if (i12 != 2 && i12 != 3) {
                i13 = 4;
                if (i12 == 4) {
                    i13 = 8;
                }
            }
        }
        return i11 * i13;
    }

    public static int c(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static ArrayList d(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object obj : collection) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Handler e() {
        if (f18525c == null) {
            synchronized (l.class) {
                try {
                    if (f18525c == null) {
                        f18525c = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return f18525c;
    }

    public static int f(int i3, int i10) {
        return (i10 * 31) + i3;
    }

    public static int g(int i3, Object obj) {
        return f(obj == null ? 0 : obj.hashCode(), i3);
    }

    public static boolean h(int i3, int i10) {
        if (i3 > 0 || i3 == Integer.MIN_VALUE) {
            return i10 > 0 || i10 == Integer.MIN_VALUE;
        }
        return false;
    }

    public static void i(Runnable runnable) {
        e().post(runnable);
    }
}
