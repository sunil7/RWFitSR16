package com.example.test.ui.main.fragment;

import androidx.recyclerview.widget.c0;
import com.example.test.ui.main.model.BaseDataModel;

/* loaded from: classes.dex */
public final class m extends c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HomeFragment f8114a;

    public m(HomeFragment homeFragment) {
        this.f8114a = homeFragment;
    }

    @Override // androidx.recyclerview.widget.c0
    public final int getSpanSize(int i3) {
        HomeFragment homeFragment = this.f8114a;
        return (((BaseDataModel) homeFragment.q0().get(i3)).getType() == 0 || ((BaseDataModel) homeFragment.q0().get(i3)).getType() == 10087) ? 2 : 1;
    }
}
