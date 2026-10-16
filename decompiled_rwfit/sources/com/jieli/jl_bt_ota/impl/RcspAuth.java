package com.jieli.jl_bt_ota.impl;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import androidx.camera.camera2.internal.compat.h;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.jieli.jl_bt_ota.impl.RcspAuth;
import ee.b;
import ee.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import n.x0;
import n5.a;
import qd.j;
import qd.k;
import qd.l;
import rd.e;

@Keep
/* loaded from: classes.dex */
public class RcspAuth {
    private static final int AUTH_RETRY_COUNT = 2;
    private static final long DEFAULT_AUTH_TIMEOUT = 3000;
    private static long DELAY_AUTH_WAITING_TIME = 3000;
    public static final int ERR_AUTH_DATA_CHECK = 40980;
    public static final int ERR_AUTH_DATA_SEND = 40979;
    public static final int ERR_AUTH_DEVICE_TIMEOUT = 40977;
    public static final int ERR_AUTH_USER_STOP = 40978;
    public static final int ERR_NONE = 0;
    private static final int MSG_AUTH_DEVICE_TIMEOUT = 18;
    private static final int MSG_SEND_AUTH_DATA_TIMEOUT = 17;
    public static boolean SUPPORT_RESET_FLAG = false;
    private static final String TAG = "RcspAuth";
    private static volatile boolean mIsLibLoaded = false;
    public static final e sLocalLibLoader = new x0(2);
    private final boolean isLibInit;
    private final Context mContext;
    private final k mIRcspAuthOp;
    private final List<l> mOnRcspAuthListeners = Collections.synchronizedList(new ArrayList());
    private final Map<String, j> mAuthTaskMap = Collections.synchronizedMap(new HashMap());
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new de.j(this, 5));

    public RcspAuth(Context context, k kVar, l lVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("IRcspAuthOp can not be null.");
        }
        loadLibrariesOnce(null);
        this.isLibInit = nativeInit();
        this.mContext = context;
        this.mIRcspAuthOp = kVar;
        addListener(lVar);
    }

    private String getErrorMsg(int i3) {
        switch (i3) {
            case ERR_AUTH_DEVICE_TIMEOUT /* 40977 */:
                return "Auth device timeout.";
            case ERR_AUTH_USER_STOP /* 40978 */:
                return "User stop auth device.";
            case ERR_AUTH_DATA_SEND /* 40979 */:
                return "Failed to send data.";
            case ERR_AUTH_DATA_CHECK /* 40980 */:
                return "Check auth data error.";
            default:
                return "";
        }
    }

    private byte[] getResetAuthFlagCmdData() {
        char[] cArr = b.f12595a;
        String upperCase = "FEDCBAC00600020001EF".replace(" ", "").toUpperCase(Locale.US);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i10 = i3 * 2;
            int i11 = i10 + 1;
            bArr[i3] = (byte) (Integer.decode("0x" + upperCase.substring(i10, i11) + upperCase.substring(i11, i10 + 2)).intValue() & 255);
        }
        return bArr;
    }

    private boolean isValidAuthData(byte[] bArr) {
        byte b3;
        return (bArr == null || bArr.length == 0 || ((bArr.length != 5 || bArr[0] != 2) && (bArr.length != 17 || ((b3 = bArr[0]) != 0 && b3 != 1)))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAuthFailed$3(BluetoothDevice bluetoothDevice, int i3, String str) {
        if (this.mOnRcspAuthListeners.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mOnRcspAuthListeners);
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((l) obj).a(bluetoothDevice, i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAuthSuccess$2(BluetoothDevice bluetoothDevice) {
        if (this.mOnRcspAuthListeners.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mOnRcspAuthListeners);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((l) obj).b(bluetoothDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInitResult$1(boolean z5) {
        if (this.mOnRcspAuthListeners.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mOnRcspAuthListeners);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((l) obj).c(z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$startAuth$0(BluetoothDevice bluetoothDevice, j jVar) {
        if (!sendAuthDataToDevice(bluetoothDevice, jVar.f17934d)) {
            onAuthFailed(bluetoothDevice, ERR_AUTH_DATA_SEND, "Failed to send data.");
            return;
        }
        this.mHandler.removeMessages(17);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(17, bluetoothDevice), DELAY_AUTH_WAITING_TIME);
    }

    public static void loadLibrariesOnce(e eVar) {
        synchronized (RcspAuth.class) {
            try {
                if (!mIsLibLoaded) {
                    if (eVar == null) {
                        eVar = sLocalLibLoader;
                    }
                    ((x0) eVar).getClass();
                    System.loadLibrary("jl_ota_auth");
                    mIsLibLoaded = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAuthFailed(BluetoothDevice bluetoothDevice, int i3) {
        onAuthFailed(bluetoothDevice, i3, getErrorMsg(i3));
    }

    private void onAuthSuccess(BluetoothDevice bluetoothDevice) {
        String str = TAG;
        String printDeviceInfo = printDeviceInfo(bluetoothDevice);
        Locale locale = Locale.ENGLISH;
        c.f(str, "onAuthSuccess", "device = " + printDeviceInfo + ",  auth ok.");
        this.mHandler.post(new a(3, this, bluetoothDevice));
        if (bluetoothDevice != null) {
            this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
        }
    }

    private void onInitResult(boolean z5) {
        this.mHandler.post(new o6.e(this, z5, 1));
    }

    private String printDeviceInfo(BluetoothDevice bluetoothDevice) {
        return ee.a.e(this.mContext, bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sendAuthDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr) {
        if (bluetoothDevice == null || bArr == null) {
            return false;
        }
        boolean a3 = this.mIRcspAuthOp.a(bluetoothDevice, bArr);
        String str = TAG;
        String printDeviceInfo = printDeviceInfo(bluetoothDevice);
        String c9 = b.c(bArr);
        Locale locale = Locale.ENGLISH;
        c.e(str, "sendAuthDataToDevice", l0.p("device : ", printDeviceInfo, ", authData : ", c9));
        return a3;
    }

    public static boolean setAuthTimeout(long j4) {
        if (j4 >= 3000) {
            DELAY_AUTH_WAITING_TIME = j4;
            return true;
        }
        String str = TAG;
        Locale locale = Locale.ENGLISH;
        c.c(str, "setAuthTimeout", "The set time[" + j4 + "] cannot be less than the minimum time[3000].");
        return false;
    }

    public void addListener(l lVar) {
        if (lVar != null) {
            this.mOnRcspAuthListeners.add(lVar);
            lVar.c(this.isLibInit);
        }
    }

    public void destroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mAuthTaskMap.clear();
        this.mOnRcspAuthListeners.clear();
        mIsLibLoaded = false;
    }

    public byte[] getAuthData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return getEncryptedAuthData(bArr);
    }

    public byte[] getAuthOkData() {
        return new byte[]{2, 112, 97, 115, 115};
    }

    public native byte[] getEncryptedAuthData(byte[] bArr);

    public native byte[] getRandomAuthData();

    public byte[] getRandomData() {
        return getRandomAuthData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
    
        if (sendAuthDataToDevice(r9, getAuthOkData()) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a2, code lost:
    
        r10 = com.jieli.jl_bt_ota.impl.RcspAuth.ERR_AUTH_DATA_SEND;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009e, code lost:
    
        if (sendAuthDataToDevice(r9, r10) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handleAuthData(android.bluetooth.BluetoothDevice r9, byte[] r10) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_bt_ota.impl.RcspAuth.handleAuthData(android.bluetooth.BluetoothDevice, byte[]):void");
    }

    public native boolean nativeInit();

    public void removeListener(l lVar) {
        if (lVar != null) {
            this.mOnRcspAuthListeners.remove(lVar);
        }
    }

    public int setDeviceConnectionLinkKey(byte[] bArr) {
        return setLinkKey(bArr);
    }

    public native int setLinkKey(byte[] bArr);

    public boolean startAuth(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        if (this.mAuthTaskMap.containsKey(bluetoothDevice.getAddress())) {
            j jVar = this.mAuthTaskMap.get(bluetoothDevice.getAddress());
            if (jVar != null && (jVar.f17933c || this.mHandler.hasMessages(18))) {
                c.e(TAG, "startAuth", "The device has been certified or certification of device is in progress.");
                return true;
            }
            this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
        }
        c.e(TAG, "startAuth", "device = " + printDeviceInfo(bluetoothDevice));
        j jVar2 = new j();
        jVar2.f17931a = bluetoothDevice;
        jVar2.f17934d = getRandomData();
        this.mAuthTaskMap.put(bluetoothDevice.getAddress(), jVar2);
        if (SUPPORT_RESET_FLAG) {
            boolean sendAuthDataToDevice = sendAuthDataToDevice(bluetoothDevice, getResetAuthFlagCmdData());
            if (sendAuthDataToDevice) {
                this.mHandler.postDelayed(new h(this, 16, bluetoothDevice, jVar2), 500L);
            }
            return sendAuthDataToDevice;
        }
        boolean sendAuthDataToDevice2 = sendAuthDataToDevice(bluetoothDevice, jVar2.f17934d);
        if (sendAuthDataToDevice2) {
            this.mHandler.removeMessages(17);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(17, bluetoothDevice), DELAY_AUTH_WAITING_TIME);
        }
        return sendAuthDataToDevice2;
    }

    public void stopAuth(BluetoothDevice bluetoothDevice) {
        stopAuth(bluetoothDevice, true);
    }

    private void onAuthFailed(final BluetoothDevice bluetoothDevice, final int i3, final String str) {
        String str2 = TAG;
        Locale locale = Locale.ENGLISH;
        c.d(str2, "onAuthFailed", "device = " + bluetoothDevice + ",  code = " + i3 + ", message = " + str + ".");
        this.mHandler.removeMessages(17);
        this.mHandler.removeMessages(18);
        this.mHandler.post(new Runnable() { // from class: qd.i
            @Override // java.lang.Runnable
            public final void run() {
                RcspAuth.this.lambda$onAuthFailed$3(bluetoothDevice, i3, str);
            }
        });
        if (bluetoothDevice != null) {
            this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
        }
    }

    public void stopAuth(BluetoothDevice bluetoothDevice, boolean z5) {
        if (bluetoothDevice == null) {
            return;
        }
        j remove = this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
        if (z5) {
            if (remove != null) {
                onAuthFailed(bluetoothDevice, ERR_AUTH_USER_STOP);
            }
            this.mHandler.removeMessages(17);
            this.mHandler.removeMessages(18);
        }
    }
}
