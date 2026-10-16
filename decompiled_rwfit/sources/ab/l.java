package ab;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class l extends Drawable implements Animatable {

    /* renamed from: k, reason: collision with root package name */
    public static final g f182k = new g(2, Float.class, "growFraction");

    /* renamed from: a, reason: collision with root package name */
    public final Context f183a;

    /* renamed from: b, reason: collision with root package name */
    public final d f184b;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f186d;
    public ObjectAnimator e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f187f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f188g;

    /* renamed from: h, reason: collision with root package name */
    public float f189h;

    /* renamed from: j, reason: collision with root package name */
    public int f191j;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f190i = new Paint();

    /* renamed from: c, reason: collision with root package name */
    public a f185c = new a();

    public l(Context context, d dVar) {
        this.f183a = context;
        this.f184b = dVar;
        setAlpha(255);
    }

    public final float b() {
        d dVar = this.f184b;
        if (dVar.e == 0 && dVar.f155f == 0) {
            return 1.0f;
        }
        return this.f189h;
    }

    public final boolean c() {
        ObjectAnimator objectAnimator = this.e;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    public final boolean d() {
        ObjectAnimator objectAnimator = this.f186d;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    public final boolean e(boolean z5, boolean z6, boolean z8) {
        a aVar = this.f185c;
        ContentResolver contentResolver = this.f183a.getContentResolver();
        aVar.getClass();
        return f(z5, z6, z8 && Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) > 0.0f);
    }

    public boolean f(boolean z5, boolean z6, boolean z8) {
        int i3 = 1;
        int i10 = 0;
        ObjectAnimator objectAnimator = this.f186d;
        g gVar = f182k;
        if (objectAnimator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, gVar, 0.0f, 1.0f);
            this.f186d = ofFloat;
            ofFloat.setDuration(500L);
            this.f186d.setInterpolator(ja.a.f15384b);
            ObjectAnimator objectAnimator2 = this.f186d;
            if (objectAnimator2 != null && objectAnimator2.isRunning()) {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
            this.f186d = objectAnimator2;
            objectAnimator2.addListener(new k(this, i10));
        }
        if (this.e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, gVar, 1.0f, 0.0f);
            this.e = ofFloat2;
            ofFloat2.setDuration(500L);
            this.e.setInterpolator(ja.a.f15384b);
            ObjectAnimator objectAnimator3 = this.e;
            if (objectAnimator3 != null && objectAnimator3.isRunning()) {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
            this.e = objectAnimator3;
            objectAnimator3.addListener(new k(this, i3));
        }
        if (isVisible() || z5) {
            ObjectAnimator objectAnimator4 = z5 ? this.f186d : this.e;
            if (!z8) {
                if (objectAnimator4.isRunning()) {
                    objectAnimator4.end();
                } else {
                    boolean z10 = this.f188g;
                    this.f188g = true;
                    new ValueAnimator[]{objectAnimator4}[0].end();
                    this.f188g = z10;
                }
                return super.setVisible(z5, false);
            }
            if (!z8 || !objectAnimator4.isRunning()) {
                boolean z11 = !z5 || super.setVisible(z5, false);
                d dVar = this.f184b;
                if (!z5 ? dVar.f155f != 0 : dVar.e != 0) {
                    boolean z12 = this.f188g;
                    this.f188g = true;
                    new ValueAnimator[]{objectAnimator4}[0].end();
                    this.f188g = z12;
                    return z11;
                }
                if (z6 || !objectAnimator4.isPaused()) {
                    objectAnimator4.start();
                    return z11;
                }
                objectAnimator4.resume();
                return z11;
            }
        }
        return false;
    }

    public final void g(c cVar) {
        ArrayList arrayList = this.f187f;
        if (arrayList == null || !arrayList.contains(cVar)) {
            return;
        }
        this.f187f.remove(cVar);
        if (this.f187f.isEmpty()) {
            this.f187f = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f191j;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return d() || c();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        this.f191j = i3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f190i.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z5, boolean z6) {
        return e(z5, z6, true);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        f(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        f(false, true, false);
    }
}
