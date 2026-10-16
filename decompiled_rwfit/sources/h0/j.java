package h0;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.impl.h0;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import t.f1;

/* loaded from: classes.dex */
public final class j extends e {
    public SurfaceView e;

    /* renamed from: f, reason: collision with root package name */
    public final i f14238f;

    public j(FrameLayout frameLayout, androidx.camera.view.c cVar) {
        super(frameLayout, cVar);
        this.f14238f = new i(this);
    }

    @Override // h0.e
    public final View a() {
        return this.e;
    }

    @Override // h0.e
    public final Bitmap b() {
        SurfaceView surfaceView = this.e;
        if (surfaceView == null || surfaceView.getHolder().getSurface() == null || !this.e.getHolder().getSurface().isValid()) {
            return null;
        }
        final Semaphore semaphore = new Semaphore(0);
        Bitmap createBitmap = Bitmap.createBitmap(this.e.getWidth(), this.e.getHeight(), Bitmap.Config.ARGB_8888);
        HandlerThread handlerThread = new HandlerThread("pixelCopyRequest Thread");
        handlerThread.start();
        PixelCopy.request(this.e, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: h0.h
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i3) {
                if (i3 == 0) {
                    a0.a("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() succeeded");
                } else {
                    a0.b("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() failed with error " + i3);
                }
                semaphore.release();
            }
        }, new Handler(handlerThread.getLooper()));
        try {
            if (!semaphore.tryAcquire(1, 100L, TimeUnit.MILLISECONDS)) {
                a0.b("SurfaceViewImpl", "Timed out while trying to acquire screenshot.");
            }
            return createBitmap;
        } catch (InterruptedException e) {
            a0.c("SurfaceViewImpl", "Interrupted while trying to acquire screenshot.", e);
            return createBitmap;
        } finally {
            handlerThread.quitSafely();
        }
    }

    @Override // h0.e
    public final void c() {
    }

    @Override // h0.e
    public final void d() {
    }

    @Override // h0.e
    public final void e(f1 f1Var, h0 h0Var) {
        SurfaceView surfaceView = this.e;
        boolean equals = Objects.equals(this.f14221a, f1Var.f18320b);
        if (surfaceView == null || !equals) {
            Size size = f1Var.f18320b;
            this.f14221a = size;
            FrameLayout frameLayout = this.f14222b;
            size.getClass();
            SurfaceView surfaceView2 = new SurfaceView(frameLayout.getContext());
            this.e = surfaceView2;
            surfaceView2.setLayoutParams(new FrameLayout.LayoutParams(this.f14221a.getWidth(), this.f14221a.getHeight()));
            frameLayout.removeAllViews();
            frameLayout.addView(this.e);
            this.e.getHolder().addCallback(this.f14238f);
        }
        Executor c9 = a1.g.c(this.e.getContext());
        androidx.activity.b bVar = new androidx.activity.b(h0Var, 28);
        n0.j jVar = f1Var.f18327j.f1607c;
        if (jVar != null) {
            jVar.a(bVar, c9);
        }
        this.e.post(new androidx.camera.camera2.internal.compat.h(this, 10, f1Var, h0Var));
    }

    @Override // h0.e
    public final ob.a g() {
        return x.k.f19707c;
    }
}
