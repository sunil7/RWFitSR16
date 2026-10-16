package fd;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final float[][] f13572a = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2787, 8);

    static {
        int i3;
        for (int i10 = 0; i10 < 2787; i10++) {
            int i11 = ed.a.f12589b[i10];
            int i12 = i11 & 1;
            int i13 = 0;
            while (i13 < 8) {
                float f2 = 0.0f;
                while (true) {
                    i3 = i11 & 1;
                    if (i3 == i12) {
                        f2 += 1.0f;
                        i11 >>= 1;
                    }
                }
                f13572a[i10][7 - i13] = f2 / 17.0f;
                i13++;
                i12 = i3;
            }
        }
    }
}
