package com.ccsi;

public class Main {

    public static void main(String[] args){
	// write your code here
    }
    //The API: int read4(char *buf) reads 4 characters at a time from a file.
    //The return value is the actual number of characters read.For example,it returns 3 if
    //there is only 3 characters left in the file.
    //By using the read4 API, implement the function int read(char *buf,int n) that reads
    //n characters from the file.
    public static int read1(char[] buf,int n){
        int count=-1,r=0;
        do{
            char[] temp=new char[4];
            r=read4(temp);
            int len=r<n?r:n;                  //这步没什么用吧？！ len要么是4，要么是n%4。
            for (int i = 0; i < len; i++) {   //直接用r替换len
                buf[++count]=temp[i];
            }
            n-=r;
        }while(n>0&&r==4);
        return count;
    }
    public static int read2(char[] buf,int n){
        int count=-1,r=0;
        do{
            char[] temp=new char[4];
            r=read4(temp);
            for (int i = 0; i < r; i++) {
                buf[++count]=temp[i];
            }
            n-=r;
        }while(n>0&&r==4);
        return count;
    }
    public static int read3(char[] buf,int n){
        int count=-1,r=0;
        for (int i = 0; i < n; i+=4) {
            char[] temp=new char[4];
            r=read4(temp);
            if(r==0)break;      //有可能正好是4的整数倍
            for (int j = 0; j < r; j++) {
                buf[++count]=temp[j];
            }
        }
        return count;
    }
}
