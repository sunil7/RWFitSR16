package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.f1;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class ImageCaptureFailedWhenVideoCaptureIsBoundQuirk implements CaptureIntentPreviewQuirk, f1 {
    @Override // androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk
    public final boolean a() {
        String str = Build.BRAND;
        if ("blu".equalsIgnoreCase(str) && "studio x10".equalsIgnoreCase(Build.MODEL)) {
            return true;
        }
        if ("itel".equalsIgnoreCase(str) && "itel w6004".equalsIgnoreCase(Build.MODEL)) {
            return true;
        }
        if (Const.BRAND_VIVO.equalsIgnoreCase(str) && "vivo 1805".equalsIgnoreCase(Build.MODEL)) {
            return true;
        }
        return "positivo".equalsIgnoreCase(str) && "twist 2 pro".equalsIgnoreCase(Build.MODEL);
    }
}
