package com.amap.api.col.p0003sl;

import com.amap.api.services.core.AMapException;

/* loaded from: classes.dex */
public class a9 extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private String f3606a;

    /* renamed from: b, reason: collision with root package name */
    private String f3607b;

    /* renamed from: c, reason: collision with root package name */
    private String f3608c;

    /* renamed from: d, reason: collision with root package name */
    private String f3609d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private int f3610f;

    /* renamed from: g, reason: collision with root package name */
    private int f3611g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f3612h;

    public a9(String str) {
        super(str);
        this.f3606a = "未知的错误";
        this.f3607b = "";
        this.f3608c = "";
        this.f3609d = "1900";
        this.e = "UnknownError";
        this.f3610f = -1;
        this.f3611g = -1;
        this.f3612h = false;
        this.f3606a = str;
        if (AMapException.AMAP_CLIENT_IO_EXCEPTION.equals(str)) {
            this.f3610f = 21;
            this.f3609d = "1902";
            this.e = "IOException";
        } else if ("socket 连接异常 - SocketException".equals(str)) {
            this.f3610f = 22;
        } else if (AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION.equals(str)) {
            this.f3610f = 23;
            this.f3609d = "1802";
            this.e = "SocketTimeoutException";
        } else if (AMapException.AMAP_CLIENT_INVALID_PARAMETER.equals(str)) {
            this.f3610f = 24;
            this.f3609d = "1901";
            this.e = "IllegalArgumentException";
        } else if (AMapException.AMAP_CLIENT_NULLPOINT_EXCEPTION.equals(str)) {
            this.f3610f = 25;
            this.f3609d = "1903";
            this.e = "NullPointException";
        } else if (AMapException.AMAP_CLIENT_URL_EXCEPTION.equals(str)) {
            this.f3610f = 26;
            this.f3609d = "1803";
            this.e = "MalformedURLException";
        } else if (AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION.equals(str)) {
            this.f3610f = 27;
            this.f3609d = "1804";
            this.e = "UnknownHostException";
        } else if ("服务器连接失败 - UnknownServiceException".equals(str)) {
            this.f3610f = 28;
            this.f3609d = "1805";
            this.e = "CannotConnectToHostException";
        } else if (AMapException.AMAP_CLIENT_ERROR_PROTOCOL.equals(str)) {
            this.f3610f = 29;
            this.f3609d = "1801";
            this.e = "ProtocolException";
        } else if ("http连接失败 - ConnectionException".equals(str)) {
            this.f3610f = 30;
            this.f3609d = "1806";
            this.e = "ConnectionException";
        } else if ("服务QPS超限".equalsIgnoreCase(str)) {
            this.f3610f = 30;
            this.f3609d = "2001";
            this.e = "ConnectionException";
        } else if ("未知的错误".equals(str)) {
            this.f3610f = 31;
        } else if ("key鉴权失败".equals(str)) {
            this.f3610f = 32;
        } else if ("限制访问的接口".equals(str)) {
            this.f3610f = 33;
        } else if ("requeust is null".equals(str)) {
            this.f3610f = 1;
        } else if ("request url is empty".equals(str)) {
            this.f3610f = 2;
        } else if ("response is null".equals(str)) {
            this.f3610f = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f3610f = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f3610f = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f3610f = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f3610f = 7;
        } else if ("线程池为空".equals(str)) {
            this.f3610f = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f3610f = 101;
        } else if ("DNS解析失败".equals(str)) {
            this.f3610f = 3;
        } else {
            this.f3610f = -1;
        }
        if (AMapException.AMAP_CLIENT_IO_EXCEPTION.equals(str)) {
            this.f3611g = 7;
            return;
        }
        if ("socket 连接异常 - SocketException".equals(str)) {
            this.f3611g = 6;
            return;
        }
        if (AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION.equals(str)) {
            this.f3611g = 2;
            return;
        }
        if (!AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION.equals(str)) {
            if ("http连接失败 - ConnectionException".equals(str)) {
                this.f3611g = 6;
                return;
            } else if (!"未知的错误".equals(str) && "DNS解析失败".equals(str)) {
                this.f3611g = 3;
                return;
            }
        }
        this.f3611g = 9;
    }

    public int a() {
        return this.f3611g;
    }

    public String b() {
        return this.f3608c;
    }

    public int c() {
        return this.f3610f;
    }

    public String d() {
        return this.f3606a;
    }

    public String e() {
        return this.f3607b;
    }

    public String f() {
        return this.f3609d;
    }

    public String g() {
        return this.e;
    }

    public boolean h() {
        return this.f3612h;
    }

    public int a(int i3) {
        this.f3611g = i3;
        return i3;
    }

    public void b(int i3) {
        this.f3610f = i3;
    }

    public void a(boolean z5) {
        this.f3612h = z5;
    }

    public a9(String str, String str2, String str3) {
        this(str);
        this.f3607b = str2;
        this.f3608c = str3;
    }
}
