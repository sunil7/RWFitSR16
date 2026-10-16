package com.google.android.material.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.R$styleable;
import de.o;

/* loaded from: classes.dex */
public class TabItem extends View {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f10778a;

    /* renamed from: b, reason: collision with root package name */
    public final Drawable f10779b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10780c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o H = o.H(context, attributeSet, R$styleable.TabItem);
        int i3 = R$styleable.TabItem_android_text;
        TypedArray typedArray = (TypedArray) H.f12378c;
        this.f10778a = typedArray.getText(i3);
        this.f10779b = H.w(R$styleable.TabItem_android_icon);
        this.f10780c = typedArray.getResourceId(R$styleable.TabItem_android_layout, 0);
        H.K();
    }
}
