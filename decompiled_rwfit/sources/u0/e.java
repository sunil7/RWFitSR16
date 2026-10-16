package u0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e extends c {
    public int e = -1;

    /* renamed from: f, reason: collision with root package name */
    public float f18671f = Float.NaN;

    /* renamed from: g, reason: collision with root package name */
    public float f18672g = Float.NaN;

    /* renamed from: h, reason: collision with root package name */
    public float f18673h = Float.NaN;

    /* renamed from: i, reason: collision with root package name */
    public float f18674i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    public float f18675j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    public float f18676k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f18677l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f18678m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    public float f18679n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    public float f18680o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    public float f18681p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    public float f18682q = Float.NaN;
    public float r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    public float f18683s = Float.NaN;

    public e() {
        this.f18669d = new HashMap();
    }

    @Override // u0.c
    public final void a(HashMap hashMap) {
        for (String str : hashMap.keySet()) {
            t0.k kVar = (t0.k) hashMap.get(str);
            if (kVar != null) {
                if (!str.startsWith("CUSTOM")) {
                    switch (str) {
                        case "rotationX":
                            if (Float.isNaN(this.f18674i)) {
                                break;
                            } else {
                                kVar.b(this.f18674i, this.f18666a);
                                break;
                            }
                        case "rotationY":
                            if (Float.isNaN(this.f18675j)) {
                                break;
                            } else {
                                kVar.b(this.f18675j, this.f18666a);
                                break;
                            }
                        case "translationX":
                            if (Float.isNaN(this.f18681p)) {
                                break;
                            } else {
                                kVar.b(this.f18681p, this.f18666a);
                                break;
                            }
                        case "translationY":
                            if (Float.isNaN(this.f18682q)) {
                                break;
                            } else {
                                kVar.b(this.f18682q, this.f18666a);
                                break;
                            }
                        case "translationZ":
                            if (Float.isNaN(this.r)) {
                                break;
                            } else {
                                kVar.b(this.r, this.f18666a);
                                break;
                            }
                        case "progress":
                            if (Float.isNaN(this.f18683s)) {
                                break;
                            } else {
                                kVar.b(this.f18683s, this.f18666a);
                                break;
                            }
                        case "scaleX":
                            if (Float.isNaN(this.f18679n)) {
                                break;
                            } else {
                                kVar.b(this.f18679n, this.f18666a);
                                break;
                            }
                        case "scaleY":
                            if (Float.isNaN(this.f18680o)) {
                                break;
                            } else {
                                kVar.b(this.f18680o, this.f18666a);
                                break;
                            }
                        case "transformPivotX":
                            if (Float.isNaN(this.f18674i)) {
                                break;
                            } else {
                                kVar.b(this.f18676k, this.f18666a);
                                break;
                            }
                        case "transformPivotY":
                            if (Float.isNaN(this.f18675j)) {
                                break;
                            } else {
                                kVar.b(this.f18677l, this.f18666a);
                                break;
                            }
                        case "rotation":
                            if (Float.isNaN(this.f18673h)) {
                                break;
                            } else {
                                kVar.b(this.f18673h, this.f18666a);
                                break;
                            }
                        case "elevation":
                            if (Float.isNaN(this.f18672g)) {
                                break;
                            } else {
                                kVar.b(this.f18672g, this.f18666a);
                                break;
                            }
                        case "transitionPathRotate":
                            if (Float.isNaN(this.f18678m)) {
                                break;
                            } else {
                                kVar.b(this.f18678m, this.f18666a);
                                break;
                            }
                        case "alpha":
                            if (Float.isNaN(this.f18671f)) {
                                break;
                            } else {
                                kVar.b(this.f18671f, this.f18666a);
                                break;
                            }
                    }
                } else {
                    w0.b bVar = (w0.b) this.f18669d.get(str.substring(7));
                    if (bVar != null) {
                        ((t0.h) kVar).f18448f.append(this.f18666a, bVar);
                    }
                }
            }
        }
    }

    @Override // u0.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final c clone() {
        e eVar = new e();
        eVar.f18666a = this.f18666a;
        eVar.f18667b = this.f18667b;
        eVar.f18668c = this.f18668c;
        eVar.f18669d = this.f18669d;
        eVar.e = this.e;
        eVar.f18671f = this.f18671f;
        eVar.f18672g = this.f18672g;
        eVar.f18673h = this.f18673h;
        eVar.f18674i = this.f18674i;
        eVar.f18675j = this.f18675j;
        eVar.f18676k = this.f18676k;
        eVar.f18677l = this.f18677l;
        eVar.f18678m = this.f18678m;
        eVar.f18679n = this.f18679n;
        eVar.f18680o = this.f18680o;
        eVar.f18681p = this.f18681p;
        eVar.f18682q = this.f18682q;
        eVar.r = this.r;
        eVar.f18683s = this.f18683s;
        return eVar;
    }

    @Override // u0.c
    public final void c(HashSet hashSet) {
        if (!Float.isNaN(this.f18671f)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f18672g)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f18673h)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f18674i)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f18675j)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f18676k)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.f18677l)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.f18681p)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f18682q)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f18678m)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f18679n)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f18680o)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f18683s)) {
            hashSet.add("progress");
        }
        if (this.f18669d.size() > 0) {
            Iterator it = this.f18669d.keySet().iterator();
            while (it.hasNext()) {
                String valueOf = String.valueOf((String) it.next());
                hashSet.add(valueOf.length() != 0 ? "CUSTOM,".concat(valueOf) : new String("CUSTOM,"));
            }
        }
    }

    @Override // u0.c
    public final void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.KeyAttribute);
        SparseIntArray sparseIntArray = d.f18670a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            SparseIntArray sparseIntArray2 = d.f18670a;
            switch (sparseIntArray2.get(index)) {
                case 1:
                    this.f18671f = obtainStyledAttributes.getFloat(index, this.f18671f);
                    break;
                case 2:
                    this.f18672g = obtainStyledAttributes.getDimension(index, this.f18672g);
                    break;
                case 3:
                case 11:
                default:
                    String hexString = Integer.toHexString(index);
                    int i10 = sparseIntArray2.get(index);
                    StringBuilder sb2 = new StringBuilder(r5.a.a(33, hexString));
                    sb2.append("unused attribute 0x");
                    sb2.append(hexString);
                    sb2.append("   ");
                    sb2.append(i10);
                    Log.e("KeyAttribute", sb2.toString());
                    break;
                case 4:
                    this.f18673h = obtainStyledAttributes.getFloat(index, this.f18673h);
                    break;
                case 5:
                    this.f18674i = obtainStyledAttributes.getFloat(index, this.f18674i);
                    break;
                case 6:
                    this.f18675j = obtainStyledAttributes.getFloat(index, this.f18675j);
                    break;
                case 7:
                    this.f18679n = obtainStyledAttributes.getFloat(index, this.f18679n);
                    break;
                case 8:
                    this.f18678m = obtainStyledAttributes.getFloat(index, this.f18678m);
                    break;
                case 9:
                    obtainStyledAttributes.getString(index);
                    break;
                case 10:
                    if (MotionLayout.f1692q1) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f18667b);
                        this.f18667b = resourceId;
                        if (resourceId == -1) {
                            this.f18668c = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                        this.f18668c = obtainStyledAttributes.getString(index);
                        break;
                    } else {
                        this.f18667b = obtainStyledAttributes.getResourceId(index, this.f18667b);
                        break;
                    }
                case 12:
                    this.f18666a = obtainStyledAttributes.getInt(index, this.f18666a);
                    break;
                case 13:
                    this.e = obtainStyledAttributes.getInteger(index, this.e);
                    break;
                case 14:
                    this.f18680o = obtainStyledAttributes.getFloat(index, this.f18680o);
                    break;
                case 15:
                    this.f18681p = obtainStyledAttributes.getDimension(index, this.f18681p);
                    break;
                case 16:
                    this.f18682q = obtainStyledAttributes.getDimension(index, this.f18682q);
                    break;
                case 17:
                    this.r = obtainStyledAttributes.getDimension(index, this.r);
                    break;
                case 18:
                    this.f18683s = obtainStyledAttributes.getFloat(index, this.f18683s);
                    break;
                case 19:
                    this.f18676k = obtainStyledAttributes.getDimension(index, this.f18676k);
                    break;
                case 20:
                    this.f18677l = obtainStyledAttributes.getDimension(index, this.f18677l);
                    break;
            }
        }
    }

    @Override // u0.c
    public final void e(HashMap hashMap) {
        if (this.e == -1) {
            return;
        }
        if (!Float.isNaN(this.f18671f)) {
            hashMap.put("alpha", Integer.valueOf(this.e));
        }
        if (!Float.isNaN(this.f18672g)) {
            hashMap.put("elevation", Integer.valueOf(this.e));
        }
        if (!Float.isNaN(this.f18673h)) {
            hashMap.put("rotation", Integer.valueOf(this.e));
        }
        if (!Float.isNaN(this.f18674i)) {
            hashMap.put("rotationX", Integer.valueOf(this.e));
        }
        if (!Float.isNaN(this.f18675j)) {
            hashMap.put("rotationY", Integer.valueOf(this.e));
        }
        if (!Float.isNaN(this.f18676k)) {
            hashMap.put("transformPivotX", Integer.valueOf(this.e));
        }
        if (!Float.isNaN(this.f18677l)) {
            hashMap.put("transformPivotY", Integer.valueOf(this.e));
        }
        if (!Float.isNaN(this.f18681p)) {
            hashMap.put("translationX", Integer.valueOf(this.e));
        }
        if (!Float.isNaN(this.f18682q)) {
            hashMap.put("translationY", Integer.valueOf(this.e));
        }
        if (!Float.isNaN(this.r)) {
            hashMap.put("translationZ", Integer.valueOf(this.e));
        }
        if (!Float.isNaN(this.f18678m)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.e));
        }
        if (!Float.isNaN(this.f18679n)) {
            hashMap.put("scaleX", Integer.valueOf(this.e));
        }
        if (!Float.isNaN(this.f18680o)) {
            hashMap.put("scaleY", Integer.valueOf(this.e));
        }
        if (!Float.isNaN(this.f18683s)) {
            hashMap.put("progress", Integer.valueOf(this.e));
        }
        if (this.f18669d.size() > 0) {
            Iterator it = this.f18669d.keySet().iterator();
            while (it.hasNext()) {
                String valueOf = String.valueOf((String) it.next());
                hashMap.put(valueOf.length() != 0 ? "CUSTOM,".concat(valueOf) : new String("CUSTOM,"), Integer.valueOf(this.e));
            }
        }
    }

    public final void g(Object obj, String str) {
        switch (str) {
            case "motionProgress":
                this.f18683s = c.f((Number) obj);
                break;
            case "transitionEasing":
                obj.toString();
                break;
            case "rotationX":
                this.f18674i = c.f((Number) obj);
                break;
            case "rotationY":
                this.f18675j = c.f((Number) obj);
                break;
            case "translationX":
                this.f18681p = c.f((Number) obj);
                break;
            case "translationY":
                this.f18682q = c.f((Number) obj);
                break;
            case "translationZ":
                this.r = c.f((Number) obj);
                break;
            case "scaleX":
                this.f18679n = c.f((Number) obj);
                break;
            case "scaleY":
                this.f18680o = c.f((Number) obj);
                break;
            case "transformPivotX":
                this.f18676k = c.f((Number) obj);
                break;
            case "transformPivotY":
                this.f18677l = c.f((Number) obj);
                break;
            case "rotation":
                this.f18673h = c.f((Number) obj);
                break;
            case "elevation":
                this.f18672g = c.f((Number) obj);
                break;
            case "transitionPathRotate":
                this.f18678m = c.f((Number) obj);
                break;
            case "alpha":
                this.f18671f = c.f((Number) obj);
                break;
            case "curveFit":
                Number number = (Number) obj;
                this.e = number instanceof Integer ? ((Integer) number).intValue() : Integer.parseInt(number.toString());
                break;
            case "visibility":
                if (!(obj instanceof Boolean)) {
                    Boolean.parseBoolean(obj.toString());
                    break;
                }
                break;
        }
    }
}
