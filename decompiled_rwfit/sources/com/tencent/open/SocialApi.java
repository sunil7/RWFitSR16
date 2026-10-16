package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;

/* loaded from: classes2.dex */
public class SocialApi {

    /* renamed from: a, reason: collision with root package name */
    private SocialApiIml f11905a;

    public SocialApi(QQToken qQToken) {
        this.f11905a = new SocialApiIml(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f11905a.ask(activity, bundle, iUiListener);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f11905a.gift(activity, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f11905a.invite(activity, bundle, iUiListener);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f11905a.story(activity, bundle, iUiListener);
    }
}
