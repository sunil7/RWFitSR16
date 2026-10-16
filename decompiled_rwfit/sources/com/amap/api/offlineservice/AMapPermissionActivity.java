package com.amap.api.offlineservice;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.amap.api.col.p0003sl.n1;
import com.amap.api.map3d.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AMapPermissionActivity extends Activity {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f5831b = 0;
    protected String[] needPermissions = new String[0];

    /* renamed from: a, reason: collision with root package name */
    private boolean f5832a = true;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                AMapPermissionActivity.this.finish();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                AMapPermissionActivity aMapPermissionActivity = AMapPermissionActivity.this;
                int i10 = AMapPermissionActivity.f5831b;
                aMapPermissionActivity.getClass();
                try {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.parse("package:" + aMapPermissionActivity.getPackageName()));
                    aMapPermissionActivity.startActivity(intent);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    @TargetApi(23)
    private void a(String... strArr) {
        List<String> b3;
        try {
            if (getApplicationInfo().targetSdkVersion < 23 || (b3 = b(strArr)) == null) {
                return;
            }
            if (b3.size() > 0) {
                try {
                    getClass().getMethod("requestPermissions", String[].class, Integer.TYPE).invoke(this, (String[]) b3.toArray(new String[b3.size()]), 0);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @TargetApi(23)
    private List<String> b(String[] strArr) {
        int i3;
        int i10;
        boolean z5;
        try {
            ArrayList arrayList = new ArrayList();
            if (getApplicationInfo().targetSdkVersion >= 23) {
                for (String str : strArr) {
                    try {
                        i10 = ((Integer) getClass().getMethod("checkSelfPermission", String.class).invoke(this, str)).intValue();
                    } catch (Throwable unused) {
                        i10 = -1;
                    }
                    if (i10 == 0) {
                        try {
                            z5 = ((Boolean) getClass().getMethod("shouldShowRequestPermissionRationale", String.class).invoke(this, str)).booleanValue();
                        } catch (Throwable unused2) {
                            z5 = false;
                        }
                        i3 = z5 ? 0 : i3 + 1;
                    }
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    @Override // android.app.Activity
    @TargetApi(23)
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        try {
            if (i3 == 0) {
                try {
                    for (int i10 : iArr) {
                        if (i10 != 0) {
                            a();
                            this.f5832a = false;
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            if (this.f5832a) {
                a(this.needPermissions);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("");
            builder.setNegativeButton(n1.a(R.string.O105492_22), new a());
            builder.setPositiveButton("设置", new b());
            builder.setCancelable(false);
            builder.show();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
