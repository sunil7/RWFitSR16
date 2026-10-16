package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.z1;

/* loaded from: classes.dex */
public interface OnItemSwipeListener {
    void clearView(z1 z1Var, int i3);

    void onItemSwipeMoving(Canvas canvas, z1 z1Var, float f2, float f10, boolean z5);

    void onItemSwipeStart(z1 z1Var, int i3);

    void onItemSwiped(z1 z1Var, int i3);
}
