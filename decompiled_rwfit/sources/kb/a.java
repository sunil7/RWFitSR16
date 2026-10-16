package kb;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transformation.ExpandableBehavior;

/* loaded from: classes.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f15592a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f15593b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ va.a f15594c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ExpandableBehavior f15595d;

    public a(ExpandableBehavior expandableBehavior, View view, int i3, va.a aVar) {
        this.f15595d = expandableBehavior;
        this.f15592a = view;
        this.f15593b = i3;
        this.f15594c = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View view = this.f15592a;
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        ExpandableBehavior expandableBehavior = this.f15595d;
        if (expandableBehavior.f10986a == this.f15593b) {
            Object obj = this.f15594c;
            expandableBehavior.s((View) obj, view, ((FloatingActionButton) obj).f10508o.f867b, false);
        }
        return false;
    }
}
