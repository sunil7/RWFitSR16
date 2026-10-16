package androidx.camera.core;

/* loaded from: classes.dex */
public class ImageCaptureException extends Exception {
    private final int mImageCaptureError;

    public ImageCaptureException(int i3, String str, Throwable th2) {
        super(str, th2);
        this.mImageCaptureError = i3;
    }

    public int getImageCaptureError() {
        return this.mImageCaptureError;
    }
}
