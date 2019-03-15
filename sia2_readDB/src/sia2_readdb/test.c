#include <jni.h>
#include <stdio.h>
#include "sia2_readdb_test_class.h"

JNIEXPORT jstring JNICALL Java_sia2_1readdb_test_1class_sayHello(JNIEnv *env, jobject thisobj, jstring str)
{
	const char *cStr = (*env)->GetStringUTFChars(env, str, NULL);
   	if (NULL == cStr){
	  return NULL; 
	} 
 	
   printf("In C, the received string is: %s\n", cStr);
   (*env)->ReleaseStringUTFChars(env, str, cStr); 
   
	char outCStr[128];
   printf("Enter a String: ");
   scanf("%s", outCStr); 
   
   return (*env)->NewStringUTF(env, outCStr);
}


