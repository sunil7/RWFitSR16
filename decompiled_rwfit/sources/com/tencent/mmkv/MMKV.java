package com.tencent.mmkv;

import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import dalvik.annotation.optimization.FastNative;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import mg.a;

/* loaded from: classes2.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumMap f11896a;

    /* renamed from: b, reason: collision with root package name */
    public static final EnumMap f11897b;

    /* renamed from: c, reason: collision with root package name */
    public static final MMKVLogLevel[] f11898c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashSet f11899d;
    public static String e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f11900f;

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap f11901g;
    private final long nativeHandle;

    static {
        EnumMap enumMap = new EnumMap(MMKVRecoverStrategic.class);
        f11896a = enumMap;
        enumMap.put((EnumMap) MMKVRecoverStrategic.OnErrorDiscard, (MMKVRecoverStrategic) 0);
        enumMap.put((EnumMap) MMKVRecoverStrategic.OnErrorRecover, (MMKVRecoverStrategic) 1);
        EnumMap enumMap2 = new EnumMap(MMKVLogLevel.class);
        f11897b = enumMap2;
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelDebug;
        enumMap2.put((EnumMap) mMKVLogLevel, (MMKVLogLevel) 0);
        MMKVLogLevel mMKVLogLevel2 = MMKVLogLevel.LevelInfo;
        enumMap2.put((EnumMap) mMKVLogLevel2, (MMKVLogLevel) 1);
        MMKVLogLevel mMKVLogLevel3 = MMKVLogLevel.LevelWarning;
        enumMap2.put((EnumMap) mMKVLogLevel3, (MMKVLogLevel) 2);
        MMKVLogLevel mMKVLogLevel4 = MMKVLogLevel.LevelError;
        enumMap2.put((EnumMap) mMKVLogLevel4, (MMKVLogLevel) 3);
        MMKVLogLevel mMKVLogLevel5 = MMKVLogLevel.LevelNone;
        enumMap2.put((EnumMap) mMKVLogLevel5, (MMKVLogLevel) 4);
        f11898c = new MMKVLogLevel[]{mMKVLogLevel, mMKVLogLevel2, mMKVLogLevel3, mMKVLogLevel4, mMKVLogLevel5};
        f11899d = new HashSet();
        e = null;
        f11900f = true;
        f11901g = new HashMap();
    }

    public MMKV(long j4) {
        this.nativeHandle = j4;
    }

    private native long actualSize(long j4);

    private native String[] allKeys(long j4, boolean z5);

    public static native long backupAllToDirectory(String str);

    public static native boolean backupOneToDirectory(String str, String str2, String str3);

    private static native boolean checkProcessMode(long j4);

    private native boolean containsKey(long j4, String str);

    private native long count(long j4, boolean z5);

    private static native long createNB(int i3);

    private native boolean decodeBool(long j4, String str, boolean z5);

    private native byte[] decodeBytes(long j4, String str);

    private native double decodeDouble(long j4, String str, double d5);

    private native float decodeFloat(long j4, String str, float f2);

    private native int decodeInt(long j4, String str, int i3);

    private native long decodeLong(long j4, String str, long j10);

    private native String decodeString(long j4, String str, String str2);

    private native String[] decodeStringSet(long j4, String str);

    private static native void destroyNB(long j4, int i3);

    private native boolean encodeBool(long j4, String str, boolean z5);

    private native boolean encodeBool_2(long j4, String str, boolean z5, int i3);

    private native boolean encodeBytes(long j4, String str, byte[] bArr);

    private native boolean encodeBytes_2(long j4, String str, byte[] bArr, int i3);

    private native boolean encodeDouble(long j4, String str, double d5);

    private native boolean encodeDouble_2(long j4, String str, double d5, int i3);

    private native boolean encodeFloat(long j4, String str, float f2);

    private native boolean encodeFloat_2(long j4, String str, float f2, int i3);

    private native boolean encodeInt(long j4, String str, int i3);

    private native boolean encodeInt_2(long j4, String str, int i3, int i10);

    private native boolean encodeLong(long j4, String str, long j10);

    private native boolean encodeLong_2(long j4, String str, long j10, int i3);

    private native boolean encodeSet(long j4, String str, String[] strArr);

    private native boolean encodeSet_2(long j4, String str, String[] strArr, int i3);

    private native boolean encodeString(long j4, String str, String str2);

    private native boolean encodeString_2(long j4, String str, String str2, int i3);

    private static native long getDefaultMMKV(int i3, String str);

    private static native long getMMKVWithAshmemFD(String str, int i3, int i10, String str2);

    private static native long getMMKVWithID(String str, int i3, String str2, String str3, long j4);

    private static native long getMMKVWithIDAndSize(String str, int i3, int i10, String str2);

    public static MMKV h() {
        if (e == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        long defaultMMKV = getDefaultMMKV(1, null);
        if (defaultMMKV == 0) {
            throw new RuntimeException("Fail to create an MMKV instance [DefaultMMKV] in JNI");
        }
        if (!f11900f) {
            return new MMKV(defaultMMKV);
        }
        HashSet hashSet = f11899d;
        synchronized (hashSet) {
            try {
                if (!hashSet.contains(Long.valueOf(defaultMMKV))) {
                    if (!checkProcessMode(defaultMMKV)) {
                        throw new IllegalArgumentException("Opening a multi-process MMKV instance [DefaultMMKV] with SINGLE_PROCESS_MODE!");
                    }
                    hashSet.add(Long.valueOf(defaultMMKV));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return new MMKV(defaultMMKV);
    }

    private native boolean isCompareBeforeSetEnabled();

    @FastNative
    private native boolean isEncryptionEnabled();

    @FastNative
    private native boolean isExpirationEnabled();

    public static native boolean isFileValid(String str, String str2);

    private static native void jniInitialize(String str, String str2, int i3, boolean z5);

    private static void mmkvLogImp(int i3, String str, int i10, String str2, String str3) {
        int i11 = a.f16128a[f11898c[i3].ordinal()];
        if (i11 == 1) {
            Log.d("MMKV", str3);
            return;
        }
        if (i11 == 2) {
            Log.w("MMKV", str3);
        } else if (i11 == 3) {
            Log.e("MMKV", str3);
        } else {
            if (i11 != 5) {
                return;
            }
            Log.i("MMKV", str3);
        }
    }

    @FastNative
    private native void nativeEnableCompareBeforeSet();

    private static void onContentChangedByOuterProcess(String str) {
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        t(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = (Integer) f11896a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        t(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = (Integer) f11896a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static void p(XXApplication xXApplication) {
        String str = xXApplication.getFilesDir().getAbsolutePath() + "/mmkv";
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
        int i3 = 2;
        if ((xXApplication.getApplicationInfo().flags & 2) == 0) {
            synchronized (f11899d) {
                f11900f = false;
            }
            Log.i("MMKV", "Disable checkProcessMode()");
        } else {
            synchronized (f11899d) {
                f11900f = true;
            }
            Log.i("MMKV", "Enable checkProcessMode()");
        }
        String absolutePath = xXApplication.getCacheDir().getAbsolutePath();
        System.loadLibrary("mmkv");
        int i10 = a.f16128a[mMKVLogLevel.ordinal()];
        if (i10 == 1) {
            i3 = 0;
        } else if (i10 != 2) {
            i3 = 3;
            if (i10 != 3) {
                i3 = 4;
                if (i10 != 4) {
                    i3 = 1;
                }
            }
        }
        jniInitialize(str, absolutePath, i3, false);
        e = str;
    }

    public static native int pageSize();

    public static MMKV q(int i3, int i10, String str, String str2) {
        long mMKVWithAshmemFD = getMMKVWithAshmemFD(str, i3, i10, str2);
        if (mMKVWithAshmemFD != 0) {
            return new MMKV(mMKVWithAshmemFD);
        }
        throw new RuntimeException(l0.o("Fail to create an ashmem MMKV instance [", str, "] in JNI"));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.tencent.mmkv.MMKV r(android.content.Context r6, java.lang.String r7, int r8, int r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmkv.MMKV.r(android.content.Context, java.lang.String, int, int, java.lang.String):com.tencent.mmkv.MMKV");
    }

    public static native boolean removeStorage(String str, String str2);

    private native void removeValueForKey(long j4, String str);

    public static native long restoreAllFromDirectory(String str);

    public static native boolean restoreOneMMKVFromDirectory(String str, String str2, String str3);

    private static native void setCallbackHandler(boolean z5, boolean z6);

    private static native void setLogLevel(int i3);

    private static native void setWantsContentChangeNotify(boolean z5);

    private native void sync(boolean z5);

    public static void t(MMKVLogLevel mMKVLogLevel, String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[r0.length - 1];
        Integer num = (Integer) f11897b.get(mMKVLogLevel);
        mmkvLogImp(num == null ? 0 : num.intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    private native long totalSize(long j4);

    private native int valueSize(long j4, String str, boolean z5);

    public static native String version();

    private native int writeValueToNB(long j4, String str, long j10, int i3);

    public final boolean a(String str) {
        return decodeBool(this.nativeHandle, str, false);
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public final double b(String str) {
        return decodeDouble(this.nativeHandle, str, 0.0d);
    }

    public final float c(String str) {
        return decodeFloat(this.nativeHandle, str, 0.0f);
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(String str);

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearAllWithKeepingSpace();

    public native void clearMemoryCache();

    public native void close();

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public native String cryptKey();

    public final int d(String str) {
        return decodeInt(this.nativeHandle, str, 0);
    }

    public native boolean disableAutoKeyExpire();

    public native void disableCompareBeforeSet();

    public final long e(String str) {
        return decodeLong(this.nativeHandle, str, 0L);
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return this;
    }

    public native boolean enableAutoKeyExpire(int i3);

    public final Parcelable f(String str, Class cls) {
        Parcelable.Creator creator;
        byte[] decodeBytes = decodeBytes(this.nativeHandle, str);
        if (decodeBytes != null) {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(decodeBytes, 0, decodeBytes.length);
            obtain.setDataPosition(0);
            try {
                String cls2 = cls.toString();
                HashMap hashMap = f11901g;
                synchronized (hashMap) {
                    try {
                        creator = (Parcelable.Creator) hashMap.get(cls2);
                        if (creator == null && (creator = (Parcelable.Creator) cls.getField("CREATOR").get(null)) != null) {
                            hashMap.put(cls2, creator);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (creator != null) {
                    return (Parcelable) creator.createFromParcel(obtain);
                }
                throw new Exception("Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class " + cls2);
            } catch (Exception e10) {
                t(MMKVLogLevel.LevelError, e10.toString());
            } finally {
                obtain.recycle();
            }
        }
        return null;
    }

    public final String g(String str) {
        return decodeString(this.nativeHandle, str, null);
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z5) {
        return decodeBool(this.nativeHandle, str, z5);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f2) {
        return decodeFloat(this.nativeHandle, str, f2);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i3) {
        return decodeInt(this.nativeHandle, str, i3);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j4) {
        return decodeLong(this.nativeHandle, str, j4);
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        String[] decodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (decodeStringSet != null) {
            try {
                Set set2 = (Set) HashSet.class.newInstance();
                set2.addAll(Arrays.asList(decodeStringSet));
                return set2;
            } catch (IllegalAccessException | InstantiationException unused) {
            }
        }
        return set;
    }

    public final boolean i(int i3, String str) {
        return encodeInt(this.nativeHandle, str, i3);
    }

    public final boolean j(long j4, String str) {
        return encodeLong(this.nativeHandle, str, j4);
    }

    public final boolean k(String str, double d5) {
        return encodeDouble(this.nativeHandle, str, d5);
    }

    public final boolean l(String str, float f2) {
        return encodeFloat(this.nativeHandle, str, f2);
    }

    public native void lock();

    public final boolean m(String str, Parcelable parcelable) {
        if (parcelable == null) {
            return encodeBytes(this.nativeHandle, str, null);
        }
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return encodeBytes(this.nativeHandle, str, marshall);
    }

    public native String mmapID();

    public final boolean n(String str, String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public final boolean o(String str, boolean z5) {
        return encodeBool(this.nativeHandle, str, z5);
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z5) {
        encodeBool(this.nativeHandle, str, z5);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f2) {
        encodeFloat(this.nativeHandle, str, f2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i3) {
        encodeInt(this.nativeHandle, str, i3);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j4) {
        encodeLong(this.nativeHandle, str, j4);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        encodeSet(this.nativeHandle, str, set == null ? null : (String[]) set.toArray(new String[0]));
        return this;
    }

    public native boolean reKey(String str);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        s(str);
        return this;
    }

    public native void removeValuesForKeys(String[] strArr);

    public final void s(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }
}
