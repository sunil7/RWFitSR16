package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.open.log.SLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static String f12087c;

    /* renamed from: a, reason: collision with root package name */
    private String f12088a;

    /* renamed from: b, reason: collision with root package name */
    private d f12089b;

    /* renamed from: d, reason: collision with root package name */
    private long f12090d;
    private Handler e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<Activity> f12091f;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f12092g = new Runnable() { // from class: com.tencent.open.utils.c.2
        @Override // java.lang.Runnable
        public void run() {
            boolean z5;
            SLog.v("AsynLoadImg", "saveFileRunnable:");
            String o3 = l0.o("share_qq_", m.g(c.this.f12088a), ".jpg");
            String str = c.f12087c + o3;
            File file = new File(str);
            Message obtainMessage = c.this.e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str;
                SLog.v("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - c.this.f12090d));
            } else {
                Bitmap a3 = c.a(c.this.f12088a);
                if (a3 != null) {
                    z5 = c.this.a(a3, o3);
                } else {
                    SLog.v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z5 = false;
                }
                if (z5) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str;
                } else {
                    obtainMessage.arg1 = 1;
                }
                SLog.v("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - c.this.f12090d));
            }
            c.this.e.sendMessage(obtainMessage);
        }
    };

    public c(Activity activity) {
        this.f12091f = new WeakReference<>(activity);
        this.e = new Handler(activity.getMainLooper()) { // from class: com.tencent.open.utils.c.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                SLog.v("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    c.this.f12089b.a(message.arg1, (String) message.obj);
                } else {
                    c.this.f12089b.a(message.arg1, (String) null);
                }
            }
        };
    }

    public void a(String str, d dVar) {
        SLog.v("AsynLoadImg", "--save---");
        if (str != null && !str.equals("")) {
            if (!m.a()) {
                dVar.a(2, (String) null);
                return;
            }
            if (this.f12091f.get() != null) {
                Activity activity = this.f12091f.get();
                File h4 = m.h(activity, "Images");
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (h4 == null) {
                    SLog.e("AsynLoadImg", "externalImageFile is null");
                    dVar.a(2, (String) null);
                    return;
                }
                f12087c = r5.a.f(new StringBuilder(), k.d(activity) ? h4.getAbsolutePath() : externalStorageDirectory.getAbsolutePath(), "/tmp/");
            }
            this.f12090d = System.currentTimeMillis();
            this.f12088a = str;
            this.f12089b = dVar;
            new Thread(this.f12092g).start();
            return;
        }
        dVar.a(1, (String) null);
    }

    public boolean a(Bitmap bitmap, String str) {
        BufferedOutputStream bufferedOutputStream;
        String str2 = f12087c;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                SLog.v("AsynLoadImg", "saveFile:" + str);
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
            bufferedOutputStream.flush();
            try {
                bufferedOutputStream.close();
                return true;
            } catch (IOException e10) {
                e10.printStackTrace();
                return true;
            }
        } catch (IOException e11) {
            e = e11;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            SLog.e("AsynLoadImg", "saveFile bmp fail---", e);
            if (bufferedOutputStream2 == null) {
                return false;
            }
            try {
                bufferedOutputStream2.close();
                return false;
            } catch (IOException e12) {
                e12.printStackTrace();
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static Bitmap a(String str) {
        SLog.v("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            SLog.v("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (IOException e) {
            e.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
