package ab;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.provider.Settings;

/* loaded from: classes.dex */
public final class o extends l {

    /* renamed from: l, reason: collision with root package name */
    public final m f197l;

    /* renamed from: m, reason: collision with root package name */
    public n f198m;

    public o(Context context, d dVar, m mVar, n nVar) {
        super(context, dVar);
        this.f197l = mVar;
        mVar.f193b = this;
        this.f198m = nVar;
        nVar.f194a = this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(rect)) {
            return;
        }
        canvas.save();
        m mVar = this.f197l;
        float b3 = b();
        mVar.f192a.a();
        mVar.a(canvas, b3);
        m mVar2 = this.f197l;
        Paint paint = this.f190i;
        mVar2.c(canvas, paint);
        int i3 = 0;
        while (true) {
            n nVar = this.f198m;
            int[] iArr = (int[]) nVar.f196c;
            if (i3 >= iArr.length) {
                canvas.restore();
                return;
            }
            m mVar3 = this.f197l;
            float[] fArr = (float[]) nVar.f195b;
            int i10 = i3 * 2;
            mVar3.b(canvas, paint, fArr[i10], fArr[i10 + 1], iArr[i3]);
            i3++;
        }
    }

    @Override // ab.l
    public final boolean f(boolean z5, boolean z6, boolean z8) {
        boolean f2 = super.f(z5, z6, z8);
        if (!isRunning()) {
            this.f198m.c();
        }
        a aVar = this.f185c;
        ContentResolver contentResolver = this.f183a.getContentResolver();
        aVar.getClass();
        Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        if (z5 && z8) {
            this.f198m.t();
        }
        return f2;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f197l.d();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f197l.e();
    }
}
