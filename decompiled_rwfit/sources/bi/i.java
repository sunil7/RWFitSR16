package bi;

import com.google.android.gms.internal.mlkit_vision_barcode.b1;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableInterval;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.a0;
import org.joda.time.format.j0;
import org.joda.time.format.v;
import org.joda.time.format.w;

/* loaded from: classes2.dex */
public final class i extends b1 implements f, j, e, k, g {

    /* renamed from: c, reason: collision with root package name */
    public static final i f3270c = new i(0);

    /* renamed from: d, reason: collision with root package name */
    public static final i f3271d = new i(1);

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3272b;

    public /* synthetic */ i(int i3) {
        this.f3272b = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b1, bi.j
    public int[] c(ai.e eVar, Object obj, org.joda.time.a aVar, org.joda.time.format.b bVar) {
        switch (this.f3272b) {
            case 1:
                DateTimeZone dateTimeZone = bVar.f17156f;
                if (dateTimeZone != null) {
                    aVar = aVar.withZone(dateTimeZone);
                }
                return aVar.get(eVar, bVar.h(aVar).c((String) obj));
            default:
                return super.c(eVar, obj, aVar, bVar);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b1, bi.f
    public long d(Object obj, org.joda.time.a aVar) {
        switch (this.f3272b) {
            case 1:
                return v.f17236e0.h(aVar).c((String) obj);
            default:
                return super.d(obj, aVar);
        }
    }

    @Override // bi.b
    public final Class e() {
        switch (this.f3272b) {
            case 0:
                return null;
            default:
                return String.class;
        }
    }

    @Override // bi.k
    public final void f(MutablePeriod mutablePeriod, Object obj, org.joda.time.a aVar) {
        switch (this.f3272b) {
            case 0:
                mutablePeriod.setPeriod((org.joda.time.k) null);
                return;
            default:
                String str = (String) obj;
                a0 a3 = w.a();
                mutablePeriod.clear();
                j0 j0Var = a3.f17150b;
                if (j0Var == null) {
                    throw new UnsupportedOperationException("Parsing not supported");
                }
                int c9 = j0Var.c(mutablePeriod, str, 0);
                if (c9 < str.length()) {
                    if (c9 < 0) {
                        a3.d(mutablePeriod.getPeriodType()).a(str);
                    }
                    throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
                }
                return;
        }
    }

    @Override // bi.g
    public final void g(MutableInterval mutableInterval, Object obj, org.joda.time.a aVar) {
        Period b3;
        long j4;
        long add;
        switch (this.f3272b) {
            case 0:
                mutableInterval.setChronology(aVar);
                AtomicReference atomicReference = org.joda.time.c.f17022a;
                long currentTimeMillis = System.currentTimeMillis();
                mutableInterval.setInterval(currentTimeMillis, currentTimeMillis);
                return;
            default:
                String str = (String) obj;
                int indexOf = str.indexOf(47);
                if (indexOf < 0) {
                    throw new IllegalArgumentException("Format requires a '/' separator: ".concat(str));
                }
                String substring = str.substring(0, indexOf);
                if (substring.length() <= 0) {
                    throw new IllegalArgumentException("Format invalid: ".concat(str));
                }
                String substring2 = str.substring(indexOf + 1);
                if (substring2.length() <= 0) {
                    throw new IllegalArgumentException("Format invalid: ".concat(str));
                }
                org.joda.time.format.b h4 = v.f17236e0.h(aVar);
                a0 a3 = w.a();
                char charAt = substring.charAt(0);
                org.joda.time.a aVar2 = null;
                if (charAt == 'P' || charAt == 'p') {
                    b3 = a3.d(PeriodType.standard()).b(substring);
                    j4 = 0;
                } else {
                    DateTime a10 = h4.a(substring);
                    j4 = a10.getMillis();
                    aVar2 = a10.getChronology();
                    b3 = null;
                }
                char charAt2 = substring2.charAt(0);
                if (charAt2 != 'P' && charAt2 != 'p') {
                    DateTime a11 = h4.a(substring2);
                    add = a11.getMillis();
                    if (aVar2 == null) {
                        aVar2 = a11.getChronology();
                    }
                    if (aVar != null) {
                        aVar2 = aVar;
                    }
                    if (b3 != null) {
                        j4 = aVar2.add(b3, add, -1);
                    }
                } else {
                    if (b3 != null) {
                        throw new IllegalArgumentException("Interval composed of two durations: ".concat(str));
                    }
                    Period b10 = a3.d(PeriodType.standard()).b(substring2);
                    if (aVar != null) {
                        aVar2 = aVar;
                    }
                    add = aVar2.add(b10, j4, 1);
                }
                mutableInterval.setInterval(j4, add);
                mutableInterval.setChronology(aVar2);
                return;
        }
    }

    @Override // bi.e
    public final long i(Object obj) {
        long j4;
        long j10;
        switch (this.f3272b) {
            case 0:
                return 0L;
            default:
                String str = (String) obj;
                int length = str.length();
                if (length >= 4 && ((str.charAt(0) == 'P' || str.charAt(0) == 'p') && (str.charAt(1) == 'T' || str.charAt(1) == 't'))) {
                    int i3 = length - 1;
                    if (str.charAt(i3) == 'S' || str.charAt(i3) == 's') {
                        String substring = str.substring(2, i3);
                        int i10 = 0;
                        int i11 = -1;
                        for (int i12 = 0; i12 < substring.length(); i12++) {
                            if (substring.charAt(i12) < '0' || substring.charAt(i12) > '9') {
                                if (i12 == 0 && substring.charAt(0) == '-') {
                                    i10 = 1;
                                } else {
                                    if (i12 <= i10 || substring.charAt(i12) != '.' || i11 != -1) {
                                        throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
                                    }
                                    i11 = i12;
                                }
                            }
                        }
                        if (i11 > 0) {
                            j10 = Long.parseLong(substring.substring(i10, i11));
                            String substring2 = substring.substring(i11 + 1);
                            if (substring2.length() != 3) {
                                substring2 = substring2.concat("000").substring(0, 3);
                            }
                            j4 = Integer.parseInt(substring2);
                        } else {
                            long parseLong = i10 != 0 ? Long.parseLong(substring.substring(i10, substring.length())) : Long.parseLong(substring);
                            j4 = 0;
                            j10 = parseLong;
                        }
                        return i10 != 0 ? nf.d(nf.f(1000, -j10), -j4) : nf.d(nf.f(1000, j10), j4);
                    }
                }
                throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
        }
    }
}
