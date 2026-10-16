package com.bingoogolapple.qrcode.core;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.example.baselibrary.R$id;
import com.example.baselibrary.R$mipmap;
import com.example.baselibrary.R$styleable;
import com.example.test.R$string;
import com.example.test.ui.device.activity.ScanQrCodeActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.c0;
import f6.o1;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.e;
import kotlin.text.m;
import mc.g;
import t3.b;
import t3.c;
import t3.d;

/* loaded from: classes.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback {

    /* renamed from: o, reason: collision with root package name */
    public static final long[] f6859o = {255, 255, 255, 255};

    /* renamed from: a, reason: collision with root package name */
    public Camera f6860a;

    /* renamed from: b, reason: collision with root package name */
    public final CameraPreview f6861b;

    /* renamed from: c, reason: collision with root package name */
    public final ScanBoxView f6862c;

    /* renamed from: d, reason: collision with root package name */
    public d f6863d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public b f6864f;

    /* renamed from: g, reason: collision with root package name */
    public int f6865g;

    /* renamed from: h, reason: collision with root package name */
    public PointF[] f6866h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f6867i;

    /* renamed from: j, reason: collision with root package name */
    public BarcodeType f6868j;

    /* renamed from: k, reason: collision with root package name */
    public ValueAnimator f6869k;

    /* renamed from: l, reason: collision with root package name */
    public long f6870l;

    /* renamed from: m, reason: collision with root package name */
    public long f6871m;

    /* renamed from: n, reason: collision with root package name */
    public int f6872n;

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int a(int i3) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i10 = 0; i10 < Camera.getNumberOfCameras(); i10++) {
            try {
                Camera.getCameraInfo(i10, cameraInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cameraInfo.facing == i3) {
                return i10;
            }
        }
        return -1;
    }

    public final void b(byte[] bArr, Camera camera) {
        CameraPreview cameraPreview = this.f6861b;
        if (cameraPreview == null || !cameraPreview.c()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f6871m < 150) {
            return;
        }
        this.f6871m = currentTimeMillis;
        long j4 = camera.getParameters().getPreviewSize().width * camera.getParameters().getPreviewSize().height;
        if (Math.abs(bArr.length - (j4 * 1.5f)) < 1.0E-5f) {
            long j10 = 0;
            for (int i3 = 0; i3 < j4; i3 += 10) {
                j10 += bArr[i3] & 255;
            }
            long j11 = j10 / (j4 / 10);
            long[] jArr = f6859o;
            int i10 = this.f6872n % 4;
            this.f6872n = i10;
            jArr[i10] = j11;
            boolean z5 = true;
            this.f6872n = i10 + 1;
            int i11 = 0;
            while (true) {
                if (i11 >= 4) {
                    break;
                }
                if (jArr[i11] > 60) {
                    z5 = false;
                    break;
                }
                i11++;
            }
            d dVar = this.f6863d;
            if (dVar != null) {
                ScanQrCodeActivity scanQrCodeActivity = (ScanQrCodeActivity) dVar;
                eh.b bVar = scanQrCodeActivity.f7247z;
                String tipText = ((o1) bVar.getValue()).f13166c.getScanBoxView().getTipText();
                e.e(tipText, "getTipText(...)");
                String n4 = l0.n("\n", scanQrCodeActivity.getString(R$string.str_qr_light_tips));
                if (!z5) {
                    if (m.c(tipText, n4, false)) {
                        String substring = tipText.substring(0, m.j(tipText, n4, 0, false, 6));
                        e.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        ((o1) bVar.getValue()).f13166c.getScanBoxView().setTipText(substring);
                        return;
                    }
                    return;
                }
                if (m.c(tipText, n4, false)) {
                    return;
                }
                ((o1) bVar.getValue()).f13166c.getScanBoxView().setTipText(tipText + n4);
            }
        }
    }

    public final boolean c(PointF[] pointFArr, String str) {
        if (this.f6860a != null && this.f6862c != null && pointFArr.length >= 1) {
            ValueAnimator valueAnimator = this.f6869k;
            if ((valueAnimator != null && valueAnimator.isRunning()) || System.currentTimeMillis() - this.f6870l < 1200) {
                return true;
            }
            Camera.Parameters parameters = this.f6860a.getParameters();
            if (parameters.isZoomSupported()) {
                PointF pointF = pointFArr[0];
                float f2 = pointF.x;
                float f10 = pointF.y;
                PointF pointF2 = pointFArr[1];
                float f11 = pointF2.x;
                float f12 = pointF2.y;
                float abs = Math.abs(f2 - f11);
                float abs2 = Math.abs(f10 - f12);
                if (((int) Math.sqrt((abs2 * abs2) + (abs * abs))) <= this.f6862c.getRectWidth() / 4) {
                    int maxZoom = parameters.getMaxZoom();
                    post(new c(this, parameters.getZoom(), maxZoom / 4, maxZoom, str));
                    return true;
                }
            }
        }
        return false;
    }

    public abstract t3.e d(Bitmap bitmap);

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        PointF[] pointFArr;
        super.dispatchDraw(canvas);
        ScanBoxView scanBoxView = this.f6862c;
        if (scanBoxView == null || !scanBoxView.f6880d0 || (pointFArr = this.f6866h) == null) {
            return;
        }
        for (PointF pointF : pointFArr) {
            canvas.drawCircle(pointF.x, pointF.y, 10.0f, this.f6867i);
        }
        this.f6866h = null;
        postInvalidateDelayed(2000L);
    }

    public abstract t3.e e(int i3, int i10, byte[] bArr);

    public abstract void f();

    public final void g() {
        int i3 = this.f6865g;
        if (this.f6860a != null || Camera.getNumberOfCameras() == 0) {
            return;
        }
        int a3 = a(i3);
        if (a3 != -1) {
            h(a3);
            return;
        }
        if (i3 == 0) {
            a3 = a(1);
        } else if (i3 == 1) {
            a3 = a(0);
        }
        if (a3 != -1) {
            h(a3);
        }
    }

    public CameraPreview getCameraPreview() {
        return this.f6861b;
    }

    public boolean getIsScanBarcodeStyle() {
        return this.f6862c.getIsBarcode();
    }

    public ScanBoxView getScanBoxView() {
        return this.f6862c;
    }

    public final void h(int i3) {
        try {
            this.f6865g = i3;
            Camera open = Camera.open(i3);
            this.f6860a = open;
            this.f6861b.setCamera(open);
        } catch (Exception e) {
            e.printStackTrace();
            d dVar = this.f6863d;
            if (dVar != null) {
                dVar.getClass();
            }
        }
    }

    public final void i() {
        try {
            this.e = false;
            b bVar = this.f6864f;
            if (bVar != null) {
                if (bVar.getStatus() != AsyncTask.Status.FINISHED) {
                    bVar.cancel(true);
                }
                this.f6864f = null;
            }
            Camera camera = this.f6860a;
            if (camera != null) {
                try {
                    camera.setOneShotPreviewCallback(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ScanBoxView scanBoxView = this.f6862c;
            if (scanBoxView != null) {
                scanBoxView.setVisibility(8);
            }
            if (this.f6860a != null) {
                this.f6861b.f();
                this.f6861b.setCamera(null);
                this.f6860a.release();
                this.f6860a = null;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final PointF j(float f2, float f10, float f11, float f12, boolean z5, int i3, Rect rect) {
        PointF pointF;
        int width = getWidth();
        int height = getHeight();
        if (c0.h(getContext())) {
            float f13 = width;
            float f14 = height;
            pointF = new PointF((f12 - f2) * (f13 / f12), (f11 - f10) * (f14 / f11));
            float f15 = f14 - pointF.y;
            pointF.y = f15;
            pointF.x = f13 - pointF.x;
            if (rect == null) {
                pointF.y = f15 + i3;
            }
        } else {
            float f16 = width;
            pointF = new PointF(f2 * (f16 / f11), f10 * (height / f12));
            if (z5) {
                pointF.x = f16 - pointF.x;
            }
        }
        if (rect != null) {
            pointF.y += rect.top;
            pointF.x += rect.left;
        }
        return pointF;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f6869k;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        CameraPreview cameraPreview = this.f6861b;
        if (cameraPreview != null && cameraPreview.c()) {
            try {
                b(bArr, camera);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.e) {
            b bVar = this.f6864f;
            if (bVar == null || !(bVar.getStatus() == AsyncTask.Status.PENDING || this.f6864f.getStatus() == AsyncTask.Status.RUNNING)) {
                boolean h4 = c0.h(getContext());
                b bVar2 = new b();
                bVar2.f18494a = camera;
                bVar2.f18495b = bArr;
                bVar2.f18497d = new WeakReference(this);
                bVar2.f18496c = h4;
                bVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                this.f6864f = bVar2;
            }
        }
    }

    public void setDelegate(d dVar) {
        this.f6863d = dVar;
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.e = false;
        this.f6865g = 0;
        this.f6868j = BarcodeType.HIGH_FREQUENCY;
        this.f6870l = 0L;
        this.f6871m = System.currentTimeMillis();
        this.f6872n = 0;
        CameraPreview cameraPreview = new CameraPreview(context);
        this.f6861b = cameraPreview;
        cameraPreview.setDelegate(new g(this, 17));
        ScanBoxView scanBoxView = new ScanBoxView(context);
        this.f6862c = scanBoxView;
        scanBoxView.f6883f0 = this;
        TypedArray obtainStyledAttributes = scanBoxView.getContext().obtainStyledAttributes(attributeSet, R$styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == R$styleable.QRCodeView_qrcv_topOffset) {
                scanBoxView.f6892o = obtainStyledAttributes.getDimensionPixelSize(index, scanBoxView.f6892o);
            } else if (index == R$styleable.QRCodeView_qrcv_cornerSize) {
                scanBoxView.f6888k = obtainStyledAttributes.getDimensionPixelSize(index, scanBoxView.f6888k);
            } else if (index == R$styleable.QRCodeView_qrcv_cornerLength) {
                scanBoxView.f6887j = obtainStyledAttributes.getDimensionPixelSize(index, scanBoxView.f6887j);
            } else if (index == R$styleable.QRCodeView_qrcv_scanLineSize) {
                scanBoxView.f6893p = obtainStyledAttributes.getDimensionPixelSize(index, scanBoxView.f6893p);
            } else if (index == R$styleable.QRCodeView_qrcv_rectWidth) {
                scanBoxView.f6889l = obtainStyledAttributes.getDimensionPixelSize(index, scanBoxView.f6889l);
            } else if (index == R$styleable.QRCodeView_qrcv_maskColor) {
                scanBoxView.f6885h = obtainStyledAttributes.getColor(index, scanBoxView.f6885h);
            } else if (index == R$styleable.QRCodeView_qrcv_cornerColor) {
                scanBoxView.f6886i = obtainStyledAttributes.getColor(index, scanBoxView.f6886i);
            } else if (index == R$styleable.QRCodeView_qrcv_scanLineColor) {
                scanBoxView.f6894q = obtainStyledAttributes.getColor(index, scanBoxView.f6894q);
            } else if (index == R$styleable.QRCodeView_qrcv_scanLineMargin) {
                scanBoxView.r = obtainStyledAttributes.getDimensionPixelSize(index, scanBoxView.r);
            } else if (index == R$styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
                scanBoxView.f6895s = obtainStyledAttributes.getBoolean(index, scanBoxView.f6895s);
            } else if (index == R$styleable.QRCodeView_qrcv_customScanLineDrawable) {
                scanBoxView.f6896t = obtainStyledAttributes.getDrawable(index);
            } else if (index == R$styleable.QRCodeView_qrcv_borderSize) {
                scanBoxView.f6898v = obtainStyledAttributes.getDimensionPixelSize(index, scanBoxView.f6898v);
            } else if (index == R$styleable.QRCodeView_qrcv_borderColor) {
                scanBoxView.f6899w = obtainStyledAttributes.getColor(index, scanBoxView.f6899w);
            } else if (index == R$styleable.QRCodeView_qrcv_animTime) {
                scanBoxView.f6900x = obtainStyledAttributes.getInteger(index, scanBoxView.f6900x);
            } else if (index == R$styleable.QRCodeView_qrcv_verticalBias) {
                scanBoxView.f6901y = obtainStyledAttributes.getFloat(index, scanBoxView.f6901y);
            } else if (index == R$styleable.QRCodeView_qrcv_cornerDisplayType) {
                scanBoxView.f6902z = obtainStyledAttributes.getInteger(index, scanBoxView.f6902z);
            } else if (index == R$styleable.QRCodeView_qrcv_toolbarHeight) {
                scanBoxView.A = obtainStyledAttributes.getDimensionPixelSize(index, scanBoxView.A);
            } else if (index == R$styleable.QRCodeView_qrcv_barcodeRectHeight) {
                scanBoxView.f6891n = obtainStyledAttributes.getDimensionPixelSize(index, scanBoxView.f6891n);
            } else if (index == R$styleable.QRCodeView_qrcv_isBarcode) {
                scanBoxView.B = obtainStyledAttributes.getBoolean(index, scanBoxView.B);
            } else if (index == R$styleable.QRCodeView_qrcv_barCodeTipText) {
                scanBoxView.D = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.QRCodeView_qrcv_qrCodeTipText) {
                scanBoxView.C = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.QRCodeView_qrcv_tipTextSize) {
                scanBoxView.F = obtainStyledAttributes.getDimensionPixelSize(index, scanBoxView.F);
            } else if (index == R$styleable.QRCodeView_qrcv_tipTextColor) {
                scanBoxView.G = obtainStyledAttributes.getColor(index, scanBoxView.G);
            } else if (index == R$styleable.QRCodeView_qrcv_isTipTextBelowRect) {
                scanBoxView.H = obtainStyledAttributes.getBoolean(index, scanBoxView.H);
            } else if (index == R$styleable.QRCodeView_qrcv_tipTextMargin) {
                scanBoxView.I = obtainStyledAttributes.getDimensionPixelSize(index, scanBoxView.I);
            } else if (index == R$styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
                scanBoxView.J = obtainStyledAttributes.getBoolean(index, scanBoxView.J);
            } else if (index == R$styleable.QRCodeView_qrcv_isShowTipBackground) {
                scanBoxView.L = obtainStyledAttributes.getBoolean(index, scanBoxView.L);
            } else if (index == R$styleable.QRCodeView_qrcv_tipBackgroundColor) {
                scanBoxView.K = obtainStyledAttributes.getColor(index, scanBoxView.K);
            } else if (index == R$styleable.QRCodeView_qrcv_isScanLineReverse) {
                scanBoxView.M = obtainStyledAttributes.getBoolean(index, scanBoxView.M);
            } else if (index == R$styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
                scanBoxView.N = obtainStyledAttributes.getBoolean(index, scanBoxView.N);
            } else if (index == R$styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
                scanBoxView.O = obtainStyledAttributes.getDrawable(index);
            } else if (index == R$styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
                scanBoxView.f6878c0 = obtainStyledAttributes.getBoolean(index, scanBoxView.f6878c0);
            } else if (index == R$styleable.QRCodeView_qrcv_isShowLocationPoint) {
                scanBoxView.f6880d0 = obtainStyledAttributes.getBoolean(index, scanBoxView.f6880d0);
            } else if (index == R$styleable.QRCodeView_qrcv_isAutoZoom) {
                scanBoxView.f6881e0 = obtainStyledAttributes.getBoolean(index, scanBoxView.f6881e0);
            }
        }
        obtainStyledAttributes.recycle();
        Drawable drawable = scanBoxView.O;
        if (drawable != null) {
            scanBoxView.U = ((BitmapDrawable) drawable).getBitmap();
        }
        if (scanBoxView.U == null) {
            Bitmap decodeResource = BitmapFactory.decodeResource(scanBoxView.getResources(), R$mipmap.qrcode_default_grid_scan_line);
            scanBoxView.U = decodeResource;
            scanBoxView.U = c0.i(scanBoxView.f6894q, decodeResource);
        }
        Bitmap a3 = c0.a(scanBoxView.U);
        scanBoxView.V = a3;
        Bitmap a10 = c0.a(a3);
        scanBoxView.V = a10;
        scanBoxView.V = c0.a(a10);
        Drawable drawable2 = scanBoxView.f6896t;
        if (drawable2 != null) {
            scanBoxView.S = ((BitmapDrawable) drawable2).getBitmap();
        }
        if (scanBoxView.S == null) {
            Bitmap decodeResource2 = BitmapFactory.decodeResource(scanBoxView.getResources(), R$mipmap.qrcode_default_scan_line);
            scanBoxView.S = decodeResource2;
            scanBoxView.S = c0.i(scanBoxView.f6894q, decodeResource2);
        }
        scanBoxView.T = c0.a(scanBoxView.S);
        scanBoxView.f6892o += scanBoxView.A;
        scanBoxView.W = (scanBoxView.f6888k * 1.0f) / 2.0f;
        TextPaint textPaint = scanBoxView.f6884g;
        textPaint.setTextSize(scanBoxView.F);
        textPaint.setColor(scanBoxView.G);
        scanBoxView.setIsBarcode(scanBoxView.B);
        this.f6861b.setId(R$id.bgaqrcode_camera_preview);
        addView(this.f6861b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.f6861b.getId());
        layoutParams.addRule(8, this.f6861b.getId());
        addView(this.f6862c, layoutParams);
        Paint paint = new Paint();
        this.f6867i = paint;
        paint.setColor(getScanBoxView().getCornerColor());
        this.f6867i.setStyle(Paint.Style.FILL);
        f();
    }
}
