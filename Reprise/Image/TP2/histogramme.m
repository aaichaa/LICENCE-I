function histogramme(nom_image)
  I=imread(nom_image);
   Ig = rgb2gray(I);

  [n,m] = size(Ig)
  n
  m
    H = imhist(Ig);
  max(H)
  min(H)
  bar(H)



end
