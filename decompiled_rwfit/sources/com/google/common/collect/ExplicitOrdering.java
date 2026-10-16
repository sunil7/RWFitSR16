package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class ExplicitOrdering<T> extends z1 implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> rankMap;

    public ExplicitOrdering(ImmutableMap<T, Integer> immutableMap) {
        this.rankMap = immutableMap;
    }

    @Override // java.util.Comparator
    public int compare(final T t8, final T t10) {
        Integer num = this.rankMap.get(t8);
        if (num == null) {
            throw new ClassCastException(t8) { // from class: com.google.common.collect.Ordering$IncomparableValueException
                private static final long serialVersionUID = 0;
                final Object value;

                {
                    super("Cannot compare value: " + t8);
                    this.value = t8;
                }
            };
        }
        int intValue = num.intValue();
        Integer num2 = this.rankMap.get(t10);
        if (num2 != null) {
            return intValue - num2.intValue();
        }
        throw new ClassCastException(t10) { // from class: com.google.common.collect.Ordering$IncomparableValueException
            private static final long serialVersionUID = 0;
            final Object value;

            {
                super("Cannot compare value: " + t10);
                this.value = t10;
            }
        };
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.rankMap.equals(((ExplicitOrdering) obj).rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ExplicitOrdering(java.util.List<T> r9) {
        /*
            r8 = this;
            int r0 = r9.size()
            int r0 = r0 * 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.util.Iterator r9 = r9.iterator()
            r1 = 0
            r2 = r1
        Le:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L3c
            java.lang.Object r3 = r9.next()
            int r4 = r1 + 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r5 = r2 + 1
            int r6 = r5 * 2
            int r7 = r0.length
            if (r6 <= r7) goto L2e
            int r7 = r0.length
            int r6 = com.google.common.collect.h.i(r7, r6)
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r6)
        L2e:
            com.google.common.collect.h.c(r3, r1)
            int r2 = r2 * 2
            r0[r2] = r3
            int r2 = r2 + 1
            r0[r2] = r1
            r1 = r4
            r2 = r5
            goto Le
        L3c:
            com.google.common.collect.RegularImmutableMap r9 = com.google.common.collect.RegularImmutableMap.create(r2, r0)
            r8.<init>(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ExplicitOrdering.<init>(java.util.List):void");
    }
}
