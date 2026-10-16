package com.amap.location.support.bean.cell;

import android.support.v4.media.session.e;
import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class AmapCell implements Serializable {
    private static final long serialVersionUID = 1;
    public int age;
    public int asuLevel;
    public long lastUpdateSystemMills;
    public long lastUpdateUtcMills;
    public boolean main;
    public String mcc;
    public String mnc;
    public boolean newApi;
    public int signalStrength;

    public AmapCell() {
        this.mcc = "";
        this.mnc = "";
        this.signalStrength = 99;
        this.asuLevel = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.lastUpdateSystemMills = 0L;
        this.lastUpdateUtcMills = 0L;
        this.age = 0;
        this.newApi = true;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract AmapCell mo42clone();

    public void cloneFrom(AmapCell amapCell) {
        if (amapCell != null) {
            this.mcc = amapCell.mcc;
            this.mnc = amapCell.mnc;
            this.signalStrength = amapCell.signalStrength;
            this.asuLevel = amapCell.asuLevel;
            this.lastUpdateSystemMills = amapCell.lastUpdateSystemMills;
            this.lastUpdateUtcMills = amapCell.lastUpdateUtcMills;
            this.age = amapCell.age;
            this.main = amapCell.main;
            this.newApi = amapCell.newApi;
        }
    }

    public long getAreaID() {
        int i3;
        if (this instanceof AmapCellGsm) {
            i3 = ((AmapCellGsm) this).lac;
        } else if (this instanceof AmapCellCdma) {
            i3 = ((AmapCellCdma) this).nid;
        } else if (this instanceof AmapCellWcdma) {
            i3 = ((AmapCellWcdma) this).lac;
        } else if (this instanceof AmapCellLte) {
            i3 = ((AmapCellLte) this).tac;
        } else {
            if (!(this instanceof AmapCellNr)) {
                return 0L;
            }
            i3 = ((AmapCellNr) this).tac;
        }
        return i3;
    }

    public long getCellID() {
        if (this instanceof AmapCellGsm) {
            return ((AmapCellGsm) this).cid;
        }
        if (this instanceof AmapCellCdma) {
            return ((AmapCellCdma) this).bid;
        }
        if (this instanceof AmapCellWcdma) {
            return ((AmapCellWcdma) this).cid;
        }
        if (this instanceof AmapCellLte) {
            return ((AmapCellLte) this).f6569ci;
        }
        if (this instanceof AmapCellNr) {
            return ((AmapCellNr) this).nci;
        }
        return 0L;
    }

    public abstract String getKey();

    public String getKeyWithDifferentApi() {
        String key = getKey();
        if (key == null || key.length() <= 0) {
            return "";
        }
        return (this.newApi ? 1 : 0) + Const.STR_MART_WELL + key;
    }

    public int getMccInt() {
        try {
            return Integer.parseInt(this.mcc);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getMncInt() {
        try {
            return Integer.parseInt(this.mnc);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void setMccInt(int i3) {
        this.mcc = String.valueOf(i3);
    }

    public void setMncInt(int i3) {
        this.mnc = String.valueOf(i3);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AmapCell{mcc=");
        sb2.append(this.mcc);
        sb2.append(", mnc=");
        sb2.append(this.mnc);
        sb2.append(", signalStrength=");
        sb2.append(this.signalStrength);
        sb2.append(", asulevel=");
        sb2.append(this.asuLevel);
        sb2.append(", lastUpdateSystemMills=");
        sb2.append(this.lastUpdateSystemMills);
        sb2.append(", lastUpdateUtcMills=");
        sb2.append(this.lastUpdateUtcMills);
        sb2.append(", age=");
        sb2.append(this.age);
        sb2.append(", main=");
        sb2.append(this.main);
        sb2.append(", newapi=");
        return e.o(sb2, this.newApi, '}');
    }

    public abstract boolean valid();

    public AmapCell(boolean z5, boolean z6) {
        this.mcc = "";
        this.mnc = "";
        this.signalStrength = 99;
        this.asuLevel = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.lastUpdateSystemMills = 0L;
        this.lastUpdateUtcMills = 0L;
        this.age = 0;
        this.main = z5;
        this.newApi = z6;
    }
}
