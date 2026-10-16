package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public final class j extends AppCompatImageView implements m {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l f946d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(l lVar, Context context) {
        super(context, null, R$attr.actionOverflowButtonStyle);
        this.f946d = lVar;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        y3.a(this, getContentDescription());
        setOnTouchListener(new i(this, this, 0));
    }

    @Override // androidx.appcompat.widget.m
    public final boolean a() {
        return false;
    }

    @Override // androidx.appcompat.widget.m
    public final boolean b() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f946d.n();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i3, int i10, int i11, int i12) {
        boolean frame = super.setFrame(i3, i10, i11, i12);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            d1.b.f(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
        }
        return frame;
    }
}
