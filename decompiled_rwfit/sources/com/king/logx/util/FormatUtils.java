package com.king.logx.util;

import com.king.logx.LogX;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import kotlin.jvm.internal.e;
import kotlin.text.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class FormatUtils {
    private static final int DEFAULT_INDENT_SPACES = 4;
    public static final FormatUtils INSTANCE = new FormatUtils();
    private static final String JSON_ARRAY_PREFIX = "[";
    private static final String JSON_OBJECT_PREFIX = "{";
    private static final String XSLT_INDENT_AMOUNT = "{http://xml.apache.org/xslt}indent-amount";
    private static final String YES = "yes";

    private FormatUtils() {
    }

    public static final String formatJson(String json) {
        e.f(json, "json");
        return formatJson$default(json, 0, 2, null);
    }

    public static /* synthetic */ String formatJson$default(String str, int i3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i3 = 4;
        }
        return formatJson(str, i3);
    }

    public static final String formatXml(String xml) {
        e.f(xml, "xml");
        return formatXml$default(xml, 0, 2, null);
    }

    public static /* synthetic */ String formatXml$default(String str, int i3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i3 = 4;
        }
        return formatXml(str, i3);
    }

    public static final String formatJson(String json, int i3) {
        String jSONArray;
        e.f(json, "json");
        try {
            String obj = m.B(json).toString();
            if (m.x(obj, "{", false)) {
                jSONArray = new JSONObject(obj).toString(i3);
            } else {
                if (!m.x(obj, JSON_ARRAY_PREFIX, false)) {
                    throw new JSONException("Invalid Json.");
                }
                jSONArray = new JSONArray(obj).toString(i3);
            }
            e.e(jSONArray, "json.trim().let {\n      …          }\n            }");
            return jSONArray;
        } catch (JSONException e) {
            LogX.Companion.w(e);
            return json;
        }
    }

    public static final String formatXml(String xml, int i3) {
        e.f(xml, "xml");
        try {
            StringWriter stringWriter = new StringWriter();
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", YES);
            newTransformer.setOutputProperty("indent", YES);
            newTransformer.setOutputProperty(XSLT_INDENT_AMOUNT, String.valueOf(i3));
            newTransformer.transform(new StreamSource(new StringReader(xml)), new StreamResult(stringWriter));
            String stringWriter2 = stringWriter.toString();
            e.e(stringWriter2, "stringWriter.toString()");
            return stringWriter2;
        } catch (TransformerException e) {
            LogX.Companion.w(e, "Invalid xml.", new Object[0]);
            return xml;
        }
    }
}
