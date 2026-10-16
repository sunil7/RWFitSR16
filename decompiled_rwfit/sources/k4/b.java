package k4;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class b extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15468a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f15469b;

    public b(wa.b bVar) {
        this.f15469b = bVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        switch (this.f15468a) {
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        switch (this.f15468a) {
            case 0:
                return new c(this);
            default:
                return (wa.b) this.f15469b;
        }
    }

    public b(h hVar) {
        this.f15469b = hVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        switch (this.f15468a) {
            case 0:
                return new c(this);
            default:
                return super.newDrawable(resources);
        }
    }
}
