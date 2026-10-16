package h0;

import android.animation.ValueAnimator;
import androidx.camera.view.ScreenFlashView;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import t.k0;

/* loaded from: classes.dex */
public final class g implements k0 {

    /* renamed from: a, reason: collision with root package name */
    public ValueAnimator f14228a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScreenFlashView f14229b;

    public g(ScreenFlashView screenFlashView) {
        this.f14229b = screenFlashView;
    }

    @Override // t.k0
    public final void clear() {
        a0.a("ScreenFlashView", "ScreenFlash#clearScreenFlashUi");
        ValueAnimator valueAnimator = this.f14228a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f14228a = null;
        }
        ScreenFlashView screenFlashView = this.f14229b;
        screenFlashView.setAlpha(0.0f);
        screenFlashView.setBrightness(0.0f);
    }
}
