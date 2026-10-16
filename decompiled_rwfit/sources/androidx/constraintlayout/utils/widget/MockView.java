package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class MockView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f1801a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f1802b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f1803c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1804d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public String f1805f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f1806g;

    /* renamed from: h, reason: collision with root package name */
    public int f1807h;

    /* renamed from: i, reason: collision with root package name */
    public int f1808i;

    /* renamed from: j, reason: collision with root package name */
    public int f1809j;

    /* renamed from: k, reason: collision with root package name */
    public int f1810k;

    public MockView(Context context) {
        super(context);
        this.f1801a = new Paint();
        this.f1802b = new Paint();
        this.f1803c = new Paint();
        this.f1804d = true;
        this.e = true;
        this.f1805f = null;
        this.f1806g = new Rect();
        this.f1807h = Color.argb(255, 0, 0, 0);
        this.f1808i = Color.argb(255, 200, 200, 200);
        this.f1809j = Color.argb(255, 50, 50, 50);
        this.f1810k = 4;
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.MockView_mock_label) {
                    this.f1805f = obtainStyledAttributes.getString(index);
                } else if (index == R$styleable.MockView_mock_showDiagonals) {
                    this.f1804d = obtainStyledAttributes.getBoolean(index, this.f1804d);
                } else if (index == R$styleable.MockView_mock_diagonalsColor) {
                    this.f1807h = obtainStyledAttributes.getColor(index, this.f1807h);
                } else if (index == R$styleable.MockView_mock_labelBackgroundColor) {
                    this.f1809j = obtainStyledAttributes.getColor(index, this.f1809j);
                } else if (index == R$styleable.MockView_mock_labelColor) {
                    this.f1808i = obtainStyledAttributes.getColor(index, this.f1808i);
                } else if (index == R$styleable.MockView_mock_showLabel) {
                    this.e = obtainStyledAttributes.getBoolean(index, this.e);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f1805f == null) {
            try {
                this.f1805f = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        int i10 = this.f1807h;
        Paint paint = this.f1801a;
        paint.setColor(i10);
        paint.setAntiAlias(true);
        int i11 = this.f1808i;
        Paint paint2 = this.f1802b;
        paint2.setColor(i11);
        paint2.setAntiAlias(true);
        this.f1803c.setColor(this.f1809j);
        this.f1810k = Math.round((getResources().getDisplayMetrics().xdpi / 160.0f) * this.f1810k);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f1804d) {
            width--;
            height--;
            float f2 = width;
            float f10 = height;
            canvas2 = canvas;
            canvas2.drawLine(0.0f, 0.0f, f2, f10, this.f1801a);
            canvas2.drawLine(0.0f, f10, f2, 0.0f, this.f1801a);
            canvas2.drawLine(0.0f, 0.0f, f2, 0.0f, this.f1801a);
            canvas2.drawLine(f2, 0.0f, f2, f10, this.f1801a);
            canvas2.drawLine(f2, f10, 0.0f, f10, this.f1801a);
            canvas2.drawLine(0.0f, f10, 0.0f, 0.0f, this.f1801a);
        } else {
            canvas2 = canvas;
        }
        String str = this.f1805f;
        if (str == null || !this.e) {
            return;
        }
        int length = str.length();
        Paint paint = this.f1802b;
        Rect rect = this.f1806g;
        paint.getTextBounds(str, 0, length, rect);
        float width2 = (width - rect.width()) / 2.0f;
        float height2 = ((height - rect.height()) / 2.0f) + rect.height();
        rect.offset((int) width2, (int) height2);
        int i3 = rect.left;
        int i10 = this.f1810k;
        rect.set(i3 - i10, rect.top - i10, rect.right + i10, rect.bottom + i10);
        canvas2.drawRect(rect, this.f1803c);
        canvas2.drawText(this.f1805f, width2, height2, paint);
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1801a = new Paint();
        this.f1802b = new Paint();
        this.f1803c = new Paint();
        this.f1804d = true;
        this.e = true;
        this.f1805f = null;
        this.f1806g = new Rect();
        this.f1807h = Color.argb(255, 0, 0, 0);
        this.f1808i = Color.argb(255, 200, 200, 200);
        this.f1809j = Color.argb(255, 50, 50, 50);
        this.f1810k = 4;
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1801a = new Paint();
        this.f1802b = new Paint();
        this.f1803c = new Paint();
        this.f1804d = true;
        this.e = true;
        this.f1805f = null;
        this.f1806g = new Rect();
        this.f1807h = Color.argb(255, 0, 0, 0);
        this.f1808i = Color.argb(255, 200, 200, 200);
        this.f1809j = Color.argb(255, 50, 50, 50);
        this.f1810k = 4;
        a(context, attributeSet);
    }
}
