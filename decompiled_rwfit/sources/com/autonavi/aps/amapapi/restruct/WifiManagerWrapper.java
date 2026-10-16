package com.autonavi.aps.amapapi.restruct;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.ICollectionManager;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.Reflect;
import com.autonavi.aps.amapapi.utils.Utils;
import com.autonavi.base.ae.gmap.glyph.FontStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import k3.a;

/* loaded from: classes.dex */
public class WifiManagerWrapper {
    public static long lLastWifiChange;

    /* renamed from: t, reason: collision with root package name */
    static long f6708t;

    /* renamed from: u, reason: collision with root package name */
    static long f6709u;

    /* renamed from: v, reason: collision with root package name */
    static long f6710v;

    /* renamed from: w, reason: collision with root package name */
    static long f6711w;

    /* renamed from: a, reason: collision with root package name */
    WifiManager f6713a;

    /* renamed from: d, reason: collision with root package name */
    Context f6716d;

    /* renamed from: m, reason: collision with root package name */
    WifiAgeEstimator f6724m;
    private ICollectionManager r;
    public static HashMap<String, Long> lastResultMap = new HashMap<>(36);
    public static long lastWifiListUpdate = 0;

    /* renamed from: x, reason: collision with root package name */
    static int f6712x = 0;
    public static long lLastCarrierWifiChange = 0;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<a> f6714b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    ArrayList<a> f6715c = new ArrayList<>();
    boolean e = false;

    /* renamed from: f, reason: collision with root package name */
    StringBuilder f6717f = null;

    /* renamed from: g, reason: collision with root package name */
    boolean f6718g = true;

    /* renamed from: h, reason: collision with root package name */
    boolean f6719h = true;

    /* renamed from: i, reason: collision with root package name */
    boolean f6720i = true;

    /* renamed from: j, reason: collision with root package name */
    private volatile WifiInfoWrapper f6721j = null;

    /* renamed from: k, reason: collision with root package name */
    String f6722k = null;

    /* renamed from: l, reason: collision with root package name */
    TreeMap<Integer, a> f6723l = null;
    public boolean isWifiEnabled = true;
    public boolean mSystemWifiEnabled = true;
    public boolean mISStartCollect = false;

    /* renamed from: n, reason: collision with root package name */
    private String f6725n = "";

    /* renamed from: o, reason: collision with root package name */
    long f6726o = 0;

    /* renamed from: p, reason: collision with root package name */
    ConnectivityManager f6727p = null;

    /* renamed from: q, reason: collision with root package name */
    private long f6728q = 30000;

    /* renamed from: s, reason: collision with root package name */
    volatile boolean f6729s = false;

    public WifiManagerWrapper(Context context, WifiManager wifiManager, Handler handler) {
        this.f6713a = wifiManager;
        this.f6716d = context;
        WifiAgeEstimator wifiAgeEstimator = new WifiAgeEstimator(context, "wifiAgee", handler);
        this.f6724m = wifiAgeEstimator;
        wifiAgeEstimator.start();
    }

