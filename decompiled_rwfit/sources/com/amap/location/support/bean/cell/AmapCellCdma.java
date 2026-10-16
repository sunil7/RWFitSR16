package com.amap.location.support.bean.cell;

import android.support.v4.media.session.e;
import com.autonavi.aps.amapapi.config.Const;
import java.io.Serializable;

/* loaded from: classes.dex */
public class AmapCellCdma extends AmapCell implements Serializable {
    private static final long serialVersionUID = 1;
    public int bid;
    public int latitude;
    public int longitude;
    public int nid;
    public int sid;

    public AmapCellCdma() {
        this.sid = 0;
        this.nid = 0;
        this.bid = 0;
    }

    @Override // com.amap.location.support.bean.cell.AmapCell
    public String getKey() {
        return "2#" + this.sid + Const.STR_MART_WELL + this.nid + Const.STR_MART_WELL + this.bid;
    }

    @Override // com.amap.location.support.bean.cell.AmapCell
    public String toString() {
        StringBuilder sb2 = new StringBuilder("AmapCellCdma{sid=");
        sb2.append(this.sid);
        sb2.append(", nid=");
        sb2.append(this.nid);
        sb2.append(", bid=");
        sb2.append(this.bid);
        sb2.append(", latitude=");
        sb2.append(this.latitude);
        sb2.append(", longitude=");
        sb2.append(this.longitude);
        sb2.append(", mcc='");
        sb2.append(this.mcc);
        sb2.append("', mnc='");
        sb2.append(this.mnc);
        sb2.append("', signalStrength=");
        sb2.append(this.signalStrength);
        sb2.append(", asuLevel=");
        sb2.append(this.asuLevel);
        sb2.append(", lastUpdateSystemMills=");
        sb2.append(this.lastUpdateSystemMills);
        sb2.append(", lastUpdateUtcMills=");
        sb2.append(this.lastUpdateUtcMills);
        sb2.append(", age=");
        sb2.append(this.age);
        sb2.append(", main=");
        sb2.append(this.main);
        sb2.append(", newApi=");
        return e.o(sb2, this.newApi, '}');
    }

    @Override // com.amap.location.support.bean.cell.AmapCell
    public boolean valid() {
        int i3;
        int i10;
        int i11 = this.sid;
        return i11 > 0 && i11 <= 32767 && (i3 = this.nid) >= 0 && i3 <= 65535 && (i10 = this.bid) >= 0 && i10 <= 65535;
    }

    @Override // com.amap.location.support.bean.cell.AmapCell
    /* renamed from: clone */
    public AmapCell mo42clone() {
        AmapCellCdma amapCellCdma = new AmapCellCdma(this.main, this.newApi);
        amapCellCdma.cloneFrom(this);
        amapCellCdma.sid = this.sid;
        amapCellCdma.nid = this.nid;
        amapCellCdma.bid = this.bid;
        amapCellCdma.latitude = this.latitude;
        amapCellCdma.longitude = this.longitude;
        return amapCellCdma;
    }

    public AmapCellCdma(boolean z5, boolean z6) {
        super(z5, z6);
        this.sid = 0;
        this.nid = 0;
        this.bid = 0;
    }
}
