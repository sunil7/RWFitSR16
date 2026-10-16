package com.tencent.open.a;

import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private int f11942a = 15000;

    /* renamed from: b, reason: collision with root package name */
    private int f11943b = Const.I_LOC_JUMP_DELAY;

    /* renamed from: c, reason: collision with root package name */
    private final String f11944c;

    public b(String str) {
        this.f11944c = str;
    }

    private static void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.open.a.a
    public void a(long j4, long j10) {
        if (j4 <= 0 || j10 <= 0) {
            return;
        }
        this.f11942a = (int) j4;
        this.f11943b = (int) j10;
    }

    @Override // com.tencent.open.a.a
    public g a(String str, String str2) throws IOException {
        SLog.i("DefaultHttpServiceImpl", "get. ");
        if (!TextUtils.isEmpty(str2)) {
            int indexOf = str2.indexOf("?");
            if (indexOf == -1) {
                str = android.support.v4.media.session.e.l(str, "?");
            } else if (indexOf != str.length() - 1) {
                str = str.concat(Const.STR_MART_ADD);
            }
            str = android.support.v4.media.session.e.l(str, str2);
        }
        return a(str, str2.length());
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map) throws IOException {
        SLog.i("DefaultHttpServiceImpl", "post. ");
        StringBuilder sb2 = new StringBuilder();
        boolean z5 = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z5) {
                z5 = false;
            } else {
                sb2.append('&');
            }
            sb2.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            sb2.append('=');
            sb2.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        String sb3 = sb2.toString();
        return a(str, sb3.length(), sb3);
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() > 0) {
            Iterator<Map.Entry<String, byte[]>> it = map2.entrySet().iterator();
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<String, byte[]> next = it.next();
            return a(str, map, next.getKey(), next.getValue());
        }
        return a(str, map);
    }

    private void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f11944c);
        httpURLConnection.setConnectTimeout(this.f11942a);
        httpURLConnection.setReadTimeout(this.f11943b);
        httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
    }

    private g a(String str, int i3) throws IOException {
        Throwable th2;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        c cVar;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod(Constants.HTTP_GET);
                a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr, 0, read);
                            }
                            cVar = new c(httpURLConnection, byteArrayOutputStream2.toString(), httpURLConnection.getContentLength(), i3, httpURLConnection.getResponseCode(), "");
                            a(byteArrayOutputStream2);
                            a(inputStream);
                        } catch (Throwable th3) {
                            th2 = th3;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            a(byteArrayOutputStream);
                            a(inputStream);
                            b(httpURLConnection);
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                    }
                } else {
                    String responseMessage = httpURLConnection.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "请求失败 code:" + httpURLConnection.getResponseCode();
                    }
                    cVar = new c(httpURLConnection, "", httpURLConnection.getContentLength(), i3, httpURLConnection.getResponseCode(), responseMessage);
                    a((Closeable) null);
                    a((Closeable) null);
                }
                b(httpURLConnection);
                return cVar;
            } catch (Throwable th5) {
                th2 = th5;
                inputStream = null;
            }
        } catch (Throwable th6) {
            th2 = th6;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    private g a(String str, int i3, String str2) throws IOException {
        Throwable th2;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        c cVar;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod(Constants.HTTP_POST);
                a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                outputStreamWriter.write(str2);
                outputStreamWriter.flush();
                httpURLConnection.connect();
                int contentLength = httpURLConnection.getContentLength();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr, 0, read);
                            }
                            cVar = new c(httpURLConnection, byteArrayOutputStream2.toString(), contentLength, i3, httpURLConnection.getResponseCode(), "");
                            a(byteArrayOutputStream2);
                            a(inputStream);
                        } catch (Throwable th3) {
                            th2 = th3;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            a(byteArrayOutputStream);
                            a(inputStream);
                            b(httpURLConnection);
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                    }
                } else {
                    String responseMessage = httpURLConnection.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "Unknown fail: " + httpURLConnection.getResponseCode();
                    }
                    cVar = new c(httpURLConnection, "", 0, i3, httpURLConnection.getResponseCode(), responseMessage);
                    a((Closeable) null);
                    a((Closeable) null);
                }
                b(httpURLConnection);
                return cVar;
            } catch (Throwable th5) {
                th2 = th5;
                inputStream = null;
            }
        } catch (Throwable th6) {
            th2 = th6;
            inputStream = null;
            httpURLConnection = null;
        }
    }

    public g a(String str, Map<String, String> map, String str2, byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        DataOutputStream dataOutputStream2;
        int i3;
        String str3;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        Map<String, String> map2 = map;
        SLog.i("DefaultHttpServiceImpl", "文件上传");
        String uuid = UUID.randomUUID().toString();
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod(Constants.HTTP_POST);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
                try {
                    a(httpURLConnection);
                    httpURLConnection.connect();
                    dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                    if (map2 != null) {
                        try {
                            if (map2.size() > 0) {
                                Iterator<String> it = map2.keySet().iterator();
                                while (it.hasNext()) {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    String encode = URLEncoder.encode(it.next(), "UTF-8");
                                    String encode2 = URLEncoder.encode(map2.get(encode), "UTF-8");
                                    stringBuffer.append("--");
                                    stringBuffer.append(uuid);
                                    stringBuffer.append("\r\n");
                                    stringBuffer.append("Content-Disposition: form-data; name=\"");
                                    stringBuffer.append(encode);
                                    stringBuffer.append("\"");
                                    stringBuffer.append("\r\n");
                                    stringBuffer.append("\r\n");
                                    stringBuffer.append(encode2);
                                    stringBuffer.append("\r\n");
                                    String stringBuffer2 = stringBuffer.toString();
                                    SLog.i("DefaultHttpServiceImpl", encode + "=" + stringBuffer2 + "##");
                                    dataOutputStream2.write(stringBuffer2.getBytes());
                                    map2 = map;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            dataOutputStream = dataOutputStream2;
                            byteArrayOutputStream = null;
                            inputStream = null;
                            a(dataOutputStream);
                            a(inputStream);
                            a(byteArrayOutputStream);
                            b(httpURLConnection);
                            throw th;
                        }
                    }
                    if (bArr == null || bArr.length <= 0) {
                        i3 = 0;
                    } else {
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append("--");
                        stringBuffer3.append(uuid);
                        stringBuffer3.append("\r\n");
                        stringBuffer3.append("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str2 + "\"\r\n");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Content-Type: application/octet-stream; charset=UTF-8");
                        sb2.append("\r\n");
                        stringBuffer3.append(sb2.toString());
                        stringBuffer3.append("\r\n");
                        dataOutputStream2.write(stringBuffer3.toString().getBytes());
                        dataOutputStream2.write(bArr, 0, bArr.length);
                        dataOutputStream2.write("\r\n".getBytes());
                        byte[] bytes = ("--" + uuid + "--\r\n").getBytes();
                        dataOutputStream2.write(bytes);
                        int length = bytes.length;
                        dataOutputStream2.flush();
                        i3 = length;
                    }
                    try {
                        int responseCode = httpURLConnection.getResponseCode();
                        SLog.i("DefaultHttpServiceImpl", responseCode + "");
                        if (responseCode == 200) {
                            InputStream inputStream3 = httpURLConnection.getInputStream();
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr2 = new byte[1024];
                                    while (true) {
                                        int read = inputStream3.read(bArr2);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr2, 0, read);
                                    }
                                    str3 = byteArrayOutputStream.toString();
                                    inputStream2 = inputStream3;
                                    byteArrayOutputStream2 = byteArrayOutputStream;
                                } catch (Throwable th3) {
                                    th = th3;
                                    inputStream = inputStream3;
                                    dataOutputStream = dataOutputStream2;
                                    a(dataOutputStream);
                                    a(inputStream);
                                    a(byteArrayOutputStream);
                                    b(httpURLConnection);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream = inputStream3;
                                dataOutputStream = dataOutputStream2;
                                byteArrayOutputStream = null;
                            }
                        } else {
                            str3 = httpURLConnection.getResponseCode() + "";
                            inputStream2 = null;
                            byteArrayOutputStream2 = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        dataOutputStream = dataOutputStream2;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        a(dataOutputStream);
                        a(inputStream);
                        a(byteArrayOutputStream);
                        b(httpURLConnection);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = null;
                    dataOutputStream = null;
                    inputStream = null;
                    a(dataOutputStream);
                    a(inputStream);
                    a(byteArrayOutputStream);
                    b(httpURLConnection);
                    throw th;
                }
                try {
                    c cVar = new c(httpURLConnection, str3, httpURLConnection.getContentLength(), i3, httpURLConnection.getResponseCode(), "");
                    a(dataOutputStream2);
                    a(inputStream2);
                    a(byteArrayOutputStream2);
                    b(httpURLConnection);
                    return cVar;
                } catch (Throwable th7) {
                    th = th7;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream2;
                    dataOutputStream = dataOutputStream2;
                    a(dataOutputStream);
                    a(inputStream);
                    a(byteArrayOutputStream);
                    b(httpURLConnection);
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (Throwable th9) {
            th = th9;
            byteArrayOutputStream = null;
            dataOutputStream = null;
            httpURLConnection = null;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
