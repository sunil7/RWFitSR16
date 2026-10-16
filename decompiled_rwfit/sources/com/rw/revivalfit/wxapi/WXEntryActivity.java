package com.rw.revivalfit.wxapi;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.test.R$string;
import com.example.test.ui.model.EventBusBeans;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import eh.b;
import kotlin.a;
import yh.d;

/* loaded from: classes2.dex */
public final class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    /* renamed from: y, reason: collision with root package name */
    public final b f11634y = a.b(new oh.a() { // from class: com.rw.revivalfit.wxapi.WXEntryActivity$wxApi$2
        {
            super(0);
        }

        @Override // oh.a
        public final IWXAPI invoke() {
            return WXAPIFactory.createWXAPI(WXEntryActivity.this, "wx1273e8f71f60b697", false);
        }
    });

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i3, int i10, Intent intent) {
        super.onActivityResult(i3, i10, intent);
        StringBuilder sb2 = new StringBuilder("requestCode : ");
        sb2.append(i3);
        sb2.append(" resultCode : ");
        sb2.append(i10);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((IWXAPI) this.f11634y.getValue()).handleIntent(getIntent(), this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        ((IWXAPI) this.f11634y.getValue()).handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public final void onReq(BaseReq baseReq) {
        if (baseReq != null) {
            baseReq.getType();
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public final void onResp(BaseResp baseResp) {
        com.example.baselibrary.utils.b.z(baseResp);
        Integer valueOf = baseResp != null ? Integer.valueOf(baseResp.errCode) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            EventBusBeans.WXLoginInfo wXLoginInfo = new EventBusBeans.WXLoginInfo();
            int type = baseResp.getType();
            if (type == 1) {
                d.b().e(new EventBusBeans.WxCode(((SendAuth.Resp) baseResp).code));
            } else if (type == 18) {
                SubscribeMessage.Resp resp = (SubscribeMessage.Resp) baseResp;
                wXLoginInfo.setOpenId(resp.openId);
                wXLoginInfo.setTemplateId(resp.templateID);
                wXLoginInfo.setScene(resp.scene);
                wXLoginInfo.setAction(resp.action);
                wXLoginInfo.setReserved(resp.reserved);
                d.b().e(wXLoginInfo);
            } else if (type == 19) {
                WXLaunchMiniProgram.Resp resp2 = (WXLaunchMiniProgram.Resp) baseResp;
                wXLoginInfo.setOpenId(resp2.openId);
                wXLoginInfo.setExtMsg(resp2.extMsg);
                wXLoginInfo.setErrStr(resp2.errStr);
                d.b().e(wXLoginInfo);
            }
        } else {
            com.example.baselibrary.utils.d.a(R$string.str_login_fail);
        }
        finish();
    }
}
