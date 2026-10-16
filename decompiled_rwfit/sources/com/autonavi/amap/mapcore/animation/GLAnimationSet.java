package com.autonavi.amap.mapcore.animation;

import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GLAnimationSet extends GLAnimation {
    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 128;
    private static final int PROPERTY_DURATION_MASK = 32;
    private static final int PROPERTY_FILL_AFTER_MASK = 1;
    private static final int PROPERTY_FILL_BEFORE_MASK = 2;
    private static final int PROPERTY_MORPH_MATRIX_MASK = 64;
    private static final int PROPERTY_REPEAT_MODE_MASK = 4;
    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 16;
    private static final int PROPERTY_START_OFFSET_MASK = 8;
    private boolean mDirty;
    private boolean mHasAlpha;
    private long mLastEnd;
    private int mFlags = 0;
    private ArrayList<GLAnimation> mAnimations = new ArrayList<>();
    private GLTransformation mTempTransformation = new GLTransformation();

    public GLAnimationSet(boolean z5) {
        setFlag(16, z5);
        init();
    }

    private void init() {
        this.mStartTime = 0L;
    }

    private void setFlag(int i3, boolean z5) {
        if (z5) {
            this.mFlags = i3 | this.mFlags;
        } else {
            this.mFlags = (~i3) & this.mFlags;
        }
    }

    public void addAnimation(Animation animation) {
        this.mAnimations.add(animation.glAnimation);
        if ((this.mFlags & 64) == 0 && animation.glAnimation.willChangeTransformationMatrix()) {
            this.mFlags |= 64;
        }
        if ((this.mFlags & 128) == 0 && animation.glAnimation.willChangeBounds()) {
            this.mFlags |= 128;
        }
        if ((this.mFlags & 32) == 32) {
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else if (this.mAnimations.size() == 1) {
            long duration = animation.glAnimation.getDuration() + animation.glAnimation.getStartOffset();
            this.mDuration = duration;
            this.mLastEnd = this.mStartOffset + duration;
        } else {
            long max = Math.max(this.mLastEnd, animation.glAnimation.getDuration() + animation.glAnimation.getStartOffset());
            this.mLastEnd = max;
            this.mDuration = max - this.mStartOffset;
        }
        this.mDirty = true;
    }

    public void cleanAnimation() {
        this.mAnimations.clear();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long computeDurationHint() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long j4 = 0;
        for (int i3 = size - 1; i3 >= 0; i3--) {
            long computeDurationHint = arrayList.get(i3).computeDurationHint();
            if (computeDurationHint > j4) {
                j4 = computeDurationHint;
            }
        }
        return j4;
    }

    public List<GLAnimation> getAnimations() {
        return this.mAnimations;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getDuration() {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        if ((this.mFlags & 32) == 32) {
            return this.mDuration;
        }
        long j4 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            j4 = Math.max(j4, arrayList.get(i3).getDuration());
        }
        return j4;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getStartTime() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long j4 = Format.OFFSET_SAMPLE_RELATIVE;
        for (int i3 = 0; i3 < size; i3++) {
            j4 = Math.min(j4, arrayList.get(i3).getStartTime());
        }
        return j4;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean getTransformation(long j4, GLTransformation gLTransformation) {
        if (!this.mInitialized) {
            initialize();
        }
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        GLTransformation gLTransformation2 = this.mTempTransformation;
        gLTransformation.clear();
        boolean z5 = true;
        boolean z6 = false;
        boolean z8 = false;
        for (int i3 = size - 1; i3 >= 0; i3--) {
            GLAnimation gLAnimation = arrayList.get(i3);
            gLTransformation2.clear();
            z8 = gLAnimation.getTransformation(j4, gLTransformation, getScaleFactor()) || z8;
            z6 = z6 || gLAnimation.hasStarted();
            z5 = gLAnimation.hasEnded() && z5;
        }
        if (z6) {
            try {
                if (!this.mStarted) {
                    Animation.AnimationListener animationListener = this.mListener;
                    if (animationListener != null) {
                        animationListener.onAnimationStart();
                    }
                    this.mStarted = true;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (z5 != this.mEnded) {
            Animation.AnimationListener animationListener2 = this.mListener;
            if (animationListener2 != null) {
                animationListener2.onAnimationEnd();
            }
            this.mEnded = z5;
            return z8;
        }
        return z8;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean hasAlpha() {
        if (this.mDirty) {
            int i3 = 0;
            this.mHasAlpha = false;
            this.mDirty = false;
            int size = this.mAnimations.size();
            ArrayList<GLAnimation> arrayList = this.mAnimations;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (arrayList.get(i3).hasAlpha()) {
                    this.mHasAlpha = true;
                    break;
                }
                i3++;
            }
        }
        return this.mHasAlpha;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void initialize() {
        ArrayList<GLAnimation> arrayList;
        boolean z5;
        super.initialize();
        int i3 = this.mFlags;
        boolean z6 = (i3 & 32) == 32;
        boolean z8 = (i3 & 1) == 1;
        boolean z10 = (i3 & 2) == 2;
        boolean z11 = (i3 & 4) == 4;
        boolean z12 = (i3 & 16) == 16;
        boolean z13 = (i3 & 8) == 8;
        if (z12) {
            ensureInterpolator();
        }
        ArrayList<GLAnimation> arrayList2 = this.mAnimations;
        int size = arrayList2.size();
        long j4 = this.mDuration;
        boolean z14 = this.mFillAfter;
        boolean z15 = this.mFillBefore;
        int i10 = this.mRepeatMode;
        Interpolator interpolator = this.mInterpolator;
        boolean z16 = z13;
        long j10 = this.mStartOffset;
        int i11 = 0;
        while (i11 < size) {
            int i12 = i11;
            GLAnimation gLAnimation = arrayList2.get(i11);
            if (z6) {
                gLAnimation.setDuration(j4);
            }
            if (z8) {
                gLAnimation.setFillAfter(z14);
            }
            if (z10) {
                gLAnimation.setFillBefore(z15);
            }
            if (z11) {
                gLAnimation.setRepeatMode(i10);
            }
            if (z12) {
                gLAnimation.setInterpolator(interpolator);
            }
            if (z16) {
                arrayList = arrayList2;
                z5 = z6;
                gLAnimation.setStartOffset(gLAnimation.getStartOffset() + j10);
            } else {
                arrayList = arrayList2;
                z5 = z6;
            }
            gLAnimation.initialize();
            i11 = i12 + 1;
            z6 = z5;
            arrayList2 = arrayList;
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void reset() {
        super.reset();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void restrictDuration(long j4) {
        super.restrictDuration(j4);
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.get(i3).restrictDuration(j4);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void scaleCurrentDuration(float f2) {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.get(i3).scaleCurrentDuration(f2);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setDuration(long j4) {
        this.mFlags |= 32;
        super.setDuration(j4);
        this.mLastEnd = this.mStartOffset + this.mDuration;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillAfter(boolean z5) {
        this.mFlags |= 1;
        super.setFillAfter(z5);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillBefore(boolean z5) {
        this.mFlags |= 2;
        super.setFillBefore(z5);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setRepeatMode(int i3) {
        this.mFlags |= 4;
        super.setRepeatMode(i3);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartOffset(long j4) {
        this.mFlags |= 8;
        super.setStartOffset(j4);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartTime(long j4) {
        super.setStartTime(j4);
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.get(i3).setStartTime(j4);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeBounds() {
        return (this.mFlags & 128) == 128;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeTransformationMatrix() {
        return (this.mFlags & 64) == 64;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    /* renamed from: clone */
    public GLAnimationSet mo43clone() throws CloneNotSupportedException {
        GLAnimationSet gLAnimationSet = (GLAnimationSet) super.mo43clone();
        gLAnimationSet.mTempTransformation = new GLTransformation();
        gLAnimationSet.mAnimations = new ArrayList<>();
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i3 = 0; i3 < size; i3++) {
            gLAnimationSet.mAnimations.add(arrayList.get(i3).mo43clone());
        }
        return gLAnimationSet;
    }
}
