package y7;

import com.google.android.gms.internal.mlkit_vision_common.l6;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final String f20021c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set f20022d;
    public static final a e;

    /* renamed from: a, reason: collision with root package name */
    public final String f20023a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20024b;

    static {
        String a3 = l6.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f20021c = a3;
        l6.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        l6.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f20022d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new x7.b("proto"), new x7.b("json"))));
        e = new a(a3, null);
    }

    public a(String str, String str2) {
        this.f20023a = str;
        this.f20024b = str2;
    }

    public static a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
        if (split.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = split[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }
}
