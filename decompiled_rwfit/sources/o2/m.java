package o2;

import android.content.Context;
import android.opengl.GLES20;
import android.util.Log;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.jieli.bmp_convert.ConvertResult;
import com.jieli.bmp_convert.OnConvertListener;

/* loaded from: classes.dex */
public final class m implements ca.b, OnConvertListener, i6.h, wf.g, y6.b {

    /* renamed from: c, reason: collision with root package name */
    public static m f16718c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16719a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16720b;

    public /* synthetic */ m(byte b3, int i3, int i10) {
        this.f16719a = i10;
        this.f16720b = i3;
    }

    public static synchronized m g() {
        m mVar;
        synchronized (m.class) {
            try {
                if (f16718c == null) {
                    f16718c = new m((byte) 0, 3, 0);
                }
                mVar = f16718c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mVar;
    }

    public static String i(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append("WM-");
        if (length >= 20) {
            sb2.append(str.substring(0, 20));
        } else {
            sb2.append(str);
        }
        return sb2.toString();
    }

    @Override // wf.g
    public boolean a(wf.b bVar) {
        switch (this.f16719a) {
            case 8:
                if (bVar.f19627a <= this.f16720b) {
                }
                break;
            case 9:
                if (bVar.f19627a >= this.f16720b) {
                }
                break;
            case 10:
                if (bVar.f19628b <= this.f16720b) {
                }
                break;
            case 11:
                if (bVar.f19628b >= this.f16720b) {
                }
                break;
            case 12:
                if (bVar.f19628b * bVar.f19627a <= this.f16720b) {
                }
                break;
            default:
                if (bVar.f19628b * bVar.f19627a >= this.f16720b) {
                }
                break;
        }
        return false;
    }

    @Override // y6.b
    public int b() {
        return this.f16720b;
    }

    @Override // ca.b
    public int c(Context context, String str) {
        return this.f16720b;
    }

    public void d(String str, String str2, Throwable... thArr) {
        if (this.f16720b <= 3) {
            if (thArr.length >= 1) {
                Log.d(str, str2, thArr[0]);
            } else {
                Log.d(str, str2);
            }
        }
    }

    @Override // ca.b
    public int e(Context context, String str, boolean z5) {
        return 0;
    }

    public void f(String str, String str2, Throwable... thArr) {
        if (this.f16720b <= 6) {
            if (thArr.length >= 1) {
                Log.e(str, str2, thArr[0]);
            } else {
                Log.e(str, str2);
            }
        }
    }

    public void h(String str, String str2, Throwable... thArr) {
        if (this.f16720b <= 4) {
            if (thArr.length >= 1) {
                Log.i(str, str2, thArr[0]);
            } else {
                Log.i(str, str2);
            }
        }
    }

    @Override // i6.h
    public void j(Object obj) {
        i6.i callback = (i6.i) obj;
        kotlin.jvm.internal.e.f(callback, "callback");
        callback.e(this.f16720b);
    }

    public void k(String str, String str2, Throwable... thArr) {
        if (this.f16720b <= 5) {
            if (thArr.length >= 1) {
                Log.w(str, str2, thArr[0]);
            } else {
                Log.w(str, str2);
            }
        }
    }

    @Override // com.jieli.bmp_convert.OnConvertListener
    public void onStart(String path) {
        kotlin.jvm.internal.e.f(path, "path");
    }

    @Override // com.jieli.bmp_convert.OnConvertListener
    public void onStop(boolean z5, String output) {
        kotlin.jvm.internal.e.f(output, "output");
    }

    public m(int i3, String str) {
        this.f16719a = 2;
        int glCreateShader = GLES20.glCreateShader(i3);
        xf.a.b(kotlin.jvm.internal.e.k(Integer.valueOf(i3), "glCreateShader type="));
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            this.f16720b = glCreateShader;
            return;
        }
        StringBuilder q5 = android.support.v4.media.session.e.q(i3, "Could not compile shader ", ": '");
        q5.append((Object) GLES20.glGetShaderInfoLog(glCreateShader));
        q5.append("' source: ");
        q5.append(str);
        String sb2 = q5.toString();
        GLES20.glDeleteShader(glCreateShader);
        throw new RuntimeException(sb2);
    }

    @Override // com.jieli.bmp_convert.OnConvertListener
    public void onStop(ConvertResult result, String outFilePath) {
        kotlin.jvm.internal.e.f(result, "result");
        kotlin.jvm.internal.e.f(outFilePath, "outFilePath");
        if (result.isConvertSuccess()) {
            int i3 = com.example.test.utils.g.f8727a;
            com.example.test.utils.g.b(this.f16720b + 1, com.example.test.utils.g.e);
        } else {
            int i10 = com.example.test.utils.g.f8727a;
            com.example.test.utils.g.b(GLMapStaticValue.MAPRENDER_CAN_STOP_AND_FULLSCREEN_RENDEROVER, com.example.test.utils.g.e);
            Log.e("qob", "bitmapConvert error");
        }
    }

    public m(int i3, int i10) {
        this.f16719a = 6;
        this.f16720b = i3;
    }
}
