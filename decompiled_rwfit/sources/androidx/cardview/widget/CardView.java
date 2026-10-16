package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;
import com.example.test.utils.y;
import ec.a;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f1598f = {R.attr.colorBackground};

    /* renamed from: g, reason: collision with root package name */
    public static final a f1599g = new a(14);

    /* renamed from: a, reason: collision with root package name */
    public boolean f1600a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1601b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f1602c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f1603d;
    public final y e;

    public CardView(Context context) {
        this(context, null);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((l0.a) ((Drawable) this.e.f8773b)).f15671h;
    }

    public float getCardElevation() {
        return ((CardView) this.e.f8774c).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f1602c.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1602c.left;
    }

    public int getContentPaddingRight() {
        return this.f1602c.right;
    }

    public int getContentPaddingTop() {
        return this.f1602c.top;
    }

    public float getMaxCardElevation() {
        return ((l0.a) ((Drawable) this.e.f8773b)).e;
    }

    public boolean getPreventCornerOverlap() {
        return this.f1601b;
    }

    public float getRadius() {
        return ((l0.a) ((Drawable) this.e.f8773b)).f15665a;
    }

    public boolean getUseCompatPadding() {
        return this.f1600a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
    }

    public void setCardBackgroundColor(int i3) {
        ColorStateList valueOf = ColorStateList.valueOf(i3);
        l0.a aVar = (l0.a) ((Drawable) this.e.f8773b);
        if (valueOf == null) {
            aVar.getClass();
            valueOf = ColorStateList.valueOf(0);
        }
        aVar.f15671h = valueOf;
        aVar.f15666b.setColor(valueOf.getColorForState(aVar.getState(), aVar.f15671h.getDefaultColor()));
        aVar.invalidateSelf();
    }

    public void setCardElevation(float f2) {
        ((CardView) this.e.f8774c).setElevation(f2);
    }

    public void setMaxCardElevation(float f2) {
        f1599g.b(this.e, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i3) {
        super.setMinimumHeight(i3);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i3) {
        super.setMinimumWidth(i3);
    }

    @Override // android.view.View
    public final void setPadding(int i3, int i10, int i11, int i12) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i3, int i10, int i11, int i12) {
    }

    public void setPreventCornerOverlap(boolean z5) {
        if (z5 != this.f1601b) {
            this.f1601b = z5;
            a aVar = f1599g;
            y yVar = this.e;
            aVar.b(yVar, ((l0.a) ((Drawable) yVar.f8773b)).e);
        }
    }

    public void setRadius(float f2) {
        l0.a aVar = (l0.a) ((Drawable) this.e.f8773b);
        if (f2 == aVar.f15665a) {
            return;
        }
        aVar.f15665a = f2;
        aVar.b(null);
        aVar.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z5) {
        if (this.f1600a != z5) {
            this.f1600a = z5;
            a aVar = f1599g;
            y yVar = this.e;
            aVar.b(yVar, ((l0.a) ((Drawable) yVar.f8773b)).e);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int color;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f1602c = rect;
        this.f1603d = new Rect();
        y yVar = new y(this);
        this.e = yVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CardView, i3, R$style.CardView);
        if (obtainStyledAttributes.hasValue(R$styleable.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(R$styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1598f);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(R$color.cardview_light_background);
            } else {
                color = getResources().getColor(R$color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        float dimension = obtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardMaxElevation, 0.0f);
        this.f1600a = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardUseCompatPadding, false);
        this.f1601b = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPadding, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minWidth, 0);
        obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        a aVar = f1599g;
        l0.a aVar2 = new l0.a(valueOf, dimension);
        yVar.f8773b = aVar2;
        setBackgroundDrawable(aVar2);
        setClipToOutline(true);
        setElevation(dimension2);
        aVar.b(yVar, dimension3);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        l0.a aVar = (l0.a) ((Drawable) this.e.f8773b);
        if (colorStateList == null) {
            aVar.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        aVar.f15671h = colorStateList;
        aVar.f15666b.setColor(colorStateList.getColorForState(aVar.getState(), aVar.f15671h.getDefaultColor()));
        aVar.invalidateSelf();
    }
}
