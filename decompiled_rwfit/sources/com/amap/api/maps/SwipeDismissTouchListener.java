package com.amap.api.maps;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {
    public static final int A_HALF = 2;
    public static final int MIN_VIEW_WIDTH = 2;
    public static final int ONE_THIRD = 3;
    private long mAnimationTime;
    private DismissCallbacks mCallbacks;
    private boolean mCanFinish;
    private float mDownX;
    private float mDownY;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private boolean mO;
    private int mSlop;
    private boolean mSwiping;
    private int mSwipingSlop;
    private Object mToken;
    private float mTranslationX;
    private VelocityTracker mVelocityTracker;
    private View mView;
    private int mViewWidth = 1;

    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);

        void onNotifySwipe();
    }

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeDismissTouchListener.a(SwipeDismissTouchListener.this);
        }
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.mSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mAnimationTime = view.getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.mView = view;
        this.mToken = obj;
        this.mCallbacks = dismissCallbacks;
    }

    public static void a(SwipeDismissTouchListener swipeDismissTouchListener) {
        swipeDismissTouchListener.mCallbacks.onDismiss(swipeDismissTouchListener.mView, swipeDismissTouchListener.mToken);
        ViewGroup.LayoutParams layoutParams = swipeDismissTouchListener.mView.getLayoutParams();
        int height = swipeDismissTouchListener.mView.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(swipeDismissTouchListener.mAnimationTime);
        duration.addListener(new e(swipeDismissTouchListener, layoutParams, height));
        duration.addUpdateListener(new f(swipeDismissTouchListener, layoutParams));
        duration.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a9  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.SwipeDismissTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
