pkg load image
I = imread('house_gaus.bmp');
figure;
imshow(I);
I1 = double(I)/255;
f1 = ones(3,3)/9;
I1M1 = medfilt2(I1,[3,3]);
figure;
imshow(I1M1);
I1F1 = filter2(f1, I1);
figure;
imshow(I1F1);

Im = imread('house_sap.bmp');
figure;
imshow(Im);
I0 = double(Im)/255;
f1 = ones(3,3)/9;
IM2 = medfilt2(I0,[3,3]);
figure;
imshow(IM2);
IF2 = filter2(f1, I0);
figure;
imshow(IF2);


