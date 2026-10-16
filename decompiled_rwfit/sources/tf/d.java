package tf;

import android.widget.FrameLayout;
import com.otaliastudios.cameraview.overlay.Overlay$Target;

/* loaded from: classes2.dex */
public final class d extends FrameLayout.LayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public boolean f18625a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f18626b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18627c;

    public final boolean a(Overlay$Target overlay$Target) {
        if (overlay$Target == Overlay$Target.PREVIEW && this.f18625a) {
            return true;
        }
        if (overlay$Target == Overlay$Target.VIDEO_SNAPSHOT && this.f18627c) {
            return true;
        }
        return overlay$Target == Overlay$Target.PICTURE_SNAPSHOT && this.f18626b;
    }

    public final String toString() {
        return d.class.getName() + "[drawOnPreview:" + this.f18625a + ",drawOnPictureSnapshot:" + this.f18626b + ",drawOnVideoSnapshot:" + this.f18627c + "]";
    }
}
