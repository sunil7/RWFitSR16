package com.tencent.connect.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.SocialConstants;
import com.tencent.open.TDialog;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class AuthAgent extends BaseApi {
    public static final String KEY_FORCE_QR_LOGIN = "KEY_FORCE_QR_LOGIN";
    public static final String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
    public static final String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_NAME = null;
    public static final int SECURE_LIB_VERSION = 5;
    public static final String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
    public static final String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";

    /* renamed from: a, reason: collision with root package name */
    private IUiListener f11700a;

    /* renamed from: d, reason: collision with root package name */
    private String f11701d;
    private WeakReference<Activity> e;

    public class a extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        IUiListener f11707a;

        public a(IUiListener iUiListener) {
            this.f11707a = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f11707a;
            if (iUiListener != null) {
                iUiListener.onCancel();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (obj == null) {
                SLog.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            try {
                int i3 = jSONObject.getInt("ret");
                String string = i3 == 0 ? "success" : jSONObject.getString(SocialConstants.PARAM_SEND_MSG);
                IUiListener iUiListener = this.f11707a;
                if (iUiListener != null) {
                    iUiListener.onComplete(new JSONObject().put("ret", i3).put(SocialConstants.PARAM_SEND_MSG, string));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                SLog.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IUiListener iUiListener = this.f11707a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }
    }

    public class c extends DefaultUiListener {

        /* renamed from: b, reason: collision with root package name */
        private final IUiListener f11724b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f11725c;

        /* renamed from: d, reason: collision with root package name */
        private final Context f11726d;

        public c(Context context, IUiListener iUiListener, boolean z5, boolean z6) {
            this.f11726d = context;
            this.f11724b = iUiListener;
            this.f11725c = z5;
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
            this.f11724b.onCancel();
            SLog.release();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
            JSONObject jSONObject = (JSONObject) obj;
            try {
                String string = jSONObject.getString(Constants.PARAM_ACCESS_TOKEN);
                String string2 = jSONObject.getString(Constants.PARAM_EXPIRES_IN);
                String string3 = jSONObject.getString("openid");
                if (string != null && ((BaseApi) AuthAgent.this).f11836c != null && string3 != null) {
                    ((BaseApi) AuthAgent.this).f11836c.setAccessToken(string, string2);
                    ((BaseApi) AuthAgent.this).f11836c.setOpenId(string3);
                    com.tencent.connect.a.a.d(this.f11726d, ((BaseApi) AuthAgent.this).f11836c);
                }
                String string4 = jSONObject.getString(Constants.PARAM_PLATFORM_ID);
                if (string4 != null) {
                    try {
                        this.f11726d.getSharedPreferences(Constants.PREFERENCE_PF, 0).edit().putString(Constants.PARAM_PLATFORM_ID, string4).commit();
                    } catch (Exception e) {
                        e.printStackTrace();
                        SLog.e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e);
                    }
                }
                if (this.f11725c) {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
                SLog.e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e10);
            }
            this.f11724b.onComplete(jSONObject);
            AuthAgent.this.releaseResource();
            SLog.release();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
            this.f11724b.onError(uiError);
            SLog.release();
        }
    }

    static {
        SECURE_LIB_NAME = r5.a.f(new StringBuilder(), SECURE_LIB_FILE_NAME, ".so");
        String str = Build.CPU_ABI;
        if (str == null || str.equals("")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
            SECURE_LIB_NAME = r5.a.f(new StringBuilder(), SECURE_LIB_FILE_NAME, ".so");
            SLog.i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
            return;
        }
        if (str.equalsIgnoreCase("arm64-v8a")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM64_FILE_NAME;
            SECURE_LIB_NAME = r5.a.f(new StringBuilder(), SECURE_LIB_FILE_NAME, ".so");
            SLog.i("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
        } else if (str.equalsIgnoreCase("x86")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_FILE_NAME;
            SECURE_LIB_NAME = r5.a.f(new StringBuilder(), SECURE_LIB_FILE_NAME, ".so");
            SLog.i("openSDK_LOG.AuthAgent", "is x86 architecture");
        } else if (str.equalsIgnoreCase("x86_64")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_64_FILE_NAME;
            SECURE_LIB_NAME = r5.a.f(new StringBuilder(), SECURE_LIB_FILE_NAME, ".so");
            SLog.i("openSDK_LOG.AuthAgent", "is x86_64 architecture");
        } else {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
            SECURE_LIB_NAME = r5.a.f(new StringBuilder(), SECURE_LIB_FILE_NAME, ".so");
            SLog.i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
        }
    }

    public AuthAgent(QQToken qQToken) {
        super(qQToken);
    }

    private void a(Bundle bundle, Map<String, Object> map) {
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener, boolean z5, Fragment fragment, boolean z6, Map<String, Object> map) {
        if (com.tencent.connect.a.a("openSDK_LOG.AuthAgent", iUiListener)) {
            return -1;
        }
        this.f11701d = str;
        this.e = new WeakReference<>(activity);
        this.f11700a = iUiListener;
        Object[] objArr = new Object[2];
        boolean booleanExtra = activity.getIntent().getBooleanExtra(KEY_FORCE_QR_LOGIN, false);
        boolean b3 = i.a(activity, this.f11836c.getAppId()).b("C_LoginWeb");
        SLog.i("openSDK_LOG.AuthAgent", "doLogin needForceQrLogin=" + booleanExtra + ", toWebLogin=" + b3);
        if (!booleanExtra && !b3 && a(activity, fragment, map, z5, objArr)) {
            SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
            e.a().a(this.f11836c.getOpenId(), this.f11836c.getAppId(), "2", "1", "5", (String) objArr[0], "0", "0");
            return ((Integer) objArr[1]).intValue();
        }
        e.a().a(this.f11836c.getOpenId(), this.f11836c.getAppId(), "2", "1", "5", "1", "0", "0");
        SLog.w("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
        b bVar = new b(this.f11700a);
        this.f11700a = bVar;
        return a(z5, bVar, z6, map);
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        this.f11700a = null;
    }

    public void b(IUiListener iUiListener) {
        Bundle a3 = a();
        a3.putString("reqType", "checkLogin");
        HttpUtils.requestAsync(this.f11836c, g.a(), "https://openmobile.qq.com/v3/user/get_info", a3, Constants.HTTP_GET, new BaseApi.TempRequestListener(new a(iUiListener)));
    }

    public int a(Activity activity, String str, IUiListener iUiListener, boolean z5, Fragment fragment, boolean z6) {
        return doLogin(activity, str, iUiListener, z5, fragment, z6, null);
    }

    private int a(boolean z5, IUiListener iUiListener, boolean z6, Map<String, Object> map) {
        CookieSyncManager.createInstance(g.a());
        Bundle a3 = a();
        if (z5) {
            a3.putString("isadd", "1");
        }
        a3.putString(Constants.PARAM_SCOPE, this.f11701d);
        a3.putString(Constants.PARAM_CLIENT_ID, this.f11836c.getAppId());
        if (BaseApi.isOEM) {
            a3.putString(Constants.PARAM_PLATFORM_ID, "desktop_m_qq-" + BaseApi.installChannel + "-android-" + BaseApi.registerChannel + "-" + BaseApi.businessId);
        } else {
            a3.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        }
        String str = (System.currentTimeMillis() / 1000) + "";
        a3.putString("sign", k.b(g.a(), str));
        a3.putString(Const.JSON_KEY_TIME, str);
        a3.putString("display", "mobile");
        a3.putString("response_type", "token");
        a3.putString("redirect_uri", "auth://tauth.qq.com/");
        a3.putString("cancel_display", "1");
        a3.putString("switch", "1");
        a3.putString("compat_v", "1");
        if (z6) {
            a3.putString("style", "qr");
        }
        boolean a10 = a(map);
        a3.putString("show_download_ui", Boolean.toString(a10));
        SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start, isShowDownloadUi=" + a10);
        final String str2 = j.a().a(g.a(), "https://openmobile.qq.com/oauth2.0/m_authorize?") + HttpUtils.encodeUrl(a3);
        final c cVar = new c(g.a(), iUiListener, true, false);
        SLog.d("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
        l.b(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1
            @Override // java.lang.Runnable
            public void run() {
                final Activity activity;
                k.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                JniInterface.loadSo();
                if (AuthAgent.this.e == null || (activity = (Activity) AuthAgent.this.e.get()) == null) {
                    return;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (JniInterface.isJniOk) {
                            Activity activity2 = activity;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            com.tencent.connect.auth.a aVar = new com.tencent.connect.auth.a(activity2, "action_login", str2, cVar, ((BaseApi) AuthAgent.this).f11836c);
                            if (activity.isFinishing()) {
                                return;
                            }
                            aVar.show();
                            return;
                        }
                        SLog.w("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                        Activity activity3 = activity;
                        String a11 = AuthAgent.this.a("");
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        TDialog tDialog = new TDialog(activity3, "", a11, cVar, ((BaseApi) AuthAgent.this).f11836c);
                        if (activity.isFinishing()) {
                            return;
                        }
                        tDialog.show();
                    }
                });
            }
        });
        SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
        return 2;
    }

    public class b extends DefaultUiListener {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<IUiListener> f11709a;

        /* renamed from: c, reason: collision with root package name */
        private final String f11711c = "sendinstall";

        /* renamed from: d, reason: collision with root package name */
        private final String f11712d = "installwording";
        private final String e = "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

        public abstract class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            Dialog f11722d;

            public a(Dialog dialog) {
                this.f11722d = dialog;
            }
        }

        public b(IUiListener iUiListener) {
            this.f11709a = new WeakReference<>(iUiListener);
        }

        private void a(String str, final IUiListener iUiListener, final Object obj) {
            PackageInfo packageInfo;
            if (AuthAgent.this.e == null) {
                SLog.i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity null and return");
                return;
            }
            Activity activity = (Activity) AuthAgent.this.e.get();
            if (activity == null) {
                SLog.i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity.get() null and return");
                return;
            }
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            PackageManager packageManager = activity.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                SLog.e("openSDK_LOG.AuthAgent", "showFeedConfrimDialog exception:" + e.getStackTrace().toString());
                packageInfo = null;
            }
            Drawable loadIcon = packageInfo != null ? packageInfo.applicationInfo.loadIcon(packageManager) : null;
            View.OnClickListener onClickListener = new a(dialog) { // from class: com.tencent.connect.auth.AuthAgent.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.a();
                    Dialog dialog2 = this.f11722d;
                    if (dialog2 != null && dialog2.isShowing()) {
                        this.f11722d.dismiss();
                    }
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            };
            View.OnClickListener onClickListener2 = new a(dialog) { // from class: com.tencent.connect.auth.AuthAgent.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Dialog dialog2 = this.f11722d;
                    if (dialog2 != null && dialog2.isShowing()) {
                        this.f11722d.dismiss();
                    }
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            };
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setAlpha(0);
            dialog.getWindow().setBackgroundDrawable(colorDrawable);
            dialog.setContentView(a(activity, loadIcon, str, onClickListener, onClickListener2));
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.connect.auth.AuthAgent.b.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            });
            if (activity.isFinishing()) {
                return;
            }
            dialog.show();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.f11709a.get() != null) {
                this.f11709a.get().onCancel();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0093  */
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onComplete(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.String r0 = "openSDK_LOG.AuthAgent"
                if (r8 == 0) goto L98
                r1 = r8
                org.json.JSONObject r1 = (org.json.JSONObject) r1
                r2 = 0
                java.lang.String r3 = "sendinstall"
                int r3 = r1.getInt(r3)     // Catch: org.json.JSONException -> L1a
                r4 = 1
                if (r3 != r4) goto L12
                goto L13
            L12:
                r4 = r2
            L13:
                java.lang.String r3 = "installwording"
                java.lang.String r3 = r1.getString(r3)     // Catch: org.json.JSONException -> L1b
                goto L22
            L1a:
                r4 = r2
            L1b:
                java.lang.String r3 = "FeedConfirmListener onComplete There is no value for sendinstall."
                com.tencent.open.log.SLog.w(r0, r3)
                java.lang.String r3 = ""
            L22:
                java.lang.String r3 = java.net.URLDecoder.decode(r3)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                java.lang.String r6 = " WORDING = "
                r5.<init>(r6)
                r5.append(r3)
                java.lang.String r6 = "xx,showConfirmDialog="
                r5.append(r6)
                r5.append(r4)
                java.lang.String r5 = r5.toString()
                com.tencent.open.log.SLog.i(r0, r5)
                if (r4 == 0) goto L58
                boolean r4 = android.text.TextUtils.isEmpty(r3)
                if (r4 != 0) goto L58
                java.lang.ref.WeakReference<com.tencent.tauth.IUiListener> r1 = r7.f11709a
                java.lang.Object r1 = r1.get()
                com.tencent.tauth.IUiListener r1 = (com.tencent.tauth.IUiListener) r1
                r7.a(r3, r1, r8)
                java.lang.String r8 = " WORDING is not empty and return"
                com.tencent.open.log.SLog.i(r0, r8)
                return
            L58:
                java.lang.ref.WeakReference<com.tencent.tauth.IUiListener> r3 = r7.f11709a
                java.lang.Object r3 = r3.get()
                com.tencent.tauth.IUiListener r3 = (com.tencent.tauth.IUiListener) r3
                if (r3 == 0) goto L93
                com.tencent.connect.auth.AuthAgent r4 = com.tencent.connect.auth.AuthAgent.this
                com.tencent.connect.auth.QQToken r4 = com.tencent.connect.auth.AuthAgent.h(r4)
                if (r4 == 0) goto L85
                com.tencent.connect.auth.AuthAgent r2 = com.tencent.connect.auth.AuthAgent.this
                com.tencent.connect.auth.QQToken r2 = com.tencent.connect.auth.AuthAgent.i(r2)
                boolean r2 = r2.saveSession(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r4 = " saveSession saveSuccess="
                r1.<init>(r4)
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.tencent.open.log.SLog.i(r0, r1)
            L85:
                if (r2 == 0) goto L8b
                r3.onComplete(r8)
                goto L98
            L8b:
                java.lang.String r8 = "持久化失败!"
                r0 = 0
                r1 = -6
                com.google.android.gms.internal.mlkit_vision_barcode.l0.A(r1, r8, r0, r3)
                goto L98
            L93:
                java.lang.String r8 = " userListener is null"
                com.tencent.open.log.SLog.i(r0, r8)
            L98:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.auth.AuthAgent.b.onComplete(java.lang.Object):void");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.f11709a.get() != null) {
                this.f11709a.get().onError(uiError);
            }
        }

        private Drawable a(String str, Context context) {
            InputStream open;
            Bitmap bitmap;
            Drawable drawable = null;
            try {
                open = context.getApplicationContext().getAssets().open(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (open == null) {
                return null;
            }
            if (str.endsWith(".9.png")) {
                try {
                    bitmap = BitmapFactory.decodeStream(open);
                } catch (OutOfMemoryError e10) {
                    e10.printStackTrace();
                    bitmap = null;
                }
                if (bitmap == null) {
                    return null;
                }
                byte[] ninePatchChunk = bitmap.getNinePatchChunk();
                NinePatch.isNinePatchChunk(ninePatchChunk);
                return new NinePatchDrawable(bitmap, ninePatchChunk, new Rect(), null);
            }
            drawable = Drawable.createFromStream(open, str);
            open.close();
            return drawable;
        }

        private View a(Context context, Drawable drawable, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            float f2 = displayMetrics.density;
            RelativeLayout relativeLayout = new RelativeLayout(context);
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setId(1);
            int i3 = (int) (60.0f * f2);
            int i10 = (int) (f2 * 14.0f);
            int i11 = (int) (18.0f * f2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
            layoutParams.addRule(9);
            layoutParams.setMargins(0, i11, (int) (6.0f * f2), i11);
            relativeLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(context);
            textView.setText(str);
            textView.setTextSize(14.0f);
            textView.setGravity(3);
            textView.setIncludeFontPadding(false);
            textView.setPadding(0, 0, 0, 0);
            textView.setLines(2);
            textView.setId(5);
            textView.setMinWidth((int) (185.0f * f2));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, 1);
            layoutParams2.addRule(6, 1);
            float f10 = 5.0f * f2;
            layoutParams2.setMargins(0, 0, (int) f10, 0);
            relativeLayout.addView(textView, layoutParams2);
            View view = new View(context);
            view.setBackgroundColor(Color.rgb(214, 214, 214));
            view.setId(3);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, 2);
            layoutParams3.addRule(3, 1);
            layoutParams3.addRule(5, 1);
            layoutParams3.addRule(7, 5);
            int i12 = (int) (12.0f * f2);
            layoutParams3.setMargins(0, 0, 0, i12);
            relativeLayout.addView(view, layoutParams3);
            LinearLayout linearLayout = new LinearLayout(context);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(5, 1);
            layoutParams4.addRule(7, 5);
            layoutParams4.addRule(3, 3);
            Button button = new Button(context);
            button.setText("跳过");
            button.setBackgroundDrawable(a("buttonNegt.png", context));
            button.setTextColor(Color.rgb(36, 97, 131));
            button.setTextSize(20.0f);
            button.setOnClickListener(onClickListener2);
            button.setId(4);
            int i13 = (int) (45.0f * f2);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, i13);
            layoutParams5.rightMargin = i10;
            int i14 = (int) (4.0f * f2);
            layoutParams5.leftMargin = i14;
            layoutParams5.weight = 1.0f;
            linearLayout.addView(button, layoutParams5);
            Button button2 = new Button(context);
            button2.setText("确定");
            button2.setTextSize(20.0f);
            button2.setTextColor(Color.rgb(255, 255, 255));
            button2.setBackgroundDrawable(a("buttonPost.png", context));
            button2.setOnClickListener(onClickListener);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, i13);
            layoutParams6.weight = 1.0f;
            layoutParams6.rightMargin = i14;
            linearLayout.addView(button2, layoutParams6);
            relativeLayout.addView(linearLayout, layoutParams4);
            ViewGroup.LayoutParams layoutParams7 = new FrameLayout.LayoutParams((int) (279.0f * f2), (int) (f2 * 163.0f));
            relativeLayout.setPadding(i10, 0, i12, i12);
            relativeLayout.setLayoutParams(layoutParams7);
            relativeLayout.setBackgroundColor(Color.rgb(247, 251, 247));
            PaintDrawable paintDrawable = new PaintDrawable(Color.rgb(247, 251, 247));
            paintDrawable.setCornerRadius(f10);
            relativeLayout.setBackgroundDrawable(paintDrawable);
            return relativeLayout;
        }

        public void a() {
            Activity activity;
            Bundle b3 = AuthAgent.this.b();
            if (AuthAgent.this.e == null || (activity = (Activity) AuthAgent.this.e.get()) == null) {
                return;
            }
            HttpUtils.requestAsync(((BaseApi) AuthAgent.this).f11836c, activity, "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", b3, Constants.HTTP_POST, null);
        }
    }

    private boolean a(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            Object obj = map.get(Constants.KEY_ENABLE_SHOW_DOWNLOAD_URL);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return true;
    }

    private boolean a(Activity activity, Fragment fragment, Map<String, Object> map, boolean z5, Object[] objArr) {
        SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
        Intent c9 = c();
        if (c9 != null) {
            Bundle a3 = a();
            if (z5) {
                a3.putString("isadd", "1");
            }
            a3.putString(Constants.PARAM_SCOPE, this.f11701d);
            a3.putString(Constants.PARAM_CLIENT_ID, this.f11836c.getAppId());
            if (BaseApi.isOEM) {
                a3.putString(Constants.PARAM_PLATFORM_ID, "desktop_m_qq-" + BaseApi.installChannel + "-android-" + BaseApi.registerChannel + "-" + BaseApi.businessId);
            } else {
                a3.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
            }
            a3.putString("need_pay", "1");
            a(a3, map);
            a3.putString(Constants.KEY_APP_NAME, k.a(g.a()));
            c9.putExtra(Constants.KEY_ACTION, "action_login");
            c9.putExtra(Constants.KEY_PARAMS, a3);
            c9.putExtra("appid", this.f11836c.getAppId());
            a3.putString(Constants.KEY_PPSTS, k.a(activity, a(a3)));
            try {
                this.f11700a = new b(this.f11700a);
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_LOGIN, this.f11700a);
                if (fragment != null) {
                    SLog.d("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                    a(fragment, c9, Constants.REQUEST_LOGIN, map);
                } else {
                    SLog.d("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                    a(activity, c9, Constants.REQUEST_LOGIN, map);
                }
                SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                e.a().a(0, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.f11836c.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                objArr[0] = "0";
                objArr[1] = 1;
                return true;
            } catch (Exception e) {
                SLog.e("openSDK_LOG.AuthAgent", "startActionActivity() exception", e);
            }
        }
        e.a().a(1, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.f11836c.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
        return false;
    }

    private String a(Bundle bundle) {
        String string = bundle.getString("status_os");
        String string2 = bundle.getString("status_machine");
        String string3 = bundle.getString("status_version");
        String string4 = bundle.getString("sdkv");
        String string5 = bundle.getString(Constants.PARAM_CLIENT_ID);
        String string6 = bundle.getString("need_pay");
        String string7 = bundle.getString(Constants.PARAM_PLATFORM_ID);
        StringBuilder v6 = l0.v("os=", string, ", machine=", string2, ", version=");
        android.support.v4.media.session.e.z(v6, string3, ", sdkv=", string4, ", appId=");
        android.support.v4.media.session.e.z(v6, string5, ", needPay=", string6, ", pf=");
        v6.append(string7);
        SLog.d("openSDK_LOG.AuthAgent", v6.toString());
        StringBuilder sb2 = new StringBuilder();
        if (string == null) {
            string = "";
        }
        sb2.append(string);
        if (string2 == null) {
            string2 = "";
        }
        sb2.append(string2);
        if (string3 == null) {
            string3 = "";
        }
        sb2.append(string3);
        if (string4 == null) {
            string4 = "";
        }
        sb2.append(string4);
        if (string5 == null) {
            string5 = "";
        }
        sb2.append(string5);
        if (string6 == null) {
            string6 = "";
        }
        sb2.append(string6);
        if (string7 == null) {
            string7 = "";
        }
        sb2.append(string7);
        return sb2.toString();
    }

    public void a(IUiListener iUiListener) {
        String str;
        SLog.i("openSDK_LOG.AuthAgent", "reportDAU() -- start");
        String accessToken = this.f11836c.getAccessToken();
        String openId = this.f11836c.getOpenId();
        String appId = this.f11836c.getAppId();
        if (!TextUtils.isEmpty(accessToken) && !TextUtils.isEmpty(openId) && !TextUtils.isEmpty(appId)) {
            str = m.g("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            SLog.e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
            return;
        }
        Bundle a3 = a();
        a3.putString("encrytoken", str);
        HttpUtils.requestAsync(this.f11836c, g.a(), "https://openmobile.qq.com/user/user_login_statis", a3, Constants.HTTP_POST, null);
        SLog.i("openSDK_LOG.AuthAgent", "reportDAU() -- end");
    }
}
