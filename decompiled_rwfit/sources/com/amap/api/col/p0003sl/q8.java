package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.amap.api.services.share.ShareSearch;

/* loaded from: classes.dex */
public class q8 implements IShareSearch {

    /* renamed from: c, reason: collision with root package name */
    private static String f4891c;

    /* renamed from: d, reason: collision with root package name */
    private static String f4892d;
    private static String e;

    /* renamed from: f, reason: collision with root package name */
    private static String f4893f;

    /* renamed from: a, reason: collision with root package name */
    private Context f4894a;

    /* renamed from: b, reason: collision with root package name */
    private ShareSearch.OnShareSearchListener f4895b;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PoiItem f4896a;

        public a(PoiItem poiItem) {
            this.f4896a = poiItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q8.this.f4895b == null) {
                return;
            }
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1100;
            obtainMessage.obj = q8.this.f4895b;
            try {
                try {
                    String searchPoiShareUrl = q8.this.searchPoiShareUrl(this.f4896a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchPoiShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                x6.a().sendMessage(obtainMessage);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShareSearch.ShareBusRouteQuery f4898a;

        public b(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
            this.f4898a = shareBusRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q8.this.f4895b == null) {
                return;
            }
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT;
            obtainMessage.obj = q8.this.f4895b;
            try {
                try {
                    String searchBusRouteShareUrl = q8.this.searchBusRouteShareUrl(this.f4898a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchBusRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                x6.a().sendMessage(obtainMessage);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShareSearch.ShareWalkRouteQuery f4900a;

        public c(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
            this.f4900a = shareWalkRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q8.this.f4895b == null) {
                return;
            }
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1105;
            obtainMessage.obj = q8.this.f4895b;
            try {
                try {
                    String searchWalkRouteShareUrl = q8.this.searchWalkRouteShareUrl(this.f4900a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchWalkRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                x6.a().sendMessage(obtainMessage);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShareSearch.ShareDrivingRouteQuery f4902a;

        public d(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
            this.f4902a = shareDrivingRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q8.this.f4895b == null) {
                return;
            }
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1104;
            obtainMessage.obj = q8.this.f4895b;
            try {
                try {
                    String searchDrivingRouteShareUrl = q8.this.searchDrivingRouteShareUrl(this.f4902a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchDrivingRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                x6.a().sendMessage(obtainMessage);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShareSearch.ShareNaviQuery f4904a;

        public e(ShareSearch.ShareNaviQuery shareNaviQuery) {
            this.f4904a = shareNaviQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q8.this.f4895b == null) {
                return;
            }
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT;
            obtainMessage.obj = q8.this.f4895b;
            try {
                try {
                    String searchNaviShareUrl = q8.this.searchNaviShareUrl(this.f4904a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchNaviShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                x6.a().sendMessage(obtainMessage);
            }
        }
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LatLonSharePoint f4906a;

        public f(LatLonSharePoint latLonSharePoint) {
            this.f4906a = latLonSharePoint;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q8.this.f4895b == null) {
                return;
            }
            Message obtainMessage = x6.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR;
            obtainMessage.obj = q8.this.f4895b;
            try {
                try {
                    String searchLocationShareUrl = q8.this.searchLocationShareUrl(this.f4906a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchLocationShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                x6.a().sendMessage(obtainMessage);
            }
        }
    }

    public q8(Context context) throws AMapException {
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f4894a = context;
        String str2 = "https://" + g9.b(context).a(63);
        f4891c = android.support.v4.media.session.e.l(str2, "/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0");
        f4892d = android.support.v4.media.session.e.l(str2, "/?q=%f,%f,%s&sourceapplication=openapi/0");
        e = android.support.v4.media.session.e.l(str2, "/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0");
        f4893f = android.support.v4.media.session.e.l(str2, "/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0");
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        try {
            if (shareBusRouteQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            try {
                int busMode = shareBusRouteQuery.getBusMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareBusRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                    throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
                }
                LatLonPoint from = shareFromAndTo.getFrom();
                LatLonPoint to = shareFromAndTo.getTo();
                String fromName = shareFromAndTo.getFromName();
                String toName = shareFromAndTo.getToName();
                return new t7(this.f4894a, String.format(f4891c, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(busMode), 1, 0, "", "", "")).c();
            } catch (AMapException e10) {
                e = e10;
                d6.a(e, "ShareSearch", "searchBusRouteShareUrl");
                throw e;
            }
        } catch (AMapException e11) {
            e = e11;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchBusRouteShareUrlAsyn(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
        try {
            u7.b().a(new b(shareBusRouteQuery));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        try {
            if (shareDrivingRouteQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            try {
                int drivingMode = shareDrivingRouteQuery.getDrivingMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareDrivingRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                    throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
                }
                LatLonPoint from = shareFromAndTo.getFrom();
                LatLonPoint to = shareFromAndTo.getTo();
                String fromName = shareFromAndTo.getFromName();
                String toName = shareFromAndTo.getToName();
                return new t7(this.f4894a, String.format(f4891c, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(drivingMode), 0, 0, "", "", "")).c();
            } catch (AMapException e10) {
                e = e10;
                d6.a(e, "ShareSearch", "searchDrivingRouteShareUrl");
                throw e;
            }
        } catch (AMapException e11) {
            e = e11;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchDrivingRouteShareUrlAsyn(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
        try {
            u7.b().a(new d(shareDrivingRouteQuery));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        try {
            if (latLonSharePoint == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            return new t7(this.f4894a, String.format(f4892d, Double.valueOf(latLonSharePoint.getLatitude()), Double.valueOf(latLonSharePoint.getLongitude()), latLonSharePoint.getSharePointName())).c();
        } catch (AMapException e10) {
            d6.a(e10, "ShareSearch", "searchLocationShareUrl");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        try {
            u7.b().a(new f(latLonSharePoint));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchNaviShareUrl(ShareSearch.ShareNaviQuery shareNaviQuery) throws AMapException {
        try {
            if (shareNaviQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            ShareSearch.ShareFromAndTo fromAndTo = shareNaviQuery.getFromAndTo();
            if (fromAndTo.getTo() == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            LatLonPoint from = fromAndTo.getFrom();
            LatLonPoint to = fromAndTo.getTo();
            int naviMode = shareNaviQuery.getNaviMode();
            return new t7(this.f4894a, fromAndTo.getFrom() == null ? String.format(e, null, null, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode)) : String.format(e, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode))).c();
        } catch (AMapException e10) {
            d6.a(e10, "ShareSearch", "searchNaviShareUrl");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchNaviShareUrlAsyn(ShareSearch.ShareNaviQuery shareNaviQuery) {
        try {
            u7.b().a(new e(shareNaviQuery));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        if (poiItem != null) {
            try {
                if (poiItem.getLatLonPoint() != null) {
                    LatLonPoint latLonPoint = poiItem.getLatLonPoint();
                    return new t7(this.f4894a, String.format(f4893f, poiItem.getPoiId(), Double.valueOf(latLonPoint.getLatitude()), Double.valueOf(latLonPoint.getLongitude()), poiItem.getTitle(), poiItem.getSnippet())).c();
                }
            } catch (AMapException e10) {
                d6.a(e10, "ShareSearch", "searchPoiShareUrl");
                throw e10;
            }
        }
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchPoiShareUrlAsyn(PoiItem poiItem) {
        try {
            u7.b().a(new a(poiItem));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        try {
            if (shareWalkRouteQuery == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            try {
                int walkMode = shareWalkRouteQuery.getWalkMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareWalkRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                    throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
                }
                LatLonPoint from = shareFromAndTo.getFrom();
                LatLonPoint to = shareFromAndTo.getTo();
                String fromName = shareFromAndTo.getFromName();
                String toName = shareFromAndTo.getToName();
                return new t7(this.f4894a, String.format(f4891c, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(walkMode), 2, 0, "", "", "")).c();
            } catch (AMapException e10) {
                e = e10;
                d6.a(e, "ShareSearch", "searchWalkRouteShareUrl");
                throw e;
            }
        } catch (AMapException e11) {
            e = e11;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchWalkRouteShareUrlAsyn(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
        try {
            u7.b().a(new c(shareWalkRouteQuery));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void setOnShareSearchListener(ShareSearch.OnShareSearchListener onShareSearchListener) {
        this.f4895b = onShareSearchListener;
    }
}
