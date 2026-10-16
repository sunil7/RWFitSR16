package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import q0.o;

/* loaded from: classes.dex */
public abstract class VirtualLayout extends ConstraintHelper {

    /* renamed from: i, reason: collision with root package name */
    public boolean f1880i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1881j;

    public VirtualLayout(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void g(ConstraintLayout constraintLayout) {
        f(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f1880i = true;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_elevation) {
                    this.f1881j = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1880i || this.f1881j) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = getElevation();
                for (int i3 = 0; i3 < this.f1850b; i3++) {
                    View d5 = constraintLayout.d(this.f1849a[i3]);
                    if (d5 != null) {
                        if (this.f1880i) {
                            d5.setVisibility(visibility);
                        }
                        if (this.f1881j && elevation > 0.0f) {
                            d5.setTranslationZ(d5.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    public void r(o oVar, int i3, int i10) {
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        e();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        e();
    }

    public VirtualLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
