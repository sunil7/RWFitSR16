package com.autonavi.aps.amapapi;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.amap.api.col.p0003sl.b9;
import com.amap.api.col.p0003sl.f9;
import com.amap.api.col.p0003sl.fb;
import com.amap.api.col.p0003sl.h9;
import com.amap.api.col.p0003sl.ha;
import com.amap.api.col.p0003sl.ib;
import com.amap.api.col.p0003sl.ka;
import com.amap.api.col.p0003sl.kc;
import com.amap.api.col.p0003sl.mc;
import com.amap.api.col.p0003sl.n9;
import com.amap.api.col.p0003sl.qb;
import com.amap.api.col.p0003sl.qc;
import com.amap.api.col.p0003sl.rc;
import com.amap.api.col.p0003sl.ub;
import com.amap.api.col.p0003sl.vb;
import com.amap.api.col.p0003sl.ya;
import com.amap.location.support.bean.cell.AmapCell;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.restruct.CgiManager;
import com.autonavi.aps.amapapi.restruct.SystemApiWrapper;
import com.autonavi.aps.amapapi.restruct.WifiManagerWrapper;
import com.autonavi.aps.amapapi.security.Encrypt;
import com.autonavi.aps.amapapi.trans.HttpRequest;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.Utils;
import com.google.android.gms.internal.mlkit_vision_barcode.de;
import g3.f;
import h3.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.KeyGenerator;
import m3.b;
import m3.c;
import m3.d;

/* loaded from: classes.dex */
public class CollectionManager implements ICollectionManager, d {

    /* renamed from: k, reason: collision with root package name */
    private static long f6609k;

    /* renamed from: a, reason: collision with root package name */
    Context f6610a;

    /* renamed from: c, reason: collision with root package name */
    private Handler f6612c;

    /* renamed from: f, reason: collision with root package name */
    a f6614f;

    /* renamed from: g, reason: collision with root package name */
    private LocationManager f6615g;

    /* renamed from: h, reason: collision with root package name */
    private CollectionLocationListener f6616h;

    /* renamed from: i, reason: collision with root package name */
    ub f6617i;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<e3.a> f6611b = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    WifiManagerWrapper f6613d = null;
    CgiManager e = null;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f6618j = false;

    public static class CollectionLocationListener implements LocationListener {

        /* renamed from: a, reason: collision with root package name */
        private CollectionManager f6620a;

        public CollectionLocationListener(CollectionManager collectionManager) {
            this.f6620a = collectionManager;
        }

