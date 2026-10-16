package org.joda.time.chrono;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public final class ISOChronology extends AssembledChronology {
    public static final ISOChronology K;
    public static final ConcurrentHashMap L;
    private static final long serialVersionUID = -6212696554273812441L;

    public static final class Stub implements Serializable {
        private static final long serialVersionUID = -6212696554273812441L;

        /* renamed from: a, reason: collision with root package name */
        public transient DateTimeZone f17055a;

        public Stub(DateTimeZone dateTimeZone) {
            this.f17055a = dateTimeZone;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.f17055a = (DateTimeZone) objectInputStream.readObject();
        }

        private Object readResolve() {
            return ISOChronology.getInstance(this.f17055a);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.f17055a);
        }
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        L = concurrentHashMap;
        ISOChronology iSOChronology = new ISOChronology(GregorianChronology.getInstanceUTC(), null);
        K = iSOChronology;
        concurrentHashMap.put(DateTimeZone.UTC, iSOChronology);
    }

    public static ISOChronology getInstance() {
        return getInstance(DateTimeZone.getDefault());
    }

    public static ISOChronology getInstanceUTC() {
        return K;
    }

    private Object writeReplace() {
        return new Stub(getZone());
    }

    @Override // org.joda.time.chrono.AssembledChronology
    public void assemble(a aVar) {
        if (getBase().getZone() == DateTimeZone.UTC) {
            m mVar = m.f17115c;
            org.joda.time.field.d dVar = new org.joda.time.field.d(mVar, mVar.getRangeDurationField(), DateTimeFieldType.centuryOfEra());
            aVar.H = dVar;
            aVar.f17066k = dVar.f17133d;
            aVar.G = new org.joda.time.field.i(dVar, dVar.f17131b.getDurationField(), DateTimeFieldType.yearOfCentury());
            aVar.C = new org.joda.time.field.i((org.joda.time.field.d) aVar.H, aVar.f17063h, DateTimeFieldType.weekyearOfCentury());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ISOChronology) {
            return getZone().equals(((ISOChronology) obj).getZone());
        }
        return false;
    }

    public int hashCode() {
        return getZone().hashCode() + 800855;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public String toString() {
        DateTimeZone zone = getZone();
        if (zone == null) {
            return "ISOChronology";
        }
        return "ISOChronology[" + zone.getID() + ']';
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withUTC() {
        return K;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone);
    }

    public static ISOChronology getInstance(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap concurrentHashMap = L;
        ISOChronology iSOChronology = (ISOChronology) concurrentHashMap.get(dateTimeZone);
        if (iSOChronology == null) {
            iSOChronology = new ISOChronology(ZonedChronology.getInstance(K, dateTimeZone), null);
            ISOChronology iSOChronology2 = (ISOChronology) concurrentHashMap.putIfAbsent(dateTimeZone, iSOChronology);
            if (iSOChronology2 != null) {
                return iSOChronology2;
            }
        }
        return iSOChronology;
    }
}
