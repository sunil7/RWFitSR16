package com.example.test.utils;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.example.test.ui.device.activity.TakePhotoActivity;
import java.io.File;

/* loaded from: classes.dex */
public final class p0 implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    public final File f8743a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaScannerConnection f8744b;

    public p0(TakePhotoActivity takePhotoActivity, File file) {
        this.f8743a = file;
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(takePhotoActivity, this);
        this.f8744b = mediaScannerConnection;
        mediaScannerConnection.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public final void onMediaScannerConnected() {
        MediaScannerConnection mediaScannerConnection = this.f8744b;
        if (mediaScannerConnection != null) {
            mediaScannerConnection.scanFile(this.f8743a.getAbsolutePath(), null);
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public final void onScanCompleted(String str, Uri uri) {
        MediaScannerConnection mediaScannerConnection = this.f8744b;
        if (mediaScannerConnection != null) {
            mediaScannerConnection.disconnect();
        }
    }
}
