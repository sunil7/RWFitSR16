package ab;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.provider.Settings;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import com.google.android.gms.internal.mlkit_vision_common.x;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j extends l {

    /* renamed from: q, reason: collision with root package name */
    public static final i f174q = new i();

    /* renamed from: l, reason: collision with root package name */
    public final m f175l;

    /* renamed from: m, reason: collision with root package name */
    public final r1.i f176m;

    /* renamed from: n, reason: collision with root package name */
    public final r1.h f177n;

    /* renamed from: o, reason: collision with root package name */
    public float f178o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f179p;

    public j(Context context, d dVar, m mVar) {
        super(context, dVar);
        this.f179p = false;
        this.f175l = mVar;
        mVar.f193b = this;
        r1.i iVar = new r1.i();
        this.f176m = iVar;
        iVar.f18011b = 1.0f;
        iVar.f18012c = false;
        iVar.f18010a = Math.sqrt(50.0f);
        iVar.f18012c = false;
        r1.h hVar = new r1.h(this);
        hVar.f18009s = Float.MAX_VALUE;
        this.f177n = hVar;
        hVar.r = iVar;
        if (this.f189h != 1.0f) {
            this.f189h = 1.0f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            m mVar = this.f175l;
            float b3 = b();
            mVar.f192a.a();
            mVar.a(canvas, b3);
            m mVar2 = this.f175l;
            Paint paint = this.f190i;
            mVar2.c(canvas, paint);
            this.f175l.b(canvas, paint, 0.0f, this.f178o, x.a(this.f184b.f153c[0], this.f191j));
            canvas.restore();
        }
    }

    @Override // ab.l
    public final boolean f(boolean z5, boolean z6, boolean z8) {
        boolean f2 = super.f(z5, z6, z8);
        a aVar = this.f185c;
        ContentResolver contentResolver = this.f183a.getContentResolver();
        aVar.getClass();
        float f10 = Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        if (f10 == 0.0f) {
            this.f179p = true;
            return f2;
        }
        this.f179p = false;
        float f11 = 50.0f / f10;
        r1.i iVar = this.f176m;
        iVar.getClass();
        if (f11 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        iVar.f18010a = Math.sqrt(f11);
        iVar.f18012c = false;
        return f2;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f175l.d();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f175l.e();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        r1.h hVar = this.f177n;
        hVar.getClass();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (hVar.f18003f) {
            hVar.a();
        }
        this.f178o = getLevel() / 10000.0f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i3) {
        boolean z5 = this.f179p;
        r1.h hVar = this.f177n;
        if (z5) {
            hVar.getClass();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
            }
            if (hVar.f18003f) {
                hVar.a();
            }
            this.f178o = i3 / 10000.0f;
            invalidateSelf();
            return true;
        }
        hVar.f18000b = this.f178o * 10000.0f;
        hVar.f18001c = true;
        float f2 = i3;
        if (hVar.f18003f) {
            hVar.f18009s = f2;
            return true;
        }
        if (hVar.r == null) {
            hVar.r = new r1.i(f2);
        }
        r1.i iVar = hVar.r;
        double d5 = f2;
        iVar.f18017i = d5;
        double d8 = (float) d5;
        if (d8 > Float.MAX_VALUE) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        float f10 = hVar.f18004g;
        if (d8 < f10) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        double abs = Math.abs(hVar.f18006i * 0.75f);
        iVar.f18013d = abs;
        iVar.e = abs * 62.5d;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        boolean z6 = hVar.f18003f;
        if (!z6 && !z6) {
            hVar.f18003f = true;
            if (!hVar.f18001c) {
                hVar.e.getClass();
                hVar.f18000b = hVar.f18002d.f178o * 10000.0f;
            }
            float f11 = hVar.f18000b;
            if (f11 > Float.MAX_VALUE || f11 < f10) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            ThreadLocal threadLocal = r1.b.f17986f;
            if (threadLocal.get() == null) {
                threadLocal.set(new r1.b());
            }
            r1.b bVar = (r1.b) threadLocal.get();
            ArrayList arrayList = bVar.f17988b;
            if (arrayList.size() == 0) {
                if (bVar.f17990d == null) {
                    bVar.f17990d = new n.l(bVar.f17989c);
                }
                n.l lVar = bVar.f17990d;
                ((Choreographer) lVar.f16246c).postFrameCallback((r1.a) lVar.f16247d);
            }
            if (!arrayList.contains(hVar)) {
                arrayList.add(hVar);
                return true;
            }
        }
        return true;
    }
}
