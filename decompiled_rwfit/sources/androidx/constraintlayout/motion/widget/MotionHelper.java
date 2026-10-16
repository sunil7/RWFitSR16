package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import u0.u;

/* loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements u {

    /* renamed from: i, reason: collision with root package name */
    public boolean f1688i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1689j;

    /* renamed from: k, reason: collision with root package name */
    public float f1690k;

    /* renamed from: l, reason: collision with root package name */
    public View[] f1691l;

    public MotionHelper(Context context) {
        super(context);
        this.f1688i = false;
        this.f1689j = false;
    }

    public void a(int i3) {
    }

    public float getProgress() {
        return this.f1690k;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.MotionHelper_onShow) {
                    this.f1688i = obtainStyledAttributes.getBoolean(index, this.f1688i);
                } else if (index == R$styleable.MotionHelper_onHide) {
                    this.f1689j = obtainStyledAttributes.getBoolean(index, this.f1689j);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void r(MotionLayout motionLayout, HashMap hashMap) {
    }

    public void setProgress(float f2) {
        this.f1690k = f2;
        int i3 = 0;
        if (this.f1850b > 0) {
            this.f1691l = j((ConstraintLayout) getParent());
            while (i3 < this.f1850b) {
                View view = this.f1691l[i3];
                i3++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i3 < childCount) {
            boolean z5 = viewGroup.getChildAt(i3) instanceof MotionHelper;
            i3++;
        }
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1688i = false;
        this.f1689j = false;
        k(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1688i = false;
        this.f1689j = false;
        k(attributeSet);
    }
}
