package f8;

import android.content.Context;
import android.util.Log;
import com.example.test.service.q0;
import com.example.test.utils.y;
import com.google.android.datatransport.cct.internal.ClientInfo$ClientType;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.backends.BackendResponse$Status;
import com.google.android.gms.internal.mlkit_vision_barcode.nb;
import de.i;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import z7.j;
import z7.k;
import z7.l;
import z7.n;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13520a;

    /* renamed from: b, reason: collision with root package name */
    public final b8.f f13521b;

    /* renamed from: c, reason: collision with root package name */
    public final g8.c f13522c;

    /* renamed from: d, reason: collision with root package name */
    public final d f13523d;
    public final Executor e;

    /* renamed from: f, reason: collision with root package name */
    public final h8.b f13524f;

    /* renamed from: g, reason: collision with root package name */
    public final i8.a f13525g;

    public g(Context context, b8.f fVar, g8.c cVar, d dVar, Executor executor, h8.b bVar, i8.a aVar) {
        this.f13520a = context;
        this.f13521b = fVar;
        this.f13522c = cVar;
        this.f13523d = dVar;
        this.e = executor;
        this.f13524f = bVar;
        this.f13525g = aVar;
    }

    public final void a(a8.b bVar, int i3) {
        b8.a aVar;
        String str;
        q0 a3;
        String str2;
        Integer num;
        i iVar;
        b8.g a10 = this.f13521b.a(bVar.f120a);
        y yVar = new y(this, 17, bVar, false);
        g8.g gVar = (g8.g) this.f13524f;
        Iterable iterable = (Iterable) gVar.f(yVar);
        if (iterable.iterator().hasNext()) {
            if (a10 == null) {
                nb.a("Uploader", bVar, "Unknown backend for %s, deleting event batch for it...");
                aVar = new b8.a(BackendResponse$Status.FATAL_ERROR, -1L);
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((g8.b) it.next()).f13883c);
                }
                y7.b bVar2 = (y7.b) a10;
                HashMap hashMap = new HashMap();
                int size = arrayList.size();
                int i10 = 0;
                int i11 = 0;
                while (i11 < size) {
                    Object obj = arrayList.get(i11);
                    i11++;
                    a8.a aVar2 = (a8.a) obj;
                    String str3 = aVar2.f115a;
                    if (hashMap.containsKey(str3)) {
                        ((List) hashMap.get(str3)).add(aVar2);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(aVar2);
                        hashMap.put(str3, arrayList2);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                for (Map.Entry entry : hashMap.entrySet()) {
                    a8.a aVar3 = (a8.a) ((List) entry.getValue()).get(i10);
                    QosTier qosTier = QosTier.DEFAULT;
                    long c9 = bVar2.f20029f.c();
                    long c10 = bVar2.e.c();
                    j jVar = new j(ClientInfo$ClientType.ANDROID_FIREBASE, new z7.h(Integer.valueOf(aVar3.b("sdk-version")), aVar3.a("model"), aVar3.a("hardware"), aVar3.a("device"), aVar3.a("product"), aVar3.a("os-uild"), aVar3.a("manufacturer"), aVar3.a("fingerprint"), aVar3.a("locale"), aVar3.a("country"), aVar3.a("mcc_mnc"), aVar3.a("application_build")));
                    try {
                        num = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                        str2 = null;
                    } catch (NumberFormatException unused) {
                        str2 = (String) entry.getKey();
                        num = null;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (a8.a aVar4 : (List) entry.getValue()) {
                        a8.e eVar = aVar4.f117c;
                        x7.b bVar3 = eVar.f128a;
                        boolean equals = bVar3.equals(new x7.b("proto"));
                        byte[] bArr = eVar.f129b;
                        if (equals) {
                            iVar = new i(7);
                            iVar.f12360f = bArr;
                        } else if (bVar3.equals(new x7.b("json"))) {
                            String str4 = new String(bArr, Charset.forName("UTF-8"));
                            i iVar2 = new i(7);
                            iVar2.f12357b = str4;
                            iVar = iVar2;
                        } else {
                            Log.w("TransportRuntime.".concat("CctTransportBackend"), "Received event of unsupported encoding " + bVar3 + ". Skipping...");
                        }
                        iVar.f12358c = Long.valueOf(aVar4.f118d);
                        iVar.e = Long.valueOf(aVar4.e);
                        String str5 = (String) aVar4.f119f.get("tz-offset");
                        iVar.f12361g = Long.valueOf(str5 == null ? 0L : Long.valueOf(str5).longValue());
                        iVar.f12362h = new n(NetworkConnectionInfo$NetworkType.forNumber(aVar4.b("net-type")), NetworkConnectionInfo$MobileSubtype.forNumber(aVar4.b("mobile-subtype")));
                        Integer num2 = aVar4.f116b;
                        if (num2 != null) {
                            iVar.f12359d = num2;
                        }
                        String str6 = ((Long) iVar.f12358c) == null ? " eventTimeMs" : "";
                        if (((Long) iVar.e) == null) {
                            str6 = str6.concat(" eventUptimeMs");
                        }
                        if (((Long) iVar.f12361g) == null) {
                            str6 = android.support.v4.media.session.e.l(str6, " timezoneOffsetSeconds");
                        }
                        if (!str6.isEmpty()) {
                            throw new IllegalStateException("Missing required properties:".concat(str6));
                        }
                        arrayList4.add(new k(((Long) iVar.f12358c).longValue(), (Integer) iVar.f12359d, ((Long) iVar.e).longValue(), (byte[]) iVar.f12360f, (String) iVar.f12357b, ((Long) iVar.f12361g).longValue(), (n) iVar.f12362h));
                    }
                    arrayList3.add(new l(c9, c10, jVar, num, str2, arrayList4, qosTier));
                    i10 = 0;
                }
                z7.i iVar3 = new z7.i(arrayList3);
                byte[] bArr2 = bVar.f121b;
                URL url = bVar2.f20028d;
                if (bArr2 != null) {
                    try {
                        y7.a a11 = y7.a.a(bArr2);
                        String str7 = a11.f20024b;
                        if (str7 == null) {
                            str7 = null;
                        }
                        String str8 = a11.f20023a;
                        if (str8 != null) {
                            url = y7.b.b(str8);
                        }
                        str = str7;
                    } catch (IllegalArgumentException unused2) {
                        aVar = new b8.a(BackendResponse$Status.FATAL_ERROR, -1L);
                    }
                } else {
                    str = null;
                }
                try {
                    n.l lVar = new n.l(url, iVar3, str, 16, false);
                    mc.g gVar2 = new mc.g(bVar2, 28);
                    int i12 = 5;
                    n.l lVar2 = lVar;
                    do {
                        a3 = gVar2.a(lVar2);
                        URL url2 = (URL) a3.f7752c;
                        if (url2 != null) {
                            nb.a("CctTransportBackend", url2, "Following redirect to: %s");
                            lVar2 = new n.l(url2, (z7.i) lVar2.f16246c, (String) lVar2.f16247d, 16, false);
                        } else {
                            lVar2 = null;
                        }
                        if (lVar2 == null) {
                            break;
                        } else {
                            i12--;
                        }
                    } while (i12 >= 1);
                    int i13 = a3.f7750a;
                    if (i13 == 200) {
                        aVar = new b8.a(BackendResponse$Status.OK, a3.f7751b);
                    } else {
                        if (i13 < 500 && i13 != 404) {
                            aVar = new b8.a(BackendResponse$Status.FATAL_ERROR, -1L);
                        }
                        aVar = new b8.a(BackendResponse$Status.TRANSIENT_ERROR, -1L);
                    }
                } catch (IOException e) {
                    Log.e("TransportRuntime.".concat("CctTransportBackend"), "Could not make request to the backend", e);
                    aVar = new b8.a(BackendResponse$Status.TRANSIENT_ERROR, -1L);
                }
            }
            gVar.f(new f(this, aVar, iterable, bVar, i3));
        }
    }
}
