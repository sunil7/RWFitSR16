package g;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.n1;
import de.o;
import h.n;
import java.io.IOException;
import okhttp3.internal.http2.Settings;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class i extends MenuInflater {
    public static final Class[] e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f13730f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f13731a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f13732b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f13733c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13734d;

    static {
        Class[] clsArr = {Context.class};
        e = clsArr;
        f13730f = clsArr;
    }

    public i(Context context) {
        super(context);
        this.f13733c = context;
        Object[] objArr = {context};
        this.f13731a = objArr;
        this.f13732b = objArr;
    }

    public static Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public final void b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) {
        boolean z5;
        int i3;
        XmlResourceParser xmlResourceParser2;
        h hVar = new h(this, menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            z5 = true;
            i3 = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlResourceParser.next();
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z6 = false;
        boolean z8 = false;
        String str = null;
        while (!z6) {
            if (eventType == z5) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != i3) {
                if (eventType == 3) {
                    String name2 = xmlResourceParser.getName();
                    if (z8 && name2.equals(str)) {
                        xmlResourceParser2 = xmlResourceParser;
                        z8 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        hVar.f13707b = 0;
                        hVar.f13708c = 0;
                        hVar.f13709d = 0;
                        hVar.e = 0;
                        hVar.f13710f = z5;
                        hVar.f13711g = z5;
                    } else if (name2.equals("item")) {
                        if (!hVar.f13712h) {
                            l1.d dVar = hVar.f13729z;
                            if (dVar == null || !((n) dVar).f14193b.hasSubMenu()) {
                                hVar.f13712h = z5;
                                hVar.b(hVar.f13706a.add(hVar.f13707b, hVar.f13713i, hVar.f13714j, hVar.f13715k));
                            } else {
                                hVar.f13712h = z5;
                                hVar.b(hVar.f13706a.addSubMenu(hVar.f13707b, hVar.f13713i, hVar.f13714j, hVar.f13715k).getItem());
                            }
                        }
                    } else if (name2.equals("menu")) {
                        xmlResourceParser2 = xmlResourceParser;
                        z6 = z5;
                    }
                    eventType = xmlResourceParser2.next();
                    i3 = 2;
                    z8 = z8;
                }
                xmlResourceParser2 = xmlResourceParser;
                eventType = xmlResourceParser2.next();
                i3 = 2;
                z8 = z8;
            } else {
                if (!z8) {
                    String name3 = xmlResourceParser.getName();
                    boolean equals = name3.equals("group");
                    i iVar = hVar.E;
                    if (equals) {
                        TypedArray obtainStyledAttributes = iVar.f13733c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
                        hVar.f13707b = obtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
                        hVar.f13708c = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
                        hVar.f13709d = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
                        hVar.e = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
                        hVar.f13710f = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, z5);
                        hVar.f13711g = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, z5);
                        obtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals("item")) {
                            o H = o.H(iVar.f13733c, attributeSet, R$styleable.MenuItem);
                            int i10 = R$styleable.MenuItem_android_id;
                            TypedArray typedArray = (TypedArray) H.f12378c;
                            hVar.f13713i = typedArray.getResourceId(i10, 0);
                            hVar.f13714j = (typedArray.getInt(R$styleable.MenuItem_android_orderInCategory, hVar.f13709d) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) | (typedArray.getInt(R$styleable.MenuItem_android_menuCategory, hVar.f13708c) & (-65536));
                            hVar.f13715k = typedArray.getText(R$styleable.MenuItem_android_title);
                            hVar.f13716l = typedArray.getText(R$styleable.MenuItem_android_titleCondensed);
                            hVar.f13717m = typedArray.getResourceId(R$styleable.MenuItem_android_icon, 0);
                            String string = typedArray.getString(R$styleable.MenuItem_android_alphabeticShortcut);
                            hVar.f13718n = string == null ? (char) 0 : string.charAt(0);
                            hVar.f13719o = typedArray.getInt(R$styleable.MenuItem_alphabeticModifiers, 4096);
                            String string2 = typedArray.getString(R$styleable.MenuItem_android_numericShortcut);
                            hVar.f13720p = string2 == null ? (char) 0 : string2.charAt(0);
                            hVar.f13721q = typedArray.getInt(R$styleable.MenuItem_numericModifiers, 4096);
                            if (typedArray.hasValue(R$styleable.MenuItem_android_checkable)) {
                                hVar.r = typedArray.getBoolean(R$styleable.MenuItem_android_checkable, false) ? 1 : 0;
                            } else {
                                hVar.r = hVar.e;
                            }
                            hVar.f13722s = typedArray.getBoolean(R$styleable.MenuItem_android_checked, false);
                            hVar.f13723t = typedArray.getBoolean(R$styleable.MenuItem_android_visible, hVar.f13710f);
                            hVar.f13724u = typedArray.getBoolean(R$styleable.MenuItem_android_enabled, hVar.f13711g);
                            hVar.f13725v = typedArray.getInt(R$styleable.MenuItem_showAsAction, -1);
                            hVar.f13728y = typedArray.getString(R$styleable.MenuItem_android_onClick);
                            hVar.f13726w = typedArray.getResourceId(R$styleable.MenuItem_actionLayout, 0);
                            hVar.f13727x = typedArray.getString(R$styleable.MenuItem_actionViewClass);
                            String string3 = typedArray.getString(R$styleable.MenuItem_actionProviderClass);
                            boolean z10 = string3 != null ? z5 : false;
                            if (z10 && hVar.f13726w == 0 && hVar.f13727x == null) {
                                hVar.f13729z = (l1.d) hVar.a(string3, f13730f, iVar.f13732b);
                            } else {
                                if (z10) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                hVar.f13729z = null;
                            }
                            hVar.A = typedArray.getText(R$styleable.MenuItem_contentDescription);
                            hVar.B = typedArray.getText(R$styleable.MenuItem_tooltipText);
                            if (typedArray.hasValue(R$styleable.MenuItem_iconTintMode)) {
                                hVar.D = n1.c(typedArray.getInt(R$styleable.MenuItem_iconTintMode, -1), hVar.D);
                            } else {
                                hVar.D = null;
                            }
                            if (typedArray.hasValue(R$styleable.MenuItem_iconTint)) {
                                hVar.C = H.v(R$styleable.MenuItem_iconTint);
                            } else {
                                hVar.C = null;
                            }
                            H.K();
                            hVar.f13712h = false;
                            xmlResourceParser2 = xmlResourceParser;
                            z5 = true;
                        } else if (name3.equals("menu")) {
                            z5 = true;
                            hVar.f13712h = true;
                            SubMenu addSubMenu = hVar.f13706a.addSubMenu(hVar.f13707b, hVar.f13713i, hVar.f13714j, hVar.f13715k);
                            hVar.b(addSubMenu.getItem());
                            xmlResourceParser2 = xmlResourceParser;
                            b(xmlResourceParser2, attributeSet, addSubMenu);
                        } else {
                            xmlResourceParser2 = xmlResourceParser;
                            z5 = true;
                            str = name3;
                            z8 = true;
                        }
                        eventType = xmlResourceParser2.next();
                        i3 = 2;
                        z8 = z8;
                    }
                }
                xmlResourceParser2 = xmlResourceParser;
                eventType = xmlResourceParser2.next();
                i3 = 2;
                z8 = z8;
            }
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i3, Menu menu) {
        if (!(menu instanceof h.k)) {
            super.inflate(i3, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f13733c.getResources().getLayout(i3);
                    b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                    xmlResourceParser.close();
                } catch (IOException e10) {
                    throw new InflateException("Error inflating menu XML", e10);
                }
            } catch (XmlPullParserException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } catch (Throwable th2) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th2;
        }
    }
}
