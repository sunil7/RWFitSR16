package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.pb;
import com.amap.api.maps.MapsInitializer;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class b4 extends pb {
    protected boolean isPostFlag = true;

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        return null;
    }

    public byte[] makeHttpRequest() throws a9 {
        qb makeHttpRequestNeedHeader = makeHttpRequestNeedHeader();
        if (makeHttpRequestNeedHeader != null) {
            return makeHttpRequestNeedHeader.f4927a;
        }
        return null;
    }

    public qb makeHttpRequestNeedHeader() throws a9 {
        if (a1.f3562f != null && k9.a(a1.f3562f, v4.b()).f4490a != k9.e.SuccessCode) {
            return null;
        }
        setHttpProtocol(MapsInitializer.getProtocol() == 1 ? pb.c.HTTP : pb.c.HTTPS);
        ob b3 = ob.b(false);
        return this.isPostFlag ? b3.a(this) : b3.e(this);
    }

    public byte[] makeHttpRequestWithInterrupted() throws a9 {
        setDegradeAbility(pb.a.INTERRUPT_IO);
        return makeHttpRequest();
    }
}
