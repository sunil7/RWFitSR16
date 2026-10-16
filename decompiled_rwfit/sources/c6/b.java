package c6;

import com.example.network.api.DeviceApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.FirmwareInfoBean;
import rg.l;

/* loaded from: classes.dex */
public final class b extends a6.c {

    /* renamed from: c, reason: collision with root package name */
    public static final b f3390c = new b();

    @Override // a6.c
    public final Object a() {
        Object create = b().create(DeviceApi.class);
        kotlin.jvm.internal.e.e(create, "create(...)");
        return (DeviceApi) create;
    }

    public final l d(String str, String str2) {
        l<HttpModel<String>> activeDevice = ((DeviceApi) this.f113a).activeDevice(str, str2);
        kotlin.jvm.internal.e.e(activeDevice, "activeDevice(...)");
        return com.example.baselibrary.utils.b.w(activeDevice);
    }

    public final l e(String str, String str2, String str3) {
        l<HttpModel<FirmwareInfoBean>> firmwareInfo = ((DeviceApi) this.f113a).getFirmwareInfo(str, str2, 1, str3);
        kotlin.jvm.internal.e.e(firmwareInfo, "getFirmwareInfo(...)");
        return com.example.baselibrary.utils.b.w(firmwareInfo);
    }
}
