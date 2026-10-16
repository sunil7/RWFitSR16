package g3;

import com.amap.location.support.bean.cell.AmapCell;
import com.amap.location.support.bean.cell.AmapCellCdma;
import com.amap.location.support.bean.cell.AmapCellGsm;
import com.amap.location.support.bean.cell.AmapCellLte;
import com.amap.location.support.bean.cell.AmapCellWcdma;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f {
    public static synchronized short a(long j4) {
        short a3;
        synchronized (f.class) {
            a3 = c.a(c.c().f13798a, j4);
        }
        return a3;
    }

    public static long b(int i3, int i10) {
        return (i10 & 4294967295L) | ((i3 & 4294967295L) << 32);
    }

    public static synchronized void c(List list) {
        synchronized (f.class) {
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        ArrayList arrayList = new ArrayList(list.size());
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            AmapCell amapCell = (AmapCell) it.next();
                            if (amapCell instanceof AmapCellGsm) {
                                AmapCellGsm amapCellGsm = (AmapCellGsm) amapCell;
                                arrayList.add(new d(amapCellGsm.lac, amapCellGsm.cid, amapCellGsm.signalStrength));
                            } else if (amapCell instanceof AmapCellLte) {
                                AmapCellLte amapCellLte = (AmapCellLte) amapCell;
                                arrayList.add(new d(amapCellLte.tac, amapCellLte.f6569ci, amapCellLte.signalStrength));
                            } else if (amapCell instanceof AmapCellWcdma) {
                                AmapCellWcdma amapCellWcdma = (AmapCellWcdma) amapCell;
                                arrayList.add(new d(amapCellWcdma.lac, amapCellWcdma.cid, amapCellWcdma.signalStrength));
                            } else if (amapCell instanceof AmapCellCdma) {
                                AmapCellCdma amapCellCdma = (AmapCellCdma) amapCell;
                                arrayList.add(new d(amapCellCdma.nid, amapCellCdma.bid, amapCellCdma.signalStrength));
                            }
                        }
                        c.c().d(arrayList);
                    }
                } finally {
                }
            }
        }
    }
}
