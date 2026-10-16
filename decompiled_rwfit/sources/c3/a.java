package c3;

import a2.h;
import android.os.SystemClock;
import com.amap.location.support.bean.cell.AmapCell;
import com.amap.location.support.bean.cell.AmapCellCdma;
import com.amap.location.support.bean.cell.AmapCellGsm;
import com.amap.location.support.bean.cell.AmapCellLte;
import com.amap.location.support.bean.cell.AmapCellWcdma;
import g3.f;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a extends h {
    public final int D(d3.a aVar) {
        int i3;
        int i10;
        ArrayList arrayList;
        int[] iArr;
        int i11;
        byte b3;
        int i12 = 1;
        ArrayList arrayList2 = aVar.f12222f;
        if (arrayList2 != null && arrayList2.size() != 0) {
            int size = arrayList2.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj = arrayList2.get(i13);
                i13++;
                AmapCell amapCell = (AmapCell) obj;
                if (amapCell instanceof AmapCellGsm) {
                    AmapCellGsm amapCellGsm = (AmapCellGsm) amapCell;
                    amapCell.age = f.a(f.b(amapCellGsm.lac, amapCellGsm.cid));
                } else if (amapCell instanceof AmapCellLte) {
                    AmapCellLte amapCellLte = (AmapCellLte) amapCell;
                    amapCell.age = f.a(f.b(amapCellLte.tac, amapCellLte.f6569ci));
                } else if (amapCell instanceof AmapCellWcdma) {
                    AmapCellWcdma amapCellWcdma = (AmapCellWcdma) amapCell;
                    amapCell.age = f.a(f.b(amapCellWcdma.lac, amapCellWcdma.cid));
                } else if (amapCell instanceof AmapCellCdma) {
                    AmapCellCdma amapCellCdma = (AmapCellCdma) amapCell;
                    amapCell.age = f.a(f.b(amapCellCdma.nid, amapCellCdma.bid));
                }
            }
        }
        ArrayList arrayList3 = aVar.f12222f;
        int size2 = arrayList3.size();
        int[] iArr2 = new int[size2];
        int i14 = 0;
        while (true) {
            b bVar = (b) this.f36a;
            if (i14 >= size2) {
                int i15 = i12;
                int[] iArr3 = iArr2;
                int i16 = bVar.i(aVar.f12219b);
                int i17 = f3.a.f12656n;
                bVar.s(4, size2, 4);
                for (int i18 = size2 - i15; i18 >= 0; i18--) {
                    bVar.e(iArr3[i18]);
                }
                int k10 = bVar.k();
                ArrayList arrayList4 = aVar.f12223g;
                int size3 = arrayList4.size();
                int[] iArr4 = new int[size3];
                for (int i19 = 0; i19 < size3; i19++) {
                    AmapCell amapCell2 = (AmapCell) arrayList4.get(i19);
                    long elapsedRealtime = (SystemClock.elapsedRealtime() - amapCell2.lastUpdateSystemMills) / 1000;
                    if (elapsedRealtime > 32767 || elapsedRealtime < 0) {
                        elapsedRealtime = 32767;
                    }
                    if (amapCell2 instanceof AmapCellGsm) {
                        AmapCellGsm amapCellGsm2 = (AmapCellGsm) amapCell2;
                        i10 = 1;
                        i3 = f3.a.b(bVar, (byte) 1, amapCellGsm2.lac, amapCellGsm2.cid, (short) elapsedRealtime);
                    } else if (amapCell2 instanceof AmapCellLte) {
                        AmapCellLte amapCellLte2 = (AmapCellLte) amapCell2;
                        i3 = f3.a.b(bVar, (byte) 1, amapCellLte2.tac, amapCellLte2.f6569ci, (short) elapsedRealtime);
                        i10 = 1;
                    } else {
                        if (amapCell2 instanceof AmapCellCdma) {
                            AmapCellCdma amapCellCdma2 = (AmapCellCdma) amapCell2;
                            int i20 = amapCellCdma2.sid;
                            int i21 = amapCellCdma2.nid;
                            int i22 = amapCellCdma2.bid;
                            int i23 = f3.a.f12656n;
                            bVar.r(5);
                            bVar.c(3, i22);
                            bVar.c(2, i21);
                            bVar.c(1, i20);
                            bVar.h((short) elapsedRealtime, 4);
                            bVar.b((byte) 2, 0);
                            i3 = bVar.j();
                            i10 = 2;
                        } else if (amapCell2 instanceof AmapCellWcdma) {
                            AmapCellWcdma amapCellWcdma2 = (AmapCellWcdma) amapCell2;
                            i3 = f3.a.b(bVar, (byte) 1, amapCellWcdma2.lac, amapCellWcdma2.cid, (short) elapsedRealtime);
                            i10 = 1;
                        } else {
                            i3 = 0;
                            i10 = 0;
                        }
                        int i24 = f3.a.f12656n;
                        bVar.r(2);
                        bVar.f(1, i3);
                        bVar.b((byte) i10, 0);
                        iArr4[i19] = bVar.j();
                    }
                    int i242 = f3.a.f12656n;
                    bVar.r(2);
                    bVar.f(1, i3);
                    bVar.b((byte) i10, 0);
                    iArr4[i19] = bVar.j();
                }
                bVar.s(4, size3, 4);
                for (int i25 = size3 - 1; i25 >= 0; i25--) {
                    bVar.e(iArr4[i25]);
                }
                int k11 = bVar.k();
                byte b10 = aVar.f12218a;
                bVar.r(4);
                bVar.f(3, k11);
                bVar.f(2, k10);
                bVar.f(0, i16);
                bVar.b(b10, 1);
                return bVar.j();
            }
            AmapCell amapCell3 = (AmapCell) arrayList3.get(i14);
            if (amapCell3 instanceof AmapCellGsm) {
                AmapCellGsm amapCellGsm3 = (AmapCellGsm) amapCell3;
                if (amapCellGsm3.newApi) {
                    int mccInt = amapCellGsm3.getMccInt();
                    int mncInt = amapCellGsm3.getMncInt();
                    int i26 = amapCellGsm3.lac;
                    int i27 = amapCellGsm3.cid;
                    int i28 = amapCellGsm3.signalStrength;
                    int i29 = amapCellGsm3.arfcn;
                    int i30 = amapCellGsm3.bsic;
                    arrayList = arrayList3;
                    int i31 = amapCellGsm3.asuLevel;
                    int i32 = amapCellGsm3.psc;
                    int i33 = f3.a.f12656n;
                    iArr = iArr2;
                    bVar.r(9);
                    bVar.c(8, i32);
                    bVar.c(7, i31);
                    bVar.c(6, i30);
                    bVar.c(5, i29);
                    bVar.c(4, i28);
                    bVar.c(3, i27);
                    bVar.c(2, i26);
                    bVar.c(1, mncInt);
                    bVar.c(0, mccInt);
                    i11 = bVar.j();
                } else {
                    int i34 = amapCellGsm3.lac;
                    int i35 = amapCellGsm3.cid;
                    int i36 = amapCellGsm3.signalStrength;
                    int i37 = amapCellGsm3.psc;
                    int i38 = f3.a.f12656n;
                    bVar.r(9);
                    bVar.c(4, i36);
                    bVar.c(3, i35);
                    bVar.c(2, i34);
                    bVar.c(8, i37);
                    i11 = bVar.j();
                    arrayList = arrayList3;
                    iArr = iArr2;
                }
                b3 = 1;
            } else {
                arrayList = arrayList3;
                iArr = iArr2;
                if (amapCell3 instanceof AmapCellLte) {
                    AmapCellLte amapCellLte3 = (AmapCellLte) amapCell3;
                    int mccInt2 = amapCellLte3.getMccInt();
                    int mncInt2 = amapCellLte3.getMncInt();
                    int i39 = amapCellLte3.tac;
                    int i40 = amapCellLte3.f6569ci;
                    int i41 = amapCellLte3.pci;
                    int i42 = amapCellLte3.signalStrength;
                    int i43 = amapCellLte3.earfcn;
                    int i44 = amapCellLte3.asuLevel;
                    int i45 = f3.a.f12656n;
                    bVar.r(8);
                    bVar.c(7, i44);
                    bVar.c(6, i43);
                    bVar.c(5, i42);
                    bVar.c(4, i41);
                    bVar.c(3, i40);
                    bVar.c(2, i39);
                    bVar.c(1, mncInt2);
                    bVar.c(0, mccInt2);
                    i11 = bVar.j();
                    b3 = 3;
                } else if (amapCell3 instanceof AmapCellCdma) {
                    AmapCellCdma amapCellCdma3 = (AmapCellCdma) amapCell3;
                    if (amapCellCdma3.newApi) {
                        int i46 = amapCellCdma3.sid;
                        int i47 = amapCellCdma3.nid;
                        int i48 = amapCellCdma3.bid;
                        int i49 = amapCellCdma3.latitude;
                        int i50 = amapCellCdma3.longitude;
                        int i51 = amapCellCdma3.signalStrength;
                        int i52 = amapCellCdma3.asuLevel;
                        int i53 = f3.a.f12656n;
                        bVar.r(7);
                        bVar.c(6, i52);
                        bVar.c(5, i51);
                        bVar.c(4, i50);
                        bVar.c(3, i49);
                        bVar.c(2, i48);
                        bVar.c(1, i47);
                        bVar.c(0, i46);
                        i11 = bVar.j();
                    } else {
                        int i54 = amapCellCdma3.sid;
                        int i55 = amapCellCdma3.nid;
                        int i56 = amapCellCdma3.bid;
                        int i57 = amapCellCdma3.latitude;
                        int i58 = amapCellCdma3.longitude;
                        int i59 = amapCellCdma3.signalStrength;
                        int i60 = f3.a.f12656n;
                        bVar.r(7);
                        bVar.c(5, i59);
                        bVar.c(4, i58);
                        bVar.c(3, i57);
                        bVar.c(2, i56);
                        bVar.c(1, i55);
                        bVar.c(0, i54);
                        i11 = bVar.j();
                    }
                    b3 = 2;
                } else if (amapCell3 instanceof AmapCellWcdma) {
                    AmapCellWcdma amapCellWcdma3 = (AmapCellWcdma) amapCell3;
                    int mccInt3 = amapCellWcdma3.getMccInt();
                    int mncInt3 = amapCellWcdma3.getMncInt();
                    int i61 = amapCellWcdma3.lac;
                    int i62 = amapCellWcdma3.cid;
                    int i63 = amapCellWcdma3.psc;
                    int i64 = amapCellWcdma3.signalStrength;
                    int i65 = amapCellWcdma3.uarfcn;
                    int i66 = amapCellWcdma3.asuLevel;
                    int i67 = f3.a.f12656n;
                    bVar.r(8);
                    bVar.c(7, i66);
                    bVar.c(6, i65);
                    bVar.c(5, i64);
                    bVar.c(4, i63);
                    bVar.c(3, i62);
                    bVar.c(2, i61);
                    bVar.c(1, mncInt3);
                    bVar.c(0, mccInt3);
                    i11 = bVar.j();
                    b3 = 4;
                } else {
                    i11 = -1;
                    b3 = 0;
                }
            }
            if (i11 == -1) {
                return -1;
            }
            byte b11 = amapCell3.main ? (byte) 1 : (byte) 0;
            byte b12 = amapCell3.newApi ? (byte) 1 : (byte) 0;
            short s7 = (short) amapCell3.age;
            int i68 = f3.a.f12656n;
            bVar.r(5);
            bVar.f(4, i11);
            bVar.h(s7, 2);
            bVar.b(b3, 3);
            bVar.b(b12, 1);
            bVar.b(b11, 0);
            iArr[i14] = bVar.j();
            i14++;
            i12 = 1;
            arrayList3 = arrayList;
            iArr2 = iArr;
        }
    }

    public final int E(j3.a aVar) {
        long j4 = aVar.f15323h;
        long j10 = aVar.f15317a;
        int i3 = (int) (aVar.f15319c * 1000000.0d);
        int i10 = (int) (aVar.f15318b * 1000000.0d);
        int i11 = (int) aVar.f15320d;
        int i12 = (int) aVar.f15322g;
        int i13 = (int) aVar.e;
        short s7 = (short) aVar.f15321f;
        byte b3 = aVar.f15324i;
        int i14 = f3.a.f12656n;
        b bVar = (b) this.f36a;
        bVar.r(10);
        bVar.d(1, j4);
        bVar.d(0, j10);
        bVar.c(6, i13);
        bVar.c(5, i12);
        bVar.c(4, i11);
        bVar.c(3, i10);
        bVar.c(2, i3);
        bVar.h(s7, 7);
        bVar.b(b3, 8);
        return bVar.j();
    }

    public final int F(long j4, ArrayList arrayList) {
        short a3;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            k3.a aVar = (k3.a) obj;
            long j10 = aVar.f15455a;
            synchronized (f.class) {
                a3 = g3.c.a(g3.c.c().f13800c, j10);
            }
            aVar.f15460g = a3;
        }
        int size2 = arrayList.size();
        if (size2 <= 0) {
            return -1;
        }
        int[] iArr = new int[size2];
        for (int i10 = 0; i10 < size2; i10++) {
            k3.a aVar2 = (k3.a) arrayList.get(i10);
            int i11 = ((b) this.f36a).i(aVar2.f15456b);
            long j11 = aVar2.f15455a;
            int i12 = (j11 != j4 || j11 == -1) ? 0 : 1;
            b bVar = (b) this.f36a;
            short s7 = (short) aVar2.f15457c;
            short s8 = aVar2.f15460g;
            short s10 = (short) aVar2.f15458d;
            int i13 = f3.a.f12656n;
            bVar.r(6);
            bVar.d(1, j11);
            bVar.f(3, i11);
            bVar.h(s10, 5);
            bVar.h(s8, 4);
            bVar.h(s7, 2);
            if (i12 != 0) {
                bVar.o(1, 0);
                ByteBuffer byteBuffer = bVar.f19590a;
                int i14 = bVar.f19591b - 1;
                bVar.f19591b = i14;
                byteBuffer.put(i14, (byte) i12);
                bVar.q(0);
            }
            iArr[i10] = bVar.j();
        }
        b bVar2 = (b) this.f36a;
        int i15 = f3.a.f12656n;
        bVar2.s(4, size2, 4);
        for (int i16 = size2 - 1; i16 >= 0; i16--) {
            bVar2.e(iArr[i16]);
        }
        int k10 = bVar2.k();
        b bVar3 = (b) this.f36a;
        bVar3.r(1);
        bVar3.f(0, k10);
        return bVar3.j();
    }
}
