package androidx.viewpager2.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class m extends RecyclerView {

    /* renamed from: l1, reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f2988l1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(ViewPager2 viewPager2, Context context) {
        super(context);
        this.f2988l1 = viewPager2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final CharSequence getAccessibilityClassName() {
        this.f2988l1.f2964t.getClass();
        return super.getAccessibilityClassName();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        ViewPager2 viewPager2 = this.f2988l1;
        accessibilityEvent.setFromIndex(viewPager2.f2950d);
        accessibilityEvent.setToIndex(viewPager2.f2950d);
        accessibilityEvent.setSource((ViewPager2) viewPager2.f2964t.f19149d);
        accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2988l1.r && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f2988l1.r && super.onTouchEvent(motionEvent);
    }
}
