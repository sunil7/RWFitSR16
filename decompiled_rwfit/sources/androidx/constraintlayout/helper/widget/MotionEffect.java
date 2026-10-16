package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class MotionEffect extends MotionHelper {

    /* renamed from: m, reason: collision with root package name */
    public float f1681m;

    /* renamed from: n, reason: collision with root package name */
    public int f1682n;

    /* renamed from: o, reason: collision with root package name */
    public int f1683o;

    /* renamed from: p, reason: collision with root package name */
    public int f1684p;

    /* renamed from: q, reason: collision with root package name */
    public int f1685q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public int f1686s;

    /* renamed from: t, reason: collision with root package name */
    public int f1687t;

    public MotionEffect(Context context) {
        super(context);
        this.f1681m = 0.1f;
        this.f1682n = 49;
        this.f1683o = 50;
        this.f1684p = 0;
        this.f1685q = 0;
        this.r = true;
        this.f1686s = -1;
        this.f1687t = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x01cc, code lost:
    
        if (r2 == 0.0f) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0189, code lost:
    
        if (r15 == 0.0f) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01a4, code lost:
    
        if (r15 == 0.0f) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f7  */
    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(androidx.constraintlayout.motion.widget.MotionLayout r26, java.util.HashMap r27) {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.r(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    public final void s(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.MotionEffect_motionEffect_start) {
                    int i10 = obtainStyledAttributes.getInt(index, this.f1682n);
                    this.f1682n = i10;
                    this.f1682n = Math.max(Math.min(i10, 99), 0);
                } else if (index == R$styleable.MotionEffect_motionEffect_end) {
                    int i11 = obtainStyledAttributes.getInt(index, this.f1683o);
                    this.f1683o = i11;
                    this.f1683o = Math.max(Math.min(i11, 99), 0);
                } else if (index == R$styleable.MotionEffect_motionEffect_translationX) {
                    this.f1684p = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1684p);
                } else if (index == R$styleable.MotionEffect_motionEffect_translationY) {
                    this.f1685q = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1685q);
                } else if (index == R$styleable.MotionEffect_motionEffect_alpha) {
                    this.f1681m = obtainStyledAttributes.getFloat(index, this.f1681m);
                } else if (index == R$styleable.MotionEffect_motionEffect_move) {
                    this.f1687t = obtainStyledAttributes.getInt(index, this.f1687t);
                } else if (index == R$styleable.MotionEffect_motionEffect_strict) {
                    this.r = obtainStyledAttributes.getBoolean(index, this.r);
                } else if (index == R$styleable.MotionEffect_motionEffect_viewTransition) {
                    this.f1686s = obtainStyledAttributes.getResourceId(index, this.f1686s);
                }
            }
            int i12 = this.f1682n;
            int i13 = this.f1683o;
            if (i12 == i13) {
                if (i12 > 0) {
                    this.f1682n = i12 - 1;
                } else {
                    this.f1683o = i13 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1681m = 0.1f;
        this.f1682n = 49;
        this.f1683o = 50;
        this.f1684p = 0;
        this.f1685q = 0;
        this.r = true;
        this.f1686s = -1;
        this.f1687t = -1;
        s(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1681m = 0.1f;
        this.f1682n = 49;
        this.f1683o = 50;
        this.f1684p = 0;
        this.f1685q = 0;
        this.r = true;
        this.f1686s = -1;
        this.f1687t = -1;
        s(context, attributeSet);
    }
}
