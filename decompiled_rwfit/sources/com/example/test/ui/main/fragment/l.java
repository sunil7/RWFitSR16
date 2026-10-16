package com.example.test.ui.main.fragment;

import android.widget.SeekBar;
import com.google.android.gms.internal.mlkit_vision_barcode.tb;

/* loaded from: classes.dex */
public final class l implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeadsetFragment f8113a;

    public l(HeadsetFragment headsetFragment) {
        this.f8113a = headsetFragment;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i3, boolean z5) {
        r5.a.h(i3, "onProgressChanged ", "qob");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        kotlin.jvm.internal.e.c(seekBar);
        xd.a a3 = tb.a(new byte[]{90, -91, 71, 5, (byte) seekBar.getProgress()});
        k6.b bVar = this.f8113a.f8070c;
        if (bVar != null) {
            bVar.i(a3, null);
        }
    }
}
