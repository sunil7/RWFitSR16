package com.example.test.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$color;
import java.util.List;

/* loaded from: classes.dex */
public class LineGradientChartView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f8462a;

    /* renamed from: b, reason: collision with root package name */
    public int f8463b;

    /* renamed from: c, reason: collision with root package name */
    public int f8464c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f8465d;
    public LinearGradient e;

    /* renamed from: f, reason: collision with root package name */
    public RectF f8466f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f8467g;

    /* renamed from: h, reason: collision with root package name */
    public LinearGradient f8468h;

    /* renamed from: i, reason: collision with root package name */
    public List f8469i;

    public LineGradientChartView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List list = this.f8469i;
        if (list == null || list.isEmpty()) {
            this.f8465d.setShader(this.f8468h);
            canvas.drawRect(this.f8466f, this.f8465d);
            return;
        }
        this.f8467g.reset();
        int i3 = 0;
        while (i3 < this.f8469i.size() - 1) {
            PointF pointF = (PointF) this.f8469i.get(i3);
            int i10 = i3 + 1;
            PointF pointF2 = (PointF) this.f8469i.get(i10);
            float f2 = pointF.x;
            float f10 = pointF2.x;
            float f11 = (f2 + f10) / 2.0f;
            if (i3 == 0) {
                this.f8467g.moveTo(f2, pointF.y);
            } else {
                Path path = this.f8467g;
                float f12 = pointF.y;
                float f13 = pointF2.y;
                path.cubicTo(f11, f12, f11, f13, f10, f13);
            }
            i3 = i10;
        }
        this.f8467g.lineTo(this.f8462a, this.f8463b);
        this.f8467g.lineTo(0.0f, this.f8463b);
        this.f8467g.lineTo(0.0f, 0.0f);
        this.f8465d.setShader(this.e);
        canvas.drawPath(this.f8467g, this.f8465d);
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        this.f8462a = View.MeasureSpec.getSize(i3);
        this.f8463b = View.MeasureSpec.getSize(i10);
        if (this.e == null) {
            this.f8466f = new RectF(0.0f, 0.0f, this.f8462a, this.f8463b);
            float f2 = this.f8466f.bottom;
            int color = getContext().getResources().getColor(this.f8464c);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.e = new LinearGradient(0.0f, 0.0f, 0.0f, f2, color, 0, tileMode);
            this.f8468h = new LinearGradient(0.0f, 0.0f, 0.0f, this.f8466f.bottom, getContext().getResources().getColor(R$color.color_1f242e), 0, tileMode);
        }
    }

    public void setColor(int i3) {
        this.f8464c = i3;
        if (this.f8466f != null) {
            float f2 = this.f8466f.bottom;
            int color = getContext().getResources().getColor(i3);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.e = new LinearGradient(0.0f, 0.0f, 0.0f, f2, color, 0, tileMode);
            this.f8468h = new LinearGradient(0.0f, 0.0f, 0.0f, this.f8466f.bottom, getContext().getResources().getColor(R$color.color_1f242e), 0, tileMode);
            this.f8465d.setShader(this.e);
        }
        invalidate();
    }

    public void setData(List<PointF> list) {
        this.f8469i = list;
        invalidate();
    }

    public LineGradientChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineGradientChartView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8464c = R$color.color_dc2641;
        this.f8465d = new Paint(1);
        this.f8467g = new Path();
    }
}
