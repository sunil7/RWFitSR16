package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class j1 extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public z1 f2633a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f2634b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2635c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2636d;

    public j1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2634b = new Rect();
        this.f2635c = true;
        this.f2636d = false;
    }

    public j1(int i3, int i10) {
        super(i3, i10);
        this.f2634b = new Rect();
        this.f2635c = true;
        this.f2636d = false;
    }

    public j1(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f2634b = new Rect();
        this.f2635c = true;
        this.f2636d = false;
    }

    public j1(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f2634b = new Rect();
        this.f2635c = true;
        this.f2636d = false;
    }

    public j1(j1 j1Var) {
        super((ViewGroup.LayoutParams) j1Var);
        this.f2634b = new Rect();
        this.f2635c = true;
        this.f2636d = false;
    }
}
