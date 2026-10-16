package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import com.amap.api.maps.model.LatLng;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class o4 {
    private static double a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d5 = latLng.latitude;
        double d8 = d5 - latLng3.latitude;
        double d10 = latLng.longitude;
        return ((d10 - latLng3.longitude) * (d5 - latLng2.latitude)) - ((d10 - latLng2.longitude) * d8);
    }

    private static boolean b(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d5 = latLng.longitude;
        double d8 = latLng2.longitude;
        double d10 = d5 - d8;
        double d11 = d10 > 0.0d ? d5 : d8;
        if (d10 >= 0.0d) {
            d5 = d8;
        }
        double d12 = latLng.latitude;
        double d13 = latLng2.latitude;
        double d14 = d12 - d13;
        double d15 = d14 > 0.0d ? d12 : d13;
        if (d14 >= 0.0d) {
            d12 = d13;
        }
        double d16 = latLng3.longitude;
        if (d5 > d16 || d16 > d11) {
            return false;
        }
        double d17 = latLng3.latitude;
        return d12 <= d17 && d17 <= d15;
    }

    public static void b(Context context, String str, String str2, Object obj) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        if (obj instanceof String) {
            edit.putString(str2, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str2, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str2, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str2, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str2, ((Long) obj).longValue());
        } else {
            edit.putString(str2, obj.toString());
        }
        edit.apply();
    }

    public static Drawable a(Context context, String str) throws Exception {
        int i3;
        InputStream open = s4.a(context).open(str);
        Bitmap decodeStream = BitmapFactory.decodeStream(open);
        int width = decodeStream.getWidth();
        int height = decodeStream.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i10 = 0; i10 < 32; i10++) {
            byteArrayOutputStream.write(0);
        }
        int i11 = width - 2;
        int[] iArr = new int[i11];
        decodeStream.getPixels(iArr, 0, width, 1, 0, i11, 1);
        boolean z5 = iArr[0] == -16777216;
        boolean z6 = iArr[width - 3] == -16777216;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            if (i12 != iArr[i14]) {
                i13++;
                a(byteArrayOutputStream, i14);
                i12 = iArr[i14];
            }
        }
        if (z6) {
            i13++;
            a(byteArrayOutputStream, i11);
        }
        int i15 = i13;
        int i16 = i15 + 1;
        if (z5) {
            i16 = i15;
        }
        if (z6) {
            i16--;
        }
        int i17 = i16;
        int i18 = height - 2;
        int[] iArr2 = new int[i18];
        decodeStream.getPixels(iArr2, 0, 1, 0, 1, 1, i18);
        boolean z8 = iArr2[0] == -16777216;
        boolean z10 = iArr2[height - 3] == -16777216;
        int i19 = 0;
        int i20 = 0;
        for (int i21 = 0; i21 < i18; i21++) {
            if (i19 != iArr2[i21]) {
                i20++;
                a(byteArrayOutputStream, i21);
                i19 = iArr2[i21];
            }
        }
        if (z10) {
            i20++;
            a(byteArrayOutputStream, i18);
        }
        int i22 = i20 + 1;
        if (z8) {
            i22 = i20;
        }
        if (z10) {
            i22--;
        }
        int i23 = 0;
        while (true) {
            i3 = i17 * i22;
            if (i23 >= i3) {
                break;
            }
            a(byteArrayOutputStream, 1);
            i23++;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArray[0] = 1;
        byteArray[1] = (byte) i15;
        byteArray[2] = (byte) i20;
        byteArray[3] = (byte) i3;
        int width2 = decodeStream.getWidth();
        int i24 = width2 - 2;
        int[] iArr3 = new int[i24];
        decodeStream.getPixels(iArr3, 0, i24, 1, decodeStream.getHeight() - 1, i24, 1);
        int i25 = 0;
        while (true) {
            if (i25 >= i24) {
                break;
            }
            if (-16777216 == iArr3[i25]) {
                a(byteArray, 12, i25);
                break;
            }
            i25++;
        }
        int i26 = width2 - 3;
        while (true) {
            if (i26 < 0) {
                break;
            }
            if (-16777216 == iArr3[i26]) {
                a(byteArray, 16, (i24 - i26) - 2);
                break;
            }
            i26--;
        }
        int height2 = decodeStream.getHeight();
        int i27 = height2 - 2;
        int[] iArr4 = new int[i27];
        decodeStream.getPixels(iArr4, 0, 1, decodeStream.getWidth() - 1, 0, 1, i27);
        int i28 = 0;
        while (true) {
            if (i28 >= i27) {
                break;
            }
            if (-16777216 == iArr4[i28]) {
                a(byteArray, 20, i28);
                break;
            }
            i28++;
        }
        int i29 = height2 - 3;
        while (true) {
            if (i29 < 0) {
                break;
            }
            if (-16777216 == iArr4[i29]) {
                a(byteArray, 24, (i27 - i29) - 2);
                break;
            }
            i29--;
        }
        if (NinePatch.isNinePatchChunk(byteArray)) {
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
            v4.a(decodeStream);
            if (Build.VERSION.SDK_INT >= 28) {
                Method declaredMethod = createBitmap.getClass().getDeclaredMethod("setNinePatchChunk", byte[].class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(createBitmap, byteArray);
            } else {
                Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
                declaredField.setAccessible(true);
                declaredField.set(createBitmap, byteArray);
            }
            decodeStream = createBitmap;
        }
        open.close();
        if (decodeStream.getNinePatchChunk() == null) {
            return new BitmapDrawable(context.getResources(), decodeStream);
        }
        Rect rect = new Rect();
        byte[] ninePatchChunk = decodeStream.getNinePatchChunk();
        rect.left = a(ninePatchChunk, 12);
        rect.right = a(ninePatchChunk, 16);
        rect.top = a(ninePatchChunk, 20);
        rect.bottom = a(ninePatchChunk, 24);
        return new NinePatchDrawable(context.getResources(), decodeStream, decodeStream.getNinePatchChunk(), rect, null);
    }

    public static boolean a(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4) {
        double a3 = a(latLng3, latLng4, latLng);
        double a10 = a(latLng3, latLng4, latLng2);
        double a11 = a(latLng, latLng2, latLng3);
        double a12 = a(latLng, latLng2, latLng4);
        if (((a3 > 0.0d && a10 < 0.0d) || (a3 < 0.0d && a10 > 0.0d)) && ((a11 > 0.0d && a12 < 0.0d) || (a11 < 0.0d && a12 > 0.0d))) {
            return true;
        }
        if (a3 == 0.0d && b(latLng3, latLng4, latLng)) {
            return true;
        }
        if (a10 == 0.0d && b(latLng3, latLng4, latLng2)) {
            return true;
        }
        if (a11 == 0.0d && b(latLng, latLng2, latLng3)) {
            return true;
        }
        return a12 == 0.0d && b(latLng, latLng2, latLng4);
    }

    public static String a(Context context, String str, String str2, String str3) {
        Object a3 = a(context, str, str2, (Object) str3);
        return a3 != null ? (String) a3 : str3;
    }

    public static Long a(Context context, String str, String str2, Long l3) {
        Object a3 = a(context, str, str2, (Object) l3);
        return a3 != null ? (Long) a3 : l3;
    }

    private static Object a(Context context, String str, String str2, Object obj) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (obj instanceof String) {
            return sharedPreferences.getString(str2, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str2, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str2, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str2, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str2, ((Long) obj).longValue()));
        }
        return null;
    }

    private static void a(OutputStream outputStream, int i3) throws IOException {
        outputStream.write(i3 & 255);
        outputStream.write((i3 >> 8) & 255);
        outputStream.write((i3 >> 16) & 255);
        outputStream.write((i3 >> 24) & 255);
    }

    private static void a(byte[] bArr, int i3, int i10) {
        bArr[i3] = (byte) i10;
        bArr[i3 + 1] = (byte) (i10 >> 8);
        bArr[i3 + 2] = (byte) (i10 >> 16);
        bArr[i3 + 3] = (byte) (i10 >> 24);
    }

    private static int a(byte[] bArr, int i3) {
        byte b3 = bArr[i3];
        byte b10 = bArr[i3 + 1];
        byte b11 = bArr[i3 + 2];
        return (bArr[i3 + 3] << 24) | (b3 & 255) | (b10 << 8) | (b11 << 16);
    }
}
