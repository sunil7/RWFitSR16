package bi;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.b1;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.JulianChronology;

/* loaded from: classes2.dex */
public final class a extends b1 implements f, j {

    /* renamed from: c, reason: collision with root package name */
    public static final a f3262c = new a(0);

    /* renamed from: d, reason: collision with root package name */
    public static final a f3263d = new a(1);
    public static final a e = new a(2);

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3264b;

    public /* synthetic */ a(int i3) {
        this.f3264b = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b1, bi.f, bi.j
    public org.joda.time.a a(Object obj, org.joda.time.a aVar) {
        DateTimeZone dateTimeZone;
        switch (this.f3264b) {
            case 0:
                if (aVar != null) {
                    return aVar;
                }
                Calendar calendar = (Calendar) obj;
                try {
                    dateTimeZone = DateTimeZone.forTimeZone(calendar.getTimeZone());
                } catch (IllegalArgumentException unused) {
                    dateTimeZone = DateTimeZone.getDefault();
                }
                return b(calendar, dateTimeZone);
            case 1:
            default:
                return super.a(obj, aVar);
            case 2:
                if (aVar != null) {
                    return aVar;
                }
                org.joda.time.a chronology = ((org.joda.time.h) obj).getChronology();
                AtomicReference atomicReference = org.joda.time.c.f17022a;
                return chronology == null ? ISOChronology.getInstance() : chronology;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b1, bi.f, bi.j
    public org.joda.time.a b(Object obj, DateTimeZone dateTimeZone) {
        switch (this.f3264b) {
            case 0:
                if (obj.getClass().getName().endsWith(".BuddhistCalendar")) {
                    return BuddhistChronology.getInstance(dateTimeZone);
                }
                if (!(obj instanceof GregorianCalendar)) {
                    return ISOChronology.getInstance(dateTimeZone);
                }
                long time = ((GregorianCalendar) obj).getGregorianChange().getTime();
                return time == Long.MIN_VALUE ? GregorianChronology.getInstance(dateTimeZone) : time == Format.OFFSET_SAMPLE_RELATIVE ? JulianChronology.getInstance(dateTimeZone) : GJChronology.getInstance(dateTimeZone, time, 4);
            case 1:
            default:
                return super.b(obj, dateTimeZone);
            case 2:
                org.joda.time.a chronology = ((org.joda.time.h) obj).getChronology();
                if (chronology == null) {
                    return ISOChronology.getInstance(dateTimeZone);
                }
                if (chronology.getZone() == dateTimeZone) {
                    return chronology;
                }
                org.joda.time.a withZone = chronology.withZone(dateTimeZone);
                return withZone == null ? ISOChronology.getInstance(dateTimeZone) : withZone;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b1, bi.f
    public final long d(Object obj, org.joda.time.a aVar) {
        switch (this.f3264b) {
            case 0:
                return ((Calendar) obj).getTime().getTime();
            case 1:
                return ((Date) obj).getTime();
            default:
                return ((org.joda.time.h) obj).getMillis();
        }
    }

    @Override // bi.b
    public final Class e() {
        switch (this.f3264b) {
            case 0:
                return Calendar.class;
            case 1:
                return Date.class;
            default:
                return org.joda.time.h.class;
        }
    }
}
