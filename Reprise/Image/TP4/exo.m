pkg load image

I=imread('image.PNG');
figure; %1 im originale
imshow(I);
% Création et affichage de l'élément structurant disque (rayon 15, angle 0)
D = strel('square', 5);
%figure;
%imshow(getnhood(D));  % Affiche la forme du disque
Ie = imerode(I,D);
%figure; %2 erosion
%imshow(Ie);

Id = imdilate(I,D);
%figure; %3 dilatation
%imshow(Id);

Ied = imdilate(Ie,D);
%figure; %4 ouverture
%imshow(Ied);


Ide = imerode(Id,D);
%figure; %5fermeture
%imshow(Ide);


Ig = rgb2gray(I);
%figure;
%imshow(Ig);
bw=im2bw(Ig);
%figure;
%imshow(bw);
I4 = medfilt2(bw,[3,3]);
%figure;
%imshow(I4);
Ie = imerode(bw,D);
figure; %2 erosion
imshow(Ie);
Id = imdilate(bw,D);
figure; %3 dilatation
imshow(Id);

Ied = imdilate(Ie,D);
figure; %4 ouverture
imshow(Ied);


Ide = imerode(Id,D);
figure; %5fermeture
imshow(Ide);



%I1 = double(I3)/255;

%I4 = medfilt2(I1,[3,3]);
%figure;

%imshow(I4);




