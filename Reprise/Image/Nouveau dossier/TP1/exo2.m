I = imread('blobs.png');

figure;
imshow(I);
img = I(1:10, 1:10);
figure;
imshow(img);
 [ligne,colonne]=size(I) ;
image = I(1:10, colonne - 9 : colonne);
figure;
imshow(image);


