package h0;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.impl.h0;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.j0;
import t.f1;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public Size f14221a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f14222b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.camera.view.c f14223c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14224d = false;

    public e(FrameLayout frameLayout, androidx.camera.view.c cVar) {
        this.f14222b = frameLayout;
        this.f14223c = cVar;
    }

    public abstract View a();

    public abstract Bitmap b();

    public abstract void c();

    public abstract void d();

    public abstract void e(f1 f1Var, h0 h0Var);

    public final void f() {
        View a3 = a();
        if (a3 == null || !this.f14224d) {
            return;
        }
        FrameLayout frameLayout = this.f14222b;
        Size size = new Size(frameLayout.getWidth(), frameLayout.getHeight());
        int layoutDirection = frameLayout.getLayoutDirection();
        androidx.camera.view.c cVar = this.f14223c;
        cVar.getClass();
        if (size.getHeight() == 0 || size.getWidth() == 0) {
            a0.e("PreviewTransform", "Transform not applied due to PreviewView size: " + size);
            return;
        }
        if (cVar.f()) {
            if (a3 instanceof TextureView) {
                ((TextureView) a3).setTransform(cVar.d());
            } else {
                Display display = a3.getDisplay();
                boolean z5 = false;
                boolean z6 = (!cVar.f1595g || display == null || display.getRotation() == cVar.e) ? false : true;
                boolean z8 = cVar.f1595g;
                if (!z8) {
                    if ((!z8 ? cVar.f1592c : -j0.b(cVar.e)) != 0) {
                        z5 = true;
                    }
                }
                if (z6 || z5) {
                    a0.b("PreviewTransform", "Custom rotation not supported with SurfaceView/PERFORMANCE mode.");
                }
            }
            RectF e = cVar.e(size, layoutDirection);
            a3.setPivotX(0.0f);
            a3.setPivotY(0.0f);
            a3.setScaleX(e.width() / cVar.f1590a.getWidth());
            a3.setScaleY(e.height() / cVar.f1590a.getHeight());
            a3.setTranslationX(e.left - a3.getLeft());
            a3.setTranslationY(e.top - a3.getTop());
        }
    }

    public abstract ob.a g();
}
