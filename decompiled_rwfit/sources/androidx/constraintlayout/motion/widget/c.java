package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.camera.core.impl.e;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import com.google.android.gms.internal.mlkit_vision_common.g0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
import u0.a0;
import u0.g;
import u0.m;
import u0.n;
import u0.t;
import u0.w;
import u0.x;
import u0.z;
import w0.j;
import w0.k;
import w0.l;
import w0.o;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final MotionLayout f1732a;

    /* renamed from: b, reason: collision with root package name */
    public final d6.a f1733b;

    /* renamed from: c, reason: collision with root package name */
    public x f1734c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1735d;
    public final x e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f1736f;

    /* renamed from: g, reason: collision with root package name */
    public final SparseArray f1737g;

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f1738h;

    /* renamed from: i, reason: collision with root package name */
    public final SparseIntArray f1739i;

    /* renamed from: j, reason: collision with root package name */
    public int f1740j;

    /* renamed from: k, reason: collision with root package name */
    public int f1741k;

    /* renamed from: l, reason: collision with root package name */
    public MotionEvent f1742l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1743m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1744n;

    /* renamed from: o, reason: collision with root package name */
    public t f1745o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1746p;

    /* renamed from: q, reason: collision with root package name */
    public final e f1747q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public float f1748s;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public c(Context context, MotionLayout motionLayout, int i3) {
        int eventType;
        x xVar;
        this.f1733b = null;
        this.f1734c = null;
        ArrayList arrayList = new ArrayList();
        this.f1735d = arrayList;
        this.e = null;
        this.f1736f = new ArrayList();
        this.f1737g = new SparseArray();
        this.f1738h = new HashMap();
        this.f1739i = new SparseIntArray();
        this.f1740j = 400;
        this.f1741k = 0;
        this.f1743m = false;
        this.f1744n = false;
        this.f1732a = motionLayout;
        this.f1747q = new e(motionLayout);
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            eventType = xml.getEventType();
            xVar = null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
        while (true) {
            char c9 = 1;
            if (eventType == 1) {
                this.f1737g.put(R$id.motion_base, new o());
                this.f1738h.put("motion_base", Integer.valueOf(R$id.motion_base));
                return;
            }
            if (eventType == 0) {
                xml.getName();
            } else if (eventType == 2) {
                String name = xml.getName();
                switch (name.hashCode()) {
                    case -1349929691:
                        if (name.equals("ConstraintSet")) {
                            c9 = 5;
                            break;
                        }
                        c9 = 65535;
                        break;
                    case -1239391468:
                        if (name.equals("KeyFrameSet")) {
                            c9 = '\b';
                            break;
                        }
                        c9 = 65535;
                        break;
                    case -687739768:
                        if (name.equals("Include")) {
                            c9 = 7;
                            break;
                        }
                        c9 = 65535;
                        break;
                    case 61998586:
                        if (name.equals("ViewTransition")) {
                            c9 = '\t';
                            break;
                        }
                        c9 = 65535;
                        break;
                    case 269306229:
                        if (name.equals("Transition")) {
                            break;
                        }
                        c9 = 65535;
                        break;
                    case 312750793:
                        if (name.equals("OnClick")) {
                            c9 = 3;
                            break;
                        }
                        c9 = 65535;
                        break;
                    case 327855227:
                        if (name.equals("OnSwipe")) {
                            c9 = 2;
                            break;
                        }
                        c9 = 65535;
                        break;
                    case 793277014:
                        if (name.equals("MotionScene")) {
                            c9 = 0;
                            break;
                        }
                        c9 = 65535;
                        break;
                    case 1382829617:
                        if (name.equals("StateSet")) {
                            c9 = 4;
                            break;
                        }
                        c9 = 65535;
                        break;
                    case 1942574248:
                        if (name.equals("include")) {
                            c9 = 6;
                            break;
                        }
                        c9 = 65535;
                        break;
                    default:
                        c9 = 65535;
                        break;
                }
                switch (c9) {
                    case 0:
                        l(context, xml);
                        break;
                    case 1:
                        xVar = new x(this, context, xml);
                        arrayList.add(xVar);
                        if (this.f1734c == null && !xVar.f18784b) {
                            this.f1734c = xVar;
                            d dVar = xVar.f18793l;
                            if (dVar != null) {
                                dVar.c(this.f1746p);
                            }
                        }
                        if (!xVar.f18784b) {
                            break;
                        } else {
                            if (xVar.f18785c == -1) {
                                this.e = xVar;
                            } else {
                                this.f1736f.add(xVar);
                            }
                            arrayList.remove(xVar);
                            break;
                        }
                        break;
                    case 2:
                        if (xVar == null) {
                            String resourceEntryName = context.getResources().getResourceEntryName(i3);
                            int lineNumber = xml.getLineNumber();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(resourceEntryName).length() + 27);
                            sb2.append(" OnSwipe (");
                            sb2.append(resourceEntryName);
                            sb2.append(".xml:");
                            sb2.append(lineNumber);
                            sb2.append(")");
                            Log.v("MotionScene", sb2.toString());
                        }
                        if (xVar == null) {
                            break;
                        } else {
                            xVar.f18793l = new d(context, this.f1732a, xml);
                            break;
                        }
                    case 3:
                        if (xVar == null) {
                            break;
                        } else {
                            xVar.f18794m.add(new w(context, xVar, xml));
                            break;
                        }
                    case 4:
                        this.f1733b = new d6.a(context, xml);
                        break;
                    case 5:
                        i(context, xml);
                        break;
                    case 6:
                    case 7:
                        k(context, xml);
                        break;
                    case '\b':
                        g gVar = new g(context, xml);
                        if (xVar == null) {
                            break;
                        } else {
                            xVar.f18792k.add(gVar);
                            break;
                        }
                    case '\t':
                        z zVar = new z(context, xml);
                        e eVar = this.f1747q;
                        ((ArrayList) eVar.f1379d).add(zVar);
                        eVar.e = null;
                        int i10 = zVar.f18812b;
                        if (i10 != 4) {
                            if (i10 != 5) {
                                break;
                            } else {
                                ConstraintLayout.getSharedValues().a(zVar.f18829u, new a0());
                                break;
                            }
                        } else {
                            ConstraintLayout.getSharedValues().a(zVar.f18829u, new a0());
                            break;
                        }
                }
            }
            eventType = xml.next();
        }
    }

    public final boolean a(int i3, MotionLayout motionLayout) {
        x xVar;
        if (this.f1745o == null) {
            ArrayList arrayList = this.f1735d;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                x xVar2 = (x) obj;
                int i11 = xVar2.f18795n;
                if (i11 != 0 && ((xVar = this.f1734c) != xVar2 || (xVar.r & 2) == 0)) {
                    if (i3 == xVar2.f18786d && (i11 == 4 || i11 == 2)) {
                        MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                        motionLayout.setState(transitionState);
                        motionLayout.setTransition(xVar2);
                        if (xVar2.f18795n == 4) {
                            motionLayout.q(1.0f);
                            motionLayout.f1705g1 = null;
                            motionLayout.setState(MotionLayout.TransitionState.SETUP);
                            motionLayout.setState(MotionLayout.TransitionState.MOVING);
                            return true;
                        }
                        motionLayout.setProgress(1.0f);
                        motionLayout.s(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.z();
                        return true;
                    }
                    if (i3 == xVar2.f18785c && (i11 == 3 || i11 == 1)) {
                        MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                        motionLayout.setState(transitionState2);
                        motionLayout.setTransition(xVar2);
                        if (xVar2.f18795n == 3) {
                            motionLayout.q(0.0f);
                            motionLayout.setState(MotionLayout.TransitionState.SETUP);
                            motionLayout.setState(MotionLayout.TransitionState.MOVING);
                            return true;
                        }
                        motionLayout.setProgress(0.0f);
                        motionLayout.s(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.z();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final o b(int i3) {
        int a3;
        SparseArray sparseArray = this.f1737g;
        d6.a aVar = this.f1733b;
        if (aVar != null && (a3 = aVar.a(i3)) != -1) {
            i3 = a3;
        }
        if (sparseArray.get(i3) != null) {
            return (o) sparseArray.get(i3);
        }
        String c9 = g0.c(this.f1732a.getContext(), i3);
        StringBuilder sb2 = new StringBuilder(r5.a.a(55, c9));
        sb2.append("Warning could not find ConstraintSet id/");
        sb2.append(c9);
        sb2.append(" In MotionScene");
        Log.e("MotionScene", sb2.toString());
        return (o) sparseArray.get(sparseArray.keyAt(0));
    }

    public final int c() {
        x xVar = this.f1734c;
        return xVar != null ? xVar.f18789h : this.f1740j;
    }

    public final int d(Context context, String str) {
        int i3;
        if (str.contains("/")) {
            i3 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
        } else {
            i3 = -1;
        }
        if (i3 == -1) {
            if (str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e("MotionScene", "error in parsing id");
        }
        return i3;
    }

    public final Interpolator e() {
        x xVar = this.f1734c;
        int i3 = xVar.e;
        if (i3 == -2) {
            return AnimationUtils.loadInterpolator(this.f1732a.getContext(), this.f1734c.f18788g);
        }
        if (i3 == -1) {
            return new m(p0.e.d(xVar.f18787f), 1);
        }
        if (i3 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i3 == 1) {
            return new AccelerateInterpolator();
        }
        if (i3 == 2) {
            return new DecelerateInterpolator();
        }
        if (i3 == 4) {
            return new BounceInterpolator();
        }
        if (i3 == 5) {
            return new OvershootInterpolator();
        }
        if (i3 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public final void f(n nVar) {
        x xVar = this.f1734c;
        int i3 = 0;
        if (xVar != null) {
            ArrayList arrayList = xVar.f18792k;
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((g) obj).a(nVar);
            }
            return;
        }
        x xVar2 = this.e;
        if (xVar2 != null) {
            ArrayList arrayList2 = xVar2.f18792k;
            int size2 = arrayList2.size();
            while (i3 < size2) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                ((g) obj2).a(nVar);
            }
        }
    }

    public final float g() {
        d dVar;
        x xVar = this.f1734c;
        if (xVar == null || (dVar = xVar.f18793l) == null) {
            return 0.0f;
        }
        return dVar.f1766t;
    }

    public final int h() {
        x xVar = this.f1734c;
        if (xVar == null) {
            return -1;
        }
        return xVar.f18786d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int i(Context context, XmlResourceParser xmlResourceParser) {
        char c9;
        char c10;
        o oVar = new o();
        oVar.e = false;
        int attributeCount = xmlResourceParser.getAttributeCount();
        int i3 = -1;
        int i10 = -1;
        for (int i11 = 0; i11 < attributeCount; i11++) {
            String attributeName = xmlResourceParser.getAttributeName(i11);
            String attributeValue = xmlResourceParser.getAttributeValue(i11);
            attributeName.getClass();
            switch (attributeName.hashCode()) {
                case -1496482599:
                    if (attributeName.equals("deriveConstraintsFrom")) {
                        c9 = 0;
                        break;
                    }
                    c9 = 65535;
                    break;
                case -1153153640:
                    if (attributeName.equals("constraintRotate")) {
                        c9 = 1;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c9 = 2;
                        break;
                    }
                    c9 = 65535;
                    break;
                default:
                    c9 = 65535;
                    break;
            }
            switch (c9) {
                case 0:
                    i10 = d(context, attributeValue);
                    break;
                case 1:
                    try {
                        oVar.f19442c = Integer.parseInt(attributeValue);
                        break;
                    } catch (NumberFormatException unused) {
                        attributeValue.getClass();
                        switch (attributeValue.hashCode()) {
                            case -768416914:
                                if (attributeValue.equals("x_left")) {
                                    c10 = 0;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 3317767:
                                if (attributeValue.equals("left")) {
                                    c10 = 1;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 3387192:
                                if (attributeValue.equals("none")) {
                                    c10 = 2;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 108511772:
                                if (attributeValue.equals("right")) {
                                    c10 = 3;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 1954540437:
                                if (attributeValue.equals("x_right")) {
                                    c10 = 4;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            default:
                                c10 = 65535;
                                break;
                        }
                        switch (c10) {
                            case 0:
                                oVar.f19442c = 4;
                                break;
                            case 1:
                                oVar.f19442c = 2;
                                break;
                            case 2:
                                oVar.f19442c = 0;
                                break;
                            case 3:
                                oVar.f19442c = 1;
                                break;
                            case 4:
                                oVar.f19442c = 3;
                                break;
                        }
                    }
                    break;
                case 2:
                    i3 = d(context, attributeValue);
                    int indexOf = attributeValue.indexOf(47);
                    if (indexOf >= 0) {
                        attributeValue = attributeValue.substring(indexOf + 1);
                    }
                    this.f1738h.put(attributeValue, Integer.valueOf(i3));
                    oVar.f19440a = g0.c(context, i3);
                    break;
            }
        }
        if (i3 != -1) {
            int i12 = this.f1732a.M;
            oVar.k(context, xmlResourceParser);
            if (i10 != -1) {
                this.f1739i.put(i3, i10);
            }
            this.f1737g.put(i3, oVar);
        }
        return i3;
    }

    public final int j(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return i(context, xml);
                }
            }
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public final void k(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.include_constraintSet) {
                j(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void l(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.MotionScene_defaultDuration) {
                int i10 = obtainStyledAttributes.getInt(index, this.f1740j);
                this.f1740j = i10;
                if (i10 < 8) {
                    this.f1740j = 8;
                }
            } else if (index == R$styleable.MotionScene_layoutDuringTransition) {
                this.f1741k = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void m(int i3, MotionLayout motionLayout) {
        SparseArray sparseArray = this.f1737g;
        o oVar = (o) sparseArray.get(i3);
        oVar.f19441b = oVar.f19440a;
        int i10 = this.f1739i.get(i3);
        HashMap hashMap = oVar.f19444f;
        if (i10 > 0) {
            m(i10, motionLayout);
            o oVar2 = (o) sparseArray.get(i10);
            if (oVar2 == null) {
                String valueOf = String.valueOf(g0.c(this.f1732a.getContext(), i10));
                Log.e("MotionScene", valueOf.length() != 0 ? "ERROR! invalid deriveConstraintsFrom: @id/".concat(valueOf) : new String("ERROR! invalid deriveConstraintsFrom: @id/"));
                return;
            }
            String valueOf2 = String.valueOf(oVar.f19441b);
            String str = oVar2.f19441b;
            oVar.f19441b = r5.a.b(r5.a.a(valueOf2.length() + 1, str), valueOf2, "/", str);
            HashMap hashMap2 = oVar2.f19444f;
            for (Integer num : hashMap2.keySet()) {
                num.getClass();
                j jVar = (j) hashMap2.get(num);
                if (!hashMap.containsKey(num)) {
                    hashMap.put(num, new j());
                }
                j jVar2 = (j) hashMap.get(num);
                if (jVar2 != null) {
                    k kVar = jVar2.e;
                    if (!kVar.f19370b) {
                        kVar.a(jVar.e);
                    }
                    w0.m mVar = jVar2.f19362c;
                    if (!mVar.f19419a) {
                        w0.m mVar2 = jVar.f19362c;
                        mVar.f19419a = mVar2.f19419a;
                        mVar.f19420b = mVar2.f19420b;
                        mVar.f19422d = mVar2.f19422d;
                        mVar.e = mVar2.e;
                        mVar.f19421c = mVar2.f19421c;
                    }
                    w0.n nVar = jVar2.f19364f;
                    if (!nVar.f19424a) {
                        nVar.a(jVar.f19364f);
                    }
                    l lVar = jVar2.f19363d;
                    if (!lVar.f19407a) {
                        lVar.a(jVar.f19363d);
                    }
                    for (String str2 : jVar.f19365g.keySet()) {
                        if (!jVar2.f19365g.containsKey(str2)) {
                            jVar2.f19365g.put(str2, (w0.b) jVar.f19365g.get(str2));
                        }
                    }
                }
            }
        } else {
            oVar.f19441b = String.valueOf(oVar.f19441b).concat("  layout");
            int childCount = motionLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = motionLayout.getChildAt(i11);
                w0.e eVar = (w0.e) childAt.getLayoutParams();
                int id2 = childAt.getId();
                if (oVar.e && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (!hashMap.containsKey(Integer.valueOf(id2))) {
                    hashMap.put(Integer.valueOf(id2), new j());
                }
                j jVar3 = (j) hashMap.get(Integer.valueOf(id2));
                if (jVar3 != null) {
                    k kVar2 = jVar3.e;
                    if (!kVar2.f19370b) {
                        jVar3.c(id2, eVar);
                        if (childAt instanceof ConstraintHelper) {
                            kVar2.i0 = ((ConstraintHelper) childAt).getReferencedIds();
                            if (childAt instanceof Barrier) {
                                Barrier barrier = (Barrier) childAt;
                                kVar2.f19393n0 = barrier.getAllowsGoneWidget();
                                kVar2.f19378f0 = barrier.getType();
                                kVar2.f19380g0 = barrier.getMargin();
                            }
                        }
                        kVar2.f19370b = true;
                    }
                    w0.m mVar3 = jVar3.f19362c;
                    if (!mVar3.f19419a) {
                        mVar3.f19420b = childAt.getVisibility();
                        mVar3.f19422d = childAt.getAlpha();
                        mVar3.f19419a = true;
                    }
                    w0.n nVar2 = jVar3.f19364f;
                    if (!nVar2.f19424a) {
                        nVar2.f19424a = true;
                        nVar2.f19425b = childAt.getRotation();
                        nVar2.f19426c = childAt.getRotationX();
                        nVar2.f19427d = childAt.getRotationY();
                        nVar2.e = childAt.getScaleX();
                        nVar2.f19428f = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (pivotX != 0.0d || pivotY != 0.0d) {
                            nVar2.f19429g = pivotX;
                            nVar2.f19430h = pivotY;
                        }
                        nVar2.f19432j = childAt.getTranslationX();
                        nVar2.f19433k = childAt.getTranslationY();
                        nVar2.f19434l = childAt.getTranslationZ();
                        if (nVar2.f19435m) {
                            nVar2.f19436n = childAt.getElevation();
                        }
                    }
                }
            }
        }
        for (j jVar4 : hashMap.values()) {
            if (jVar4.f19366h != null) {
                if (jVar4.f19361b != null) {
                    Iterator it = hashMap.keySet().iterator();
                    while (it.hasNext()) {
                        j i12 = oVar.i(((Integer) it.next()).intValue());
                        String str3 = i12.e.f19387k0;
                        if (str3 != null && jVar4.f19361b.matches(str3)) {
                            jVar4.f19366h.e(i12);
                            i12.f19365g.putAll((HashMap) jVar4.f19365g.clone());
                        }
                    }
                } else {
                    jVar4.f19366h.e(oVar.i(jVar4.f19360a));
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r2 != (-1)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(int r11, int r12) {
        /*
            r10 = this;
            d6.a r0 = r10.f1733b
            r1 = -1
            if (r0 == 0) goto L18
            int r0 = r0.a(r11)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r11
        Ld:
            d6.a r2 = r10.f1733b
            int r2 = r2.a(r12)
            if (r2 == r1) goto L16
            goto L1a
        L16:
            r2 = r12
            goto L1a
        L18:
            r0 = r11
            goto L16
        L1a:
            u0.x r3 = r10.f1734c
            if (r3 == 0) goto L27
            int r4 = r3.f18785c
            if (r4 != r12) goto L27
            int r3 = r3.f18786d
            if (r3 != r11) goto L27
            goto L52
        L27:
            java.util.ArrayList r3 = r10.f1735d
            int r4 = r3.size()
            r5 = 0
            r6 = r5
        L2f:
            if (r6 >= r4) goto L53
            java.lang.Object r7 = r3.get(r6)
            int r6 = r6 + 1
            u0.x r7 = (u0.x) r7
            int r8 = r7.f18785c
            if (r8 != r2) goto L41
            int r9 = r7.f18786d
            if (r9 == r0) goto L47
        L41:
            if (r8 != r12) goto L2f
            int r8 = r7.f18786d
            if (r8 != r11) goto L2f
        L47:
            r10.f1734c = r7
            androidx.constraintlayout.motion.widget.d r11 = r7.f18793l
            if (r11 == 0) goto L52
            boolean r12 = r10.f1746p
            r11.c(r12)
        L52:
            return
        L53:
            u0.x r11 = r10.e
            java.util.ArrayList r4 = r10.f1736f
            int r6 = r4.size()
        L5b:
            if (r5 >= r6) goto L6b
            java.lang.Object r7 = r4.get(r5)
            int r5 = r5 + 1
            u0.x r7 = (u0.x) r7
            int r8 = r7.f18785c
            if (r8 != r12) goto L5b
            r11 = r7
            goto L5b
        L6b:
            u0.x r12 = new u0.x
            r12.<init>(r10, r11)
            r12.f18786d = r0
            r12.f18785c = r2
            if (r0 == r1) goto L79
            r3.add(r12)
        L79:
            r10.f1734c = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.c.n(int, int):void");
    }

    public final boolean o() {
        ArrayList arrayList = this.f1735d;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            if (((x) obj).f18793l != null) {
                return true;
            }
        }
        x xVar = this.f1734c;
        return (xVar == null || xVar.f18793l == null) ? false : true;
    }
}
