package com.amap.location.support.bean.cell;

import android.support.v4.media.session.e;
import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Serializable;

/* loaded from: classes.dex */
public class AmapCellLte extends AmapCell implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: ci, reason: collision with root package name */
    public int f6569ci;
    public int earfcn;
    public int pci;
    public int tac;
    public int timingAdvance;

    public AmapCellLte() {
        this.tac = 0;
        this.f6569ci = 0;
        this.pci = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.earfcn = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.timingAdvance = SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }

    @Override // com.amap.location.support.bean.cell.AmapCell
    public String getKey() {
        return "3#" + this.mcc + Const.STR_MART_WELL + this.mnc + Const.STR_MART_WELL + this.tac + Const.STR_MART_WELL + this.f6569ci;
    }

    @Override // com.amap.location.support.bean.cell.AmapCell
    public String toString() {
        StringBuilder sb2 = new StringBuilder("AmapCellLte{tac=");
        sb2.append(this.tac);
        sb2.append(", ci=");
        sb2.append(this.f6569ci);
        sb2.append(", pci=");
        sb2.append(this.pci);
        sb2.append(", earfcn=");
        sb2.append(this.earfcn);
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
        int i10 = this.tac;
        return i10 >= 0 && i10 <= 65535 && (i3 = this.f6569ci) >= 0 && i3 <= 268435455;
    }

    @Override // com.amap.location.support.bean.cell.AmapCell
    /* renamed from: clone */
    public AmapCell mo42clone() {
        AmapCellLte amapCellLte = new AmapCellLte(this.main);
        amapCellLte.cloneFrom(this);
        amapCellLte.tac = this.tac;
        amapCellLte.f6569ci = this.f6569ci;
        amapCellLte.pci = this.pci;
        amapCellLte.earfcn = this.earfcn;
        amapCellLte.timingAdvance = this.timingAdvance;
        return amapCellLte;
    }

    public AmapCellLte(boolean z5) {
        super(z5, true);
        this.tac = 0;
        this.f6569ci = 0;
        this.pci = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.earfcn = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.timingAdvance = SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }
}
