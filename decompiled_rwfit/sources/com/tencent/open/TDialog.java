package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.b;
import com.tencent.open.b.h;
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
public class TDialog extends c {

    /* renamed from: c, reason: collision with root package name */
    static final FrameLayout.LayoutParams f11922c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d, reason: collision with root package name */
    static Toast f11923d = null;

    /* renamed from: f, reason: collision with root package name */
    private static WeakReference<ProgressDialog> f11924f;
    private WeakReference<Context> e;

    /* renamed from: g, reason: collision with root package name */
    private String f11925g;

    /* renamed from: h, reason: collision with root package name */
    private OnTimeListener f11926h;

    /* renamed from: i, reason: collision with root package name */
    private IUiListener f11927i;

    /* renamed from: j, reason: collision with root package name */
    private FrameLayout f11928j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.open.c.b f11929k;

    /* renamed from: l, reason: collision with root package name */
    private Handler f11930l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11931m;

    /* renamed from: n, reason: collision with root package name */
    private QQToken f11932n;

    public class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.f11929k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            super.onReceivedError(webView, i3, str, str2);
            TDialog.this.f11926h.onError(new UiError(i3, str, str2));
            if (TDialog.this.e != null && TDialog.this.e.get() != null) {
                Toast.makeText((Context) TDialog.this.e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(j.a().a((Context) TDialog.this.e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f11926h.onComplete(m.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f11926h.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                return str.startsWith("auth://progress");
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(11))) : Uri.parse(Uri.decode(str)));
                intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                if (TDialog.this.e != null && TDialog.this.e.get() != null) {
                    ((Context) TDialog.this.e.get()).startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public class JsListener extends b.C0017b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            SLog.d("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.f11930l.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel("cancel");
        }

        public void onCancelInvite() {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.f11930l.obtainMessage(1, str).sendToTarget();
            SLog.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.f11930l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.f11930l.obtainMessage(3, str).sendToTarget();
        }
    }

    public static class OnTimeListener extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        String f11936a;

        /* renamed from: b, reason: collision with root package name */
        String f11937b;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<Context> f11938c;

        /* renamed from: d, reason: collision with root package name */
        private String f11939d;
        private IUiListener e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f11938c = new WeakReference<>(context);
            this.f11939d = str;
            this.f11936a = str2;
            this.f11937b = str3;
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
            h.a().a(r5.a.f(new StringBuilder(), this.f11939d, "_H5"), SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f11936a, false);
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
                str = uiError.errorMessage + this.f11936a;
            } else {
                str = this.f11936a;
            }
            h.a().a(r5.a.f(new StringBuilder(), this.f11939d, "_H5"), SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
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

    public class THandler extends Handler {

        /* renamed from: b, reason: collision with root package name */
        private OnTimeListener f11941b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f11941b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i3 = message.what;
            if (i3 == 1) {
                this.f11941b.a((String) message.obj);
                return;
            }
            if (i3 == 2) {
                this.f11941b.onCancel();
                return;
            }
            if (i3 == 3) {
                if (TDialog.this.e == null || TDialog.this.e.get() == null) {
                    return;
                }
                TDialog.c((Context) TDialog.this.e.get(), (String) message.obj);
                return;
            }
            if (i3 != 5 || TDialog.this.e == null || TDialog.this.e.get() == null) {
                return;
            }
            TDialog.d((Context) TDialog.this.e.get(), (String) message.obj);
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f11931m = false;
        this.f11932n = null;
        this.e = new WeakReference<>(context);
        this.f11925g = str2;
        this.f11926h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f11930l = new THandler(this.f11926h, context.getMainLooper());
        this.f11927i = iUiListener;
        this.f11932n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f11926h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.c, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a.a(getWindow());
        a();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.TDialog.1
            @Override // java.lang.Runnable
            public void run() {
                View decorView;
                View childAt;
                Window window = TDialog.this.getWindow();
                if (window == null || (decorView = window.getDecorView()) == null || (childAt = ((ViewGroup) decorView).getChildAt(0)) == null) {
                    return;
                }
                childAt.setPadding(0, 0, 0, 0);
            }
        });
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) {
        try {
            JSONObject d5 = m.d(str);
            int i3 = d5.getInt("type");
            String string = d5.getString(SocialConstants.PARAM_SEND_MSG);
            if (i3 == 0) {
                Toast toast = f11923d;
                if (toast == null) {
                    f11923d = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f11923d.setText(string);
                    f11923d.setDuration(0);
                }
                f11923d.show();
                return;
            }
            if (i3 == 1) {
                Toast toast2 = f11923d;
                if (toast2 == null) {
                    f11923d = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f11923d.setText(string);
                    f11923d.setDuration(1);
                }
                f11923d.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        WeakReference<ProgressDialog> weakReference;
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d5 = m.d(str);
            int i3 = d5.getInt("action");
            String string = d5.getString(SocialConstants.PARAM_SEND_MSG);
            if (i3 != 1) {
                if (i3 != 0 || (weakReference = f11924f) == null || weakReference.get() == null || !f11924f.get().isShowing()) {
                    return;
                }
                f11924f.get().dismiss();
                f11924f = null;
                return;
            }
            WeakReference<ProgressDialog> weakReference2 = f11924f;
            if (weakReference2 != null && weakReference2.get() != null) {
                f11924f.get().setMessage(string);
                if (f11924f.get().isShowing()) {
                    return;
                }
                f11924f.get().show();
                return;
            }
            ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(string);
            f11924f = new WeakReference<>(progressDialog);
            progressDialog.show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void a() {
        new TextView(this.e.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.e.get());
        this.f11929k = bVar;
        bVar.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.e.get());
        this.f11928j = cVar;
        cVar.setLayoutParams(layoutParams);
        this.f11928j.setBackgroundColor(-1);
        this.f11928j.addView(this.f11929k);
        setContentView(this.f11928j);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.f11929k.setVerticalScrollBarEnabled(false);
        this.f11929k.setHorizontalScrollBarEnabled(false);
        this.f11929k.setWebViewClient(new FbWebViewClient());
        this.f11929k.setWebChromeClient(this.f12001b);
        this.f11929k.clearFormData();
        WebSettings settings = this.f11929k.getSettings();
        if (settings == null) {
            return;
        }
        com.tencent.open.web.a.a(this.f11929k);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f12000a.a(new JsListener(), "sdk_js_if");
        this.f11929k.loadUrl(this.f11925g);
        this.f11929k.setLayoutParams(f11922c);
        this.f11929k.setVisibility(4);
    }

    @Override // com.tencent.open.c
    public void a(String str) {
        SLog.d("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f12000a.a(this.f11929k, str);
        } catch (Exception unused) {
        }
    }
}
