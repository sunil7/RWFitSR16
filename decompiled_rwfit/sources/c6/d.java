package c6;

import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.LoginResultBean;
import rg.l;

/* loaded from: classes.dex */
public final class d extends a6.c {

    /* renamed from: c, reason: collision with root package name */
    public static final d f3392c = new d();

    @Override // a6.c
    public final Object a() {
        Object create = b().create(UserApi.class);
        kotlin.jvm.internal.e.e(create, "create(...)");
        return (UserApi) create;
    }

    public final l d(String str, String str2, String str3) {
        l<HttpModel<LoginResultBean>> register = ((UserApi) this.f113a).register(str, str2, str3);
        kotlin.jvm.internal.e.e(register, "register(...)");
        return com.example.baselibrary.utils.b.w(register);
    }

    public final l e(String str, String str2, String sex, String height, String weight, String str3, String sportTarget) {
        kotlin.jvm.internal.e.f(sex, "sex");
        kotlin.jvm.internal.e.f(height, "height");
        kotlin.jvm.internal.e.f(weight, "weight");
        kotlin.jvm.internal.e.f(sportTarget, "sportTarget");
        l<HttpModel<String>> updateUserInfo = ((UserApi) this.f113a).updateUserInfo(str, str2, sex, height, weight, str3, sportTarget);
        kotlin.jvm.internal.e.e(updateUserInfo, "updateUserInfo(...)");
        return com.example.baselibrary.utils.b.w(updateUserInfo);
    }
}
