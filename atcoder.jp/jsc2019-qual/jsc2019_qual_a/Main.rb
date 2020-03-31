M, D = gets.split.map(&:to_i)
cnt = 0
(1..M).each do |m|
    (1..D).each do |d|
        d1 = d % 10
        d10 = d / 10
        cnt += 1 if d1>=2 && d10>=2 && d1*d10==m
    end
end
puts cnt
