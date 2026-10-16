package com.amap.api.services.busline;

import com.amap.api.col.p0003sl.d6;

/* loaded from: classes.dex */
public class BusStationQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f5888a;

    /* renamed from: b, reason: collision with root package name */
    private String f5889b;

    /* renamed from: c, reason: collision with root package name */
    private int f5890c = 20;

    /* renamed from: d, reason: collision with root package name */
    private int f5891d = 1;

    public BusStationQuery(String str, String str2) {
        this.f5888a = str;
        this.f5889b = str2;
        if (a()) {
            return;
        }
        new IllegalArgumentException("Empty query").printStackTrace();
    }

    private boolean a() {
        return !d6.a(this.f5888a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusStationQuery busStationQuery = (BusStationQuery) obj;
        String str = this.f5889b;
        if (str == null) {
            if (busStationQuery.f5889b != null) {
                return false;
            }
        } else if (!str.equals(busStationQuery.f5889b)) {
            return false;
        }
        if (this.f5891d != busStationQuery.f5891d || this.f5890c != busStationQuery.f5890c) {
            return false;
        }
        String str2 = this.f5888a;
        if (str2 == null) {
            if (busStationQuery.f5888a != null) {
                return false;
            }
        } else if (!str2.equals(busStationQuery.f5888a)) {
            return false;
        }
        return true;
    }

    public String getCity() {
        return this.f5889b;
    }

    public int getPageNumber() {
        return this.f5891d;
    }

    public int getPageSize() {
        return this.f5890c;
    }

    public String getQueryString() {
        return this.f5888a;
    }

    public int hashCode() {
        String str = this.f5889b;
        int hashCode = ((((((str == null ? 0 : str.hashCode()) + 31) * 31) + this.f5891d) * 31) + this.f5890c) * 31;
        String str2 = this.f5888a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.f5889b = str;
    }

    public void setPageNumber(int i3) {
        if (i3 < 1) {
            i3 = 1;
        }
        this.f5891d = i3;
    }

    public void setPageSize(int i3) {
        this.f5890c = i3;
    }

    public void setQueryString(String str) {
        this.f5888a = str;
    }

    public boolean weakEquals(BusStationQuery busStationQuery) {
        if (this == busStationQuery) {
            return true;
        }
        if (busStationQuery == null) {
            return false;
        }
        String str = this.f5889b;
        if (str == null) {
            if (busStationQuery.f5889b != null) {
                return false;
            }
        } else if (!str.equals(busStationQuery.f5889b)) {
            return false;
        }
        if (this.f5890c != busStationQuery.f5890c) {
            return false;
        }
        String str2 = this.f5888a;
        if (str2 == null) {
            if (busStationQuery.f5888a != null) {
                return false;
            }
        } else if (!str2.equals(busStationQuery.f5888a)) {
            return false;
        }
        return true;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BusStationQuery m19clone() {
        BusStationQuery busStationQuery = new BusStationQuery(this.f5888a, this.f5889b);
        busStationQuery.setPageNumber(this.f5891d);
        busStationQuery.setPageSize(this.f5890c);
        return busStationQuery;
    }
}
