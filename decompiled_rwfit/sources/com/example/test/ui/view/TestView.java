package com.example.test.ui.view;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class TestView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f8641a;

    /* renamed from: b, reason: collision with root package name */
    public final Camera f8642b;

    public TestView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8641a.setColor(-65536);
        canvas.drawCircle(50.0f, 50.0f, 50.0f, this.f8641a);
        canvas.save();
        Matrix matrix = canvas.getMatrix();
        this.f8642b.rotateY(-90.0f);
        this.f8642b.getMatrix(matrix);
        canvas.setMatrix(matrix);
        this.f8641a.setColor(-16711936);
        canvas.drawCircle(50.0f, 50.0f, 50.0f, this.f8641a);
        canvas.restore();
    }

    public TestView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TestView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint(1);
        this.f8641a = paint;
        paint.setColor(-65536);
        this.f8642b = new Camera();
    }
}
