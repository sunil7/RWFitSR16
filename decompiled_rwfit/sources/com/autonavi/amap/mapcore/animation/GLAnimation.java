package com.autonavi.amap.mapcore.animation;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;

/* loaded from: classes.dex */
public class GLAnimation implements Cloneable {
    public static final int ABSOLUTE = 0;
    public static final int INFINITE = -1;
    public static final int RELATIVE_TO_PARENT = 2;
    public static final int RELATIVE_TO_SELF = 1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int START_ON_FIRST_FRAME = -1;
    public static final int ZORDER_BOTTOM = -1;
    public static final int ZORDER_NORMAL = 0;
    public static final int ZORDER_TOP = 1;
    private int mBackgroundColor;
    Interpolator mInterpolator;
    Animation.AnimationListener mListener;
    private Handler mListenerHandler;
    private Runnable mOnEnd;
    private Runnable mOnStart;
    long mStartOffset;
    private int mZAdjustment;
    boolean mEnded = false;
    boolean mStarted = false;
    boolean mCycleFlip = false;
    boolean mInitialized = false;
    boolean mFillBefore = true;
    boolean mFillAfter = false;
    boolean mFillEnabled = false;
    long mStartTime = -1;
    long mDuration = 500;
    int mRepeatCount = 0;
    int mRepeated = 0;
    int mRepeatMode = 1;
    private float mScaleFactor = 1.0f;
    private boolean mDetachWallpaper = false;
    private boolean mMore = true;
    private boolean mOneMoreTime = true;
    RectF mPreviousRegion = new RectF();
    RectF mRegion = new RectF();
    GLTransformation mPreviousTransformation = new GLTransformation();

    public GLAnimation() {
        try {
            ensureInterpolator();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void fireAnimationEnd() {
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Handler handler = this.mListenerHandler;
            if (handler == null) {
                animationListener.onAnimationEnd();
            } else {
                handler.postAtFrontOfQueue(this.mOnEnd);
            }
        }
    }

    private void fireAnimationRepeat() {
    }

    private void fireAnimationStart() {
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Handler handler = this.mListenerHandler;
            if (handler == null) {
                animationListener.onAnimationStart();
            } else {
                handler.postAtFrontOfQueue(this.mOnStart);
            }
        }
    }

    public void applyTransformation(float f2, GLTransformation gLTransformation) {
    }

    public void cancel() {
        if (this.mStarted && !this.mEnded) {
            fireAnimationEnd();
            this.mEnded = true;
        }
        this.mStartTime = Long.MIN_VALUE;
        this.mOneMoreTime = false;
        this.mMore = false;
    }

    public long computeDurationHint() {
        return (getDuration() + getStartOffset()) * (getRepeatCount() + 1);
    }

    public void detach() {
        if (!this.mStarted || this.mEnded) {
            return;
        }
        this.mEnded = true;
        fireAnimationEnd();
    }

