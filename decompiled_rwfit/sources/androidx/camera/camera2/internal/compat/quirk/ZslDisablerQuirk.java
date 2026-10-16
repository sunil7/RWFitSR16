package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.f1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ZslDisablerQuirk implements f1 {

    /* renamed from: a, reason: collision with root package name */
    public static final List f1214a = Arrays.asList("SM-F936", "SM-S901U", "SM-S908U", "SM-S908U1");

    /* renamed from: b, reason: collision with root package name */
    public static final List f1215b = Arrays.asList("MI 8");

    public static boolean b(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Build.MODEL.toUpperCase(Locale.US).startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
