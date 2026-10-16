package ab;

import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public final d f192a;

    /* renamed from: b, reason: collision with root package name */
    public l f193b;

    public m(d dVar) {
        this.f192a = dVar;
    }

    public abstract void a(Canvas canvas, float f2);

    public abstract void b(Canvas canvas, Paint paint, float f2, float f10, int i3);

    public abstract void c(Canvas canvas, Paint paint);

    public abstract int d();

    public abstract int e();
}
