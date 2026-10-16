package z7;

/* loaded from: classes.dex */
public final class h extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f20355a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20356b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20357c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20358d;
    public final String e;

    /* renamed from: f, reason: collision with root package name */
    public final String f20359f;

    /* renamed from: g, reason: collision with root package name */
    public final String f20360g;

    /* renamed from: h, reason: collision with root package name */
    public final String f20361h;

    /* renamed from: i, reason: collision with root package name */
    public final String f20362i;

    /* renamed from: j, reason: collision with root package name */
    public final String f20363j;

    /* renamed from: k, reason: collision with root package name */
    public final String f20364k;

    /* renamed from: l, reason: collision with root package name */
    public final String f20365l;

    public h(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f20355a = num;
        this.f20356b = str;
        this.f20357c = str2;
        this.f20358d = str3;
        this.e = str4;
        this.f20359f = str5;
        this.f20360g = str6;
        this.f20361h = str7;
        this.f20362i = str8;
        this.f20363j = str9;
        this.f20364k = str10;
        this.f20365l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            Integer num = this.f20355a;
            if (num != null ? num.equals(((h) aVar).f20355a) : ((h) aVar).f20355a == null) {
                String str = this.f20356b;
                if (str != null ? str.equals(((h) aVar).f20356b) : ((h) aVar).f20356b == null) {
                    String str2 = this.f20357c;
                    if (str2 != null ? str2.equals(((h) aVar).f20357c) : ((h) aVar).f20357c == null) {
                        String str3 = this.f20358d;
                        if (str3 != null ? str3.equals(((h) aVar).f20358d) : ((h) aVar).f20358d == null) {
                            String str4 = this.e;
                            if (str4 != null ? str4.equals(((h) aVar).e) : ((h) aVar).e == null) {
                                String str5 = this.f20359f;
                                if (str5 != null ? str5.equals(((h) aVar).f20359f) : ((h) aVar).f20359f == null) {
                                    String str6 = this.f20360g;
                                    if (str6 != null ? str6.equals(((h) aVar).f20360g) : ((h) aVar).f20360g == null) {
                                        String str7 = this.f20361h;
                                        if (str7 != null ? str7.equals(((h) aVar).f20361h) : ((h) aVar).f20361h == null) {
                                            String str8 = this.f20362i;
                                            if (str8 != null ? str8.equals(((h) aVar).f20362i) : ((h) aVar).f20362i == null) {
                                                String str9 = this.f20363j;
                                                if (str9 != null ? str9.equals(((h) aVar).f20363j) : ((h) aVar).f20363j == null) {
                                                    String str10 = this.f20364k;
                                                    if (str10 != null ? str10.equals(((h) aVar).f20364k) : ((h) aVar).f20364k == null) {
                                                        String str11 = this.f20365l;
                                                        if (str11 != null ? str11.equals(((h) aVar).f20365l) : ((h) aVar).f20365l == null) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.f20355a;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f20356b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f20357c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f20358d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f20359f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f20360g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f20361h;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f20362i;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f20363j;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f20364k;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f20365l;
        return (str11 != null ? str11.hashCode() : 0) ^ hashCode11;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb2.append(this.f20355a);
        sb2.append(", model=");
        sb2.append(this.f20356b);
        sb2.append(", hardware=");
        sb2.append(this.f20357c);
        sb2.append(", device=");
        sb2.append(this.f20358d);
        sb2.append(", product=");
        sb2.append(this.e);
        sb2.append(", osBuild=");
        sb2.append(this.f20359f);
        sb2.append(", manufacturer=");
        sb2.append(this.f20360g);
        sb2.append(", fingerprint=");
        sb2.append(this.f20361h);
        sb2.append(", locale=");
        sb2.append(this.f20362i);
        sb2.append(", country=");
        sb2.append(this.f20363j);
        sb2.append(", mccMnc=");
        sb2.append(this.f20364k);
        sb2.append(", applicationBuild=");
        return r5.a.f(sb2, this.f20365l, "}");
    }
}
