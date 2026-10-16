package d6;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;
import androidx.recyclerview.widget.e1;
import androidx.recyclerview.widget.s0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import g4.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import m1.o;
import nf.e;
import org.xmlpull.v1.XmlPullParserException;
import q9.n;
import w0.t;
import w0.u;
import x3.f;
import z3.s;

/* loaded from: classes.dex */
public final class a implements s0, l4.a, ia.b, o {

    /* renamed from: c, reason: collision with root package name */
    public static a f12304c;

    /* renamed from: a, reason: collision with root package name */
    public int f12305a;

    /* renamed from: b, reason: collision with root package name */
    public Object f12306b;

    public /* synthetic */ a(int i3, Object obj) {
        this.f12305a = i3;
        this.f12306b = obj;
    }

    public int a(int i3) {
        float f2 = -1;
        SparseArray sparseArray = (SparseArray) this.f12306b;
        int i10 = 0;
        if (-1 == i3) {
            t tVar = i3 == -1 ? (t) sparseArray.valueAt(0) : (t) sparseArray.get(-1);
            if (tVar != null) {
                while (true) {
                    ArrayList arrayList = tVar.f19457b;
                    if (i10 >= arrayList.size()) {
                        i10 = -1;
                        break;
                    }
                    if (((u) arrayList.get(i10)).a(f2, f2)) {
                        break;
                    }
                    i10++;
                }
                if (-1 != i10) {
                    return i10 == -1 ? tVar.f19458c : ((u) tVar.f19457b.get(i10)).e;
                }
            }
        } else {
            t tVar2 = (t) sparseArray.get(i3);
            if (tVar2 != null) {
                while (true) {
                    ArrayList arrayList2 = tVar2.f19457b;
                    if (i10 >= arrayList2.size()) {
                        i10 = -1;
                        break;
                    }
                    if (((u) arrayList2.get(i10)).a(f2, f2)) {
                        break;
                    }
                    i10++;
                }
                return i10 == -1 ? tVar2.f19458c : ((u) tVar2.f19457b.get(i10)).e;
            }
        }
        return -1;
    }

    @Override // l4.a
    public s d(s sVar, f fVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) sVar.get()).compress((Bitmap.CompressFormat) this.f12306b, this.f12305a, byteArrayOutputStream);
        sVar.recycle();
        return new y(byteArrayOutputStream.toByteArray());
    }

    @Override // m1.o
    public boolean g(View view) {
        ((BottomSheetBehavior) this.f12306b).B(this.f12305a);
        return true;
    }

    @Override // ia.b
    public void j(ia.f fVar) {
        e eVar = (e) this.f12306b;
        if (this.f12305a == eVar.f16615g) {
            eVar.f16614f = eVar.e;
        }
    }

    @Override // androidx.recyclerview.widget.s0
    public void onChanged(int i3, int i10, Object obj) {
        ((androidx.recyclerview.widget.b) this.f12306b).onChanged(i3 + this.f12305a, i10, obj);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onInserted(int i3, int i10) {
        ((androidx.recyclerview.widget.b) this.f12306b).onInserted(i3 + this.f12305a, i10);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onMoved(int i3, int i10) {
        int i11 = this.f12305a;
        ((androidx.recyclerview.widget.b) this.f12306b).onMoved(i3 + i11, i10 + i11);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onRemoved(int i3, int i10) {
        ((androidx.recyclerview.widget.b) this.f12306b).onRemoved(i3 + this.f12305a, i10);
    }

    public /* synthetic */ a(Object obj, int i3) {
        this.f12306b = obj;
        this.f12305a = i3;
    }

    public a(int i3) {
        switch (i3) {
            case 5:
                this.f12306b = Bitmap.CompressFormat.JPEG;
                this.f12305a = 100;
                break;
            default:
                this.f12306b = new HashMap();
                this.f12305a = (new Random().nextInt(255) + 1) % 256;
                break;
        }
    }

    public a(ConnectionResult connectionResult, int i3) {
        n.e(connectionResult);
        this.f12306b = connectionResult;
        this.f12305a = i3;
    }

    public a(Context context, XmlResourceParser xmlResourceParser) {
        this.f12305a = -1;
        this.f12306b = new SparseArray();
        new SparseArray();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.StateSet_defaultState) {
                this.f12305a = obtainStyledAttributes.getResourceId(index, this.f12305a);
            }
        }
        obtainStyledAttributes.recycle();
        try {
            int eventType = xmlResourceParser.getEventType();
            t tVar = null;
            while (true) {
                char c9 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xmlResourceParser.getName();
                } else if (eventType == 2) {
                    String name = xmlResourceParser.getName();
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                c9 = 2;
                                break;
                            }
                            c9 = 65535;
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                c9 = 0;
                                break;
                            }
                            c9 = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                break;
                            }
                            c9 = 65535;
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c9 = 3;
                                break;
                            }
                            c9 = 65535;
                            break;
                        default:
                            c9 = 65535;
                            break;
                    }
                    if (c9 == 2) {
                        tVar = new t(context, xmlResourceParser);
                        ((SparseArray) this.f12306b).put(tVar.f19456a, tVar);
                    } else if (c9 == 3) {
                        u uVar = new u(context, xmlResourceParser);
                        if (tVar != null) {
                            tVar.f19457b.add(uVar);
                        }
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("StateSet".equals(xmlResourceParser.getName())) {
                    return;
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
    }

    public a(int i3, e1 e1Var) {
        this.f12305a = i3;
        this.f12306b = new e1[]{e1Var};
    }
}
