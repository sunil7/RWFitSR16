package androidx.viewpager.widget;

import a1.d;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import n2.b;

/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    public boolean A;
    public final int B;
    public boolean C;
    public float D;
    public float E;
    public final int F;

    /* renamed from: q, reason: collision with root package name */
    public int f2894q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public final int f2895s;

    /* renamed from: t, reason: collision with root package name */
    public final int f2896t;

    /* renamed from: u, reason: collision with root package name */
    public final int f2897u;

    /* renamed from: v, reason: collision with root package name */
    public final int f2898v;

    /* renamed from: w, reason: collision with root package name */
    public final Paint f2899w;

    /* renamed from: x, reason: collision with root package name */
    public final Rect f2900x;

    /* renamed from: y, reason: collision with root package name */
    public int f2901y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f2902z;

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public final void c(int i3, boolean z5, float f2) {
        int height = getHeight();
        TextView textView = this.f2907c;
        int left = textView.getLeft();
        int i10 = this.f2898v;
        int right = textView.getRight() + i10;
        int i11 = height - this.r;
        Rect rect = this.f2900x;
        rect.set(left - i10, i11, right, height);
        super.c(i3, z5, f2);
        this.f2901y = (int) (Math.abs(f2 - 0.5f) * 2.0f * 255.0f);
        rect.union(textView.getLeft() - i10, i11, textView.getRight() + i10, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f2902z;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f2897u);
    }

    public int getTabIndicatorColor() {
        return this.f2894q;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        TextView textView = this.f2907c;
        int left = textView.getLeft();
        int i3 = this.f2898v;
        int i10 = left - i3;
        int right = textView.getRight() + i3;
        int i11 = height - this.r;
        Paint paint = this.f2899w;
        paint.setColor((this.f2901y << 24) | (this.f2894q & 16777215));
        float f2 = height;
        canvas.drawRect(i10, i11, right, f2, paint);
        if (this.f2902z) {
            paint.setColor((this.f2894q & 16777215) | (-16777216));
            canvas.drawRect(getPaddingLeft(), height - this.B, getWidth() - getPaddingRight(), f2, paint);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.C) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y4 = motionEvent.getY();
        if (action == 0) {
            this.D = x10;
            this.E = y4;
            this.C = false;
            return true;
        }
        if (action == 1) {
            int left = this.f2907c.getLeft();
            int i3 = this.f2898v;
            if (x10 < left - i3) {
                ViewPager viewPager = this.f2905a;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                return true;
            }
            if (x10 > r5.getRight() + i3) {
                ViewPager viewPager2 = this.f2905a;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        } else if (action == 2) {
            float abs = Math.abs(x10 - this.D);
            float f2 = this.F;
            if (abs > f2 || Math.abs(y4 - this.E) > f2) {
                this.C = true;
                return true;
            }
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        super.setBackgroundColor(i3);
        if (this.A) {
            return;
        }
        this.f2902z = (i3 & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.A) {
            return;
        }
        this.f2902z = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        if (this.A) {
            return;
        }
        this.f2902z = i3 == 0;
    }

    public void setDrawFullUnderline(boolean z5) {
        this.f2902z = z5;
        this.A = true;
        invalidate();
    }

    @Override // android.view.View
    public final void setPadding(int i3, int i10, int i11, int i12) {
        int i13 = this.f2895s;
        if (i12 < i13) {
            i12 = i13;
        }
        super.setPadding(i3, i10, i11, i12);
    }

    public void setTabIndicatorColor(int i3) {
        this.f2894q = i3;
        this.f2899w.setColor(i3);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i3) {
        setTabIndicatorColor(d.a(getContext(), i3));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i3) {
        int i10 = this.f2896t;
        if (i3 < i10) {
            i3 = i10;
        }
        super.setTextSpacing(i3);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f2899w = paint;
        this.f2900x = new Rect();
        this.f2901y = 255;
        this.f2902z = false;
        this.A = false;
        int i3 = this.f2917n;
        this.f2894q = i3;
        paint.setColor(i3);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.r = (int) ((3.0f * f2) + 0.5f);
        this.f2895s = (int) ((6.0f * f2) + 0.5f);
        this.f2896t = (int) (64.0f * f2);
        this.f2898v = (int) ((16.0f * f2) + 0.5f);
        this.B = (int) ((1.0f * f2) + 0.5f);
        this.f2897u = (int) ((f2 * 32.0f) + 0.5f);
        this.F = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f2906b.setFocusable(true);
        this.f2906b.setOnClickListener(new b(this, 0));
        this.f2908d.setFocusable(true);
        this.f2908d.setOnClickListener(new b(this, 1));
        if (getBackground() == null) {
            this.f2902z = true;
        }
    }
}
