% Equations from paper:
% "Geocaching-inspired Navigation for Micro Aerial Vehicles with Fallible
% Place Recognition"
% authored by: Michel Barbeau, Joaquin Garcia-Alfaro and Evangelos Kranakis
% Version: June 10, 2020
% 
% 


function cprint(m)
fprintf('{');
for i=1:size(m,2)
  for j=1:size(m,3)
    fprintf('%f',m(1,i,j));
    if j<size(m,2)
      %fprintf('\t');
    end
  end
  fprintf(',');
end
fprintf('}\n');
end
