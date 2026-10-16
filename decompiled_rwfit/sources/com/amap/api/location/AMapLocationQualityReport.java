package com.amap.api.location;

import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.tencent.connect.common.Constants;

/* loaded from: classes.dex */
public class AMapLocationQualityReport implements Cloneable {
    public static final int GPS_STATUS_MODE_SAVING = 3;
    public static final int GPS_STATUS_NOGPSPERMISSION = 4;
    public static final int GPS_STATUS_NOGPSPROVIDER = 1;
    public static final int GPS_STATUS_OFF = 2;
    public static final int GPS_STATUS_OK = 0;

    /* renamed from: a, reason: collision with root package name */
    private boolean f5665a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f5666b = 2;

    /* renamed from: c, reason: collision with root package name */
    private int f5667c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f5668d = Constants.APP_VERSION_UNKNOWN;
    private long e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5669f = false;

    /* renamed from: g, reason: collision with root package name */
    AMapLocationClientOption.AMapLocationMode f5670g = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    public String getAdviseMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        AMapLocationClientOption.AMapLocationMode aMapLocationMode = this.f5670g;
        if (aMapLocationMode != AMapLocationClientOption.AMapLocationMode.Battery_Saving) {
            int i3 = this.f5666b;
            if (i3 != 0) {
                if (i3 == 1) {
                    stringBuffer.append("您的设备没有GPS模块或者GPS模块异常，无法进行GPS定位\n");
                } else if (i3 == 2) {
                    stringBuffer.append("您的设备关闭了GPS定位功能，开启GPS定位功能有助于提高定位的精确度\n");
                } else if (i3 == 3) {
                    stringBuffer.append("您的设备当前设置的定位模式不包含GPS定位，选择包含GPS模式的定位模式有助于提高定位的精确度\n");
                } else if (i3 == 4) {
                    stringBuffer.append("您的设置禁用了GPS定位权限，开启GPS定位权限有助于提高定位的精确度\n");
                }
            } else if (aMapLocationMode == AMapLocationClientOption.AMapLocationMode.Device_Sensors && this.f5667c < 4) {
                stringBuffer.append("当前GPS信号弱，位置更新可能会延迟\n");
            }
        }
        if (this.f5670g != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            if ("DISCONNECTED".equals(this.f5668d)) {
                stringBuffer.append("您的设备未连接到网络，无法进行网络定位\n");
            } else if ("2G".equals(this.f5668d)) {
                stringBuffer.append("您的设备网络状态不太好，网络定位可能会有延迟\n");
            }
            if (!this.f5665a) {
                stringBuffer.append("您的设备WIFI开关已关闭，打开WIFI开关有助于提高定位的成功率\n");
            }
        }
        return stringBuffer.toString();
    }

    public int getGPSSatellites() {
        return this.f5667c;
    }

    public int getGPSStatus() {
        return this.f5666b;
    }

    public long getNetUseTime() {
        return this.e;
    }

    public String getNetworkType() {
        return this.f5668d;
    }

    public boolean isInstalledHighDangerMockApp() {
        return this.f5669f;
    }

    public boolean isWifiAble() {
        return this.f5665a;
    }

    public void setGPSSatellites(int i3) {
        this.f5667c = i3;
    }

    public void setGpsStatus(int i3) {
        this.f5666b = i3;
    }

    public void setInstallHighDangerMockApp(boolean z5) {
        this.f5669f = z5;
    }

    public void setLocationMode(AMapLocationClientOption.AMapLocationMode aMapLocationMode) {
        this.f5670g = aMapLocationMode;
    }

    public void setNetUseTime(long j4) {
        this.e = j4;
    }

    public void setNetworkType(String str) {
        this.f5668d = str;
    }

    public void setWifiAble(boolean z5) {
        this.f5665a = z5;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AMapLocationQualityReport m4clone() {
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        try {
            aMapLocationQualityReport.setGpsStatus(this.f5666b);
            aMapLocationQualityReport.setGPSSatellites(this.f5667c);
            aMapLocationQualityReport.setWifiAble(this.f5665a);
            aMapLocationQualityReport.setNetUseTime(this.e);
            aMapLocationQualityReport.setNetworkType(this.f5668d);
            aMapLocationQualityReport.setLocationMode(this.f5670g);
            aMapLocationQualityReport.setInstallHighDangerMockApp(this.f5669f);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMapLocationQualityReport", "clone");
        }
        return aMapLocationQualityReport;
    }
}
