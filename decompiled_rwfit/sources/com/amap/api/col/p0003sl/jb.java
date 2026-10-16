package com.amap.api.col.p0003sl;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class jb extends j9 {
    protected Context mContext;
    protected byte[] mDatas;
    protected m9 mSDKInfo;

    public jb(Context context, m9 m9Var) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        this.mSDKInfo = m9Var;
        setBinary(true);
    }

    private static byte[] c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(n9.e("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                return byteArray;
            } catch (Throwable th2) {
                return byteArray;
            }
        } catch (Throwable th3) {
            try {
                ga.a(th3, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th4) {
                    ga.a(th4, "bre", "gbh");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th22) {
                    ga.a(th22, "bre", "gbh");
                }
            }
        }
    }

    private byte[] d() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] rawDatas = getRawDatas();
            if (rawDatas != null && rawDatas.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byteArrayOutputStream.write(getDatasLength(rawDatas));
                byteArrayOutputStream.write(rawDatas);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    return byteArray;
                } catch (Throwable th2) {
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray2;
            } catch (Throwable th3) {
                ga.a(th3, "bre", "grrd");
                return byteArray2;
            }
        } catch (Throwable th4) {
            try {
                ga.a(th4, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    ga.a(th5, "bre", "grrd");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th22) {
                    ga.a(th22, "bre", "grrd");
                }
            }
        }
    }

    private byte[] e() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] rsaAesRawDatas = getRsaAesRawDatas();
            if (rsaAesRawDatas != null && rsaAesRawDatas.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] d5 = h9.d(rsaAesRawDatas);
                byteArrayOutputStream.write(getDatasLength(d5));
                byteArrayOutputStream.write(d5);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    return byteArray;
                } catch (Throwable th2) {
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray2;
            } catch (Throwable th3) {
                ga.a(th3, "bre", "gred");
                return byteArray2;
            }
        } catch (Throwable th4) {
            try {
                ga.a(th4, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    ga.a(th5, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th22) {
                    ga.a(th22, "bre", "gred");
                }
            }
        }
    }

    public byte[] getDatasLength(byte[] bArr) {
        return n9.a(bArr.length, 2);
    }

    @Override // com.amap.api.col.p0003sl.pb
    public final byte[] getEntityBytes() {
        byte[] bArr = this.mDatas;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(c());
            byteArrayOutputStream.write(getPublicData());
            byteArrayOutputStream.write(d());
            byteArrayOutputStream.write(e());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.mDatas = byteArray;
            try {
                return byteArray;
            } catch (Throwable th2) {
                return byteArray;
            }
        } catch (Throwable th3) {
            try {
                ga.a(th3, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th4) {
                    ga.a(th4, "bre", "geb");
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th22) {
                    ga.a(th22, "bre", "geb");
                }
            }
        }
    }

    public String getLogVersion() {
        return "2.1";
    }

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        String e = b9.e(this.mContext);
        String c9 = e9.c();
        String a3 = e9.a(this.mContext, c9, "key=".concat(String.valueOf(e)));
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.TS, c9);
        hashMap.put("key", e);
        hashMap.put("scode", a3);
        return hashMap;
    }

    public String getPlatInfo() {
        return l0.p("platform=Android&sdkversion=", this.mSDKInfo.b(), "&product=", this.mSDKInfo.d());
    }

    public byte[] getPublicData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (getXinfoFlag()) {
                Context context = this.mContext;
                boolean isLocRequest = isLocRequest();
                m9 m9Var = this.mSDKInfo;
                byte[] a3 = e9.a(context, isLocRequest, m9Var != null && "navi".equals(m9Var.d()));
                byteArrayOutputStream.write(getDatasLength(a3));
                byteArrayOutputStream.write(a3);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] e = n9.e(getLogVersion());
            if (e == null || e.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(getDatasLength(e));
                byteArrayOutputStream.write(e);
            }
            byte[] e10 = n9.e(getPlatInfo());
            if (e10 == null || e10.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(getDatasLength(e10));
                byteArrayOutputStream.write(e10);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                return byteArray;
            } catch (Throwable th2) {
                return byteArray;
            }
        } catch (Throwable th3) {
            try {
                ga.a(th3, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    ga.a(th4, "bre", "gred");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th22) {
                    ga.a(th22, "bre", "gred");
                }
            }
        }
    }

    public abstract byte[] getRawDatas();

    @Override // com.amap.api.col.p0003sl.pb
    public abstract Map<String, String> getRequestHead();

    public abstract byte[] getRsaAesRawDatas();

    @Override // com.amap.api.col.p0003sl.pb
    public abstract String getURL();

    public boolean getXinfoFlag() {
        return true;
    }

    public boolean isLocRequest() {
        return false;
    }
}
