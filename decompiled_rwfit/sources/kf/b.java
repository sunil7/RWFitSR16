package kf;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class b implements sf.b {

    /* renamed from: g, reason: collision with root package name */
    public static final ef.b f15616g = ef.b.a(b.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final lf.b f15617a;

    /* renamed from: b, reason: collision with root package name */
    public final wf.b f15618b;

    /* renamed from: c, reason: collision with root package name */
    public final wf.b f15619c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f15620d;
    public final CameraCharacteristics e;

    /* renamed from: f, reason: collision with root package name */
    public final CaptureRequest.Builder f15621f;

    public b(lf.b bVar, wf.b bVar2, wf.b bVar3, boolean z5, CameraCharacteristics cameraCharacteristics, CaptureRequest.Builder builder) {
        this.f15617a = bVar;
        this.f15618b = bVar2;
        this.f15619c = bVar3;
        this.f15620d = z5;
        this.e = cameraCharacteristics;
        this.f15621f = builder;
    }

    @Override // sf.b
    public final Object a(RectF rectF, int i3) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new MeteringRectangle(rect, i3);
    }

    @Override // sf.b
    public final PointF b(PointF pointF) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        wf.b bVar = this.f15618b;
        HashMap hashMap = wf.a.f19624c;
        wf.b bVar2 = this.f15619c;
        int i3 = bVar2.f19627a;
        int i10 = bVar2.f19628b;
        wf.a a3 = wf.a.a(i3, i10);
        int i11 = bVar.f19627a;
        int i12 = bVar.f19628b;
        wf.a a10 = wf.a.a(i11, i12);
        if (this.f15620d) {
            if (a3.c() > a10.c()) {
                float c9 = a3.c() / a10.c();
                float f2 = i11;
                pointF2.x = (((c9 - 1.0f) * f2) / 2.0f) + pointF2.x;
                i11 = Math.round(f2 * c9);
            } else {
                float c10 = a10.c() / a3.c();
                float f10 = i12;
                pointF2.y = (((c10 - 1.0f) * f10) / 2.0f) + pointF2.y;
                i12 = Math.round(f10 * c10);
            }
        }
        float f11 = pointF2.x;
        int i13 = bVar2.f19627a;
        pointF2.x = (i13 / i11) * f11;
        float f12 = i10;
        pointF2.y = (f12 / i12) * pointF2.y;
        int c11 = this.f15617a.c(Reference.SENSOR, Reference.VIEW, Axis.ABSOLUTE);
        boolean z5 = c11 % 180 != 0;
        float f13 = pointF2.x;
        float f14 = pointF2.y;
        if (c11 == 0) {
            pointF2.x = f13;
            pointF2.y = f14;
        } else if (c11 == 90) {
            pointF2.x = f14;
            pointF2.y = i13 - f13;
        } else if (c11 == 180) {
            pointF2.x = i13 - f13;
            pointF2.y = f12 - f14;
        } else {
            if (c11 != 270) {
                throw new IllegalStateException(l0.j(c11, "Unexpected angle "));
            }
            pointF2.x = f12 - f14;
            pointF2.y = f13;
        }
        if (z5) {
            bVar2 = bVar2.a();
        }
        CaptureRequest.Key key = CaptureRequest.SCALER_CROP_REGION;
        CaptureRequest.Builder builder = this.f15621f;
        Rect rect = (Rect) builder.get(key);
        int width = rect == null ? bVar2.f19627a : rect.width();
        int height = rect == null ? bVar2.f19628b : rect.height();
        pointF2.x = ((width - r5) / 2.0f) + pointF2.x;
        pointF2.y = ((height - r3) / 2.0f) + pointF2.y;
        Rect rect2 = (Rect) builder.get(key);
        pointF2.x += rect2 == null ? 0.0f : rect2.left;
        pointF2.y += rect2 == null ? 0.0f : rect2.top;
        Rect rect3 = (Rect) this.e.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect3 == null) {
            rect3 = new Rect(0, 0, width, height);
        }
        int width2 = rect3.width();
        int height2 = rect3.height();
        ef.b bVar3 = f15616g;
        bVar3.b(1, "input:", pointF, "output (before clipping):", pointF2);
        if (pointF2.x < 0.0f) {
            pointF2.x = 0.0f;
        }
        if (pointF2.y < 0.0f) {
            pointF2.y = 0.0f;
        }
        float f15 = width2;
        if (pointF2.x > f15) {
            pointF2.x = f15;
        }
        float f16 = height2;
        if (pointF2.y > f16) {
            pointF2.y = f16;
        }
        bVar3.b(1, "input:", pointF, "output (after clipping):", pointF2);
        return pointF2;
    }
}
