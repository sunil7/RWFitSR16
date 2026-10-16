package lf;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;

/* loaded from: classes2.dex */
public final class b {
    public static final ef.b e = ef.b.a(b.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public Facing f15870a;

    /* renamed from: b, reason: collision with root package name */
    public int f15871b;

    /* renamed from: c, reason: collision with root package name */
    public int f15872c;

    /* renamed from: d, reason: collision with root package name */
    public int f15873d;

    public static void e(int i3) {
        if (i3 != 0 && i3 != 90 && i3 != 180 && i3 != 270) {
            throw new IllegalStateException(l0.j(i3, "This value is not sanitized: "));
        }
    }

    public static int f(int i3) {
        return (i3 + 360) % 360;
    }

    public final int a(Reference reference, Reference reference2) {
        if (reference == reference2) {
            return 0;
        }
        Reference reference3 = Reference.BASE;
        if (reference2 == reference3) {
            return f(360 - a(reference2, reference));
        }
        if (reference != reference3) {
            return f(a(reference3, reference2) - a(reference3, reference));
        }
        int i3 = a.f15869a[reference2.ordinal()];
        if (i3 == 1) {
            return f(360 - this.f15872c);
        }
        if (i3 == 2) {
            return f(this.f15873d);
        }
        if (i3 == 3) {
            return f(360 - this.f15871b);
        }
        throw new RuntimeException("Unknown reference: " + reference2);
    }

    public final boolean b(Reference reference, Reference reference2) {
        return c(reference, reference2, Axis.ABSOLUTE) % 180 != 0;
    }

    public final int c(Reference reference, Reference reference2, Axis axis) {
        int a3 = a(reference, reference2);
        return (axis == Axis.RELATIVE_TO_SENSOR && this.f15870a == Facing.FRONT) ? f(360 - a3) : a3;
    }

    public final void d() {
        e.b(1, "Angles changed:", "sensorOffset:", Integer.valueOf(this.f15871b), "displayOffset:", Integer.valueOf(this.f15872c), "deviceOrientation:", Integer.valueOf(this.f15873d));
    }
}
