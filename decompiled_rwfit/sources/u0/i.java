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

/* loaded from: classes.dex */
public final class i extends c {
    public int e = -1;

    /* renamed from: f, reason: collision with root package name */
    public String f18687f = null;

    /* renamed from: g, reason: collision with root package name */
    public int f18688g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f18689h = 0;

    /* renamed from: i, reason: collision with root package name */
    public float f18690i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    public float f18691j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    public float f18692k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f18693l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public int f18694m = 0;

    @Override // u0.c
    public final void a(HashMap hashMap) {
        throw null;
    }

    @Override // u0.c
    /* renamed from: b */
    public final c clone() {
        i iVar = new i();
        iVar.f18666a = this.f18666a;
        iVar.f18667b = this.f18667b;
        iVar.f18668c = this.f18668c;
        iVar.f18669d = this.f18669d;
        iVar.f18687f = this.f18687f;
        iVar.f18688g = this.f18688g;
        iVar.f18689h = this.f18689h;
        iVar.f18690i = this.f18690i;
        iVar.f18691j = Float.NaN;
        iVar.f18692k = this.f18692k;
        iVar.f18693l = this.f18693l;
        return iVar;
    }

    @Override // u0.c
    public final void c(HashSet hashSet) {
    }

    @Override // u0.c
    public final void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.KeyPosition);
        SparseIntArray sparseIntArray = h.f18686a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            SparseIntArray sparseIntArray2 = h.f18686a;
            switch (sparseIntArray2.get(index)) {
                case 1:
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
                case 2:
                    this.f18666a = obtainStyledAttributes.getInt(index, this.f18666a);
                    break;
                case 3:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        this.f18687f = obtainStyledAttributes.getString(index);
                        break;
                    } else {
                        this.f18687f = p0.e.f17312d[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 4:
                    this.e = obtainStyledAttributes.getInteger(index, this.e);
                    break;
                case 5:
                    this.f18689h = obtainStyledAttributes.getInt(index, this.f18689h);
                    break;
                case 6:
                    this.f18692k = obtainStyledAttributes.getFloat(index, this.f18692k);
                    break;
                case 7:
                    this.f18693l = obtainStyledAttributes.getFloat(index, this.f18693l);
                    break;
                case 8:
                    float f2 = obtainStyledAttributes.getFloat(index, this.f18691j);
                    this.f18690i = f2;
                    this.f18691j = f2;
                    break;
                case 9:
                    this.f18694m = obtainStyledAttributes.getInt(index, this.f18694m);
                    break;
                case 10:
                    this.f18688g = obtainStyledAttributes.getInt(index, this.f18688g);
                    break;
                case 11:
                    this.f18690i = obtainStyledAttributes.getFloat(index, this.f18690i);
                    break;
                case 12:
                    this.f18691j = obtainStyledAttributes.getFloat(index, this.f18691j);
                    break;
                default:
                    String hexString = Integer.toHexString(index);
                    int i10 = sparseIntArray2.get(index);
                    StringBuilder sb2 = new StringBuilder(r5.a.a(33, hexString));
                    sb2.append("unused attribute 0x");
                    sb2.append(hexString);
                    sb2.append("   ");
                    sb2.append(i10);
                    Log.e("KeyPosition", sb2.toString());
                    break;
            }
        }
        if (this.f18666a == -1) {
            Log.e("KeyPosition", "no frame position");
        }
    }

    public final void g(Object obj, String str) {
        switch (str) {
            case "transitionEasing":
                this.f18687f = obj.toString();
                break;
            case "percentWidth":
                this.f18690i = c.f((Number) obj);
                break;
            case "percentHeight":
                this.f18691j = c.f((Number) obj);
                break;
            case "drawPath":
                Number number = (Number) obj;
                this.f18689h = number instanceof Integer ? ((Integer) number).intValue() : Integer.parseInt(number.toString());
                break;
            case "sizePercent":
                float f2 = c.f((Number) obj);
                this.f18690i = f2;
                this.f18691j = f2;
                break;
            case "percentX":
                this.f18692k = c.f((Number) obj);
                break;
            case "percentY":
                this.f18693l = c.f((Number) obj);
                break;
        }
    }
}
