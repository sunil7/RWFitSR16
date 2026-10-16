package w0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: o, reason: collision with root package name */
    public static final SparseIntArray f19423o;

    /* renamed from: a, reason: collision with root package name */
    public boolean f19424a;

    /* renamed from: b, reason: collision with root package name */
    public float f19425b;

    /* renamed from: c, reason: collision with root package name */
    public float f19426c;

    /* renamed from: d, reason: collision with root package name */
    public float f19427d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f19428f;

    /* renamed from: g, reason: collision with root package name */
    public float f19429g;

    /* renamed from: h, reason: collision with root package name */
    public float f19430h;

    /* renamed from: i, reason: collision with root package name */
    public int f19431i;

    /* renamed from: j, reason: collision with root package name */
    public float f19432j;

    /* renamed from: k, reason: collision with root package name */
    public float f19433k;

    /* renamed from: l, reason: collision with root package name */
    public float f19434l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f19435m;

    /* renamed from: n, reason: collision with root package name */
    public float f19436n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f19423o = sparseIntArray;
        sparseIntArray.append(R$styleable.Transform_android_rotation, 1);
        sparseIntArray.append(R$styleable.Transform_android_rotationX, 2);
        sparseIntArray.append(R$styleable.Transform_android_rotationY, 3);
        sparseIntArray.append(R$styleable.Transform_android_scaleX, 4);
        sparseIntArray.append(R$styleable.Transform_android_scaleY, 5);
        sparseIntArray.append(R$styleable.Transform_android_transformPivotX, 6);
        sparseIntArray.append(R$styleable.Transform_android_transformPivotY, 7);
        sparseIntArray.append(R$styleable.Transform_android_translationX, 8);
        sparseIntArray.append(R$styleable.Transform_android_translationY, 9);
        sparseIntArray.append(R$styleable.Transform_android_translationZ, 10);
        sparseIntArray.append(R$styleable.Transform_android_elevation, 11);
        sparseIntArray.append(R$styleable.Transform_transformPivotTarget, 12);
    }

    public final void a(n nVar) {
        this.f19424a = nVar.f19424a;
        this.f19425b = nVar.f19425b;
        this.f19426c = nVar.f19426c;
        this.f19427d = nVar.f19427d;
        this.e = nVar.e;
        this.f19428f = nVar.f19428f;
        this.f19429g = nVar.f19429g;
        this.f19430h = nVar.f19430h;
        this.f19431i = nVar.f19431i;
        this.f19432j = nVar.f19432j;
        this.f19433k = nVar.f19433k;
        this.f19434l = nVar.f19434l;
        this.f19435m = nVar.f19435m;
        this.f19436n = nVar.f19436n;
    }

    public final void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
        this.f19424a = true;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            switch (f19423o.get(index)) {
                case 1:
                    this.f19425b = obtainStyledAttributes.getFloat(index, this.f19425b);
                    break;
                case 2:
                    this.f19426c = obtainStyledAttributes.getFloat(index, this.f19426c);
                    break;
                case 3:
                    this.f19427d = obtainStyledAttributes.getFloat(index, this.f19427d);
                    break;
                case 4:
                    this.e = obtainStyledAttributes.getFloat(index, this.e);
                    break;
                case 5:
                    this.f19428f = obtainStyledAttributes.getFloat(index, this.f19428f);
                    break;
                case 6:
                    this.f19429g = obtainStyledAttributes.getDimension(index, this.f19429g);
                    break;
                case 7:
                    this.f19430h = obtainStyledAttributes.getDimension(index, this.f19430h);
                    break;
                case 8:
                    this.f19432j = obtainStyledAttributes.getDimension(index, this.f19432j);
                    break;
                case 9:
                    this.f19433k = obtainStyledAttributes.getDimension(index, this.f19433k);
                    break;
                case 10:
                    this.f19434l = obtainStyledAttributes.getDimension(index, this.f19434l);
                    break;
                case 11:
                    this.f19435m = true;
                    this.f19436n = obtainStyledAttributes.getDimension(index, this.f19436n);
                    break;
                case 12:
                    this.f19431i = o.l(obtainStyledAttributes, index, this.f19431i);
                    break;
            }
        }
        obtainStyledAttributes.recycle();
    }
}
