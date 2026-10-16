package c5;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.appcompat.app.i0;
import androidx.recyclerview.widget.x;
import com.dh.imagepick.crop.CropImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import qd.g;

/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3382a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3383b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3384c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3385d;

    public a(String str, g gVar) {
        this.f3382a = 1;
        this.f3385d = new Handler(Looper.getMainLooper());
        this.f3383b = str;
        this.f3384c = gVar;
    }

    public void a(x xVar) {
        ((Handler) this.f3385d).post(new i0(8, this, xVar));
    }

    public void finalize() {
        switch (this.f3382a) {
            case 1:
                super.finalize();
                ((Handler) this.f3385d).removeCallbacksAndMessages(null);
                break;
            default:
                super.finalize();
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r1v18, types: [androidx.appcompat.app.i0, java.lang.Runnable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x009e -> B:19:0x00b9). Please report as a decompilation issue!!! */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        byte[] bArr;
        Object obj = this.f3385d;
        OutputStream outputStream = null;
        r1 = null;
        r1 = null;
        r1 = null;
        FileInputStream fileInputStream3 = null;
        outputStream = null;
        Object obj2 = this.f3383b;
        switch (this.f3382a) {
            case 0:
                Bitmap bitmap = (Bitmap) obj2;
                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
                File file = (File) this.f3384c;
                b bVar = CropImageView.H;
                CropImageView cropImageView = (CropImageView) obj;
                cropImageView.getClass();
                b bVar2 = CropImageView.H;
                try {
                    try {
                        try {
                            outputStream = cropImageView.getContext().getContentResolver().openOutputStream(Uri.fromFile(file));
                            if (outputStream != null) {
                                bitmap.compress(compressFormat, 90, outputStream);
                            }
                            Message.obtain(bVar2, 1001, file).sendToTarget();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Message.obtain(bVar2, 1002, file).sendToTarget();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
                cropImageView.E = false;
                bitmap.recycle();
                return;
            default:
                StringBuilder sb2 = new StringBuilder("file path : ");
                String str = (String) obj2;
                sb2.append(str);
                ee.c.b(2, "ReadFileThread", sb2.toString());
                try {
                    try {
                    } catch (IOException e12) {
                        e12.printStackTrace();
                        fileInputStream3 = fileInputStream3;
                    }
                    if (!(!TextUtils.isEmpty(str) ? new File(str).exists() : false)) {
                        a(com.google.android.gms.internal.mlkit_vision_common.i0.c(4097, "File path does not exist."));
                        return;
                    }
                    try {
                        fileInputStream2 = new FileInputStream(str);
                    } catch (FileNotFoundException e13) {
                        e = e13;
                    } catch (IOException e14) {
                        e = e14;
                    }
                    try {
                        byte[] bArr2 = new byte[fileInputStream2.available()];
                        int read = fileInputStream2.read(bArr2);
                        if (read >= 0) {
                            byte[] bArr3 = new byte[read];
                            System.arraycopy(bArr2, 0, bArr3, 0, read);
                            ?? i0Var = new i0(9, this, bArr3);
                            ((Handler) obj).post(i0Var);
                            bArr = i0Var;
                        } else {
                            a(com.google.android.gms.internal.mlkit_vision_common.i0.a(20485));
                            bArr = bArr2;
                        }
                        fileInputStream2.close();
                        fileInputStream3 = bArr;
                    } catch (FileNotFoundException e15) {
                        e = e15;
                        fileInputStream3 = fileInputStream2;
                        e.printStackTrace();
                        a(com.google.android.gms.internal.mlkit_vision_common.i0.a(20484));
                        if (fileInputStream3 != null) {
                            fileInputStream3.close();
                            fileInputStream3 = fileInputStream3;
                        }
                        return;
                    } catch (IOException e16) {
                        e = e16;
                        fileInputStream3 = fileInputStream2;
                        e.printStackTrace();
                        a(com.google.android.gms.internal.mlkit_vision_common.i0.c(20486, e.getMessage()));
                        if (fileInputStream3 != null) {
                            fileInputStream3.close();
                            fileInputStream3 = fileInputStream3;
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = fileInputStream3;
                }
        }
    }

    public a(CropImageView cropImageView, Bitmap bitmap, File file) {
        this.f3382a = 0;
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
        this.f3385d = cropImageView;
        this.f3383b = bitmap;
        this.f3384c = file;
    }
}
