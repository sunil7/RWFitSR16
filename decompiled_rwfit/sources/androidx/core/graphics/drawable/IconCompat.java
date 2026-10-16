package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.tencent.connect.common.Constants;
import d1.d;
import d1.f;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f1914k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public Object f1916b;

    /* renamed from: j, reason: collision with root package name */
    public String f1923j;

    /* renamed from: a, reason: collision with root package name */
    public int f1915a = -1;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f1917c = null;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f1918d = null;
    public int e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f1919f = 0;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f1920g = null;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f1921h = f1914k;

    /* renamed from: i, reason: collision with root package name */
    public String f1922i = null;

    public static IconCompat a(int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1917c = null;
        iconCompat.f1918d = null;
        iconCompat.f1919f = 0;
        iconCompat.f1920g = null;
        iconCompat.f1921h = f1914k;
        iconCompat.f1922i = null;
        iconCompat.f1915a = 2;
        iconCompat.e = i3;
        iconCompat.f1916b = "";
        iconCompat.f1923j = "";
        return iconCompat;
    }

    public final int b() {
        int i3 = this.f1915a;
        if (i3 != -1) {
            if (i3 == 2) {
                return this.e;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        int i10 = Build.VERSION.SDK_INT;
        Object obj = this.f1916b;
        if (i10 >= 28) {
            return f.a(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (NoSuchMethodException e10) {
            Log.e("IconCompat", "Unable to get icon resource", e10);
            return 0;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon resource", e11);
            return 0;
        }
    }

    public final Uri c() {
        int i3 = this.f1915a;
        if (i3 == -1) {
            return d.a(this.f1916b);
        }
        if (i3 == 4 || i3 == 6) {
            return Uri.parse((String) this.f1916b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public final String toString() {
        String str;
        if (this.f1915a == -1) {
            return String.valueOf(this.f1916b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        switch (this.f1915a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = Constants.APP_VERSION_UNKNOWN;
                break;
        }
        sb2.append(str);
        switch (this.f1915a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f1916b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f1916b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f1923j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", Integer.valueOf(b())));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.e);
                if (this.f1919f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f1919f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f1916b);
                break;
        }
        if (this.f1920g != null) {
            sb2.append(" tint=");
            sb2.append(this.f1920g);
        }
        if (this.f1921h != f1914k) {
            sb2.append(" mode=");
            sb2.append(this.f1921h);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
