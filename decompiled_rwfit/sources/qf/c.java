package qf;

import android.util.Range;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ef.b f17938a = ef.b.a("FpsRangeValidator");

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f17939b;

    static {
        HashMap hashMap = new HashMap();
        f17939b = hashMap;
        hashMap.put("Google Pixel 4", Arrays.asList(new Range(15, 60)));
        hashMap.put("Google Pixel 4a", Arrays.asList(new Range(15, 60)));
        hashMap.put("Google Pixel 4 XL", Arrays.asList(new Range(15, 60)));
    }
}
