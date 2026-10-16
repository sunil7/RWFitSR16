package t;

import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class c implements androidx.camera.core.impl.r0 {

    /* renamed from: a, reason: collision with root package name */
    public final ImageReader f18277a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f18278b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public boolean f18279c = true;

    public c(ImageReader imageReader) {
        this.f18277a = imageReader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnImageAvailableListener$0(androidx.camera.core.impl.q0 q0Var) {
        q0Var.c(this);
    }

    @Override // androidx.camera.core.impl.r0
    public final void close() {
        synchronized (this.f18278b) {
            this.f18277a.close();
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final Surface e() {
        Surface surface;
        synchronized (this.f18278b) {
            surface = this.f18277a.getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.r0, wa.f
    public final int getHeight() {
        int height;
        synchronized (this.f18278b) {
            height = this.f18277a.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.r0, wa.f
    public final int getWidth() {
        int width;
        synchronized (this.f18278b) {
            width = this.f18277a.getWidth();
        }
        return width;
    }

    @Override // androidx.camera.core.impl.r0
    public final p0 k() {
        Image image;
        synchronized (this.f18278b) {
            try {
                image = this.f18277a.acquireLatestImage();
            } catch (RuntimeException e) {
                if (!"ImageReaderContext is not initialized".equals(e.getMessage())) {
                    throw e;
                }
                image = null;
            }
            if (image == null) {
                return null;
            }
            return new a(image);
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final int m() {
        int imageFormat;
        synchronized (this.f18278b) {
            imageFormat = this.f18277a.getImageFormat();
        }
        return imageFormat;
    }

    @Override // androidx.camera.core.impl.r0
    public final void o() {
        synchronized (this.f18278b) {
            this.f18279c = true;
            this.f18277a.setOnImageAvailableListener(null, null);
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final int q() {
        int maxImages;
        synchronized (this.f18278b) {
            maxImages = this.f18277a.getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.r0
    public final p0 r() {
        Image image;
        synchronized (this.f18278b) {
            try {
                image = this.f18277a.acquireNextImage();
            } catch (RuntimeException e) {
                if (!"ImageReaderContext is not initialized".equals(e.getMessage())) {
                    throw e;
                }
                image = null;
            }
            if (image == null) {
                return null;
            }
            return new a(image);
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final void t(final androidx.camera.core.impl.q0 q0Var, final Executor executor) {
        synchronized (this.f18278b) {
            this.f18279c = false;
            this.f18277a.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: t.b
                @Override // android.media.ImageReader.OnImageAvailableListener
                public final void onImageAvailable(ImageReader imageReader) {
                    c cVar = c.this;
                    Executor executor2 = executor;
                    androidx.camera.core.impl.q0 q0Var2 = q0Var;
                    synchronized (cVar.f18278b) {
                        try {
                            if (!cVar.f18279c) {
                                executor2.execute(new n5.a(4, cVar, q0Var2));
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            }, v.c.a());
        }
    }
}
