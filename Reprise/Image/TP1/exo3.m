R = [0.5 0 1 ; 0 1 0 ;1 0 0.5];
V = [0.5 0.6 0 ; 0.6 0 0.6 ; 0 0.6 0.5];
B = [0.5 1 0 ; 1 0 1 ; 0 1 0.5];
Icoul(:,:,1) = R;
Icoul(:,:,2) = V;
Icoul(:,:,3)= B;
imshow(Icoul);
imwrite(Icoul, 'im_coul1.bmp');
