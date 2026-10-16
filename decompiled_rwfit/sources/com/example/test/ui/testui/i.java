package com.example.test.ui.testui;

import android.content.Intent;
import android.view.View;

/* loaded from: classes.dex */
public final class i implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingActivityFragment f8282a;

    public i(TRingActivityFragment tRingActivityFragment) {
        this.f8282a = tRingActivityFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TRingActivityFragment tRingActivityFragment = this.f8282a;
        tRingActivityFragment.startActivity(new Intent(tRingActivityFragment.f0(), (Class<?>) TRingSetpTargetActivity.class));
    }
}
