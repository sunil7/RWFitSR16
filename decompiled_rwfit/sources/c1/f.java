package c1;

import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.internal.mlkit_vision_barcode.d1;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final d1 f3359a;

    /* renamed from: b, reason: collision with root package name */
    public static final m0.f f3360b;

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            f3359a = new i();
        } else if (i3 >= 28) {
            f3359a = new h();
        } else {
            f3359a = new g();
        }
        f3360b = new m0.f(16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
    
        if (r5.equals(r9) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface a(android.content.Context r12, b1.e r13, android.content.res.Resources r14, int r15, java.lang.String r16, int r17, int r18, b1.b r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.f.a(android.content.Context, b1.e, android.content.res.Resources, int, java.lang.String, int, int, b1.b, boolean):android.graphics.Typeface");
    }

    public static String b(Resources resources, int i3, String str, int i10, int i11) {
        return resources.getResourcePackageName(i3) + '-' + str + '-' + i10 + '-' + i3 + '-' + i11;
    }
}
