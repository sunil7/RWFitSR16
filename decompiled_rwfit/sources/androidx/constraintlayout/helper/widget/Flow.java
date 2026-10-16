package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import q0.f;
import q0.i;
import q0.l;
import q0.o;
import w0.j;
import w0.p;

/* loaded from: classes.dex */
public class Flow extends VirtualLayout {

    /* renamed from: k, reason: collision with root package name */
    public i f1663k;

    public Flow(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        this.f1663k = new i();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f1663k.X0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_padding) {
                    i iVar = this.f1663k;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    iVar.f17723u0 = dimensionPixelSize;
                    iVar.f17724v0 = dimensionPixelSize;
                    iVar.f17725w0 = dimensionPixelSize;
                    iVar.f17726x0 = dimensionPixelSize;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingStart) {
                    i iVar2 = this.f1663k;
                    int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    iVar2.f17725w0 = dimensionPixelSize2;
                    iVar2.f17727y0 = dimensionPixelSize2;
                    iVar2.f17728z0 = dimensionPixelSize2;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.f1663k.f17726x0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f1663k.f17727y0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.f1663k.f17723u0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.f1663k.f17728z0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f1663k.f17724v0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f1663k.V0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f1663k.F0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f1663k.G0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f1663k.H0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f1663k.J0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f1663k.I0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f1663k.K0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f1663k.L0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f1663k.N0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f1663k.P0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f1663k.O0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f1663k.Q0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f1663k.M0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f1663k.T0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f1663k.U0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f1663k.R0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f1663k.S0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f1663k.W0 = obtainStyledAttributes.getInt(index, -1);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1852d = this.f1663k;
        q();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void l(j jVar, l lVar, p pVar, SparseArray sparseArray) {
        super.l(jVar, lVar, pVar, sparseArray);
        if (lVar instanceof i) {
            i iVar = (i) lVar;
            int i3 = pVar.U;
            if (i3 != -1) {
                iVar.X0 = i3;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void m(f fVar, boolean z5) {
        i iVar = this.f1663k;
        int i3 = iVar.f17725w0;
        if (i3 > 0 || iVar.f17726x0 > 0) {
            if (z5) {
                iVar.f17727y0 = iVar.f17726x0;
                iVar.f17728z0 = i3;
            } else {
                iVar.f17727y0 = i3;
                iVar.f17728z0 = iVar.f17726x0;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onMeasure(int i3, int i10) {
        r(this.f1663k, i3, i10);
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

    public void setFirstHorizontalBias(float f2) {
        this.f1663k.N0 = f2;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i3) {
        this.f1663k.H0 = i3;
        requestLayout();
    }

    public void setFirstVerticalBias(float f2) {
        this.f1663k.O0 = f2;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i3) {
        this.f1663k.I0 = i3;
        requestLayout();
    }

    public void setHorizontalAlign(int i3) {
        this.f1663k.T0 = i3;
        requestLayout();
    }

    public void setHorizontalBias(float f2) {
        this.f1663k.L0 = f2;
        requestLayout();
    }

    public void setHorizontalGap(int i3) {
        this.f1663k.R0 = i3;
        requestLayout();
    }

    public void setHorizontalStyle(int i3) {
        this.f1663k.F0 = i3;
        requestLayout();
    }

    public void setLastHorizontalBias(float f2) {
        this.f1663k.P0 = f2;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i3) {
        this.f1663k.J0 = i3;
        requestLayout();
    }

    public void setLastVerticalBias(float f2) {
        this.f1663k.Q0 = f2;
        requestLayout();
    }

    public void setLastVerticalStyle(int i3) {
        this.f1663k.K0 = i3;
        requestLayout();
    }

    public void setMaxElementsWrap(int i3) {
        this.f1663k.W0 = i3;
        requestLayout();
    }

    public void setOrientation(int i3) {
        this.f1663k.X0 = i3;
        requestLayout();
    }

    public void setPadding(int i3) {
        i iVar = this.f1663k;
        iVar.f17723u0 = i3;
        iVar.f17724v0 = i3;
        iVar.f17725w0 = i3;
        iVar.f17726x0 = i3;
        requestLayout();
    }

    public void setPaddingBottom(int i3) {
        this.f1663k.f17724v0 = i3;
        requestLayout();
    }

    public void setPaddingLeft(int i3) {
        this.f1663k.f17727y0 = i3;
        requestLayout();
    }

    public void setPaddingRight(int i3) {
        this.f1663k.f17728z0 = i3;
        requestLayout();
    }

    public void setPaddingTop(int i3) {
        this.f1663k.f17723u0 = i3;
        requestLayout();
    }

    public void setVerticalAlign(int i3) {
        this.f1663k.U0 = i3;
        requestLayout();
    }

    public void setVerticalBias(float f2) {
        this.f1663k.M0 = f2;
        requestLayout();
    }

    public void setVerticalGap(int i3) {
        this.f1663k.S0 = i3;
        requestLayout();
    }

    public void setVerticalStyle(int i3) {
        this.f1663k.G0 = i3;
        requestLayout();
    }

    public void setWrapMode(int i3) {
        this.f1663k.V0 = i3;
        requestLayout();
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
