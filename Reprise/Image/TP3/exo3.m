I1 = imread('frog.jpeg');
%figure;
%imshow(I1);
S = [-1,0,1;-2,0,2;-1,0,1]
L = [0,1,0;1,-4,1;0,1,0]
R = [1,1,1;0,0,0;-1,-1,-1]

Ig = rgb2gray(I1);
I = double(Ig)/255;
figure;
imshow(Ig)

F1 = filter2(S,I);
%figure;
%imshow(F1);
F2 = filter2(L,I);
%figure;
%imshow(F2);
F3 = filter2(R,I);
figure;
imshow(F3);

Kx = (1/9)*[-3,-3,5;-3,0,5;-3,-3,5]
Ky = [-3,-3,-3;-3,0,-3;5,5,5]

I2 = filter2(Kx,I);
%figure;
%imshow(I2);
I3 = filter2(Ky,I);
%figure;
%imshow(I3);

I4 = sqrt(I3*I3+I4*I4);
%figure;
%imshow(I4);
clear





