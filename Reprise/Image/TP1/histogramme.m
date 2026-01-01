pkg load image

function histogramme(I1);
  I = imread(I1);
  figure;
  imshow(I);
  Ig = rgb2gray(I);
  figure;
  imshow(Ig);
  [nblig,nbcol] = size(Ig);
  nblig
  nbcol
  H = imhist(Ig);
  max(H)
  min(H)
  figure;
  bar (H);
end
