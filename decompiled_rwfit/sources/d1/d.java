package d1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class d {
    public static Uri a(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return f.d(obj);
        }
        try {
            return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon uri", e);
            return null;
        } catch (NoSuchMethodException e10) {
            Log.e("IconCompat", "Unable to get icon uri", e10);
            return null;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon uri", e11);
            return null;
        }
    }

    public static Drawable b(Icon icon, Context context) {
        return icon.loadDrawable(context);
    }

    public static Icon c(IconCompat iconCompat, Context context) {
        Icon createWithBitmap;
        int i3 = iconCompat.f1915a;
        String str = null;
        r1 = null;
        InputStream openInputStream = null;
        str = null;
        str = null;
        switch (i3) {
            case -1:
                return (Icon) iconCompat.f1916b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f1916b);
                break;
            case 2:
                if (i3 == -1) {
                    int i10 = Build.VERSION.SDK_INT;
                    Object obj = iconCompat.f1916b;
                    if (i10 >= 28) {
                        str = f.b(obj);
                    } else {
                        try {
                            str = (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
                        } catch (IllegalAccessException e) {
                            Log.e("IconCompat", "Unable to get icon package", e);
                        } catch (NoSuchMethodException e10) {
                            Log.e("IconCompat", "Unable to get icon package", e10);
                        } catch (InvocationTargetException e11) {
                            Log.e("IconCompat", "Unable to get icon package", e11);
                        }
                    }
                } else {
                    if (i3 != 2) {
                        throw new IllegalStateException("called getResPackage() on " + iconCompat);
                    }
                    String str2 = iconCompat.f1923j;
                    str = (str2 == null || TextUtils.isEmpty(str2)) ? ((String) iconCompat.f1916b).split(":", -1)[0] : iconCompat.f1923j;
                }
                createWithBitmap = Icon.createWithResource(str, iconCompat.e);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) iconCompat.f1916b, iconCompat.e, iconCompat.f1919f);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) iconCompat.f1916b);
                break;
            case 5:
                createWithBitmap = e.b((Bitmap) iconCompat.f1916b);
                break;
            case 6:
                if (Build.VERSION.SDK_INT >= 30) {
                    createWithBitmap = g.a(iconCompat.c());
                    break;
                } else {
                    if (context == null) {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.c());
                    }
                    Uri c9 = iconCompat.c();
                    String scheme = c9.getScheme();
                    if ("content".equals(scheme) || Const.STR_FILE.equals(scheme)) {
                        try {
                            openInputStream = context.getContentResolver().openInputStream(c9);
                        } catch (Exception e12) {
                            Log.w("IconCompat", "Unable to load image from URI: " + c9, e12);
                        }
                    } else {
                        try {
                            openInputStream = new FileInputStream(new File((String) iconCompat.f1916b));
                        } catch (FileNotFoundException e13) {
                            Log.w("IconCompat", "Unable to load image from path: " + c9, e13);
                        }
                    }
                    if (openInputStream == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.c());
                    }
                    createWithBitmap = e.b(BitmapFactory.decodeStream(openInputStream));
                    break;
                }
                break;
        }
        ColorStateList colorStateList = iconCompat.f1920g;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = iconCompat.f1921h;
        if (mode != IconCompat.f1914k) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }
}
