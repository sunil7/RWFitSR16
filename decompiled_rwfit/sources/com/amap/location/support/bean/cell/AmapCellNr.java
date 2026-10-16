package com.amap.location.support.bean.cell;

import android.support.v4.media.session.e;
import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Serializable;

/* loaded from: classes.dex */
public class AmapCellNr extends AmapCell implements Serializable {
    private static final long serialVersionUID = 1;
    public long nci;
    public int nrarfcn;
    public int pci;
    public int tac;

    public AmapCellNr() {
        this.tac = 0;
        this.nci = 0L;
        this.pci = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.nrarfcn = SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }

    @Override // com.amap.location.support.bean.cell.AmapCell
    public String getKey() {
        return "6#" + this.mcc + Const.STR_MART_WELL + this.mnc + Const.STR_MART_WELL + this.tac + Const.STR_MART_WELL + this.nci;
    }

    @Override // com.amap.location.support.bean.cell.AmapCell
    public String toString() {
        StringBuilder sb2 = new StringBuilder("AmapCellNr{tac=");
        sb2.append(this.tac);
        sb2.append(", nci=");
        sb2.append(this.nci);
        sb2.append(", pci=");
        sb2.append(this.pci);
        sb2.append(", nrarfcn=");
        sb2.append(this.nrarfcn);
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
        int i3 = this.tac;
        if (i3 < 0 || i3 > 16777215) {
            return false;
        }
        long j4 = this.nci;
        return j4 >= 4096 && j4 <= 68719476735L;
    }

    @Override // com.amap.location.support.bean.cell.AmapCell
    /* renamed from: clone */
    public AmapCell mo42clone() {
        AmapCellNr amapCellNr = new AmapCellNr(this.main);
        amapCellNr.cloneFrom(this);
        amapCellNr.tac = this.tac;
        amapCellNr.nci = this.nci;
        amapCellNr.pci = this.pci;
        amapCellNr.nrarfcn = this.nrarfcn;
        return amapCellNr;
    }

    public AmapCellNr(boolean z5) {
        super(z5, true);
        this.tac = 0;
        this.nci = 0L;
        this.pci = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.nrarfcn = SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }
}
