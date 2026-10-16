package jb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import androidx.appcompat.widget.v2;
import bb.e;
import com.google.android.material.internal.r;
import com.google.android.material.internal.s;
import eb.f;
import eb.h;
import eb.i;
import eb.l;

/* loaded from: classes.dex */
public final class a extends h implements r {
    public final s A;
    public final v2 B;
    public final Rect C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public float J;
    public float K;
    public float L;
    public float M;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f15396x;

    /* renamed from: y, reason: collision with root package name */
    public final Context f15397y;

    /* renamed from: z, reason: collision with root package name */
    public final Paint.FontMetrics f15398z;

    public a(Context context, int i3) {
        super(context, null, 0, i3);
        this.f15398z = new Paint.FontMetrics();
        s sVar = new s(this);
        this.A = sVar;
        this.B = new v2(this, 2);
        this.C = new Rect();
        this.J = 1.0f;
        this.K = 1.0f;
        this.L = 0.5f;
        this.M = 1.0f;
        this.f15397y = context;
        TextPaint textPaint = sVar.f10632a;
        textPaint.density = context.getResources().getDisplayMetrics().density;
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override // eb.h, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        canvas.save();
        float u10 = u();
        float f2 = (float) (-((Math.sqrt(2.0d) * this.H) - this.H));
        canvas.scale(this.J, this.K, (getBounds().width() * 0.5f) + getBounds().left, (getBounds().height() * this.L) + getBounds().top);
        canvas.translate(u10, f2);
        super.draw(canvas);
        if (this.f15396x == null) {
            canvas2 = canvas;
        } else {
            float centerY = getBounds().centerY();
            s sVar = this.A;
            TextPaint textPaint = sVar.f10632a;
            Paint.FontMetrics fontMetrics = this.f15398z;
            textPaint.getFontMetrics(fontMetrics);
            int i3 = (int) (centerY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f));
            e eVar = sVar.f10636f;
            TextPaint textPaint2 = sVar.f10632a;
            if (eVar != null) {
                textPaint2.drawableState = getState();
                sVar.f10636f.e(this.f15397y, textPaint2, sVar.f10633b);
                textPaint2.setAlpha((int) (this.M * 255.0f));
            }
            CharSequence charSequence = this.f15396x;
            canvas2 = canvas;
            canvas2.drawText(charSequence, 0, charSequence.length(), r0.centerX(), i3, textPaint2);
        }
        canvas2.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) Math.max(this.A.f10632a.getTextSize(), this.F);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float f2 = this.D * 2;
        CharSequence charSequence = this.f15396x;
        return (int) Math.max(f2 + (charSequence == null ? 0.0f : this.A.a(charSequence.toString())), this.E);
    }

    @Override // eb.h, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        l f2 = this.f12505a.f12488a.f();
        f2.f12537k = v();
        setShapeAppearanceModel(f2.a());
    }

    public final float u() {
        int i3;
        Rect rect = this.C;
        if (((rect.right - getBounds().right) - this.I) - this.G < 0) {
            i3 = ((rect.right - getBounds().right) - this.I) - this.G;
        } else {
            if (((rect.left - getBounds().left) - this.I) + this.G <= 0) {
                return 0.0f;
            }
            i3 = ((rect.left - getBounds().left) - this.I) + this.G;
        }
        return i3;
    }

    public final i v() {
        float f2 = -u();
        float width = ((float) (getBounds().width() - (Math.sqrt(2.0d) * this.H))) / 2.0f;
        return new i(new f(this.H), Math.min(Math.max(f2, -width), width));
    }
}
