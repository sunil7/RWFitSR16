package com.amap.location.support.bean.cell;

import android.support.v4.media.session.e;
import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Serializable;

/* loaded from: classes.dex */
public class AmapCellGsm extends AmapCell implements Serializable {
    private static final long serialVersionUID = 1;
    public int arfcn;
    public int bsic;
    public int cid;
    public int lac;
    public int psc;
    public int timingAdvance;

    public AmapCellGsm() {
        this.lac = 0;
        this.cid = 0;
        this.psc = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.arfcn = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.bsic = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.timingAdvance = SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }

    @Override // com.amap.location.support.bean.cell.AmapCell
    public String getKey() {
        return "1#" + this.mcc + Const.STR_MART_WELL + this.mnc + Const.STR_MART_WELL + this.lac + Const.STR_MART_WELL + this.cid;
    }

    @Override // com.amap.location.support.bean.cell.AmapCell
    public String toString() {
        StringBuilder sb2 = new StringBuilder("AmapCellGsm{lac=");
        sb2.append(this.lac);
        sb2.append(", cid=");
        sb2.append(this.cid);
        sb2.append(", psc=");
        sb2.append(this.psc);
        sb2.append(", arfcn=");
        sb2.append(this.arfcn);
        sb2.append(", bsic=");
        sb2.append(this.bsic);
        sb2.append(", timingAdvance=");
        sb2.append(this.timingAdvance);
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
        int i10 = this.lac;
        return i10 >= 0 && i10 <= 65535 && (i3 = this.cid) >= 0 && i3 <= 268435455;
    }

    @Override // com.amap.location.support.bean.cell.AmapCell
    /* renamed from: clone */
    public AmapCell mo42clone() {
        AmapCellGsm amapCellGsm = new AmapCellGsm(this.main, this.newApi);
        amapCellGsm.cloneFrom(this);
        amapCellGsm.lac = this.lac;
        amapCellGsm.cid = this.cid;
        amapCellGsm.psc = this.psc;
        amapCellGsm.arfcn = this.arfcn;
        amapCellGsm.bsic = this.bsic;
        amapCellGsm.timingAdvance = this.timingAdvance;
        return amapCellGsm;
    }

    public AmapCellGsm(boolean z5, boolean z6) {
        super(z5, z6);
        this.lac = 0;
        this.cid = 0;
        this.psc = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.arfcn = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.bsic = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.timingAdvance = SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }
}
