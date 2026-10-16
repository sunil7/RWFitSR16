package y5;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.aps.amapapi.config.Const;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f20004a = {0, 49345, 49537, GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 49921, 960, GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, 49729, 50689, 1728, 1920, 51009, 1280, 50625, 50305, 1088, 52225, 3264, 3456, 52545, 3840, 53185, 52865, 3648, 2560, 51905, 52097, 2880, 51457, 2496, 2176, 51265, 55297, 6336, 6528, 55617, 6912, 56257, 55937, 6720, 7680, 57025, 57217, Const.I_GEO_MAX_TIME, 56577, 7616, 7296, 56385, 5120, 54465, 54657, 5440, 55041, 6080, 5760, 54849, 53761, 4800, 4992, 54081, 4352, 53697, 53377, 4160, 61441, 12480, 12672, 61761, 13056, 62401, 62081, 12864, 13824, 63169, 63361, 14144, 62721, 13760, 13440, 62529, 15360, 64705, 64897, 15680, 65281, 16320, 16000, 65089, 64001, 15040, 15232, 64321, 14592, 63937, 63617, 14400, 10240, 59585, 59777, 10560, 60161, 11200, 10880, 59969, 60929, 11968, 12160, 61249, 11520, 60865, 60545, 11328, 58369, 9408, 9600, 58689, 9984, 59329, 59009, 9792, 8704, 58049, 58241, 9024, 57601, 8640, 8320, 57409, 40961, 24768, 24960, 41281, 25344, 41921, 41601, 25152, 26112, 42689, 42881, 26432, 42241, 26048, 25728, 42049, 27648, 44225, 44417, 27968, 44801, 28608, 28288, 44609, 43521, 27328, 27520, 43841, 26880, 43457, 43137, 26688, 30720, 47297, 47489, 31040, 47873, 31680, 31360, 47681, 48641, 32448, 32640, 48961, 32000, 48577, 48257, 31808, 46081, 29888, 30080, 46401, 30464, 47041, 46721, 30272, 29184, 45761, 45953, 29504, 45313, 29120, 28800, 45121, 20480, 37057, 37249, 20800, 37633, 21440, 21120, 37441, 38401, 22208, 22400, 38721, 21760, 38337, 38017, 21568, 39937, 23744, 23936, 40257, 24320, 40897, 40577, 24128, 23040, 39617, 39809, 23360, 39169, 22976, 22656, 38977, 34817, 18624, 18816, 35137, 19200, 35777, 35457, 19008, 19968, 36545, 36737, 20288, 36097, 19904, 19584, 35905, 17408, 33985, 34177, 17728, 34561, 18368, 18048, 34369, 33281, 17088, 17280, 33601, 16640, 33217, 32897, 16448};

    /* renamed from: b, reason: collision with root package name */
    public static boolean f20005b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f20006c = false;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f20007d = false;

    public static String a(byte[] bArr) {
        int i3 = 0;
        for (byte b3 : bArr) {
            i3 = f20004a[(i3 ^ b3) & 255] ^ (i3 >> 8);
        }
        return String.format("%04x", Integer.valueOf(i3));
    }

    public static Bitmap b(Bitmap bitmap) {
        int width = bitmap.getWidth() < bitmap.getHeight() ? bitmap.getWidth() : bitmap.getHeight();
        Paint paint = new Paint(1);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.e.e(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        float f2 = width / 2;
        canvas.drawCircle(f2, f2, f2, paint);
        paint.reset();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static void c(int i3, String mac) {
        kotlin.jvm.internal.e.f(mac, "mac");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice remoteDevice = defaultAdapter.getRemoteDevice(mac);
        kotlin.jvm.internal.e.e(remoteDevice, "getRemoteDevice(...)");
        Log.e("qob", "createOrRemoveBond222 " + remoteDevice + " type " + remoteDevice.getType());
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BlueToothUtils", i3 == 1 ? "发起配对" : "发起取消配对");
        if (defaultAdapter.isEnabled()) {
            try {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return;
                    }
                    BluetoothDevice.class.getMethod("removeBond", null).invoke(remoteDevice, null);
                } else {
                    if (remoteDevice.getType() != 3) {
                        remoteDevice.createBond();
                        return;
                    }
                    Method method = BluetoothDevice.class.getMethod("createBond", Integer.TYPE);
                    kotlin.jvm.internal.e.e(method, "getMethod(...)");
                    method.invoke(remoteDevice, 1);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        }
    }

    public static Bitmap d(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        paint.setStrokeWidth(0.0f);
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, width, height), 22.0f, 22.0f, Path.Direction.CCW);
        path.close();
        canvas.drawPath(path, paint);
        return createBitmap;
    }

    public static boolean e(String deviceMac) {
        Object obj;
        kotlin.jvm.internal.e.f(deviceMac, "deviceMac");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        kotlin.jvm.internal.e.c(defaultAdapter);
        Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
        if (bondedDevices.size() <= 0) {
            return false;
        }
        Iterator<T> it = bondedDevices.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.jvm.internal.e.a(((BluetoothDevice) obj).getAddress(), deviceMac)) {
                break;
            }
        }
        return ((BluetoothDevice) obj) != null;
    }

    public static void f(Bitmap bitmap, String cachePath) {
        Bitmap d5;
        FileOutputStream fileOutputStream;
        kotlin.jvm.internal.e.f(cachePath, "cachePath");
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                d5 = d(bitmap);
                fileOutputStream = new FileOutputStream(cachePath);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e) {
            e = e;
        }
        try {
            fileOutputStream.write(b.k(d5));
            d5.recycle();
            fileOutputStream.close();
        } catch (FileNotFoundException e10) {
            e = e10;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "DialUtils", "表盘缩略图生成失败，" + e.getMessage());
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public static void g(Bitmap bitmap, String cachePath) {
        FileOutputStream fileOutputStream;
        kotlin.jvm.internal.e.f(cachePath, "cachePath");
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(cachePath);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e) {
            e = e;
        }
        try {
            fileOutputStream.write(b.k(bitmap));
            bitmap.recycle();
            fileOutputStream.close();
        } catch (FileNotFoundException e10) {
            e = e10;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "DialUtils", "表盘生成失败，" + e.getMessage());
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }
}
