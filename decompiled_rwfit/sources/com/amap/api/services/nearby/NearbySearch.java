package com.amap.api.services.nearby;

import android.content.Context;
import com.amap.api.col.p0003sl.d6;
import com.amap.api.col.p0003sl.k8;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;

/* loaded from: classes.dex */
public class NearbySearch {
    public static final int AMAP = 1;
    public static final int GPS = 0;

    /* renamed from: b, reason: collision with root package name */
    private static NearbySearch f6072b;

    /* renamed from: a, reason: collision with root package name */
    private INearbySearch f6073a;

    public interface NearbyListener {
        void onNearbyInfoSearched(NearbySearchResult nearbySearchResult, int i3);

        void onNearbyInfoUploaded(int i3);

        void onUserInfoCleared(int i3);
    }

    public static class NearbyQuery {

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f6074a;

        /* renamed from: b, reason: collision with root package name */
        private NearbySearchFunctionType f6075b = NearbySearchFunctionType.DISTANCE_SEARCH;

        /* renamed from: c, reason: collision with root package name */
        private int f6076c = 1000;

        /* renamed from: d, reason: collision with root package name */
        private int f6077d = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
        private int e = 1;

        public LatLonPoint getCenterPoint() {
            return this.f6074a;
        }

        public int getCoordType() {
            return this.e;
        }

        public int getRadius() {
            return this.f6076c;
        }

        public int getTimeRange() {
            return this.f6077d;
        }

        public int getType() {
            int ordinal = this.f6075b.ordinal();
            return (ordinal == 0 || ordinal != 1) ? 0 : 1;
        }

        public void setCenterPoint(LatLonPoint latLonPoint) {
            this.f6074a = latLonPoint;
        }

        public void setCoordType(int i3) {
            if (i3 == 0 || i3 == 1) {
                this.e = i3;
            } else {
                this.e = 1;
            }
        }

        public void setRadius(int i3) {
            if (i3 > 10000) {
                i3 = 10000;
            }
            this.f6076c = i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0008, code lost:
        
            if (r2 > 86400) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setTimeRange(int r2) {
            /*
                r1 = this;
                r0 = 5
                if (r2 >= r0) goto L5
            L3:
                r2 = r0
                goto Lb
            L5:
                r0 = 86400(0x15180, float:1.21072E-40)
                if (r2 <= r0) goto Lb
                goto L3
            Lb:
                r1.f6077d = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.nearby.NearbySearch.NearbyQuery.setTimeRange(int):void");
        }

        public void setType(NearbySearchFunctionType nearbySearchFunctionType) {
            this.f6075b = nearbySearchFunctionType;
        }
    }

    private NearbySearch(Context context) throws AMapException {
        if (this.f6073a == null) {
            try {
                this.f6073a = new k8(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public static synchronized void destroy() {
        synchronized (NearbySearch.class) {
            try {
                NearbySearch nearbySearch = f6072b;
                if (nearbySearch != null) {
                    try {
                        INearbySearch iNearbySearch = nearbySearch.f6073a;
                        if (iNearbySearch != null) {
                            iNearbySearch.destroy();
                        }
                        nearbySearch.f6073a = null;
                    } catch (Throwable th2) {
                        d6.a(th2, "NearbySearch", "destryoy");
                    }
                }
                f6072b = null;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static synchronized NearbySearch getInstance(Context context) throws AMapException {
        NearbySearch nearbySearch;
        synchronized (NearbySearch.class) {
            if (f6072b == null) {
                try {
                    f6072b = new NearbySearch(context);
                } catch (AMapException e) {
                    throw e;
                }
            }
            nearbySearch = f6072b;
        }
        return nearbySearch;
    }

    public synchronized void addNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.f6073a;
        if (iNearbySearch != null) {
            iNearbySearch.addNearbyListener(nearbyListener);
        }
    }

    public void clearUserInfoAsyn() {
        INearbySearch iNearbySearch = this.f6073a;
        if (iNearbySearch != null) {
            iNearbySearch.clearUserInfoAsyn();
        }
    }

    public synchronized void removeNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.f6073a;
        if (iNearbySearch != null) {
            iNearbySearch.removeNearbyListener(nearbyListener);
        }
    }

    public NearbySearchResult searchNearbyInfo(NearbyQuery nearbyQuery) throws AMapException {
        INearbySearch iNearbySearch = this.f6073a;
        if (iNearbySearch != null) {
            return iNearbySearch.searchNearbyInfo(nearbyQuery);
        }
        return null;
    }

    public void searchNearbyInfoAsyn(NearbyQuery nearbyQuery) {
        INearbySearch iNearbySearch = this.f6073a;
        if (iNearbySearch != null) {
            iNearbySearch.searchNearbyInfoAsyn(nearbyQuery);
        }
    }

    public void setUserID(String str) {
        INearbySearch iNearbySearch = this.f6073a;
        if (iNearbySearch != null) {
            iNearbySearch.setUserID(str);
        }
    }

    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i3) {
        INearbySearch iNearbySearch = this.f6073a;
        if (iNearbySearch != null) {
            iNearbySearch.startUploadNearbyInfoAuto(uploadInfoCallback, i3);
        }
    }

    public synchronized void stopUploadNearbyInfoAuto() {
        INearbySearch iNearbySearch = this.f6073a;
        if (iNearbySearch != null) {
            iNearbySearch.stopUploadNearbyInfoAuto();
        }
    }

    public void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        INearbySearch iNearbySearch = this.f6073a;
        if (iNearbySearch != null) {
            iNearbySearch.uploadNearbyInfoAsyn(uploadInfo);
        }
    }
}
