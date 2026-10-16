package e5;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.dh.imagepick.preview.widgets.video.ExoVideoView2;

/* loaded from: classes.dex */
public final class d implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f12470a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f12471b;

    /* renamed from: c, reason: collision with root package name */
    public final ExoVideoView2 f12472c;

    public d(FrameLayout frameLayout, ImageView imageView, ExoVideoView2 exoVideoView2) {
        this.f12470a = frameLayout;
        this.f12471b = imageView;
        this.f12472c = exoVideoView2;
    }

    @Override // m2.a
    public final View b() {
        return this.f12470a;
    }
}
