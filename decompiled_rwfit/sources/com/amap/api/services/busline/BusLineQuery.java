package com.amap.api.services.busline;

/* loaded from: classes.dex */
public class BusLineQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f5872a;

    /* renamed from: b, reason: collision with root package name */
    private String f5873b;
    private SearchType e;

    /* renamed from: c, reason: collision with root package name */
    private int f5874c = 20;

    /* renamed from: d, reason: collision with root package name */
    private int f5875d = 1;

    /* renamed from: f, reason: collision with root package name */
    private String f5876f = "base";

    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.f5872a = str;
        this.e = searchType;
        this.f5873b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusLineQuery busLineQuery = (BusLineQuery) obj;
        if (this.e != busLineQuery.e) {
            return false;
        }
        String str = this.f5873b;
        if (str == null) {
            if (busLineQuery.f5873b != null) {
                return false;
            }
        } else if (!str.equals(busLineQuery.f5873b)) {
            return false;
        }
        if (this.f5875d != busLineQuery.f5875d || this.f5874c != busLineQuery.f5874c) {
            return false;
        }
        String str2 = this.f5872a;
        if (str2 == null) {
            if (busLineQuery.f5872a != null) {
                return false;
            }
        } else if (!str2.equals(busLineQuery.f5872a)) {
            return false;
        }
        String str3 = this.f5876f;
        if (str3 == null) {
            if (busLineQuery.f5876f != null) {
                return false;
            }
        } else if (!str3.equals(busLineQuery.f5876f)) {
            return false;
        }
        return true;
    }

    public SearchType getCategory() {
        return this.e;
    }

    public String getCity() {
        return this.f5873b;
    }

    public String getExtensions() {
        return this.f5876f;
    }

    public int getPageNumber() {
        return this.f5875d;
    }

    public int getPageSize() {
        return this.f5874c;
    }

    public String getQueryString() {
        return this.f5872a;
    }

    public int hashCode() {
        SearchType searchType = this.e;
        int hashCode = ((searchType == null ? 0 : searchType.hashCode()) + 31) * 31;
        String str = this.f5873b;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f5875d) * 31) + this.f5874c) * 31;
        String str2 = this.f5872a;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f5876f;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public void setCategory(SearchType searchType) {
        this.e = searchType;
    }

    public void setCity(String str) {
        this.f5873b = str;
    }

    public void setExtensions(String str) {
        this.f5876f = str;
    }

    public void setPageNumber(int i3) {
        if (i3 < 1) {
            i3 = 1;
        }
        this.f5875d = i3;
    }

    public void setPageSize(int i3) {
        this.f5874c = i3;
    }

    public void setQueryString(String str) {
        this.f5872a = str;
    }

    public boolean weakEquals(BusLineQuery busLineQuery) {
        if (this == busLineQuery) {
            return true;
        }
        if (busLineQuery == null) {
            return false;
        }
        if (this.f5872a == null) {
            if (busLineQuery.getQueryString() != null) {
                return false;
            }
        } else if (!busLineQuery.getQueryString().equals(this.f5872a)) {
            return false;
        }
        if (this.f5873b == null) {
            if (busLineQuery.getCity() != null) {
                return false;
            }
        } else if (!busLineQuery.getCity().equals(this.f5873b)) {
            return false;
        }
        return this.f5874c == busLineQuery.getPageSize() && busLineQuery.getCategory().compareTo(this.e) == 0;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BusLineQuery m18clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.f5872a, this.e, this.f5873b);
        busLineQuery.setPageNumber(this.f5875d);
        busLineQuery.setPageSize(this.f5874c);
        busLineQuery.setExtensions(this.f5876f);
        return busLineQuery;
    }
}
