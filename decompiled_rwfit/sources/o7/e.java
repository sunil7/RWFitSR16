package o7;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class e {
    private Object mData;
    private Drawable mIcon;

    /* renamed from: y, reason: collision with root package name */
    private float f16825y;

    public e() {
        this.f16825y = 0.0f;
        this.mData = null;
        this.mIcon = null;
    }

    public final Object a() {
        return this.mData;
    }

    public final Drawable b() {
        return this.mIcon;
    }

    public float d() {
        return this.f16825y;
    }

    public final void h(Parcelable parcelable) {
        this.mData = parcelable;
    }

    public final void i(float f2) {
        this.f16825y = f2;
    }

    public e(float f2) {
        this.mData = null;
        this.mIcon = null;
        this.f16825y = f2;
    }
}
