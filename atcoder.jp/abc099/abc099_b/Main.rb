a,b = gets.split.map(&:to_i)
sum = 0
(1...(b-a)).to_a.map{|n| sum += n}
puts sum-a