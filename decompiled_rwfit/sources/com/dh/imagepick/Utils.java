package com.dh.imagepick;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import androidx.core.content.FileProvider;
import com.google.android.gms.internal.mlkit_vision_barcode.je;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.e;
import kotlin.text.m;
import r5.a;

/* loaded from: classes.dex */
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    private final byte[] bitmapToBytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                e.e(byteArray, "toByteArray(...)");
                try {
                    byteArrayOutputStream2.close();
                    return byteArray;
                } catch (IOException e) {
                    DevUtil.INSTANCE.e("ImagePick", e.toString());
                    return byteArray;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    e.c(byteArrayOutputStream);
                    byteArrayOutputStream.close();
                } catch (IOException e10) {
                    DevUtil.INSTANCE.e("ImagePick", e10.toString());
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private final File createImageFile(Context context) {
        return File.createTempFile("JPEG_RW_20240305_", ".jpg", context.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
    }

    public final boolean bitmapToFile(File file, Bitmap bm) {
        FileOutputStream fileOutputStream;
        e.f(file, "file");
        e.f(bm, "bm");
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            fileOutputStream.write(bitmapToBytes(bm));
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e10) {
                DevUtil.INSTANCE.e("ImagePick", e10.toString());
                return true;
            }
        } catch (IOException e11) {
            e = e11;
            fileOutputStream2 = fileOutputStream;
            DevUtil.INSTANCE.e("ImagePick", e.toString());
            try {
                e.c(fileOutputStream2);
                fileOutputStream2.close();
                return false;
            } catch (IOException e12) {
                DevUtil.INSTANCE.e("ImagePick", e12.toString());
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            try {
                e.c(fileOutputStream2);
                fileOutputStream2.close();
            } catch (IOException e13) {
                DevUtil.INSTANCE.e("ImagePick", e13.toString());
            }
            throw th;
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    public final File createSDCardFile$imagepick_release(Context context) throws IOException {
        e.f(context, "context");
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        e.e(format, "format(...)");
        File externalCacheDir = context.getExternalCacheDir();
        e.c(externalCacheDir);
        File file = new File(a.c(externalCacheDir.getPath(), "/", format));
        if (!file.exists()) {
            file.mkdir();
        }
        File createTempFile = File.createTempFile("JPEG_" + format + "_", ".jpg", file);
        e.e(createTempFile, "createTempFile(...)");
        return createTempFile;
    }

    public final Uri createUriFromFile$imagepick_release(Context context, File file) {
        e.f(context, "context");
        e.f(file, "file");
        if (!file.exists()) {
            file.mkdir();
        }
        return FileProvider.getUriForFile(context, context.getApplicationInfo().packageName + ".provider", file);
    }

    public final Bitmap getBitmapFromFile(String filePath) {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        e.f(filePath, "filePath");
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(filePath);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream2);
                    try {
                        BitmapFactory.decodeStream(bufferedInputStream, null, null);
                        fileInputStream2.close();
                        bufferedInputStream.close();
                        fileInputStream = new FileInputStream(filePath);
                        try {
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                            try {
                                Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream2, null, null);
                                bufferedInputStream2.close();
                                fileInputStream.close();
                                return decodeStream;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedInputStream = bufferedInputStream2;
                                e.c(bufferedInputStream);
                                bufferedInputStream.close();
                                e.c(fileInputStream);
                                fileInputStream.close();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = fileInputStream2;
                        th = th;
                        e.c(bufferedInputStream);
                        bufferedInputStream.close();
                        e.c(fileInputStream);
                        fileInputStream.close();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = null;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = null;
                fileInputStream = null;
            }
        } catch (IOException e) {
            DevUtil.INSTANCE.e("ImagePick", e.toString());
            return null;
        }
    }

    public final int getScreenHeight$imagepick_release(Context context) {
        e.f(context, "context");
        Object systemService = context.getSystemService("window");
        e.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final int getScreenWidth$imagepick_release(Context context) {
        e.f(context, "context");
        Object systemService = context.getSystemService("window");
        e.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public final boolean isActivityAvailable$imagepick_release(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (activity.isFinishing()) {
            DevUtil.INSTANCE.d("ImagePick", " activity is finishing :".concat(activity.getClass().getSimpleName()));
            return false;
        }
        if (!activity.isDestroyed()) {
            return true;
        }
        DevUtil.INSTANCE.d("ImagePick", " activity is destroyed :".concat(activity.getClass().getSimpleName()));
        return false;
    }

    public final boolean isHostAvailable$imagepick_release(b5.a host) {
        e.f(host, "host");
        return host.t() == 4;
    }

    public final boolean isOnMainThread$imagepick_release() {
        return e.a(Looper.myLooper(), Looper.getMainLooper());
    }

    @SuppressLint({"Recycle"})
    public final String uriToImagePath(Context context, Uri uri) {
        e.f(context, "context");
        e.f(uri, "uri");
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(uri, null, null, null, null);
            if (query == null || query.getCount() <= 0) {
                Log.e("qob", "cursor == null");
                return null;
            }
            query.moveToFirst();
            int columnIndex = query.getColumnIndex("_data");
            if (columnIndex < 0) {
                String str = query.getString(query.getColumnIndex("document_id"));
                if (str != null && m.c(str, "image:", false)) {
                    String substring = str.substring(6);
                    e.e(substring, "this as java.lang.String).substring(startIndex)");
                    query = contentResolver.query(Uri.parse("content://media/external/images/media/".concat(substring)), null, null, null, null);
                    if (query != null && query.getCount() > 0) {
                        query.moveToFirst();
                        columnIndex = query.getColumnIndex("_data");
                        if (columnIndex < 0) {
                            query.close();
                        }
                    }
                }
            }
            String string = query.getString(columnIndex);
            query.close();
            return string;
        }
        return null;
    }

    public final String uriToImagePath2(Context context, Uri contentUri) {
        e.f(context, "context");
        e.f(contentUri, "contentUri");
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return null;
        }
        InputStream openInputStream = contentResolver.openInputStream(contentUri);
        File createImageFile = createImageFile(context);
        if (createImageFile == null) {
            return null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(createImageFile);
            if (openInputStream == null) {
                return null;
            }
            try {
                try {
                    je.a(openInputStream, fileOutputStream);
                    String absolutePath = createImageFile.getAbsolutePath();
                    fileOutputStream.close();
                    openInputStream.close();
                    return absolutePath;
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