        public void a(CollectionManager collectionManager) {
            this.f6620a = collectionManager;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                CollectionManager collectionManager = this.f6620a;
                if (collectionManager != null) {
                    collectionManager.onLocationChanged(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i3, Bundle bundle) {
        }

        public void a() {
            this.f6620a = null;
        }
    }

    public CollectionManager(Context context) {
        this.f6610a = null;
        this.f6610a = context;
        ub ubVar = new ub();
        this.f6617i = ubVar;
        int i3 = ha.f4272c;
        vb.a(context, ubVar, "k", 100, 1024000, "0");
        ub ubVar2 = this.f6617i;
        int i10 = AuthUtil.mCarrierInterVal;
        boolean z5 = AuthUtil.mCarrierMobileUpdate;
        int i11 = AuthUtil.maxUpdate;
        ubVar2.f5154f = new mc(context, i10, "kKey", new kc(context, z5, i11, i11 * 10, "carrierLocKey"));
        this.f6617i.e = new ya();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:18|(3:19|20|21)|(2:22|23)|(0)(9:32|33|(1:(1:36))(2:41|(9:45|(8:49|50|51|52|53|54|46|47)|67|68|69|70|71|72|73)(0))|37|38|27|28|30|17)|26|27|28|30|17) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        if (r9 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e0, code lost:
    
        if (r5 > r19.f5154f.a()) goto L97;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0111 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List a(com.autonavi.aps.amapapi.CollectionManager r17, com.amap.api.col.p0003sl.fb r18, com.amap.api.col.p0003sl.ub r19, java.util.List r20, byte[] r21) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.CollectionManager.a(com.autonavi.aps.amapapi.CollectionManager, com.amap.api.col.3sl.fb, com.amap.api.col.3sl.ub, java.util.List, byte[]):java.util.List");
    }

    public static int byteArrayToInt(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }

    public static byte[] get2BytesFromInt(int i3) {
        return new byte[]{(byte) ((i3 & 65280) >> 8), (byte) (i3 & 255)};
    }

    public void cancelRequest(m3.a aVar) {
    }

    @Override // com.autonavi.aps.amapapi.ICollectionManager
    public void destroyColl() {
    }

    public b get(m3.a aVar) {
        return null;
    }

    public byte[] intToBytes(int i3) {
        return new byte[]{(byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)};
    }

    public void onLocationChanged(Location location) {
        try {
            Handler handler = this.f6612c;
            if (handler != null) {
                handler.post(new CollettionRunner(this, 1, location));
            }
        } catch (Throwable th2) {
            ka.a(th2, Const.SP_KEY_CONTINUE_LOCATION, "olcc");
        }
    }

    public void post(m3.a aVar, c cVar) {
    }

    @Override // com.autonavi.aps.amapapi.ICollectionManager
    public void startColl(CgiManager cgiManager, WifiManagerWrapper wifiManagerWrapper, Handler handler) {
        LocationManager locationManager;
        DebugUtils.writeCat("Cl | dl -- sc");
        if (this.f6618j || cgiManager == null || wifiManagerWrapper == null || handler == null) {
            return;
        }
        if (Utils.isCoarsePermOpen(this.f6610a)) {
            DebugUtils.writeCat("Cl | dl -- c_perm_sc");
            return;
        }
        this.f6618j = true;
        this.e = cgiManager;
        this.f6613d = wifiManagerWrapper;
        wifiManagerWrapper.setCollectionManager(this);
        this.e.setCollectionManager(this);
        this.f6612c = handler;
        try {
            if (this.f6615g == null) {
                this.f6615g = (LocationManager) this.f6610a.getSystemService("location");
            }
            if (this.f6616h == null) {
                this.f6616h = new CollectionLocationListener(this);
            }
            this.f6616h.a(this);
            CollectionLocationListener collectionLocationListener = this.f6616h;
            if (collectionLocationListener != null && (locationManager = this.f6615g) != null) {
                locationManager.requestLocationUpdates("passive", 1000L, -1.0f, collectionLocationListener);
            }
            if (this.f6614f == null) {
                String e = b9.e(this.f6610a);
                String f2 = b9.f(this.f6610a);
                a aVar = new a();
                de.f9264a = (byte) 4;
                if (f2 != null) {
                    de.e = f2;
                }
                String.valueOf(74);
                de.f9265b = CoreUtil.STR_CONFIG_VERSION;
                if (e != null) {
                    de.f9267d = e;
                }
                de.f9266c = CoreUtil.AMAP_LICENSE;
                com.google.android.gms.internal.mlkit_vision_barcode.mc.f9435a = this;
                this.f6614f = aVar;
                String b3 = f9.b();
                if (b3 != null) {
                    de.f9268f = b3;
                }
                String t8 = f9.t(this.f6610a);
                if (t8 != null) {
                    de.f9269g = t8;
                }
                String f10 = f9.f(this.f6610a);
                if (f10 != null) {
                    de.f9270h = f10;
                }
                f9.q(this.f6610a);
                String str = Build.MODEL;
                if (str != null) {
                    de.f9271i = str;
                }
                String str2 = Build.MANUFACTURER;
                if (str2 != null) {
                    de.f9272j = str2;
                }
                String str3 = Build.BRAND;
                de.f9273k = Build.VERSION.SDK_INT;
                String str4 = Build.VERSION.RELEASE;
                k3.a.b(f9.c());
                String c9 = f9.c();
                if (c9 != null) {
                    de.f9274l = c9;
                }
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "col", "init");
        }
    }

    @Override // com.autonavi.aps.amapapi.ICollectionManager
    public void stopColl() {
        LocationManager locationManager;
        if (Utils.isCoarsePermOpen(this.f6610a)) {
            DebugUtils.writeCat("Cl | dl -- c_perm_spc");
            return;
        }
        try {
            CollectionLocationListener collectionLocationListener = this.f6616h;
            if (collectionLocationListener != null && (locationManager = this.f6615g) != null) {
                locationManager.removeUpdates(collectionLocationListener);
            }
            CollectionLocationListener collectionLocationListener2 = this.f6616h;
            if (collectionLocationListener2 != null) {
                collectionLocationListener2.a();
            }
            if (this.f6618j) {
                a();
                this.f6613d.setCollectionManager(null);
                this.e.setCollectionManager(null);
                this.e = null;
                this.f6613d = null;
                this.f6612c = null;
                this.f6618j = false;
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "clm", "stc");
        }
    }

    @Override // com.autonavi.aps.amapapi.ICollectionManager
    public void updateCell() {
        CgiManager cgiManager;
        try {
            DebugUtils.writeCat("Cl | dl -- uc");
            if (this.f6614f == null || (cgiManager = this.e) == null) {
                return;
            }
            f.c(cgiManager.getAmapCells());
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, Const.SP_KEY_CONTINUE_LOCATION, "upc");
        }
    }

