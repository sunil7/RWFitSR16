package w0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public boolean f19419a;

    /* renamed from: b, reason: collision with root package name */
    public int f19420b;

    /* renamed from: c, reason: collision with root package name */
    public int f19421c;

    /* renamed from: d, reason: collision with root package name */
    public float f19422d;
    public float e;

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
        this.f19419a = true;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.PropertySet_android_alpha) {
                this.f19422d = obtainStyledAttributes.getFloat(index, this.f19422d);
            } else if (index == R$styleable.PropertySet_android_visibility) {
                int i10 = obtainStyledAttributes.getInt(index, this.f19420b);
                this.f19420b = i10;
                this.f19420b = o.f19437g[i10];
            } else if (index == R$styleable.PropertySet_visibilityMode) {
                this.f19421c = obtainStyledAttributes.getInt(index, this.f19421c);
            } else if (index == R$styleable.PropertySet_motionProgress) {
                this.e = obtainStyledAttributes.getFloat(index, this.e);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
