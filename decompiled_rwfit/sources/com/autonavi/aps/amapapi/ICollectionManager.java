package com.autonavi.aps.amapapi;

import android.os.Handler;
import com.autonavi.aps.amapapi.restruct.CgiManager;
import com.autonavi.aps.amapapi.restruct.WifiManagerWrapper;

/* loaded from: classes.dex */
public interface ICollectionManager {
    public static final ICollectionManager EMPTY = new ICollectionManager() { // from class: com.autonavi.aps.amapapi.ICollectionManager.1
        @Override // com.autonavi.aps.amapapi.ICollectionManager
        public void destroyColl() {
        }

        @Override // com.autonavi.aps.amapapi.ICollectionManager
        public void startColl(CgiManager cgiManager, WifiManagerWrapper wifiManagerWrapper, Handler handler) {
        }

        @Override // com.autonavi.aps.amapapi.ICollectionManager
        public void stopColl() {
        }

        @Override // com.autonavi.aps.amapapi.ICollectionManager
        public void updateCell() {
        }

        @Override // com.autonavi.aps.amapapi.ICollectionManager
        public void updateToServer() {
        }

        @Override // com.autonavi.aps.amapapi.ICollectionManager
        public void updateWiFi() {
        }
    };

    void destroyColl();

    void startColl(CgiManager cgiManager, WifiManagerWrapper wifiManagerWrapper, Handler handler);

    void stopColl();

    void updateCell();

    void updateToServer();

    void updateWiFi();
}
