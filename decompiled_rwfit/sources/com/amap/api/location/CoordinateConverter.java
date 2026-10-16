package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.OffsetUtil;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CoordinateConverter {
    private static int e;

    /* renamed from: a, reason: collision with root package name */
    private Context f5675a;

    /* renamed from: b, reason: collision with root package name */
    private CoordType f5676b = null;

    /* renamed from: c, reason: collision with root package name */
    private DPoint f5677c = null;

    /* renamed from: d, reason: collision with root package name */
    DPoint f5678d = null;

    public enum CoordType {
        BAIDU,
        MAPBAR,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public CoordinateConverter(Context context) {
        this.f5675a = context;
    }

    public static float calculateLineDistance(DPoint dPoint, DPoint dPoint2) {
        try {
            return Utils.dist(dPoint, dPoint2);
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static boolean isAMapDataAvailable(double d5, double d8) {
        return CoreUtil.isChina(d5, d8);
    }

    public synchronized DPoint convert() throws Exception {
        try {
            if (this.f5676b == null) {
                throw new IllegalArgumentException("转换坐标类型不能为空");
            }
            DPoint dPoint = this.f5677c;
            if (dPoint == null) {
                throw new IllegalArgumentException("转换坐标源不能为空");
            }
            if (dPoint.getLongitude() > 180.0d || this.f5677c.getLongitude() < -180.0d) {
                throw new IllegalArgumentException("请传入合理经度");
            }
            if (this.f5677c.getLatitude() > 90.0d || this.f5677c.getLatitude() < -90.0d) {
                throw new IllegalArgumentException("请传入合理纬度");
            }
            boolean z5 = true;
            String str = null;
            switch (this.f5676b) {
                case BAIDU:
                    this.f5678d = OffsetUtil.b2G(this.f5677c);
                    int i3 = e;
                    if ((i3 & 1) == 0) {
                        str = "baidu";
                        e = i3 | 1;
                        break;
                    }
                    z5 = false;
                    break;
                case MAPBAR:
                    this.f5678d = OffsetUtil.marbar2G(this.f5675a, this.f5677c);
                    int i10 = e;
                    if ((i10 & 2) == 0) {
                        str = "mapbar";
                        e = i10 | 2;
                        break;
                    }
                    z5 = false;
                    break;
                case MAPABC:
                    int i11 = e;
                    if ((i11 & 4) == 0) {
                        str = "mapabc";
                        e = i11 | 4;
                    } else {
                        z5 = false;
                    }
                    this.f5678d = this.f5677c;
                    break;
                case SOSOMAP:
                    int i12 = e;
                    if ((i12 & 8) == 0) {
                        str = "sosomap";
                        e = i12 | 8;
                    } else {
                        z5 = false;
                    }
                    this.f5678d = this.f5677c;
                    break;
                case ALIYUN:
                    int i13 = e;
                    if ((i13 & 16) == 0) {
                        str = "aliyun";
                        e = i13 | 16;
                    } else {
                        z5 = false;
                    }
                    this.f5678d = this.f5677c;
                    break;
                case GOOGLE:
                    int i14 = e;
                    if ((i14 & 32) == 0) {
                        str = "google";
                        e = i14 | 32;
                    } else {
                        z5 = false;
                    }
                    this.f5678d = this.f5677c;
                    break;
                case GPS:
                    int i15 = e;
                    if ((i15 & 64) == 0) {
                        str = "gps";
                        e = i15 | 64;
                    } else {
                        z5 = false;
                    }
                    this.f5678d = OffsetUtil.offset(this.f5675a, this.f5677c);
                    break;
                default:
                    z5 = false;
                    break;
            }
            if (z5) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("amap_loc_coordinate", str);
                }
                ReportUtil.applyStatistics(this.f5675a, ReportUtil.STATICS_ID_COORDINATE, jSONObject);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f5678d;
    }

    public synchronized CoordinateConverter coord(DPoint dPoint) throws Exception {
        if (dPoint == null) {
            throw new IllegalArgumentException("传入经纬度对象为空");
        }
        if (dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
            throw new IllegalArgumentException("请传入合理经度");
        }
        if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d) {
            throw new IllegalArgumentException("请传入合理纬度");
        }
        this.f5677c = dPoint;
        return this;
    }

    public synchronized CoordinateConverter from(CoordType coordType) {
        this.f5676b = coordType;
        return this;
    }
}
