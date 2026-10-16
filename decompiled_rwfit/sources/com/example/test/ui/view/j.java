package com.example.test.ui.view;

import android.view.View;
import java.util.Timer;

/* loaded from: classes.dex */
public final class j implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LongClickView f8697a;

    public j(LongClickView longClickView) {
        this.f8697a = longClickView;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        LongClickView longClickView = this.f8697a;
        longClickView.f8477i = false;
        longClickView.f8475g.set(0);
        Timer timer = new Timer();
        longClickView.f8474f = timer;
        timer.schedule(new i(this, 0), 0L, longClickView.f8481m);
        return true;
    }
}
