% Equations from paper:
% "Geocaching-inspired Navigation for Micro Aerial Vehicles with Fallible
% Place Recognition"
% authored by: Michel Barbeau, Joaquin Garcia-Alfaro and Evangelos Kranakis
% Version: June 10, 2020
% 
% 

m=7;
log2java(90,m,0.5)


% subplot(3,3,1)
% ploterror(10,m,0.5)
% subplot(3,3,2)
% ploterror(20,m,0.5)
% subplot(3,3,3)
% ploterror(30,m,0.5)
% subplot(3,3,4)
% ploterror(40,m,0.5)
% subplot(3,3,5)
% ploterror(50,m,0.5)
% subplot(3,3,6)
% ploterror(60,m,0.5)
% subplot(3,3,7)
% ploterror(70,m,0.5)
% subplot(3,3,8)
% ploterror(80,m,0.5)
% subplot(3,3,9)
% ploterror(90,m,0.5)
%
function [] = ploterror(n,m,q)
    % n = number of MAVs
    % q = parameter of binomial distribution
	p = 0:0.05:0.5; % indicator error probability
    % Plot error of Algorithm 3
    for i=1:length(p)
        pn(i) = error1(m*n,p(i))
    end
    plot(p,pn,'--');
    xlabel('Indicator error probability');
    ylabel('Algorithm error probability');
    grid on;
    legend('Algorithm 3');
    str = {strcat('Error Propabilities,',' m=' ,num2str(m),' n=' , num2str(n))}
    title(str{:});
end
%
% Error function
%
function e = error1(n,p)
% n = number of MAVS, indicators or their product
% p = error probability of indicator
    s = 0;
    for l=ceil(n/2):n
        s = s + nchoosek(n,l)*power(1-p,l)*power(p,n-l);
    end
    e = 1-s;
end

%
% log2java
%
function [] = log2java(n,m,q)
    % n = number of MAVs
    % q = parameter of binomial distribution
	p = 0:0.05:0.5; % indicator error probability
    % Plot error of Algorithm 3
    for i=1:length(p)
        pn(i) = error1(m*n,p(i));
    end
    fprintf('Algorithm 3, n=%d\n',n);
    cprint(pn);
end

