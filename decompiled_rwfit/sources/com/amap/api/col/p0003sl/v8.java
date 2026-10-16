package com.amap.api.col.p0003sl;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;

/* loaded from: classes.dex */
public class v8 {
    public static void a(int i3, String str) throws s8 {
        if (i3 != 0) {
            switch (i3) {
                case 10000:
                    return;
                case 10001:
                    throw new s8(s8.f5014c);
                case 10002:
                    throw new s8(s8.f5015d);
                case GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR /* 10003 */:
                    throw new s8(s8.e);
                case 10004:
                    throw new s8(s8.f5016f);
                case 10005:
                    throw new s8(s8.f5017g);
                case 10006:
                    throw new s8(s8.f5018h);
                case 10007:
                    throw new s8(s8.f5013b);
                case 10008:
                    throw new s8(s8.f5019i);
                case 10009:
                    throw new s8(s8.f5020j);
                case 10010:
                    throw new s8(s8.f5021k);
                case 10011:
                    throw new s8(s8.f5022l);
                case 10012:
                    throw new s8(s8.f5023m);
                case 10013:
                    throw new s8(s8.f5024n);
                default:
                    switch (i3) {
                        case Const.I_CITY_TILE_LEN /* 20000 */:
                            throw new s8(s8.f5028s);
                        case 20001:
                            throw new s8(s8.f5029t);
                        case 20002:
                            throw new s8(s8.f5030u);
                        case 20003:
                            throw new s8(s8.f5031v);
                        default:
                            switch (i3) {
                                case Const.I_LOC_JUMP_DELAY /* 30000 */:
                                    throw new s8(s8.f5025o);
                                case 30001:
                                    throw new s8(s8.f5026p);
                                case 30002:
                                    throw new s8(s8.f5027q);
                                case 30003:
                                    throw new s8(s8.r);
                                default:
                                    throw new s8(str);
                            }
                    }
            }
        }
    }
}
