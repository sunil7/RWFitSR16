package f6;

import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public final class a2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f12687a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f12688b;

    /* renamed from: c, reason: collision with root package name */
    public final Button f12689c;

    /* renamed from: d, reason: collision with root package name */
    public final Button f12690d;
    public final SurfaceView e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f12691f;

    public a2(ConstraintLayout constraintLayout, ImageView imageView, Button button, Button button2, SurfaceView surfaceView, TextView textView) {
        this.f12687a = constraintLayout;
        this.f12688b = imageView;
        this.f12689c = button;
        this.f12690d = button2;
        this.e = surfaceView;
        this.f12691f = textView;
    }

    @Override // m2.a
    public final View b() {
        return this.f12687a;
    }
}
