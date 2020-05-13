H, W = gets.split(' ').map(&:to_i)
c = []
10.times do |i|
  c << gets.split(' ').map(&:to_i)
end
A = []
H.times do |h|
  A << gets.split(' ').map(&:to_i)
end

10.times do |k|
  10.times do |i|
    10.times do |j|
      c[i][j] = [c[i][j], c[i][k] + c[k][j]].min
    end
  end
end

sum = 0
A.flatten.delete_if{|n| n < 0}.map{|n|c[n][1]}.each{|n| sum += n}
puts sum



