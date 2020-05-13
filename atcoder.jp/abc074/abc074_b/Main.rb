N = gets.to_i
K = gets.to_i
x = gets.split.map(&:to_i)

sum = 0
N.times do |i|
  sum += [x[i]*2,(K-x[i]).abs*2].min
end
puts sum