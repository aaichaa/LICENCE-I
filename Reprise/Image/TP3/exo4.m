pkg load image
I = imread('image_bin.bmp');
figure;
imshow(I);

S = [1 1 1 ; 1 0 0 ; 1 1 0; 1 0 0 ; 1 1 1];

Ie = imerode(I,S);
figure;
imshow(Ie);

H = [1 0 1 ; 1 0 1 ; 1 1 1; 1 0 1 ; 1 0 1];


Ied = imdilate(Ie,H);
figure;
imshow(Ied);
