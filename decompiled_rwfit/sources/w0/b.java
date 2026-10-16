package w0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import androidx.constraintlayout.widget.R$styleable;
import com.google.android.gms.internal.mlkit_vision_common.g0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f19285a = false;

    /* renamed from: b, reason: collision with root package name */
    public String f19286b;

    /* renamed from: c, reason: collision with root package name */
    public ConstraintAttribute$AttributeType f19287c;

    /* renamed from: d, reason: collision with root package name */
    public int f19288d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public String f19289f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f19290g;

    /* renamed from: h, reason: collision with root package name */
    public int f19291h;

    public b(b bVar, Object obj) {
        this.f19286b = bVar.f19286b;
        this.f19287c = bVar.f19287c;
        h(obj);
    }

    public static int a(int i3) {
        int i10 = (i3 & (~(i3 >> 31))) - 255;
        return (i10 & (i10 >> 31)) + 255;
    }

    public static void e(Context context, XmlResourceParser xmlResourceParser, HashMap hashMap) {
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType;
        Object valueOf;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType2 = null;
        boolean z5 = false;
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    char upperCase = Character.toUpperCase(str.charAt(0));
                    String substring = str.substring(1);
                    StringBuilder sb2 = new StringBuilder(r5.a.a(1, substring));
                    sb2.append(upperCase);
                    sb2.append(substring);
                    str = sb2.toString();
                }
            } else if (index == R$styleable.CustomAttribute_methodName) {
                str = obtainStyledAttributes.getString(index);
                z5 = true;
            } else if (index == R$styleable.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                constraintAttribute$AttributeType2 = ConstraintAttribute$AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R$styleable.CustomAttribute_customColorValue) {
                    constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.COLOR_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R$styleable.CustomAttribute_customColorDrawableValue) {
                    constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.COLOR_DRAWABLE_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R$styleable.CustomAttribute_customPixelDimension) {
                    constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R$styleable.CustomAttribute_customDimension) {
                    constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.CustomAttribute_customFloatValue) {
                    constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.FLOAT_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R$styleable.CustomAttribute_customIntegerValue) {
                    constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.INT_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R$styleable.CustomAttribute_customStringValue) {
                    constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.STRING_TYPE;
                    valueOf = obtainStyledAttributes.getString(index);
                } else if (index == R$styleable.CustomAttribute_customReference) {
                    constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.REFERENCE_TYPE;
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    valueOf = Integer.valueOf(resourceId);
                }
                Object obj2 = valueOf;
                constraintAttribute$AttributeType2 = constraintAttribute$AttributeType;
                obj = obj2;
            }
        }
        if (str != null && obj != null) {
            b bVar = new b();
            bVar.f19286b = str;
            bVar.f19287c = constraintAttribute$AttributeType2;
            bVar.f19285a = z5;
            bVar.h(obj);
            hashMap.put(str, bVar);
        }
        obtainStyledAttributes.recycle();
    }

    public static void f(View view, HashMap hashMap) {
        String str;
        Class<?> cls = view.getClass();
        for (String str2 : hashMap.keySet()) {
            b bVar = (b) hashMap.get(str2);
            if (bVar.f19285a) {
                str = str2;
            } else {
                String valueOf = String.valueOf(str2);
                str = valueOf.length() != 0 ? "set".concat(valueOf) : new String("set");
            }
            try {
                int i3 = a.f19284a[bVar.f19287c.ordinal()];
                Class cls2 = Float.TYPE;
                Class cls3 = Integer.TYPE;
                switch (i3) {
                    case 1:
                        cls.getMethod(str, cls3).invoke(view, Integer.valueOf(bVar.f19288d));
                        break;
                    case 2:
                        cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(bVar.f19290g));
                        break;
                    case 3:
                        cls.getMethod(str, CharSequence.class).invoke(view, bVar.f19289f);
                        break;
                    case 4:
                        cls.getMethod(str, cls3).invoke(view, Integer.valueOf(bVar.f19291h));
                        break;
                    case 5:
                        Method method = cls.getMethod(str, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(bVar.f19291h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 6:
                        cls.getMethod(str, cls3).invoke(view, Integer.valueOf(bVar.f19288d));
                        break;
                    case 7:
                        cls.getMethod(str, cls2).invoke(view, Float.valueOf(bVar.e));
                        break;
                    case 8:
                        cls.getMethod(str, cls2).invoke(view, Float.valueOf(bVar.e));
                        break;
                }
            } catch (IllegalAccessException e) {
                String name = cls.getName();
                StringBuilder sb2 = new StringBuilder(name.length() + r5.a.a(34, str2));
                sb2.append(" Custom Attribute \"");
                sb2.append(str2);
                sb2.append("\" not found on ");
                sb2.append(name);
                Log.e("TransitionLayout", sb2.toString());
                e.printStackTrace();
            } catch (NoSuchMethodException e10) {
                Log.e("TransitionLayout", e10.getMessage());
                String name2 = cls.getName();
                StringBuilder sb3 = new StringBuilder(name2.length() + r5.a.a(34, str2));
                sb3.append(" Custom Attribute \"");
                sb3.append(str2);
                sb3.append("\" not found on ");
                sb3.append(name2);
                Log.e("TransitionLayout", sb3.toString());
                String name3 = cls.getName();
                StringBuilder sb4 = new StringBuilder(r5.a.a(name3.length() + 20, str));
                sb4.append(name3);
                sb4.append(" must have a method ");
                sb4.append(str);
                Log.e("TransitionLayout", sb4.toString());
            } catch (InvocationTargetException e11) {
                String name4 = cls.getName();
                StringBuilder sb5 = new StringBuilder(name4.length() + r5.a.a(34, str2));
                sb5.append(" Custom Attribute \"");
                sb5.append(str2);
                sb5.append("\" not found on ");
                sb5.append(name4);
                Log.e("TransitionLayout", sb5.toString());
                e11.printStackTrace();
            }
        }
    }

    public final float b() {
        switch (a.f19284a[this.f19287c.ordinal()]) {
            case 2:
                return this.f19290g ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return this.f19288d;
            case 7:
                return this.e;
            case 8:
                return this.e;
            default:
                return Float.NaN;
        }
    }

    public final void c(float[] fArr) {
        switch (a.f19284a[this.f19287c.ordinal()]) {
            case 2:
                fArr[0] = this.f19290g ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i3 = (this.f19291h >> 24) & 255;
                float pow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float pow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = pow3;
                fArr[3] = i3 / 255.0f;
                return;
            case 6:
                fArr[0] = this.f19288d;
                return;
            case 7:
                fArr[0] = this.e;
                return;
            case 8:
                fArr[0] = this.e;
                return;
            default:
                return;
        }
    }

    public final int d() {
        int i3 = a.f19284a[this.f19287c.ordinal()];
        return (i3 == 4 || i3 == 5) ? 4 : 1;
    }

    public final void g(View view, float[] fArr) {
        Class<?> cls = view.getClass();
        String str = this.f19286b;
        String valueOf = String.valueOf(str);
        String concat = valueOf.length() != 0 ? "set".concat(valueOf) : new String("set");
        try {
            int i3 = a.f19284a[this.f19287c.ordinal()];
            Class cls2 = Integer.TYPE;
            Class cls3 = Float.TYPE;
            boolean z5 = true;
            switch (i3) {
                case 2:
                    Method method = cls.getMethod(concat, Boolean.TYPE);
                    if (fArr[0] <= 0.5f) {
                        z5 = false;
                    }
                    method.invoke(view, Boolean.valueOf(z5));
                    return;
                case 3:
                    String valueOf2 = String.valueOf(str);
                    throw new RuntimeException(valueOf2.length() != 0 ? "unable to interpolate strings ".concat(valueOf2) : new String("unable to interpolate strings "));
                case 4:
                    cls.getMethod(concat, cls2).invoke(view, Integer.valueOf((a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 5:
                    Method method2 = cls.getMethod(concat, Drawable.class);
                    int a3 = (a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(a3);
                    method2.invoke(view, colorDrawable);
                    return;
                case 6:
                    cls.getMethod(concat, cls2).invoke(view, Integer.valueOf((int) fArr[0]));
                    return;
                case 7:
                    cls.getMethod(concat, cls3).invoke(view, Float.valueOf(fArr[0]));
                    return;
                case 8:
                    cls.getMethod(concat, cls3).invoke(view, Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e) {
            String d5 = g0.d(view);
            StringBuilder g10 = r5.a.g(r5.a.a(r5.a.a(32, concat), d5), "cannot access method ", concat, " on View \"", d5);
            g10.append("\"");
            Log.e("TransitionLayout", g10.toString());
            e.printStackTrace();
        } catch (NoSuchMethodException e10) {
            String d8 = g0.d(view);
            StringBuilder g11 = r5.a.g(r5.a.a(r5.a.a(21, concat), d8), "no method ", concat, " on View \"", d8);
            g11.append("\"");
            Log.e("TransitionLayout", g11.toString());
            e10.printStackTrace();
        } catch (InvocationTargetException e11) {
            e11.printStackTrace();
        }
    }

    public final void h(Object obj) {
        switch (a.f19284a[this.f19287c.ordinal()]) {
            case 1:
            case 6:
                this.f19288d = ((Integer) obj).intValue();
                break;
            case 2:
                this.f19290g = ((Boolean) obj).booleanValue();
                break;
            case 3:
                this.f19289f = (String) obj;
                break;
            case 4:
            case 5:
                this.f19291h = ((Integer) obj).intValue();
                break;
            case 7:
                this.e = ((Float) obj).floatValue();
                break;
            case 8:
                this.e = ((Float) obj).floatValue();
                break;
        }
    }
}
