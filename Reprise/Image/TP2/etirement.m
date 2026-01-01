pkg load image
function [Ietir] = etirement(I)
 valMax = max(max(I));
 valMin = min(min(I));
 Ietir =(I-valMin)/(valMax - valMin);
 figure;
 imshow(Ietir);
 end
