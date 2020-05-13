N = gets.to_i
L = Hash.new do |h, i|
    h[i] = h[i-1] + h[i-2]
end
L[0] = 2
L[1] = 1
puts L[N]
