% Equations from paper:
% "Geocaching-inspired Navigation for Micro Aerial Vehicles with Fallible
% Place Recognition"
% authored by: Michel Barbeau, Joaquin Garcia-Alfaro and Evangelos Kranakis
% Version: June 5, 2020
% 
% 
clear;
figure;
subplot(2,2,1)
ploterror(3,5,0.5)
subplot(2,2,2)
ploterror(3,7,0.5)
subplot(2,2,3)
ploterror(5,5,0.5)
subplot(2,2,4)
ploterror(5,7,0.5)
%
function [] = ploterror(m,n,q)
    % m = number of indicators
    % n = number of MAVs
    % q = parameter of binomial distribution
	p = 0:0.05:0.5; % indicator error probability 
    % Plot error of Algorithm 1
    for i=1:length(p)
        pn(i) = error1(n,p(i))
    end
    plot(p,pn,'--');
    hold on;
    % Plot error of Algorithm 2
    for i=1:length(p)
        % majority of all indicators
        pm = error1(m,p(i))
        % majority of all MAVs
        pn(i) = error1(n,pm)
    end
    plot(p,pn,':');
    hold on;
    % Plot error of Algorithm 3
    for i=1:length(p)
        pn(i) = error1(m*n,p(i))
    end
    plot(p,pn,'-');
    hold on;
    % Plot error of Algorithm 4
    % using binomial distribution, generate the the number of vosters
    % v = binornd(n,q);
    % or fixed number of voters
    v = round(n/2);
    for i=1:length(p)
        % majority of all indicators
        pm = error1(m,p(i))
        % majority of all voter MAVs
        pn(i) = error1(v,pm)
    end
    plot(p,pn,'-.');
    hold on;
    xlabel('Indicator error probability');
    ylabel('Algorithm error probability');
    grid on;
    str = {strcat('Algorithm 4, v=' , num2str(v))}
    legend('Algorithm 1','Algorithm 2','Algorithm 3',str{:});
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
