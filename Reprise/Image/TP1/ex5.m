I = imread('peppers.png');

%imshow(I);
%figure;

[nblig, nbcol, nbcoul] = size(I);

nbpix = nblig * nbcol;

R = I(:,:,1);
V = I(:,:,2);
B = I(:,:,3);
imshow(R);
figure;
imshow(V);
figure;
imshow(B);

I2 = rgb2gray(I);

imwrite (I2, 'niveaux_de_gris.bmp');

nbpix150 = 0;
for lig = 1 : nblig
  for col = 1 : nbcol
    if I2(lig,col) == 150
      nbpix150 = nbpix150 + 1
    endif
  endfor
endfor
nbpix150;
I( 50: 59 , 50 : 59, 1 ) = 255 ;
I( 50: 59 , 50 : 59, 2 ) = 0;
I( 50: 59 , 50 : 59, 3) = 0;
figure
imshow(I);



%PAR MOI

I( 50: 59 , 50 : 59, 1 ) = 255 ;
I( 50: 59 , 50 : 59, 2 ) = 255;
I( 50: 59 , 50 : 59, 3) = 255;

%imshow(I);

x = nblig - 10+ 1-50;  % Pour que le carré soit aligné à droite
y = 1;  % Coin supérieur de l'image
I(y:y +10-1, x :x+10-1, 1 ) = 255 ;
I(y:y +10-1, x :x+10-1, 2 ) = 255;
I(y:y +10-1, x :x+10-1, 3) = 0;
%imshow(I);

y = 50;
I(y:y +10-1, x :x+10-1, 1 ) = 255 ;
I(y:y +10-1, x :x+10-1, 2 ) = 255;
I(y:y +10-1, x :x+10-1, 3) = 0;
%imshow(I);





























