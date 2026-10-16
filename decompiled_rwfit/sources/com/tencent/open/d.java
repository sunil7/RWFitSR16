package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.b;
import com.tencent.open.b.h;
import com.tencent.open.c.a;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.j;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class d extends com.tencent.open.c implements a.InterfaceC0018a {

    /* renamed from: c, reason: collision with root package name */
    static Toast f12010c;

    /* renamed from: d, reason: collision with root package name */
    private String f12011d;
    private IUiListener e;

    /* renamed from: f, reason: collision with root package name */
    private c f12012f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f12013g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.open.c.a f12014h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.open.c.b f12015i;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<Context> f12016j;

    /* renamed from: k, reason: collision with root package name */
    private int f12017k;

    public class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            d.this.f12015i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            super.onReceivedError(webView, i3, str, str2);
            d.this.f12012f.onError(new UiError(i3, str, str2));
            if (d.this.f12016j != null && d.this.f12016j.get() != null) {
                Toast.makeText((Context) d.this.f12016j.get(), "网络连接异常或系统错误", 0).show();
            }
            d.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(j.a().a((Context) d.this.f12016j.get(), "auth://tauth.qq.com/"))) {
                d.this.f12012f.onComplete(m.c(str));
                d.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                d.this.f12012f.onCancel();
                d.this.dismiss();
                return true;
            }
            if (!str.startsWith(Constants.CLOSE_URI)) {
                return false;
            }
            d.this.dismiss();
            return true;
        }
    }

    public class b extends b.C0017b {
        private b() {
        }
    }

    public static class c extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        String f12020a;

        /* renamed from: b, reason: collision with root package name */
        String f12021b;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<Context> f12022c;

        /* renamed from: d, reason: collision with root package name */
        private String f12023d;
        private IUiListener e;

        public c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f12022c = new WeakReference<>(context);
            this.f12023d = str;
            this.f12020a = str2;
            this.f12021b = str3;
            this.e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h.a().a(r5.a.f(new StringBuilder(), this.f12023d, "_H5"), SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f12020a, false);
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f12020a;
            } else {
                str = this.f12020a;
            }
            h.a().a(r5.a.f(new StringBuilder(), this.f12023d, "_H5"), SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            try {
                onComplete(m.d(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* renamed from: com.tencent.open.d$d, reason: collision with other inner class name */
    public class HandlerC0019d extends Handler {

        /* renamed from: b, reason: collision with root package name */
        private c f12025b;

        public HandlerC0019d(c cVar, Looper looper) {
            super(looper);
            this.f12025b = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i3 = message.what;
            if (i3 == 1) {
                this.f12025b.a((String) message.obj);
                return;
            }
            if (i3 == 2) {
                this.f12025b.onCancel();
                return;
            }
            if (i3 == 3) {
                if (d.this.f12016j == null || d.this.f12016j.get() == null) {
                    return;
                }
                d.c((Context) d.this.f12016j.get(), (String) message.obj);
                return;
            }
            if (i3 != 5 || d.this.f12016j == null || d.this.f12016j.get() == null) {
                return;
            }
            d.d((Context) d.this.f12016j.get(), (String) message.obj);
        }
    }

    public d(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f12016j = new WeakReference<>(context);
        this.f12011d = str2;
        this.f12012f = new c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f12013g = new HandlerC0019d(this.f12012f, context.getMainLooper());
        this.e = iUiListener;
        this.f12017k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        SLog.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.f12017k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d5 = m.d(str);
            d5.getInt("action");
            d5.getString(SocialConstants.PARAM_SEND_MSG);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.c, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.f12015i.setVerticalScrollBarEnabled(false);
        this.f12015i.setHorizontalScrollBarEnabled(false);
        this.f12015i.setWebViewClient(new a());
        this.f12015i.setWebChromeClient(this.f12001b);
        this.f12015i.clearFormData();
        WebSettings settings = this.f12015i.getSettings();
        if (settings == null) {
            return;
        }
        com.tencent.open.web.a.a(this.f12015i);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.f12016j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f12016j.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f12000a.a(new b(), "sdk_js_if");
        this.f12015i.clearView();
        this.f12015i.loadUrl(this.f12011d);
    }

    private void b() {
        com.tencent.open.c.a aVar = new com.tencent.open.c.a(this.f12016j.get());
        this.f12014h = aVar;
        aVar.setBackgroundColor(1711276032);
        this.f12014h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f12016j.get());
        this.f12015i = bVar;
        bVar.setBackgroundColor(0);
        this.f12015i.setBackgroundDrawable(null);
        try {
            View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f12015i, 1, new Paint());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f12017k);
        layoutParams.addRule(13, -1);
        this.f12015i.setLayoutParams(layoutParams);
        this.f12014h.addView(this.f12015i);
        this.f12014h.a(this);
        setContentView(this.f12014h);
    }

    @Override // com.tencent.open.c.a.InterfaceC0018a
    public void a(int i3) {
        WeakReference<Context> weakReference = this.f12016j;
        if (weakReference != null && weakReference.get() != null) {
            if (i3 < this.f12017k && 2 == this.f12016j.get().getResources().getConfiguration().orientation) {
                this.f12015i.getLayoutParams().height = i3;
            } else {
                this.f12015i.getLayoutParams().height = this.f12017k;
            }
        }
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.c.a.InterfaceC0018a
    public void a() {
        this.f12015i.getLayoutParams().height = this.f12017k;
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.c
    public void a(String str) {
        SLog.d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.f12000a.a(this.f12015i, str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject d5 = m.d(str);
            int i3 = d5.getInt("type");
            String string = d5.getString(SocialConstants.PARAM_SEND_MSG);
            if (i3 == 0) {
                Toast toast = f12010c;
                if (toast == null) {
                    f12010c = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f12010c.setText(string);
                    f12010c.setDuration(0);
                }
                f12010c.show();
                return;
            }
            if (i3 == 1) {
                Toast toast2 = f12010c;
                if (toast2 == null) {
                    f12010c = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f12010c.setText(string);
                    f12010c.setDuration(1);
                }
                f12010c.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
