#include <jni.h>
#include <stdio.h>
#include "sia2_readdb_readDB.h"

JNIEXPORT void JNICALL Java_sia2_1readdb_readDB_cgetData(JNIEnv *env, jobject obj, jobjectArray stringArrays)
{
	int size = (*env)->GetArrayLength(env, stringArrays);
	int i;
	printf("C receives:");
	
	for (i=0; i < size; ++i) 
	{
	    jstring string = (*env)->GetObjectArrayElement(env, stringArrays, i);
	    const char* myarray = (*env)->GetStringUTFChars(env, string, 0);

	    printf("%s\n", myarray);
	    (*env)->ReleaseStringUTFChars(env, string, myarray);
	    (*env)->DeleteLocalRef(env, string);
	}
}


