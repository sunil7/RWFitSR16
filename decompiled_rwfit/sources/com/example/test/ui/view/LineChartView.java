package com.example.test.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$color;
import java.util.List;

/* loaded from: classes.dex */
public class LineChartView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f8454a;

    /* renamed from: b, reason: collision with root package name */
    public int f8455b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f8456c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f8457d;
    public final Path e;

    /* renamed from: f, reason: collision with root package name */
    public final Path f8458f;

    /* renamed from: g, reason: collision with root package name */
    public List f8459g;

    /* renamed from: h, reason: collision with root package name */
    public List f8460h;

    /* renamed from: i, reason: collision with root package name */
    public LinearGradient f8461i;

    public LineChartView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List list = this.f8459g;
        if (list == null || list.isEmpty()) {
            canvas.drawRect(0.0f, 0.0f, this.f8454a, this.f8455b, this.f8457d);
            return;
        }
        this.e.reset();
        int i3 = 0;
        int i10 = 0;
        while (i10 < this.f8459g.size() - 1) {
            PointF pointF = (PointF) this.f8459g.get(i10);
            int i11 = i10 + 1;
            PointF pointF2 = (PointF) this.f8459g.get(i11);
            float f2 = pointF.x;
            float f10 = pointF2.x;
            float f11 = (f2 + f10) / 2.0f;
            if (i10 == 0) {
                this.e.moveTo(f2, pointF.y);
            } else {
                Path path = this.e;
                float f12 = pointF.y;
                float f13 = pointF2.y;
                path.cubicTo(f11, f12, f11, f13, f10, f13);
            }
            i10 = i11;
        }
        this.f8456c.setColor(getContext().getResources().getColor(R$color.color_d90fd2));
        canvas.drawPath(this.e, this.f8456c);
        this.f8458f.reset();
        while (i3 < this.f8460h.size() - 1) {
            PointF pointF3 = (PointF) this.f8460h.get(i3);
            int i12 = i3 + 1;
            PointF pointF4 = (PointF) this.f8460h.get(i12);
            float f14 = pointF3.x;
            float f15 = pointF4.x;
            float f16 = (f14 + f15) / 2.0f;
            if (i3 == 0) {
                this.f8458f.moveTo(f14, pointF3.y);
            } else {
                Path path2 = this.f8458f;
                float f17 = pointF3.y;
                float f18 = pointF4.y;
                path2.cubicTo(f16, f17, f16, f18, f15, f18);
            }
            i3 = i12;
        }
        this.f8456c.setColor(getContext().getResources().getColor(R$color.color_17fff1));
        canvas.drawPath(this.f8458f, this.f8456c);
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        this.f8454a = View.MeasureSpec.getSize(i3);
        this.f8455b = View.MeasureSpec.getSize(i10);
        if (this.f8461i != null || this.f8454a <= 0) {
            return;
        }
        float f2 = this.f8455b;
        int color = getContext().getResources().getColor(R$color.color_1f242e);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f8461i = new LinearGradient(0.0f, 0.0f, 0.0f, f2, color, 0, tileMode);
        new LinearGradient(0.0f, 0.0f, 0.0f, this.f8455b, getContext().getResources().getColor(R$color.color_925ed2), 0, tileMode);
        this.f8457d.setShader(this.f8461i);
    }

    public void setColor(int i3) {
        invalidate();
    }

    public LineChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineChartView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint(1);
        this.f8456c = paint;
        paint.setStrokeWidth(5.0f);
        this.f8456c.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.f8457d = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.e = new Path();
        this.f8458f = new Path();
    }
}
