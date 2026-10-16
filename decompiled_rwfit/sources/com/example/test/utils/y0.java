package com.example.test.utils;

import android.util.Log;
import com.amap.api.maps.offlinemap.OfflineMapStatus;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.example.blesdk.bean.function.BindInfoBean;
import com.example.blesdk.bean.function.WeatherBean;
import com.example.database.table.User;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class y0 implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z0 f8775a;

    public y0(z0 z0Var) {
        this.f8775a = z0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "设置天气失败："));
        this.f8775a.c();
    }

    @Override // u5.g
    public final void c() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "设置天气成功，刷新天气时间");
        s5.a g10 = com.example.test.service.e.h().g();
        if (k.f8731b == null) {
            synchronized (k.class) {
                k.f8731b = new k();
            }
        }
        k kVar = k.f8731b;
        if (kVar != null && g10 != null) {
            if (kVar == null) {
                synchronized (k.class) {
                    k.f8731b = new k();
                }
            }
            k kVar2 = k.f8731b;
            String mac = g10.f18212c;
            kVar2.getClass();
            kotlin.jvm.internal.e.f(mac, "mac");
            User d5 = kVar2.d();
            if (d5 != null) {
                kVar2.M(Long.valueOf(System.currentTimeMillis()), r5.a.c(d5.getUserId(), mac, "user_location_weather_time"));
            }
        }
        if (!y5.d.f20005b) {
            this.f8775a.c();
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (!this.f8775a.f8777a.isEmpty()) {
            WeatherBean weatherBean = (WeatherBean) this.f8775a.f8777a.poll();
            if (weatherBean != null) {
                arrayList.add(weatherBean);
            }
        }
        if (arrayList.isEmpty()) {
            this.f8775a.c();
            return;
        }
        if (k.f8731b == null) {
            synchronized (k.class) {
                k.f8731b = new k();
            }
        }
        BindInfoBean m10 = k.f8731b.m();
        if (m10 != null) {
            if (m10.getWeather2Enable() != 1) {
                if (!r5.b.k().f18054c) {
                    x5.b.I0().F0((byte) 5);
                    return;
                }
                x5.c b3 = x5.c.b();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getForecastWeatherCmdJL " + arrayList);
                byte[] bArr = new byte[((arrayList.size() - 1) * 10) + 19];
                bArr[0] = 4;
                bArr[1] = 5;
                bArr[2] = 0;
                WeatherBean weatherBean2 = (WeatherBean) arrayList.get(0);
                bArr[3] = (byte) weatherBean2.getYear();
                bArr[4] = (byte) weatherBean2.getMonth();
                bArr[5] = (byte) weatherBean2.getDay();
                bArr[6] = (byte) weatherBean2.getHour();
                bArr[7] = (byte) weatherBean2.getMinute();
                bArr[8] = (byte) weatherBean2.getSecond();
                bArr[9] = (byte) weatherBean2.getCurrentTemp();
                bArr[10] = (byte) weatherBean2.getMaxTemp();
                bArr[11] = (byte) weatherBean2.getMinTemp();
                bArr[12] = (byte) weatherBean2.getWeatherType();
                bArr[13] = (byte) weatherBean2.getWindSpeed();
                bArr[14] = (byte) weatherBean2.getHumidity();
                bArr[15] = (byte) weatherBean2.getVisibility();
                bArr[16] = (byte) weatherBean2.getUVIntensity();
                byte[] a3 = y5.b.a(weatherBean2.getRainfall(), 2);
                bArr[17] = a3[1];
                bArr[18] = a3[0];
                int size = arrayList.size();
                for (int i3 = 1; i3 < size; i3++) {
                    WeatherBean weatherBean3 = (WeatherBean) arrayList.get(i3);
                    int i10 = (i3 - 1) * 10;
                    bArr[i10 + 19] = (byte) weatherBean3.getCurrentTemp();
                    bArr[i10 + 20] = (byte) weatherBean3.getMaxTemp();
                    bArr[i10 + 21] = (byte) weatherBean3.getMinTemp();
                    bArr[i10 + 22] = (byte) weatherBean3.getWeatherType();
                    bArr[i10 + 23] = (byte) weatherBean3.getWindSpeed();
                    bArr[i10 + 24] = (byte) weatherBean3.getHumidity();
                    bArr[i10 + 25] = (byte) weatherBean3.getVisibility();
                    bArr[i10 + 26] = (byte) weatherBean3.getUVIntensity();
                    byte[] a10 = y5.b.a(weatherBean3.getRainfall(), 2);
                    bArr[i10 + 27] = a10[1];
                    bArr[i10 + 28] = a10[0];
                }
                b3.g((byte) 5, bArr, new boolean[0]);
                return;
            }
            if (!r5.b.k().f18054c) {
                x5.b.I0().F0((byte) 5);
                return;
            }
            x5.c b10 = x5.c.b();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getForecastWeatherCmdJL2 " + arrayList);
            byte[] bArr2 = new byte[((arrayList.size() - 1) * 20) + 95];
            bArr2[0] = 4;
            bArr2[1] = 5;
            bArr2[2] = 0;
            WeatherBean weatherBean4 = (WeatherBean) arrayList.get(0);
            bArr2[3] = (byte) weatherBean4.getYear();
            bArr2[4] = (byte) weatherBean4.getMonth();
            bArr2[5] = (byte) weatherBean4.getDay();
            bArr2[6] = (byte) weatherBean4.getHour();
            bArr2[7] = (byte) weatherBean4.getMinute();
            bArr2[8] = (byte) weatherBean4.getSecond();
            bArr2[75] = (byte) weatherBean4.getCurrentTemp();
            bArr2[76] = (byte) weatherBean4.getMaxTemp();
            bArr2[77] = (byte) weatherBean4.getMinTemp();
            byte[] a11 = y5.b.a(weatherBean4.getWeatherType(), 2);
            bArr2[78] = a11[1];
            bArr2[79] = a11[0];
            bArr2[80] = (byte) weatherBean4.getWindSpeed();
            bArr2[81] = (byte) weatherBean4.getHumidity();
            bArr2[82] = (byte) weatherBean4.getVisibility();
            bArr2[83] = (byte) weatherBean4.getUVIntensity();
            byte[] a12 = y5.b.a(weatherBean4.getRainfall(), 2);
            bArr2[84] = a12[1];
            bArr2[85] = a12[0];
            bArr2[86] = (byte) weatherBean4.getJlSunriseHour();
            bArr2[87] = (byte) weatherBean4.getJlSunriseMin();
            bArr2[88] = (byte) weatherBean4.getJlSunriseSec();
            bArr2[89] = (byte) weatherBean4.getJlSunsetHour();
            bArr2[90] = (byte) weatherBean4.getJlSunsetMin();
            bArr2[91] = (byte) weatherBean4.getJlSunsetSec();
            int size2 = arrayList.size();
            for (int i11 = 1; i11 < size2; i11++) {
                WeatherBean weatherBean5 = (WeatherBean) arrayList.get(i11);
                Log.e("qob", "bean " + weatherBean5.getDay() + '-' + weatherBean5.getHour() + ' ' + weatherBean5.getMinTemp());
                int i12 = (i11 + (-1)) * 20;
                bArr2[i12 + 95] = (byte) weatherBean5.getCurrentTemp();
                bArr2[i12 + 96] = (byte) weatherBean5.getMaxTemp();
                bArr2[i12 + 97] = (byte) weatherBean5.getMinTemp();
                byte[] a13 = y5.b.a(weatherBean5.getWeatherType(), 2);
                bArr2[i12 + 98] = a13[1];
                bArr2[i12 + 99] = a13[0];
                bArr2[i12 + 100] = (byte) weatherBean5.getWindSpeed();
                bArr2[i12 + 101] = (byte) weatherBean5.getHumidity();
                int i13 = i12 + OfflineMapStatus.EXCEPTION_SDCARD;
                bArr2[i12 + 102] = (byte) weatherBean5.getVisibility();
                bArr2[i13] = (byte) weatherBean5.getUVIntensity();
                byte[] a14 = y5.b.a(weatherBean5.getRainfall(), 2);
                bArr2[i12 + 104] = a14[1];
                bArr2[i12 + 105] = a14[0];
                bArr2[i12 + 106] = (byte) weatherBean5.getJlSunriseHour();
                bArr2[i12 + 107] = (byte) weatherBean5.getJlSunriseMin();
                bArr2[i12 + 108] = (byte) weatherBean5.getJlSunriseSec();
                int i14 = i12 + 110;
                bArr2[i12 + 109] = (byte) weatherBean5.getJlSunsetHour();
                int i15 = i12 + AMapEngineUtils.ARROW_LINE_INNER_TEXTURE_ID;
                bArr2[i14] = (byte) weatherBean5.getJlSunsetMin();
                bArr2[i15] = (byte) weatherBean5.getJlSunsetSec();
            }
            b10.g((byte) 5, bArr2, new boolean[0]);
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "WeatherUtils", "设置天气成功，刷新天气时间 onResult");
    }
}
