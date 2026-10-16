package com.google.android.libraries.barhopper;

import com.google.android.apps.common.proguard.UsedByNative;

@UsedByNative("jni_common.cc")
/* loaded from: classes.dex */
public class RecognitionOptions {

    @UsedByNative("jni_common.cc")
    private int barcodeFormats = 0;

    @UsedByNative("jni_common.cc")
    private boolean outputUnrecognizedBarcodes = false;

    @UsedByNative("jni_common.cc")
    private boolean useQrMobilenetV3 = false;

    @UsedByNative("jni_common.cc")
    private boolean enableQrAlignmentGrid = true;

    @UsedByNative("jni_common.cc")
    private boolean enableUseKeypointAsFinderPattern = true;

    @UsedByNative("jni_common.cc")
    private boolean useHalideAffineCrop = false;

    @UsedByNative("jni_common.cc")
    private MultiScaleDecodingOptions multiScaleDecodingOptions = new MultiScaleDecodingOptions();

    @UsedByNative("jni_common.cc")
    private MultiScaleDetectionOptions multiScaleDetectionOptions = new MultiScaleDetectionOptions();

    @UsedByNative("jni_common.cc")
    private OnedRecognitionOptions onedRecognitionOptions = new OnedRecognitionOptions();

    @UsedByNative("jni_common.cc")
    private boolean qrEnableFourthCornerApproximation = false;

    public final void a(int i3) {
        this.barcodeFormats = i3;
    }

    public final void b() {
        this.enableQrAlignmentGrid = true;
    }

    public final void c() {
        this.enableUseKeypointAsFinderPattern = true;
    }

    public final void d(MultiScaleDecodingOptions multiScaleDecodingOptions) {
        this.multiScaleDecodingOptions = multiScaleDecodingOptions;
    }

    public final void e(MultiScaleDetectionOptions multiScaleDetectionOptions) {
        this.multiScaleDetectionOptions = multiScaleDetectionOptions;
    }

    public final void f(boolean z5) {
        this.outputUnrecognizedBarcodes = z5;
    }

    public final void g(boolean z5) {
        this.qrEnableFourthCornerApproximation = z5;
    }
}
