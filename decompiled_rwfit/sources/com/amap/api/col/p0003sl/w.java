package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.UmidtokenInfo;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.aps.amapapi.utils.Utils;

/* loaded from: classes.dex */
public class w implements s {

    /* renamed from: b, reason: collision with root package name */
    private final Handler f5200b;

    /* renamed from: c, reason: collision with root package name */
    private Context f5201c;

    /* renamed from: d, reason: collision with root package name */
    private e f5202d;
    private AMapLocationClientOption e;

    /* renamed from: f, reason: collision with root package name */
    boolean f5203f = false;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f5204g = false;

    public w(Context context, e eVar) {
        this.f5201c = context;
        this.f5200b = eVar.f3928d;
        this.f5202d = eVar;
    }

    private boolean d() {
        boolean z5 = false;
        int i3 = 0;
        do {
            try {
                if (this.f5202d.f3942t != null) {
                    break;
                }
                Thread.sleep(100L);
                i3++;
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "LbsLocation", "checkAPSManager");
            }
        } while (i3 < 50);
        if (this.f5202d.f3942t == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            if (Utils.isHadApsService(this.f5201c.getApplicationContext())) {
                aMapLocation.setLocationDetail("启动ApsServcie失败#1001");
            } else {
                aMapLocation.setLocationDetail("请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003");
            }
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.f5200b.sendMessage(obtain);
        } else {
            z5 = true;
        }
        if (!z5) {
            if (Utils.isHadApsService(this.f5201c.getApplicationContext())) {
                ReportUtil.reportLocError(null, 2101);
            } else {
                ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOTAPSSERVICE);
            }
        }
        return z5;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:21|(23:132|133|(2:25|(2:124|(2:126|(1:130)))(20:27|(22:29|30|31|(2:33|(1:35))|108|(2:38|39)(1:106)|40|41|(1:45)|47|48|(1:52)|54|55|(3:57|58|59)|60|(3:63|64|(1:66))|(3:75|76|77)|82|83|84|(4:86|(1:96)(1:92)|93|94)(1:97))(1:123)|36|(0)(0)|40|41|(2:43|45)|47|48|(2:50|52)|54|55|(0)|60|(3:63|64|(0))|(4:73|75|76|77)|82|83|84|(0)(0)))|131|(0)(0)|36|(0)(0)|40|41|(0)|47|48|(0)|54|55|(0)|60|(0)|(0)|82|83|84|(0)(0))|23|(0)|131|(0)(0)|36|(0)(0)|40|41|(0)|47|48|(0)|54|55|(0)|60|(0)|(0)|82|83|84|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x015d, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0180, code lost:
    
        com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r3, "LbsLocation", "apsLocation:callback");
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0129, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x012a, code lost:
    
        com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r10, "LbsLocation", "fixLastLocation");
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0089 A[Catch: all -> 0x0084, TryCatch #1 {all -> 0x0084, blocks: (B:18:0x005e, B:21:0x006a, B:25:0x0089, B:124:0x0094, B:126:0x009e, B:128:0x00b5, B:130:0x00ba, B:136:0x0080, B:137:0x00c4, B:143:0x00d2, B:140:0x00cc, B:133:0x007a), top: B:17:0x005e, outer: #6, inners: #8, #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0103 A[Catch: all -> 0x00fb, TRY_LEAVE, TryCatch #13 {all -> 0x00fb, blocks: (B:38:0x0103, B:73:0x0189, B:75:0x018d, B:80:0x01a8, B:102:0x0180, B:105:0x012a, B:110:0x00f5, B:77:0x018f, B:41:0x0110, B:43:0x0118, B:45:0x011e, B:31:0x00e1, B:33:0x00e7, B:55:0x0142, B:57:0x0149, B:59:0x0150, B:60:0x015f, B:69:0x017a), top: B:30:0x00e1, inners: #2, #3, #7, #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0118 A[Catch: all -> 0x0129, TryCatch #3 {all -> 0x0129, blocks: (B:41:0x0110, B:43:0x0118, B:45:0x011e), top: B:40:0x0110, outer: #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0139 A[Catch: all -> 0x0142, TryCatch #0 {all -> 0x0142, blocks: (B:48:0x012f, B:50:0x0139, B:52:0x013d), top: B:47:0x012f }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0149 A[Catch: all -> 0x015d, TRY_LEAVE, TryCatch #14 {all -> 0x015d, blocks: (B:55:0x0142, B:57:0x0149, B:59:0x0150, B:60:0x015f, B:69:0x017a, B:64:0x016f, B:66:0x0175), top: B:54:0x0142, outer: #13, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0175 A[Catch: all -> 0x0179, TRY_LEAVE, TryCatch #12 {all -> 0x0179, blocks: (B:64:0x016f, B:66:0x0175), top: B:63:0x016f, outer: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0187 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e() {
        /*
            Method dump skipped, instructions count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.w.e():void");
    }

    private void f() {
        if (this.e.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            this.f5202d.a(1016, null, this.e.getInterval() >= 1000 ? this.e.getInterval() : 1000L);
        }
    }

    @Override // com.amap.api.col.p0003sl.t
    public void a(Bundle bundle) {
    }

    public void b(AMapLocationClientOption aMapLocationClientOption) {
        this.e = aMapLocationClientOption;
    }

    @Override // com.amap.api.col.p0003sl.t
    public void c() {
    }

    @Override // com.amap.api.col.p0003sl.t
    public void a(AMapLocationClientOption aMapLocationClientOption) {
        this.e = aMapLocationClientOption;
        if (aMapLocationClientOption.isLBSLocationEnable()) {
            try {
                try {
                    e eVar = this.f5202d;
                    if (eVar.f3936m || !(eVar.A || this.f5204g)) {
                        this.f5202d.f3936m = false;
                        this.f5204g = true;
                        e();
                    } else {
                        try {
                            e eVar2 = this.f5202d;
                            if (eVar2.A && !eVar2.g() && !this.f5203f) {
                                this.f5203f = true;
                                this.f5202d.j();
                            }
                        } catch (Throwable th2) {
                            this.f5203f = true;
                            CoreUtil.reportError(th2, "LbsLocation", "doLBSLocation reStartService");
                        }
                        if (d()) {
                            this.f5203f = false;
                            Bundle bundle = new Bundle();
                            bundle.putBundle("optBundle", CoreUtil.getOptionBundle(this.e));
                            bundle.putString(Const.INTENT_KEY_UMID, UmidtokenInfo.getUmidtoken());
                            this.f5202d.a(1, bundle);
                        }
                    }
                    if (this.e.isOnceLocation()) {
                        return;
                    }
                } catch (Throwable unused) {
                    return;
                }
            } catch (Throwable th3) {
                try {
                    CoreUtil.reportError(th3, "LbsLocation", "doLBSLocation");
                    if (this.e.isOnceLocation()) {
                        return;
                    }
                } catch (Throwable th4) {
                    try {
                        if (!this.e.isOnceLocation()) {
                            f();
                        }
                    } catch (Throwable unused2) {
                    }
                    throw th4;
                }
            }
            f();
        }
    }
}
