package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.p0003sl.d6;
import com.amap.api.col.p0003sl.l8;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class PoiSearch {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";

    /* renamed from: a, reason: collision with root package name */
    private IPoiSearch f6118a;

    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItem poiItem, int i3);

        void onPoiSearched(PoiResult poiResult, int i3);
    }

    public static class Query implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        private String f6119a;

        /* renamed from: b, reason: collision with root package name */
        private String f6120b;

        /* renamed from: c, reason: collision with root package name */
        private String f6121c;

        /* renamed from: d, reason: collision with root package name */
        private int f6122d;
        private int e;

        /* renamed from: f, reason: collision with root package name */
        private String f6123f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f6124g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f6125h;

        /* renamed from: i, reason: collision with root package name */
        private String f6126i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f6127j;

        /* renamed from: k, reason: collision with root package name */
        private LatLonPoint f6128k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f6129l;

        /* renamed from: m, reason: collision with root package name */
        private Map<String, String> f6130m;

        /* renamed from: n, reason: collision with root package name */
        private String f6131n;

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Query query = (Query) obj;
            if (this.f6122d == query.f6122d && this.e == query.e && this.f6124g == query.f6124g && this.f6125h == query.f6125h && this.f6127j == query.f6127j && this.f6129l == query.f6129l && Objects.equals(this.f6119a, query.f6119a) && Objects.equals(this.f6120b, query.f6120b) && Objects.equals(this.f6121c, query.f6121c) && Objects.equals(this.f6123f, query.f6123f) && Objects.equals(this.f6126i, query.f6126i) && Objects.equals(this.f6128k, query.f6128k) && Objects.equals(this.f6130m, query.f6130m)) {
                return Objects.equals(this.f6131n, query.f6131n);
            }
            return false;
        }

        public String getBuilding() {
            return this.f6126i;
        }

        public String getCategory() {
            String str = this.f6120b;
            return (str == null || str.equals("00") || this.f6120b.equals("00|")) ? "" : this.f6120b;
        }

        public String getCity() {
            return this.f6121c;
        }

        public boolean getCityLimit() {
            return this.f6124g;
        }

        public Map<String, String> getCustomParams() {
            return this.f6130m;
        }

        public String getExtensions() {
            return this.f6131n;
        }

        public LatLonPoint getLocation() {
            return this.f6128k;
        }

        public int getPageNum() {
            return this.f6122d;
        }

        public int getPageSize() {
            return this.e;
        }

        public String getQueryLanguage() {
            return this.f6123f;
        }

        public String getQueryString() {
            return this.f6119a;
        }

        public int hashCode() {
            String str = this.f6119a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f6120b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f6121c;
            int hashCode3 = (((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f6122d) * 31) + this.e) * 31;
            String str4 = this.f6123f;
            int hashCode4 = (((((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + (this.f6124g ? 1 : 0)) * 31) + (this.f6125h ? 1 : 0)) * 31;
            String str5 = this.f6126i;
            int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + (this.f6127j ? 1 : 0)) * 31;
            LatLonPoint latLonPoint = this.f6128k;
            int hashCode6 = (((hashCode5 + (latLonPoint != null ? latLonPoint.hashCode() : 0)) * 31) + (this.f6129l ? 1 : 0)) * 31;
            Map<String, String> map = this.f6130m;
            int hashCode7 = (hashCode6 + (map != null ? map.hashCode() : 0)) * 31;
            String str6 = this.f6131n;
            return hashCode7 + (str6 != null ? str6.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f6127j;
        }

        public boolean isRequireSubPois() {
            return this.f6125h;
        }

        public boolean isSpecial() {
            return this.f6129l;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearch.a(query.f6119a, this.f6119a) && PoiSearch.a(query.f6120b, this.f6120b) && PoiSearch.a(query.f6123f, this.f6123f) && PoiSearch.a(query.f6121c, this.f6121c) && PoiSearch.a(query.f6131n, this.f6131n) && PoiSearch.a(query.f6126i, this.f6126i) && query.f6124g == this.f6124g && query.e == this.e && query.f6127j == this.f6127j && query.f6130m.equals(this.f6130m) && query.f6129l == this.f6129l;
        }

        public void requireSubPois(boolean z5) {
            this.f6125h = z5;
        }

        public void setBuilding(String str) {
            this.f6126i = str;
        }

        public void setCityLimit(boolean z5) {
            this.f6124g = z5;
        }

        public void setCustomParams(Map<String, String> map) {
            if (map != null) {
                this.f6130m.putAll(map);
            }
        }

        public void setDistanceSort(boolean z5) {
            this.f6127j = z5;
        }

        public void setExtensions(String str) {
            this.f6131n = str;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.f6128k = latLonPoint;
        }

        public void setPageNum(int i3) {
            if (i3 < 1) {
                i3 = 1;
            }
            this.f6122d = i3;
        }

        public void setPageSize(int i3) {
            if (i3 <= 0) {
                this.e = 20;
            } else if (i3 > 30) {
                this.e = 30;
            } else {
                this.e = i3;
            }
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f6123f = "en";
            } else {
                this.f6123f = "zh-CN";
            }
        }

        public void setSpecial(boolean z5) {
            this.f6129l = z5;
        }

        public Query(String str, String str2, String str3) {
            this.f6122d = 1;
            this.e = 20;
            this.f6123f = "zh-CN";
            this.f6124g = false;
            this.f6125h = false;
            this.f6127j = true;
            this.f6129l = true;
            this.f6130m = new HashMap();
            this.f6131n = "base";
            this.f6119a = str;
            this.f6120b = str2;
            this.f6121c = str3;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Query m23clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f6119a, this.f6120b, this.f6121c);
            query.setPageNum(this.f6122d);
            query.setPageSize(this.e);
            query.setQueryLanguage(this.f6123f);
            query.setCityLimit(this.f6124g);
            query.requireSubPois(this.f6125h);
            query.setBuilding(this.f6126i);
            query.setLocation(this.f6128k);
            query.setDistanceSort(this.f6127j);
            query.setSpecial(this.f6129l);
            query.setExtensions(this.f6131n);
            query.setCustomParams(this.f6130m);
            return query;
        }
    }

    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f6132a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f6133b;

        /* renamed from: c, reason: collision with root package name */
        private int f6134c;

        /* renamed from: d, reason: collision with root package name */
        private LatLonPoint f6135d;
        private String e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f6136f;

        /* renamed from: g, reason: collision with root package name */
        private List<LatLonPoint> f6137g;

        public SearchBound(LatLonPoint latLonPoint, int i3) {
            this.f6136f = true;
            this.e = "Bound";
            this.f6134c = i3;
            this.f6135d = latLonPoint;
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f6132a = latLonPoint;
            this.f6133b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.f6133b.getLatitude() || this.f6132a.getLongitude() >= this.f6133b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.f6135d = new LatLonPoint((this.f6133b.getLatitude() + this.f6132a.getLatitude()) / 2.0d, (this.f6133b.getLongitude() + this.f6132a.getLongitude()) / 2.0d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            LatLonPoint latLonPoint = this.f6135d;
            if (latLonPoint == null) {
                if (searchBound.f6135d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(searchBound.f6135d)) {
                return false;
            }
            if (this.f6136f != searchBound.f6136f) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f6132a;
            if (latLonPoint2 == null) {
                if (searchBound.f6132a != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(searchBound.f6132a)) {
                return false;
            }
            LatLonPoint latLonPoint3 = this.f6133b;
            if (latLonPoint3 == null) {
                if (searchBound.f6133b != null) {
                    return false;
                }
            } else if (!latLonPoint3.equals(searchBound.f6133b)) {
                return false;
            }
            List<LatLonPoint> list = this.f6137g;
            if (list == null) {
                if (searchBound.f6137g != null) {
                    return false;
                }
            } else if (!list.equals(searchBound.f6137g)) {
                return false;
            }
            if (this.f6134c != searchBound.f6134c) {
                return false;
            }
            String str = this.e;
            if (str == null) {
                if (searchBound.e != null) {
                    return false;
                }
            } else if (!str.equals(searchBound.e)) {
                return false;
            }
            return true;
        }

        public LatLonPoint getCenter() {
            return this.f6135d;
        }

        public LatLonPoint getLowerLeft() {
            return this.f6132a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f6137g;
        }

        public int getRange() {
            return this.f6134c;
        }

        public String getShape() {
            return this.e;
        }

        public LatLonPoint getUpperRight() {
            return this.f6133b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f6135d;
            int hashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f6136f ? 1231 : 1237)) * 31;
            LatLonPoint latLonPoint2 = this.f6132a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f6133b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f6137g;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f6134c) * 31;
            String str = this.e;
            return hashCode4 + (str != null ? str.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f6136f;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public SearchBound m24clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f6132a, this.f6133b, this.f6134c, this.f6135d, this.e, this.f6137g, this.f6136f);
        }

        public SearchBound(LatLonPoint latLonPoint, int i3, boolean z5) {
            this.e = "Bound";
            this.f6134c = i3;
            this.f6135d = latLonPoint;
            this.f6136f = z5;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f6134c = 1500;
            this.f6136f = true;
            this.e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f6134c = 1500;
            this.f6136f = true;
            this.e = "Polygon";
            this.f6137g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i3, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z5) {
            this.f6132a = latLonPoint;
            this.f6133b = latLonPoint2;
            this.f6134c = i3;
            this.f6135d = latLonPoint3;
            this.e = str;
            this.f6137g = list;
            this.f6136f = z5;
        }
    }

    public PoiSearch(Context context, Query query) throws AMapException {
        this.f6118a = null;
        try {
            this.f6118a = new l8(context, query);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof AMapException) {
                throw ((AMapException) e);
            }
        }
    }

    public static boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public SearchBound getBound() {
        IPoiSearch iPoiSearch = this.f6118a;
        if (iPoiSearch != null) {
            return iPoiSearch.getBound();
        }
        return null;
    }

    public String getLanguage() {
        IPoiSearch iPoiSearch = this.f6118a;
        if (iPoiSearch != null) {
            return iPoiSearch.getLanguage();
        }
        return null;
    }

    public Query getQuery() {
        IPoiSearch iPoiSearch = this.f6118a;
        if (iPoiSearch != null) {
            return iPoiSearch.getQuery();
        }
        return null;
    }

    public PoiResult searchPOI() throws AMapException {
        IPoiSearch iPoiSearch = this.f6118a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearch iPoiSearch = this.f6118a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIAsyn();
        }
    }

    public PoiItem searchPOIId(String str) throws AMapException {
        IPoiSearch iPoiSearch = this.f6118a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearch iPoiSearch = this.f6118a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIIdAsyn(str);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearch iPoiSearch = this.f6118a;
        if (iPoiSearch != null) {
            iPoiSearch.setBound(searchBound);
        }
    }

    public void setLanguage(String str) {
        IPoiSearch iPoiSearch = this.f6118a;
        if (iPoiSearch != null) {
            iPoiSearch.setLanguage(str);
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearch iPoiSearch = this.f6118a;
        if (iPoiSearch != null) {
            iPoiSearch.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(Query query) {
        IPoiSearch iPoiSearch = this.f6118a;
        if (iPoiSearch != null) {
            iPoiSearch.setQuery(query);
        }
    }
}
