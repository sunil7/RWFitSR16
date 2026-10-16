package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.VirtualLayout;
import q0.l;
import q0.n;
import q0.o;

/* loaded from: classes.dex */
public class MotionPlaceholder extends VirtualLayout {
    public MotionPlaceholder(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        this.f1852d = new n();
        q();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onMeasure(int i3, int i10) {
        r(null, i3, i10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void p(l lVar, SparseArray sparseArray) {
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public final void r(o oVar, int i3, int i10) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        if (oVar == null) {
            setMeasuredDimension(0, 0);
        } else {
            oVar.Q(mode, size, mode2, size2);
            setMeasuredDimension(oVar.B0, oVar.C0);
        }
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
