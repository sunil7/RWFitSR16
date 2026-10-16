package com.example.test.utils;

import android.os.Parcelable;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.BindInfoBean;
import com.example.blesdk.bean.function.BlueToothBean;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.blesdk.bean.function.PowerBean;
import com.example.blesdk.bean.function.SportTargetBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.database.db.UserImpl;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.network.bean.DeviceModelInfoBean;
import com.example.network.bean.SwitchBean;
import com.tencent.mmkv.MMKV;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    public static k f8731b;

    /* renamed from: a, reason: collision with root package name */
    public MMKV f8732a;

    public final int A() {
        User d5 = d();
        if (d5 != null) {
            String l3 = android.support.v4.media.session.e.l(d5.getUserId(), "sleep_time_target");
            Class cls = Integer.TYPE;
            Integer num = (Integer) i(l3, cls);
            if (num != null && num.intValue() == 0) {
                return GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
            }
            Integer num2 = (Integer) i(d5.getUserId() + "sleep_time_target", cls);
            if (num2 != null) {
                return num2.intValue();
            }
        }
        return GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
    }

    public final SportTargetBean B() {
        SportTargetBean sportTargetBean;
        SportTargetBean sportTargetBean2 = new SportTargetBean();
        User d5 = d();
        if (d5 != null) {
            MMKV mmkv = this.f8732a;
            if (mmkv != null) {
                sportTargetBean = (SportTargetBean) mmkv.f(d5.getUserId() + "setting_sport_target", SportTargetBean.class);
            } else {
                sportTargetBean = null;
            }
            if (sportTargetBean != null) {
                sportTargetBean2.setTime(sportTargetBean.getTime());
                sportTargetBean2.setDistance(sportTargetBean.getDistance());
                sportTargetBean2.setCalorie(sportTargetBean.getCalorie());
                sportTargetBean2.setAutoPause(sportTargetBean.isAutoPause());
                sportTargetBean2.setScreenLight(sportTargetBean.isScreenLight());
                sportTargetBean2.setVibrator(sportTargetBean.isVibrator());
            }
        }
        return sportTargetBean2;
    }

    public final long C() {
        User d5 = d();
        if (d5 != null) {
            String l3 = android.support.v4.media.session.e.l(d5.getUserId(), "step_num_target");
            Class cls = Long.TYPE;
            Long l5 = (Long) i(l3, cls);
            if (l5 != null && l5.longValue() == 0) {
                return Const.L_MIN_GET_REQ;
            }
            Long l8 = (Long) i(d5.getUserId() + "step_num_target", cls);
            if (l8 != null) {
                return l8.longValue();
            }
        }
        return Const.L_MIN_GET_REQ;
    }

    public final int D() {
        Integer num = (Integer) i("app_theme_style", Integer.TYPE);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final int E() {
        User d5 = d();
        if (d5 != null) {
            String l3 = android.support.v4.media.session.e.l(d5.getUserId(), "wear_derction_select");
            Class cls = Integer.TYPE;
            Integer num = (Integer) i(l3, cls);
            if (num != null && num.intValue() == 0) {
                return 0;
            }
            Integer num2 = (Integer) i(d5.getUserId() + "wear_derction_select", cls);
            if (num2 != null) {
                return num2.intValue();
            }
        }
        return 0;
    }

    public final void F(SupportMenuBean support) {
        Devices c9;
        kotlin.jvm.internal.e.f(support, "support");
        User d5 = d();
        if (d5 == null || (c9 = c()) == null) {
            return;
        }
        M(support, d5.getUserId() + c9.getMacAddress() + "device_support");
    }

    public final void G(User userInfoBean) {
        kotlin.jvm.internal.e.f(userInfoBean, "userInfoBean");
        M(userInfoBean, "user_info_logged");
        DataCacheUtils$initUser$1 runBlock = new oh.l() { // from class: com.example.test.utils.DataCacheUtils$initUser$1
            @Override // oh.l
            public final Long invoke(User it) {
                kotlin.jvm.internal.e.f(it, "it");
                return Long.valueOf(UserImpl.INSTANCE.saveUser(it));
            }
        };
        final DataCacheUtils$initUser$2 backBlock = new oh.l() { // from class: com.example.test.utils.DataCacheUtils$initUser$2
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return eh.g.f12633a;
            }

            public final void invoke(long j4) {
                new StringBuilder("用户保存 : ").append(j4);
            }
        };
        kotlin.jvm.internal.e.f(runBlock, "runBlock");
        kotlin.jvm.internal.e.f(backBlock, "backBlock");
        rg.l create = rg.l.create(new c0.b(7, runBlock, userInfoBean));
        kotlin.jvm.internal.e.e(create, "create(...)");
        com.example.baselibrary.utils.b.t(create).subscribe(new androidx.camera.lifecycle.d(new oh.l() { // from class: com.example.test.utils.DataCacheUtils$startAsyncTask$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m61invoke(obj);
                return eh.g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m61invoke(Object obj) {
                oh.l.this.invoke(obj);
            }
        }, 13), new androidx.camera.lifecycle.d(new oh.l() { // from class: com.example.test.utils.DataCacheUtils$startAsyncTask$3
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return eh.g.f12633a;
            }

            public final void invoke(Throwable th2) {
                new StringBuilder("error : ").append(com.example.baselibrary.utils.b.z(th2));
            }
        }, 14));
    }

    public final boolean H(String str) {
        User d5;
        Boolean bool;
        if (str == null || (d5 = d()) == null || (bool = (Boolean) i(r5.a.c(d5.getUserId(), str, "setting_anti_lost"), Boolean.TYPE)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean I(String str) {
        User d5;
        Boolean bool;
        if (str == null || (d5 = d()) == null || (bool = (Boolean) i(r5.a.c(d5.getUserId(), str, "setting_incoming_call"), Boolean.TYPE)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean J(String str) {
        User d5;
        Boolean bool;
        if (str == null || (d5 = d()) == null || (bool = (Boolean) i(r5.a.c(d5.getUserId(), str, "setting_take_photo"), Boolean.TYPE)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean K(String str) {
        User d5;
        Boolean bool;
        if (str == null || (d5 = d()) == null || (bool = (Boolean) i(r5.a.c(d5.getUserId(), str, "setting_weather"), Boolean.TYPE)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void L() {
        N("user_info_logged");
        N("user_login_token");
        if (d6.a.f12304c == null) {
            synchronized (d6.a.class) {
                d6.a.f12304c = new d6.a();
            }
        }
        d6.a aVar = d6.a.f12304c;
        if (aVar != null) {
            aVar.f12306b = "";
        }
        if (aVar == null) {
            synchronized (d6.a.class) {
                d6.a.f12304c = new d6.a();
            }
        }
        d6.a aVar2 = d6.a.f12304c;
        if (aVar2 == null) {
            return;
        }
        aVar2.f12305a = -1;
    }

    public final boolean M(Object obj, String str) {
        if (obj instanceof String) {
            MMKV mmkv = this.f8732a;
            kotlin.jvm.internal.e.c(mmkv);
            kotlin.jvm.internal.e.d(obj, "null cannot be cast to non-null type kotlin.String");
            return mmkv.n(str, (String) obj);
        }
        if (obj instanceof Boolean) {
            MMKV mmkv2 = this.f8732a;
            kotlin.jvm.internal.e.c(mmkv2);
            kotlin.jvm.internal.e.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
            return mmkv2.o(str, ((Boolean) obj).booleanValue());
        }
        if (obj instanceof Integer) {
            MMKV mmkv3 = this.f8732a;
            kotlin.jvm.internal.e.c(mmkv3);
            kotlin.jvm.internal.e.d(obj, "null cannot be cast to non-null type kotlin.Int");
            return mmkv3.i(((Integer) obj).intValue(), str);
        }
        if (obj instanceof Long) {
            MMKV mmkv4 = this.f8732a;
            kotlin.jvm.internal.e.c(mmkv4);
            kotlin.jvm.internal.e.d(obj, "null cannot be cast to non-null type kotlin.Long");
            return mmkv4.j(((Long) obj).longValue(), str);
        }
        if (obj instanceof Float) {
            MMKV mmkv5 = this.f8732a;
            kotlin.jvm.internal.e.c(mmkv5);
            kotlin.jvm.internal.e.d(obj, "null cannot be cast to non-null type kotlin.Float");
            return mmkv5.l(str, ((Float) obj).floatValue());
        }
        if (obj instanceof Double) {
            MMKV mmkv6 = this.f8732a;
            kotlin.jvm.internal.e.c(mmkv6);
            kotlin.jvm.internal.e.d(obj, "null cannot be cast to non-null type kotlin.Double");
            return mmkv6.k(str, ((Double) obj).doubleValue());
        }
        if (!(obj instanceof Parcelable)) {
            return false;
        }
        MMKV mmkv7 = this.f8732a;
        kotlin.jvm.internal.e.c(mmkv7);
        kotlin.jvm.internal.e.d(obj, "null cannot be cast to non-null type android.os.Parcelable");
        return mmkv7.m(str, (Parcelable) obj);
    }

    public final void N(String str) {
        MMKV mmkv = this.f8732a;
        kotlin.jvm.internal.e.c(mmkv);
        mmkv.s(str);
    }

    public final void O(String mac, boolean z5) {
        kotlin.jvm.internal.e.f(mac, "mac");
        User d5 = d();
        if (d5 != null) {
            M(Boolean.valueOf(z5), r5.a.c(d5.getUserId(), mac, "setting_anti_lost"));
        }
    }

    public final void P(BlueToothBean blueToothBean) {
        kotlin.jvm.internal.e.f(blueToothBean, "blueToothBean");
        Devices c9 = c();
        if (c9 != null) {
            M(blueToothBean, c9.getMacAddress() + "blue_tooth_info");
        }
    }

    public final void Q(String str) {
        Devices c9 = c();
        if (c9 != null) {
            M(str, c9.getMacAddress() + "custom_dial_path");
        }
    }

    public final void R(DeviceModelInfoBean deviceModelInfoBean) {
        Devices c9 = c();
        if (c9 != null) {
            M(deviceModelInfoBean, c9.getMacAddress() + "device_model_info");
        }
    }

    public final void S(PowerBean power) {
        kotlin.jvm.internal.e.f(power, "power");
        Devices c9 = c();
        if (c9 != null) {
            M(power, c9.getMacAddress() + "device_power_info");
        }
    }

    public final void T(DialInfoBean dialInfoBean) {
        Devices c9 = c();
        if (c9 != null) {
            M(dialInfoBean, c9.getMacAddress() + "device_dial_info");
        }
    }

    public final void U(String str, boolean z5) {
        User d5 = d();
        if (d5 != null) {
            M(Boolean.valueOf(z5), r5.a.c(d5.getUserId(), str, "setting_incoming_call"));
        }
    }

    public final void V(boolean z5) {
        M(Boolean.valueOf(z5), "setting_jl_ota_failed");
    }

    public final void W(int i3) {
        User d5 = d();
        if (d5 != null) {
            M(Integer.valueOf(i3), android.support.v4.media.session.e.l(d5.getUserId(), "muslin_count_target"));
        }
    }

    public final void X(List list) {
        User d5 = d();
        if (d5 != null) {
            M(com.example.baselibrary.utils.b.z(list), android.support.v4.media.session.e.l(d5.getUserId(), "setting_privacy"));
        }
    }

    public final void Y(int i3) {
        User d5 = d();
        if (d5 != null) {
            M(Integer.valueOf(i3), android.support.v4.media.session.e.l(d5.getUserId(), "is_ring_device"));
        }
    }

    public final void Z(int i3) {
        User d5 = d();
        if (d5 != null) {
            M(Integer.valueOf(i3), android.support.v4.media.session.e.l(d5.getUserId(), "ring_remember_select"));
        }
    }

    public final void a(Devices devices) {
        User d5 = d();
        if (d5 != null) {
            M(devices, d5.getUserId() + "device_info_bound");
            M(devices.getMacAddress(), android.support.v4.media.session.e.l(d5.getUserId(), "device_last_info_bound"));
        }
    }

    public final void a0(String mac, boolean z5) {
        kotlin.jvm.internal.e.f(mac, "mac");
        User d5 = d();
        if (d5 != null) {
            M(Boolean.valueOf(z5), r5.a.c(d5.getUserId(), mac, "setting_take_photo"));
        }
    }

    public final void b() {
        Devices c9 = c();
        if (c9 != null) {
            N(c9.getMacAddress() + "gps_track");
        }
    }

    public final void b0() {
        M(Integer.valueOf((D() & 15) | 240), "app_theme_style");
    }

    public final Devices c() {
        MMKV mmkv = this.f8732a;
        if (mmkv == null) {
            return null;
        }
        User d5 = d();
        return (Devices) mmkv.f((d5 != null ? d5.getUserId() : null) + "device_info_bound", Devices.class);
    }

    public final void c0() {
        M(Integer.valueOf(D() & 15), "app_theme_style");
    }

    public final User d() {
        MMKV mmkv = this.f8732a;
        if (mmkv != null) {
            return (User) mmkv.f("user_info_logged", User.class);
        }
        return null;
    }

    public final void d0(int i3) {
        User d5 = d();
        if (d5 != null) {
            M(Integer.valueOf(i3), android.support.v4.media.session.e.l(d5.getUserId(), "wear_derction_select"));
        }
    }

    public final BlueToothBean e() {
        MMKV mmkv;
        Devices c9 = c();
        if (c9 == null || (mmkv = this.f8732a) == null) {
            return null;
        }
        return (BlueToothBean) mmkv.f(c9.getMacAddress() + "blue_tooth_info", BlueToothBean.class);
    }

    public final void e0(String mac, boolean z5) {
        kotlin.jvm.internal.e.f(mac, "mac");
        User d5 = d();
        if (d5 != null) {
            M(Boolean.valueOf(z5), r5.a.c(d5.getUserId(), mac, "setting_weather"));
        }
    }

    public final int f() {
        User d5 = d();
        if (d5 != null) {
            String l3 = android.support.v4.media.session.e.l(d5.getUserId(), "calu_num_target");
            Class cls = Integer.TYPE;
            Integer num = (Integer) i(l3, cls);
            if (num != null && num.intValue() == 0) {
                return 300;
            }
            Integer num2 = (Integer) i(d5.getUserId() + "calu_num_target", cls);
            if (num2 != null) {
                return num2.intValue();
            }
        }
        return 300;
    }

    public final void f0() {
        User d5 = d();
        if (d5 != null) {
            N(d5.getUserId() + "device_info_bound");
        }
    }

    public final String g() {
        Devices c9 = c();
        if (c9 != null) {
            return c9.getMacAddress();
        }
        User d5 = d();
        if (d5 == null) {
            return null;
        }
        return (String) i(d5.getUserId() + "device_last_info_bound", String.class);
    }

    public final String h() {
        Devices c9 = c();
        if (c9 == null) {
            return null;
        }
        return (String) i(c9.getMacAddress() + "custom_dial_path", String.class);
    }

    public final Object i(String str, Class cls) {
        if (kotlin.jvm.internal.e.a(cls, String.class)) {
            MMKV mmkv = this.f8732a;
            kotlin.jvm.internal.e.c(mmkv);
            return mmkv.g(str);
        }
        if (kotlin.jvm.internal.e.a(cls, Boolean.TYPE)) {
            MMKV mmkv2 = this.f8732a;
            kotlin.jvm.internal.e.c(mmkv2);
            return Boolean.valueOf(mmkv2.a(str));
        }
        if (kotlin.jvm.internal.e.a(cls, Integer.TYPE)) {
            MMKV mmkv3 = this.f8732a;
            kotlin.jvm.internal.e.c(mmkv3);
            return Integer.valueOf(mmkv3.d(str));
        }
        if (kotlin.jvm.internal.e.a(cls, Long.TYPE)) {
            MMKV mmkv4 = this.f8732a;
            kotlin.jvm.internal.e.c(mmkv4);
            return Long.valueOf(mmkv4.e(str));
        }
        if (kotlin.jvm.internal.e.a(cls, Double.TYPE)) {
            MMKV mmkv5 = this.f8732a;
            kotlin.jvm.internal.e.c(mmkv5);
            return Double.valueOf(mmkv5.b(str));
        }
        if (kotlin.jvm.internal.e.a(cls, Parcelable.class)) {
            MMKV mmkv6 = this.f8732a;
            kotlin.jvm.internal.e.c(mmkv6);
            return mmkv6.f(str, Parcelable.class);
        }
        if (!kotlin.jvm.internal.e.a(cls, Float.TYPE)) {
            return null;
        }
        MMKV mmkv7 = this.f8732a;
        kotlin.jvm.internal.e.c(mmkv7);
        return Float.valueOf(mmkv7.c(str));
    }

    public final DeviceModelInfoBean j() {
        MMKV mmkv;
        Devices c9 = c();
        if (c9 == null || (mmkv = this.f8732a) == null) {
            return null;
        }
        return (DeviceModelInfoBean) mmkv.f(c9.getMacAddress() + "device_model_info", DeviceModelInfoBean.class);
    }

    public final PowerBean k() {
        MMKV mmkv;
        Devices c9 = c();
        if (c9 == null || (mmkv = this.f8732a) == null) {
            return null;
        }
        return (PowerBean) mmkv.f(c9.getMacAddress() + "device_power_info", PowerBean.class);
    }

    public final SupportMenuBean l() {
        Devices c9;
        MMKV mmkv;
        User d5 = d();
        if (d5 == null || (c9 = c()) == null || (mmkv = this.f8732a) == null) {
            return null;
        }
        return (SupportMenuBean) mmkv.f(d5.getUserId() + c9.getMacAddress() + "device_support", SupportMenuBean.class);
    }

    public final BindInfoBean m() {
        MMKV mmkv;
        Devices c9 = c();
        if (c9 == null || (mmkv = this.f8732a) == null) {
            return null;
        }
        return (BindInfoBean) mmkv.f(c9.getMacAddress() + "device_support_info", BindInfoBean.class);
    }

    public final DialInfoBean n() {
        DialInfoBean dialInfoBean;
        DialInfoBean dialInfoBean2 = new DialInfoBean();
        Devices c9 = c();
        if (c9 != null) {
            MMKV mmkv = this.f8732a;
            if (mmkv != null) {
                dialInfoBean = (DialInfoBean) mmkv.f(c9.getMacAddress() + "device_dial_info", DialInfoBean.class);
            } else {
                dialInfoBean = null;
            }
            if (dialInfoBean != null) {
                dialInfoBean2.setDialType(dialInfoBean.getDialType());
                dialInfoBean2.setWidth(dialInfoBean.getWidth());
                dialInfoBean2.setHeight(dialInfoBean.getHeight());
            }
        }
        return dialInfoBean2;
    }

    public final float o() {
        User d5 = d();
        if (d5 != null) {
            String l3 = android.support.v4.media.session.e.l(d5.getUserId(), "dist_num_target");
            Class cls = Float.TYPE;
            Float f2 = (Float) i(l3, cls);
            if (f2 != null && f2.floatValue() == 0.0f) {
                return 3.0f;
            }
            Float f10 = (Float) i(d5.getUserId() + "dist_num_target", cls);
            if (f10 != null) {
                return f10.floatValue();
            }
        }
        return 3.0f;
    }

    public final ArrayList p() {
        String str;
        Devices c9 = c();
        if (c9 != null) {
            str = (String) i(c9.getMacAddress() + "home_card_data", String.class);
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(com.example.baselibrary.utils.b.h(str, new i().f3204b));
        return arrayList;
    }

    public final Boolean q() {
        return (Boolean) i("setting_jl_ota_failed", Boolean.TYPE);
    }

    public final long r(String mac) {
        Long l3;
        kotlin.jvm.internal.e.f(mac, "mac");
        User d5 = d();
        if (d5 == null || (l3 = (Long) i(r5.a.c(d5.getUserId(), mac, "user_location_weather_time"), Long.TYPE)) == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public final String s() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Devices c9 = c();
        if (c9 == null) {
            return now.format(ofPattern);
        }
        String str = (String) i(c9.getUserId() + "menstrual_start_date", String.class);
        return TextUtils.isEmpty(str) ? now.format(ofPattern) : str;
    }

    public final int t() {
        User d5 = d();
        if (d5 != null) {
            String l3 = android.support.v4.media.session.e.l(d5.getUserId(), "menstrual_cycle_days");
            Class cls = Integer.TYPE;
            Integer num = (Integer) i(l3, cls);
            if (num != null && num.intValue() == 0) {
                return 28;
            }
            Integer num2 = (Integer) i(d5.getUserId() + "menstrual_cycle_days", cls);
            if (num2 != null) {
                return num2.intValue();
            }
        }
        return 28;
    }

    public final int u() {
        User d5 = d();
        if (d5 != null) {
            String l3 = android.support.v4.media.session.e.l(d5.getUserId(), "menstrual_days");
            Class cls = Integer.TYPE;
            Integer num = (Integer) i(l3, cls);
            if (num != null && num.intValue() == 0) {
                return 5;
            }
            Integer num2 = (Integer) i(d5.getUserId() + "menstrual_days", cls);
            if (num2 != null) {
                return num2.intValue();
            }
        }
        return 5;
    }

    public final int v() {
        User d5 = d();
        if (d5 != null) {
            String l3 = android.support.v4.media.session.e.l(d5.getUserId(), "muslin_count_target");
            Class cls = Integer.TYPE;
            Integer num = (Integer) i(l3, cls);
            if (num != null && num.intValue() == 0) {
                return 33;
            }
            Integer num2 = (Integer) i(d5.getUserId() + "muslin_count_target", cls);
            if (num2 != null) {
                return num2.intValue();
            }
        }
        return 33;
    }

    public final ArrayList w() {
        String str;
        User d5 = d();
        if (d5 != null) {
            str = (String) i(d5.getUserId() + "setting_privacy", String.class);
        } else {
            str = null;
        }
        ArrayList arrayList = new ArrayList();
        if (str != null && str.length() != 0) {
            arrayList.addAll(com.example.baselibrary.utils.b.h(str, new j().f3204b));
            return arrayList;
        }
        SwitchBean switchBean = new SwitchBean();
        switchBean.setParaName("isPerson");
        switchBean.setParaValue("1");
        arrayList.add(switchBean);
        SwitchBean switchBean2 = new SwitchBean();
        switchBean2.setParaName("isSport");
        switchBean2.setParaValue("1");
        arrayList.add(switchBean2);
        SwitchBean switchBean3 = new SwitchBean();
        switchBean3.setParaName("isHealth");
        switchBean3.setParaValue("1");
        arrayList.add(switchBean3);
        return arrayList;
    }

    public final int x() {
        User d5 = d();
        if (d5 != null) {
            String l3 = android.support.v4.media.session.e.l(d5.getUserId(), "is_ring_device");
            Class cls = Integer.TYPE;
            Integer num = (Integer) i(l3, cls);
            if (num != null && num.intValue() == 0) {
                return 0;
            }
            Integer num2 = (Integer) i(d5.getUserId() + "is_ring_device", cls);
            if (num2 != null) {
                return num2.intValue();
            }
        }
        return 0;
    }

    public final int y() {
        User d5 = d();
        if (d5 != null) {
            String l3 = android.support.v4.media.session.e.l(d5.getUserId(), "ring_lowbattery_select");
            Class cls = Integer.TYPE;
            Integer num = (Integer) i(l3, cls);
            if (num != null && num.intValue() == 0) {
                return 0;
            }
            Integer num2 = (Integer) i(d5.getUserId() + "ring_lowbattery_select", cls);
            if (num2 != null) {
                return num2.intValue();
            }
        }
        return 0;
    }

    public final int z() {
        User d5 = d();
        if (d5 != null) {
            String l3 = android.support.v4.media.session.e.l(d5.getUserId(), "ring_remember_select");
            Class cls = Integer.TYPE;
            Integer num = (Integer) i(l3, cls);
            if (num != null && num.intValue() == 0) {
                return 0;
            }
            Integer num2 = (Integer) i(d5.getUserId() + "ring_remember_select", cls);
            if (num2 != null) {
                return num2.intValue();
            }
        }
        return 0;
    }
}
