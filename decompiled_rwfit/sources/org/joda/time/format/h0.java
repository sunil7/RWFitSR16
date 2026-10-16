package org.joda.time.format;

import com.amap.api.maps.utils.SpatialRelationUtil;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.open.log.TraceLevel;

/* loaded from: classes2.dex */
public final class h0 extends e0 {

    /* renamed from: b, reason: collision with root package name */
    public final String f17188b;

    public h0(String str) {
        this.f17188b = str;
    }

    @Override // org.joda.time.format.e0
    public final int a(int i3) {
        return this.f17188b.length();
    }

    @Override // org.joda.time.format.e0
    public final String[] b() {
        return new String[]{this.f17188b};
    }

    @Override // org.joda.time.format.e0
    public final int d(int i3, String str) {
        String str2 = this.f17188b;
        int length = str2.length();
        return (!str.regionMatches(true, i3, str2, 0, length) || c(length, i3, str)) ? ~i3 : i3 + length;
    }

    @Override // org.joda.time.format.e0
    public final void e(StringBuffer stringBuffer, int i3) {
        stringBuffer.append(this.f17188b);
    }

    @Override // org.joda.time.format.e0
    public final int f(int i3, String str) {
        String str2 = this.f17188b;
        int length = str2.length();
        int length2 = str.length();
        int i10 = i3;
        while (i10 < length2) {
            String str3 = str;
            if (str3.regionMatches(true, i10, str2, 0, length) && !c(length, i10, str3)) {
                return i10;
            }
            switch (str3.charAt(i10)) {
                case '+':
                case ',':
                case WXMediaMessage.IMediaObject.TYPE_BUSINESS_CARD /* 45 */:
                case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /* 46 */:
                case TraceLevel.ABOVE_WARN /* 48 */:
                case '1':
                case SpatialRelationUtil.MIN_OFFSET_DEGREE /* 50 */:
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i10++;
                    str = str3;
            }
            return ~i3;
        }
        return ~i3;
    }
}
