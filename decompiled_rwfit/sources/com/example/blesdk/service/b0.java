package com.example.blesdk.service;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.le;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import okhttp3.internal.http2.Settings;

/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f7293a;

    /* renamed from: d, reason: collision with root package name */
    public static int f7296d;

    /* renamed from: g, reason: collision with root package name */
    public static int f7298g;

    /* renamed from: h, reason: collision with root package name */
    public static com.example.test.presenter.device.e f7299h;

    /* renamed from: b, reason: collision with root package name */
    public static TelinkOtaService$OtaPhase f7294b = TelinkOtaService$OtaPhase.IDLE;

    /* renamed from: c, reason: collision with root package name */
    public static byte[] f7295c = new byte[0];
    public static int e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f7297f = 16;

    /* renamed from: i, reason: collision with root package name */
    public static final Handler f7300i = new Handler(Looper.getMainLooper());

    /* renamed from: j, reason: collision with root package name */
    public static final z f7301j = new z(0);

    public static void a() {
        if (f7293a) {
            int i3 = a0.f7280a[f7294b.ordinal()];
            if (i3 == 1) {
                f7294b = TelinkOtaService$OtaPhase.SENDING_START;
                e(new byte[]{1, -1});
                return;
            }
            if (i3 == 2) {
                c();
                return;
            }
            if (i3 == 3) {
                c();
                return;
            }
            if (i3 != 4) {
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "TelinkOtaService", "Telink OTA End命令发送完成");
            b();
            com.example.test.presenter.device.e eVar = f7299h;
            if (eVar != null) {
                eVar.b(1.0f);
                com.example.test.presenter.device.e eVar2 = f7299h;
                if (eVar2 != null) {
                    eVar2.onFinish();
                } else {
                    kotlin.jvm.internal.e.m("fileCallback");
                    throw null;
                }
            }
        }
    }

    public static void b() {
        f7293a = false;
        f7294b = TelinkOtaService$OtaPhase.IDLE;
        e = -1;
        f7296d = 0;
        f7298g = 0;
        f7295c = new byte[0];
        f7300i.removeCallbacksAndMessages(null);
    }

    public static void c() {
        if (f7293a) {
            int i3 = e + 1;
            if (i3 >= f7296d) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "TelinkOtaService", "所有数据包发送完毕,发送OTA End");
                f7294b = TelinkOtaService$OtaPhase.SENDING_END;
                int i10 = e;
                byte[] bArr = new byte[20];
                bArr[0] = 2;
                bArr[1] = -1;
                bArr[2] = (byte) (i10 & 255);
                bArr[3] = (byte) ((i10 >> 8) & 255);
                int i11 = ~i10;
                bArr[4] = (byte) (i11 & 255);
                bArr[5] = (byte) ((i11 >> 8) & 255);
                e(bArr);
                return;
            }
            f7294b = TelinkOtaService$OtaPhase.SENDING_DATA;
            int i12 = f7297f;
            int i13 = i3 * i12;
            int length = f7295c.length - i13;
            if (length >= i12) {
                length = i12;
            }
            if (length != i12) {
                i12 = ((length / 16) + 1) * 16;
            }
            int i14 = i12 + 4;
            byte[] bArr2 = new byte[i14];
            for (int i15 = 0; i15 < i14; i15++) {
                bArr2[i15] = -1;
            }
            bArr2[0] = (byte) (i3 & 255);
            bArr2[1] = (byte) ((i3 >> 8) & 255);
            System.arraycopy(f7295c, i13, bArr2, 2, length);
            int i16 = i12 + 2;
            int[] iArr = {0, 40961};
            int i17 = 65535;
            for (int i18 = 0; i18 < i16; i18++) {
                int i19 = bArr2[i18];
                for (int i20 = 0; i20 < 8; i20++) {
                    i17 = (iArr[(i17 ^ i19) & 1] ^ (i17 >> 1)) & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
                    i19 >>= 1;
                }
            }
            bArr2[i16] = (byte) (i17 & 255);
            bArr2[i12 + 3] = (byte) ((i17 >> 8) & 255);
            e = i3;
            e(bArr2);
            float f2 = (e + 1) / f7296d;
            int i21 = (int) (100 * f2);
            if (i21 != f7298g) {
                f7298g = i21;
                com.example.test.presenter.device.e eVar = f7299h;
                if (eVar != null) {
                    eVar.b(f2);
                }
            }
        }
    }

    public static void d(String filePath, com.example.test.presenter.device.e callback) {
        kotlin.jvm.internal.e.f(filePath, "filePath");
        kotlin.jvm.internal.e.f(callback, "callback");
        f7299h = callback;
        if (f7293a) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "TelinkOtaService", "OTA正在进行中");
            return;
        }
        if (!r5.b.k().f18054c) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "TelinkOtaService", "设备未连接");
            com.example.test.presenter.device.e eVar = f7299h;
            if (eVar != null) {
                eVar.a(1);
                return;
            } else {
                kotlin.jvm.internal.e.m("fileCallback");
                throw null;
            }
        }
        try {
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                byte[] a3 = le.a(file);
                f7295c = a3;
                if (a3.length == 0) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "TelinkOtaService", "固件文件为空");
                    com.example.test.presenter.device.e eVar2 = f7299h;
                    if (eVar2 != null) {
                        eVar2.a(2);
                        return;
                    } else {
                        kotlin.jvm.internal.e.m("fileCallback");
                        throw null;
                    }
                }
                int length = a3.length;
                int i3 = f7297f;
                f7296d = length % i3 == 0 ? a3.length / i3 : (a3.length / i3) + 1;
                e = -1;
                f7298g = 0;
                f7293a = true;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "TelinkOtaService", "开始Telink OTA, 固件大小: " + f7295c.length + ", 总包数: " + f7296d);
                f7300i.postDelayed(f7301j, Const.L_GPS_REBOOT_INTERVAL);
                f7294b = TelinkOtaService$OtaPhase.SENDING_VERSION;
                e(new byte[]{0, -1});
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "TelinkOtaService", "固件文件不存在: ".concat(filePath));
            com.example.test.presenter.device.e eVar3 = f7299h;
            if (eVar3 != null) {
                eVar3.a(2);
            } else {
                kotlin.jvm.internal.e.m("fileCallback");
                throw null;
            }
        } catch (IOException e10) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "TelinkOtaService", "读取固件文件失败: " + e10.getMessage());
            com.example.test.presenter.device.e eVar4 = f7299h;
            if (eVar4 != null) {
                eVar4.a(2);
            } else {
                kotlin.jvm.internal.e.m("fileCallback");
                throw null;
            }
        }
    }

    public static void e(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder("TelinkOtaService writeCommand size=");
        sb2.append(bArr.length);
        sb2.append(" hex=");
        TelinkOtaService$writeCommand$1 telinkOtaService$writeCommand$1 = new oh.l() { // from class: com.example.blesdk.service.TelinkOtaService$writeCommand$1
            public final CharSequence invoke(byte b3) {
                return String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b3)}, 1));
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).byteValue());
            }
        };
        StringBuilder sb3 = new StringBuilder();
        sb3.append((CharSequence) "");
        int i3 = 0;
        for (byte b3 : bArr) {
            i3++;
            if (i3 > 1) {
                sb3.append((CharSequence) "");
            }
            if (telinkOtaService$writeCommand$1 != null) {
                sb3.append((CharSequence) telinkOtaService$writeCommand$1.invoke(Byte.valueOf(b3)));
            } else {
                sb3.append((CharSequence) String.valueOf((int) b3));
            }
        }
        sb3.append((CharSequence) "");
        String sb4 = sb3.toString();
        kotlin.jvm.internal.e.e(sb4, "joinTo(StringBuilder(), …ed, transform).toString()");
        sb2.append(sb4);
        Log.e("qob", sb2.toString());
        r5.b k10 = r5.b.k();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = k10.f18067q;
        if (bluetoothGattCharacteristic == null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "Telink OTA写入特征值为空");
            return;
        }
        bluetoothGattCharacteristic.setWriteType(1);
        k10.f18067q.setValue(bArr);
        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = k10.f18067q;
        BluetoothGatt bluetoothGatt = k10.f18059i;
        if (bluetoothGatt == null || bluetoothGattCharacteristic2 == null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "Telink写characteristic is null");
        } else if ((bluetoothGattCharacteristic2.getProperties() & 12) != 0) {
            bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic2);
        } else {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "Telink Writing characteristic 不支持写功能");
        }
    }
}
