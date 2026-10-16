package com.google.android.gms.internal.mlkit_vision_barcode;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class nd {
    public static void a(AnimatorSet animatorSet, ArrayList arrayList) {
        int size = arrayList.size();
        long j4 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Animator animator = (Animator) arrayList.get(i3);
            j4 = Math.max(j4, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j4);
        arrayList.add(0, ofInt);
        animatorSet.playTogether(arrayList);
    }
}
