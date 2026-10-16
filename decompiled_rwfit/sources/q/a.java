package q;

import androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk;
import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedForVideoSnapshotQuirk;
import androidx.camera.core.impl.f1;
import androidx.camera.core.impl.i1;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f17604a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f17605b;

    public a(i1 i1Var, int i3) {
        switch (i3) {
            case 1:
                i1Var.getClass();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = i1Var.f1421a;
                int size = arrayList2.size();
                boolean z5 = false;
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList2.get(i10);
                    i10++;
                    f1 f1Var = (f1) obj;
                    if (CaptureIntentPreviewQuirk.class.isAssignableFrom(f1Var.getClass())) {
                        arrayList.add(f1Var);
                    }
                }
                int size2 = arrayList.size();
                int i11 = 0;
                while (true) {
                    if (i11 < size2) {
                        Object obj2 = arrayList.get(i11);
                        i11++;
                        if (((CaptureIntentPreviewQuirk) obj2).a()) {
                            z5 = true;
                        }
                    }
                }
                this.f17604a = z5;
                this.f17605b = i1Var.d(ImageCaptureFailedForVideoSnapshotQuirk.class);
                break;
            default:
                this.f17604a = i1Var.d(ImageCaptureFailWithAutoFlashQuirk.class);
                this.f17605b = p.a.f17285a.f(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class) != null;
                break;
        }
    }
}