    @Override // com.autonavi.aps.amapapi.ICollectionManager
    public void updateToServer() {
        try {
            if (Utils.isCoarsePermOpen(this.f6610a)) {
                DebugUtils.writeCat("Cl | dl -- c_perm_uts");
            } else {
                if (System.currentTimeMillis() - f6609k < 60000) {
                    return;
                }
                qc.d().b(new CollettionRunner(2));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.aps.amapapi.ICollectionManager
    public void updateWiFi() {
        try {
            DebugUtils.writeCat("Cl | dl -- uwf");
            Handler handler = this.f6612c;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.autonavi.aps.amapapi.CollectionManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WifiManagerWrapper wifiManagerWrapper;
                        try {
                            CollectionManager collectionManager = CollectionManager.this;
                            if (collectionManager.f6614f == null || (wifiManagerWrapper = collectionManager.f6613d) == null) {
                                return;
                            }
                            a.e(wifiManagerWrapper.getAmapWifis());
                        } catch (Throwable th2) {
                            CoreUtil.reportError(th2, Const.SP_KEY_CONTINUE_LOCATION, "upwr");
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, Const.SP_KEY_CONTINUE_LOCATION, "upw");
        }
    }

    public void writeCache() {
        try {
            qc.d().b(new CollettionRunner(3));
        } catch (Throwable unused) {
        }
    }

    public class CollettionRunner extends rc {

        /* renamed from: a, reason: collision with root package name */
        private int f6621a;

        /* renamed from: b, reason: collision with root package name */
        private Location f6622b;

        public CollettionRunner(int i3) {
            this.f6621a = i3;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public void runTask() {
            int i3 = this.f6621a;
            if (i3 == 1) {
                try {
                    DebugUtils.writeCat("Cl | dl -- dc");
                    if (this.f6622b != null && CollectionManager.this.f6618j) {
                        if (Utils.isCoarsePermOpen(CollectionManager.this.f6610a)) {
                            DebugUtils.writeCat("Cl | dl -- c_perm_dc");
                            return;
                        }
                        Bundle extras = this.f6622b.getExtras();
                        r1 = extras != null ? extras.getInt("satellites") : 0;
                        if (Utils.isGpsMock(this.f6622b, r1)) {
                            return;
                        }
                        WifiManagerWrapper wifiManagerWrapper = CollectionManager.this.f6613d;
                        if (wifiManagerWrapper != null && !wifiManagerWrapper.mISStartCollect) {
                            wifiManagerWrapper.onCollectLocation();
                        }
                        ArrayList<k3.a> amapWifis = CollectionManager.this.f6613d.getAmapWifis();
                        List<AmapCell> amapCells = CollectionManager.this.e.getAmapCells();
                        d3.b bVar = new d3.b();
                        j3.a aVar = new j3.a();
                        aVar.f15322g = this.f6622b.getAccuracy();
                        aVar.f15320d = this.f6622b.getAltitude();
                        aVar.f15318b = this.f6622b.getLatitude();
                        aVar.f15321f = this.f6622b.getBearing();
                        aVar.f15319c = this.f6622b.getLongitude();
                        this.f6622b.isFromMockProvider();
                        this.f6622b.getProvider();
                        aVar.e = this.f6622b.getSpeed();
                        aVar.f15324i = (byte) r1;
                        System.currentTimeMillis();
                        aVar.f15317a = this.f6622b.getTime();
                        aVar.f15323h = this.f6622b.getTime();
                        bVar.f12224a = aVar;
                        bVar.f12225b = amapWifis;
                        WifiInfo connectionInfo = CollectionManager.this.f6613d.getConnectionInfo();
                        if (connectionInfo != null) {
                            bVar.f12226c = k3.a.b(SystemApiWrapper.getBSSID(connectionInfo));
                        }
                        WifiManagerWrapper wifiManagerWrapper2 = CollectionManager.this.f6613d;
                        bVar.f12227d = WifiManagerWrapper.lLastCarrierWifiChange;
                        bVar.f12228f = this.f6622b.getTime();
                        bVar.f12229g = (byte) f9.o(CollectionManager.this.f6610a);
                        bVar.f12230h = f9.m(CollectionManager.this.f6610a);
                        bVar.e = CollectionManager.this.f6613d.isWifiEnabled();
                        bVar.f12232j = Utils.airPlaneModeOn(CollectionManager.this.f6610a);
                        bVar.f12231i = amapCells;
                        CollectionManager.this.f6614f.getClass();
                        e3.a a3 = a.a(bVar);
                        if (a3 == null) {
                            return;
                        }
                        synchronized (CollectionManager.this.f6611b) {
                            try {
                                CollectionManager.this.f6611b.add(a3);
                                if (CollectionManager.this.f6611b.size() >= 5) {
                                    CollectionManager.this.writeCache();
                                }
                            } finally {
                            }
                        }
                        CollectionManager.this.updateToServer();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    CoreUtil.reportError(th2, Const.SP_KEY_CONTINUE_LOCATION, "coll");
                    return;
                }
            }
            if (i3 != 2) {
                if (i3 == 3) {
                    CollectionManager.this.a();
                    return;
                }
                return;
            }
            DebugUtils.writeCat("Cl | dl -- duts");
            if (Utils.isCoarsePermOpen(CollectionManager.this.f6610a)) {
                DebugUtils.writeCat("Cl | dl -- c_perm_duts");
                return;
            }
            fb fbVar = null;
            try {
                long unused = CollectionManager.f6609k = System.currentTimeMillis();
            } catch (Throwable th3) {
                try {
                    ka.a(th3, "leg", "uts");
                    if (fbVar == null) {
                        return;
                    }
                } catch (Throwable th4) {
                    if (fbVar != null) {
                        try {
                            fbVar.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th4;
                }
            }
            try {
                if (CollectionManager.this.f6617i.f5154f.b()) {
                    fbVar = fb.a(new File(CollectionManager.this.f6617i.f5150a), 1, 1, CollectionManager.this.f6617i.f5151b);
                    ArrayList arrayList = new ArrayList();
                    byte[] a10 = CollectionManager.this.a(128);
                    if (a10 != null) {
                        CollectionManager collectionManager = CollectionManager.this;
                        List a11 = CollectionManager.a(collectionManager, fbVar, collectionManager.f6617i, arrayList, a10);
                        if (((ArrayList) a11).size() != 0) {
                            CollectionManager.this.f6617i.f5154f.a(true);
                            CollectionManager.this.f6614f.getClass();
                            byte[] c9 = h9.c(a10, a.b(), n9.c());
                            byte[] rsaEncryptCarrier = Encrypt.rsaEncryptCarrier(a10);
                            CollectionManager.this.f6614f.getClass();
                            byte[] f2 = n9.f(a.c(rsaEncryptCarrier, c9, a11));
                            CollectionManager.this.f6614f.getClass();
                            if (a.d(f2)) {
                                CollectionManager.this.getClass();
                                try {
                                    int size = arrayList.size();
                                    while (r1 < size) {
                                        Object obj = arrayList.get(r1);
                                        r1++;
                                        fbVar.d((String) obj);
                                    }
                                    fbVar.close();
                                } catch (Throwable th5) {
                                    ka.a(th5, "aps", "dlo");
                                }
                            }
                        }
                    }
                    fbVar.close();
                    return;
                }
                fbVar.close();
                return;
            } catch (Throwable unused3) {
                return;
            }
            if (fbVar == null) {
            }
        }

        public CollettionRunner(CollectionManager collectionManager, int i3, Location location) {
            this(i3);
            this.f6622b = location;
        }
    }

    public void get(m3.a aVar, c cVar) {
    }

    @Override // m3.d
    public b post(m3.a aVar) {
        try {
            HttpRequest httpRequest = new HttpRequest();
            httpRequest.setHead(aVar.f15942b);
            httpRequest.setUrl(aVar.f15941a);
            httpRequest.setEntity(aVar.f15943c);
            qb a3 = ib.a().a(httpRequest);
            b bVar = new b();
            bVar.f15945b = a3.f4927a;
            bVar.f15944a = 200;
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            DebugUtils.writeCat("Cl | dl -- wtd");
            if (Utils.isCoarsePermOpen(this.f6610a)) {
                DebugUtils.writeCat("Cl | dl -- c_perm_wtd");
                return;
            }
            ArrayList<e3.a> arrayList = this.f6611b;
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList arrayList2 = new ArrayList();
                synchronized (this.f6611b) {
                    arrayList2.addAll(this.f6611b);
                    this.f6611b.clear();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] a3 = a(256);
                if (a3 == null) {
                    return;
                }
                byteArrayOutputStream.write(get2BytesFromInt(a3.length));
                byteArrayOutputStream.write(a3);
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    e3.a aVar = (e3.a) obj;
                    byte[] bArr = aVar.f12446b;
                    int length = bArr.length;
                    if (bArr.length >= 10 && bArr.length <= 65535) {
                        byte[] c9 = h9.c(a3, bArr, n9.c());
                        byteArrayOutputStream.write(get2BytesFromInt(c9.length));
                        byteArrayOutputStream.write(c9);
                        byteArrayOutputStream.write(intToBytes(aVar.f12445a));
                    }
                }
                vb.a(Long.toString(System.currentTimeMillis()), byteArrayOutputStream.toByteArray(), this.f6617i);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "clm", "wtD");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(int i3) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            if (keyGenerator == null) {
                return null;
            }
            keyGenerator.init(i3);
            return keyGenerator.generateKey().getEncoded();
        } catch (Throwable unused) {
            return null;
        }
    }
}
