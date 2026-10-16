package com.autonavi.aps.amapapi.restruct;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class HistoryLocation {
    public int locationType = 0;
    public double latitude = 0.0d;
    public double longitude = 0.0d;
    public long time = 0;
    public int radius = 0;
    public int type = 0;
    public int reType = 63;
    public int reSubType = 0;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            HistoryLocation historyLocation = (HistoryLocation) obj;
            if (this.locationType == historyLocation.locationType && Double.compare(historyLocation.latitude, this.latitude) == 0 && Double.compare(historyLocation.longitude, this.longitude) == 0 && this.time == historyLocation.time && this.radius == historyLocation.radius && this.type == historyLocation.type && this.reType == historyLocation.reType && this.reSubType == historyLocation.reSubType) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.locationType), Double.valueOf(this.latitude), Double.valueOf(this.longitude), Long.valueOf(this.time), Integer.valueOf(this.radius), Integer.valueOf(this.type), Integer.valueOf(this.reType), Integer.valueOf(this.reSubType));
    }

    public String toJson() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put(Const.JSON_KEY_TIME, this.time);
            jSONObject.put(Const.JSON_KEY_LON, this.longitude);
            jSONObject.put(Const.JSON_KEY_LAT, this.latitude);
            jSONObject.put("radius", this.radius);
            jSONObject.put("locationType", this.locationType);
            jSONObject.put("reType", this.reType);
            jSONObject.put("reSubType", this.reSubType);
        } catch (Throwable unused) {
            jSONObject = null;
        }
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public void transformLocation(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.latitude = jSONObject.optDouble(Const.JSON_KEY_LAT, this.latitude);
                this.longitude = jSONObject.optDouble(Const.JSON_KEY_LON, this.longitude);
                this.locationType = jSONObject.optInt("locationType", this.locationType);
                this.reType = jSONObject.optInt("reType", this.reType);
                this.reSubType = jSONObject.optInt("reSubType", this.reSubType);
                this.radius = jSONObject.optInt("radius", this.radius);
                this.time = jSONObject.optLong(Const.JSON_KEY_TIME, this.time);
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "CoreUtil", "transformLocation");
            }
        }
    }
}
