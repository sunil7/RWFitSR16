package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.e;
import com.tencent.open.b.h;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ImageActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    RelativeLayout f11773a;

    /* renamed from: b, reason: collision with root package name */
    private QQToken f11774b;

    /* renamed from: c, reason: collision with root package name */
    private String f11775c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f11776d;
    private c e;

    /* renamed from: f, reason: collision with root package name */
    private Button f11777f;

    /* renamed from: g, reason: collision with root package name */
    private Button f11778g;

    /* renamed from: h, reason: collision with root package name */
    private b f11779h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f11780i;

    /* renamed from: j, reason: collision with root package name */
    private ProgressBar f11781j;
    private String r;

    /* renamed from: s, reason: collision with root package name */
    private Bitmap f11789s;

    /* renamed from: k, reason: collision with root package name */
    private int f11782k = 0;

    /* renamed from: l, reason: collision with root package name */
    private boolean f11783l = false;

    /* renamed from: m, reason: collision with root package name */
    private long f11784m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f11785n = 0;

    /* renamed from: o, reason: collision with root package name */
    private final int f11786o = GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;

    /* renamed from: p, reason: collision with root package name */
    private final int f11787p = GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;

    /* renamed from: q, reason: collision with root package name */
    private Rect f11788q = new Rect();

    /* renamed from: t, reason: collision with root package name */
    private final View.OnClickListener f11790t = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.f11781j.setVisibility(0);
            ImageActivity.this.f11778g.setEnabled(false);
            ImageActivity.this.f11778g.setTextColor(Color.rgb(21, 21, 21));
            ImageActivity.this.f11777f.setEnabled(false);
            ImageActivity.this.f11777f.setTextColor(Color.rgb(36, 94, 134));
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageActivity.this.c();
                }
            }).start();
            if (ImageActivity.this.f11783l) {
                ImageActivity.this.a("10657", 0L);
                return;
            }
            ImageActivity.this.a("10655", System.currentTimeMillis() - ImageActivity.this.f11784m);
            if (ImageActivity.this.e.f11811b) {
                ImageActivity.this.a("10654", 0L);
            }
        }
    };

    /* renamed from: u, reason: collision with root package name */
    private final View.OnClickListener f11791u = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.a("10656", System.currentTimeMillis() - ImageActivity.this.f11784m);
            ImageActivity.this.setResult(0);
            ImageActivity.this.d();
        }
    };

    /* renamed from: v, reason: collision with root package name */
    private final IUiListener f11792v = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.5
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            ImageActivity.this.f11778g.setEnabled(true);
            int i3 = -1;
            ImageActivity.this.f11778g.setTextColor(-1);
            ImageActivity.this.f11777f.setEnabled(true);
            ImageActivity.this.f11777f.setTextColor(-1);
            ImageActivity.this.f11781j.setVisibility(8);
            JSONObject jSONObject = (JSONObject) obj;
            try {
                i3 = jSONObject.getInt("ret");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i3 != 0) {
                ImageActivity.this.a("设置出错了，请重新登录再尝试下呢：）", 1);
                e.a().a(ImageActivity.this.f11774b.getOpenId(), ImageActivity.this.f11774b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_ACT_TYPE_NINETEEN, "1");
                return;
            }
            ImageActivity.this.a("设置成功", 0);
            ImageActivity.this.a("10658", 0L);
            e.a().a(ImageActivity.this.f11774b.getOpenId(), ImageActivity.this.f11774b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, "3", "0");
            ImageActivity imageActivity = ImageActivity.this;
            if (imageActivity.f11775c != null && !"".equals(ImageActivity.this.f11775c)) {
                Intent intent = new Intent();
                intent.setClassName(imageActivity, ImageActivity.this.f11775c);
                if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                    imageActivity.startActivity(intent);
                }
            }
            ImageActivity.this.a(0, jSONObject.toString(), null, null);
            ImageActivity.this.d();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            ImageActivity.this.f11778g.setEnabled(true);
            ImageActivity.this.f11778g.setTextColor(-1);
            ImageActivity.this.f11777f.setEnabled(true);
            ImageActivity.this.f11777f.setTextColor(-1);
            ImageActivity.this.f11777f.setText("重试");
            ImageActivity.this.f11781j.setVisibility(8);
            ImageActivity.this.f11783l = true;
            ImageActivity.this.a(uiError.errorMessage, 1);
            ImageActivity.this.a("10660", 0L);
        }
    };

    /* renamed from: w, reason: collision with root package name */
    private final IUiListener f11793w = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.6
        private void a(int i3) {
            if (ImageActivity.this.f11782k < 2) {
                ImageActivity.this.e();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            int i3 = -1;
            try {
                i3 = jSONObject.getInt("ret");
                if (i3 == 0) {
                    final String string = jSONObject.getString("nickname");
                    ImageActivity.this.f11776d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageActivity.this.c(string);
                        }
                    });
                    ImageActivity.this.a("10659", 0L);
                } else {
                    ImageActivity.this.a("10661", 0L);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i3 != 0) {
                a(i3);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            a(0);
        }
    };

    public class QQAvatarImp extends BaseApi {
        public QQAvatarImp(QQToken qQToken) {
            super(qQToken);
        }

        public void setAvator(Bitmap bitmap, IUiListener iUiListener) {
            Bundle a3 = a();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
            a3.putByteArray("picture", byteArray);
            HttpUtils.requestAsync(this.f11836c, g.a(), "user/set_user_face", a3, Constants.HTTP_POST, tempRequestListener);
            e.a().a(this.f11836c.getOpenId(), this.f11836c.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_ACT_TYPE_NINETEEN, "0");
        }
    }

    public class a extends View {
        public a(Context context) {
            super(context);
        }

        public void a(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable b3 = ImageActivity.this.b("com.tencent.plus.blue_normal.png");
            Drawable b10 = ImageActivity.this.b("com.tencent.plus.blue_down.png");
            Drawable b11 = ImageActivity.this.b("com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b10);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b3);
            stateListDrawable.addState(View.ENABLED_STATE_SET, b3);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, b3);
            stateListDrawable.addState(View.EMPTY_STATE_SET, b11);
            button.setBackgroundDrawable(stateListDrawable);
        }

        public void b(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable b3 = ImageActivity.this.b("com.tencent.plus.gray_normal.png");
            Drawable b10 = ImageActivity.this.b("com.tencent.plus.gray_down.png");
            Drawable b11 = ImageActivity.this.b("com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b10);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b3);
            stateListDrawable.addState(View.ENABLED_STATE_SET, b3);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, b3);
            stateListDrawable.addState(View.EMPTY_STATE_SET, b11);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        d();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(a());
        this.f11776d = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra(Constants.KEY_PARAMS);
        this.r = bundleExtra.getString("picture");
        this.f11775c = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString(Constants.PARAM_ACCESS_TOKEN);
        long j4 = bundleExtra.getLong(Constants.PARAM_EXPIRES_IN);
        String string3 = bundleExtra.getString("openid");
        this.f11785n = bundleExtra.getInt("exitAnim");
        QQToken qQToken = new QQToken(string);
        this.f11774b = qQToken;
        qQToken.setAccessToken(string2, ((j4 - System.currentTimeMillis()) / 1000) + "");
        this.f11774b.setOpenId(string3);
        b();
        e();
        this.f11784m = System.currentTimeMillis();
        a("10653", 0L);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.e.setImageBitmap(null);
        Bitmap bitmap = this.f11789s;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f11789s.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        float width = this.f11788q.width();
        Matrix imageMatrix = this.e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f2 = fArr[2];
        float f10 = fArr[5];
        float f11 = fArr[0];
        float f12 = 640.0f / width;
        Rect rect = this.f11788q;
        int i3 = (int) ((rect.left - f2) / f11);
        int i10 = i3 < 0 ? 0 : i3;
        int i11 = (int) ((rect.top - f10) / f11);
        int i12 = i11 < 0 ? 0 : i11;
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(f12, f12);
        int i13 = (int) (650.0f / f11);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f11789s, i10, i12, Math.min(this.f11789s.getWidth() - i10, i13), Math.min(this.f11789s.getHeight() - i12, i13), matrix, true);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH);
            createBitmap.recycle();
            a(createBitmap2);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e.getMessage());
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        finish();
        int i3 = this.f11785n;
        if (i3 != 0) {
            overridePendingTransition(0, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f11782k++;
        new UserInfo(this, this.f11774b).getUserInfo(this.f11793w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable b(String str) {
        return m.a(str, this);
    }

    private void b() {
        Bitmap a3;
        try {
            a3 = a(this.r);
            this.f11789s = a3;
        } catch (IOException e) {
            e.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e.getMessage());
            d();
        }
        if (a3 == null) {
            throw new IOException("cannot read picture: '" + this.r + "'!");
        }
        this.e.setImageBitmap(a3);
        this.f11777f.setOnClickListener(this.f11790t);
        this.f11778g.setOnClickListener(this.f11791u);
        this.f11773a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.connect.avatar.ImageActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ImageActivity.this.f11773a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ImageActivity imageActivity = ImageActivity.this;
                imageActivity.f11788q = imageActivity.f11779h.a();
                ImageActivity.this.e.a(ImageActivity.this.f11788q);
            }
        });
    }

    private String d(String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", Const.STR_MART_ADD);
    }

    private Bitmap a(String str) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i3 = 1;
        options.inJustDecodeBounds = true;
        Uri parse = Uri.parse(str);
        InputStream openInputStream = getContentResolver().openInputStream(parse);
        if (openInputStream == null) {
            return null;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        openInputStream.close();
        int i10 = options.outWidth;
        int i11 = options.outHeight;
        while (i10 * i11 > 4194304) {
            i10 /= 2;
            i11 /= 2;
            i3 *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i3;
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i3) {
        Toast makeText = Toast.makeText(this, str, 1);
        LinearLayout linearLayout = (LinearLayout) makeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 16.0f), com.tencent.connect.avatar.a.a(this, 16.0f)));
        if (i3 == 0) {
            imageView.setImageDrawable(b("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(b("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        makeText.setView(linearLayout);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    private View a() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f11773a = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.f11773a.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(layoutParams3);
        this.f11773a.addView(relativeLayout2);
        c cVar = new c(this);
        this.e = cVar;
        cVar.setLayoutParams(layoutParams2);
        this.e.setScaleType(ImageView.ScaleType.MATRIX);
        relativeLayout2.addView(this.e);
        this.f11779h = new b(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.f11779h.setLayoutParams(layoutParams4);
        relativeLayout2.addView(this.f11779h);
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.tencent.connect.avatar.a.a(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f11773a.addView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 24.0f), com.tencent.connect.avatar.a.a(this, 24.0f)));
        imageView.setImageDrawable(b("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.f11780i = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f11780i.setLayoutParams(layoutParams6);
        this.f11780i.setEllipsize(TextUtils.TruncateAt.END);
        this.f11780i.setSingleLine();
        this.f11780i.setTextColor(-1);
        this.f11780i.setTextSize(24.0f);
        this.f11780i.setVisibility(8);
        linearLayout.addView(this.f11780i);
        RelativeLayout relativeLayout3 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.tencent.connect.avatar.a.a(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout3.setLayoutParams(layoutParams7);
        relativeLayout3.setBackgroundDrawable(b("com.tencent.plus.bar.png"));
        int a3 = com.tencent.connect.avatar.a.a(this, 10.0f);
        relativeLayout3.setPadding(a3, a3, a3, 0);
        this.f11773a.addView(relativeLayout3);
        a aVar = new a(this);
        int a10 = com.tencent.connect.avatar.a.a(this, 14.0f);
        int a11 = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f11778g = new Button(this);
        this.f11778g.setLayoutParams(new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f)));
        this.f11778g.setText("取消");
        this.f11778g.setTextColor(-1);
        this.f11778g.setTextSize(18.0f);
        this.f11778g.setPadding(a10, a11, a10, a11);
        aVar.b(this.f11778g);
        relativeLayout3.addView(this.f11778g);
        this.f11777f = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f11777f.setLayoutParams(layoutParams8);
        this.f11777f.setTextColor(-1);
        this.f11777f.setTextSize(18.0f);
        this.f11777f.setPadding(a10, a11, a10, a11);
        this.f11777f.setText("选取");
        aVar.a(this.f11777f);
        relativeLayout3.addView(this.f11777f);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("移动和缩放");
        textView.setPadding(0, com.tencent.connect.avatar.a.a(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout3.addView(textView);
        this.f11781j = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.f11781j.setLayoutParams(layoutParams10);
        this.f11781j.setVisibility(8);
        this.f11773a.addView(this.f11781j);
        return this.f11773a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String d5 = d(str);
        if ("".equals(d5)) {
            return;
        }
        this.f11780i.setText(d5);
        this.f11780i.setVisibility(0);
    }

    private void a(Bitmap bitmap) {
        new QQAvatarImp(this.f11774b).setAvator(bitmap, this.f11792v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i3) {
        this.f11776d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ImageActivity.this.b(str, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_ERROR_CODE, i3);
        intent.putExtra(Constants.KEY_ERROR_MSG, str2);
        intent.putExtra(Constants.KEY_ERROR_DETAIL, str3);
        intent.putExtra(Constants.KEY_RESPONSE, str);
        setResult(-1, intent);
    }

    public void a(String str, long j4) {
        a(str, j4, this.f11774b.getAppId());
    }

    public static void a(String str, long j4, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("strValue", str2);
        hashMap.put("nValue", str);
        hashMap.put("qver", Constants.SDK_VERSION);
        if (j4 != 0) {
            hashMap.put("elt", String.valueOf(j4));
        }
        h.a().a("https://cgi.qplus.com/report/report", hashMap);
    }
}
