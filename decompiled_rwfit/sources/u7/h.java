package u7;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.data.Entry;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class h extends a4.a {

    /* renamed from: b, reason: collision with root package name */
    public final k7.a f18948b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f18949c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f18950d;
    public final Paint e;

    public h(k7.a aVar, v7.i iVar) {
        super(iVar);
        this.f18948b = aVar;
        Paint paint = new Paint(1);
        this.f18949c = paint;
        paint.setStyle(Paint.Style.FILL);
        new Paint(4);
        Paint paint2 = new Paint(1);
        this.e = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setTextSize(v7.h.c(9.0f));
        Paint paint3 = new Paint(1);
        this.f18950d = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.f18950d.setStrokeWidth(2.0f);
        this.f18950d.setColor(Color.rgb(255, 187, 115));
    }

    public final void j(o7.d dVar) {
        Paint paint = this.e;
        paint.setTypeface(null);
        paint.setTextSize(dVar.f16818m);
    }

    public abstract void k(Canvas canvas);

    public abstract void l(Canvas canvas);

    public abstract void m(Canvas canvas, q7.c[] cVarArr);

    public final void n(Canvas canvas, p7.d dVar, float f2, Entry entry, int i3, float f10, float f11, int i10) {
        Paint paint = this.e;
        paint.setColor(i10);
        canvas.drawText(((DecimalFormat) ((n6.a) dVar).f16381b).format(f2), f10, f11, paint);
    }

    public abstract void o(Canvas canvas);

    public abstract void p();

    public boolean q(BarLineChartBase barLineChartBase) {
        return ((float) barLineChartBase.getData().d()) < ((float) barLineChartBase.getMaxVisibleCount()) * ((v7.i) this.f78a).f19208i;
    }
}
