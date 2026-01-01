pkg load image
I = imread('house.jpg');
figure;
imshow(I);
I1 = double(I)/255;
%figure;
%imshow(I1);

I2 = imnoise(I,'salt & pepper');
%figure;
%imshow(I2);

I3 = imnoise(I,'gaussian', 1,1);
%figure;
imshow(I3);
