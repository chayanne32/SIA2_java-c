#include <stdio.h>
#include <conio.h>
#include <jni.h>
#include <string.h>

JNIEnv* callFunc(JavaVM ** );

int main(){
	
	printf("Hello World");
	
	getch();
	return 0;
}

JNIEnv* create_vm(JavaVM ** jvm)
{
	JNIEnv *env;
    JavaVMInitArgs vm_args;

    JavaVMOption options; 
    //Path to the java source code     
    options.optionString = "-Djava.class.path=C:\\Users\\wabzs\\Desktop\\Projects and apps\\CS & IT\\IT 3203\\SIA2_java-c\\readDB\\src"; 
    vm_args.version = JNI_VERSION_1_8; //JDK version. This indicates version 1.6
    vm_args.nOptions = 1;
    vm_args.options = &options;
    vm_args.ignoreUnrecognized = 0;
    
    int ret = JNI_CreateJavaVM(jvm, (void**)&env, &vm_args);
    if(ret < 0)
        printf("\nUnable to Launch JVM\n");       
    return env;
}
	

