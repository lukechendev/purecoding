# This is the Android.mk file used to prebuild the app apk into AOSP
# 1) Copy the file along with the MyDice.apk file to be under "packages/apps/Car/MyDice/"
# 2) Edit "packages/services/Car/car_product/build/car.mk" and add:
# PRODUCT_PACKAGES += MyDice

LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
# Module name should match apk name to be installed (without the .apk extension)
LOCAL_MODULE := MyDice
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(LOCAL_MODULE).apk
LOCAL_MODULE_CLASS := APPS
LOCAL_MODULE_SUFFIX := $(COMMON_ANDROID_PACKAGE_SUFFIX)
LOCAL_CERTIFICATE := platform
LOCAL_PREVILEGED_MODULE := true
LOCAL_DEX_PREOPT := false
# The priv-app folder
TARGET_OUT_DATA_APPS_PRIVILEGED := $(TARGET_OUT_DATA)/priv-app
include $(BUILD_PREBUILT)
