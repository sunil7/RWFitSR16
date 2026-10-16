package androidx.appcompat.app;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;

/* loaded from: classes.dex */
public final class z extends ContentFrameLayout {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ c0 f577i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(c0 c0Var, g.d dVar) {
        super(dVar);
        this.f577i = c0Var;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f577i.u(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x10 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            if (x10 < -5 || y4 < -5 || x10 > getWidth() + 5 || y4 > getHeight() + 5) {
                c0 c0Var = this.f577i;
                c0Var.s(c0Var.z(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i3) {
        setBackgroundDrawable(pb.b(getContext(), i3));
    }
}
