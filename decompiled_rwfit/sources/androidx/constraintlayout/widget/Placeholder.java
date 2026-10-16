package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import w0.e;

/* loaded from: classes.dex */
public class Placeholder extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f1873a;

    /* renamed from: b, reason: collision with root package name */
    public View f1874b;

    /* renamed from: c, reason: collision with root package name */
    public int f1875c;

    public Placeholder(Context context) {
        super(context);
        this.f1873a = -1;
        this.f1874b = null;
        this.f1875c = 4;
        a(null);
    }

    public final void a(AttributeSet attributeSet) {
        super.setVisibility(this.f1875c);
        this.f1873a = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.ConstraintLayout_placeholder_content) {
                    this.f1873a = obtainStyledAttributes.getResourceId(index, this.f1873a);
                } else if (index == R$styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.f1875c = obtainStyledAttributes.getInt(index, this.f1875c);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public View getContent() {
        return this.f1874b;
    }

    public int getEmptyVisibility() {
        return this.f1875c;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((rect.height() / 2.0f) + (height / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i3) {
        View findViewById;
        if (this.f1873a == i3) {
            return;
        }
        View view = this.f1874b;
        if (view != null) {
            view.setVisibility(0);
            ((e) this.f1874b.getLayoutParams()).f19302e0 = false;
            this.f1874b = null;
        }
        this.f1873a = i3;
        if (i3 == -1 || (findViewById = ((View) getParent()).findViewById(i3)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i3) {
        this.f1875c = i3;
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1873a = -1;
        this.f1874b = null;
        this.f1875c = 4;
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1873a = -1;
        this.f1874b = null;
        this.f1875c = 4;
        a(attributeSet);
    }
}
