package f6;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.otaliastudios.cameraview.CameraView;

/* loaded from: classes.dex */
public final class q2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f13259a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f13260b;

    /* renamed from: c, reason: collision with root package name */
    public final CameraView f13261c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f13262d;
    public final ImageView e;

    public q2(ConstraintLayout constraintLayout, ImageView imageView, CameraView cameraView, LinearLayout linearLayout, ImageView imageView2) {
        this.f13259a = constraintLayout;
        this.f13260b = imageView;
        this.f13261c = cameraView;
        this.f13262d = linearLayout;
        this.e = imageView2;
    }

    @Override // m2.a
    public final View b() {
        return this.f13259a;
    }
}
