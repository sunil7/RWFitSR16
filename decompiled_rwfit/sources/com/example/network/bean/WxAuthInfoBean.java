package com.example.network.bean;

/* loaded from: classes.dex */
public class WxAuthInfoBean {
    private AuthInfo result;

    public static class AuthInfo {
        private String access_token;
        private String openid;
        private String refresh_token;
        private String scope;

        public String getAccess_token() {
            return this.access_token;
        }

        public String getOpenid() {
            return this.openid;
        }

        public String getRefresh_token() {
            return this.refresh_token;
        }

        public String getScope() {
            return this.scope;
        }

        public void setAccess_token(String str) {
            this.access_token = str;
        }

        public void setOpenid(String str) {
            this.openid = str;
        }

        public void setRefresh_token(String str) {
            this.refresh_token = str;
        }

        public void setScope(String str) {
            this.scope = str;
        }
    }

    public AuthInfo getResult() {
        return this.result;
    }

    public void setResult(AuthInfo authInfo) {
        this.result = authInfo;
    }

    public String toString() {
        return "WxAuthInfoBean{result=" + this.result + '}';
    }
}
