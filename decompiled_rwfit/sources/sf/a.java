package sf;

import android.graphics.PointF;
import android.graphics.RectF;

/* loaded from: classes2.dex */
public final class a implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final RectF f18257a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18258b;

    public a(RectF rectF, int i3) {
        this.f18257a = rectF;
        this.f18258b = i3;
    }

    public static void a(RectF rectF, PointF pointF) {
        rectF.left = Math.min(rectF.left, pointF.x);
        rectF.top = Math.min(rectF.top, pointF.y);
        rectF.right = Math.max(rectF.right, pointF.x);
        rectF.bottom = Math.max(rectF.bottom, pointF.y);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return -Integer.valueOf(this.f18258b).compareTo(Integer.valueOf(((a) obj).f18258b));
    }
}
