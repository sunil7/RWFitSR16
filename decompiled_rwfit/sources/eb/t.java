package eb;

import android.graphics.Matrix;
import android.graphics.Path;

/* loaded from: classes.dex */
public final class t extends u {

    /* renamed from: b, reason: collision with root package name */
    public float f12575b;

    /* renamed from: c, reason: collision with root package name */
    public float f12576c;

    @Override // eb.u
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f12577a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f12575b, this.f12576c);
        path.transform(matrix);
    }
}
