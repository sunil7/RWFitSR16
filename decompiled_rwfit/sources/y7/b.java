package y7;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import b8.g;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import n.g0;
import tb.d;
import z7.c;
import z7.e;
import z7.f;
import z7.h;
import z7.i;
import z7.j;
import z7.k;
import z7.l;
import z7.n;
import z7.o;
import z7.p;
import z7.q;
import z7.r;
import z7.s;

/* loaded from: classes.dex */
public final class b implements g {

    /* renamed from: a, reason: collision with root package name */
    public final n6.a f20025a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f20026b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f20027c;

    /* renamed from: d, reason: collision with root package name */
    public final URL f20028d;
    public final i8.a e;

    /* renamed from: f, reason: collision with root package name */
    public final i8.a f20029f;

    /* renamed from: g, reason: collision with root package name */
    public final int f20030g;

    public b(Context context, i8.a aVar, i8.a aVar2) {
        d dVar = new d();
        c cVar = c.f20333a;
        dVar.a(o.class, cVar);
        dVar.a(i.class, cVar);
        f fVar = f.f20345a;
        dVar.a(r.class, fVar);
        dVar.a(l.class, fVar);
        z7.d dVar2 = z7.d.f20335a;
        dVar.a(p.class, dVar2);
        dVar.a(j.class, dVar2);
        z7.b bVar = z7.b.f20321a;
        dVar.a(z7.a.class, bVar);
        dVar.a(h.class, bVar);
        e eVar = e.f20338a;
        dVar.a(q.class, eVar);
        dVar.a(k.class, eVar);
        z7.g gVar = z7.g.f20352a;
        dVar.a(s.class, gVar);
        dVar.a(n.class, gVar);
        dVar.f18603d = true;
        this.f20025a = new n6.a(dVar, 18);
        this.f20027c = context;
        this.f20026b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f20028d = b(a.f20021c);
        this.e = aVar2;
        this.f20029f = aVar;
        this.f20030g = 40000;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(l0.n("Invalid url: ", str), e);
        }
    }

    public final a8.a a(a8.a aVar) {
        int subtype;
        NetworkInfo activeNetworkInfo = this.f20026b.getActiveNetworkInfo();
        g0 c9 = aVar.c();
        int i3 = Build.VERSION.SDK_INT;
        HashMap hashMap = (HashMap) c9.f16178f;
        if (hashMap == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        hashMap.put("sdk-version", String.valueOf(i3));
        c9.a("model", Build.MODEL);
        c9.a("hardware", Build.HARDWARE);
        c9.a("device", Build.DEVICE);
        c9.a("product", Build.PRODUCT);
        c9.a("os-uild", Build.ID);
        c9.a("manufacturer", Build.MANUFACTURER);
        c9.a("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        long offset = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
        HashMap hashMap2 = (HashMap) c9.f16178f;
        if (hashMap2 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        hashMap2.put("tz-offset", String.valueOf(offset));
        int value = activeNetworkInfo == null ? NetworkConnectionInfo$NetworkType.NONE.getValue() : activeNetworkInfo.getType();
        HashMap hashMap3 = (HashMap) c9.f16178f;
        if (hashMap3 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        hashMap3.put("net-type", String.valueOf(value));
        int i10 = -1;
        if (activeNetworkInfo == null) {
            subtype = NetworkConnectionInfo$MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        } else {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                subtype = NetworkConnectionInfo$MobileSubtype.COMBINED.getValue();
            } else if (NetworkConnectionInfo$MobileSubtype.forNumber(subtype) == null) {
                subtype = 0;
            }
        }
        HashMap hashMap4 = (HashMap) c9.f16178f;
        if (hashMap4 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        hashMap4.put("mobile-subtype", String.valueOf(subtype));
        c9.a("country", Locale.getDefault().getCountry());
        c9.a("locale", Locale.getDefault().getLanguage());
        Context context = this.f20027c;
        c9.a("mcc_mnc", ((TelephonyManager) context.getSystemService("phone")).getSimOperator());
        try {
            i10 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Unable to find version code for package", e);
        }
        c9.a("application_build", Integer.toString(i10));
        return c9.c();
    }
}
