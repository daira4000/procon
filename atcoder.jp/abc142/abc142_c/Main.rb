N = gets.to_i
A = gets.split(' ').map(&:to_i)
B = []
(1..N).each{|i| B << [i, A[i-1]]}
B.sort!{|a,b| a[1] - b[1]}
puts B.map{|o|o[0]}.join ' '

