package j2;

import android.os.Build;

/* loaded from: classes.dex */
public abstract class l0 {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f15253a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f15254b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f15255c;

    static {
        int i3 = Build.VERSION.SDK_INT;
        f15253a = true;
        f15254b = true;
        f15255c = i3 >= 28;
    }
}
