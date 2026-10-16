package wh;

/* loaded from: classes2.dex */
public final class b {
    public static e a() {
        long j4;
        long j10;
        e eVar = e.head;
        kotlin.jvm.internal.e.c(eVar);
        e eVar2 = eVar.next;
        if (eVar2 != null) {
            long access$remainingNanos = e.access$remainingNanos(eVar2, System.nanoTime());
            if (access$remainingNanos > 0) {
                long j11 = access$remainingNanos / 1000000;
                e.class.wait(j11, (int) (access$remainingNanos - (1000000 * j11)));
                return null;
            }
            e eVar3 = e.head;
            kotlin.jvm.internal.e.c(eVar3);
            eVar3.next = eVar2.next;
            eVar2.next = null;
            return eVar2;
        }
        long nanoTime = System.nanoTime();
        j4 = e.IDLE_TIMEOUT_MILLIS;
        e.class.wait(j4);
        e eVar4 = e.head;
        kotlin.jvm.internal.e.c(eVar4);
        if (eVar4.next == null) {
            long nanoTime2 = System.nanoTime() - nanoTime;
            j10 = e.IDLE_TIMEOUT_NANOS;
            if (nanoTime2 >= j10) {
                return e.head;
            }
        }
        return null;
    }
}
