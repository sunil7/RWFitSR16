package v0;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.MotionButton;

/* loaded from: classes.dex */
public final class d extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19122a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MotionButton f19123b;

    public /* synthetic */ d(MotionButton motionButton, int i3) {
        this.f19122a = i3;
        this.f19123b = motionButton;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f19122a) {
            case 0:
                MotionButton motionButton = this.f19123b;
                outline.setRoundRect(0, 0, motionButton.getWidth(), motionButton.getHeight(), (Math.min(r9, r10) * motionButton.f1811d) / 2.0f);
                break;
            default:
                MotionButton motionButton2 = this.f19123b;
                outline.setRoundRect(0, 0, motionButton2.getWidth(), motionButton2.getHeight(), motionButton2.e);
                break;
        }
    }
}
