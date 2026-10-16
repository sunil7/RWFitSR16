package com.autonavi.aps.amapapi.restruct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyManager$CellInfoCallback;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.qc;
import com.amap.location.support.bean.cell.AmapCell;
import com.amap.location.support.bean.cell.AmapCellCdma;
import com.amap.location.support.bean.cell.AmapCellGsm;
import com.amap.location.support.bean.cell.AmapCellLte;
import com.amap.location.support.bean.cell.AmapCellWcdma;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.aps.amapapi.ICollectionManager;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.Utils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class CgiManager {
    public static final String HAS_FINE_LOC_PERM = "hasFineLocPerm";
    public static final String HAS_NO_FINE_LOC_PERM = "hasNoFineLocPerm";
    public static final String HAS_NO_READ_PHONESTATE_PERM = "hasNoReadPhoneStatePerm";
    public static final String HAS_READ_PHONESTATE_PERM = "hasReadPhoneStatePerm";
    public static final int MASK_NEW_VERSION_INDICATOR = 4;
    public static final int MASK_OPERATOR_INDICATOR = 8;
    public static final int MASK_V1_CELL_TYPE = 3;

    /* renamed from: a, reason: collision with root package name */
    private Context f6674a;

    /* renamed from: g, reason: collision with root package name */
    TelephonyManager f6679g;

    /* renamed from: h, reason: collision with root package name */
    private CellAgeEstimator f6680h;

    /* renamed from: k, reason: collision with root package name */
    SignalStrength f6683k;

    /* renamed from: m, reason: collision with root package name */
    @SuppressLint({"NewApi"})
    private TelephonyManager$CellInfoCallback f6685m;

    /* renamed from: w, reason: collision with root package name */
    private ICollectionManager f6694w;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6675b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6676c = false;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<Cgi> f6677d = new ArrayList<>();
    private String e = null;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<Cgi> f6678f = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private long f6681i = 0;

    /* renamed from: j, reason: collision with root package name */
    PhoneStateListener f6682j = null;

    /* renamed from: l, reason: collision with root package name */
    private Object f6684l = new Object();

    /* renamed from: n, reason: collision with root package name */
    private boolean f6686n = false;

    /* renamed from: o, reason: collision with root package name */
    boolean f6687o = false;

    /* renamed from: p, reason: collision with root package name */
    StringBuilder f6688p = null;

    /* renamed from: q, reason: collision with root package name */
    private String f6689q = null;
    private String r = null;

    /* renamed from: s, reason: collision with root package name */
    String f6690s = null;

    /* renamed from: t, reason: collision with root package name */
    private volatile boolean f6691t = true;

    /* renamed from: u, reason: collision with root package name */
    private volatile boolean f6692u = true;

    /* renamed from: v, reason: collision with root package name */
    private volatile boolean f6693v = false;

    @SuppressLint({"NewApi"})
    public class CellInfoCallBack extends TelephonyManager$CellInfoCallback {
        public CellInfoCallBack() {
        }

        public void onCellInfo(List<CellInfo> list) {
            try {
                DebugUtils.writeCat("CgiManager", "CellInfoCallBack onCellInfo");
                DebugUtils.writeCat("CgiManager", "noLocReqCgiEnable:" + CgiManager.this.f6692u + " isStartLocation:" + CgiManager.this.f6691t);
                if ((CgiManager.this.f6692u || CgiManager.this.f6691t) && Utils.getTimeBoot() - CgiManager.this.f6681i >= 500) {
                    CgiManager.this.f6686n = true;
                    CgiManager.this.a(CgiManager.this.e());
                    CgiManager.this.a(list);
                    CgiManager.this.f6681i = Utils.getTimeBoot();
                }
            } catch (SecurityException e) {
                CgiManager.this.f6690s = e.getMessage();
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "Cgi", "cellInfo");
            }
        }
    }

    public class CgiPhoneListener extends PhoneStateListener {
        public CgiPhoneListener() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellInfoChanged(List<CellInfo> list) {
            try {
                DebugUtils.writeCat("CgiManager", "CgiPhoneListener onCellInfoChanged");
                DebugUtils.writeCat("CgiManager", "noLocReqCgiEnable:" + CgiManager.this.f6692u + " isStartLocation:" + CgiManager.this.f6691t);
                if (CgiManager.this.f6692u || CgiManager.this.f6691t) {
                    if (CgiManager.this.f6694w != null) {
                        CgiManager.this.f6694w.updateCell();
                    }
                    if (Utils.getTimeBoot() - CgiManager.this.f6681i < 500) {
                        return;
                    }
                    CgiManager.this.a(CgiManager.this.e());
                    CgiManager.this.a(list);
                    CgiManager.this.f6681i = Utils.getTimeBoot();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            DebugUtils.writeCat("CgiManager", "CgiPhoneListener onCellLocationChanged");
            DebugUtils.writeCat("CgiManager", "noLocReqCgiEnable:" + CgiManager.this.f6692u + " isStartLocation:" + CgiManager.this.f6691t);
            if ((CgiManager.this.f6692u || CgiManager.this.f6691t) && Utils.getTimeBoot() - CgiManager.this.f6681i >= 500) {
                try {
                    CgiManager.this.a(cellLocation);
                    CgiManager.this.a(CgiManager.this.d());
                    CgiManager.this.f6681i = Utils.getTimeBoot();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i3) {
            super.onDataConnectionStateChanged(i3);
            DebugUtils.writeCat("CgiManager", "CgiPhoneListener onDataConnectionStateChanged");
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            try {
                DebugUtils.writeCat("CgiManager", "CgiPhoneListener onServiceStateChanged");
                DebugUtils.writeCat("CgiManager", "noLocReqCgiEnable:" + CgiManager.this.f6692u + " isStartLocation:" + CgiManager.this.f6691t);
                if (CgiManager.this.f6692u || CgiManager.this.f6691t) {
                    int state = serviceState.getState();
                    if (state == 0) {
                        CgiManager.this.updateCgi(false, false);
                    } else {
                        if (state != 1) {
                            return;
                        }
                        CgiManager.this.h();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthChanged(int i3) {
            super.onSignalStrengthChanged(i3);
            DebugUtils.writeCat("CgiManager", "CgiPhoneListener onSignalStrengthChanged");
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            DebugUtils.writeCat("CgiManager", "CgiPhoneListener onSignalStrengthsChanged");
            DebugUtils.writeCat("CgiManager", "noLocReqCgiEnable:" + CgiManager.this.f6692u + " isStartLocation:" + CgiManager.this.f6691t);
            if (signalStrength == null) {
                return;
            }
            CgiManager cgiManager = CgiManager.this;
            cgiManager.f6683k = signalStrength;
            if (cgiManager.f6692u || CgiManager.this.f6691t) {
                try {
                    if (CgiManager.this.f6694w != null) {
                        CgiManager.this.f6694w.updateCell();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public CgiManager(Context context, Handler handler) {
        this.f6679g = null;
        this.f6680h = null;
        DebugUtils.writeCat("CgiManager", "==================CgiManager Constructor===================");
        this.f6674a = context;
        if (this.f6679g == null) {
            this.f6679g = (TelephonyManager) Utils.getServ(context, "phone");
        }
        f();
        CellAgeEstimator cellAgeEstimator = new CellAgeEstimator(context, "cellAge", handler);
        this.f6680h = cellAgeEstimator;
        cellAgeEstimator.start();
    }

    private void g() {
        try {
            if (this.f6682j == null) {
                this.f6682j = new CgiPhoneListener();
            }
            int i3 = Build.VERSION.SDK_INT;
            String str = HAS_NO_FINE_LOC_PERM;
            int i10 = 336;
            if (i3 < 31) {
                DebugUtils.writeCat("CgiManager | event LCL SUC2", false);
            } else if (this.f6674a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                this.r = HAS_FINE_LOC_PERM;
                DebugUtils.writeCat("CgiManager | event LCL SUC1", false);
            } else {
                this.r = HAS_NO_FINE_LOC_PERM;
                DebugUtils.writeCat("CgiManager | LCL: NO FINE Loc Perm，failed", false);
                i10 = GlMapUtil.DEVICE_DISPLAY_DPI_HIGH;
            }
            if (i3 >= 31) {
                boolean z5 = this.f6674a.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
                boolean z6 = this.f6674a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
                if (z5 && z6) {
                    i10 |= 1024;
                    DebugUtils.writeCat("CgiManager | event LCI SUC3", false);
                } else {
                    DebugUtils.writeCat("CgiManager | LCI: NO rps Perm or NO fl Perm，failed", false);
                }
                this.f6689q = z5 ? HAS_READ_PHONESTATE_PERM : HAS_NO_READ_PHONESTATE_PERM;
                if (z6) {
                    str = HAS_FINE_LOC_PERM;
                }
                this.r = str;
                DebugUtils.writeCat("CgiManager | mLFLPerm = " + this.r + ";mLRPSPerm = " + this.f6689q, false);
            } else {
                DebugUtils.writeCat("CgiManager | event LCI SUC4", false);
                i10 |= 1024;
            }
            PhoneStateListener phoneStateListener = this.f6682j;
            if (phoneStateListener != null) {
                this.f6679g.listen(phoneStateListener, i10);
                this.f6693v = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidCgiFlag(int i3) {
        return i3 >= 1 && i3 <= 15;
    }

    public void destroy(boolean z5) {
        this.f6680h.destroy(z5);
        this.f6681i = 0L;
        synchronized (this.f6684l) {
        }
        b();
        this.f6683k = null;
        this.f6679g = null;
    }

    public List<AmapCell> getAmapCells() {
        ArrayList arrayList = new ArrayList();
        List<CellInfo> c9 = c();
        if (c9 != null) {
            for (CellInfo cellInfo : c9) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    AmapCellCdma amapCellCdma = new AmapCellCdma(cellInfo.isRegistered(), true);
                    amapCellCdma.latitude = cellIdentity.getLatitude();
                    amapCellCdma.longitude = cellIdentity.getLongitude();
                    amapCellCdma.sid = cellIdentity.getSystemId();
                    amapCellCdma.nid = cellIdentity.getNetworkId();
                    amapCellCdma.bid = cellIdentity.getBasestationId();
                    amapCellCdma.asuLevel = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    amapCellCdma.signalStrength = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    arrayList.add(amapCellCdma);
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    AmapCellGsm amapCellGsm = new AmapCellGsm(cellInfo.isRegistered(), true);
                    amapCellGsm.mcc = String.valueOf(cellIdentity2.getMcc());
                    amapCellGsm.mnc = String.valueOf(cellIdentity2.getMnc());
                    amapCellGsm.lac = cellIdentity2.getLac();
                    amapCellGsm.cid = cellIdentity2.getCid();
                    amapCellGsm.signalStrength = cellInfoGsm.getCellSignalStrength().getDbm();
                    amapCellGsm.asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    amapCellGsm.arfcn = cellIdentity2.getArfcn();
                    amapCellGsm.bsic = cellIdentity2.getBsic();
                    arrayList.add(amapCellGsm);
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    AmapCellLte amapCellLte = new AmapCellLte(cellInfo.isRegistered());
                    amapCellLte.mcc = String.valueOf(cellIdentity3.getMcc());
                    amapCellLte.mnc = String.valueOf(cellIdentity3.getMnc());
                    amapCellLte.pci = cellIdentity3.getPci();
                    amapCellLte.asuLevel = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    amapCellLte.f6569ci = cellIdentity3.getCi();
                    amapCellLte.tac = cellIdentity3.getTac();
                    amapCellLte.timingAdvance = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    amapCellLte.signalStrength = cellInfoLte.getCellSignalStrength().getDbm();
                    amapCellLte.earfcn = cellIdentity3.getEarfcn();
                    arrayList.add(amapCellLte);
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                    AmapCellWcdma amapCellWcdma = new AmapCellWcdma(cellInfo.isRegistered(), true);
                    amapCellWcdma.mcc = String.valueOf(cellIdentity4.getMcc());
                    amapCellWcdma.mnc = String.valueOf(cellIdentity4.getMnc());
                    amapCellWcdma.lac = cellIdentity4.getLac();
                    amapCellWcdma.cid = cellIdentity4.getCid();
                    amapCellWcdma.psc = cellIdentity4.getPsc();
                    amapCellWcdma.asuLevel = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                    amapCellWcdma.signalStrength = cellInfoWcdma.getCellSignalStrength().getDbm();
                    amapCellWcdma.uarfcn = cellIdentity4.getUarfcn();
                    arrayList.add(amapCellWcdma);
                }
            }
        }
        return arrayList;
    }

    public int getCgiFlag() {
        return getMainCgiType() | (this.f6675b ? 4 : 0) | (this.f6676c ? 8 : 0);
    }

    public synchronized String getCgiParam() {
        try {
            if (this.f6687o) {
                h();
            }
            StringBuilder sb2 = this.f6688p;
            if (sb2 == null) {
                this.f6688p = new StringBuilder();
            } else {
                sb2.delete(0, sb2.length());
            }
            if (getMainCgiTypeMasked() == 1) {
                for (int i3 = 1; i3 < this.f6677d.size(); i3++) {
                    StringBuilder sb3 = this.f6688p;
                    sb3.append(Const.STR_MART_WELL);
                    sb3.append(this.f6677d.get(i3).mnc);
                    StringBuilder sb4 = this.f6688p;
                    sb4.append("|");
                    sb4.append(this.f6677d.get(i3).lac);
                    StringBuilder sb5 = this.f6688p;
                    sb5.append("|");
                    sb5.append(this.f6677d.get(i3).cid);
                }
            }
            for (int i10 = 1; i10 < this.f6678f.size(); i10++) {
                Cgi cgi = this.f6678f.get(i10);
                int i11 = cgi.type;
                if (i11 != 1 && i11 != 3 && i11 != 4 && i11 != 5) {
                    if (i11 == 2) {
                        StringBuilder sb6 = this.f6688p;
                        sb6.append(Const.STR_MART_WELL);
                        sb6.append(cgi.type);
                        StringBuilder sb7 = this.f6688p;
                        sb7.append("|");
                        sb7.append(cgi.mcc);
                        StringBuilder sb8 = this.f6688p;
                        sb8.append("|");
                        sb8.append(cgi.sid);
                        StringBuilder sb9 = this.f6688p;
                        sb9.append("|");
                        sb9.append(cgi.nid);
                        StringBuilder sb10 = this.f6688p;
                        sb10.append("|");
                        sb10.append(cgi.bid);
                    }
                }
                StringBuilder sb11 = this.f6688p;
                sb11.append(Const.STR_MART_WELL);
                sb11.append(cgi.type);
                StringBuilder sb12 = this.f6688p;
                sb12.append("|");
                sb12.append(cgi.mcc);
                StringBuilder sb13 = this.f6688p;
                sb13.append("|");
                sb13.append(cgi.mnc);
                StringBuilder sb14 = this.f6688p;
                sb14.append("|");
                sb14.append(cgi.lac);
                StringBuilder sb15 = this.f6688p;
                sb15.append("|");
                sb15.append(cgi.getCid());
            }
            if (this.f6688p.length() > 0) {
                this.f6688p.deleteCharAt(0);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f6688p.toString();
    }

    public synchronized ArrayList<Cgi> getDetectedCgiList() {
        ArrayList<Cgi> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<Cgi> arrayList2 = this.f6677d;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Cgi cgi = arrayList2.get(i3);
                i3++;
                arrayList.add(cgi.m44clone());
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<Cgi> getDetectedCgiV2List() {
        ArrayList<Cgi> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<Cgi> arrayList2 = this.f6678f;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Cgi cgi = arrayList2.get(i3);
                i3++;
                arrayList.add(cgi.m44clone());
            }
        }
        return arrayList;
    }

    public synchronized Cgi getMainCgi() {
        if (this.f6687o) {
            return null;
        }
        ArrayList<Cgi> arrayList = this.f6677d;
        if (arrayList.size() < 1) {
            return null;
        }
        return arrayList.get(0).m44clone();
    }

    public int getMainCgiType() {
        Cgi mainCgi = getMainCgi();
        if (mainCgi != null) {
            return mainCgi.type;
        }
        return 0;
    }

    public int getMainCgiTypeMasked() {
        return getMainCgiType() & 3;
    }

    public synchronized Cgi getMainCgiV2() {
        if (this.f6687o) {
            return null;
        }
        ArrayList<Cgi> arrayList = this.f6678f;
        if (arrayList.size() < 1) {
            return null;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Cgi cgi = arrayList.get(i3);
            i3++;
            Cgi cgi2 = cgi;
            if (cgi2.isMain) {
                return cgi2.m44clone();
            }
        }
        return arrayList.get(0).m44clone();
    }

    public String getRawOperatorStr() {
        return this.e;
    }

    public String getSecurityException() {
        return this.f6690s;
    }

    public TelephonyManager getTelephonyManagerInstance() {
        return this.f6679g;
    }

    public synchronized void h() {
        this.f6690s = null;
        this.f6677d.clear();
        this.f6678f.clear();
        this.f6675b = false;
        this.f6676c = false;
    }

    public boolean isSimValid() {
        try {
            TelephonyManager telephonyManager = this.f6679g;
            if (telephonyManager != null) {
                if (!TextUtils.isEmpty(telephonyManager.getSimOperator())) {
                    return true;
                }
                if (!TextUtils.isEmpty(this.f6679g.getSimCountryIso())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            int netT = Utils.getNetT(Utils.getNetWorkInfo(this.f6674a));
            return netT == 0 || netT == 4 || netT == 2 || netT == 5 || netT == 3;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public void notifyLocationStatus(boolean z5) {
        this.f6691t = z5;
        if (this.f6692u) {
            return;
        }
        if (z5 && !this.f6693v) {
            g();
        } else {
            if (z5 || !this.f6693v) {
                return;
            }
            b();
        }
    }

    public void reInitIfNeed() {
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                String str = this.f6674a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 ? HAS_FINE_LOC_PERM : HAS_NO_FINE_LOC_PERM;
                String str2 = this.f6674a.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0 ? HAS_READ_PHONESTATE_PERM : HAS_NO_READ_PHONESTATE_PERM;
                boolean z5 = true;
                boolean z6 = (TextUtils.isEmpty(this.r) || this.r.equals(str)) ? false : true;
                if (TextUtils.isEmpty(this.f6689q) || this.f6689q.equals(str2)) {
                    z5 = z6;
                }
                if (z5) {
                    DebugUtils.writeCat("CgiManager | reInitPSL", false);
                    g();
                }
            }
        } catch (Throwable unused) {
            DebugUtils.writeCat("CgiManager | reInit e", false);
        }
    }

    public void setCollectionManager(ICollectionManager iCollectionManager) {
        this.f6694w = iCollectionManager;
    }

    public void setNoLocReqCgiEnable(boolean z5) {
        this.f6692u = z5;
    }

    public void updateCgi(boolean z5, boolean z6) {
        try {
            this.f6687o = Utils.airPlaneModeOn(this.f6674a);
            if (a()) {
                a(z5, z6);
                a(e());
                a(d());
            }
            if (this.f6687o) {
                h();
            }
        } catch (SecurityException e) {
            this.f6690s = e.getMessage();
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "CgiManager", "refresh");
        }
    }

    private void b() {
        PhoneStateListener phoneStateListener;
        TelephonyManager telephonyManager = this.f6679g;
        if (telephonyManager != null && (phoneStateListener = this.f6682j) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
                this.f6693v = false;
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "CgiManager", "destroy");
            }
        }
        this.f6682j = null;
    }

    private List<CellInfo> c() {
        TelephonyManager telephonyManager = this.f6679g;
        if (telephonyManager == null) {
            return null;
        }
        List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
        DebugUtils.writeCat("CgiManager", "getAllCellInfo");
        return allCellInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public List<CellInfo> d() {
        List<CellInfo> list;
        try {
            if (Utils.getSdk() < 18 || this.f6679g == null) {
                return null;
            }
            try {
                list = c();
                try {
                    this.f6690s = null;
                    return list;
                } catch (SecurityException e) {
                    e = e;
                    this.f6690s = e.getMessage();
                    return list;
                }
            } catch (SecurityException e10) {
                e = e10;
                list = null;
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Cgi", "getNewCells");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellLocation e() {
        TelephonyManager telephonyManager = this.f6679g;
        if (telephonyManager == null) {
            return null;
        }
        try {
            CellLocation cellLocation = telephonyManager.getCellLocation();
            DebugUtils.writeCat("CgiManager", "getCellLocation");
            this.f6690s = null;
            return cellLocation;
        } catch (SecurityException e) {
            this.f6690s = e.getMessage();
            return null;
        } catch (Throwable th2) {
            this.f6690s = null;
            CoreUtil.reportError(th2, "CgiManager", "getCellLocation");
            return null;
        }
    }

    private void f() {
        if (this.f6679g == null) {
            return;
        }
        g();
    }

    public boolean a() {
        return !this.f6687o && Utils.getTimeBoot() - this.f6681i >= Const.L_MIN_CGI_REFRESH;
    }

    @SuppressLint({"NewApi"})
    private void a(boolean z5, boolean z6) {
        if (!this.f6687o && this.f6679g != null && Build.VERSION.SDK_INT >= 29 && this.f6674a.getApplicationInfo().targetSdkVersion >= 29) {
            if (this.f6685m == null) {
                this.f6685m = new CellInfoCallBack();
            }
            try {
                this.f6679g.requestCellInfoUpdate(qc.d().b(), this.f6685m);
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "Cgi", "refreshCgi");
            }
            if (z6 || z5) {
                for (int i3 = 0; !this.f6686n && i3 < 20; i3++) {
                    try {
                        Thread.sleep(5L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        this.f6676c = false;
        TelephonyManager telephonyManager = this.f6679g;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.e = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.f6676c = true;
            }
        }
        this.f6681i = Utils.getTimeBoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(CellLocation cellLocation) {
        try {
            String[] mccMnc = Utils.getMccMnc(this.f6679g);
            this.f6677d.clear();
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                Cgi cgi = new Cgi(1, true);
                cgi.mcc = Utils.parseInt(mccMnc[0]);
                cgi.mnc = Utils.parseInt(mccMnc[1]);
                cgi.lac = gsmCellLocation.getLac();
                cgi.cid = gsmCellLocation.getCid();
                SignalStrength signalStrength = this.f6683k;
                if (signalStrength != null) {
                    int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                    cgi.signalStrength = gsmSignalStrength == 99 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : (gsmSignalStrength * 2) + Const.I_DEF_CGI_SIG;
                }
                cgi.newApi = false;
                this.f6680h.update((CellAgeEstimator) cgi);
                this.f6677d.add(cgi);
            } else if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                Cgi cgi2 = new Cgi(2, true);
                cgi2.mcc = Integer.parseInt(mccMnc[0]);
                cgi2.mnc = Integer.parseInt(mccMnc[1]);
                cgi2.lat = cdmaCellLocation.getBaseStationLatitude();
                cgi2.lon = cdmaCellLocation.getBaseStationLongitude();
                cgi2.sid = cdmaCellLocation.getSystemId();
                cgi2.nid = cdmaCellLocation.getNetworkId();
                cgi2.bid = cdmaCellLocation.getBaseStationId();
                SignalStrength signalStrength2 = this.f6683k;
                if (signalStrength2 != null) {
                    cgi2.signalStrength = signalStrength2.getCdmaDbm();
                }
                cgi2.newApi = false;
                this.f6680h.update((CellAgeEstimator) cgi2);
                this.f6677d.add(cgi2);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x025e A[Catch: all -> 0x000d, TryCatch #5 {all -> 0x000d, blocks: (B:4:0x0005, B:6:0x0009, B:8:0x0012, B:12:0x001c, B:14:0x0023, B:18:0x027f, B:19:0x002e, B:30:0x025e, B:74:0x022c, B:76:0x023a, B:77:0x0246, B:79:0x023f, B:80:0x0244, B:64:0x0298, B:111:0x0284, B:113:0x028b, B:115:0x0291), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x027f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x023a A[Catch: all -> 0x000d, TryCatch #5 {all -> 0x000d, blocks: (B:4:0x0005, B:6:0x0009, B:8:0x0012, B:12:0x001c, B:14:0x0023, B:18:0x027f, B:19:0x002e, B:30:0x025e, B:74:0x022c, B:76:0x023a, B:77:0x0246, B:79:0x023f, B:80:0x0244, B:64:0x0298, B:111:0x0284, B:113:0x028b, B:115:0x0291), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x023d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(java.util.List<android.telephony.CellInfo> r21) {
        /*
            Method dump skipped, instructions count: 666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.restruct.CgiManager.a(java.util.List):void");
    }

    public Cgi a(int i3, boolean z5, int i10, int i11, int i12, int i13, int i14) {
        Cgi cgi = new Cgi(i3, z5);
        cgi.mcc = i10;
        cgi.mnc = i11;
        cgi.lac = i12;
        cgi.cid = i13;
        cgi.sig = i14;
        return cgi;
    }
}
