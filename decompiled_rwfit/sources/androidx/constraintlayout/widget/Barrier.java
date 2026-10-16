package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import q0.a;
import q0.f;
import q0.g;
import q0.l;
import w0.j;
import w0.k;
import w0.p;

/* loaded from: classes.dex */
public class Barrier extends ConstraintHelper {

    /* renamed from: i, reason: collision with root package name */
    public int f1845i;

    /* renamed from: j, reason: collision with root package name */
    public int f1846j;

    /* renamed from: k, reason: collision with root package name */
    public a f1847k;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.f1847k.f17614v0;
    }

    public int getMargin() {
        return this.f1847k.f17615w0;
    }

    public int getType() {
        return this.f1845i;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        this.f1847k = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f1847k.f17614v0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f1847k.f17615w0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1852d = this.f1847k;
        q();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void l(j jVar, l lVar, p pVar, SparseArray sparseArray) {
        super.l(jVar, lVar, pVar, sparseArray);
        if (lVar instanceof a) {
            a aVar = (a) lVar;
            boolean z5 = ((g) lVar.U).f17690x0;
            k kVar = jVar.e;
            r(aVar, kVar.f19378f0, z5);
            aVar.f17614v0 = kVar.f19393n0;
            aVar.f17615w0 = kVar.f19380g0;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void m(f fVar, boolean z5) {
        r(fVar, this.f1845i, z5);
    }

    public final void r(f fVar, int i3, boolean z5) {
        this.f1846j = i3;
        if (z5) {
            int i10 = this.f1845i;
            if (i10 == 5) {
                this.f1846j = 1;
            } else if (i10 == 6) {
                this.f1846j = 0;
            }
        } else {
            int i11 = this.f1845i;
            if (i11 == 5) {
                this.f1846j = 0;
            } else if (i11 == 6) {
                this.f1846j = 1;
            }
        }
        if (fVar instanceof a) {
            ((a) fVar).f17613u0 = this.f1846j;
        }
    }

    public void setAllowsGoneWidget(boolean z5) {
        this.f1847k.f17614v0 = z5;
    }

    public void setDpMargin(int i3) {
        this.f1847k.f17615w0 = (int) ((i3 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i3) {
        this.f1847k.f17615w0 = i3;
    }

    public void setType(int i3) {
        this.f1845i = i3;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        super.setVisibility(8);
    }
}
