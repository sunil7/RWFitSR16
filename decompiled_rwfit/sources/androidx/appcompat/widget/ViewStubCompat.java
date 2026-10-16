package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f862a;

    /* renamed from: b, reason: collision with root package name */
    public int f863b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f864c;

    /* renamed from: d, reason: collision with root package name */
    public LayoutInflater f865d;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f862a == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflater = this.f865d;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(getContext());
        }
        View inflate = layoutInflater.inflate(this.f862a, viewGroup, false);
        int i3 = this.f863b;
        if (i3 != -1) {
            inflate.setId(i3);
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(inflate, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(inflate, indexOfChild);
        }
        this.f864c = new WeakReference(inflate);
        return inflate;
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f863b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f865d;
    }

    public int getLayoutResource() {
        return this.f862a;
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i3) {
        this.f863b = i3;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f865d = layoutInflater;
    }

    public void setLayoutResource(int i3) {
        this.f862a = i3;
    }

    public void setOnInflateListener(a4 a4Var) {
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        WeakReference weakReference = this.f864c;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i3);
            return;
        }
        super.setVisibility(i3);
        if (i3 == 0 || i3 == 4) {
            a();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f862a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewStubCompat, i3, 0);
        this.f863b = obtainStyledAttributes.getResourceId(R$styleable.ViewStubCompat_android_inflatedId, -1);
        this.f862a = obtainStyledAttributes.getResourceId(R$styleable.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(R$styleable.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
