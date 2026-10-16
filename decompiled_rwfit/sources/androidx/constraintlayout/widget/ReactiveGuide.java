package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import w0.e;
import w0.r;
import w0.s;

/* loaded from: classes.dex */
public class ReactiveGuide extends View implements r {

    /* renamed from: a, reason: collision with root package name */
    public int f1876a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1877b;

    /* renamed from: c, reason: collision with root package name */
    public int f1878c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1879d;

    public ReactiveGuide(Context context) {
        super(context);
        this.f1876a = -1;
        this.f1877b = false;
        this.f1878c = 0;
        this.f1879d = true;
        super.setVisibility(8);
        a(null);
    }

    public final void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.f1876a = obtainStyledAttributes.getResourceId(index, this.f1876a);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.f1877b = obtainStyledAttributes.getBoolean(index, this.f1877b);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.f1878c = obtainStyledAttributes.getResourceId(index, this.f1878c);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.f1879d = obtainStyledAttributes.getBoolean(index, this.f1879d);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f1876a != -1) {
            ConstraintLayout.getSharedValues().a(this.f1876a, this);
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.f1878c;
    }

    public int getAttributeId() {
        return this.f1876a;
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean z5) {
        this.f1877b = z5;
    }

    public void setApplyToConstraintSetId(int i3) {
        this.f1878c = i3;
    }

    public void setAttributeId(int i3) {
        HashSet hashSet;
        s sharedValues = ConstraintLayout.getSharedValues();
        int i10 = this.f1876a;
        if (i10 != -1 && (hashSet = (HashSet) sharedValues.f19455a.get(Integer.valueOf(i10))) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                r rVar = (r) weakReference.get();
                if (rVar == null || rVar == this) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
        this.f1876a = i3;
        if (i3 != -1) {
            sharedValues.a(i3, this);
        }
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

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1876a = -1;
        this.f1877b = false;
        this.f1878c = 0;
        this.f1879d = true;
        super.setVisibility(8);
        a(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1876a = -1;
        this.f1877b = false;
        this.f1878c = 0;
        this.f1879d = true;
        super.setVisibility(8);
        a(attributeSet);
    }
}