    public void ensureInterpolator() {
        if (this.mInterpolator == null) {
            this.mInterpolator = new AccelerateDecelerateInterpolator();
        }
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public boolean getDetachWallpaper() {
        return this.mDetachWallpaper;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public boolean getFillAfter() {
        return this.mFillAfter;
    }

    public boolean getFillBefore() {
        return this.mFillBefore;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public float getScaleFactor() {
        return this.mScaleFactor;
    }

    public long getStartOffset() {
        return this.mStartOffset;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public boolean getTransformation(long j4, GLTransformation gLTransformation) {
        if (this.mStartTime == -1) {
            this.mStartTime = j4;
        }
        long startOffset = getStartOffset();
        long j10 = this.mDuration;
        float f2 = j10 != 0 ? (j4 - (this.mStartTime + startOffset)) / j10 : j4 < this.mStartTime ? 0.0f : 1.0f;
        boolean z5 = f2 >= 1.0f;
        this.mMore = !z5;
        if (!this.mFillEnabled) {
            f2 = Math.max(Math.min(f2, 1.0f), 0.0f);
        }
        if ((f2 >= 0.0f || this.mFillBefore) && (f2 <= 1.0f || this.mFillAfter)) {
            if (!this.mStarted) {
                try {
                    fireAnimationStart();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                this.mStarted = true;
            }
            if (this.mFillEnabled) {
                f2 = Math.max(Math.min(f2, 1.0f), 0.0f);
            }
            if (this.mCycleFlip) {
                f2 = 1.0f - f2;
            }
            applyTransformation(this.mInterpolator.getInterpolation(f2), gLTransformation);
        }
        if (z5) {
            int i3 = this.mRepeatCount;
            int i10 = this.mRepeated;
            if (i3 != i10) {
                if (i3 > 0) {
                    this.mRepeated = i10 + 1;
                }
                if (this.mRepeatMode == 2) {
                    this.mCycleFlip = !this.mCycleFlip;
                }
                this.mStartTime = -1L;
                this.mMore = true;
                fireAnimationRepeat();
            } else if (!this.mEnded) {
                this.mEnded = true;
                fireAnimationEnd();
            }
        }
        boolean z6 = this.mMore;
        if (z6 || !this.mOneMoreTime) {
            return z6;
        }
        this.mOneMoreTime = false;
        return true;
    }

    public int getZAdjustment() {
        return this.mZAdjustment;
    }

    public boolean hasAlpha() {
        return false;
    }

    public boolean hasEnded() {
        return this.mEnded;
    }

    public boolean hasStarted() {
        return this.mStarted;
    }

    public void initialize() {
        reset();
        this.mInitialized = true;
    }

    public boolean isFillEnabled() {
        return this.mFillEnabled;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void reset() {
        this.mPreviousRegion.setEmpty();
        this.mPreviousTransformation.clear();
        this.mInitialized = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
        this.mOneMoreTime = true;
        this.mListenerHandler = null;
    }

    public void restrictDuration(long j4) {
        long j10 = this.mStartOffset;
        if (j10 > j4) {
            this.mStartOffset = j4;
            this.mDuration = 0L;
            this.mRepeatCount = 0;
            return;
        }
        long j11 = this.mDuration + j10;
        if (j11 > j4) {
            this.mDuration = j4 - j10;
            j11 = j4;
        }
        if (this.mDuration <= 0) {
            this.mDuration = 0L;
            this.mRepeatCount = 0;
            return;
        }
        int i3 = this.mRepeatCount;
        if (i3 >= 0) {
            long j12 = i3;
            if (j12 <= j4 && j12 * j11 <= j4) {
                return;
            }
        }
        int i10 = ((int) (j4 / j11)) - 1;
        this.mRepeatCount = i10;
        if (i10 < 0) {
            this.mRepeatCount = 0;
        }
    }

    public void scaleCurrentDuration(float f2) {
        this.mDuration = (long) (this.mDuration * f2);
        this.mStartOffset = (long) (this.mStartOffset * f2);
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void setBackgroundColor(int i3) {
        this.mBackgroundColor = i3;
    }

    public void setDetachWallpaper(boolean z5) {
        this.mDetachWallpaper = z5;
    }

    public void setDuration(long j4) {
        if (j4 < 0) {
            j4 = 0;
        }
        this.mDuration = j4;
    }

    public void setFillAfter(boolean z5) {
        this.mFillAfter = z5;
    }

    public void setFillBefore(boolean z5) {
        this.mFillBefore = z5;
    }

    public void setFillEnabled(boolean z5) {
        this.mFillEnabled = z5;
    }

    public void setInterpolator(Context context, int i3) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i3));
    }

    public void setRepeatCount(int i3) {
        if (i3 < 0) {
            i3 = -1;
        }
        this.mRepeatCount = i3;
    }

    public void setRepeatMode(int i3) {
        this.mRepeatMode = i3;
    }

    public void setStartOffset(long j4) {
        this.mStartOffset = j4;
    }

    public void setStartTime(long j4) {
        this.mStartTime = j4;
        this.mEnded = false;
        this.mStarted = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
    }

    public void setZAdjustment(int i3) {
        this.mZAdjustment = i3;
    }

    public void start() {
        setStartTime(-1L);
    }

    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    public boolean willChangeBounds() {
        return true;
    }

    public boolean willChangeTransformationMatrix() {
        return true;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GLAnimation mo43clone() throws CloneNotSupportedException {
        GLAnimation gLAnimation = (GLAnimation) super.clone();
        gLAnimation.mPreviousRegion = new RectF();
        gLAnimation.mRegion = new RectF();
        gLAnimation.mPreviousTransformation = new GLTransformation();
        return gLAnimation;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public boolean getTransformation(long j4, GLTransformation gLTransformation, float f2) {
        this.mScaleFactor = f2;
        return getTransformation(j4, gLTransformation);
    }
}
