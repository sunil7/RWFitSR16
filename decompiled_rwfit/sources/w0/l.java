package w0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: n, reason: collision with root package name */
    public static final SparseIntArray f19406n;

    /* renamed from: a, reason: collision with root package name */
    public boolean f19407a;

    /* renamed from: b, reason: collision with root package name */
    public int f19408b;

    /* renamed from: c, reason: collision with root package name */
    public int f19409c;

    /* renamed from: d, reason: collision with root package name */
    public String f19410d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f19411f;

    /* renamed from: g, reason: collision with root package name */
    public float f19412g;

    /* renamed from: h, reason: collision with root package name */
    public float f19413h;

    /* renamed from: i, reason: collision with root package name */
    public float f19414i;

    /* renamed from: j, reason: collision with root package name */
    public int f19415j;

    /* renamed from: k, reason: collision with root package name */
    public String f19416k;

    /* renamed from: l, reason: collision with root package name */
    public int f19417l;

    /* renamed from: m, reason: collision with root package name */
    public int f19418m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f19406n = sparseIntArray;
        sparseIntArray.append(R$styleable.Motion_motionPathRotate, 1);
        sparseIntArray.append(R$styleable.Motion_pathMotionArc, 2);
        sparseIntArray.append(R$styleable.Motion_transitionEasing, 3);
        sparseIntArray.append(R$styleable.Motion_drawPath, 4);
        sparseIntArray.append(R$styleable.Motion_animateRelativeTo, 5);
        sparseIntArray.append(R$styleable.Motion_animateCircleAngleTo, 6);
        sparseIntArray.append(R$styleable.Motion_motionStagger, 7);
        sparseIntArray.append(R$styleable.Motion_quantizeMotionSteps, 8);
        sparseIntArray.append(R$styleable.Motion_quantizeMotionPhase, 9);
        sparseIntArray.append(R$styleable.Motion_quantizeMotionInterpolator, 10);
    }

    public final void a(l lVar) {
        this.f19407a = lVar.f19407a;
        this.f19408b = lVar.f19408b;
        this.f19410d = lVar.f19410d;
        this.e = lVar.e;
        this.f19411f = lVar.f19411f;
        this.f19413h = lVar.f19413h;
        this.f19412g = lVar.f19412g;
    }

    public final void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
        this.f19407a = true;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            switch (f19406n.get(index)) {
                case 1:
                    this.f19413h = obtainStyledAttributes.getFloat(index, this.f19413h);
                    break;
                case 2:
                    this.e = obtainStyledAttributes.getInt(index, this.e);
                    break;
                case 3:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        this.f19410d = obtainStyledAttributes.getString(index);
                        break;
                    } else {
                        this.f19410d = p0.e.f17312d[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 4:
                    this.f19411f = obtainStyledAttributes.getInt(index, 0);
                    break;
                case 5:
                    this.f19408b = o.l(obtainStyledAttributes, index, this.f19408b);
                    break;
                case 6:
                    this.f19409c = obtainStyledAttributes.getInteger(index, this.f19409c);
                    break;
                case 7:
                    this.f19412g = obtainStyledAttributes.getFloat(index, this.f19412g);
                    break;
                case 8:
                    this.f19415j = obtainStyledAttributes.getInteger(index, this.f19415j);
                    break;
                case 9:
                    this.f19414i = obtainStyledAttributes.getFloat(index, this.f19414i);
                    break;
                case 10:
                    int i10 = obtainStyledAttributes.peekValue(index).type;
                    if (i10 == 1) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                        this.f19418m = resourceId;
                        if (resourceId != -1) {
                            this.f19417l = -2;
                            break;
                        } else {
                            break;
                        }
                    } else if (i10 == 3) {
                        String string = obtainStyledAttributes.getString(index);
                        this.f19416k = string;
                        if (string.indexOf("/") > 0) {
                            this.f19418m = obtainStyledAttributes.getResourceId(index, -1);
                            this.f19417l = -2;
                            break;
                        } else {
                            this.f19417l = -1;
                            break;
                        }
                    } else {
                        this.f19417l = obtainStyledAttributes.getInteger(index, this.f19418m);
                        break;
                    }
            }
        }
        obtainStyledAttributes.recycle();
    }
}
