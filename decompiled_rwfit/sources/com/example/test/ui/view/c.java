package com.example.test.ui.view;

import android.media.ImageReader;
import java.io.File;

/* loaded from: classes.dex */
public final class c implements ImageReader.OnImageAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CameraPreview f8675a;

    public c(CameraPreview cameraPreview) {
        this.f8675a = cameraPreview;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        int i3 = CameraPreview.f8347d;
        CameraPreview cameraPreview = this.f8675a;
        cameraPreview.getClass();
        imageReader.acquireNextImage();
        File file = cameraPreview.f8350c;
        throw null;
    }
}
