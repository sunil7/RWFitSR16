package ee;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.ub;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f12594a = "0123456789ABCDEF".toCharArray();

    public static byte[] a(String str) {
        if (!TextUtils.isEmpty(str) && str.contains(":")) {
            String replace = str.replace(":", "");
            int length = replace.length() / 2;
            byte[] bArr = new byte[length];
            if (length == 6) {
                for (int i3 = 0; i3 < length; i3++) {
                    int i10 = i3 * 2;
                    int i11 = i10 + 2;
                    if (i11 <= replace.length()) {
                        try {
                            bArr[i3] = (byte) Integer.valueOf(replace.substring(i10, i11), 16).intValue();
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }
                return bArr;
            }
        }
        return null;
    }

    public static boolean b(BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2) {
        return (bluetoothDevice == null || bluetoothDevice2 == null || !bluetoothDevice.getAddress().equals(bluetoothDevice2.getAddress())) ? false : true;
    }

    public static ArrayList c(XXApplication xXApplication) {
        if (ub.a(xXApplication)) {
            ArrayList arrayList = new ArrayList();
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            try {
                int i3 = -1;
                if (ub.a(xXApplication) && defaultAdapter != null) {
                    try {
                        Method declaredMethod = defaultAdapter.getClass().getDeclaredMethod("getConnectionState", null);
                        declaredMethod.setAccessible(true);
                        Object invoke = declaredMethod.invoke(defaultAdapter, null);
                        if (invoke instanceof Integer) {
                            i3 = ((Integer) invoke).intValue();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (i3 == 2 || i3 == 0) {
                    for (BluetoothDevice bluetoothDevice : defaultAdapter.getBondedDevices()) {
                        boolean z5 = false;
                        if (ub.a(xXApplication) && bluetoothDevice != null) {
                            try {
                                Object invoke2 = bluetoothDevice.getClass().getDeclaredMethod("isConnected", null).invoke(bluetoothDevice, null);
                                if (invoke2 instanceof Boolean) {
                                    z5 = ((Boolean) invoke2).booleanValue();
                                }
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                        }
                        if (z5) {
                            arrayList.add(bluetoothDevice);
                        }
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    public static boolean d() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    public static String e(Context context, BluetoothDevice bluetoothDevice) {
        if (!ub.a(context) || bluetoothDevice == null) {
            return "null";
        }
        return "name : " + bluetoothDevice.getName() + " ,type : " + bluetoothDevice.getType() + " ,address : " + bluetoothDevice.getAddress();
    }
}
