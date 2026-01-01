pkg load image
% Lecture et affichage de l'image "circles.png"
I = imread('circles.png');
figure;
imshow(I);  % Affiche l'image

% Création et affichage de l'élément structurant carré (13x13)
C = strel('square', 13);
%figure;
%imshow(getnhood(C));  % Affiche la forme du carré

% Création et affichage de l'élément structurant disque (rayon 15, angle 0)
D = strel('disk', 15, 0);
%figure;
%imshow(getnhood(D));  % Affiche la forme du disque

% Création et affichage de l'élément structurant ligne (longueur 10, angle 45)
L = strel('line', 10, 45);
%figure;
%imshow(getnhood(L));  % Affiche la forme de la ligne

% Création et affichage de l'élément structurant rectangle (taille 5x15)
R = strel('rectangle', [5, 15]);
%figure;
%Himshow(getnhood(R));  % Affiche la forme du rectangle

Ie = imerode(I,R);
figure;
imshow(Ie);

Ied = imerode(Ie,R);
figure;
imshow(Ied);









