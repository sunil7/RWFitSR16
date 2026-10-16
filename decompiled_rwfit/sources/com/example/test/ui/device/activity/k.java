package com.example.test.ui.device.activity;

import android.widget.SeekBar;

/* loaded from: classes.dex */
public final class k implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomDialActivity f7871a;

    public k(CustomDialActivity customDialActivity) {
        this.f7871a = customDialActivity;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i3, boolean z5) {
        CustomDialActivity customDialActivity = this.f7871a;
        customDialActivity.T = false;
        CustomDialActivity.R0(customDialActivity).e.setAlpha((100 - i3) / 100.0f);
        customDialActivity.P = CustomDialActivity.R0(customDialActivity).e.getAlpha();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
    }
}
