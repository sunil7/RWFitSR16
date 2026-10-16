package com.jieli.bmp_convert;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.camera.camera2.internal.compat.b;
import androidx.camera.camera2.internal.compat.h;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class BmpConvert {
    public static final int ERR_FILE_TYPE = -3588;
    public static final int ERR_INVALID_PARAM = -3584;
    public static final int ERR_IN_PROGRESS = -3587;
    public static final int ERR_IO_EXCEPTION = -3586;
    public static final int ERR_NOT_FOUND_FILE = -3585;
    public static final int TYPE_695N_RBG = 0;
    public static final int TYPE_701N_ARGB = 2;
    public static final int TYPE_701N_ARGB_NO_PACK = 4;
    public static final int TYPE_701N_JPEG = 9;
    public static final int TYPE_701N_RGB = 1;
    public static final int TYPE_701N_RGB_NO_PACK = 3;
    public static final int TYPE_707N_ARGB = 6;
    public static final int TYPE_707N_ARGB_NO_PACK = 8;
    public static final int TYPE_707N_RGB = 5;
    public static final int TYPE_707N_RGB_NO_PACK = 7;

    @Deprecated
    public static final int TYPE_BR_23 = 0;

    @Deprecated
    public static final int TYPE_BR_28 = 1;

    @Deprecated
    public static final int TYPE_BR_28_ALPHA = 2;

    @Deprecated
    public static final int TYPE_BR_28_ALPHA_RAW = 4;

    @Deprecated
    public static final int TYPE_BR_28_RAW = 3;

    /* renamed from: d, reason: collision with root package name */
    public static final String f11380d = "BmpConvert";
    public static final int[] e = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static boolean isLog = false;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f11381a;

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f11382b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f11383c = new Handler(Looper.getMainLooper());

    static {
        try {
            System.loadLibrary("jl_bmp_convert");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public BmpConvert() {
        b("init", String.format(Locale.ENGLISH, "Library name = %s(%d), clazz : %s", getLibVersionName(), Integer.valueOf(getLibVersionCode()), this));
    }

    public static int getLibVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    public static String getLibVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    public final /* synthetic */ void a(OnConvertListener onConvertListener, String str, ConvertParam convertParam, int i3, String str2) {
        if (onConvertListener != null) {
            this.f11383c.post(new h(this, 6, onConvertListener, str));
        }
        if (convertParam == null) {
            convertParam = new ConvertParam();
        }
        ConvertResult bitmapConvertAndCompressBlock = bitmapConvertAndCompressBlock(i3, str, str2, convertParam);
        if (onConvertListener != null) {
            this.f11383c.post(new b(this, bitmapConvertAndCompressBlock, onConvertListener, str2, 3));
        }
    }

    public final void b(String str) {
        if (!isLog || str == null || str.isEmpty()) {
            return;
        }
        Log.i(f11380d, str);
    }

    @Deprecated
    public void bitmapConvert(String str, String str2, OnConvertListener onConvertListener) {
        bitmapConvert(0, str, str2, onConvertListener);
    }

    public ConvertResult bitmapConvertAndCompressBlock(int i3, String str, String str2) {
        return bitmapConvertAndCompressBlock(i3, str, str2, new ConvertParam());
    }

    public int bitmapConvertBlock(int i3, String str, String str2) {
        ConvertResult bitmapConvertAndCompressBlock = bitmapConvertAndCompressBlock(i3, str, str2);
        return bitmapConvertAndCompressBlock == null ? ERR_INVALID_PARAM : bitmapConvertAndCompressBlock.getResult();
    }

    public native ConvertResult bmpConvert_native(int i3, String str, int i10, int i11, String str2, ConvertParam convertParam);

    public boolean isWorking() {
        return this.f11381a;
    }

    public void release() {
        b("release", "clazz : " + this);
        ExecutorService executorService = this.f11382b;
        if (executorService != null && !executorService.isShutdown()) {
            this.f11382b.shutdownNow();
        }
        this.f11382b = null;
        this.f11381a = false;
        this.f11383c.removeCallbacksAndMessages(null);
    }

    public void bitmapConvert(int i3, String str, String str2, OnConvertListener onConvertListener) {
        bitmapConvert(i3, str, str2, new ConvertParam(), onConvertListener);
    }

    public ConvertResult bitmapConvertAndCompressBlock(int i3, String str, String str2, ConvertParam convertParam) {
        File file;
        String str3 = str;
        if (a(i3)) {
            b("bitmapConvertAndCompressBlock", "Unknown Type : " + i3);
            return new ConvertResult().setAlgorithm(i3).setResult(ERR_INVALID_PARAM);
        }
        File file2 = new File(str3);
        if (!file2.exists() || !file2.isFile()) {
            b("bitmapConvertAndCompressBlock", "File not found. path : " + str3);
            return new ConvertResult().setAlgorithm(i3).setResult(ERR_NOT_FOUND_FILE);
        }
        if (isWorking()) {
            b("bitmapConvertAndCompressBlock", "Conversion in progress.");
            return new ConvertResult().setAlgorithm(i3).setResult(ERR_IN_PROGRESS);
        }
        this.f11381a = true;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeFile = BitmapFactory.decodeFile(str3, options);
        int width = decodeFile.getWidth();
        int height = decodeFile.getHeight();
        if (i3 != 9) {
            int i10 = width * height;
            int[] iArr = new int[i10];
            decodeFile.getPixels(iArr, 0, width, 0, 0, width, height);
            byte[] bArr = new byte[i10 * 4];
            for (int i11 = 0; i11 < i10; i11++) {
                int i12 = i11 << 2;
                int i13 = iArr[i11];
                bArr[i12] = (byte) (i13 & 255);
                bArr[i12 + 1] = (byte) ((i13 >> 8) & 255);
                bArr[i12 + 2] = (byte) ((i13 >> 16) & 255);
                bArr[i12 + 3] = (byte) ((i13 >> 24) & 255);
            }
            str3 = str3.substring(0, str3.lastIndexOf(".")) + ".bin";
            file = new File(str3);
            try {
                if (file.exists() && !file.delete()) {
                    b("bitmapConvertAndCompressBlock", "Failed to delete file. path : " + str3);
                }
                if (!file.createNewFile()) {
                    b("bitmapConvertAndCompressBlock", "Failed to create new file. path : " + str3);
                    this.f11381a = false;
                    return new ConvertResult().setAlgorithm(i3).setResult(ERR_IO_EXCEPTION);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str3);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
                b("bitmapConvertAndCompressBlock", "IOException : " + e10);
                this.f11381a = false;
                return new ConvertResult().setAlgorithm(i3).setResult(ERR_IO_EXCEPTION);
            }
        } else {
            if (!a(file2.getName())) {
                b("bitmapConvertAndCompressBlock", "It's not a JPG image.");
                return new ConvertResult().setAlgorithm(i3).setResult(ERR_FILE_TYPE);
            }
            file = null;
        }
        File file3 = file;
        String str4 = str3;
        ConvertResult bmpConvert_native = bmpConvert_native(i3, str4, width, height, str2, convertParam);
        b("bitmapConvertAndCompressBlock", "result : " + bmpConvert_native);
        if (bmpConvert_native.isConvertSuccess() && file3 != null && file3.exists() && !file3.delete()) {
            b("bitmapConvertAndCompressBlock", "Failed to delete cache file. path : " + str4);
        }
        this.f11381a = false;
        return bmpConvert_native;
    }

    public final void b(String str, String str2) {
        b(a(str, str2));
    }

    public void bitmapConvert(final int i3, final String str, final String str2, final ConvertParam convertParam, final OnConvertListener onConvertListener) {
        ExecutorService executorService = this.f11382b;
        if (executorService == null || executorService.isShutdown()) {
            this.f11382b = Executors.newSingleThreadExecutor();
        }
        this.f11382b.submit(new Runnable() { // from class: com.jieli.bmp_convert.a
            @Override // java.lang.Runnable
            public final void run() {
                BmpConvert.this.a(onConvertListener, str, convertParam, i3, str2);
            }
        });
    }

    public final /* synthetic */ void a(OnConvertListener onConvertListener, String str) {
        b("bitmapConvert", "start");
        onConvertListener.onStart(str);
    }

    public final /* synthetic */ void a(ConvertResult convertResult, OnConvertListener onConvertListener, String str) {
        b("bitmapConvert", "end ... " + convertResult);
        if (convertResult.isConvertSuccess()) {
            onConvertListener.onStop(true, str);
        } else {
            onConvertListener.onStop(false, (String) null);
        }
        onConvertListener.onStop(convertResult, str);
    }

    public final boolean a(int i3) {
        for (int i10 : e) {
            if (i10 == i3) {
                return false;
            }
        }
        return true;
    }

    public final boolean a(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(".jpg") || str.endsWith(".JPG") || str.endsWith(".jpeg") || str.endsWith(".JPEG");
    }

    public final String a(String str, String str2) {
        Locale locale = Locale.ENGLISH;
        return l0.p("[", str, "]\t", str2);
    }
}
