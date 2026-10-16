package eb;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* loaded from: classes.dex */
public final class r extends v {

    /* renamed from: b, reason: collision with root package name */
    public final t f12566b;

    /* renamed from: c, reason: collision with root package name */
    public final float f12567c;

    /* renamed from: d, reason: collision with root package name */
    public final float f12568d;

    public r(t tVar, float f2, float f10) {
        this.f12566b = tVar;
        this.f12567c = f2;
        this.f12568d = f10;
    }

    @Override // eb.v
    public final void a(Matrix matrix, db.a aVar, int i3, Canvas canvas) {
        t tVar = this.f12566b;
        float f2 = tVar.f12576c;
        float f10 = this.f12568d;
        float f11 = tVar.f12575b;
        float f12 = this.f12567c;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f2 - f10, f11 - f12), 0.0f);
        Matrix matrix2 = new Matrix(matrix);
        matrix2.preTranslate(f12, f10);
        matrix2.preRotate(b());
        aVar.getClass();
        rectF.bottom += i3;
        rectF.offset(0.0f, -i3);
        int[] iArr = db.a.f12315i;
        iArr[0] = aVar.f12323f;
        iArr[1] = aVar.e;
        iArr[2] = aVar.f12322d;
        Paint paint = aVar.f12321c;
        float f13 = rectF.left;
        paint.setShader(new LinearGradient(f13, rectF.top, f13, rectF.bottom, iArr, db.a.f12316j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        t tVar = this.f12566b;
        return (float) Math.toDegrees(Math.atan((tVar.f12576c - this.f12568d) / (tVar.f12575b - this.f12567c)));
    }
}
