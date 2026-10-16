package u0;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f18684b;

    /* renamed from: a, reason: collision with root package name */
    public HashMap f18685a = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        f18684b = hashMap;
        try {
            hashMap.put("KeyAttribute", e.class.getConstructor(null));
            hashMap.put("KeyPosition", i.class.getConstructor(null));
            hashMap.put("KeyCycle", f.class.getConstructor(null));
            hashMap.put("KeyTimeCycle", j.class.getConstructor(null));
            hashMap.put("KeyTrigger", k.class.getConstructor(null));
        } catch (NoSuchMethodException e) {
            Log.e("KeyFrames", "unable to load", e);
        }
    }

    public g(Context context, XmlResourceParser xmlResourceParser) {
        Exception e;
        c cVar;
        Constructor constructor;
        HashMap hashMap;
        HashMap hashMap2;
        try {
            int eventType = xmlResourceParser.getEventType();
            c cVar2 = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlResourceParser.getName();
                    HashMap hashMap3 = f18684b;
                    if (hashMap3.containsKey(name)) {
                        try {
                            constructor = (Constructor) hashMap3.get(name);
                        } catch (Exception e10) {
                            c cVar3 = cVar2;
                            e = e10;
                            cVar = cVar3;
                        }
                        if (constructor == null) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 23);
                            sb2.append("Keymaker for ");
                            sb2.append(name);
                            sb2.append(" not found");
                            throw new NullPointerException(sb2.toString());
                        }
                        cVar = (c) constructor.newInstance(null);
                        try {
                            cVar.d(context, Xml.asAttributeSet(xmlResourceParser));
                            b(cVar);
                        } catch (Exception e11) {
                            e = e11;
                            Log.e("KeyFrames", "unable to create ", e);
                            cVar2 = cVar;
                            eventType = xmlResourceParser.next();
                        }
                        cVar2 = cVar;
                    } else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (cVar2 != null && (hashMap2 = cVar2.f18669d) != null) {
                            w0.b.e(context, xmlResourceParser, hashMap2);
                        }
                    } else if (name.equalsIgnoreCase("CustomMethod") && cVar2 != null && (hashMap = cVar2.f18669d) != null) {
                        w0.b.e(context, xmlResourceParser, hashMap);
                    }
                } else if (eventType == 3 && "KeyFrameSet".equals(xmlResourceParser.getName())) {
                    return;
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException e12) {
            e12.printStackTrace();
        } catch (XmlPullParserException e13) {
            e13.printStackTrace();
        }
    }

    public final void a(n nVar) {
        Integer valueOf = Integer.valueOf(nVar.f18715c);
        HashMap hashMap = this.f18685a;
        ArrayList arrayList = (ArrayList) hashMap.get(valueOf);
        if (arrayList != null) {
            nVar.f18733w.addAll(arrayList);
        }
        ArrayList arrayList2 = (ArrayList) hashMap.get(-1);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                c cVar = (c) obj;
                String str = ((w0.e) nVar.f18714b.getLayoutParams()).X;
                String str2 = cVar.f18668c;
                if ((str2 == null || str == null) ? false : str.matches(str2)) {
                    nVar.a(cVar);
                }
            }
        }
    }

    public final void b(c cVar) {
        Integer valueOf = Integer.valueOf(cVar.f18667b);
        HashMap hashMap = this.f18685a;
        if (!hashMap.containsKey(valueOf)) {
            hashMap.put(Integer.valueOf(cVar.f18667b), new ArrayList());
        }
        ArrayList arrayList = (ArrayList) hashMap.get(Integer.valueOf(cVar.f18667b));
        if (arrayList != null) {
            arrayList.add(cVar);
        }
    }
}
