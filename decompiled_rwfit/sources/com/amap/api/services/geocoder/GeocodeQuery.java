package com.amap.api.services.geocoder;

/* loaded from: classes.dex */
public class GeocodeQuery {

    /* renamed from: a, reason: collision with root package name */
    private String f6019a;

    /* renamed from: b, reason: collision with root package name */
    private String f6020b;

    /* renamed from: c, reason: collision with root package name */
    private String f6021c;

    public GeocodeQuery(String str, String str2) {
        this.f6019a = str;
        this.f6020b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
        String str = this.f6020b;
        if (str == null) {
            if (geocodeQuery.f6020b != null) {
                return false;
            }
        } else if (!str.equals(geocodeQuery.f6020b)) {
            return false;
        }
        String str2 = this.f6019a;
        if (str2 == null) {
            if (geocodeQuery.f6019a != null) {
                return false;
            }
        } else if (!str2.equals(geocodeQuery.f6019a)) {
            return false;
        }
        return true;
    }

    public String getCity() {
        return this.f6020b;
    }

    public String getCountry() {
        return this.f6021c;
    }

    public String getLocationName() {
        return this.f6019a;
    }

    public int hashCode() {
        String str = this.f6020b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f6019a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.f6020b = str;
    }

    public void setCountry(String str) {
        this.f6021c = str;
    }

    public void setLocationName(String str) {
        this.f6019a = str;
    }
}
