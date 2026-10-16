package com.dh.imagepick.preview.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class InterceptLayout extends FrameLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterceptLayout(Context context) {
        this(context, null, 6, 0);
        e.f(context, "context");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return com.dh.imagepick.preview.utils.d.f7152a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterceptLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        e.f(context, "context");
    }

    public /* synthetic */ InterceptLayout(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterceptLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        e.f(context, "context");
    }
}
