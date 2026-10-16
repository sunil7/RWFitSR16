package t3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.bingoogolapple.qrcode.core.QRCodeView;
import com.example.test.ui.device.activity.ScanQrCodeActivity;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class b extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public Camera f18494a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f18495b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18496c;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference f18497d;

    public final e a(QRCodeView qRCodeView) {
        int i3;
        int i10;
        byte[] bArr = this.f18495b;
        if (bArr != null) {
            int i11 = 0;
            try {
                Camera.Size previewSize = this.f18494a.getParameters().getPreviewSize();
                i10 = previewSize.width;
                try {
                    i3 = previewSize.height;
                } catch (Exception e) {
                    e = e;
                    i3 = 0;
                }
            } catch (Exception e10) {
                e = e10;
                i3 = 0;
            }
            try {
                new BitmapFactory.Options().inJustDecodeBounds = true;
                YuvImage yuvImage = new YuvImage(bArr, 17, i10, i3, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, i10, i3), 100, byteArrayOutputStream);
                BitmapFactory.Options options = new BitmapFactory.Options();
                Bitmap.Config config = Bitmap.Config.RGB_565;
                options.inPreferredConfig = config;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.toByteArray().length, options);
                int width = decodeByteArray.getWidth();
                int height = decodeByteArray.getHeight();
                Bitmap createBitmap = Bitmap.createBitmap(width, height, config);
                int i12 = width * height;
                int[] iArr = new int[i12];
                decodeByteArray.getPixels(iArr, 0, width, 0, 0, width, height);
                while (i11 < i12) {
                    iArr[i11] = ~iArr[i11];
                    i11++;
                }
                createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                return qRCodeView.d(createBitmap);
            } catch (Exception e11) {
                e = e11;
                i11 = i10;
                e.printStackTrace();
                if (i11 != 0 && i3 != 0) {
                    try {
                        return qRCodeView.e(i11, i3, bArr);
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                }
                return null;
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        int i3;
        Exception e;
        int i10;
        Exception exc;
        int i11;
        QRCodeView qRCodeView = (QRCodeView) this.f18497d.get();
        if (qRCodeView != null) {
            System.currentTimeMillis();
            byte[] bArr = this.f18495b;
            if (bArr != null) {
                try {
                    Camera.Size previewSize = this.f18494a.getParameters().getPreviewSize();
                    i3 = previewSize.width;
                    try {
                        i10 = previewSize.height;
                        try {
                            if (this.f18496c) {
                                bArr = new byte[this.f18495b.length];
                                for (int i12 = 0; i12 < i10; i12++) {
                                    for (int i13 = 0; i13 < i3; i13++) {
                                        bArr[(((i13 * i10) + i10) - i12) - 1] = this.f18495b[(i12 * i3) + i13];
                                    }
                                }
                                i11 = i10;
                                i10 = i3;
                            } else {
                                i11 = i3;
                            }
                        } catch (Exception e10) {
                            e = e10;
                            e.printStackTrace();
                            if (i3 == 0 && i10 != 0) {
                                try {
                                    return qRCodeView.e(i3, i10, bArr);
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                    return null;
                                }
                            }
                        }
                    } catch (Exception e12) {
                        exc = e12;
                        i10 = 0;
                    }
                } catch (Exception e13) {
                    i3 = 0;
                    e = e13;
                    i10 = 0;
                }
                try {
                    e e14 = qRCodeView.e(i11, i10, bArr);
                    e a3 = a(qRCodeView);
                    if (e14 != null && !TextUtils.isEmpty(e14.f18502a)) {
                        return e14;
                    }
                    if (a3 != null) {
                        if (!TextUtils.isEmpty(a3.f18502a)) {
                            return a3;
                        }
                    }
                } catch (Exception e15) {
                    exc = e15;
                    i3 = i11;
                    e = exc;
                    e.printStackTrace();
                    return i3 == 0 ? null : null;
                }
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        super.onCancelled();
        this.f18497d.clear();
        this.f18495b = null;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        e eVar = (e) obj;
        QRCodeView qRCodeView = (QRCodeView) this.f18497d.get();
        if (qRCodeView != null && qRCodeView.e) {
            String str = eVar == null ? null : eVar.f18502a;
            if (TextUtils.isEmpty(str)) {
                try {
                    Camera camera = qRCodeView.f6860a;
                    if (camera != null) {
                        camera.setOneShotPreviewCallback(qRCodeView);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            qRCodeView.e = false;
            try {
                d dVar = qRCodeView.f6863d;
                if (dVar != null) {
                    ((ScanQrCodeActivity) dVar).S0(str);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
