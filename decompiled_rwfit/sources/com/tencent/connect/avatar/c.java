package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class c extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    final String f11810a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11811b;

    /* renamed from: c, reason: collision with root package name */
    private Matrix f11812c;

    /* renamed from: d, reason: collision with root package name */
    private Matrix f11813d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private float f11814f;

    /* renamed from: g, reason: collision with root package name */
    private float f11815g;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f11816h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f11817i;

    /* renamed from: j, reason: collision with root package name */
    private float f11818j;

    /* renamed from: k, reason: collision with root package name */
    private float f11819k;

    /* renamed from: l, reason: collision with root package name */
    private PointF f11820l;

    /* renamed from: m, reason: collision with root package name */
    private PointF f11821m;

    /* renamed from: n, reason: collision with root package name */
    private float f11822n;

    /* renamed from: o, reason: collision with root package name */
    private float f11823o;

    /* renamed from: p, reason: collision with root package name */
    private Rect f11824p;

    public c(Context context) {
        super(context);
        this.f11812c = new Matrix();
        this.f11813d = new Matrix();
        this.e = 0;
        this.f11814f = 1.0f;
        this.f11815g = 1.0f;
        this.f11817i = false;
        this.f11810a = "TouchView";
        this.f11820l = new PointF();
        this.f11821m = new PointF();
        this.f11822n = 1.0f;
        this.f11823o = 0.0f;
        this.f11811b = false;
        Rect rect = new Rect();
        this.f11824p = rect;
        getDrawingRect(rect);
        a();
    }

    private void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Animation animation;
        if (this.f11816h == null) {
            return;
        }
        float width = this.f11824p.width();
        float height = this.f11824p.height();
        float[] fArr = new float[9];
        this.f11812c.getValues(fArr);
        float f2 = fArr[2];
        float f10 = fArr[5];
        boolean z5 = false;
        float f11 = fArr[0];
        float f12 = this.f11814f;
        if (f11 > f12) {
            float f13 = f12 / f11;
            this.f11823o = f13;
            Matrix matrix = this.f11812c;
            PointF pointF = this.f11821m;
            matrix.postScale(f13, f13, pointF.x, pointF.y);
            setImageMatrix(this.f11812c);
            float f14 = this.f11823o;
            float f15 = 1.0f / f14;
            float f16 = 1.0f / f14;
            PointF pointF2 = this.f11821m;
            animation = new ScaleAnimation(f15, 1.0f, f16, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f17 = this.f11815g;
            if (f11 < f17) {
                float f18 = f17 / f11;
                this.f11823o = f18;
                Matrix matrix2 = this.f11812c;
                PointF pointF3 = this.f11821m;
                matrix2.postScale(f18, f18, pointF3.x, pointF3.y);
                float f19 = this.f11823o;
                PointF pointF4 = this.f11821m;
                animation = new ScaleAnimation(1.0f, f19, 1.0f, f19, pointF4.x, pointF4.y);
            } else {
                float width2 = this.f11816h.getWidth() * f11;
                float height2 = this.f11816h.getHeight() * f11;
                Rect rect = this.f11824p;
                int i3 = rect.left;
                float f20 = i3 - f2;
                int i10 = rect.top;
                float f21 = i10 - f10;
                if (f20 < 0.0f) {
                    f2 = i3;
                    z5 = true;
                }
                if (f21 < 0.0f) {
                    f10 = i10;
                    z5 = true;
                }
                float f22 = height2 - f21;
                if (width2 - f20 < width) {
                    f2 = i3 - (width2 - width);
                    z5 = true;
                }
                if (f22 < height) {
                    f10 = i10 - (height2 - height);
                    z5 = true;
                }
                if (z5) {
                    float f23 = fArr[2] - f2;
                    float f24 = fArr[5] - f10;
                    fArr[2] = f2;
                    fArr[5] = f10;
                    this.f11812c.setValues(fArr);
                    setImageMatrix(this.f11812c);
                    animation = new TranslateAnimation(f23, 0.0f, f24, 0.0f);
                } else {
                    setImageMatrix(this.f11812c);
                    animation = null;
                }
            }
        }
        if (animation != null) {
            this.f11817i = true;
            animation.setDuration(300L);
            startAnimation(animation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.clearAnimation();
                            c.this.b();
                        }
                    });
                    c.this.f11817i = false;
                }
            }).start();
        }
    }

    private void c() {
        if (this.f11816h == null) {
            return;
        }
        float[] fArr = {r1, 0.0f, this.f11818j, 0.0f, r1, r2, 0.0f, 0.0f, 0.0f};
        this.f11812c.getValues(fArr);
        float max = Math.max(this.f11824p.width() / this.f11816h.getWidth(), this.f11824p.height() / this.f11816h.getHeight());
        this.f11818j = this.f11824p.left - (((this.f11816h.getWidth() * max) - this.f11824p.width()) / 2.0f);
        float height = this.f11824p.top - (((this.f11816h.getHeight() * max) - this.f11824p.height()) / 2.0f);
        this.f11819k = height;
        this.f11812c.setValues(fArr);
        float min = Math.min(2048.0f / this.f11816h.getWidth(), 2048.0f / this.f11816h.getHeight());
        this.f11814f = min;
        this.f11815g = max;
        if (min < max) {
            this.f11814f = max;
        }
        setImageMatrix(this.f11812c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        if (r0 != 6) goto L28;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.f11817i
            r1 = 1
            if (r0 == 0) goto L6
            return r1
        L6:
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L90
            if (r0 == r1) goto L89
            r2 = 1092616192(0x41200000, float:10.0)
            r3 = 2
            if (r0 == r3) goto L37
            r4 = 5
            if (r0 == r4) goto L1d
            r6 = 6
            if (r0 == r6) goto L89
            goto Laf
        L1d:
            float r6 = r5.a(r6)
            r5.f11822n = r6
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 <= 0) goto Laf
            android.graphics.Matrix r6 = r5.f11813d
            android.graphics.Matrix r0 = r5.f11812c
            r6.set(r0)
            android.graphics.PointF r6 = r5.f11821m
            r5.a(r6)
            r5.e = r3
            goto Laf
        L37:
            int r0 = r5.e
            if (r0 != r1) goto L5f
            android.graphics.Matrix r0 = r5.f11812c
            android.graphics.Matrix r2 = r5.f11813d
            r0.set(r2)
            float r0 = r6.getX()
            android.graphics.PointF r2 = r5.f11820l
            float r2 = r2.x
            float r0 = r0 - r2
            float r6 = r6.getY()
            android.graphics.PointF r2 = r5.f11820l
            float r2 = r2.y
            float r6 = r6 - r2
            android.graphics.Matrix r2 = r5.f11812c
            r2.postTranslate(r0, r6)
            android.graphics.Matrix r6 = r5.f11812c
            r5.setImageMatrix(r6)
            goto Laf
        L5f:
            if (r0 != r3) goto Laf
            android.graphics.Matrix r0 = r5.f11812c
            r0.set(r0)
            float r6 = r5.a(r6)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L83
            android.graphics.Matrix r0 = r5.f11812c
            android.graphics.Matrix r2 = r5.f11813d
            r0.set(r2)
            float r0 = r5.f11822n
            float r6 = r6 / r0
            android.graphics.Matrix r0 = r5.f11812c
            android.graphics.PointF r2 = r5.f11821m
            float r3 = r2.x
            float r2 = r2.y
            r0.postScale(r6, r6, r3, r2)
        L83:
            android.graphics.Matrix r6 = r5.f11812c
            r5.setImageMatrix(r6)
            goto Laf
        L89:
            r5.b()
            r6 = 0
            r5.e = r6
            goto Laf
        L90:
            android.graphics.Matrix r0 = r5.f11812c
            android.graphics.Matrix r2 = r5.getImageMatrix()
            r0.set(r2)
            android.graphics.Matrix r0 = r5.f11813d
            android.graphics.Matrix r2 = r5.f11812c
            r0.set(r2)
            android.graphics.PointF r0 = r5.f11820l
            float r2 = r6.getX()
            float r6 = r6.getY()
            r0.set(r2, r6)
            r5.e = r1
        Laf:
            r5.f11811b = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.avatar.c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f11816h = bitmap;
        if (bitmap != null) {
            this.f11816h = bitmap;
        }
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x10 = motionEvent.getX(0) - motionEvent.getX(1);
        float y4 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((y4 * y4) + (x10 * x10));
    }

    public void a(Rect rect) {
        this.f11824p = rect;
        if (this.f11816h != null) {
            c();
        }
    }

    private void a(PointF pointF) {
        if (this.f11816h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f11812c.getValues(fArr);
        float f2 = fArr[2];
        float f10 = fArr[5];
        float f11 = fArr[0];
        float width = this.f11816h.getWidth() * f11;
        float height = this.f11816h.getHeight() * f11;
        Rect rect = this.f11824p;
        float f12 = rect.left - f2;
        if (f12 <= 1.0f) {
            f12 = 1.0f;
        }
        float f13 = (f2 + width) - rect.right;
        if (f13 <= 1.0f) {
            f13 = 1.0f;
        }
        float width2 = (rect.width() * f12) / (f13 + f12);
        Rect rect2 = this.f11824p;
        float f14 = width2 + rect2.left;
        float f15 = rect2.top - f10;
        float f16 = (f10 + height) - rect2.bottom;
        if (f15 <= 1.0f) {
            f15 = 1.0f;
        }
        pointF.set(f14, ((rect2.height() * f15) / ((f16 > 1.0f ? f16 : 1.0f) + f15)) + this.f11824p.top);
    }
}
