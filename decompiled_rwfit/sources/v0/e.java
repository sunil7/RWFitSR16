package v0;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.MotionLabel;

/* loaded from: classes.dex */
public final class e extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19124a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MotionLabel f19125b;

    public /* synthetic */ e(MotionLabel motionLabel, int i3) {
        this.f19124a = i3;
        this.f19125b = motionLabel;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f19124a) {
            case 0:
                MotionLabel motionLabel = this.f19125b;
                outline.setRoundRect(0, 0, motionLabel.getWidth(), motionLabel.getHeight(), (Math.min(r9, r10) * motionLabel.f1819f) / 2.0f);
                break;
            default:
                MotionLabel motionLabel2 = this.f19125b;
                outline.setRoundRect(0, 0, motionLabel2.getWidth(), motionLabel2.getHeight(), motionLabel2.f1820g);
                break;
        }
    }
}
