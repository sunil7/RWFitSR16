package com.tencent.connect.common;

import android.content.Intent;
import android.support.v4.media.session.e;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UIListenerManager {

    /* renamed from: a, reason: collision with root package name */
    private static UIListenerManager f11842a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, ApiTask> f11843b;

    public class ApiTask {
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(int i3, IUiListener iUiListener) {
            this.mRequestCode = i3;
            this.mListener = iUiListener;
        }
    }

    private UIListenerManager() {
        Map<String, ApiTask> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.f11843b = synchronizedMap;
        if (synchronizedMap == null) {
            this.f11843b = Collections.synchronizedMap(new HashMap());
        }
    }

    private IUiListener a(int i3, IUiListener iUiListener) {
        if (i3 == 11101) {
            SLog.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
            return iUiListener;
        }
        if (i3 == 11105) {
            SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
            return iUiListener;
        }
        if (i3 == 11106) {
            SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        }
        return iUiListener;
    }

    public static UIListenerManager getInstance() {
        if (f11842a == null) {
            f11842a = new UIListenerManager();
        }
        return f11842a;
    }

    public IUiListener getListnerWithAction(String str) {
        ApiTask apiTask;
        if (str == null) {
            SLog.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        synchronized (this.f11843b) {
            apiTask = this.f11843b.get(str);
            this.f11843b.remove(str);
        }
        if (apiTask == null) {
            return null;
        }
        return apiTask.mListener;
    }

    public IUiListener getListnerWithRequestCode(int i3) {
        String a3 = k.a(i3);
        if (a3 != null) {
            return getListnerWithAction(a3);
        }
        SLog.e("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + i3);
        return null;
    }

    public void handleDataToListener(Intent intent, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.UIListenerManager", "handleDataToListener");
        if (intent == null) {
            iUiListener.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
        if (!"action_login".equals(stringExtra)) {
            if ("action_share".equals(stringExtra)) {
                String stringExtra2 = intent.getStringExtra("result");
                String stringExtra3 = intent.getStringExtra("response");
                if ("cancel".equals(stringExtra2)) {
                    iUiListener.onCancel();
                    return;
                }
                if ("error".equals(stringExtra2)) {
                    iUiListener.onError(new UiError(-6, "unknown error", e.l(stringExtra3, "")));
                    return;
                }
                if ("complete".equals(stringExtra2)) {
                    try {
                        iUiListener.onComplete(new JSONObject(stringExtra3 == null ? "{\"ret\": 0}" : stringExtra3));
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        iUiListener.onError(new UiError(-4, "json error", e.l(stringExtra3, "")));
                        return;
                    }
                }
                return;
            }
            return;
        }
        int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
        if (intExtra != 0) {
            SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
            l0.A(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL), iUiListener);
            return;
        }
        String stringExtra4 = intent.getStringExtra(Constants.KEY_RESPONSE);
        if (stringExtra4 == null) {
            SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
            iUiListener.onComplete(new JSONObject());
            return;
        }
        try {
            iUiListener.onComplete(m.d(stringExtra4));
        } catch (JSONException e10) {
            l0.A(-4, Constants.MSG_JSON_ERROR, stringExtra4, iUiListener);
            SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e10);
        }
    }

    public boolean onActivityResult(int i3, int i10, Intent intent, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.UIListenerManager", "onActivityResult req=" + i3 + " res=" + i10);
        IUiListener listnerWithRequestCode = getListnerWithRequestCode(i3);
        if (listnerWithRequestCode == null) {
            if (iUiListener == null) {
                SLog.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
                return false;
            }
            listnerWithRequestCode = a(i3, iUiListener);
        }
        if (i10 != -1) {
            listnerWithRequestCode.onCancel();
            return true;
        }
        if (intent == null) {
            l0.A(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null.", listnerWithRequestCode);
            return true;
        }
        String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
            if (intExtra != 0) {
                SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                l0.A(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL), listnerWithRequestCode);
                return true;
            }
            String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
            if (stringExtra2 == null) {
                SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                listnerWithRequestCode.onComplete(new JSONObject());
                return true;
            }
            try {
                listnerWithRequestCode.onComplete(m.d(stringExtra2));
                return true;
            } catch (JSONException e) {
                l0.A(-4, Constants.MSG_JSON_ERROR, stringExtra2, listnerWithRequestCode);
                SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                return true;
            }
        }
        if ("action_share".equals(stringExtra) || "action_request_avatar".equals(stringExtra) || "action_request_dynamic_avatar".equals(stringExtra) || "action_request_set_emotion".equals(stringExtra) || "guildOpen".equals(stringExtra)) {
            String stringExtra3 = intent.getStringExtra("result");
            String stringExtra4 = intent.getStringExtra("response");
            if ("cancel".equals(stringExtra3)) {
                listnerWithRequestCode.onCancel();
                return true;
            }
            if ("error".equals(stringExtra3)) {
                listnerWithRequestCode.onError(new UiError(-6, "unknown error", e.l(stringExtra4, "")));
                return true;
            }
            if (!"complete".equals(stringExtra3)) {
                return true;
            }
            try {
                listnerWithRequestCode.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                return true;
            } catch (JSONException e10) {
                SLog.e("openSDK_LOG.UIListenerManager", "JSONException", e10);
                listnerWithRequestCode.onError(new UiError(-4, "json error", e.l(stringExtra4, "")));
                return true;
            }
        }
        if (!"action_common_channel".equals(stringExtra)) {
            int intExtra2 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
            if (intExtra2 != 0) {
                l0.A(intExtra2, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL), listnerWithRequestCode);
                return true;
            }
            String stringExtra5 = intent.getStringExtra(Constants.KEY_RESPONSE);
            if (stringExtra5 == null) {
                listnerWithRequestCode.onComplete(new JSONObject());
                return true;
            }
            try {
                listnerWithRequestCode.onComplete(m.d(stringExtra5));
                return true;
            } catch (JSONException unused) {
                l0.A(-4, Constants.MSG_JSON_ERROR, stringExtra5, listnerWithRequestCode);
                return true;
            }
        }
        int intExtra3 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
        if (intExtra3 != 0) {
            l0.A(intExtra3, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL), listnerWithRequestCode);
            return true;
        }
        String stringExtra6 = intent.getStringExtra("response");
        if (stringExtra6 == null) {
            listnerWithRequestCode.onComplete(new JSONObject());
            return true;
        }
        try {
            String stringExtra7 = intent.getStringExtra("message");
            JSONObject d5 = m.d(stringExtra6);
            d5.put("message", stringExtra7);
            listnerWithRequestCode.onComplete(d5);
            return true;
        } catch (JSONException unused2) {
            l0.A(-4, Constants.MSG_JSON_ERROR, stringExtra6, listnerWithRequestCode);
            return true;
        }
    }

    public Object setListenerWithRequestcode(int i3, IUiListener iUiListener) {
        ApiTask put;
        String a3 = k.a(i3);
        if (a3 == null) {
            SLog.e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + i3);
            return null;
        }
        synchronized (this.f11843b) {
            put = this.f11843b.put(a3, new ApiTask(i3, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }

    public Object setListnerWithAction(String str, IUiListener iUiListener) {
        ApiTask put;
        int b3 = k.b(str);
        if (b3 == -1) {
            SLog.e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + str);
            return null;
        }
        synchronized (this.f11843b) {
            put = this.f11843b.put(str, new ApiTask(b3, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }
}
