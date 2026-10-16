package com.amap.api.services.share;

import android.content.Context;
import com.amap.api.col.p0003sl.q8;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;

/* loaded from: classes.dex */
public class ShareSearch {
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoHighWay = 3;
    public static final int DrivingNoHighWayAvoidCongestion = 6;
    public static final int DrivingNoHighWaySaveMoney = 5;
    public static final int DrivingNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 7;
    public static final int DrivingShortDistance = 2;
    public static final int NaviAvoidCongestion = 4;
    public static final int NaviDefault = 0;
    public static final int NaviNoHighWay = 3;
    public static final int NaviNoHighWayAvoidCongestion = 6;
    public static final int NaviNoHighWaySaveMoney = 5;
    public static final int NaviNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int NaviSaveMoney = 1;
    public static final int NaviSaveMoneyAvoidCongestion = 7;
    public static final int NaviShortDistance = 2;

    /* renamed from: a, reason: collision with root package name */
    private IShareSearch f6516a;

    public interface OnShareSearchListener {
        void onBusRouteShareUrlSearched(String str, int i3);

        void onDrivingRouteShareUrlSearched(String str, int i3);

        void onLocationShareUrlSearched(String str, int i3);

        void onNaviShareUrlSearched(String str, int i3);

        void onPoiShareUrlSearched(String str, int i3);

        void onWalkRouteShareUrlSearched(String str, int i3);
    }

    public static class ShareBusRouteQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f6517a;

        /* renamed from: b, reason: collision with root package name */
        private int f6518b;

        public ShareBusRouteQuery(ShareFromAndTo shareFromAndTo, int i3) {
            this.f6517a = shareFromAndTo;
            this.f6518b = i3;
        }

        public int getBusMode() {
            return this.f6518b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f6517a;
        }
    }

    public static class ShareDrivingRouteQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f6519a;

        /* renamed from: b, reason: collision with root package name */
        private int f6520b;

        public ShareDrivingRouteQuery(ShareFromAndTo shareFromAndTo, int i3) {
            this.f6519a = shareFromAndTo;
            this.f6520b = i3;
        }

        public int getDrivingMode() {
            return this.f6520b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f6519a;
        }
    }

    public static class ShareFromAndTo {

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f6521a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f6522b;

        /* renamed from: c, reason: collision with root package name */
        private String f6523c = "起点";

        /* renamed from: d, reason: collision with root package name */
        private String f6524d = "终点";

        public ShareFromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f6521a = latLonPoint;
            this.f6522b = latLonPoint2;
        }

        public LatLonPoint getFrom() {
            return this.f6521a;
        }

        public String getFromName() {
            return this.f6523c;
        }

        public LatLonPoint getTo() {
            return this.f6522b;
        }

        public String getToName() {
            return this.f6524d;
        }

        public void setFromName(String str) {
            this.f6523c = str;
        }

        public void setToName(String str) {
            this.f6524d = str;
        }
    }

    public static class ShareNaviQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f6525a;

        /* renamed from: b, reason: collision with root package name */
        private int f6526b;

        public ShareNaviQuery(ShareFromAndTo shareFromAndTo, int i3) {
            this.f6525a = shareFromAndTo;
            this.f6526b = i3;
        }

        public ShareFromAndTo getFromAndTo() {
            return this.f6525a;
        }

        public int getNaviMode() {
            return this.f6526b;
        }
    }

    public static class ShareWalkRouteQuery {

        /* renamed from: a, reason: collision with root package name */
        private ShareFromAndTo f6527a;

        /* renamed from: b, reason: collision with root package name */
        private int f6528b;

        public ShareWalkRouteQuery(ShareFromAndTo shareFromAndTo, int i3) {
            this.f6527a = shareFromAndTo;
            this.f6528b = i3;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f6527a;
        }

        public int getWalkMode() {
            return this.f6528b;
        }
    }

    public ShareSearch(Context context) throws AMapException {
        if (this.f6516a == null) {
            try {
                this.f6516a = new q8(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public String searchBusRouteShareUrl(ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f6516a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchBusRouteShareUrl(shareBusRouteQuery);
        return null;
    }

    public void searchBusRouteShareUrlAsyn(ShareBusRouteQuery shareBusRouteQuery) {
        IShareSearch iShareSearch = this.f6516a;
        if (iShareSearch != null) {
            iShareSearch.searchBusRouteShareUrlAsyn(shareBusRouteQuery);
        }
    }

    public String searchDrivingRouteShareUrl(ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f6516a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
        return null;
    }

    public void searchDrivingRouteShareUrlAsyn(ShareDrivingRouteQuery shareDrivingRouteQuery) {
        IShareSearch iShareSearch = this.f6516a;
        if (iShareSearch != null) {
            iShareSearch.searchDrivingRouteShareUrlAsyn(shareDrivingRouteQuery);
        }
    }

    public String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        IShareSearch iShareSearch = this.f6516a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchLocationShareUrl(latLonSharePoint);
        return null;
    }

    public void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        IShareSearch iShareSearch = this.f6516a;
        if (iShareSearch != null) {
            iShareSearch.searchLocationShareUrlAsyn(latLonSharePoint);
        }
    }

    public String searchNaviShareUrl(ShareNaviQuery shareNaviQuery) throws AMapException {
        IShareSearch iShareSearch = this.f6516a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchNaviShareUrl(shareNaviQuery);
        return null;
    }

    public void searchNaviShareUrlAsyn(ShareNaviQuery shareNaviQuery) {
        IShareSearch iShareSearch = this.f6516a;
        if (iShareSearch != null) {
            iShareSearch.searchNaviShareUrlAsyn(shareNaviQuery);
        }
    }

    public String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        IShareSearch iShareSearch = this.f6516a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchPoiShareUrl(poiItem);
        return null;
    }

    public void searchPoiShareUrlAsyn(PoiItem poiItem) {
        IShareSearch iShareSearch = this.f6516a;
        if (iShareSearch != null) {
            iShareSearch.searchPoiShareUrlAsyn(poiItem);
        }
    }

    public String searchWalkRouteShareUrl(ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f6516a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchWalkRouteShareUrl(shareWalkRouteQuery);
        return null;
    }

    public void searchWalkRouteShareUrlAsyn(ShareWalkRouteQuery shareWalkRouteQuery) {
        IShareSearch iShareSearch = this.f6516a;
        if (iShareSearch != null) {
            iShareSearch.searchWalkRouteShareUrlAsyn(shareWalkRouteQuery);
        }
    }

    public void setOnShareSearchListener(OnShareSearchListener onShareSearchListener) {
        IShareSearch iShareSearch = this.f6516a;
        if (iShareSearch != null) {
            iShareSearch.setOnShareSearchListener(onShareSearchListener);
        }
    }
}
