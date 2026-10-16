package eb;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* loaded from: classes.dex */
public final class q extends v {

    /* renamed from: b, reason: collision with root package name */
    public final s f12565b;

    public q(s sVar) {
        this.f12565b = sVar;
    }

    @Override // eb.v
    public final void a(Matrix matrix, db.a aVar, int i3, Canvas canvas) {
        s sVar = this.f12565b;
        float f2 = sVar.f12573f;
        float f10 = sVar.f12574g;
        RectF rectF = new RectF(sVar.f12570b, sVar.f12571c, sVar.f12572d, sVar.e);
        aVar.getClass();
        boolean z5 = f10 < 0.0f;
        Path path = aVar.f12324g;
        int[] iArr = db.a.f12317k;
        if (z5) {
            iArr[0] = 0;
            iArr[1] = aVar.f12323f;
            iArr[2] = aVar.e;
            iArr[3] = aVar.f12322d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f10);
            path.close();
            float f11 = -i3;
            rectF.inset(f11, f11);
            iArr[0] = 0;
            iArr[1] = aVar.f12322d;
            iArr[2] = aVar.e;
            iArr[3] = aVar.f12323f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f12 = 1.0f - (i3 / width);
        float[] fArr = db.a.f12318l;
        fArr[1] = f12;
        fArr[2] = ((1.0f - f12) / 2.0f) + f12;
        RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), width, iArr, fArr, Shader.TileMode.CLAMP);
        Paint paint = aVar.f12320b;
        paint.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z5) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, aVar.f12325h);
        }
        canvas.drawArc(rectF, f2, f10, true, paint);
        canvas.restore();
    }
}
