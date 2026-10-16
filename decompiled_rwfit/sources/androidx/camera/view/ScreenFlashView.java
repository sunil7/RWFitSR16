package androidx.camera.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import h0.g;
import t.k0;

/* loaded from: classes.dex */
public final class ScreenFlashView extends View {

    /* renamed from: a, reason: collision with root package name */
    public Window f1581a;

    /* renamed from: b, reason: collision with root package name */
    public g f1582b;

    public ScreenFlashView(Context context) {
        this(context, null);
    }

    private float getBrightness() {
        Window window = this.f1581a;
        if (window != null) {
            return window.getAttributes().screenBrightness;
        }
        a0.b("ScreenFlashView", "setBrightness: mScreenFlashWindow is null!");
        return Float.NaN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrightness(float f2) {
        if (this.f1581a == null) {
            a0.b("ScreenFlashView", "setBrightness: mScreenFlashWindow is null!");
            return;
        }
        if (Float.isNaN(f2)) {
            a0.b("ScreenFlashView", "setBrightness: value is NaN!");
            return;
        }
        WindowManager.LayoutParams attributes = this.f1581a.getAttributes();
        attributes.screenBrightness = f2;
        this.f1581a.setAttributes(attributes);
        a0.a("ScreenFlashView", "Brightness set to " + attributes.screenBrightness);
    }

    private void setScreenFlashUiInfo(k0 k0Var) {
        a0.a("ScreenFlashView", "setScreenFlashUiInfo: mCameraController is null!");
    }

    public k0 getScreenFlash() {
        return this.f1582b;
    }

    public long getVisibilityRampUpAnimationDurationMillis() {
        return 1000L;
    }

    public void setController(h0.a aVar) {
        y5.a();
    }

    public void setScreenFlashWindow(Window window) {
        y5.a();
        if (this.f1581a != window) {
            this.f1582b = window == null ? null : new g(this);
        }
        this.f1581a = window;
        setScreenFlashUiInfo(getScreenFlash());
    }

    public ScreenFlashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScreenFlashView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3, 0);
        setBackgroundColor(-1);
        setAlpha(0.0f);
        setElevation(Float.MAX_VALUE);
    }
}
