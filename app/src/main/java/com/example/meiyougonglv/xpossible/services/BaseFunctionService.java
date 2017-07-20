package com.example.meiyougonglv.xpossible.services;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import com.example.meiyougonglv.xpossible.R;

/**
 * Created by meiyougonglv on 17-7-20.
 */

public class BaseFunctionService extends AccessibilityService{

    private static final String TAG = "BaseFunctionService";

    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"service onCreate !");
    }

    private void setServiceInfo(int feedbackType) {
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        // We are interested in all types of accessibility events.
        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        // We want to provide specific type of feedback.
        info.feedbackType = feedbackType;
        // We want to receive events in a certain interval.
        info.notificationTimeout = EVENT_NOTIFICATION_TIMEOUT_MILLIS;
        // We want to receive accessibility events only from certain packages.
        info.packageNames = PACKAGE_NAMES;
        setServiceInfo(info);
    }

    public  void onAccessibilityEvent(AccessibilityEvent var1){

    }

    public  void onInterrupt(){

    }

    /**
     * 前往设置界面开启服务
     */
    private void startAccessibilityService() {
        new AlertDialog.Builder(this)
                .setTitle("开启辅助功能")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("使用此项功能需要您开启辅助功能")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 隐式调用系统设置界面
                        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                        startActivity(intent);
                    }
                }).create().show();
    }

//    public abstract static class GestureResultCallback {
//        public GestureResultCallback() {
//            throw new RuntimeException("Stub!");
//        }
//
//        public void onCompleted(GestureDescription gestureDescription) {
//            throw new RuntimeException("Stub!");
//        }
//
//        public void onCancelled(GestureDescription gestureDescription) {
//            throw new RuntimeException("Stub!");
//        }
//    }
//
//    public static final class SoftKeyboardController {
//        SoftKeyboardController() {
//            throw new RuntimeException("Stub!");
//        }
//
//        public void addOnShowModeChangedListener(AccessibilityService.SoftKeyboardController.OnShowModeChangedListener listener) {
//            throw new RuntimeException("Stub!");
//        }
//
//        public void addOnShowModeChangedListener(AccessibilityService.SoftKeyboardController.OnShowModeChangedListener listener, Handler handler) {
//            throw new RuntimeException("Stub!");
//        }
//
//        public boolean removeOnShowModeChangedListener(AccessibilityService.SoftKeyboardController.OnShowModeChangedListener listener) {
//            throw new RuntimeException("Stub!");
//        }
//
//        public int getShowMode() {
//            throw new RuntimeException("Stub!");
//        }
//
//        public boolean setShowMode(int showMode) {
//            throw new RuntimeException("Stub!");
//        }
//
//        public interface OnShowModeChangedListener {
//            void onShowModeChanged(AccessibilityService.SoftKeyboardController var1, int var2);
//        }
//    }
}
