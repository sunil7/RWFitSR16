package k6;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanSettings;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.appcompat.app.y;
import androidx.recyclerview.widget.n0;
import androidx.recyclerview.widget.x;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.XXApplication;
import com.example.test.presenter.device.y0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.ub;
import com.google.android.gms.internal.mlkit_vision_common.i0;
import com.jieli.jl_bt_ota.impl.RcspAuth;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import com.jieli.jl_bt_ota.tool.DataInfoCache;
import de.j;
import de.n;
import de.r;
import ef.i;
import i9.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import l6.l;
import n9.e;
import o6.m;
import o6.o;
import qd.g;
import qd.h;
import qd.k;
import rd.d;
import xd.q;

/* loaded from: classes.dex */
public final class b extends qd.a implements k {
    public final de.k A;
    public final RcspAuth B;
    public final r C;
    public ExecutorService D;
    public volatile boolean E;
    public volatile byte[] F;
    public volatile RandomAccessFile G;
    public final long H;
    public long I;
    public int J;
    public int K;
    public f L;
    public final Handler M;
    public final o N;
    public final i6.f O;
    public final a P;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f15512m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f15513n;

    /* renamed from: o, reason: collision with root package name */
    public y f15514o;

    /* renamed from: p, reason: collision with root package name */
    public final BluetoothLeScanner f15515p;

    /* renamed from: q, reason: collision with root package name */
    public volatile int f15516q;
    public volatile boolean r;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f15517s;

    /* renamed from: t, reason: collision with root package name */
    public final Handler f15518t;

    /* renamed from: u, reason: collision with root package name */
    public final l6.k f15519u;

    /* renamed from: v, reason: collision with root package name */
    public final l f15520v;

    /* renamed from: w, reason: collision with root package name */
    public BluetoothHeadset f15521w;

    /* renamed from: x, reason: collision with root package name */
    public BluetoothA2dp f15522x;

    /* renamed from: y, reason: collision with root package name */
    public y f15523y;

