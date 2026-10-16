package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import w0.e;

/* loaded from: classes.dex */
public class Guideline extends View {
    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i3) {
        e eVar = (e) getLayoutParams();
        eVar.f19294a = i3;
        setLayoutParams(eVar);
    }

    public void setGuidelineEnd(int i3) {
        e eVar = (e) getLayoutParams();
        eVar.f19296b = i3;
        setLayoutParams(eVar);
    }

    public void setGuidelinePercent(float f2) {
        e eVar = (e) getLayoutParams();
        eVar.f19298c = f2;
        setLayoutParams(eVar);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        super.setVisibility(8);
    }
}
