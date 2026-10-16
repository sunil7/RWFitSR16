package com.tencent.connect.auth;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.auth.b;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.tencent.open.b.h;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private String f11733a;

    /* renamed from: b, reason: collision with root package name */
    private b f11734b;

    /* renamed from: c, reason: collision with root package name */
    private IUiListener f11735c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f11736d;
    private FrameLayout e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f11737f;

    /* renamed from: g, reason: collision with root package name */
    private FrameLayout f11738g;

    /* renamed from: h, reason: collision with root package name */
    private ProgressBar f11739h;

    /* renamed from: i, reason: collision with root package name */
    private String f11740i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.open.c.d f11741j;

    /* renamed from: k, reason: collision with root package name */
    private Context f11742k;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.open.web.security.b f11743l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11744m;

    /* renamed from: n, reason: collision with root package name */
    private int f11745n;

    /* renamed from: o, reason: collision with root package name */
    private String f11746o;

    /* renamed from: p, reason: collision with root package name */
    private String f11747p;

    /* renamed from: q, reason: collision with root package name */
    private long f11748q;
    private long r;

    /* renamed from: s, reason: collision with root package name */
    private HashMap<String, Runnable> f11749s;

    /* renamed from: com.tencent.connect.auth.a$a, reason: collision with other inner class name */
    public class C0014a extends WebViewClient {
        private C0014a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            a.this.f11738g.setVisibility(8);
            if (a.this.f11741j != null) {
                a.this.f11741j.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.this.f11736d.removeCallbacks((Runnable) a.this.f11749s.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            a.this.f11738g.setVisibility(0);
            a.this.f11748q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.f11746o)) {
                a.this.f11736d.removeCallbacks((Runnable) a.this.f11749s.remove(a.this.f11746o));
            }
            a.this.f11746o = str;
            a aVar = a.this;
            d dVar = aVar.new d(aVar.f11746o);
            a.this.f11749s.put(str, dVar);
            a.this.f11736d.postDelayed(dVar, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            super.onReceivedError(webView, i3, str, str2);
            SLog.i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i3 + " | description: " + str);
            if (!m.b(a.this.f11742k)) {
                a.this.f11734b.onError(new UiError(9001, "当前网络不可用，请稍后重试！", str2));
                a.this.dismiss();
                return;
            }
            if (a.this.f11746o.startsWith("https://imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                a.this.f11734b.onError(new UiError(i3, str, str2));
                a.this.dismiss();
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f11748q;
            if (a.this.f11745n >= 1 || elapsedRealtime >= a.this.r) {
                a.this.f11741j.loadUrl(a.this.a());
            } else {
                a.m(a.this);
                a.this.f11736d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f11741j.loadUrl(a.this.f11746o);
                    }
                }, 500L);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            SLog.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            List<String> pathSegments;
            SLog.v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject c9 = m.c(str);
                a aVar = a.this;
                aVar.f11744m = aVar.e();
                if (!a.this.f11744m) {
                    if (c9.optString("fail_cb", null) != null) {
                        a.this.a(c9.optString("fail_cb"), "");
                    } else if (c9.optInt("fall_to_wv") == 1) {
                        a aVar2 = a.this;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(a.this.f11733a);
                        sb2.append(a.this.f11733a.indexOf("?") > -1 ? Const.STR_MART_ADD : "?");
                        aVar2.f11733a = sb2.toString();
                        a.this.f11733a = a.this.f11733a + "browser_error=1";
                        a.this.f11741j.loadUrl(a.this.f11733a);
                    } else {
                        String optString = c9.optString("redir", null);
                        if (optString != null) {
                            a.this.f11741j.loadUrl(optString);
                        }
                    }
                }
                return true;
            }
            if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.f11734b.onComplete(m.c(str));
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                a.this.f11734b.onCancel();
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.DOWNLOAD_URI) || str.endsWith(".apk")) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(11))) : Uri.parse(Uri.decode(str)));
                    intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                    a.this.f11742k.startActivity(intent);
                } catch (Exception e) {
                    SLog.e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e);
                }
                return true;
            }
            if (!str.startsWith("auth://progress")) {
                if (str.startsWith("auth://onLoginSubmit")) {
                    try {
                        List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                        if (!pathSegments2.isEmpty()) {
                            a.this.f11747p = pathSegments2.get(0);
                        }
                    } catch (Exception unused) {
                    }
                    return true;
                }
                if (a.this.f11743l.a(a.this.f11741j, str)) {
                    return true;
                }
                SLog.i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                return false;
            }
            try {
                pathSegments = Uri.parse(str).getPathSegments();
            } catch (Exception unused2) {
            }
            if (pathSegments.isEmpty()) {
                return true;
            }
            int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
            if (intValue == 0) {
                a.this.f11738g.setVisibility(8);
                a.this.f11741j.setVisibility(0);
            } else if (intValue == 1) {
                a.this.f11738g.setVisibility(0);
            }
            return true;
        }
    }

    public class b extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        String f11756a;

        /* renamed from: b, reason: collision with root package name */
        String f11757b;

        /* renamed from: d, reason: collision with root package name */
        private String f11759d;
        private IUiListener e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.f11759d = str;
            this.f11756a = str2;
            this.f11757b = str3;
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
            h.a().a(r5.a.f(new StringBuilder(), this.f11759d, "_H5"), SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f11756a, false);
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
                str = uiError.errorMessage + this.f11756a;
            } else {
                str = this.f11756a;
            }
            String str2 = str;
            h.a().a(r5.a.f(new StringBuilder(), this.f11759d, "_H5"), SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str2, false);
            a.this.a(str2);
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

    public class c extends Handler {

        /* renamed from: b, reason: collision with root package name */
        private b f11761b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.f11761b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                this.f11761b.a((String) message.obj);
            } else if (i3 == 2) {
                this.f11761b.onCancel();
            } else {
                if (i3 != 3) {
                    return;
                }
                a.b(a.this.f11742k, (String) message.obj);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        String f11762a;

        public d(String str) {
            this.f11762a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SLog.v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f11762a + " | mRetryUrl: " + a.this.f11746o);
            if (this.f11762a.equals(a.this.f11746o)) {
                a.this.f11734b.onError(new UiError(9002, "请求页面超时，请稍后重试！", a.this.f11746o));
                a.this.dismiss();
            }
        }
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f11744m = false;
        this.f11748q = 0L;
        this.r = 30000L;
        this.f11742k = context;
        this.f11733a = str2;
        this.f11734b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.f11736d = new c(this.f11734b, context.getMainLooper());
        this.f11735c = iUiListener;
        this.f11740i = str;
        this.f11743l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    public static /* synthetic */ int m(a aVar) {
        int i3 = aVar.f11745n;
        aVar.f11745n = i3 + 1;
        return i3;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f11749s.clear();
        this.f11736d.removeCallbacksAndMessages(null);
        try {
            Context context = this.f11742k;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && isShowing()) {
                super.dismiss();
                SLog.i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e) {
            SLog.e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e);
        }
        com.tencent.open.c.d dVar = this.f11741j;
        if (dVar != null) {
            dVar.destroy();
            this.f11741j = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.f11744m) {
            this.f11734b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.tencent.open.a.a(getWindow());
        b();
        d();
        this.f11749s = new HashMap<>();
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        com.tencent.connect.auth.b a3 = com.tencent.connect.auth.b.a();
        String c9 = a3.c();
        b.a aVar = new b.a();
        aVar.f11768a = this.f11735c;
        aVar.f11769b = this;
        aVar.f11770c = c9;
        String a10 = a3.a(aVar);
        String str = this.f11733a;
        String substring = str.substring(0, str.indexOf("?"));
        Bundle b3 = m.b(this.f11733a);
        b3.putString("token_key", c9);
        b3.putString("serial", a10);
        b3.putString("browser", "1");
        String str2 = substring + "?" + HttpUtils.encodeUrl(b3);
        this.f11733a = str2;
        return m.a(this.f11742k, str2);
    }

    private void b() {
        c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.d dVar = new com.tencent.open.c.d(this.f11742k);
        this.f11741j = dVar;
        dVar.setLayerType(1, null);
        this.f11741j.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.f11742k);
        cVar.setLayoutParams(layoutParams);
        cVar.addView(this.f11741j);
        FrameLayout frameLayout = new FrameLayout(this.f11742k);
        this.e = frameLayout;
        frameLayout.addView(cVar);
        this.e.setBackgroundColor(-1);
        this.e.addView(this.f11738g);
        String string = m.b(this.f11733a).getString("style");
        if (string != null && "qr".equals(string)) {
            a(this.e);
        }
        setContentView(this.e);
    }

    private void c() {
        TextView textView;
        this.f11739h = new ProgressBar(this.f11742k);
        this.f11739h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f11737f = new LinearLayout(this.f11742k);
        if (this.f11740i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.f11742k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f11737f.setLayoutParams(layoutParams2);
        this.f11737f.addView(this.f11739h);
        if (textView != null) {
            this.f11737f.addView(textView);
        }
        this.f11738g = new FrameLayout(this.f11742k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.f11738g.setLayoutParams(layoutParams3);
        this.f11738g.setBackgroundColor(Color.parseColor("#B3000000"));
        this.f11738g.addView(this.f11737f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.f11741j.setVerticalScrollBarEnabled(false);
        this.f11741j.setHorizontalScrollBarEnabled(false);
        this.f11741j.setWebViewClient(new C0014a());
        this.f11741j.setWebChromeClient(new WebChromeClient());
        this.f11741j.clearFormData();
        this.f11741j.clearSslPreferences();
        this.f11741j.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.f11741j.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.a.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        WebSettings settings = this.f11741j.getSettings();
        com.tencent.open.web.a.a(this.f11741j);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f11742k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        SLog.v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f11733a);
        String str = this.f11733a;
        this.f11746o = str;
        this.f11741j.loadUrl(str);
        this.f11741j.setVisibility(4);
        this.f11743l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    if (JniInterface.isJniOk) {
                        JniInterface.clearAllPWD();
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.f11747p) && this.f11747p.length() >= 4) {
            String str2 = this.f11747p;
            String substring = str2.substring(str2.length() - 4);
            sb2.append("_u_");
            sb2.append(substring);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        String str = this.f11733a;
        String str2 = "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        SLog.i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return str2;
    }

    private void a(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.f11742k);
        int a3 = com.tencent.connect.avatar.a.a(this.f11742k, 15.6f);
        int a10 = com.tencent.connect.avatar.a.a(this.f11742k, 25.2f);
        int a11 = com.tencent.connect.avatar.a.a(this.f11742k, 10.0f);
        int i3 = a11 * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a3 + i3, a10 + i3);
        layoutParams.leftMargin = a11;
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(a11, a11, a11, a11);
        imageView.setImageDrawable(m.a("h5_qr_back.png", this.f11742k));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.connect.auth.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                if (a.this.f11744m || a.this.f11734b == null) {
                    return;
                }
                a.this.f11734b.onCancel();
            }
        });
        viewGroup.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            JSONObject d5 = m.d(str);
            int i3 = d5.getInt("type");
            Toast.makeText(context.getApplicationContext(), d5.getString(SocialConstants.PARAM_SEND_MSG), i3).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        StringBuilder v6 = l0.v("javascript:", str, "(", str2, ");void(");
        v6.append(System.currentTimeMillis());
        v6.append(");");
        this.f11741j.loadUrl(v6.toString());
    }
}
