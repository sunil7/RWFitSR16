package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.d;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;
import pe.o;
import s0.a;
import u0.x;

/* loaded from: classes.dex */
public class Carousel extends MotionHelper {

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f1640m;

    /* renamed from: n, reason: collision with root package name */
    public int f1641n;

    /* renamed from: o, reason: collision with root package name */
    public MotionLayout f1642o;

    /* renamed from: p, reason: collision with root package name */
    public int f1643p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1644q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f1645s;

    /* renamed from: t, reason: collision with root package name */
    public int f1646t;

    /* renamed from: u, reason: collision with root package name */
    public int f1647u;

    /* renamed from: v, reason: collision with root package name */
    public float f1648v;

    /* renamed from: w, reason: collision with root package name */
    public int f1649w;

    /* renamed from: x, reason: collision with root package name */
    public int f1650x;

    /* renamed from: y, reason: collision with root package name */
    public float f1651y;

    public Carousel(Context context) {
        super(context);
        this.f1640m = new ArrayList();
        this.f1641n = 0;
        this.f1643p = -1;
        this.f1644q = false;
        this.r = -1;
        this.f1645s = -1;
        this.f1646t = -1;
        this.f1647u = -1;
        this.f1648v = 0.9f;
        this.f1649w = 4;
        this.f1650x = 1;
        this.f1651y = 2.0f;
        new o(this, 4);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, u0.u
    public final void a(int i3) {
        int i10 = this.f1641n;
        if (i3 == this.f1647u) {
            this.f1641n = i10 + 1;
        } else if (i3 == this.f1646t) {
            this.f1641n = i10 - 1;
        }
        if (!this.f1644q) {
            throw null;
        }
        throw null;
    }

    public int getCount() {
        return 0;
    }

    public int getCurrentIndex() {
        return this.f1641n;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        d dVar;
        d dVar2;
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i3 = 0; i3 < this.f1850b; i3++) {
                this.f1640m.add(motionLayout.d(this.f1849a[i3]));
            }
            this.f1642o = motionLayout;
            if (this.f1650x == 2) {
                x w8 = motionLayout.w(this.f1645s);
                if (w8 != null && (dVar2 = w8.f18793l) != null) {
                    dVar2.f1751c = 5;
                }
                x w9 = this.f1642o.w(this.r);
                if (w9 == null || (dVar = w9.f18793l) == null) {
                    return;
                }
                dVar.f1751c = 5;
            }
        }
    }

    public final void s(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Carousel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.Carousel_carousel_firstView) {
                    this.f1643p = obtainStyledAttributes.getResourceId(index, this.f1643p);
                } else if (index == R$styleable.Carousel_carousel_backwardTransition) {
                    this.r = obtainStyledAttributes.getResourceId(index, this.r);
                } else if (index == R$styleable.Carousel_carousel_forwardTransition) {
                    this.f1645s = obtainStyledAttributes.getResourceId(index, this.f1645s);
                } else if (index == R$styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.f1649w = obtainStyledAttributes.getInt(index, this.f1649w);
                } else if (index == R$styleable.Carousel_carousel_previousState) {
                    this.f1646t = obtainStyledAttributes.getResourceId(index, this.f1646t);
                } else if (index == R$styleable.Carousel_carousel_nextState) {
                    this.f1647u = obtainStyledAttributes.getResourceId(index, this.f1647u);
                } else if (index == R$styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.f1648v = obtainStyledAttributes.getFloat(index, this.f1648v);
                } else if (index == R$styleable.Carousel_carousel_touchUpMode) {
                    this.f1650x = obtainStyledAttributes.getInt(index, this.f1650x);
                } else if (index == R$styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.f1651y = obtainStyledAttributes.getFloat(index, this.f1651y);
                } else if (index == R$styleable.Carousel_carousel_infinite) {
                    this.f1644q = obtainStyledAttributes.getBoolean(index, this.f1644q);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setAdapter(a aVar) {
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1640m = new ArrayList();
        this.f1641n = 0;
        this.f1643p = -1;
        this.f1644q = false;
        this.r = -1;
        this.f1645s = -1;
        this.f1646t = -1;
        this.f1647u = -1;
        this.f1648v = 0.9f;
        this.f1649w = 4;
        this.f1650x = 1;
        this.f1651y = 2.0f;
        new o(this, 4);
        s(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1640m = new ArrayList();
        this.f1641n = 0;
        this.f1643p = -1;
        this.f1644q = false;
        this.r = -1;
        this.f1645s = -1;
        this.f1646t = -1;
        this.f1647u = -1;
        this.f1648v = 0.9f;
        this.f1649w = 4;
        this.f1650x = 1;
        this.f1651y = 2.0f;
        new o(this, 4);
        s(context, attributeSet);
    }
}
