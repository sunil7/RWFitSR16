package pf;

import android.graphics.ImageFormat;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: f, reason: collision with root package name */
    public static final ef.b f17597f = ef.b.a(c.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final int f17598a;

    /* renamed from: b, reason: collision with root package name */
    public int f17599b = -1;

    /* renamed from: c, reason: collision with root package name */
    public wf.b f17600c = null;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedBlockingQueue f17601d;
    public lf.b e;

    public c(Class cls, int i3) {
        this.f17598a = i3;
        this.f17601d = new LinkedBlockingQueue(i3);
    }

    public final b a(long j4, Object obj) {
        if (this.f17600c == null) {
            throw new IllegalStateException("Can't call getFrame() after releasing or before setUp.");
        }
        b bVar = (b) this.f17601d.poll();
        ef.b bVar2 = f17597f;
        if (bVar == null) {
            bVar2.b(1, "getFrame for time:", Long.valueOf(j4), "NOT AVAILABLE.");
            b(obj, false);
            return null;
        }
        bVar2.b(0, "getFrame for time:", Long.valueOf(j4), "RECYCLING.");
        lf.b bVar3 = this.e;
        Reference reference = Reference.SENSOR;
        Reference reference2 = Reference.OUTPUT;
        Axis axis = Axis.RELATIVE_TO_SENSOR;
        bVar3.c(reference, reference2, axis);
        this.e.c(reference, Reference.VIEW, axis);
        bVar.f17594b = obj;
        bVar.f17595c = j4;
        bVar.f17596d = j4;
        return bVar;
    }

    public abstract void b(Object obj, boolean z5);

    public void c() {
        boolean z5 = this.f17600c != null;
        ef.b bVar = f17597f;
        if (!z5) {
            bVar.b(2, "release called twice. Ignoring.");
            return;
        }
        bVar.b(1, "release: Clearing the frame and buffer queue.");
        this.f17601d.clear();
        this.f17599b = -1;
        this.f17600c = null;
        this.e = null;
    }

    public void d(int i3, wf.b bVar, lf.b bVar2) {
        this.f17600c = bVar;
        this.f17599b = (int) Math.ceil(((bVar.f19628b * bVar.f19627a) * ImageFormat.getBitsPerPixel(i3)) / 8.0d);
        for (int i10 = 0; i10 < this.f17598a; i10++) {
            this.f17601d.offer(new b(this));
        }
        this.e = bVar2;
    }
}
