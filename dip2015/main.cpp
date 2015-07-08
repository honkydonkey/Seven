#include "image.h"
#include <stdlib.h>
#include <math.h>
#include<stdio.h>

#define PI 3.1415926535

//入力画像のファイル名
const char INPUT_FILE[] = "input/input1.bmp";

int convertColor2Gray(ImageData *src, ImageData *dst);
int convertGray2Color(ImageData *src, ImageData *dst);

// ----------------------------------------------------------
//
// ----------------------------------------------------------
int main(int argc,char *argv[])
{
	//入力引数チェック
    if(argc != 2){
        printf("error\n");
        printf("正しい引数(4 or 8)を入力してください\n");
        return -1;
    }
	int renketu;
    renketu = atoi(argv[1]);

    //入力画像を用意
    ImageData *input_img;

    // ファイルより画像データの読み込み
	int res;
    res = readBMPfile(INPUT_FILE, &input_img);
    if(res<0) {
        printf("Failed load image\n");
        printf("正しいファイル名を指定してください\n");
        return -1;
    }
    
    // 面積
    int A = 0;
    // 周囲長
    int P = 0;
    // 円形度
    float enkeido = 0.0;

    
    //説明
    ////変数　renketu　で 4-連結近傍 か 8-連結近傍 か判断できます
    ////画素の値を取得するには
    //  Pixel pix;//変数の宣言
    //  getPixel(input_img, (画像のx座標), (画像のy座標), &pix);
    //  とすると　pix.pix_val　に画素値が入ります。
    //　黒：pix.pix_val = 0, 白：pix.pix_val = 255 になります。
    //
    //////////////////////////////////
    //ここから編集してください
    
    
    
    // 面積を計算（画素値が255の画素の数をカウント）
    printf("%d\n",A);
    
    
    
    
    
    // 周囲長を計算（境界画素の数をカウント）
    ////4-連結近傍　と　8-連結近傍で周囲長が異なる
    //////ヒント////////////////////////
    ////////4-連結近傍：周囲8画素の画素値を考える
    ////////8-連結近傍：周囲4画素の画素値を考える
    printf("%d\n",P);
    
    
    
    
    
    
    // 円形度を計算
    enkeido = ;
    
    
    //////////////////////////////////////////////////
    ///////ここまで
    printf("%f\n",enkeido);//結果出力
    // 解放
    disposeImage(input_img);


    return 0;
}