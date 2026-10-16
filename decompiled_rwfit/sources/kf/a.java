package kf;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;

/* loaded from: classes2.dex */
public final class a implements sf.b {

    /* renamed from: c, reason: collision with root package name */
    public static final ef.b f15613c = ef.b.a(a.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final int f15614a;

    /* renamed from: b, reason: collision with root package name */
    public final wf.b f15615b;

    public a(lf.b bVar, wf.b bVar2) {
        this.f15614a = -bVar.c(Reference.SENSOR, Reference.VIEW, Axis.ABSOLUTE);
        this.f15615b = bVar2;
    }

    @Override // sf.b
    public final Object a(RectF rectF, int i3) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new Camera.Area(rect, i3);
    }

    @Override // sf.b
    public final PointF b(PointF pointF) {
        PointF pointF2 = new PointF();
        float f2 = pointF.x;
        wf.b bVar = this.f15615b;
        pointF2.x = ((f2 / bVar.f19627a) * 2000.0f) - 1000.0f;
        pointF2.y = ((pointF.y / bVar.f19628b) * 2000.0f) - 1000.0f;
        PointF pointF3 = new PointF();
        double d5 = (this.f15614a * 3.141592653589793d) / 180.0d;
        pointF3.x = (float) ((Math.cos(d5) * pointF2.x) - (Math.sin(d5) * pointF2.y));
        pointF3.y = (float) ((Math.cos(d5) * pointF2.y) + (Math.sin(d5) * pointF2.x));
        f15613c.b(1, "scaled:", pointF2, "rotated:", pointF3);
        return pointF3;
    }
}
