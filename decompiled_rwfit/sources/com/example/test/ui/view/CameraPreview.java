package com.example.test.ui.view;

import android.content.Context;
import android.hardware.camera2.CaptureRequest;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.util.concurrent.Semaphore;

/* loaded from: classes.dex */
public class CameraPreview extends TextureView {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f8347d = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f8348a;

    /* renamed from: b, reason: collision with root package name */
    public final Semaphore f8349b;

    /* renamed from: c, reason: collision with root package name */
    public File f8350c;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.append(0, 90);
        sparseIntArray.append(1, 0);
        sparseIntArray.append(2, SubsamplingScaleImageView.ORIENTATION_270);
        sparseIntArray.append(3, 180);
    }

    public CameraPreview(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i10));
    }

    public void setAutoFlash(CaptureRequest.Builder builder) {
    }

    public void setOnCameraListener(a7.a aVar) {
    }

    public void setOutPutDir(File file) {
        this.f8350c = file;
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8348a = 0;
        this.f8349b = new Semaphore(1);
        int i10 = 0;
        new a(this, i10);
        new b(this, i10);
        new c(this);
        this.f8350c = new File(getContext().getExternalFilesDir(null), "pic.jpg");
        com.example.baselibrary.utils.b.j(context);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
    }
}
