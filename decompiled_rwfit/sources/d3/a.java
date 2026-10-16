package d3;

import com.amap.location.support.bean.cell.AmapCell;
import com.amap.location.support.bean.cell.AmapCellCdma;
import com.amap.location.support.bean.cell.AmapCellGsm;
import com.amap.location.support.bean.cell.AmapCellLte;
import com.amap.location.support.bean.cell.AmapCellWcdma;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public byte f12218a;

    /* renamed from: b, reason: collision with root package name */
    public String f12219b;

    /* renamed from: c, reason: collision with root package name */
    public AmapCell f12220c;

    /* renamed from: d, reason: collision with root package name */
    public AmapCell f12221d;
    public AmapCell e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f12222f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f12223g;

    public static boolean b(AmapCell amapCell, AmapCell amapCell2) {
        if (amapCell == null || amapCell2 == null) {
            return (amapCell == null) == (amapCell2 == null);
        }
        if ((amapCell instanceof AmapCellGsm) && (amapCell2 instanceof AmapCellGsm)) {
            AmapCellGsm amapCellGsm = (AmapCellGsm) amapCell;
            AmapCellGsm amapCellGsm2 = (AmapCellGsm) amapCell2;
            return amapCellGsm.lac == amapCellGsm2.lac && amapCellGsm.cid == amapCellGsm2.cid;
        }
        if ((amapCell instanceof AmapCellCdma) && (amapCell2 instanceof AmapCellCdma)) {
            AmapCellCdma amapCellCdma = (AmapCellCdma) amapCell;
            AmapCellCdma amapCellCdma2 = (AmapCellCdma) amapCell2;
            return amapCellCdma.bid == amapCellCdma2.bid && amapCellCdma.nid == amapCellCdma2.nid && amapCellCdma.sid == amapCellCdma2.sid;
        }
        if ((amapCell instanceof AmapCellLte) && (amapCell2 instanceof AmapCellLte)) {
            AmapCellLte amapCellLte = (AmapCellLte) amapCell;
            AmapCellLte amapCellLte2 = (AmapCellLte) amapCell2;
            return amapCellLte.tac == amapCellLte2.tac && amapCellLte.f6569ci == amapCellLte2.f6569ci;
        }
        if ((amapCell instanceof AmapCellWcdma) && (amapCell2 instanceof AmapCellWcdma)) {
            AmapCellWcdma amapCellWcdma = (AmapCellWcdma) amapCell;
            AmapCellWcdma amapCellWcdma2 = (AmapCellWcdma) amapCell2;
            if (amapCellWcdma.lac == amapCellWcdma2.lac && amapCellWcdma.cid == amapCellWcdma2.cid) {
                return true;
            }
        }
        return false;
    }

    public final void a() {
        this.f12218a = (byte) 0;
        this.f12219b = "";
        this.f12220c = null;
        this.f12221d = null;
        this.e = null;
        this.f12222f.clear();
        this.f12223g.clear();
    }

    public final String toString() {
        return "CellInfo{radio=" + ((int) this.f12218a) + ", operator='" + this.f12219b + "', mainCell=" + this.f12220c + ", mainOldInterCell=" + this.f12221d + ", mainNewInterCell=" + this.e + ", cells=" + this.f12222f + ", historyMainCellList=" + this.f12223g + '}';
    }
}
