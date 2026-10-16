package org.joda.time;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.format.u;
import org.joda.time.tz.FixedDateTimeZone;

/* loaded from: classes2.dex */
public abstract class DateTimeZone implements Serializable {
    public static final String DEFAULT_TZ_DATA_PATH = "org/joda/time/tz/data";
    public static final DateTimeZone UTC = UTCDateTimeZone.INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f16985a = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference f16986b = new AtomicReference();

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference f16987c = new AtomicReference();
    private static final long serialVersionUID = 5546345482340108586L;
    private final String iID;

    public static final class Stub implements Serializable {
        private static final long serialVersionUID = -6471952376487863581L;

        /* renamed from: a, reason: collision with root package name */
        public transient String f16988a;

        public Stub(String str) {
            this.f16988a = str;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            this.f16988a = objectInputStream.readUTF();
        }

        private Object readResolve() throws ObjectStreamException {
            return DateTimeZone.forID(this.f16988a);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeUTF(this.f16988a);
        }
    }

    public DateTimeZone(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        this.iID = str;
    }

    public static org.joda.time.tz.f a() {
        org.joda.time.tz.f fVar = null;
        try {
            String property = System.getProperty("org.joda.time.DateTimeZone.NameProvider");
            if (property != null) {
                try {
                    Class<?> cls = Class.forName(property, false, DateTimeZone.class.getClassLoader());
                    if (!org.joda.time.tz.f.class.isAssignableFrom(cls)) {
                        throw new IllegalArgumentException("System property referred to class that does not implement " + org.joda.time.tz.f.class);
                    }
                    fVar = (org.joda.time.tz.f) cls.asSubclass(org.joda.time.tz.f.class).getConstructor(null).newInstance(null);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SecurityException unused) {
        }
        if (fVar != null) {
            return fVar;
        }
        org.joda.time.tz.e eVar = new org.joda.time.tz.e();
        eVar.f17275a = org.joda.time.tz.e.a();
        eVar.f17276b = org.joda.time.tz.e.a();
        return eVar;
    }

    public static org.joda.time.tz.g b() {
        try {
            String property = System.getProperty("org.joda.time.DateTimeZone.Provider");
            if (property != null) {
                try {
                    Class<?> cls = Class.forName(property, false, DateTimeZone.class.getClassLoader());
                    if (org.joda.time.tz.g.class.isAssignableFrom(cls)) {
                        org.joda.time.tz.g gVar = (org.joda.time.tz.g) cls.asSubclass(org.joda.time.tz.g.class).getConstructor(null).newInstance(null);
                        d(gVar);
                        return gVar;
                    }
                    throw new IllegalArgumentException("System property referred to class that does not implement " + org.joda.time.tz.g.class);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SecurityException unused) {
        }
        try {
            String property2 = System.getProperty("org.joda.time.DateTimeZone.Folder");
            if (property2 != null) {
                try {
                    org.joda.time.tz.k kVar = new org.joda.time.tz.k(new File(property2));
                    d(kVar);
                    return kVar;
                } catch (Exception e10) {
                    throw new RuntimeException(e10);
                }
            }
        } catch (SecurityException unused2) {
        }
        try {
            org.joda.time.tz.k kVar2 = new org.joda.time.tz.k();
            d(kVar2);
            return kVar2;
        } catch (Exception e11) {
            e11.printStackTrace();
            return new org.joda.time.tz.h();
        }
    }

    public static String c(int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i3 >= 0) {
            stringBuffer.append('+');
        } else {
            stringBuffer.append('-');
            i3 = -i3;
        }
        int i10 = i3 / 3600000;
        u.b(stringBuffer, i10, 2);
        int i11 = i3 - (i10 * 3600000);
        int i12 = i11 / 60000;
        stringBuffer.append(':');
        u.b(stringBuffer, i12, 2);
        int i13 = i11 - (i12 * 60000);
        if (i13 == 0) {
            return stringBuffer.toString();
        }
        int i14 = i13 / 1000;
        stringBuffer.append(':');
        u.b(stringBuffer, i14, 2);
        int i15 = i13 - (i14 * 1000);
        if (i15 == 0) {
            return stringBuffer.toString();
        }
        stringBuffer.append('.');
        u.b(stringBuffer, i15, 3);
        return stringBuffer.toString();
    }

    public static void d(org.joda.time.tz.g gVar) {
        Set b3 = gVar.b();
        if (b3 == null || b3.size() == 0) {
            throw new IllegalArgumentException("The provider doesn't have any available ids");
        }
        if (!b3.contains("UTC")) {
            throw new IllegalArgumentException("The provider doesn't support UTC");
        }
        if (!UTC.equals(gVar.a("UTC"))) {
            throw new IllegalArgumentException("Invalid UTC zone provided");
        }
    }

    @FromString
    public static DateTimeZone forID(String str) {
        if (str == null) {
            return getDefault();
        }
        if (str.equals("UTC")) {
            return UTC;
        }
        DateTimeZone a3 = getProvider().a(str);
        if (a3 != null) {
            return a3;
        }
        if (!str.startsWith("+") && !str.startsWith("-")) {
            throw new IllegalArgumentException(l0.o("The datetime zone id '", str, "' is not recognised"));
        }
        int i3 = -((int) d.f17125b.c(str));
        if (i3 == 0) {
            return UTC;
        }
        return i3 == 0 ? UTC : new FixedDateTimeZone(c(i3), null, i3, i3);
    }

    public static DateTimeZone forOffsetHours(int i3) throws IllegalArgumentException {
        return forOffsetHoursMinutes(i3, 0);
    }

    public static DateTimeZone forOffsetHoursMinutes(int i3, int i10) throws IllegalArgumentException {
        if (i3 == 0 && i10 == 0) {
            return UTC;
        }
        if (i3 < -23 || i3 > 23) {
            throw new IllegalArgumentException(l0.j(i3, "Hours out of range: "));
        }
        if (i10 < -59 || i10 > 59) {
            throw new IllegalArgumentException(l0.j(i10, "Minutes out of range: "));
        }
        if (i3 > 0 && i10 < 0) {
            throw new IllegalArgumentException(l0.j(i10, "Positive hours must not have negative minutes: "));
        }
        int i11 = i3 * 60;
        try {
            return forOffsetMillis(nf.e(i11 < 0 ? i11 - Math.abs(i10) : i11 + i10, 60000));
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Offset is too large");
        }
    }

    public static DateTimeZone forOffsetMillis(int i3) {
        if (i3 < -86399999 || i3 > 86399999) {
            throw new IllegalArgumentException(l0.j(i3, "Millis out of range: "));
        }
        return i3 == 0 ? UTC : new FixedDateTimeZone(c(i3), null, i3, i3);
    }

    public static DateTimeZone forTimeZone(TimeZone timeZone) {
        char charAt;
        if (timeZone == null) {
            return getDefault();
        }
        String id2 = timeZone.getID();
        if (id2 == null) {
            throw new IllegalArgumentException("The TimeZone id must not be null");
        }
        if (id2.equals("UTC")) {
            return UTC;
        }
        String str = (String) d.f17124a.get(id2);
        org.joda.time.tz.g provider = getProvider();
        DateTimeZone a3 = str != null ? provider.a(str) : null;
        if (a3 == null) {
            a3 = provider.a(id2);
        }
        if (a3 != null) {
            return a3;
        }
        if (str != null || (!id2.startsWith("GMT+") && !id2.startsWith("GMT-"))) {
            throw new IllegalArgumentException(l0.o("The datetime zone id '", id2, "' is not recognised"));
        }
        String substring = id2.substring(3);
        if (substring.length() > 2 && (charAt = substring.charAt(1)) > '9' && Character.isDigit(charAt)) {
            StringBuilder sb2 = new StringBuilder(substring);
            for (int i3 = 0; i3 < sb2.length(); i3++) {
                int digit = Character.digit(sb2.charAt(i3), 10);
                if (digit >= 0) {
                    sb2.setCharAt(i3, (char) (digit + 48));
                }
            }
            substring = sb2.toString();
        }
        int i10 = -((int) d.f17125b.c(substring));
        if (i10 == 0) {
            return UTC;
        }
        return i10 == 0 ? UTC : new FixedDateTimeZone(c(i10), null, i10, i10);
    }

    public static Set<String> getAvailableIDs() {
        return getProvider().b();
    }

    public static DateTimeZone getDefault() {
        AtomicReference atomicReference = f16987c;
        DateTimeZone dateTimeZone = (DateTimeZone) atomicReference.get();
        if (dateTimeZone != null) {
            return dateTimeZone;
        }
        try {
            String property = System.getProperty("user.timezone");
            if (property != null) {
                dateTimeZone = forID(property);
            }
        } catch (RuntimeException unused) {
        }
        if (dateTimeZone == null) {
            try {
                dateTimeZone = forTimeZone(TimeZone.getDefault());
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (dateTimeZone == null) {
            dateTimeZone = UTC;
        }
        DateTimeZone dateTimeZone2 = dateTimeZone;
        while (!atomicReference.compareAndSet(null, dateTimeZone2)) {
            if (atomicReference.get() != null) {
                return (DateTimeZone) atomicReference.get();
            }
        }
        return dateTimeZone2;
    }

    public static org.joda.time.tz.f getNameProvider() {
        AtomicReference atomicReference = f16986b;
        org.joda.time.tz.f fVar = (org.joda.time.tz.f) atomicReference.get();
        if (fVar != null) {
            return fVar;
        }
        org.joda.time.tz.f a3 = a();
        while (!atomicReference.compareAndSet(null, a3)) {
            if (atomicReference.get() != null) {
                return (org.joda.time.tz.f) atomicReference.get();
            }
        }
        return a3;
    }

    public static org.joda.time.tz.g getProvider() {
        AtomicReference atomicReference = f16985a;
        org.joda.time.tz.g gVar = (org.joda.time.tz.g) atomicReference.get();
        if (gVar != null) {
            return gVar;
        }
        org.joda.time.tz.g b3 = b();
        while (!atomicReference.compareAndSet(null, b3)) {
            if (atomicReference.get() != null) {
                return (org.joda.time.tz.g) atomicReference.get();
            }
        }
        return b3;
    }

    public static void setDefault(DateTimeZone dateTimeZone) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setDefault"));
        }
        if (dateTimeZone == null) {
            throw new IllegalArgumentException("The datetime zone must not be null");
        }
        f16987c.set(dateTimeZone);
    }

    public static void setNameProvider(org.joda.time.tz.f fVar) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setNameProvider"));
        }
        if (fVar == null) {
            fVar = a();
        }
        f16986b.set(fVar);
    }

    public static void setProvider(org.joda.time.tz.g gVar) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setProvider"));
        }
        if (gVar == null) {
            gVar = b();
        } else {
            d(gVar);
        }
        f16985a.set(gVar);
    }

    public long adjustOffset(long j4, boolean z5) {
        long j10 = j4 - 10800000;
        long offset = getOffset(j10);
        long offset2 = getOffset(10800000 + j4);
        if (offset <= offset2) {
            return j4;
        }
        long j11 = offset - offset2;
        long nextTransition = nextTransition(j10);
        long j12 = nextTransition - j11;
        return (j4 < j12 || j4 >= nextTransition + j11) ? j4 : j4 - j12 >= j11 ? z5 ? j4 : j4 - j11 : z5 ? j4 + j11 : j4;
    }

    public long convertLocalToUTC(long j4, boolean z5, long j10) {
        int offset = getOffset(j10);
        long j11 = j4 - offset;
        return getOffset(j11) == offset ? j11 : convertLocalToUTC(j4, z5);
    }

    public long convertUTCToLocal(long j4) {
        long offset = getOffset(j4);
        long j10 = j4 + offset;
        if ((j4 ^ j10) >= 0 || (j4 ^ offset) < 0) {
            return j10;
        }
        throw new ArithmeticException("Adding time zone offset caused overflow");
    }

    public abstract boolean equals(Object obj);

    @ToString
    public final String getID() {
        return this.iID;
    }

    public long getMillisKeepLocal(DateTimeZone dateTimeZone, long j4) {
        if (dateTimeZone == null) {
            dateTimeZone = getDefault();
        }
        DateTimeZone dateTimeZone2 = dateTimeZone;
        return dateTimeZone2 == this ? j4 : dateTimeZone2.convertLocalToUTC(convertUTCToLocal(j4), false, j4);
    }

    public final String getName(long j4) {
        return getName(j4, null);
    }

    public abstract String getNameKey(long j4);

    public abstract int getOffset(long j4);

    public final int getOffset(h hVar) {
        if (hVar != null) {
            return getOffset(hVar.getMillis());
        }
        AtomicReference atomicReference = c.f17022a;
        return getOffset(System.currentTimeMillis());
    }

    public int getOffsetFromLocal(long j4) {
        int offset = getOffset(j4);
        long j10 = j4 - offset;
        int offset2 = getOffset(j10);
        if (offset != offset2) {
            if (offset - offset2 < 0) {
                long nextTransition = nextTransition(j10);
                long j11 = Format.OFFSET_SAMPLE_RELATIVE;
                if (nextTransition == j10) {
                    nextTransition = Long.MAX_VALUE;
                }
                long j12 = j4 - offset2;
                long nextTransition2 = nextTransition(j12);
                if (nextTransition2 != j12) {
                    j11 = nextTransition2;
                }
                if (nextTransition != j11) {
                    return offset;
                }
            }
        } else if (offset >= 0) {
            long previousTransition = previousTransition(j10);
            if (previousTransition < j10) {
                int offset3 = getOffset(previousTransition);
                if (j10 - previousTransition <= offset3 - offset) {
                    return offset3;
                }
            }
        }
        return offset2;
    }

    public final String getShortName(long j4) {
        return getShortName(j4, null);
    }

    public abstract int getStandardOffset(long j4);

    public int hashCode() {
        return getID().hashCode() + 57;
    }

    public abstract boolean isFixed();

    public boolean isLocalDateTimeGap(LocalDateTime localDateTime) {
        if (isFixed()) {
            return false;
        }
        try {
            localDateTime.toDateTime(this);
            return false;
        } catch (IllegalInstantException unused) {
            return true;
        }
    }

    public boolean isStandardOffset(long j4) {
        return getOffset(j4) == getStandardOffset(j4);
    }

    public abstract long nextTransition(long j4);

    public abstract long previousTransition(long j4);

    public String toString() {
        return getID();
    }

    public TimeZone toTimeZone() {
        return TimeZone.getTimeZone(this.iID);
    }

    public Object writeReplace() throws ObjectStreamException {
        return new Stub(this.iID);
    }

    public String getName(long j4, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String nameKey = getNameKey(j4);
        if (nameKey == null) {
            return this.iID;
        }
        org.joda.time.tz.f nameProvider = getNameProvider();
        String str = null;
        if (nameProvider instanceof org.joda.time.tz.e) {
            String[] c9 = ((org.joda.time.tz.e) nameProvider).c(locale, this.iID, nameKey, isStandardOffset(j4));
            if (c9 != null) {
                str = c9[1];
            }
        } else {
            String[] b3 = ((org.joda.time.tz.e) nameProvider).b(locale, this.iID, nameKey);
            if (b3 != null) {
                str = b3[1];
            }
        }
        return str != null ? str : c(getOffset(j4));
    }

    public String getShortName(long j4, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String nameKey = getNameKey(j4);
        if (nameKey == null) {
            return this.iID;
        }
        org.joda.time.tz.f nameProvider = getNameProvider();
        String str = null;
        if (nameProvider instanceof org.joda.time.tz.e) {
            String[] c9 = ((org.joda.time.tz.e) nameProvider).c(locale, this.iID, nameKey, isStandardOffset(j4));
            if (c9 != null) {
                str = c9[0];
            }
        } else {
            String[] b3 = ((org.joda.time.tz.e) nameProvider).b(locale, this.iID, nameKey);
            if (b3 != null) {
                str = b3[0];
            }
        }
        return str != null ? str : c(getOffset(j4));
    }

    public long convertLocalToUTC(long j4, boolean z5) {
        long j10;
        int offset = getOffset(j4);
        long j11 = j4 - offset;
        int offset2 = getOffset(j11);
        if (offset != offset2 && (z5 || offset < 0)) {
            long nextTransition = nextTransition(j11);
            long j12 = Format.OFFSET_SAMPLE_RELATIVE;
            if (nextTransition == j11) {
                nextTransition = Long.MAX_VALUE;
            }
            long j13 = j4 - offset2;
            long nextTransition2 = nextTransition(j13);
            if (nextTransition2 != j13) {
                j12 = nextTransition2;
            }
            if (nextTransition != j12) {
                if (z5) {
                    throw new IllegalInstantException(j4, getID());
                }
                long j14 = offset;
                j10 = j4 - j14;
                if ((j4 ^ j10) < 0 || (j4 ^ j14) >= 0) {
                    return j10;
                }
                throw new ArithmeticException("Subtracting time zone offset caused overflow");
            }
        }
        offset = offset2;
        long j142 = offset;
        j10 = j4 - j142;
        if ((j4 ^ j10) < 0) {
        }
        return j10;
    }
}
