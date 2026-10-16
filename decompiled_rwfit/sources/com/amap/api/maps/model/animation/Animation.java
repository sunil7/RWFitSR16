package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.col.p0003sl.rc;
import com.amap.api.col.p0003sl.u4;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public abstract class Animation {
    public static final int FILL_MODE_BACKWARDS = 1;
    public static final int FILL_MODE_FORWARDS = 0;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;

    @JBindingInclude
    protected String animationType;
    public GLAnimation glAnimation;

    @JBindingInclude
    private AnimationListener mListener;

    @JBindingInclude
    private int fillMode = 0;

    @JBindingInclude
    private long duration = 500;

    @JBindingInclude
    private Interpolator interpolator = null;

    @JBindingInclude
    private boolean mFillBefore = true;

    @JBindingInclude
    private boolean mFillAfter = false;

    @JBindingInclude
    private boolean mFillEnabled = false;

    @JBindingInclude
    private int mRepeatCount = 0;

    @JBindingInclude
    private int mRepeatMode = 1;
    private AnimationUpdateFlags updateFlags = new AnimationUpdateFlags();

    @JBindingInclude
    public interface AnimationListener {
        @JBindingInclude
        void onAnimationEnd();

        @JBindingInclude
        void onAnimationStart();
    }

    @JBindingInclude
    public static class AnimationUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean mListenerUpdate = false;
        protected boolean durationUpdate = false;
        protected boolean interpolatorUpdate = false;
        protected boolean fillModeUpdate = false;
        protected boolean mFillEnabledUpdate = false;
        protected boolean mFillAfterUpdate = false;
        protected boolean mFillBeforeUpdate = false;
        protected boolean mRepeatCountUpdate = false;
        protected boolean mRepeatModeUpdate = false;

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.mListenerUpdate = false;
            this.durationUpdate = false;
            this.interpolatorUpdate = false;
            this.fillModeUpdate = false;
            this.mFillEnabledUpdate = false;
            this.mFillAfterUpdate = false;
            this.mFillBeforeUpdate = false;
            this.mRepeatCountUpdate = false;
            this.mRepeatModeUpdate = false;
        }
    }

    public class b implements AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        private final rc f5751a;

        /* renamed from: b, reason: collision with root package name */
        private final rc f5752b;

        public class a extends rc {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AnimationListener f5753a;

            public a(b bVar, Animation animation, AnimationListener animationListener) {
                this.f5753a = animationListener;
            }

            @Override // com.amap.api.col.p0003sl.rc
            public void runTask() {
                try {
                    AnimationListener animationListener = this.f5753a;
                    if (animationListener != null) {
                        animationListener.onAnimationStart();
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }

        /* renamed from: com.amap.api.maps.model.animation.Animation$b$b, reason: collision with other inner class name */
        public class C0011b extends rc {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AnimationListener f5754a;

            public C0011b(b bVar, Animation animation, AnimationListener animationListener) {
                this.f5754a = animationListener;
            }

            @Override // com.amap.api.col.p0003sl.rc
            public void runTask() {
                try {
                    AnimationListener animationListener = this.f5754a;
                    if (animationListener != null) {
                        animationListener.onAnimationEnd();
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public void onAnimationEnd() {
            u4.b().a(this.f5752b);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public void onAnimationStart() {
            u4.b().a(this.f5751a);
        }

        private b(Animation animation, AnimationListener animationListener) {
            this.f5751a = new a(this, animation, animationListener);
            this.f5752b = new C0011b(this, animation, animationListener);
        }
    }

    public Animation() {
        this.animationType = "typeAnimtionBase";
        this.glAnimation = null;
        this.glAnimation = new GLAnimation();
        this.animationType = getAnimationType();
    }

    public abstract String getAnimationType();

    public int getFillMode() {
        return this.fillMode;
    }

    public int getRepeatCount() {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatCount();
        }
        return 0;
    }

    public int getRepeatMode() {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatMode();
        }
        return 1;
    }

    @JBindingInclude
    public AnimationUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.mListener = new b(animationListener);
        this.glAnimation.setAnimationListener(animationListener);
        this.updateFlags.mListenerUpdate = true;
    }

    public void setDuration(long j4) {
        this.duration = j4;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setDuration(j4);
        }
        this.updateFlags.durationUpdate = true;
    }

    public void setFillMode(int i3) {
        this.fillMode = i3;
        if (i3 == 0) {
            this.mFillAfter = true;
            GLAnimation gLAnimation = this.glAnimation;
            if (gLAnimation != null) {
                gLAnimation.setFillAfter(true);
            }
            this.updateFlags.mFillAfterUpdate = true;
            this.mFillBefore = false;
            GLAnimation gLAnimation2 = this.glAnimation;
            if (gLAnimation2 != null) {
                gLAnimation2.setFillBefore(false);
            }
            this.updateFlags.mFillBeforeUpdate = true;
            this.mFillEnabled = false;
            GLAnimation gLAnimation3 = this.glAnimation;
            if (gLAnimation3 != null) {
                gLAnimation3.setFillEnabled(false);
            }
            this.updateFlags.mFillEnabledUpdate = true;
        } else {
            this.mFillAfter = false;
            GLAnimation gLAnimation4 = this.glAnimation;
            if (gLAnimation4 != null) {
                gLAnimation4.setFillAfter(false);
            }
            this.updateFlags.mFillAfterUpdate = true;
            this.mFillEnabled = true;
            GLAnimation gLAnimation5 = this.glAnimation;
            if (gLAnimation5 != null) {
                gLAnimation5.setFillEnabled(true);
            }
            this.updateFlags.mFillEnabledUpdate = true;
            this.mFillBefore = true;
            GLAnimation gLAnimation6 = this.glAnimation;
            if (gLAnimation6 != null) {
                gLAnimation6.setFillBefore(true);
            }
            this.updateFlags.mFillBeforeUpdate = true;
        }
        this.updateFlags.fillModeUpdate = true;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setInterpolator(interpolator);
        }
        this.updateFlags.interpolatorUpdate = true;
    }

    public void setRepeatCount(int i3) {
        this.mRepeatCount = i3;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatCount(i3);
        }
        this.updateFlags.mRepeatCountUpdate = true;
    }

    public void setRepeatMode(int i3) {
        this.mRepeatMode = i3;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatMode(i3);
        }
        this.updateFlags.mRepeatModeUpdate = true;
    }
}
