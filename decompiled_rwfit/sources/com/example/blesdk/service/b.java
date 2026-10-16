package com.example.blesdk.service;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import okhttp3.internal.http2.Settings;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f7281a;

    /* renamed from: b, reason: collision with root package name */
    public static int f7282b;

    /* renamed from: c, reason: collision with root package name */
    public static int f7283c;

    /* renamed from: d, reason: collision with root package name */
    public static int f7284d;
    public static int e;

    /* renamed from: f, reason: collision with root package name */
    public static int f7285f;

    /* renamed from: g, reason: collision with root package name */
    public static int f7286g;

    /* renamed from: h, reason: collision with root package name */
    public static int f7287h;

    /* renamed from: i, reason: collision with root package name */
    public static int f7288i;

    /* renamed from: k, reason: collision with root package name */
    public static int f7290k;

    /* renamed from: m, reason: collision with root package name */
    public static com.example.test.presenter.device.e f7292m;

    /* renamed from: j, reason: collision with root package name */
    public static byte[] f7289j = new byte[0];

    /* renamed from: l, reason: collision with root package name */
    public static ArrayList f7291l = new ArrayList();

    public static void a(int i3) {
        StringBuilder q5 = android.support.v4.media.session.e.q(i3, "index: ", " max_object_size: ");
        q5.append(f7281a);
        System.out.println((Object) q5.toString());
        int i10 = f7281a;
        e(new byte[]{(byte) PXIOtaService$PXI_CMD_FW.CMD_FW_OBJECT_CREATE.getCode(), (byte) (i3 & 255), (byte) ((i3 >> 8) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 24) & 255), (byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 24) & 255)});
    }

    public static void b(byte[] receiveData) {
        kotlin.jvm.internal.e.f(receiveData, "receiveData");
        byte b3 = receiveData[0];
        if (b3 == PXIOtaService$PXI_CMD_FW.EVT_COMMAND_COMPLETE.getCode()) {
            byte b10 = receiveData[2];
            if (b10 == PXIOtaService$PXI_CMD_FW.CMD_FW_OTA_INIT_NEW.getCode()) {
                System.out.println((Object) l0.j(b10, "#OP code Error ==> "));
                System.out.println((Object) "run new ota flow");
                System.out.println((Object) "executer run new ota flow");
                d(kotlin.collections.g.d(5, 7, receiveData));
                d(kotlin.collections.g.d(7, 9, receiveData));
                byte[] d5 = kotlin.collections.g.d(9, 13, receiveData);
                f7281a = ((d5[3] << 24) & (-16777216)) | (d5[0] & 255) | ((d5[1] << 8) & 65280) | ((d5[2] << 16) & 16711680);
                f7282b = d(kotlin.collections.g.d(13, 15, receiveData));
                f7283c = 0;
                f7284d = d(kotlin.collections.g.d(15, 17, receiveData));
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "PXIOtaService", "initOTAparameter mtu_size [" + f7282b + "] max_object_size [" + f7281a + "] prn_threshold " + f7284d);
                e = 0;
                a(0);
                return;
            }
            return;
        }
        if (b3 == PXIOtaService$PXI_CMD_FW.CMD_FW_OBJECT_CREATE.getCode()) {
            System.out.println((Object) "#cmd fw object create 开始块文件");
            f7285f = 0;
            ArrayList c9 = c();
            f7291l = c9;
            f7290k = 0;
            e((byte[]) c9.get(0));
            return;
        }
        if (b3 != PXIOtaService$PXI_CMD_FW.CMD_FW_WRITE.getCode()) {
            if (b3 != PXIOtaService$PXI_CMD_FW.CMD_FW_UPGRADE.getCode()) {
                if (b3 == PXIOtaService$PXI_CMD_FW.CMD_FW_MCU_RESET.getCode()) {
                    System.out.println((Object) "#cmd CMD_FW_MCU_RESET");
                    return;
                } else {
                    if (b3 == PXIOtaService$PXI_CMD_FW.CMD_FW_EXECUTE.getCode()) {
                        System.out.println((Object) "#cmd fw execute");
                        return;
                    }
                    return;
                }
            }
            System.out.println((Object) "#cmd fw upgrade OTA结束");
            byte[] bArr = {(byte) PXIOtaService$PXI_CMD_FW.CMD_FW_MCU_RESET.getCode(), 0};
            System.out.println((Object) "FW Reset");
            e(bArr);
            com.example.test.presenter.device.e eVar = f7292m;
            if (eVar != null) {
                eVar.onFinish();
                return;
            } else {
                kotlin.jvm.internal.e.m("fileCallBack");
                throw null;
            }
        }
        if (d(kotlin.collections.g.d(1, 3, receiveData)) != f7283c) {
            com.example.test.presenter.device.e eVar2 = f7292m;
            if (eVar2 == null) {
                kotlin.jvm.internal.e.m("fileCallBack");
                throw null;
            }
            eVar2.a(13);
            System.out.println((Object) "CRC错误 CRC错误");
            return;
        }
        if (e >= f7288i) {
            System.out.println((Object) "升级文件传输完成");
            byte code = (byte) PXIOtaService$PXI_CMD_FW.CMD_FW_UPGRADE.getCode();
            int i3 = f7288i;
            int i10 = f7287h;
            e(new byte[]{code, (byte) (i3 & 255), (byte) ((i3 & 65280) >> 8), (byte) ((16711680 & i3) >> 16), (byte) ((i3 & 251658240) >> 24), (byte) (i10 & 255), (byte) ((65280 & i10) >>> 8)});
        } else if (f7285f >= f7281a) {
            System.out.println((Object) "4096块文件传输完成");
            a(e);
        } else {
            ArrayList c10 = c();
            f7291l = c10;
            f7290k = 0;
            e((byte[]) c10.get(0));
        }
        double d8 = (e * 1.0d) / f7288i;
        com.example.test.presenter.device.e eVar3 = f7292m;
        if (eVar3 != null) {
            eVar3.b((float) d8);
        } else {
            kotlin.jvm.internal.e.m("fileCallBack");
            throw null;
        }
    }

    public static ArrayList c() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < f7284d; i3++) {
            int i10 = f7282b;
            f7286g = i10;
            int i11 = f7288i;
            int i12 = e;
            int i13 = i11 - i12;
            if (i13 < i10) {
                f7286g = i13;
            } else {
                int i14 = f7281a - f7285f;
                if (i14 < i10) {
                    f7286g = i14;
                }
            }
            int i15 = f7286g;
            if (i15 > 0) {
                byte[] d5 = kotlin.collections.g.d(i12, i15 + i12, f7289j);
                int i16 = f7286g;
                for (int i17 = 0; i17 < i16; i17++) {
                    f7283c = (f7283c + (d5[i17] & 255)) & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
                }
                arrayList.add(d5);
                int i18 = e;
                int i19 = f7286g;
                e = i18 + i19;
                f7285f += i19;
            }
        }
        return arrayList;
    }

    public static int d(byte[] bArr) {
        return ((bArr[1] << 8) & 65280) | (bArr[0] & 255);
    }

    public static void e(byte[] bArr) {
        r5.b k10 = r5.b.k();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = k10.f18066p;
        if (bluetoothGattCharacteristic == null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "写入特征值为空");
            return;
        }
        bluetoothGattCharacteristic.setValue(bArr);
        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = k10.f18066p;
        BluetoothGatt bluetoothGatt = k10.f18059i;
        if (bluetoothGatt == null || bluetoothGattCharacteristic2 == null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "写characteristic is  null ", "");
        } else if ((bluetoothGattCharacteristic2.getProperties() & 12) != 0) {
            bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic2);
        } else {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ConnectBleService", "Writing characteristic 不支持写功能", "");
        }
    }
}
