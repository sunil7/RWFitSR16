package com.example.test.ui.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$styleable;

/* loaded from: classes.dex */
public final class PointView extends View {

    /* renamed from: a, reason: collision with root package name */
    public Integer f8502a;

    /* renamed from: b, reason: collision with root package name */
    public final eh.b f8503b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PointView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    private final Paint getPaint() {
        return (Paint) this.f8503b.getValue();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        kotlin.jvm.internal.e.f(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, getPaint());
    }

    public final void setPointColor(int i3) {
        this.f8502a = Integer.valueOf(i3);
        getPaint().setColor(i3);
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PointView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ PointView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        this.f8502a = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PointView);
            kotlin.jvm.internal.e.e(obtainStyledAttributes, "obtainStyledAttributes(...)");
            this.f8502a = Integer.valueOf(obtainStyledAttributes.getColor(R$styleable.PointView_color_point, context.getResources().getColor(R.color.holo_red_light)));
            obtainStyledAttributes.recycle();
        }
        this.f8503b = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.view.PointView$paint$2
            {
                super(0);
            }

            @Override // oh.a
            public final Paint invoke() {
                Paint paint = new Paint(1);
                Integer num = PointView.this.f8502a;
                if (num != null) {
                    paint.setColor(num.intValue());
                }
                return paint;
            }
        });
    }
}
