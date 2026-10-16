package com.dh.imagepick.preview.widgets;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public final class c extends SubsamplingScaleImageView.DefaultOnImageEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubsamplingScaleImageView2 f7176a;

    public c(SubsamplingScaleImageView2 subsamplingScaleImageView2) {
        this.f7176a = subsamplingScaleImageView2;
    }

    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.DefaultOnImageEventListener, com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
    public final void onImageLoaded() {
        this.f7176a.f7166b = null;
    }
}
