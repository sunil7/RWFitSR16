package u0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;
import com.google.android.gms.internal.mlkit_vision_common.g0;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public int f18811a;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public final g f18815f;

    /* renamed from: g, reason: collision with root package name */
    public final w0.j f18816g;

    /* renamed from: j, reason: collision with root package name */
    public int f18819j;

    /* renamed from: k, reason: collision with root package name */
    public String f18820k;

    /* renamed from: o, reason: collision with root package name */
    public final Context f18824o;

    /* renamed from: b, reason: collision with root package name */
    public int f18812b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18813c = false;

    /* renamed from: d, reason: collision with root package name */
    public int f18814d = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f18817h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f18818i = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f18821l = 0;

    /* renamed from: m, reason: collision with root package name */
    public String f18822m = null;

    /* renamed from: n, reason: collision with root package name */
    public int f18823n = -1;

    /* renamed from: p, reason: collision with root package name */
    public int f18825p = -1;

    /* renamed from: q, reason: collision with root package name */
    public int f18826q = -1;
    public int r = -1;

    /* renamed from: s, reason: collision with root package name */
    public int f18827s = -1;

    /* renamed from: t, reason: collision with root package name */
    public int f18828t = -1;

    /* renamed from: u, reason: collision with root package name */
    public int f18829u = -1;

    public z(Context context, XmlResourceParser xmlResourceParser) {
        char c9;
        this.f18824o = context;
        try {
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlResourceParser.getName();
                    switch (name.hashCode()) {
                        case -1962203927:
                            if (name.equals("ConstraintOverride")) {
                                c9 = 2;
                                break;
                            }
                            c9 = 65535;
                            break;
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                c9 = 1;
                                break;
                            }
                            c9 = 65535;
                            break;
                        case 61998586:
                            if (name.equals("ViewTransition")) {
                                c9 = 0;
                                break;
                            }
                            c9 = 65535;
                            break;
                        case 366511058:
                            if (name.equals("CustomMethod")) {
                                c9 = 4;
                                break;
                            }
                            c9 = 65535;
                            break;
                        case 1791837707:
                            if (name.equals("CustomAttribute")) {
                                c9 = 3;
                                break;
                            }
                            c9 = 65535;
                            break;
                        default:
                            c9 = 65535;
                            break;
                    }
                    if (c9 == 0) {
                        b(context, xmlResourceParser);
                    } else if (c9 == 1) {
                        this.f18815f = new g(context, xmlResourceParser);
                    } else if (c9 == 2) {
                        this.f18816g = w0.o.d(context, xmlResourceParser);
                    } else if (c9 == 3 || c9 == 4) {
                        w0.b.e(context, xmlResourceParser, this.f18816g.f19365g);
                    } else {
                        String a3 = g0.a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(a3).length() + 13 + name.length());
                        sb2.append(a3);
                        sb2.append(" unknown tag ");
                        sb2.append(name);
                        Log.e("ViewTransition", sb2.toString());
                        int lineNumber = xmlResourceParser.getLineNumber();
                        StringBuilder sb3 = new StringBuilder(16);
                        sb3.append(".xml:");
                        sb3.append(lineNumber);
                        Log.e("ViewTransition", sb3.toString());
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("ViewTransition".equals(xmlResourceParser.getName())) {
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

    public final boolean a(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if (this.f18819j == -1 && this.f18820k == null) {
            return false;
        }
        int i3 = this.r;
        boolean z5 = i3 == -1 || view.getTag(i3) != null;
        int i10 = this.f18827s;
        boolean z6 = i10 == -1 || view.getTag(i10) == null;
        if (z5 && z6) {
            if (view.getId() == this.f18819j) {
                return true;
            }
            if (this.f18820k != null && (view.getLayoutParams() instanceof w0.e) && (str = ((w0.e) view.getLayoutParams()).X) != null && str.matches(this.f18820k)) {
                return true;
            }
        }
        return false;
    }

    public final void b(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.ViewTransition_android_id) {
                this.f18811a = obtainStyledAttributes.getResourceId(index, this.f18811a);
            } else if (index == R$styleable.ViewTransition_motionTarget) {
                if (MotionLayout.f1692q1) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.f18819j);
                    this.f18819j = resourceId;
                    if (resourceId == -1) {
                        this.f18820k = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.f18820k = obtainStyledAttributes.getString(index);
                } else {
                    this.f18819j = obtainStyledAttributes.getResourceId(index, this.f18819j);
                }
            } else if (index == R$styleable.ViewTransition_onStateTransition) {
                this.f18812b = obtainStyledAttributes.getInt(index, this.f18812b);
            } else if (index == R$styleable.ViewTransition_transitionDisable) {
                this.f18813c = obtainStyledAttributes.getBoolean(index, this.f18813c);
            } else if (index == R$styleable.ViewTransition_pathMotionArc) {
                this.f18814d = obtainStyledAttributes.getInt(index, this.f18814d);
            } else if (index == R$styleable.ViewTransition_duration) {
                this.f18817h = obtainStyledAttributes.getInt(index, this.f18817h);
            } else if (index == R$styleable.ViewTransition_upDuration) {
                this.f18818i = obtainStyledAttributes.getInt(index, this.f18818i);
            } else if (index == R$styleable.ViewTransition_viewTransitionMode) {
                this.e = obtainStyledAttributes.getInt(index, this.e);
            } else if (index == R$styleable.ViewTransition_motionInterpolator) {
                int i10 = obtainStyledAttributes.peekValue(index).type;
                if (i10 == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.f18823n = resourceId2;
                    if (resourceId2 != -1) {
                        this.f18821l = -2;
                    }
                } else if (i10 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f18822m = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.f18821l = -1;
                    } else {
                        this.f18823n = obtainStyledAttributes.getResourceId(index, -1);
                        this.f18821l = -2;
                    }
                } else {
                    this.f18821l = obtainStyledAttributes.getInteger(index, this.f18821l);
                }
            } else if (index == R$styleable.ViewTransition_setsTag) {
                this.f18825p = obtainStyledAttributes.getResourceId(index, this.f18825p);
            } else if (index == R$styleable.ViewTransition_clearsTag) {
                this.f18826q = obtainStyledAttributes.getResourceId(index, this.f18826q);
            } else if (index == R$styleable.ViewTransition_ifTagSet) {
                this.r = obtainStyledAttributes.getResourceId(index, this.r);
            } else if (index == R$styleable.ViewTransition_ifTagNotSet) {
                this.f18827s = obtainStyledAttributes.getResourceId(index, this.f18827s);
            } else if (index == R$styleable.ViewTransition_SharedValueId) {
                this.f18829u = obtainStyledAttributes.getResourceId(index, this.f18829u);
            } else if (index == R$styleable.ViewTransition_SharedValue) {
                this.f18828t = obtainStyledAttributes.getInteger(index, this.f18828t);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final String toString() {
        String c9 = g0.c(this.f18824o, this.f18811a);
        return r5.a.b(r5.a.a(16, c9), "ViewTransition(", c9, ")");
    }
}
