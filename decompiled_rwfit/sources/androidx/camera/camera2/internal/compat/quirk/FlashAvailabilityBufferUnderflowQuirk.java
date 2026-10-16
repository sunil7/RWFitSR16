package androidx.camera.camera2.internal.compat.quirk;

import android.util.Pair;
import androidx.camera.core.impl.f1;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes.dex */
public class FlashAvailabilityBufferUnderflowQuirk implements f1 {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f1195a;

    static {
        HashSet hashSet = new HashSet();
        f1195a = hashSet;
        Locale locale = Locale.US;
        hashSet.add(new Pair("sprd".toLowerCase(locale), "lemp".toLowerCase(locale)));
        hashSet.add(new Pair("sprd".toLowerCase(locale), "DM20C".toLowerCase(locale)));
    }
}
