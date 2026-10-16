package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.p0003sl.d6;
import com.amap.api.col.p0003sl.m8;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class PoiSearchV2 {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";

    /* renamed from: a, reason: collision with root package name */
    private IPoiSearchV2 f6138a;

    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItemV2 poiItemV2, int i3);

        void onPoiSearched(PoiResultV2 poiResultV2, int i3);
    }

    public enum PremiumType {
        DEFAULT(""),
        ENTIRETY("entirety_poi");


        /* renamed from: a, reason: collision with root package name */
        private final String f6140a;

        PremiumType(String str) {
            this.f6140a = str;
        }

        public String a() {
            return this.f6140a;
        }

        public static PremiumType a(String str) {
            PremiumType premiumType = DEFAULT;
            if (!str.equals(premiumType.f6140a)) {
                PremiumType premiumType2 = ENTIRETY;
                if (str.equals(premiumType2.f6140a)) {
                    return premiumType2;
                }
            }
            return premiumType;
        }
    }

    public static class Query implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        private String f6141a;

        /* renamed from: b, reason: collision with root package name */
        private String f6142b;

        /* renamed from: c, reason: collision with root package name */
        private String f6143c;

        /* renamed from: d, reason: collision with root package name */
        private int f6144d;
        private int e;

        /* renamed from: f, reason: collision with root package name */
        private String f6145f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f6146g;

        /* renamed from: h, reason: collision with root package name */
        private String f6147h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f6148i;

        /* renamed from: j, reason: collision with root package name */
        private LatLonPoint f6149j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f6150k;

        /* renamed from: l, reason: collision with root package name */
        private String f6151l;

        /* renamed from: m, reason: collision with root package name */
        private String f6152m;

        /* renamed from: n, reason: collision with root package name */
        private Map<String, String> f6153n;

        /* renamed from: o, reason: collision with root package name */
        private ShowFields f6154o;

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
            if (this.f6144d == query.f6144d && this.e == query.e && this.f6146g == query.f6146g && this.f6148i == query.f6148i && this.f6150k == query.f6150k && Objects.equals(this.f6141a, query.f6141a) && Objects.equals(this.f6142b, query.f6142b) && Objects.equals(this.f6143c, query.f6143c) && Objects.equals(this.f6145f, query.f6145f) && Objects.equals(this.f6147h, query.f6147h) && Objects.equals(this.f6149j, query.f6149j) && Objects.equals(this.f6151l, query.f6151l) && Objects.equals(this.f6152m, query.f6152m) && Objects.equals(this.f6153n, query.f6153n)) {
                return Objects.equals(this.f6154o, query.f6154o);
            }
            return false;
        }

        public String getBuilding() {
            return this.f6147h;
        }

        public String getCategory() {
            String str = this.f6142b;
            return (str == null || str.equals("00") || this.f6142b.equals("00|")) ? "" : this.f6142b;
        }

        public String getChannel() {
            return this.f6151l;
        }

        public String getCity() {
            return this.f6143c;
        }

        public boolean getCityLimit() {
            return this.f6146g;
        }

        public Map<String, String> getCustomParams() {
            return this.f6153n;
        }

        public LatLonPoint getLocation() {
            return this.f6149j;
        }

        public int getPageNum() {
            return this.f6144d;
        }

        public int getPageSize() {
            return this.e;
        }

        public String getPremium() {
            return this.f6152m;
        }

        public String getQueryLanguage() {
            return this.f6145f;
        }

        public String getQueryString() {
            return this.f6141a;
        }

        public ShowFields getShowFields() {
            return this.f6154o;
        }

        public int hashCode() {
            String str = this.f6141a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f6142b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f6143c;
            int hashCode3 = (((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f6144d) * 31) + this.e) * 31;
            String str4 = this.f6145f;
            int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + (this.f6146g ? 1 : 0)) * 31;
            String str5 = this.f6147h;
            int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + (this.f6148i ? 1 : 0)) * 31;
            LatLonPoint latLonPoint = this.f6149j;
            int hashCode6 = (((hashCode5 + (latLonPoint != null ? latLonPoint.hashCode() : 0)) * 31) + (this.f6150k ? 1 : 0)) * 31;
            String str6 = this.f6151l;
            int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.f6152m;
            int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
            Map<String, String> map = this.f6153n;
            int hashCode9 = (hashCode8 + (map != null ? map.hashCode() : 0)) * 31;
            ShowFields showFields = this.f6154o;
            return hashCode9 + (showFields != null ? showFields.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f6148i;
        }

        public boolean isSpecial() {
            return this.f6150k;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearchV2.a(query.f6141a, this.f6141a) && PoiSearchV2.a(query.f6142b, this.f6142b) && PoiSearchV2.a(query.f6145f, this.f6145f) && PoiSearchV2.a(query.f6143c, this.f6143c) && PoiSearchV2.a(query.f6147h, this.f6147h) && PoiSearchV2.a(query.f6151l, this.f6151l) && PoiSearchV2.a(query.f6152m, this.f6152m) && query.f6146g == this.f6146g && query.e == this.e && query.f6148i == this.f6148i && query.f6150k == this.f6150k && query.f6153n.equals(this.f6153n) && query.f6154o.value == this.f6154o.value;
        }

        public void setBuilding(String str) {
            this.f6147h = str;
        }

        public void setChannel(String str) {
            this.f6151l = str;
        }

        public void setCityLimit(boolean z5) {
            this.f6146g = z5;
        }

        public void setCustomParams(Map<String, String> map) {
            this.f6153n = map;
        }

        public void setDistanceSort(boolean z5) {
            this.f6148i = z5;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.f6149j = latLonPoint;
        }

        public void setPageNum(int i3) {
            if (i3 < 1) {
                i3 = 1;
            }
            this.f6144d = i3;
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

        public void setPremium(PremiumType premiumType) {
            if (premiumType == null) {
                return;
            }
            this.f6152m = premiumType.a();
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f6145f = "en";
            } else {
                this.f6145f = "zh-CN";
            }
        }

        public void setShowFields(ShowFields showFields) {
            if (showFields == null) {
                this.f6154o = new ShowFields();
            } else {
                this.f6154o = showFields;
            }
        }

        public void setSpecial(boolean z5) {
            this.f6150k = z5;
        }

        public Query(String str, String str2, String str3) {
            this.f6144d = 1;
            this.e = 20;
            this.f6145f = "zh-CN";
            this.f6146g = false;
            this.f6148i = true;
            this.f6150k = true;
            this.f6152m = PremiumType.DEFAULT.a();
            this.f6153n = new HashMap();
            this.f6154o = new ShowFields();
            this.f6141a = str;
            this.f6142b = str2;
            this.f6143c = str3;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Query m25clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f6141a, this.f6142b, this.f6143c);
            query.setPageNum(this.f6144d);
            query.setPageSize(this.e);
            query.setQueryLanguage(this.f6145f);
            query.setCityLimit(this.f6146g);
            query.setBuilding(this.f6147h);
            query.setLocation(this.f6149j);
            query.setDistanceSort(this.f6148i);
            query.setSpecial(this.f6150k);
            query.setChannel(this.f6151l);
            query.setPremium(PremiumType.a(this.f6152m));
            query.setCustomParams(this.f6153n);
            query.setShowFields(new ShowFields(this.f6154o.value));
            return query;
        }
    }

    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f6155a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f6156b;

        /* renamed from: c, reason: collision with root package name */
        private int f6157c;

        /* renamed from: d, reason: collision with root package name */
        private LatLonPoint f6158d;
        private String e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f6159f;

        /* renamed from: g, reason: collision with root package name */
        private List<LatLonPoint> f6160g;

        public SearchBound(LatLonPoint latLonPoint, int i3) {
            this.f6159f = true;
            this.e = "Bound";
            this.f6157c = i3;
            this.f6158d = latLonPoint;
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f6155a = latLonPoint;
            this.f6156b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.f6156b.getLatitude() || this.f6155a.getLongitude() >= this.f6156b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.f6158d = new LatLonPoint((this.f6156b.getLatitude() + this.f6155a.getLatitude()) / 2.0d, (this.f6156b.getLongitude() + this.f6155a.getLongitude()) / 2.0d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            LatLonPoint latLonPoint = this.f6158d;
            if (latLonPoint == null) {
                if (searchBound.f6158d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(searchBound.f6158d)) {
                return false;
            }
            if (this.f6159f != searchBound.f6159f) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f6155a;
            if (latLonPoint2 == null) {
                if (searchBound.f6155a != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(searchBound.f6155a)) {
                return false;
            }
            LatLonPoint latLonPoint3 = this.f6156b;
            if (latLonPoint3 == null) {
                if (searchBound.f6156b != null) {
                    return false;
                }
            } else if (!latLonPoint3.equals(searchBound.f6156b)) {
                return false;
            }
            List<LatLonPoint> list = this.f6160g;
            if (list == null) {
                if (searchBound.f6160g != null) {
                    return false;
                }
            } else if (!list.equals(searchBound.f6160g)) {
                return false;
            }
            if (this.f6157c != searchBound.f6157c) {
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
            return this.f6158d;
        }

        public LatLonPoint getLowerLeft() {
            return this.f6155a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f6160g;
        }

        public int getRange() {
            return this.f6157c;
        }

        public String getShape() {
            return this.e;
        }

        public LatLonPoint getUpperRight() {
            return this.f6156b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f6158d;
            int hashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f6159f ? 1231 : 1237)) * 31;
            LatLonPoint latLonPoint2 = this.f6155a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f6156b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f6160g;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f6157c) * 31;
            String str = this.e;
            return hashCode4 + (str != null ? str.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f6159f;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public SearchBound m26clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                d6.a(e, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f6155a, this.f6156b, this.f6157c, this.f6158d, this.e, this.f6160g, this.f6159f);
        }

        public SearchBound(LatLonPoint latLonPoint, int i3, boolean z5) {
            this.e = "Bound";
            this.f6157c = i3;
            this.f6158d = latLonPoint;
            this.f6159f = z5;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f6157c = 1500;
            this.f6159f = true;
            this.e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f6157c = 1500;
            this.f6159f = true;
            this.e = "Polygon";
            this.f6160g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i3, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z5) {
            this.f6155a = latLonPoint;
            this.f6156b = latLonPoint2;
            this.f6157c = i3;
            this.f6158d = latLonPoint3;
            this.e = str;
            this.f6160g = list;
            this.f6159f = z5;
        }
    }

    public static class ShowFields {
        public static final int ALL = -1;
        public static final int BUSINESS = 2;
        public static final int CHILDREN = 1;
        public static final int DEFAULT = 0;
        public static final int INDOOR = 4;
        public static final int NAVI = 8;
        public static final int PHOTOS = 16;
        public int value;

        public ShowFields() {
            this.value = 0;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int i3) {
            this.value = i3;
        }

        public ShowFields(int i3) {
            this.value = i3;
        }
    }

    public PoiSearchV2(Context context, Query query) throws AMapException {
        this.f6138a = null;
        try {
            this.f6138a = new m8(context, query);
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
        IPoiSearchV2 iPoiSearchV2 = this.f6138a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getBound();
        }
        return null;
    }

    public Query getQuery() {
        IPoiSearchV2 iPoiSearchV2 = this.f6138a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getQuery();
        }
        return null;
    }

    public PoiResultV2 searchPOI() throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f6138a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearchV2 iPoiSearchV2 = this.f6138a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIAsyn();
        }
    }

    public PoiItemV2 searchPOIId(String str) throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f6138a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearchV2 iPoiSearchV2 = this.f6138a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIIdAsyn(str);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearchV2 iPoiSearchV2 = this.f6138a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setBound(searchBound);
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearchV2 iPoiSearchV2 = this.f6138a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(Query query) {
        IPoiSearchV2 iPoiSearchV2 = this.f6138a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setQuery(query);
        }
    }
}
