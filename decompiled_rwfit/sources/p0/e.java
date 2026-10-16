package p0;

import android.view.View;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f17311c = new e(0);

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f17312d = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17313a;

    /* renamed from: b, reason: collision with root package name */
    public Serializable f17314b;

    public e(int i3) {
        this.f17313a = i3;
        switch (i3) {
            case 1:
                this.f17314b = new HashMap();
                break;
            default:
                this.f17314b = "identity";
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0161, code lost:
    
        if (r21.equals("linear") == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p0.e d(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.e.d(java.lang.String):p0.e");
    }

    public double a(double d5) {
        return d5;
    }

    public double b(double d5) {
        return 1.0d;
    }

    public float c(View view, String str) {
        HashMap hashMap;
        float[] fArr;
        HashMap hashMap2 = (HashMap) this.f17314b;
        if (hashMap2.containsKey(view) && (hashMap = (HashMap) hashMap2.get(view)) != null && hashMap.containsKey(str) && (fArr = (float[]) hashMap.get(str)) != null && fArr.length > 0) {
            return fArr[0];
        }
        return Float.NaN;
    }

    public String toString() {
        switch (this.f17313a) {
            case 0:
                return (String) this.f17314b;
            default:
                return super.toString();
        }
    }
}
