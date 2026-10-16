package com.google.android.material.bottomappbar;

import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10257a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10258b;

    /* renamed from: c, reason: collision with root package name */
    public int f10259c;

    /* renamed from: d, reason: collision with root package name */
    public final View f10260d;
    public final /* synthetic */ Object e;

    public e(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i3, boolean z5) {
        this.e = bottomAppBar;
        this.f10260d = actionMenuView;
        this.f10259c = i3;
        this.f10258b = z5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.f10260d;
        Object obj = this.e;
        switch (this.f10257a) {
            case 0:
                ((ActionMenuView) view).setTranslationX(((BottomAppBar) obj).A(r0, this.f10259c, this.f10258b));
                break;
            default:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) obj;
                p1.d dVar = bottomSheetBehavior.G;
                if (dVar == null || !dVar.g()) {
                    bottomSheetBehavior.C(this.f10259c);
                } else {
                    WeakHashMap weakHashMap = z0.f15748a;
                    h0.m(view, this);
                }
                this.f10258b = false;
                break;
        }
    }

    public e(BottomSheetBehavior bottomSheetBehavior, View view, int i3) {
        this.e = bottomSheetBehavior;
        this.f10260d = view;
        this.f10259c = i3;
    }
}
