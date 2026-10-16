package u1;

import com.autonavi.aps.amapapi.config.Const;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f18837a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18838b;

    /* renamed from: c, reason: collision with root package name */
    public final long f18839c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f18840d;

    public c(int i3, int i10, byte[] bArr) {
        this(-1L, bArr, i3, i10);
    }

    public static c a(String str) {
        byte[] bytes = str.concat("\u0000").getBytes(g.M);
        return new c(2, bytes.length, bytes);
    }

    public static c b(long j4, ByteOrder byteOrder) {
        long[] jArr = {j4};
        ByteBuffer wrap = ByteBuffer.wrap(new byte[g.D[4] * jArr.length]);
        wrap.order(byteOrder);
        for (long j10 : jArr) {
            wrap.putInt((int) j10);
        }
        return new c(4, jArr.length, wrap.array());
    }

    public static c c(e[] eVarArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[g.D[5] * eVarArr.length]);
        wrap.order(byteOrder);
        for (e eVar : eVarArr) {
            wrap.putInt((int) eVar.f18845a);
            wrap.putInt((int) eVar.f18846b);
        }
        return new c(5, eVarArr.length, wrap.array());
    }

    public static c d(int i3, ByteOrder byteOrder) {
        int[] iArr = {i3};
        ByteBuffer wrap = ByteBuffer.wrap(new byte[g.D[3] * iArr.length]);
        wrap.order(byteOrder);
        for (int i10 : iArr) {
            wrap.putShort((short) i10);
        }
        return new c(3, iArr.length, wrap.array());
    }

    public final double e(ByteOrder byteOrder) {
        Object h4 = h(byteOrder);
        if (h4 == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (h4 instanceof String) {
            return Double.parseDouble((String) h4);
        }
        if (h4 instanceof long[]) {
            if (((long[]) h4).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (h4 instanceof int[]) {
            if (((int[]) h4).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (h4 instanceof double[]) {
            double[] dArr = (double[]) h4;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(h4 instanceof e[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        e[] eVarArr = (e[]) h4;
        if (eVarArr.length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        e eVar = eVarArr[0];
        return eVar.f18845a / eVar.f18846b;
    }

    public final int f(ByteOrder byteOrder) {
        Object h4 = h(byteOrder);
        if (h4 == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (h4 instanceof String) {
            return Integer.parseInt((String) h4);
        }
        if (h4 instanceof long[]) {
            long[] jArr = (long[]) h4;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(h4 instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) h4;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public final String g(ByteOrder byteOrder) {
        Object h4 = h(byteOrder);
        if (h4 == null) {
            return null;
        }
        if (h4 instanceof String) {
            return (String) h4;
        }
        StringBuilder sb2 = new StringBuilder();
        int i3 = 0;
        if (h4 instanceof long[]) {
            long[] jArr = (long[]) h4;
            while (i3 < jArr.length) {
                sb2.append(jArr[i3]);
                i3++;
                if (i3 != jArr.length) {
                    sb2.append(Const.STR_MART_COMMA);
                }
            }
            return sb2.toString();
        }
        if (h4 instanceof int[]) {
            int[] iArr = (int[]) h4;
            while (i3 < iArr.length) {
                sb2.append(iArr[i3]);
                i3++;
                if (i3 != iArr.length) {
                    sb2.append(Const.STR_MART_COMMA);
                }
            }
            return sb2.toString();
        }
        if (h4 instanceof double[]) {
            double[] dArr = (double[]) h4;
            while (i3 < dArr.length) {
                sb2.append(dArr[i3]);
                i3++;
                if (i3 != dArr.length) {
                    sb2.append(Const.STR_MART_COMMA);
                }
            }
            return sb2.toString();
        }
        if (!(h4 instanceof e[])) {
            return null;
        }
        e[] eVarArr = (e[]) h4;
        while (i3 < eVarArr.length) {
            sb2.append(eVarArr[i3].f18845a);
            sb2.append('/');
            sb2.append(eVarArr[i3].f18846b);
            i3++;
            if (i3 != eVarArr.length) {
                sb2.append(Const.STR_MART_COMMA);
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0033: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:162:0x0033 */
    /* JADX WARN: Removed duplicated region for block: B:165:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v22, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v23, types: [java.io.Serializable, long[]] */
    /* JADX WARN: Type inference failed for: r15v24, types: [java.io.Serializable, u1.e[]] */
    /* JADX WARN: Type inference failed for: r15v25, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v26, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v27, types: [java.io.Serializable, u1.e[]] */
    /* JADX WARN: Type inference failed for: r15v28, types: [double[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r15v29, types: [double[], java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable h(java.nio.ByteOrder r15) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.c.h(java.nio.ByteOrder):java.io.Serializable");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("(");
        sb2.append(g.C[this.f18837a]);
        sb2.append(", data length:");
        return r5.a.e(sb2, this.f18840d.length, ")");
    }

    public c(long j4, byte[] bArr, int i3, int i10) {
        this.f18837a = i3;
        this.f18838b = i10;
        this.f18839c = j4;
        this.f18840d = bArr;
    }
}
