pkg load image

I = imread('image4.jpg');
figure;
imshow(I);
Ig = rgb2gray(I);
Ig = double(Ig)/255;
etirement(Ig);
Ieg = histeq(Ig);
figure;
imshow(Ieg);


