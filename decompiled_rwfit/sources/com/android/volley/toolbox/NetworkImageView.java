package com.android.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class NetworkImageView extends ImageView {
    public NetworkImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        int width = getWidth();
        int height = getHeight();
        if (width == 0 && height == 0) {
            return;
        }
        if (!TextUtils.isEmpty(null)) {
            throw null;
        }
        setImageBitmap(null);
    }

    public void setDefaultImageResId(int i3) {
    }

    public void setErrorImageResId(int i3) {
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