    public List<a> a() {
        List<ScanResult> list;
        if (this.f6713a != null) {
            try {
                if (Utils.hasPerminssion(this.f6716d, Const.ACCESS_WIFI_STATE_SELF_BASE64)) {
                    list = this.f6713a.getScanResults();
                } else {
                    CoreUtil.reportError(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");
                    list = null;
                }
                HashMap<String, Long> hashMap = new HashMap<>(36);
                if (list != null) {
                    for (ScanResult scanResult : list) {
                        hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                }
                if (lastResultMap.isEmpty() || !lastResultMap.equals(hashMap)) {
                    lastResultMap = hashMap;
                    lastWifiListUpdate = Utils.getTimeBoot();
                }
                this.f6722k = null;
                ArrayList arrayList = new ArrayList();
                this.f6725n = "";
                this.f6721j = getWifiAccess();
                if (wifiUseful(this.f6721j)) {
                    this.f6725n = this.f6721j.getBSSID();
                }
                if (list != null && list.size() > 0) {
                    int size = list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ScanResult scanResult2 = list.get(i3);
                        a aVar = new a(!TextUtils.isEmpty(this.f6725n) && this.f6725n.equals(scanResult2.BSSID));
                        aVar.f15456b = scanResult2.SSID;
                        aVar.f15458d = scanResult2.frequency;
                        aVar.e = scanResult2.timestamp;
                        aVar.f15455a = a.b(scanResult2.BSSID);
                        aVar.f15457c = (short) scanResult2.level;
                        short elapsedRealtime = (short) ((SystemClock.elapsedRealtime() - (scanResult2.timestamp / 1000)) / 1000);
                        aVar.f15460g = elapsedRealtime;
                        if (elapsedRealtime < 0) {
                            aVar.f15460g = (short) 0;
                        }
                        aVar.f15459f = Utils.getTimeBoot();
                        arrayList.add(aVar);
                    }
                }
                this.f6724m.update((List) arrayList);
                return arrayList;
            } catch (SecurityException e) {
                this.f6722k = e.getMessage();
            } catch (Throwable th2) {
                this.f6722k = null;
                CoreUtil.reportError(th2, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    public boolean b() {
        long timeBoot = Utils.getTimeBoot() - f6708t;
        if (timeBoot < 4900) {
            return false;
        }
        if (this.f6727p == null) {
            this.f6727p = (ConnectivityManager) Utils.getServ(this.f6716d, "connectivity");
        }
        if (wifiAccess(this.f6727p) && timeBoot < Const.MINWIFIUPDATE_ACCESS) {
            return false;
        }
        if (f6712x > 1) {
            long j4 = this.f6728q;
            if (j4 == 30000) {
                j4 = AuthUtil.getAPWifiScanInterval() != -1 ? AuthUtil.getAPWifiScanInterval() : 30000L;
            }
            if (Build.VERSION.SDK_INT >= 28 && timeBoot < j4) {
                return false;
            }
        }
        if (this.f6713a != null) {
            f6708t = Utils.getTimeBoot();
            int i3 = f6712x;
            if (i3 < 2) {
                f6712x = i3 + 1;
            }
            if (Utils.hasPerminssion(this.f6716d, Const.CHANGE_WIFI_STATE_SELF_BASE64)) {
                return this.f6713a.startScan();
            }
            CoreUtil.reportError(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
        }
        return false;
    }

    public boolean c() {
        this.isWifiEnabled = this.f6713a == null ? false : Utils.isWifiAble(this.f6716d);
        checkSystemWifiEnabled();
        if (this.isWifiEnabled && this.f6718g) {
            if (f6710v == 0) {
                return true;
            }
            if (Utils.getTimeBoot() - f6710v >= 4900 && Utils.getTimeBoot() - lLastWifiChange >= Const.L_MIN_WIFI_RESULT) {
                Utils.getTimeBoot();
                return true;
            }
        }
        return false;
    }

    public void checkSystemWifiEnabled() {
        try {
            if (Utils.hasPerminssion(this.f6716d, Const.ACCESS_WIFI_STATE_SELF_BASE64)) {
                this.mSystemWifiEnabled = this.f6713a.isWifiEnabled();
            }
        } catch (Throwable unused) {
            DebugUtils.writeCat("WMW | cswe e", false);
        }
    }

    public void d() {
        if (c()) {
            try {
                if (b()) {
                    f6710v = Utils.getTimeBoot();
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "WifiManager", "wifiScan");
            }
        }
    }

    public void destroy(boolean z5) {
        resetWifiData();
        this.f6714b.clear();
        this.f6724m.destroy(z5);
    }

    public void enableWifiAlwaysScan(boolean z5) {
        Context context = this.f6716d;
        if (!AuthUtil.isCanAlwaysScanWifi() || !this.f6720i || this.f6713a == null || context == null || !z5 || Utils.getSdk() <= 17) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((Integer) Reflect.invokeStaticMethod("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                Reflect.invokeStaticMethod("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, (Class<?>[]) new Class[]{ContentResolver.class, String.class, Integer.TYPE});
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    public ArrayList<a> getAmapWifis() {
        if (!this.mISStartCollect) {
            return this.f6715c;
        }
        updateWifi(true);
        return this.f6715c;
    }

    public WifiInfo getConnectionInfo() {
        try {
            if (this.f6713a == null) {
                return null;
            }
            if (Utils.hasPerminssion(this.f6716d, Const.ACCESS_WIFI_STATE_SELF_BASE64)) {
                return this.f6713a.getConnectionInfo();
            }
            CoreUtil.reportError(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");
            return null;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    public long getMMacUpdateTime() {
        return this.f6726o;
    }

    public ArrayList<a> getScanResultsParam() {
        if (this.f6714b == null) {
            return null;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        if (!this.f6714b.isEmpty()) {
            arrayList.addAll(this.f6714b);
        }
        return arrayList;
    }

    public String getSecurityException() {
        return this.f6722k;
    }

    public WifiInfoWrapper getWifiAccess() {
        checkSystemWifiEnabled();
        if (!isSystemWifiEnabled()) {
            return null;
        }
        if (this.f6721j == null) {
            this.f6721j = new WifiInfoWrapper(getConnectionInfo());
        }
        return this.f6721j;
    }

    public String getWifiAge() {
        return String.valueOf(Utils.getTimeBoot() - lLastWifiChange);
    }

    public String getWifiParam() {
        String str;
        StringBuilder sb2 = this.f6717f;
        int i3 = 0;
        if (sb2 == null) {
            this.f6717f = new StringBuilder(FontStyle.WEIGHT_BOLD);
        } else {
            sb2.delete(0, sb2.length());
        }
        this.e = false;
        int size = this.f6714b.size();
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            boolean z8 = true;
            if (i3 >= size) {
                break;
            }
            String a3 = a.a(this.f6714b.get(i3).f15455a);
            if (!this.f6719h && !"<unknown ssid>".equals(this.f6714b.get(i3).f15456b)) {
                z5 = true;
            }
            if (TextUtils.isEmpty(this.f6725n) || !this.f6725n.equals(a3)) {
                z8 = z6;
                str = "nb";
            } else {
                str = "access";
            }
            StringBuilder sb3 = this.f6717f;
            Locale locale = Locale.US;
            sb3.append(Const.STR_MART_WELL + a3 + Const.STR_MART_COMMA + str);
            i3++;
            z6 = z8;
        }
        if (this.f6714b.size() == 0) {
            z5 = true;
        }
        if (!this.f6719h && !z5) {
            this.e = true;
        }
        if (!z6 && !TextUtils.isEmpty(this.f6725n)) {
            StringBuilder sb4 = this.f6717f;
            sb4.append(Const.STR_MART_WELL);
            sb4.append(this.f6725n);
            this.f6717f.append(",access");
        }
        return this.f6717f.toString();
    }

    public long getWifiResultAge() {
        return ((Utils.getTimeBoot() - lastWifiListUpdate) / 1000) + 1;
    }

    public boolean isMock() {
        return this.e;
    }

    public boolean isSystemWifiEnabled() {
        return this.mSystemWifiEnabled;
    }

    public boolean isWifiEnabled() {
        return this.isWifiEnabled;
    }

    public void onCollectLocation() {
        try {
            this.mISStartCollect = true;
            List<a> a3 = a();
            if (a3 != null) {
                this.f6714b.clear();
                this.f6714b.addAll(a3);
            }
            a(true);
        } catch (Throwable unused) {
        }
    }

    public void resetWifiAccess() {
        this.f6721j = null;
    }

    public void resetWifiData() {
        this.f6721j = null;
        this.f6714b.clear();
    }

    public void setCollectionManager(ICollectionManager iCollectionManager) {
        this.r = iCollectionManager;
    }

    public void setOption(boolean z5, boolean z6, boolean z8, boolean z10) {
        setOption(z5, z6, z8, z10, 30000L);
    }

    public void updateWifi(boolean z5) {
        List<a> list;
        int i3;
        if (!z5) {
            d();
        } else if (c()) {
            long timeBoot = Utils.getTimeBoot();
            if (timeBoot - f6709u >= 10000) {
                this.f6714b.clear();
                f6711w = lLastWifiChange;
            }
            d();
            if (timeBoot - f6709u >= 10000) {
                for (int i10 = 20; i10 > 0 && lLastWifiChange == f6711w; i10--) {
                    try {
                        Thread.sleep(Const.L_MAX_WAIT_WIFI / 20);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        boolean z6 = true;
        if (this.f6729s) {
            this.f6729s = false;
            try {
                WifiManager wifiManager = this.f6713a;
                if (wifiManager != null) {
                    try {
                        i3 = wifiManager.getWifiState();
                    } catch (Throwable th2) {
                        CoreUtil.reportError(th2, "OPENSDK_WMW", "cwsc");
                        i3 = 4;
                    }
                    if (this.f6714b == null) {
                        this.f6714b = new ArrayList<>();
                    }
                    if (i3 == 0 || i3 == 1 || i3 == 4) {
                        resetWifiData();
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        if (f6711w != lLastWifiChange) {
            try {
                list = a();
            } catch (Throwable th3) {
                CoreUtil.reportError(th3, "WifiManager", "updateScanResult");
                list = null;
            }
            f6711w = lLastWifiChange;
            if (list != null) {
                this.f6714b.clear();
                this.f6714b.addAll(list);
            } else {
                this.f6714b.clear();
            }
        }
        if (Utils.getTimeBoot() - lLastWifiChange > 20000) {
            this.f6714b.clear();
        }
        f6709u = Utils.getTimeBoot();
        if (this.f6714b.isEmpty()) {
            lLastWifiChange = Utils.getTimeBoot();
            List<a> a3 = a();
            if (a3 != null) {
                this.f6714b.addAll(a3);
                a(z6);
            }
        }
        z6 = false;
        a(z6);
    }

    public boolean wifiAccess(ConnectivityManager connectivityManager) {
        try {
            if (Utils.getNetT(connectivityManager.getActiveNetworkInfo()) == 1) {
                return wifiUseful(getWifiAccess());
            }
            return false;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public void wifiResultChange() {
        if (this.f6713a != null && Utils.getTimeBoot() - lLastWifiChange > 4900) {
            lLastWifiChange = Utils.getTimeBoot();
        }
    }

    public void wifiResultUpdateChange() {
        lLastCarrierWifiChange = System.currentTimeMillis();
        ICollectionManager iCollectionManager = this.r;
        if (iCollectionManager != null) {
            iCollectionManager.updateWiFi();
        }
    }

    public void wifiStateChange() {
        if (this.f6713a == null) {
            return;
        }
        this.f6729s = true;
    }

    public boolean wifiUseful(WifiInfoWrapper wifiInfoWrapper) {
        if (wifiInfoWrapper == null) {
            return false;
        }
        return wifiInfoWrapper.isUseFul();
    }

    public void setOption(boolean z5, boolean z6, boolean z8, boolean z10, long j4) {
        this.f6718g = z6;
        this.f6719h = z8;
        this.f6720i = z10;
        if (j4 < 10000) {
            this.f6728q = 10000L;
        } else {
            this.f6728q = j4;
        }
    }

    public void a(boolean z5) {
        ArrayList<a> arrayList = this.f6714b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (Utils.getTimeBoot() - lLastWifiChange > Const.L_WIFI_EXP) {
            resetWifiData();
        }
        if (this.f6723l == null) {
            this.f6723l = new TreeMap<>(Collections.reverseOrder());
        }
        this.f6723l.clear();
        if (this.mISStartCollect && z5) {
            try {
                this.f6715c.clear();
            } catch (Throwable unused) {
            }
        }
        int size = this.f6714b.size();
        this.f6726o = 0L;
        for (int i3 = 0; i3 < size; i3++) {
            a aVar = this.f6714b.get(i3);
            if (aVar.f15461h) {
                this.f6726o = aVar.f15459f;
            }
            if (Utils.wifiUseful(a.a(aVar.f15455a))) {
                int i10 = 20;
                if (size > 20) {
                    try {
                        i10 = WifiManager.calculateSignalLevel(aVar.f15457c, 20);
                    } catch (ArithmeticException e) {
                        CoreUtil.reportError(e, "Aps", "wifiSigFine");
                    }
                    if (!(i10 >= 1)) {
                    }
                }
                if (this.mISStartCollect && z5) {
                    this.f6715c.add(aVar);
                }
                if (!TextUtils.isEmpty(aVar.f15456b)) {
                    if (!"<unknown ssid>".equals(aVar.f15456b)) {
                        aVar.f15456b = String.valueOf(i3);
                    }
                } else {
                    aVar.f15456b = "unkwn";
                }
                this.f6723l.put(Integer.valueOf((aVar.f15457c * 25) + i3), aVar);
            }
        }
        this.f6714b.clear();
        Iterator<a> it = this.f6723l.values().iterator();
        while (it.hasNext()) {
            this.f6714b.add(it.next());
        }
        this.f6723l.clear();
    }
}
