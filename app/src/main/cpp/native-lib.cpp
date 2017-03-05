#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_jangsir_godutch_GoDutch_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "  ";
    return env->NewStringUTF(hello.c_str());
}
