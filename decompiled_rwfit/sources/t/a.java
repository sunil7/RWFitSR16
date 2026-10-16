package t;

import android.graphics.Matrix;
import android.media.Image;
import androidx.camera.core.impl.w1;

/* loaded from: classes.dex */
public final class a implements p0 {

    /* renamed from: a, reason: collision with root package name */
    public final Image f18259a;

    /* renamed from: b, reason: collision with root package name */
    public final n6.a[] f18260b;

    /* renamed from: c, reason: collision with root package name */
    public final g f18261c;

    public a(Image image) {
        this.f18259a = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.f18260b = new n6.a[planes.length];
            for (int i3 = 0; i3 < planes.length; i3++) {
                this.f18260b[i3] = new n6.a(planes[i3], 15);
            }
        } else {
            this.f18260b = new n6.a[0];
        }
        this.f18261c = new g(w1.f1513b, image.getTimestamp(), 0, new Matrix());
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f18259a.close();
    }

    @Override // t.p0
    public final int getHeight() {
        return this.f18259a.getHeight();
    }

    @Override // t.p0
    public final int getWidth() {
        return this.f18259a.getWidth();
    }

    @Override // t.p0
    public final int n() {
        return this.f18259a.getFormat();
    }

    @Override // t.p0
    public final n6.a[] o() {
        return this.f18260b;
    }

    @Override // t.p0
    public final n0 u() {
        return this.f18261c;
    }
}
