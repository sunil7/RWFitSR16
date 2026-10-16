package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class NavigationMenuView extends RecyclerView implements h.z {
    public NavigationMenuView(Context context) {
        this(context, null);
    }

    @Override // h.z
    public final void a(h.k kVar) {
    }

    public int getWindowAnimations() {
        return 0;
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setLayoutManager(new LinearLayoutManager(1));
    }
}
