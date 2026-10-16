package com.amap.api.services.cloud;

import android.content.Context;
import com.amap.api.col.p0003sl.d6;
import com.amap.api.col.p0003sl.f8;
import com.amap.api.col.p0003sl.g7;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.ArrayList;
import java.util.List;
import r5.a;

/* loaded from: classes.dex */
public class CloudSearch {

    /* renamed from: a, reason: collision with root package name */
    private ICloudSearch f5910a;

    public interface OnCloudSearchListener {
        void onCloudItemDetailSearched(CloudItemDetail cloudItemDetail, int i3);

        void onCloudSearched(CloudResult cloudResult, int i3);
    }

    public static class Query implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        private String f5911a;

        /* renamed from: d, reason: collision with root package name */
        private String f5914d;
        private SearchBound e;

        /* renamed from: f, reason: collision with root package name */
        private Sortingrules f5915f;

        /* renamed from: b, reason: collision with root package name */
        private int f5912b = 1;

        /* renamed from: c, reason: collision with root package name */
        private int f5913c = 20;

        /* renamed from: g, reason: collision with root package name */
        private ArrayList<g7> f5916g = new ArrayList<>();

        /* renamed from: h, reason: collision with root package name */
        private List<String> f5917h = new ArrayList();

        public Query(String str, String str2, SearchBound searchBound) throws AMapException {
            if (d6.a(str) || searchBound == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            this.f5914d = str;
            this.f5911a = str2;
            this.e = searchBound;
        }

        public void addFilterNum(String str, String str2, String str3) {
            this.f5916g.add(new g7(str, str2, str3));
        }

        public void addFilterString(String str, String str2) {
            if (str == null || str2 == null) {
                return;
            }
            this.f5917h.add(str.concat(str2));
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof Query)) {
                if (obj == this) {
                    return true;
                }
                Query query = (Query) obj;
                if (queryEquals(query) && query.f5912b == this.f5912b) {
                    return true;
                }
            }
            return false;
        }

        public SearchBound getBound() {
            return this.e;
        }

        public String getFilterNumString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.f5916g.size();
                for (int i3 = 0; i3 < size; i3++) {
                    g7 g7Var = this.f5916g.get(i3);
                    stringBuffer.append(g7Var.a());
                    stringBuffer.append(">=");
                    stringBuffer.append(g7Var.b());
                    stringBuffer.append("&&");
                    stringBuffer.append(g7Var.a());
                    stringBuffer.append("<=");
                    stringBuffer.append(g7Var.c());
                    if (i3 != size - 1) {
                        stringBuffer.append("&&");
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public String getFilterString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.f5917h.size();
                for (int i3 = 0; i3 < size; i3++) {
                    stringBuffer.append(this.f5917h.get(i3));
                    if (i3 != size - 1) {
                        stringBuffer.append("&&");
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public int getPageNum() {
            return this.f5912b;
        }

        public int getPageSize() {
            return this.f5913c;
        }

        public String getQueryString() {
            return this.f5911a;
        }

        public Sortingrules getSortingrules() {
            return this.f5915f;
        }

        public String getTableID() {
            return this.f5914d;
        }

        public int hashCode() {
            ArrayList<g7> arrayList = this.f5916g;
            int hashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
            List<String> list = this.f5917h;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            SearchBound searchBound = this.e;
            int hashCode3 = (((((hashCode2 + (searchBound == null ? 0 : searchBound.hashCode())) * 31) + this.f5912b) * 31) + this.f5913c) * 31;
            String str = this.f5911a;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            Sortingrules sortingrules = this.f5915f;
            int hashCode5 = (hashCode4 + (sortingrules == null ? 0 : sortingrules.hashCode())) * 31;
            String str2 = this.f5914d;
            return hashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            if (CloudSearch.a(query.f5911a, this.f5911a) && CloudSearch.a(query.getTableID(), getTableID()) && CloudSearch.a(query.getFilterString(), getFilterString()) && CloudSearch.a(query.getFilterNumString(), getFilterNumString()) && query.f5913c == this.f5913c) {
                SearchBound bound = query.getBound();
                SearchBound bound2 = getBound();
                if ((bound == null && bound2 == null) ? true : (bound == null || bound2 == null) ? false : bound.equals(bound2)) {
                    Sortingrules sortingrules = query.getSortingrules();
                    Sortingrules sortingrules2 = getSortingrules();
                    if ((sortingrules == null && sortingrules2 == null) ? true : (sortingrules == null || sortingrules2 == null) ? false : sortingrules.equals(sortingrules2)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void setBound(SearchBound searchBound) {
            this.e = searchBound;
        }

        public void setPageNum(int i3) {
            this.f5912b = i3;
        }

        public void setPageSize(int i3) {
            if (i3 <= 0) {
                this.f5913c = 20;
            } else if (i3 > 100) {
                this.f5913c = 100;
            } else {
                this.f5913c = i3;
            }
        }

        public void setSortingrules(Sortingrules sortingrules) {
            this.f5915f = sortingrules;
        }

        public void setTableID(String str) {
            this.f5914d = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[RETURN] */
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.amap.api.services.cloud.CloudSearch.Query m20clone() {
            /*
                r6 = this;
                super.clone()     // Catch: java.lang.CloneNotSupportedException -> L4
                goto L8
            L4:
                r0 = move-exception
                r0.printStackTrace()
            L8:
                r0 = 0
                com.amap.api.services.cloud.CloudSearch$Query r1 = new com.amap.api.services.cloud.CloudSearch$Query     // Catch: com.amap.api.services.core.AMapException -> L4b
                java.lang.String r2 = r6.f5914d     // Catch: com.amap.api.services.core.AMapException -> L4b
                java.lang.String r3 = r6.f5911a     // Catch: com.amap.api.services.core.AMapException -> L4b
                com.amap.api.services.cloud.CloudSearch$SearchBound r4 = r6.e     // Catch: com.amap.api.services.core.AMapException -> L4b
                r1.<init>(r2, r3, r4)     // Catch: com.amap.api.services.core.AMapException -> L4b
                int r2 = r6.f5912b     // Catch: com.amap.api.services.core.AMapException -> L49
                r1.setPageNum(r2)     // Catch: com.amap.api.services.core.AMapException -> L49
                int r2 = r6.f5913c     // Catch: com.amap.api.services.core.AMapException -> L49
                r1.setPageSize(r2)     // Catch: com.amap.api.services.core.AMapException -> L49
                com.amap.api.services.cloud.CloudSearch$Sortingrules r2 = r6.getSortingrules()     // Catch: com.amap.api.services.core.AMapException -> L49
                r1.setSortingrules(r2)     // Catch: com.amap.api.services.core.AMapException -> L49
                java.util.ArrayList<com.amap.api.col.3sl.g7> r2 = r6.f5916g     // Catch: com.amap.api.services.core.AMapException -> L49
                if (r2 != 0) goto L2b
                r2 = r0
                goto L35
            L2b:
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch: com.amap.api.services.core.AMapException -> L49
                r2.<init>()     // Catch: com.amap.api.services.core.AMapException -> L49
                java.util.ArrayList<com.amap.api.col.3sl.g7> r3 = r6.f5916g     // Catch: com.amap.api.services.core.AMapException -> L49
                r2.addAll(r3)     // Catch: com.amap.api.services.core.AMapException -> L49
            L35:
                r1.f5916g = r2     // Catch: com.amap.api.services.core.AMapException -> L49
                java.util.List<java.lang.String> r2 = r6.f5917h     // Catch: com.amap.api.services.core.AMapException -> L49
                if (r2 != 0) goto L3c
                goto L46
            L3c:
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch: com.amap.api.services.core.AMapException -> L49
                r0.<init>()     // Catch: com.amap.api.services.core.AMapException -> L49
                java.util.List<java.lang.String> r2 = r6.f5917h     // Catch: com.amap.api.services.core.AMapException -> L49
                r0.addAll(r2)     // Catch: com.amap.api.services.core.AMapException -> L49
            L46:
                r1.f5917h = r0     // Catch: com.amap.api.services.core.AMapException -> L49
                goto L52
            L49:
                r0 = move-exception
                goto L4f
            L4b:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L4f:
                r0.printStackTrace()
            L52:
                if (r1 != 0) goto L5a
                com.amap.api.services.cloud.CloudSearch$Query r0 = new com.amap.api.services.cloud.CloudSearch$Query
                r0.<init>()
                return r0
            L5a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.cloud.CloudSearch.Query.m20clone():com.amap.api.services.cloud.CloudSearch$Query");
        }

        private Query() {
        }
    }

    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String LOCAL_SHAPE = "Local";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f5918a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f5919b;

        /* renamed from: c, reason: collision with root package name */
        private int f5920c;

        /* renamed from: d, reason: collision with root package name */
        private LatLonPoint f5921d;
        private String e;

        /* renamed from: f, reason: collision with root package name */
        private List<LatLonPoint> f5922f;

        /* renamed from: g, reason: collision with root package name */
        private String f5923g;

        public SearchBound(LatLonPoint latLonPoint, int i3) {
            this.e = "Bound";
            this.f5920c = i3;
            this.f5921d = latLonPoint;
        }

        private boolean a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f5918a = latLonPoint;
            this.f5919b = latLonPoint2;
            return latLonPoint != null && latLonPoint2 != null && latLonPoint.getLatitude() < this.f5919b.getLatitude() && this.f5918a.getLongitude() < this.f5919b.getLongitude();
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof SearchBound)) {
                SearchBound searchBound = (SearchBound) obj;
                if (!getShape().equalsIgnoreCase(searchBound.getShape())) {
                    return false;
                }
                if (getShape().equals("Bound")) {
                    return searchBound.f5921d.equals(this.f5921d) && searchBound.f5920c == this.f5920c;
                }
                if (getShape().equals("Polygon")) {
                    List<LatLonPoint> list = searchBound.f5922f;
                    List<LatLonPoint> list2 = this.f5922f;
                    if (list != null || list2 != null) {
                        if (list != null && list2 != null && list.size() == list2.size()) {
                            int size = list.size();
                            for (int i3 = 0; i3 < size; i3++) {
                                if (list.get(i3).equals(list2.get(i3))) {
                                }
                            }
                        }
                        return false;
                    }
                    return true;
                }
                if (getShape().equals(LOCAL_SHAPE)) {
                    return searchBound.f5923g.equals(this.f5923g);
                }
                if (searchBound.f5918a.equals(this.f5918a) && searchBound.f5919b.equals(this.f5919b)) {
                    return true;
                }
            }
            return false;
        }

        public LatLonPoint getCenter() {
            return this.f5921d;
        }

        public String getCity() {
            return this.f5923g;
        }

        public LatLonPoint getLowerLeft() {
            return this.f5918a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f5922f;
        }

        public int getRange() {
            return this.f5920c;
        }

        public String getShape() {
            return this.e;
        }

        public LatLonPoint getUpperRight() {
            return this.f5919b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f5921d;
            int hashCode = ((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint2 = this.f5918a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f5919b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f5922f;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f5920c) * 31;
            String str = this.e;
            int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f5923g;
            return hashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public SearchBound m21clone() {
            ArrayList arrayList;
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            if (getShape().equals("Bound")) {
                return new SearchBound(this.f5921d, this.f5920c);
            }
            if (!getShape().equals("Polygon")) {
                return getShape().equals(LOCAL_SHAPE) ? new SearchBound(this.f5923g) : new SearchBound(this.f5918a, this.f5919b);
            }
            if (this.f5922f == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (LatLonPoint latLonPoint : this.f5922f) {
                    arrayList.add(new LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
                }
            }
            return new SearchBound(arrayList);
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.e = "Rectangle";
            if (a(latLonPoint, latLonPoint2)) {
                return;
            }
            new IllegalArgumentException("invalid rect ").printStackTrace();
        }

        public SearchBound(List<LatLonPoint> list) {
            this.e = "Polygon";
            this.f5922f = list;
        }

        public SearchBound(String str) {
            this.e = LOCAL_SHAPE;
            this.f5923g = str;
        }
    }

    public CloudSearch(Context context) throws AMapException {
        if (this.f5910a == null) {
            try {
                this.f5910a = new f8(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
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

    public void searchCloudAsyn(Query query) {
        ICloudSearch iCloudSearch = this.f5910a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudAsyn(query);
        }
    }

    public void searchCloudDetailAsyn(String str, String str2) {
        ICloudSearch iCloudSearch = this.f5910a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudDetailAsyn(str, str2);
        }
    }

    public void setOnCloudSearchListener(OnCloudSearchListener onCloudSearchListener) {
        ICloudSearch iCloudSearch = this.f5910a;
        if (iCloudSearch != null) {
            iCloudSearch.setOnCloudSearchListener(onCloudSearchListener);
        }
    }

    public static class Sortingrules {
        public static final int DISTANCE = 1;
        public static final int WEIGHT = 0;

        /* renamed from: a, reason: collision with root package name */
        private int f5924a;

        /* renamed from: b, reason: collision with root package name */
        private String f5925b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5926c;

        public Sortingrules(String str, boolean z5) {
            this.f5924a = 0;
            this.f5925b = str;
            this.f5926c = z5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Sortingrules sortingrules = (Sortingrules) obj;
            if (this.f5926c != sortingrules.f5926c) {
                return false;
            }
            String str = this.f5925b;
            if (str == null) {
                if (sortingrules.f5925b != null) {
                    return false;
                }
            } else if (!str.equals(sortingrules.f5925b)) {
                return false;
            }
            return this.f5924a == sortingrules.f5924a;
        }

        public int hashCode() {
            int i3 = ((this.f5926c ? 1231 : 1237) + 31) * 31;
            String str = this.f5925b;
            return ((i3 + (str == null ? 0 : str.hashCode())) * 31) + this.f5924a;
        }

        public String toString() {
            if (!d6.a(this.f5925b)) {
                return this.f5926c ? a.f(new StringBuilder(), this.f5925b, ":asc") : a.f(new StringBuilder(), this.f5925b, ":desc");
            }
            int i3 = this.f5924a;
            return i3 == 0 ? "_weight:desc" : i3 == 1 ? "_distance:asc" : "";
        }

        public Sortingrules(int i3) {
            this.f5926c = true;
            this.f5924a = i3;
        }
    }
}