    /* renamed from: z, reason: collision with root package name */
    public final n f15524z;

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public b(XXApplication xXApplication) {
        super(xXApplication);
        int i3;
        XXApplication xXApplication2;
        this.f15512m = new ArrayList();
        this.f15513n = new ArrayList();
        this.r = false;
        this.f15517s = false;
        this.f15518t = new Handler(Looper.getMainLooper(), new m(this, 1));
        this.f15519u = new l6.k(this, 1);
        this.f15520v = new l(this, 1);
        BluetoothAdapter bluetoothAdapter = this.f17898b;
        if (bluetoothAdapter != null) {
            this.f15515p = bluetoothAdapter.getBluetoothLeScanner();
        }
        qd.b bVar = new qd.b(this);
        BluetoothAdapter bluetoothAdapter2 = this.f17898b;
        String str = this.f17897a;
        if (bluetoothAdapter2 == null) {
            ee.c.d(str, "init", "The device does not support Bluetooth function.");
        } else {
            if (this.f15522x == null) {
                try {
                    if (!bluetoothAdapter2.getProfileProxy(xXApplication, bVar, 2)) {
                        ee.c.d(str, "init", "Failed to obtain a2dp manager.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.f15521w == null) {
                try {
                    if (!bluetoothAdapter2.getProfileProxy(xXApplication, bVar, 1)) {
                        ee.c.d(str, "init", "Failed to obtain hfp manager.");
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
        if (this.f15523y == null && (xXApplication2 = this.f17901f) != null) {
            this.f15523y = new y(this, 5);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.device.action.UUID");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            xXApplication2.registerReceiver(this.f15523y, intentFilter);
        }
        this.E = false;
        this.H = 20000L;
        this.I = 0L;
        this.J = 0;
        this.K = 0;
        this.M = new Handler(Looper.getMainLooper(), new j(this, 4));
        o oVar = new o(this, 1);
        this.N = oVar;
        String str2 = this.f17897a;
        Locale locale = Locale.ENGLISH;
        ee.c.e(str2, "init", "Lib version name = 1.10.0(10932)");
        this.f15524z = new n(this, 0);
        this.A = new de.k(xXApplication, this);
        this.B = new RcspAuth(xXApplication, this, oVar);
        this.C = new r();
        e eVar = j6.a.f15325b;
        j6.a g10 = eVar.g();
        i6.f r = i6.f.f14366f.r();
        this.O = r;
        a aVar = new a(this);
        this.P = aVar;
        r.a(r5.b.k().f18057g);
        n0 n0Var = new n0(1);
        n0Var.f2676b = !g10.a() ? 1 : 0;
        SharedPreferences sharedPreferences = g10.f15327a;
        n0Var.f2677c = sharedPreferences.getBoolean("use_custom_reconnect_way", false) && sharedPreferences.getBoolean("is_hid_device", false);
        if (eVar.g().f15327a.getBoolean("function_upgrade", true)) {
            n0Var.f2678d = true;
        } else {
            n0Var.f2678d = false;
        }
        this.f17902g = n0Var;
        ee.c.c(this.f17897a, "configure", "" + n0Var);
        this.f17905j = null;
        RcspAuth.setAuthTimeout(5000L);
        i6.b bVar2 = r.f14371d;
        bVar2.getClass();
        ArrayList arrayList = bVar2.f14361a;
        if (!arrayList.contains(aVar)) {
            arrayList.add(aVar);
        }
        if (r.c() != null) {
            K(r.c(), 1);
            if (g10.a()) {
                BluetoothGatt d5 = r.d();
                if (r.f14368a.a()) {
                    n6.b d8 = r.f14369b.d(r.c());
                    if (d8 == null) {
                        i3 = 0;
                    } else {
                        int i10 = d8.f16384c;
                        if (i10 > 128) {
                            d8.f16384c = i10 - 6;
                        }
                        i3 = d8.f16384c;
                    }
                } else {
                    i3 = 20;
                }
                L(d5, i3 + 3, 0);
            }
        }
    }

    public static void q(b bVar) {
        ee.c.b(3, bVar.f17897a, "callbackStopOTA : ");
        bVar.N();
        bVar.C.d();
        bVar.M.postDelayed(new qd.c(bVar, 1), 100L);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void r(k6.b r16, android.bluetooth.BluetoothDevice r17, i9.f r18) {
        /*
            Method dump skipped, instructions count: 701
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.b.r(k6.b, android.bluetooth.BluetoothDevice, i9.f):void");
    }

    public final be.j A() {
        return this.f17899c.a(g());
    }

    public final void B() {
        Handler handler = this.M;
        handler.removeMessages(4662);
        handler.sendEmptyMessageDelayed(4662, 1000L);
    }

    public final void C(BluetoothDevice bluetoothDevice) {
        boolean j4 = this.A.j();
        ee.c.e(this.f17897a, "handleBrEdrDisconnect", r5.a.d("isWaitingForUpdate : ", j4));
        if (j4) {
            Handler handler = this.M;
            handler.removeMessages(4664);
            if (!ee.a.b(g(), bluetoothDevice)) {
                B();
                return;
            }
            handler.removeMessages(4674);
            handler.sendMessageDelayed(handler.obtainMessage(4674, bluetoothDevice), 6000L);
            this.O.b(bluetoothDevice);
        }
    }

    public final boolean D(BluetoothDevice bluetoothDevice) {
        return ee.a.b(g(), bluetoothDevice) && this.f17902g.f2676b == 0;
    }

    public final int E(BluetoothDevice bluetoothDevice) {
        if (y("isConnectedByA2dp", bluetoothDevice)) {
            return 0;
        }
        BluetoothA2dp bluetoothA2dp = this.f15522x;
        if (bluetoothA2dp == null) {
            ee.c.f(this.f17897a, "isConnectedByA2dp", "No a2dp manager.");
            return 0;
        }
        List<BluetoothDevice> connectedDevices = bluetoothA2dp.getConnectedDevices();
        String str = this.f17897a;
        if (connectedDevices != null) {
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (it.hasNext()) {
                if (it.next().getAddress().equals(bluetoothDevice.getAddress())) {
                    ee.c.c(str, "isConnectedByA2dp", " ----> Connected");
                    return 2;
                }
            }
        }
        int connectionState = this.f15522x.getConnectionState(bluetoothDevice);
        ee.c.c(str, "isConnectedByA2dp", "state : " + connectionState);
        return connectionState;
    }

    public final int F(BluetoothDevice bluetoothDevice) {
        if (y("isConnectedByHfp", bluetoothDevice)) {
            return 0;
        }
        BluetoothHeadset bluetoothHeadset = this.f15521w;
        if (bluetoothHeadset == null) {
            ee.c.f(this.f17897a, "isConnectedByHfp", "No hfp manager.");
            return 0;
        }
        List<BluetoothDevice> connectedDevices = bluetoothHeadset.getConnectedDevices();
        String str = this.f17897a;
        if (connectedDevices != null) {
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (it.hasNext()) {
                if (it.next().getAddress().equals(bluetoothDevice.getAddress())) {
                    ee.c.c(str, "isConnectedByHfp", "Hfp service is connected.");
                    return 2;
                }
            }
        }
        int connectionState = this.f15521w.getConnectionState(bluetoothDevice);
        ee.c.c(str, "isConnectedByHfp", "state : " + connectionState);
        return connectionState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
    
        if (r3.r >= 2) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(android.bluetooth.BluetoothDevice r9) {
        /*
            r8 = this;
            java.lang.String r0 = "readyToReconnectDevice"
            boolean r1 = r8.w(r0)
            if (r1 == 0) goto L9
            return
        L9:
            androidx.recyclerview.widget.n0 r1 = r8.f17902g
            int r1 = r1.f2676b
            fc.c r2 = r8.f17899c
            be.j r3 = r2.a(r9)
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L2b
            boolean r6 = r3.A
            if (r6 != 0) goto L2b
            int r6 = r3.C
            if (r6 != r5) goto L21
        L1f:
            r1 = r4
            goto L2b
        L21:
            r7 = 2
            if (r6 != r7) goto L26
            r1 = r5
            goto L2b
        L26:
            int r3 = r3.r
            if (r3 < r7) goto L2b
            goto L1f
        L2b:
            java.lang.String r3 = r9.getAddress()
            be.j r2 = r2.a(r9)
            if (r2 == 0) goto L4d
            boolean r6 = r2.A
            if (r6 != 0) goto L4d
            if (r1 != r5) goto L3e
            java.lang.String r2 = r2.f3238g
            goto L40
        L3e:
            java.lang.String r2 = r2.f3241j
        L40:
            boolean r6 = android.bluetooth.BluetoothAdapter.checkBluetoothAddress(r2)
            if (r6 == 0) goto L4d
            boolean r6 = r2.equals(r3)
            if (r6 != 0) goto L4d
            r3 = r2
        L4d:
            ud.d r2 = new ud.d
            r2.<init>(r3, r1, r4)
            de.k r4 = r8.A
            r4.k(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "flag = 1, "
            r4.<init>(r6)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r4 = r8.f17897a
            ee.c.c(r4, r0, r2)
            i9.f r0 = new i9.f
            java.lang.String r2 = r9.getAddress()
            r0.<init>(r2, r1, r3)
            r8.L = r0
            android.os.Handler r0 = r8.M
            r2 = 4665(0x1239, float:6.537E-42)
            r0.removeMessages(r2)
            r3 = 6000(0x1770, double:2.9644E-320)
            r0.sendEmptyMessageDelayed(r2, r3)
            qd.g r0 = new qd.g
            r2 = 3
            r0.<init>(r8, r9, r2)
            de.n r9 = r8.f15524z
            r9.getClass()
            xd.n r2 = new xd.n
            zd.f r3 = new zd.f
            r3.<init>(r1, r5)
            r2.<init>(r3)
            ef.i r1 = new ef.i
            com.google.android.gms.internal.mlkit_common.o r3 = new com.google.android.gms.internal.mlkit_common.o
            r4 = 10
            r3.<init>(r4)
            r4 = 16
            r1.<init>(r4, r0, r3)
            k6.b r9 = r9.f12375a
            r9.i(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.b.G(android.bluetooth.BluetoothDevice):void");
    }

    public final void H(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return;
        }
        boolean hasMessages = this.M.hasMessages(4661);
        String str = this.f17897a;
        if (hasMessages) {
            ee.c.f(str, "startChangeMtu", "Adjusting the MTU for BLE");
            return;
        }
        ee.c.c(str, "startChangeMtu", "requestBleMtu : false");
        v(bluetoothDevice, 0);
    }

    public final void I(BluetoothDevice bluetoothDevice) {
        if (w("upgradePrepare")) {
            return;
        }
        if (this.f17899c.a(bluetoothDevice) != null) {
            J(bluetoothDevice);
        } else {
            this.f15524z.b(new g(this, bluetoothDevice, 1));
        }
    }

    public final void J(BluetoothDevice bluetoothDevice) {
        if (w("upgradeStep01")) {
            return;
        }
        h hVar = new h(this, bluetoothDevice, 1);
        n nVar = this.f15524z;
        nVar.getClass();
        nVar.f12375a.i(new xd.l(), new i(16, hVar, new eb.e(10)));
    }

    public final void K(BluetoothDevice bluetoothDevice, int i3) {
        this.e.p(bluetoothDevice, i3);
        ee.c.e(this.f17897a, "onBtDeviceConnection", "device : " + ee.a.e(this.f17901f, bluetoothDevice) + ", " + com.google.android.gms.internal.mlkit_vision_common.n.a(i3));
        if (i3 != 3) {
            this.M.removeMessages(4673);
        }
        if (i3 != 1) {
            if (ee.a.b(bluetoothDevice, g())) {
                this.f17903h = null;
            }
            x(bluetoothDevice, i3);
            return;
        }
        if (this.f17904i == null) {
            this.f17904i = new de.i(this);
        }
        if (d(bluetoothDevice)) {
            if (D(bluetoothDevice)) {
                H(bluetoothDevice);
                return;
            } else {
                v(bluetoothDevice, 1);
                return;
            }
        }
        this.B.stopAuth(bluetoothDevice, false);
        if (this.B.startAuth(bluetoothDevice)) {
            return;
        }
        x a3 = i0.a(20481);
        x(bluetoothDevice, 2);
        p("callbackConnectFailed", a3);
    }

    public final void L(BluetoothGatt bluetoothGatt, int i3, int i10) {
        if (bluetoothGatt == null) {
            return;
        }
        int i11 = i10 == 0 ? i3 - 3 : 20;
        ee.c.d(this.f17897a, "onMtuChanged", l0.j(i11, "bleMtu : "));
        BluetoothDevice device = bluetoothGatt.getDevice();
        this.e.j(device, i11, i10);
        String e = ee.a.e(this.f17901f, device);
        Locale locale = Locale.ENGLISH;
        String str = "device : " + e + ", block : " + i11 + ", status : " + i10;
        String str2 = this.f17897a;
        ee.c.e(str2, "onBleDataBlockChanged", str);
        Handler handler = this.M;
        if (handler.hasMessages(4661)) {
            handler.removeMessages(4661);
            ee.c.e(str2, "onBleDataBlockChanged", "handleConnectedEvent >>>");
            v(device, 0);
        }
    }

    public final void M(rd.b bVar) {
        BluetoothDevice g10 = g();
        String str = this.f17897a;
        if (g10 == null) {
            ee.c.f(str, "queryMandatoryUpdate", "Bluetooth device is disconnected.");
            bVar.a(i0.a(4114));
            return;
        }
        be.j a3 = this.f17899c.a(g10);
        ee.c.e(str, "queryMandatoryUpdate", "cache deviceInfo : " + a3);
        if (a3 == null) {
            this.f15524z.b(new n.l(this, 4, g10, bVar));
        } else if (a3.f3253w != 1 && a3.f3254x != 1) {
            bVar.a(i0.c(0, "Device is connected."));
        } else {
            bVar.onSuccess(a3);
            this.e.r(g10);
        }
    }

    public final void N() {
        this.E = false;
        this.M.removeMessages(4660);
        this.K = 0;
        this.J = 0;
        if (this.I > 0) {
            Calendar.getInstance().getTimeInMillis();
            this.I = 0L;
        }
        this.L = null;
        if (this.F != null) {
            this.F = null;
            System.gc();
        }
        if (this.G != null) {
            try {
                this.G.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                this.G = null;
            }
        }
    }

    public final void O(BluetoothDevice bluetoothDevice, byte[] bArr) {
        int i3;
        ArrayList arrayList;
        be.j a3;
        byte[] bArr2;
        int i10;
        int i11;
        int i12;
        vd.a aVar;
        int i13;
        int i14 = 2;
        int i15 = 4;
        be.j a10 = this.f17899c.a(bluetoothDevice);
        if (a10 == null || (i3 = a10.L) <= 0) {
            i3 = 530;
        }
        byte[] bArr3 = de.m.f12371a;
        int i16 = 0;
        if (i3 == 0 || bArr == null || bArr.length == 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            int length = bArr.length;
            int i17 = de.m.f12373c;
            if (i17 > 0) {
                bArr2 = new byte[i17 + length];
                System.arraycopy(de.m.f12372b, 0, bArr2, 0, i17);
                System.arraycopy(bArr, 0, bArr2, de.m.f12373c, length);
                de.m.f12373c = 0;
            } else {
                bArr2 = (byte[]) bArr.clone();
            }
            int length2 = bArr2.length;
            ee.c.c("ParseHelper", "findPacketData", "data : " + ee.b.c(bArr2));
            int i18 = 0;
            while (true) {
                if (i18 >= length2) {
                    break;
                }
                int a11 = de.m.a(i18, i3, bArr2);
                if (a11 < 3) {
                    ee.c.f("ParseHelper", "findPacketData", "not find head data : ");
                    break;
                }
                ee.c.e("ParseHelper", "findPacketData", "prefixIndex = " + a11);
                int e = ee.b.e(a11 + 2, bArr2);
                int i19 = e + 4;
                byte[] bArr4 = new byte[i19];
                System.arraycopy(bArr2, a11, bArr4, i16, i19);
                if (i19 >= i15) {
                    byte b3 = bArr4[i16];
                    i12 = i15;
                    byte[] bArr5 = new byte[8];
                    int i20 = 0;
                    for (int i21 = 8; i20 < i21; i21 = 8) {
                        bArr5[i20] = (byte) (b3 & 1);
                        b3 = (byte) (b3 >> 1);
                        i20++;
                    }
                    int i22 = bArr4[1] & 255;
                    int e10 = ee.b.e(i14, bArr4);
                    aVar = new vd.a();
                    i11 = i14;
                    int i23 = bArr5[7] & 255;
                    int i24 = bArr5[6] & 255;
                    aVar.f19218a = i23;
                    aVar.f19219b = i24;
                    aVar.f19220c = i22;
                    aVar.f19221d = e10;
                    if (e10 > 0) {
                        if (i23 == 0) {
                            aVar.e = bArr4[i12] & 255;
                            i13 = 5;
                        } else {
                            i13 = i12;
                        }
                        aVar.f19222f = bArr4[i13] & 255;
                        int i25 = i13 + 1;
                        i10 = length2;
                        if (i22 == 1) {
                            aVar.f19223g = bArr4[i25] & 255;
                            i25 = i13 + 2;
                        }
                        int i26 = e10 - (i25 - 4);
                        byte[] bArr6 = new byte[i26];
                        System.arraycopy(bArr4, i25, bArr6, 0, i26);
                        aVar.f19224h = bArr6;
                        int i27 = aVar.f19218a;
                        int i28 = aVar.f19220c;
                        int i29 = aVar.f19222f;
                        Locale locale = Locale.ENGLISH;
                        StringBuilder s7 = l0.s(i27, "packet type : ", i28, ", opCode : ", ", sn :");
                        s7.append(i29);
                        ee.c.c("ParseHelper", "parsePacketData", s7.toString());
                    } else {
                        i10 = length2;
                    }
                } else {
                    i10 = length2;
                    i11 = i14;
                    i12 = i15;
                    aVar = null;
                }
                if (aVar != null) {
                    arrayList.add(aVar);
                }
                i18 = a11 + 4 + e + 1;
                i15 = i12;
                length2 = i10;
                i14 = i11;
                i16 = 0;
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            ee.c.f(this.f17897a, "receiveDataFromDevice", "No ota command found.");
            return;
        }
        int size = arrayList.size();
        int i30 = 0;
        while (i30 < size) {
            Object obj = arrayList.get(i30);
            i30++;
            vd.a aVar2 = (vd.a) obj;
            vd.b d5 = de.m.d(aVar2, f(bluetoothDevice, aVar2));
            if (d5 == null) {
                ee.c.f(this.f17897a, "receiveDataFromDevice", "Failed to parse command");
            } else {
                ee.c.c(this.f17897a, "receiveDataFromDevice", "" + d5);
                if (aVar2.f19218a == 1) {
                    this.e.m(bluetoothDevice, d5);
                    boolean z5 = aVar2.f19219b == 1;
                    int i31 = d5.f19226b;
                    if (i31 == 194) {
                        boolean z6 = this.E;
                        boolean hasMessages = this.M.hasMessages(4663);
                        ee.c.c(this.f17897a, "Receive Command", "0xC2 : isOTA = " + z6 + ", hasStopAdvNotify = " + hasMessages);
                        if (z6 && !hasMessages) {
                            this.M.sendEmptyMessageDelayed(4663, Const.L_MAX_WAIT_WIFI);
                            n nVar = this.f15524z;
                            nVar.getClass();
                            nVar.f12375a.i(new yd.c(new ae.b(0, 1)), new de.f(null));
                        }
                    } else if (i31 != 209) {
                        float f2 = 0.0f;
                        if (i31 == 232) {
                            vd.b bVar = (xd.o) d5;
                            if (w("Receive E8 command ")) {
                                bVar.f19229f = null;
                                bVar.e = 1;
                                j(bVar);
                            } else {
                                ee.c.f(this.f17897a, "Receive Command", "0xE8 : " + bVar);
                                zd.g gVar = (zd.g) bVar.f19229f;
                                if (gVar == null) {
                                    ee.c.c(this.f17897a, "Receive Command", "0xE8 : command is error.");
                                    bVar.e = 1;
                                    j(bVar);
                                    p("Receive E8 command", i0.c(12293, "E8 command"));
                                } else {
                                    int i32 = gVar.f20399d;
                                    if (i32 >= 0) {
                                        this.I = Calendar.getInstance().getTimeInMillis();
                                        int i33 = gVar.e;
                                        this.K = i33;
                                        this.J = i32;
                                        if (i32 > 0) {
                                            f2 = (i33 * 100.0f) / i32;
                                            if (f2 >= 100.0f) {
                                                f2 = 99.9f;
                                            }
                                        }
                                        l(bluetoothDevice, f2);
                                        bVar.e = 0;
                                        bVar.f19229f = null;
                                        j(bVar);
                                    } else {
                                        ee.c.f(this.f17897a, "Receive Command", "0xE8 : length = " + i32);
                                        p("Receive E8 command", i0.c(4097, "Update content size is error. " + i32));
                                    }
                                }
                            }
                        } else if (i31 == 228) {
                            vd.b bVar2 = (xd.f) d5;
                            boolean z8 = this.E;
                            if (z8) {
                                z();
                            }
                            bVar2.f19230g = new be.c(!z8 ? 1 : 0);
                            bVar2.e = 0;
                            j(bVar2);
                        } else if (i31 == 229) {
                            this.M.removeMessages(4660);
                            xd.g gVar2 = (xd.g) d5;
                            if (w("Receive E5 command")) {
                                gVar2.f19229f = null;
                                gVar2.e = 1;
                                j(gVar2);
                            } else {
                                zd.c cVar = (zd.c) gVar2.f19229f;
                                if (cVar == null) {
                                    ee.c.c(this.f17897a, "Receive Command", "0xE5 : command is error.");
                                    gVar2.e = 1;
                                    j(gVar2);
                                    p("Receive E5 command", i0.c(12293, "E5 command"));
                                } else {
                                    int i34 = cVar.f20395d;
                                    int i35 = cVar.e;
                                    int i36 = this.J;
                                    if (i36 > 0) {
                                        int i37 = this.K + i35;
                                        this.K = i37;
                                        if (i36 > 0) {
                                            f2 = (i37 * 100.0f) / i36;
                                            if (f2 >= 100.0f) {
                                                f2 = 99.9f;
                                            }
                                        }
                                        l(bluetoothDevice, f2);
                                    }
                                    if (!w("upgradeStep04")) {
                                        this.M.removeMessages(4660);
                                        if (i34 == 0 && i35 == 0) {
                                            ee.c.e(this.f17897a, "upgradeStep04", "read data over.");
                                            gVar2.f19229f = null;
                                            gVar2.e = 0;
                                            j(gVar2);
                                            if (!w("upgradeStep05")) {
                                                n nVar2 = new n(this, 1);
                                                n nVar3 = this.f15524z;
                                                nVar3.getClass();
                                                nVar3.f12375a.i(new xd.h(), new i(16, nVar2, new e(10)));
                                            }
                                        } else {
                                            u(i34, i35, new f(this, i34, i35, gVar2));
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        vd.b bVar3 = (q) d5;
                        zd.h hVar = (zd.h) bVar3.f19229f;
                        if (hVar == null) {
                            ee.c.c(this.f17897a, "Receive Command", "0xD1 : command is error.");
                            if (z5) {
                                bVar3.e = 1;
                                j(bVar3);
                            }
                        } else {
                            int i38 = hVar.f20400d;
                            int c9 = this.f17899c.c(bluetoothDevice);
                            if (i38 >= 530) {
                                fc.c cVar2 = this.f17899c;
                                if (i38 <= 0) {
                                    cVar2.getClass();
                                } else {
                                    be.j a12 = cVar2.a(bluetoothDevice);
                                    if (a12 != null) {
                                        a12.K = i38;
                                        cVar2.f(bluetoothDevice, a12);
                                    }
                                }
                            } else {
                                i38 = c9;
                            }
                            if (z5) {
                                hVar.f20400d = i38;
                                bVar3.e = 0;
                                j(bVar3);
                            }
                        }
                    }
                } else if (d5.e == 0) {
                    int i39 = d5.f19226b;
                    if (i39 == 209) {
                        be.i iVar = (be.i) ((q) d5).f19230g;
                        if (iVar != null) {
                            int i40 = iVar.f3235d;
                            fc.c cVar3 = this.f17899c;
                            if (i40 <= 0) {
                                cVar3.getClass();
                            } else {
                                be.j a13 = cVar3.a(bluetoothDevice);
                                if (a13 != null) {
                                    a13.K = i40;
                                    cVar3.f(bluetoothDevice, a13);
                                }
                            }
                        }
                    } else if (i39 == 227) {
                        be.b bVar4 = (be.b) ((xd.e) d5).f19230g;
                        if (bVar4 != null && bVar4.f3228d == 0) {
                            fc.c cVar4 = this.f17899c;
                            if (cVar4.c(bluetoothDevice) < 530 && (a3 = cVar4.a(bluetoothDevice)) != null) {
                                a3.K = 530;
                                cVar4.f(bluetoothDevice, a3);
                            }
                        }
                    } else if (i39 == 231) {
                        ee.c.d(this.f17897a, "handleResponseCommand", "reboot >>> ");
                        this.O.b(bluetoothDevice);
                    }
                }
            }
        }
    }

    public final void P() {
        BluetoothAdapter bluetoothAdapter;
        BluetoothAdapter bluetoothAdapter2;
        XXApplication xXApplication;
        XXApplication xXApplication2;
        XXApplication xXApplication3;
        ee.c.e(this.f17897a, "release", ">>>>>>");
        y yVar = this.f17906k;
        if (yVar != null && (xXApplication3 = this.f17901f) != null) {
            xXApplication3.unregisterReceiver(yVar);
            this.f17906k = null;
        }
        this.f17899c.f13558a.clear();
        this.f17900d.f12284a.clear();
        de.e eVar = this.e;
        ((ArrayList) eVar.f36a).clear();
        ((Handler) eVar.f37b).removeCallbacksAndMessages(null);
        d6.a aVar = this.f17905j;
        if (aVar != null) {
            ((HashMap) aVar.f12306b).clear();
            this.f17905j = null;
        }
        y yVar2 = this.f15514o;
        if (yVar2 != null && (xXApplication2 = this.f17901f) != null) {
            xXApplication2.unregisterReceiver(yVar2);
            this.f15514o = null;
        }
        U();
        T();
        this.f15516q = 0;
        this.r = false;
        this.f15517s = false;
        this.f15512m.clear();
        this.f15513n.clear();
        this.f15518t.removeCallbacksAndMessages(null);
        y yVar3 = this.f15523y;
        if (yVar3 != null && (xXApplication = this.f17901f) != null) {
            xXApplication.unregisterReceiver(yVar3);
            this.f15523y = null;
        }
        BluetoothA2dp bluetoothA2dp = this.f15522x;
        if (bluetoothA2dp != null && (bluetoothAdapter2 = this.f17898b) != null) {
            bluetoothAdapter2.closeProfileProxy(2, bluetoothA2dp);
            this.f15522x = null;
        }
        BluetoothHeadset bluetoothHeadset = this.f15521w;
        if (bluetoothHeadset != null && (bluetoothAdapter = this.f17898b) != null) {
            bluetoothAdapter.closeProfileProxy(1, bluetoothHeadset);
            this.f15521w = null;
        }
        if (!w("exitUpdateMode")) {
            be.j A = A();
            if (A == null || !A.A) {
                String str = this.f17897a;
                BluetoothDevice g10 = g();
                Locale locale = Locale.ENGLISH;
                ee.c.e(str, "exitUpdateMode", "device[" + g10 + "] is single flash ota, so ota progress cannot be interrupted.");
            } else {
                this.E = false;
                n nVar = this.f15524z;
                qd.f fVar = new qd.f(this, 1);
                nVar.getClass();
                nVar.f12375a.i(new xd.f(), new i(16, fVar, new hc.a(10)));
            }
        }
        N();
        de.k kVar = this.A;
        kVar.k(null);
        kVar.n();
        y0 y0Var = (y0) kVar.f12369f;
        de.e eVar2 = ((b) kVar.f12368d).e;
        if (y0Var != null) {
            ArrayList arrayList = (ArrayList) eVar2.f36a;
            if (!arrayList.isEmpty()) {
                arrayList.remove(y0Var);
            }
        } else {
            eVar2.getClass();
        }
        kVar.f12365a.removeCallbacksAndMessages(null);
        ExecutorService executorService = this.D;
        if (executorService != null && !executorService.isShutdown()) {
            this.D.shutdownNow();
            this.D = null;
        }
        this.B.removeListener(this.N);
        this.B.destroy();
        r rVar = this.C;
        ((ArrayList) rVar.f36a).clear();
        ((Handler) rVar.f37b).removeCallbacksAndMessages(null);
        this.M.removeCallbacksAndMessages(null);
        ee.c.f(this.f17897a, "releaseDataHandler", "---->");
        if (this.f17904i != null) {
            de.i iVar = this.f17904i;
            ((Handler) iVar.f12361g).removeCallbacksAndMessages(null);
            ((ByteArrayOutputStream) ((de.o) iVar.f12359d).f12378c).reset();
            ((DataInfoCache) iVar.e).clear();
            HandlerThread handlerThread = (HandlerThread) iVar.f12360f;
            if (!handlerThread.isInterrupted()) {
                handlerThread.quitSafely();
            }
            this.f17904i = null;
        }
        i6.f fVar2 = this.O;
        a callback = this.P;
        fVar2.getClass();
        kotlin.jvm.internal.e.f(callback, "callback");
        i6.b bVar = fVar2.f14371d;
        bVar.getClass();
        ArrayList arrayList2 = bVar.f14361a;
        if (!arrayList2.isEmpty()) {
            arrayList2.remove(callback);
        }
        i6.f fVar3 = this.O;
        fVar3.b(fVar3.c());
    }

    public final int Q(long j4) {
        if (t("startBLEScan", false)) {
            return 4113;
        }
        if (this.f15517s) {
            ee.c.c(this.f17897a, "startBLEScan", "stopDeviceScan");
            if (U() == 0) {
                int i3 = 0;
                do {
                    SystemClock.sleep(30L);
                    i3 += 30;
                    if (i3 > 300) {
                        break;
                    }
                } while (this.f17898b.isDiscovering());
            }
        }
        this.f15516q = 0;
        if (j4 <= 0) {
            j4 = Const.L_MIN_GET_REQ;
        }
        if (this.r) {
            ee.c.e(this.f17897a, "startBLEScan", "scanning ble ..... timeout = " + j4);
            BluetoothLeScanner bluetoothLeScanner = this.f15515p;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.flushPendingScanResults(this.f15520v);
            }
            this.f15518t.removeMessages(4661);
            this.f15518t.sendEmptyMessageDelayed(4661, j4);
            s(true);
            return 0;
        }
        if (this.f15515p != null) {
            this.f15515p.startScan(new ArrayList(), new ScanSettings.Builder().setScanMode(0).setMatchMode(1).build(), this.f15520v);
            ee.c.c(this.f17897a, "startBLEScan", "startScan : true");
        } else {
            boolean startLeScan = this.f17898b.startLeScan(this.f15519u);
            ee.c.c(this.f17897a, "startBLEScan", "startLeScan : " + startLeScan);
            if (!startLeScan) {
                return 8194;
            }
        }
        ee.c.e(this.f17897a, "startBLEScan", "Ready to scan, timeout : " + j4);
        this.f15518t.removeMessages(4661);
        this.f15518t.sendEmptyMessageDelayed(4661, j4);
        s(true);
        return 0;
    }

    public final int R(int i3, long j4) {
        XXApplication xXApplication;
        XXApplication xXApplication2;
        if (i3 == 0) {
            return Q(j4);
        }
        if (t("startDeviceScan", false)) {
            return 4113;
        }
        if (this.r) {
            T();
            ee.c.e(this.f17897a, "startDeviceScan", "stopBLEScan.");
            SystemClock.sleep(100L);
        }
        this.f15516q = i3;
        long j10 = j4 <= 0 ? Const.L_MIN_GET_REQ : j4;
        if (this.f15517s) {
            ee.c.c(this.f17897a, "startDeviceScan", "scanning br/edr ..... timeout = " + j4);
            this.f15518t.removeMessages(4660);
            this.f15518t.sendEmptyMessageDelayed(4660, j10);
            s(true);
            return 0;
        }
        if (this.f15514o == null && (xXApplication2 = this.f17901f) != null) {
            this.f15514o = new y(this, 6);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            xXApplication2.registerReceiver(this.f15514o, intentFilter);
        }
        boolean startDiscovery = this.f17898b.startDiscovery();
        ee.c.c(this.f17897a, "startDeviceScan", "startDiscovery : " + startDiscovery);
        if (startDiscovery) {
            this.f15518t.removeMessages(4660);
            this.f15518t.sendEmptyMessageDelayed(4660, j10);
            s(true);
            return 0;
        }
        y yVar = this.f15514o;
        if (yVar == null || (xXApplication = this.f17901f) == null) {
            return 8194;
        }
        xXApplication.unregisterReceiver(yVar);
        this.f15514o = null;
        return 8194;
    }

    public final void S(d dVar) {
        BluetoothDevice g10 = g();
        if (g10 == null) {
            ee.c.f(this.f17897a, "startOTA", "Bluetooth device is disconnected.");
            dVar.a(i0.a(4114));
            return;
        }
        if (this.E) {
            ee.c.f(this.f17897a, "startOTA", "OTA in progress.");
            dVar.a(i0.a(16392));
            return;
        }
        if (!this.f17902g.f2678d) {
            this.f17899c.d(g10, true);
        }
        this.E = true;
        ArrayList arrayList = (ArrayList) this.C.f36a;
        arrayList.clear();
        if (!arrayList.contains(dVar)) {
            arrayList.add(dVar);
        }
        String str = (String) this.f17902g.f2679f;
        if (!(!TextUtils.isEmpty(str) ? new File(str).exists() : false)) {
            p("startOTA", i0.a(20485));
            return;
        }
        String str2 = (String) this.f17902g.f2679f;
        if (g() == null) {
            p("startReadFileThread", i0.a(4114));
            return;
        }
        ee.c.b(3, this.f17897a, "callbackStartOTA : ");
        this.C.s();
        File file = new File(str2);
        if (!file.exists() || !file.isFile()) {
            p("startReadFileThread", i0.a(20484));
            return;
        }
        ExecutorService executorService = this.D;
        if (executorService == null || executorService.isShutdown()) {
            this.D = Executors.newSingleThreadExecutor();
        }
        if (file.length() <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
            this.D.execute(new c5.a(str2, new g(this, g10, 0)));
        } else {
            this.D.execute(new androidx.camera.camera2.internal.compat.h(this, 15, file, g10));
        }
    }

    public final void T() {
        if (t("stopBLEScan", true)) {
            return;
        }
        if (!this.r) {
            this.e.o(true, false);
            return;
        }
        try {
            BluetoothLeScanner bluetoothLeScanner = this.f15515p;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.stopScan(this.f15520v);
                ee.c.c(this.f17897a, "stopBLEScan", "stopScan");
            } else {
                this.f17898b.stopLeScan(this.f15519u);
                ee.c.c(this.f17897a, "stopBLEScan", "stopLeScan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f15518t.removeMessages(4661);
        s(false);
    }

    public final int U() {
        if (t("stopDeviceScan", true)) {
            return 4113;
        }
        if (!this.f15517s) {
            this.e.o(false, false);
            return 0;
        }
        boolean cancelDiscovery = this.f17898b.cancelDiscovery();
        ee.c.f(this.f17897a, "stopDeviceScan", "cancelDiscovery = " + cancelDiscovery);
        if (!cancelDiscovery) {
            return 8194;
        }
        this.f15518t.removeMessages(4660);
        return 0;
    }

    public final void V() {
        if (w("startReceiveCmdTimeout")) {
            return;
        }
        long j4 = this.H;
        if (j4 > 0) {
            Handler handler = this.M;
            handler.removeMessages(4660);
            handler.sendEmptyMessageDelayed(4660, j4);
        }
    }

    public final void W() {
        if (w("upgradeStep03")) {
            return;
        }
        qd.f fVar = new qd.f(this, 0);
        n nVar = this.f15524z;
        nVar.getClass();
        nVar.f12375a.i(new xd.e(), new i(16, fVar, new gc.b(10)));
    }

    @Override // qd.a
    public final void e(x xVar) {
        this.e.a(xVar);
        p("errorEventCallback", xVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // qd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(android.bluetooth.BluetoothDevice r13, byte[] r14) {
        /*
            r12 = this;
            i6.f r0 = r12.O
            r0.getClass()
            r1 = 0
            if (r13 == 0) goto L9f
            int r2 = r14.length
            if (r2 != 0) goto Ld
            goto L9f
        Ld:
            l6.o r2 = r0.f14369b
            android.bluetooth.BluetoothDevice r2 = r2.f15812f
            if (r2 == 0) goto L8b
            l6.o r2 = r0.f14369b
            java.util.UUID r5 = l6.o.f15805p
            java.util.UUID r6 = l6.o.f15806q
            i6.c r8 = new i6.c
            r8.<init>(r0)
            n6.b r0 = r2.d(r13)
            if (r0 == 0) goto L84
            l6.q r2 = r0.e
            if (r2 == 0) goto L84
            boolean r2 = r2.f15827b
            if (r2 == 0) goto L84
            l6.q r3 = r0.e
            android.bluetooth.BluetoothGatt r4 = r0.f16383b
            mc.g r0 = r3.f15830f
            if (r0 == 0) goto L84
            if (r5 == 0) goto L84
            if (r6 == 0) goto L84
            int r2 = r14.length
            if (r2 != 0) goto L3c
            goto L84
        L3c:
            java.lang.Object r0 = r0.f16022b
            n6.b r0 = (n6.b) r0
            int r2 = r0.f16384c
            r7 = 128(0x80, float:1.8E-43)
            if (r2 <= r7) goto L4a
            int r2 = r2 + (-6)
            r0.f16384c = r2
        L4a:
            int r0 = r0.f16384c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r7 = "addSendTask : "
            r2.<init>(r7)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            r7 = 2
            java.lang.String r9 = "SendBleDataThread"
            ee.c.b(r7, r9, r2)
            int r2 = r14.length
            int r9 = r2 / r0
            r7 = r1
            r10 = r7
        L65:
            if (r10 >= r9) goto L75
            byte[] r7 = new byte[r0]
            int r11 = r10 * r0
            java.lang.System.arraycopy(r14, r11, r7, r1, r0)
            boolean r7 = r3.a(r4, r5, r6, r7, r8)
            int r10 = r10 + 1
            goto L65
        L75:
            int r0 = r2 % r0
            if (r0 == 0) goto L85
            byte[] r7 = new byte[r0]
            int r2 = r2 - r0
            java.lang.System.arraycopy(r14, r2, r7, r1, r0)
            boolean r7 = r3.a(r4, r5, r6, r7, r8)
            goto L85
        L84:
            r7 = r1
        L85:
            if (r7 != 0) goto L9d
            r8.a(r13, r1)
            goto L9d
        L8b:
            o6.p r1 = r0.f14370c
            android.bluetooth.BluetoothDevice r1 = r1.f16791g
            if (r1 == 0) goto L9d
            o6.p r1 = r0.f14370c
            java.util.UUID r2 = o6.p.r
            i6.c r3 = new i6.c
            r3.<init>(r0)
            r1.i(r13, r2, r14, r3)
        L9d:
            r13 = 1
            return r13
        L9f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.b.k(android.bluetooth.BluetoothDevice, byte[]):boolean");
    }

    public final void l(BluetoothDevice bluetoothDevice, float f2) {
        if (w("callbackProgress")) {
            return;
        }
        be.j a3 = this.f17899c.a(bluetoothDevice);
        int i3 = (a3 == null || a3.B) ? 0 : 1;
        if (w("callbackProgress")) {
            return;
        }
        ee.c.b(2, this.f17897a, "callbackProgress : type = " + i3 + ", progress = " + f2);
        if (this.I > 0) {
            Calendar.getInstance().getTimeInMillis();
        }
        this.C.f(f2, i3);
    }

    public final void m(BluetoothDevice bluetoothDevice, int i3, int i10) {
        if (i10 != 0) {
            return;
        }
        boolean z5 = true;
        if (i3 != 1 ? !(i3 != 2 || F(bluetoothDevice) == 0) : E(bluetoothDevice) != 0) {
            z5 = false;
        }
        boolean hasMessages = this.M.hasMessages(4664);
        ee.c.c(this.f17897a, "handleBrEdrProfileStatus", "isBrEdrDisconnect : " + z5 + ", isWaitingEdrDisconnectTask : " + hasMessages);
        if (z5 && hasMessages) {
            C(bluetoothDevice);
        }
    }

    public final void n(BluetoothDevice bluetoothDevice, int i3, byte[] bArr, boolean z5) {
        if (bluetoothDevice == null || t("filterDevice", true)) {
            return;
        }
        ArrayList arrayList = this.f15512m;
        if (arrayList.contains(bluetoothDevice)) {
            return;
        }
        arrayList.add(bluetoothDevice);
        this.e.g(bluetoothDevice, new BleScanMessage().setRawData(bArr).setRssi(i3).setEnableConnect(z5));
    }

    public final void o(BluetoothDevice bluetoothDevice, byte[] bArr) {
        h hVar = new h(this, bluetoothDevice, 2);
        n nVar = this.f15524z;
        nVar.getClass();
        nVar.f12375a.i(new xd.m(new zd.b(bArr, 1)), new i(16, hVar, new ec.a(10)));
    }

    public final void p(String str, x xVar) {
        if (w("callbackError") || xVar == null) {
            return;
        }
        Locale locale = Locale.ENGLISH;
        ee.c.d(this.f17897a, "callbackError", str + " ----> " + xVar);
        N();
        this.C.a(xVar);
        this.M.postDelayed(new qd.c(this, 2), 100L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b3, code lost:
    
        if (r3 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bb, code lost:
    
        if (com.google.android.gms.internal.mlkit_vision_barcode.ub.a(r8.f17901f) != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c2, code lost:
    
        if (r3.getType() == 2) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c8, code lost:
    
        if (r3.getType() != 3) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cb, code lost:
    
        r5 = r8.f15513n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d1, code lost:
    
        if (r5.contains(r3) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d3, code lost:
    
        r5.add(r3);
        r4.g(r3, new com.jieli.jl_bt_ota.model.BleScanMessage());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(boolean r9) {
        /*
            r8 = this;
            int r0 = r8.f15516q
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L8
            r0 = r1
            goto L9
        L8:
            r0 = r2
        L9:
            java.lang.String r3 = r8.f17897a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "scanType : "
            r4.<init>(r5)
            int r5 = r8.f15516q
            r4.append(r5)
            java.lang.String r5 = ", bStart : "
            r4.append(r5)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "notifyDiscoveryStatus"
            ee.c.e(r3, r5, r4)
            if (r9 == 0) goto L3c
            if (r0 == 0) goto L34
            r8.r = r1
            java.util.ArrayList r1 = r8.f15512m
            r1.clear()
            goto L58
        L34:
            r8.f15517s = r1
            java.util.ArrayList r1 = r8.f15513n
            r1.clear()
            goto L58
        L3c:
            if (r0 == 0) goto L41
            r8.r = r2
            goto L58
        L41:
            r8.f15517s = r2
            android.os.Handler r1 = r8.f15518t
            r3 = 4660(0x1234, float:6.53E-42)
            r1.removeMessages(r3)
            androidx.appcompat.app.y r1 = r8.f15514o
            if (r1 == 0) goto L58
            com.example.test.XXApplication r3 = r8.f17901f
            if (r3 == 0) goto L58
            r3.unregisterReceiver(r1)
            r1 = 0
            r8.f15514o = r1
        L58:
            de.e r1 = r8.e
            r1.o(r0, r9)
            if (r9 != 0) goto L62
            r8.f15516q = r2
            return
        L62:
            com.example.test.XXApplication r9 = r8.f17901f
            java.util.ArrayList r9 = ee.a.c(r9)
            if (r9 == 0) goto Ldf
            boolean r1 = r9.isEmpty()
            if (r1 == 0) goto L72
            goto Ldf
        L72:
            int r1 = r9.size()
        L76:
            if (r2 >= r1) goto Ldf
            java.lang.Object r3 = r9.get(r2)
            int r2 = r2 + 1
            android.bluetooth.BluetoothDevice r3 = (android.bluetooth.BluetoothDevice) r3
            de.e r4 = r8.e
            r5 = 3
            r6 = 2
            if (r0 == 0) goto Lb1
            if (r3 == 0) goto Lb1
            com.example.test.XXApplication r7 = r8.f17901f
            boolean r7 = com.google.android.gms.internal.mlkit_vision_barcode.ub.a(r7)
            if (r7 != 0) goto L91
            goto Lb1
        L91:
            int r7 = r3.getType()
            if (r7 == r6) goto L9d
            int r7 = r3.getType()
            if (r7 != r5) goto Lb1
        L9d:
            java.util.ArrayList r5 = r8.f15512m
            boolean r6 = r5.contains(r3)
            if (r6 != 0) goto L76
            r5.add(r3)
            com.jieli.jl_bt_ota.model.BleScanMessage r5 = new com.jieli.jl_bt_ota.model.BleScanMessage
            r5.<init>()
            r4.g(r3, r5)
            goto L76
        Lb1:
            if (r0 != 0) goto L76
            if (r3 == 0) goto Lcb
            com.example.test.XXApplication r7 = r8.f17901f
            boolean r7 = com.google.android.gms.internal.mlkit_vision_barcode.ub.a(r7)
            if (r7 != 0) goto Lbe
            goto Lcb
        Lbe:
            int r7 = r3.getType()
            if (r7 == r6) goto L76
            int r6 = r3.getType()
            if (r6 != r5) goto Lcb
            goto L76
        Lcb:
            java.util.ArrayList r5 = r8.f15513n
            boolean r6 = r5.contains(r3)
            if (r6 != 0) goto L76
            r5.add(r3)
            com.jieli.jl_bt_ota.model.BleScanMessage r5 = new com.jieli.jl_bt_ota.model.BleScanMessage
            r5.<init>()
            r4.g(r3, r5)
            goto L76
        Ldf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.b.s(boolean):void");
    }

    public final boolean t(String str, boolean z5) {
        int i3 = Build.VERSION.SDK_INT;
        XXApplication xXApplication = this.f17901f;
        boolean z6 = i3 < 31 || (xXApplication != null && a1.g.a(xXApplication, "android.permission.BLUETOOTH_SCAN") == 0);
        String str2 = this.f17897a;
        if (!z6) {
            ee.c.f(str2, str, "Missing bluetooth scan permissions.");
            return true;
        }
        if (!z5 && i3 < 31 && ((xXApplication == null || a1.g.a(xXApplication, "android.permission.ACCESS_FINE_LOCATION") != 0) && (xXApplication == null || a1.g.a(xXApplication, "android.permission.ACCESS_COARSE_LOCATION") != 0))) {
            ee.c.f(str2, str, "Missing location permissions.");
            return true;
        }
        if (!ee.a.d()) {
            ee.c.f(str2, str, "Bluetooth is off.");
            return true;
        }
        if (this.f17898b != null) {
            return false;
        }
        ee.c.f(str2, str, "The device is not supported bluetooth.");
        return true;
    }

    public final void u(final int i3, final int i10, final rd.b bVar) {
        ExecutorService executorService;
        if (i3 >= 0 && i10 >= 0) {
            if (this.F != null && this.F.length > 0) {
                byte[] bArr = new byte[i10];
                if (i3 + i10 <= this.F.length) {
                    System.arraycopy(this.F, i3, bArr, 0, i10);
                    bVar.onSuccess(bArr);
                    return;
                }
                int length = this.F.length;
                Locale locale = Locale.ENGLISH;
                StringBuilder s7 = l0.s(i3, "readBlockData :: Can not read file data by Buffer. offset = ", i10, ", len = ", ", file data length = ");
                s7.append(length);
                s7.append(".");
                bVar.a(i0.c(16388, s7.toString()));
                return;
            }
            if (this.G != null && (executorService = this.D) != null && !executorService.isShutdown()) {
                this.D.execute(new Runnable() { // from class: qd.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        k6.b bVar2 = k6.b.this;
                        final int i11 = i10;
                        final int i12 = i3;
                        final rd.b bVar3 = bVar;
                        try {
                            byte[] bArr2 = new byte[i11];
                            bVar2.G.seek(i12);
                            final int read = bVar2.G.read(bArr2);
                            if (read == i11) {
                                bVar2.M.post(new androidx.camera.camera2.internal.compat.e(bVar3, bArr2, read, 4));
                            } else {
                                final long length2 = bVar2.G.length();
                                bVar2.M.post(new Runnable() { // from class: qd.e
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        rd.b bVar4 = rd.b.this;
                                        Locale locale2 = Locale.ENGLISH;
                                        bVar4.a(i0.c(16388, "readBlockData :: Can not read file data by RandomAccessFile. offset = " + i12 + ", len = " + i11 + ", read data size = " + read + ", file data length = " + length2 + "."));
                                    }
                                });
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            bVar2.M.post(new n5.a(2, bVar3, e));
                        }
                    }
                });
                return;
            }
        }
        Locale locale2 = Locale.ENGLISH;
        bVar.a(i0.c(4097, android.support.v4.media.session.e.g(i3, "readBlockData :: Can not read file data. offset = ", i10, ", len = ", ".")));
    }

    public final void v(BluetoothDevice bluetoothDevice, int i3) {
        if (bluetoothDevice == null) {
            ee.c.d(this.f17897a, "handleConnectedEvent", "device is null.");
            return;
        }
        String str = this.f17897a;
        String e = ee.a.e(this.f17901f, bluetoothDevice);
        Locale locale = Locale.ENGLISH;
        ee.c.c(str, "handleConnectedEvent", "device : " + e + ", way = " + i3);
        if (i3 == 0) {
            this.M.removeMessages(4661);
        }
        this.f17903h = bluetoothDevice;
        ee.c.c(this.f17897a, "getDeviceInfoWithConnection", "---->");
        this.f15524z.b(new h(this, bluetoothDevice, 0));
    }

    public final boolean w(String str) {
        if (this.E) {
            return false;
        }
        ee.c.f(this.f17897a, str, "OTA process has exited.");
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e5, code lost:
    
        if (r13 != 2) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(android.bluetooth.BluetoothDevice r12, int r13) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.b.x(android.bluetooth.BluetoothDevice, int):void");
    }

    public final boolean y(String str, BluetoothDevice bluetoothDevice) {
        boolean a3 = ub.a(this.f17901f);
        String str2 = this.f17897a;
        if (!a3) {
            ee.c.f(str2, str, "Missing connect permissions.");
            return true;
        }
        if (bluetoothDevice == null) {
            ee.c.f(str2, str, "Device is null.");
            return true;
        }
        if (ee.a.d()) {
            return false;
        }
        ee.c.f(str2, str, "Bluetooth is off.");
        return true;
    }

    public final void z() {
        ee.c.b(4, this.f17897a, "callbackCancelOTA : ");
        N();
        this.C.h();
        this.M.postDelayed(new qd.c(this, 0), 100L);
    }
}
