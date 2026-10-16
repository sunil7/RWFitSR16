package com.google.gson;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.internal.LazilyParsedNumber;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import yb.o;

/* loaded from: classes.dex */
public final class b extends k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11157a;

    public /* synthetic */ b(int i3) {
        this.f11157a = i3;
    }

    public static g c(cc.a aVar) {
        switch (o.f20085a[aVar.b0().ordinal()]) {
            case 1:
                return new j(new LazilyParsedNumber(aVar.Z()));
            case 2:
                return new j(Boolean.valueOf(aVar.y()));
            case 3:
                return new j(aVar.Z());
            case 4:
                aVar.X();
                return h.f11167a;
            case 5:
                f fVar = new f();
                aVar.b();
                while (aVar.j()) {
                    fVar.f11166a.add(c(aVar));
                }
                aVar.g();
                return fVar;
            case 6:
                i iVar = new i();
                aVar.c();
                while (aVar.j()) {
                    iVar.f11168a.put(aVar.O(), c(aVar));
                }
                aVar.h();
                return iVar;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void d(cc.b bVar, g gVar) {
        if (gVar == null || (gVar instanceof h)) {
            bVar.k();
            return;
        }
        boolean z5 = gVar instanceof j;
        if (z5) {
            if (!z5) {
                throw new IllegalStateException("Not a JSON Primitive: " + gVar);
            }
            j jVar = (j) gVar;
            Serializable serializable = jVar.f11198a;
            if (serializable instanceof Number) {
                bVar.F(jVar.a());
                return;
            } else if (serializable instanceof Boolean) {
                bVar.O(serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(jVar.c()));
                return;
            } else {
                bVar.I(jVar.c());
                return;
            }
        }
        boolean z6 = gVar instanceof f;
        if (z6) {
            bVar.c();
            if (!z6) {
                throw new IllegalStateException("Not a JSON Array: " + gVar);
            }
            ArrayList arrayList = ((f) gVar).f11166a;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                d(bVar, (g) obj);
            }
            bVar.g();
            return;
        }
        boolean z8 = gVar instanceof i;
        if (!z8) {
            throw new IllegalArgumentException("Couldn't write " + gVar.getClass());
        }
        bVar.e();
        if (!z8) {
            throw new IllegalStateException("Not a JSON Object: " + gVar);
        }
        for (Map.Entry entry : ((i) gVar).f11168a.entrySet()) {
            bVar.i((String) entry.getKey());
            d(bVar, (g) entry.getValue());
        }
        bVar.h();
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e5, code lost:
    
        if (java.lang.Integer.parseInt(r1) != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e8, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0113, code lost:
    
        if (r10.F() != 0) goto L69;
     */
    @Override // com.google.gson.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(cc.a r10) {
        /*
            Method dump skipped, instructions count: 1118
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.b.a(cc.a):java.lang.Object");
    }

    @Override // com.google.gson.k
    public final void b(cc.b bVar, Object obj) {
        switch (this.f11157a) {
            case 0:
                Number number = (Number) obj;
                if (number == null) {
                    bVar.k();
                    return;
                } else {
                    e.a(number.doubleValue());
                    bVar.F(number);
                    return;
                }
            case 1:
                Number number2 = (Number) obj;
                if (number2 == null) {
                    bVar.k();
                    return;
                } else {
                    e.a(number2.floatValue());
                    bVar.F(number2);
                    return;
                }
            case 2:
                bVar.c();
                int length = ((AtomicIntegerArray) obj).length();
                for (int i3 = 0; i3 < length; i3++) {
                    bVar.A(r6.get(i3));
                }
                bVar.g();
                return;
            case 3:
                bVar.F((Number) obj);
                return;
            case 4:
                bVar.F((Number) obj);
                return;
            case 5:
                bVar.F((Number) obj);
                return;
            case 6:
                bVar.F((Number) obj);
                return;
            case 7:
                Character ch2 = (Character) obj;
                bVar.I(ch2 == null ? null : String.valueOf(ch2));
                return;
            case 8:
                bVar.I((String) obj);
                return;
            case 9:
                bVar.F((BigDecimal) obj);
                return;
            case 10:
                bVar.F((BigInteger) obj);
                return;
            case 11:
                StringBuilder sb2 = (StringBuilder) obj;
                bVar.I(sb2 == null ? null : sb2.toString());
                return;
            case 12:
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?");
            case 13:
                StringBuffer stringBuffer = (StringBuffer) obj;
                bVar.I(stringBuffer == null ? null : stringBuffer.toString());
                return;
            case 14:
                URL url = (URL) obj;
                bVar.I(url == null ? null : url.toExternalForm());
                return;
            case 15:
                URI uri = (URI) obj;
                bVar.I(uri == null ? null : uri.toASCIIString());
                return;
            case 16:
                InetAddress inetAddress = (InetAddress) obj;
                bVar.I(inetAddress == null ? null : inetAddress.getHostAddress());
                return;
            case 17:
                UUID uuid = (UUID) obj;
                bVar.I(uuid == null ? null : uuid.toString());
                return;
            case 18:
                bVar.I(((Currency) obj).getCurrencyCode());
                return;
            case 19:
                if (((Calendar) obj) == null) {
                    bVar.k();
                    return;
                }
                bVar.e();
                bVar.i("year");
                bVar.A(r6.get(1));
                bVar.i("month");
                bVar.A(r6.get(2));
                bVar.i("dayOfMonth");
                bVar.A(r6.get(5));
                bVar.i("hourOfDay");
                bVar.A(r6.get(11));
                bVar.i("minute");
                bVar.A(r6.get(12));
                bVar.i("second");
                bVar.A(r6.get(13));
                bVar.h();
                return;
            case 20:
                Locale locale = (Locale) obj;
                bVar.I(locale == null ? null : locale.toString());
                return;
            case 21:
                d(bVar, (g) obj);
                return;
            case 22:
                BitSet bitSet = (BitSet) obj;
                bVar.c();
                int length2 = bitSet.length();
                for (int i10 = 0; i10 < length2; i10++) {
                    bVar.A(bitSet.get(i10) ? 1L : 0L);
                }
                bVar.g();
                return;
            case 23:
                Boolean bool = (Boolean) obj;
                if (bool == null) {
                    bVar.k();
                    return;
                }
                bVar.W();
                bVar.b();
                bVar.f3443a.write(bool.booleanValue() ? "true" : "false");
                return;
            case 24:
                Boolean bool2 = (Boolean) obj;
                bVar.I(bool2 == null ? "null" : bool2.toString());
                return;
            case 25:
                bVar.F((Number) obj);
                return;
            case 26:
                bVar.F((Number) obj);
                return;
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                bVar.F((Number) obj);
                return;
            case Const.ANDROID_VERSION_28 /* 28 */:
                bVar.A(((AtomicInteger) obj).get());
                return;
            default:
                bVar.O(((AtomicBoolean) obj).get());
                return;
        }
    }
}
