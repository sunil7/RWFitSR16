package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class u extends ReplacementSpan {

    /* renamed from: b, reason: collision with root package name */
    public final n f2071b;

    /* renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f2070a = new Paint.FontMetricsInt();

    /* renamed from: c, reason: collision with root package name */
    public float f2072c = 1.0f;

    public u(n nVar) {
        pd.e(nVar, "metadata cannot be null");
        this.f2071b = nVar;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i3, int i10, float f2, int i11, int i12, int i13, Paint paint) {
        k.a().getClass();
        n nVar = this.f2071b;
        v2.h hVar = nVar.f2049b;
        Typeface typeface = (Typeface) hVar.f19149d;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText((char[]) hVar.f19147b, nVar.f2048a * 2, 2, f2, i12, paint);
        paint.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i3, int i10, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f2070a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float abs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        n nVar = this.f2071b;
        this.f2072c = abs / (nVar.b().a(14) != 0 ? ((ByteBuffer) r8.f15697d).getShort(r1 + r8.f15694a) : (short) 0);
        s1.a b3 = nVar.b();
        int a3 = b3.a(14);
        if (a3 != 0) {
            ((ByteBuffer) b3.f15697d).getShort(a3 + b3.f15694a);
        }
        short s7 = (short) ((nVar.b().a(12) != 0 ? ((ByteBuffer) r5.f15697d).getShort(r7 + r5.f15694a) : (short) 0) * this.f2072c);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s7;
    }
}
