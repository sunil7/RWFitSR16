package com.example.test.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$color;
import java.util.List;

/* loaded from: classes.dex */
public class SleepChartView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f8565a;

    /* renamed from: b, reason: collision with root package name */
    public int f8566b;

    /* renamed from: c, reason: collision with root package name */
    public List f8567c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f8568d;
    public RectF e;

    /* renamed from: f, reason: collision with root package name */
    public LinearGradient f8569f;

    /* renamed from: g, reason: collision with root package name */
    public LinearGradient f8570g;

    /* renamed from: h, reason: collision with root package name */
    public LinearGradient f8571h;

    /* renamed from: i, reason: collision with root package name */
    public LinearGradient f8572i;

    public SleepChartView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List list = this.f8567c;
        if (list == null || list.isEmpty()) {
            this.f8568d.setShader(this.f8572i);
            canvas.drawRect(this.e, this.f8568d);
            return;
        }
        for (x6.a aVar : this.f8567c) {
            int i3 = aVar.f19813a;
            if (i3 == 0) {
                this.f8568d.setShader(this.f8569f);
            } else if (i3 == 1) {
                this.f8568d.setShader(this.f8571h);
            } else if (i3 == 2) {
                this.f8568d.setShader(this.f8570g);
            }
            canvas.drawPath(aVar.f19814b, this.f8568d);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        this.f8565a = View.MeasureSpec.getSize(i3);
        this.f8566b = View.MeasureSpec.getSize(i10);
        if (this.e != null || this.f8565a <= 0) {
            return;
        }
        this.e = new RectF(0.0f, 0.0f, this.f8565a, this.f8566b);
        float f2 = this.e.bottom;
        int color = getContext().getResources().getColor(R$color.color_fbb612);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f8569f = new LinearGradient(0.0f, 0.0f, 0.0f, f2, color, 0, tileMode);
        this.f8570g = new LinearGradient(0.0f, 0.0f, 0.0f, this.e.bottom, getContext().getResources().getColor(R$color.color_925ed2), 0, tileMode);
        this.f8571h = new LinearGradient(0.0f, 0.0f, 0.0f, this.e.bottom, getContext().getResources().getColor(R$color.color_3d56bf), 0, tileMode);
        this.f8572i = new LinearGradient(0.0f, 0.0f, 0.0f, this.e.bottom, getContext().getResources().getColor(R$color.color_1f242e), 0, tileMode);
    }

    public void setData(List<x6.a> list) {
        this.f8567c = list;
        invalidate();
    }

    public SleepChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SleepChartView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8568d = new Paint(1);
    }
}
