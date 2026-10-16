package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected HashMap<String, C0017b> f11963a = new HashMap<>();

    /* renamed from: com.tencent.open.b$b, reason: collision with other inner class name */
    public static class C0017b {
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0124, code lost:
        
            r22.a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0127, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void call(java.lang.String r20, java.util.List<java.lang.String> r21, com.tencent.open.b.a r22) {
            /*
                Method dump skipped, instructions count: 325
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.C0017b.call(java.lang.String, java.util.List, com.tencent.open.b$a):void");
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(C0017b c0017b, String str) {
        this.f11963a.put(str, c0017b);
    }

    public void a(String str, String str2, List<String> list, a aVar) {
        SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            try {
                list.set(i3, URLDecoder.decode(list.get(i3), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        C0017b c0017b = this.f11963a.get(str);
        if (c0017b != null) {
            SLog.d("openSDK_LOG.JsBridge", "call----");
            c0017b.call(str2, list, aVar);
        } else {
            SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        protected WeakReference<WebView> f11965a;

        /* renamed from: b, reason: collision with root package name */
        protected long f11966b;

        /* renamed from: c, reason: collision with root package name */
        protected String f11967c;

        public a(WebView webView, long j4, String str) {
            this.f11965a = new WeakReference<>(webView);
            this.f11966b = j4;
            this.f11967c = str;
        }

        public void a(Object obj) {
            String obj2;
            WebView webView = this.f11965a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                obj2 = "'" + ((Object) ((String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
            } else {
                obj2 = ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) ? obj.toString() : obj instanceof Boolean ? obj.toString() : "'undefined'";
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f11966b + ",{'r':0,'result':" + obj2 + "});");
        }

        public void a() {
            WebView webView = this.f11965a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f11966b + ",{'r':1,'result':'no such method'})");
        }

        public void a(String str) {
            WebView webView = this.f11965a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    public boolean a(WebView webView, String str) {
        SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(str.concat("/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        List<String> subList = arrayList.subList(4, arrayList.size() - 1);
        a aVar = new a(webView, 4L, str);
        webView.getUrl();
        a(str2, str3, subList, aVar);
        return true;
    }
}
