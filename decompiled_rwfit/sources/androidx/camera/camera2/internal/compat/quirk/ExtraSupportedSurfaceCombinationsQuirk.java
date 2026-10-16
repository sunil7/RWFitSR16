package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.SurfaceConfig$ConfigSize;
import androidx.camera.core.impl.SurfaceConfig$ConfigType;
import androidx.camera.core.impl.f1;
import androidx.camera.core.impl.i;
import androidx.camera.core.impl.v1;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public class ExtraSupportedSurfaceCombinationsQuirk implements f1 {

    /* renamed from: a, reason: collision with root package name */
    public static final v1 f1191a;

    /* renamed from: b, reason: collision with root package name */
    public static final v1 f1192b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashSet f1193c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashSet f1194d;

    static {
        v1 v1Var = new v1();
        SurfaceConfig$ConfigType surfaceConfig$ConfigType = SurfaceConfig$ConfigType.YUV;
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.VGA;
        v1Var.a(i.a(surfaceConfig$ConfigType, surfaceConfig$ConfigSize));
        SurfaceConfig$ConfigType surfaceConfig$ConfigType2 = SurfaceConfig$ConfigType.PRIV;
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize2 = SurfaceConfig$ConfigSize.PREVIEW;
        v1Var.a(i.a(surfaceConfig$ConfigType2, surfaceConfig$ConfigSize2));
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize3 = SurfaceConfig$ConfigSize.MAXIMUM;
        l0.B(surfaceConfig$ConfigType, surfaceConfig$ConfigSize3, 0L, v1Var);
        f1191a = v1Var;
        v1 v1Var2 = new v1();
        v1Var2.a(new i(surfaceConfig$ConfigType2, surfaceConfig$ConfigSize2, 0L));
        v1Var2.a(new i(surfaceConfig$ConfigType2, surfaceConfig$ConfigSize, 0L));
        l0.B(surfaceConfig$ConfigType, surfaceConfig$ConfigSize3, 0L, v1Var2);
        f1192b = v1Var2;
        f1193c = new HashSet(Arrays.asList("PIXEL 6", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO"));
        f1194d = new HashSet(Arrays.asList("SM-S921", "SC-51E", "SCG25", "SM-S926", "SM-S928", "SC-52E", "SCG26"));
    }

    public static boolean b() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        String upperCase = Build.MODEL.toUpperCase(Locale.US);
        Iterator it = f1194d.iterator();
        while (it.hasNext()) {
            if (upperCase.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
