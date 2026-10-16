package com.autonavi.aps.amapapi.model;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.AMapLocationUtil;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AMapLocationServer extends AMapLocation {

    /* renamed from: d0, reason: collision with root package name */
    private String f6641d0;
    protected String desc;

    /* renamed from: e0, reason: collision with root package name */
    private String f6642e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f6643f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f6644g0;

    /* renamed from: h0, reason: collision with root package name */
    private JSONObject f6645h0;
    private String i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f6646j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f6647k0;

    public AMapLocationServer(String str) {
        super(str);
        this.desc = "";
        this.f6641d0 = null;
        this.f6642e0 = "";
        this.f6643f0 = "";
        this.f6644g0 = Const.STR_NEW;
        this.f6645h0 = null;
        this.i0 = "";
        this.f6646j0 = "";
        this.f6647k0 = null;
    }

    public void constructorByJSON(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                CoreUtil.transformLocation(this, jSONObject);
                setCacheType(jSONObject.optString("type", this.f6644g0));
                setRetype(jSONObject.optString(Const.JSON_KEY_RETYPE, this.f6643f0));
                setCens(jSONObject.optString(Const.JSON_KEY_CENS, this.f6646j0));
                setDesc(jSONObject.optString("desc", this.desc));
                setMcell(jSONObject.optString(Const.JSON_KEY_MCELL, this.i0));
                if (Utils.joHasK(jSONObject, Const.JSON_KEY_POIID)) {
                    setBuildingId(jSONObject.optString(Const.JSON_KEY_POIID));
                }
                if (Utils.joHasK(jSONObject, Const.JSON_KEY_PID)) {
                    setBuildingId(jSONObject.optString(Const.JSON_KEY_PID));
                }
                if (Utils.joHasK(jSONObject, Const.JSON_KEY_FLOOR)) {
                    setFloor(jSONObject.optString(Const.JSON_KEY_FLOOR));
                }
                if (Utils.joHasK(jSONObject, Const.JSON_KEY_FLR)) {
                    setFloor(jSONObject.optString(Const.JSON_KEY_FLR));
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "AmapLoc", "AmapLoc");
            }
        }
    }

    public String getCacheType() {
        return this.f6644g0;
    }

    public String getCens() {
        return this.f6646j0;
    }

    public String getDesc() {
        return this.desc;
    }

    public JSONObject getExtra() {
        return this.f6645h0;
    }

    public String getMcell() {
        return this.i0;
    }

    public AMapLocationServer getMcellLoc() {
        String mcell = getMcell();
        if (TextUtils.isEmpty(mcell)) {
            return null;
        }
        String[] split = mcell.split(Const.STR_MART_COMMA);
        if (split.length != 3) {
            return null;
        }
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setProvider(getProvider());
        aMapLocationServer.setLongitude(Utils.parseDouble(split[0]));
        aMapLocationServer.setLatitude(Utils.parseDouble(split[1]));
        aMapLocationServer.setAccuracy(Utils.parseFloat(split[2]));
        aMapLocationServer.setCityCode(getCityCode());
        aMapLocationServer.setAdCode(getAdCode());
        aMapLocationServer.setCountry(getCountry());
        aMapLocationServer.setProvince(getProvince());
        aMapLocationServer.setCity(getCity());
        aMapLocationServer.setTime(getTime());
        aMapLocationServer.setCacheType(getCacheType());
        aMapLocationServer.setCoord(String.valueOf(getCoord()));
        if (Utils.locCorrect(aMapLocationServer)) {
            return aMapLocationServer;
        }
        return null;
    }

    public String getNb() {
        return this.f6647k0;
    }

    public String getRdesc() {
        return this.f6642e0;
    }

    public String getRetype() {
        return this.f6643f0;
    }

    public String getsCxtFromServer() {
        return this.f6641d0;
    }

    public void setCacheType(String str) {
        this.f6644g0 = str;
    }

    public void setCens(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("\\*");
        int length = split.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String str2 = split[i3];
            if (!TextUtils.isEmpty(str2)) {
                String[] split2 = str2.split(Const.STR_MART_COMMA);
                setLongitude(Utils.parseDouble(split2[0]));
                setLatitude(Utils.parseDouble(split2[1]));
                setAccuracy(Utils.parseInt(split2[2]));
                break;
            }
            i3++;
        }
        this.f6646j0 = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setExtra(JSONObject jSONObject) {
        this.f6645h0 = jSONObject;
    }

    @Override // com.amap.api.location.AMapLocation
    public void setLocationType(int i3) {
        if (i3 == 2 || i3 == 4 || i3 == 9) {
            AMapLocationUtil.cacheLocationType(this);
        }
        super.setLocationType(i3);
    }

    public void setMcell(String str) {
        this.i0 = str;
    }

    public void setNb(String str) {
        this.f6647k0 = str;
    }

    public void setRdesc(String str) {
        this.f6642e0 = str;
    }

    public void setRetype(String str) {
        this.f6643f0 = str;
    }

    public void setsCxtFromServer(String str) {
        this.f6641d0 = str;
    }

    @Override // com.amap.api.location.AMapLocation
    public JSONObject toJson(int i3) {
        try {
            JSONObject json = super.toJson(i3);
            if (i3 == 1) {
                json.put(Const.JSON_KEY_RETYPE, this.f6643f0);
                json.put(Const.JSON_KEY_CENS, this.f6646j0);
                json.put(Const.JSON_KEY_MCELL, this.i0);
                json.put("desc", this.desc);
                json.put(Const.JSON_KEY_ADDRESS, getAddress());
                if (this.f6645h0 != null && Utils.joHasK(json, Const.JSON_KEY_OFFPCT)) {
                    json.put(Const.JSON_KEY_OFFPCT, this.f6645h0.getString(Const.JSON_KEY_OFFPCT));
                }
            } else if (i3 != 2 && i3 != 3) {
                return json;
            }
            json.put("type", this.f6644g0);
            return json;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AmapLoc", "toStr");
            return null;
        }
    }

    @Override // com.amap.api.location.AMapLocation
    public String toStr() {
        return toStr(1);
    }

    @Override // com.amap.api.location.AMapLocation
    public String toStr(int i3) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i3);
            jSONObject.put("nb", this.f6647k0);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
