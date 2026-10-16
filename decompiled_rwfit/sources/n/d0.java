package n;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Rational;
import androidx.camera.camera2.internal.compat.quirk.AfRegionFlipHorizontallyQuirk;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.d1;
import androidx.camera.core.impl.i1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: t, reason: collision with root package name */
    public static final MeteringRectangle[] f16150t = new MeteringRectangle[0];

    /* renamed from: a, reason: collision with root package name */
    public final h f16151a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.camera.core.impl.utils.executor.b f16152b;

    /* renamed from: c, reason: collision with root package name */
    public final w.c f16153c;

    /* renamed from: f, reason: collision with root package name */
    public final mc.g f16155f;

    /* renamed from: i, reason: collision with root package name */
    public ScheduledFuture f16158i;

    /* renamed from: j, reason: collision with root package name */
    public ScheduledFuture f16159j;

    /* renamed from: o, reason: collision with root package name */
    public MeteringRectangle[] f16164o;

    /* renamed from: p, reason: collision with root package name */
    public MeteringRectangle[] f16165p;

    /* renamed from: q, reason: collision with root package name */
    public MeteringRectangle[] f16166q;
    public androidx.concurrent.futures.b r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f16167s;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f16154d = false;
    public volatile Rational e = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16156g = false;

    /* renamed from: h, reason: collision with root package name */
    public Integer f16157h = 0;

    /* renamed from: k, reason: collision with root package name */
    public long f16160k = 0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f16161l = false;

    /* renamed from: m, reason: collision with root package name */
    public int f16162m = 1;

    /* renamed from: n, reason: collision with root package name */
    public a0 f16163n = null;

    public d0(h hVar, w.c cVar, androidx.camera.core.impl.utils.executor.b bVar, i1 i1Var) {
        MeteringRectangle[] meteringRectangleArr = f16150t;
        this.f16164o = meteringRectangleArr;
        this.f16165p = meteringRectangleArr;
        this.f16166q = meteringRectangleArr;
        this.r = null;
        this.f16167s = false;
        this.f16151a = hVar;
        this.f16152b = bVar;
        this.f16153c = cVar;
        this.f16155f = new mc.g(i1Var, 12);
    }

    public final void a() {
        h hVar = this.f16151a;
        ((HashSet) hVar.f16179b.f1165c).remove(null);
        ((HashSet) hVar.f16179b.f1165c).remove(this.f16163n);
        androidx.concurrent.futures.b bVar = this.r;
        if (bVar != null) {
            bVar.b(new CameraControl$OperationCanceledException("Cancelled by cancelFocusAndMetering()"));
            this.r = null;
        }
        ScheduledFuture scheduledFuture = this.f16158i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f16158i = null;
        }
        ScheduledFuture scheduledFuture2 = this.f16159j;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
            this.f16159j = null;
        }
        if ((this.f16164o.length > 0) && this.f16154d) {
            androidx.camera.core.impl.c0 c0Var = new androidx.camera.core.impl.c0();
            c0Var.e = true;
            c0Var.f1356c = this.f16162m;
            androidx.camera.core.impl.x0 f2 = androidx.camera.core.impl.x0.f();
            f2.m(m.b.Y(CaptureRequest.CONTROL_AF_TRIGGER), 2);
            c0Var.c(new m.b(d1.a(f2), 12));
            this.f16151a.u(Collections.singletonList(c0Var.d()));
        }
        MeteringRectangle[] meteringRectangleArr = f16150t;
        this.f16164o = meteringRectangleArr;
        this.f16165p = meteringRectangleArr;
        this.f16166q = meteringRectangleArr;
        this.f16156g = false;
        hVar.v();
    }

    public final List b(List list, int i3, Rational rational, Rect rect, int i10) {
        if (list.isEmpty() || i3 == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Rational rational2 = new Rational(rect.width(), rect.height());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            t.t0 t0Var = (t.t0) it.next();
            if (arrayList.size() == i3) {
                break;
            }
            float f2 = t0Var.f18413a;
            if (f2 >= 0.0f && f2 <= 1.0f) {
                float f10 = t0Var.f18414b;
                if (f10 >= 0.0f && f10 <= 1.0f) {
                    Rational rational3 = t0Var.f18415c;
                    if (rational3 == null) {
                        rational3 = rational;
                    }
                    PointF pointF = (i10 == 1 && ((i1) this.f16155f.f16022b).d(AfRegionFlipHorizontallyQuirk.class)) ? new PointF(1.0f - f2, f10) : new PointF(f2, f10);
                    if (!rational3.equals(rational2)) {
                        if (rational3.compareTo(rational2) > 0) {
                            float doubleValue = (float) (rational3.doubleValue() / rational2.doubleValue());
                            pointF.y = (1.0f / doubleValue) * (((float) ((doubleValue - 1.0d) / 2.0d)) + pointF.y);
                        } else {
                            float doubleValue2 = (float) (rational2.doubleValue() / rational3.doubleValue());
                            pointF.x = (1.0f / doubleValue2) * (((float) ((doubleValue2 - 1.0d) / 2.0d)) + pointF.x);
                        }
                    }
                    int width = (int) ((pointF.x * rect.width()) + rect.left);
                    int height = (int) ((pointF.y * rect.height()) + rect.top);
                    int width2 = ((int) (rect.width() * 0.15f)) / 2;
                    int height2 = ((int) (0.15f * rect.height())) / 2;
                    Rect rect2 = new Rect(width - width2, height - height2, width + width2, height + height2);
                    rect2.left = Math.min(Math.max(rect2.left, rect.left), rect.right);
                    rect2.right = Math.min(Math.max(rect2.right, rect.left), rect.right);
                    rect2.top = Math.min(Math.max(rect2.top, rect.top), rect.bottom);
                    rect2.bottom = Math.min(Math.max(rect2.bottom, rect.top), rect.bottom);
                    MeteringRectangle meteringRectangle = new MeteringRectangle(rect2, 1000);
                    if (meteringRectangle.getWidth() != 0 && meteringRectangle.getHeight() != 0) {
                        arrayList.add(meteringRectangle);
                    }
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final boolean c(t.v vVar) {
        Rational rational;
        h hVar = this.f16151a;
        Rect c9 = ((u0) hVar.f16185i.f16310f).c();
        if (this.e != null) {
            rational = this.e;
        } else {
            Rect c10 = ((u0) this.f16151a.f16185i.f16310f).c();
            rational = new Rational(c10.width(), c10.height());
        }
        List list = vVar.f18418b;
        Integer num = (Integer) hVar.e.a(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        List b3 = b(list, num == null ? 0 : num.intValue(), rational, c9, 1);
        Integer num2 = (Integer) hVar.e.a(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        List b10 = b(vVar.f18419c, num2 == null ? 0 : num2.intValue(), rational, c9, 2);
        Integer num3 = (Integer) hVar.e.a(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        return (b3.isEmpty() && b10.isEmpty() && b(vVar.f18420d, num3 == null ? 0 : num3.intValue(), rational, c9, 4).isEmpty()) ? false : true;
    }
}
