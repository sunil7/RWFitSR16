package eb;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes.dex */
public final class s extends u {

    /* renamed from: h, reason: collision with root package name */
    public static final RectF f12569h = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final float f12570b;

    /* renamed from: c, reason: collision with root package name */
    public final float f12571c;

    /* renamed from: d, reason: collision with root package name */
    public final float f12572d;
    public final float e;

    /* renamed from: f, reason: collision with root package name */
    public float f12573f;

    /* renamed from: g, reason: collision with root package name */
    public float f12574g;

    public s(float f2, float f10, float f11, float f12) {
        this.f12570b = f2;
        this.f12571c = f10;
        this.f12572d = f11;
        this.e = f12;
    }

    @Override // eb.u
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f12577a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        RectF rectF = f12569h;
        rectF.set(this.f12570b, this.f12571c, this.f12572d, this.e);
        path.arcTo(rectF, this.f12573f, this.f12574g, false);
        path.transform(matrix);
    }
}
