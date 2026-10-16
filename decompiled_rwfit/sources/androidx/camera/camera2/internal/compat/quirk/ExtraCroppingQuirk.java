package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.SurfaceConfig$ConfigType;
import androidx.camera.core.impl.f1;
import java.util.HashMap;
import java.util.Locale;
import p.b;

/* loaded from: classes.dex */
public class ExtraCroppingQuirk implements f1 {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f1190a;

    static {
        HashMap hashMap = new HashMap();
        f1190a = hashMap;
        hashMap.put("SM-T580", null);
        hashMap.put("SM-J710MN", new Range(21, 26));
        hashMap.put("SM-A320FL", null);
        hashMap.put("SM-G570M", null);
        hashMap.put("SM-G610F", null);
        hashMap.put("SM-G610M", new Range(21, 26));
    }

    public static Size b(SurfaceConfig$ConfigType surfaceConfig$ConfigType) {
        if (!c()) {
            return null;
        }
        int i3 = b.f17286a[surfaceConfig$ConfigType.ordinal()];
        if (i3 == 1) {
            return new Size(1920, 1080);
        }
        if (i3 == 2) {
            return new Size(1280, 720);
        }
        if (i3 != 3) {
            return null;
        }
        return new Size(3264, 1836);
    }

    public static boolean c() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        HashMap hashMap = f1190a;
        String str = Build.MODEL;
        Locale locale = Locale.US;
        if (!hashMap.containsKey(str.toUpperCase(locale))) {
            return false;
        }
        Range range = (Range) hashMap.get(str.toUpperCase(locale));
        if (range == null) {
            return true;
        }
        return range.contains((Range) Integer.valueOf(Build.VERSION.SDK_INT));
    }
}
